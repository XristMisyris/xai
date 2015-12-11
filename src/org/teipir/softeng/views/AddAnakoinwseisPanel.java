package org.teipir.softeng.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.teipir.softeng.controllers.AnakoinwseisController;

@SuppressWarnings("serial")
public class AddAnakoinwseisPanel extends JPanel{

	private JTextField titlosField = new JTextField(20);
	private JTextArea sxoliaTextArea = new JTextArea();
	
	public AddAnakoinwseisPanel() {
		super();

		// Panel
		this.add(this.createAnakoinwseisPanel(), BorderLayout.CENTER);
	}

	private JComponent createAnakoinwseisPanel() {
		JPanel anakoinwseisPanel = new JPanel();
		anakoinwseisPanel.setLayout(new BoxLayout(anakoinwseisPanel, BoxLayout.Y_AXIS));
		anakoinwseisPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		anakoinwseisPanel.add(this.createTitle());
		anakoinwseisPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		anakoinwseisPanel.add(this.createSxolio());
		anakoinwseisPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		anakoinwseisPanel.add(this.createButtons());
		
		return anakoinwseisPanel;
	}
	
	
	private JComponent createTitle() {
		// Components
		JLabel label = new JLabel("Τίτλος : ");
		
		// Panel
		JPanel component = new JPanel();
		component.setLayout(new BoxLayout(component, BoxLayout.LINE_AXIS));
		component.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		component.add(label);
		component.add(Box.createRigidArea(new Dimension(34, 0)));
		component.add(titlosField);
		return component;
	}
	
	private JComponent createSxolio() {
		// Components
		JLabel label = new JLabel("Σχόλιο : ");
		
		// Panel
		JPanel component = new JPanel();
		component.setLayout(new BoxLayout(component, BoxLayout.LINE_AXIS));
		component.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		component.add(label);
		component.add(Box.createRigidArea(new Dimension(33, 0)));
		sxoliaTextArea.setLineWrap(true);
		sxoliaTextArea.setRows(10);
		component.add(sxoliaTextArea);
		return component;
	}
	
	
	
	private JComponent createButtons() {
		// Components
		JButton okButton = new JButton("Προσθήκη Ανακοίνωσης");
		
		JPanel framePanel = this;
		
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String title = titlosField.getText();
				String sxolio  = sxoliaTextArea.getText();
				
				AnakoinwseisController anakoinwsi = new AnakoinwseisController();
				boolean prostethike = anakoinwsi.addAnakoinwsi(title,sxolio);
				
				if (prostethike == true){
					JOptionPane.showMessageDialog(framePanel,"Η Ανακοίνωση προστέθικε επιτυχός!",
						    "Success",JOptionPane.INFORMATION_MESSAGE);
				}
				else{
					JOptionPane.showMessageDialog(framePanel,"Σφάλμα! Δεν ήταν δυνατή η προσθήκη ανακοίνωσης",
						    "Error",JOptionPane.ERROR_MESSAGE);
				}
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
