package org.teipir.softeng.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;

public class AddDromologioPanel extends JPanel {
	
	private JTextField proorismosField = new JTextField(20);
	private JTextField anaxwrisiField = new JTextField(20);
	private JSpinner timeSpinner = new JSpinner( new SpinnerDateModel() );
	
	public AddDromologioPanel() {
		super();

		// Panel
		this.add(this.createLoginPanel(), BorderLayout.CENTER);
	}

	private JComponent createLoginPanel() {
		JPanel loginPanel = new JPanel();
		loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.Y_AXIS));
		loginPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 0));
		
		loginPanel.add(this.createAnaxwrisi());
		loginPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		loginPanel.add(this.createProorismos());
		loginPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		loginPanel.add(this.createOra());
		loginPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		loginPanel.add(this.createButtons());
		return loginPanel;
	}
	
	
	private JComponent createProorismos() {
		// Components
		JLabel label = new JLabel("Προορισμός : ");
		
		// Panel
		JPanel component = new JPanel();
		component.setLayout(new BoxLayout(component, BoxLayout.LINE_AXIS));
		component.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		component.add(label);
		component.add(Box.createRigidArea(new Dimension(34, 0)));
		component.add(proorismosField);
		return component;
	}
	
	private JComponent createAnaxwrisi() {
		// Components
		JLabel label = new JLabel("Αναχώριση : ");
		
		// Panel
		JPanel component = new JPanel();
		component.setLayout(new BoxLayout(component, BoxLayout.LINE_AXIS));
		component.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		component.add(label);
		component.add(Box.createRigidArea(new Dimension(42, 0)));
		component.add(anaxwrisiField);
		return component;
	}
	
	private JComponent createOra() {
		// Components
		JLabel label = new JLabel("Ώρα Αναχώρισης : ");
		
		// Panel
		JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, "HH:mm");
		timeSpinner.setEditor(timeEditor);
		timeSpinner.setValue(new Date());
		
		JPanel component = new JPanel();
		component.setLayout(new BoxLayout(component, BoxLayout.LINE_AXIS));
		component.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		component.add(label);
		component.add(Box.createRigidArea(new Dimension(10, 0)));
		component.add(timeSpinner);
		return component;
	}
	
	private JComponent createButtons() {
		// Components
		JButton okButton = new JButton("Προσθήκη Δρομολογίου");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
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