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

public class AnakoinwseisFrame extends JFrame{
	
	private JFrame frame = this;
	
	public AnakoinwseisFrame() {
		super("Ανακοινώσεις");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setResizable(false);
	    this.setLocation(400,200);

	    this.add(this.createAnakoinwseisPanel(), BorderLayout.CENTER);
	}
	
	public void displayWindow() {
		this.pack();
        this.setVisible(true);
	}
	
	private JComponent createAnakoinwseisPanel() {
		JPanel anakPanel = new JPanel();
		anakPanel.setLayout(new BoxLayout(anakPanel, BoxLayout.Y_AXIS));
		anakPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 0));
		
		AnakoinwseisController ac = new AnakoinwseisController();
		
		List<Anakoinwsi> anakinwseis = ac.getAllAnakoinwseis();
		for (Anakoinwsi anakinwsi : anakinwseis) {
			anakPanel.add(this.createLabel(anakinwsi.getTitle()));
			anakPanel.add(Box.createRigidArea(new Dimension(0, 10)));
			anakPanel.add(this.createLabelWra(anakinwsi.getDate()));
			anakPanel.add(Box.createRigidArea(new Dimension(0, 10)));
			anakPanel.add(this.createLabel(anakinwsi.getSxolio()));
		}
		
		anakPanel.add(this.createButtons());
	
		return anakPanel;
	}
	
	private JComponent createLabel(String title) {
		// Components
		JLabel titleLabel = new JLabel(title);
		
		// Panel
		JPanel titlePanel = new JPanel();
		titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.LINE_AXIS));
		titlePanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		titlePanel.add(titleLabel);
		
		return titlePanel;
	}
	
	private JComponent createLabelWra(Date wra) {	
		// Components
		Locale locale = new Locale("el", "GR");
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH:mm a",locale);
		String time = dateFormat.format(wra);
		
		JLabel titleLabel = new JLabel(time);
		
		// Panel
		JPanel titlePanel = new JPanel();
		titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.LINE_AXIS));
		titlePanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		titlePanel.add(titleLabel);
		
		return titlePanel;
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
