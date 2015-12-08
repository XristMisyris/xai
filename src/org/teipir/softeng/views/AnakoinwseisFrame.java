package org.teipir.softeng.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.teipir.softeng.controllers.AnakoinwseisController;
import org.teipir.softeng.models.Anakoinwsi;

public class AnakoinwseisFrame extends JFrame{
	public AnakoinwseisFrame() {
		super();
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
			anakPanel.add(this.createTitle(anakinwsi.getTitle()));
			anakPanel.add(Box.createRigidArea(new Dimension(0, 10)));
			anakPanel.add(this.createWra(anakinwsi.getDate()));
			anakPanel.add(Box.createRigidArea(new Dimension(0, 10)));
			anakPanel.add(this.createSxolio(anakinwsi.getSxolio()));
		}
	
		return anakPanel;
	}
	
	private JComponent createTitle(String title) {
		// Components
		JLabel titleLabel = new JLabel("Τίτλος : ");
		JLabel titleLabel2 = new JLabel(title);
		
		// Panel
		JPanel titlePanel = new JPanel();
		titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.LINE_AXIS));
		titlePanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		titlePanel.add(titleLabel);
		titlePanel.add(Box.createRigidArea(new Dimension(5, 0)));
		titlePanel.add(titleLabel2);
		
		return titlePanel;
	}
	
	private JComponent createWra(String wra) {
		// Components
		JLabel titleLabel = new JLabel("Ώρα : ");
		JLabel titleLabel2 = new JLabel(wra);
		
		// Panel
		JPanel titlePanel = new JPanel();
		titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.LINE_AXIS));
		titlePanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		titlePanel.add(titleLabel);
		titlePanel.add(Box.createRigidArea(new Dimension(5, 0)));
		titlePanel.add(titleLabel2);
		
		return titlePanel;
	}
	private JComponent createSxolio(String sxolio) {
		// Components
		JLabel titleLabel = new JLabel("Σχόλιο : ");
		JLabel titleLabel2 = new JLabel(sxolio);
		
		// Panel
		JPanel titlePanel = new JPanel();
		titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.LINE_AXIS));
		titlePanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		titlePanel.add(titleLabel);
		titlePanel.add(Box.createRigidArea(new Dimension(5, 0)));
		titlePanel.add(titleLabel2);
		
		return titlePanel;
	}
}
