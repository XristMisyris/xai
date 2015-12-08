package org.teipir.softeng.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import org.teipir.softeng.controllers.AnakoinwseisController;
import org.teipir.softeng.models.Anakoinwsi;
import java.awt.Font;
import javax.swing.JSeparator;

public class AnakoinwseisFrame extends JFrame{
	
	private JFrame frame = this;
	
	public AnakoinwseisFrame() {
		super("Ανακοινώσεις");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setResizable(false);
	    this.setLocation(400,200);

	    this.add(this.createAnakoinwseisPanel(), BorderLayout.CENTER);
	    
	    this.displayWindow();
	}
	
	public void displayWindow() {
		this.pack();
        this.setVisible(true);
	}
	
	private JComponent createAnakoinwseisPanel() {
		JPanel anakPanel = new JPanel();
		anakPanel.setLayout(new BoxLayout(anakPanel, BoxLayout.Y_AXIS));
		anakPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		AnakoinwseisController ac = new AnakoinwseisController();
		
		List<Anakoinwsi> anakinwseis = ac.getAllAnakoinwseis();
		for (Anakoinwsi anakinwsi : anakinwseis) {
			anakPanel.add(Box.createRigidArea(new Dimension(0, 10)));
			anakPanel.add(this.createUpper(anakinwsi.getTitle(),anakinwsi.getDate()));
			anakPanel.add(Box.createRigidArea(new Dimension(0, 10)));
			anakPanel.add(this.createSxolio(anakinwsi.getSxolio()));
			anakPanel.add(new JSeparator());
		}
		
		anakPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		anakPanel.add(this.createButtons());
	
		return anakPanel;
	}
	
	private JComponent createUpper(String title,Date wra) {
		// Components
		JLabel titleLabel = new JLabel(title);
		JLabel diaxwristikoLabel = new JLabel(" - ");
		
		Locale locale = new Locale("el", "GR");
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH:mm a",locale);
		String time = dateFormat.format(wra);
		
		JLabel timeLabel = new JLabel(time);
		
		titleLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		timeLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		diaxwristikoLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		// Panel
		JPanel titlePanel = new JPanel();
		titlePanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.X_AXIS));
		titlePanel.add(titleLabel);
		titlePanel.add(Box.createRigidArea(new Dimension(10, 10)));
		titlePanel.add(diaxwristikoLabel);
		titlePanel.add(Box.createRigidArea(new Dimension(10, 10)));
		titlePanel.add(timeLabel);
		
		return titlePanel;
	}
	
	private JComponent createSxolio(String title) {
		// Components
		JLabel sxoliaLabel = new JLabel(title);
		sxoliaLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		// Panel
		JPanel sxoliaPanel = new JPanel();
		sxoliaPanel.setLayout(new BoxLayout(sxoliaPanel, BoxLayout.LINE_AXIS));
		sxoliaPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		sxoliaPanel.add(sxoliaLabel);
		
		return sxoliaPanel;
	}
	
	private JComponent createButtons() {
		// Components
		JButton okButton = new JButton("Σύνδεση");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				SwingUtilities.invokeLater(new Runnable() {
		            public void run() {
		            	new LoginFrame();
		            }
		        });
			}
		});
		
		// Panel
		JPanel component = new JPanel();
		component.setLayout(new BoxLayout(component, BoxLayout.LINE_AXIS));
		component.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		component.add(okButton);

		return component;
	}
	
}
