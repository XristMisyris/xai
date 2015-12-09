package org.teipir.softeng.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Locale;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;

import org.teipir.softeng.controllers.DromologioController;

public class AddDromologioPanel extends JPanel {
	
	private JTextField proorismosField = new JTextField(20);
	private JTextField anaxwrisiField = new JTextField(20);
	private JTextField kanonikoField = new JTextField(20);
	private JTextField foititikoField = new JTextField(20);
	private JSpinner timeSpinner = new JSpinner( new SpinnerDateModel() );
	
	public AddDromologioPanel() {
		super();

		// Panel
		this.add(this.createLoginPanel(), BorderLayout.CENTER);
	}

	private JComponent createLoginPanel() {
		JPanel loginPanel = new JPanel();
		loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.Y_AXIS));
		loginPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		loginPanel.add(this.createAnaxwrisi());
		loginPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		loginPanel.add(this.createProorismos());
		loginPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		loginPanel.add(this.createKanoniko());
		loginPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		loginPanel.add(this.createFoititiko());
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
		component.add(Box.createRigidArea(new Dimension(33, 0)));
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
	
	private JComponent createKanoniko() {
		// Components
		JLabel label = new JLabel("Τιμή Κανονικού : ");
		
		// Panel
		JPanel component = new JPanel();
		component.setLayout(new BoxLayout(component, BoxLayout.LINE_AXIS));
		component.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		component.add(label);
		component.add(Box.createRigidArea(new Dimension(17, 0)));
		component.add(kanonikoField);
		return component;
	}
	
	private JComponent createFoititiko() {
		// Components
		JLabel label = new JLabel("Τιμή Φοιτητηκού : ");
		
		// Panel
		JPanel component = new JPanel();
		component.setLayout(new BoxLayout(component, BoxLayout.LINE_AXIS));
		component.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		component.add(label);
		component.add(Box.createRigidArea(new Dimension(9, 0)));
		component.add(foititikoField);
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
		
		JPanel framePanel = this;
		
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String proorismos = proorismosField.getText();
				String anaxwrisi  = anaxwrisiField.getText();
				double kanonikiTimi = Double.parseDouble(kanonikoField.getText());
				double foititikiTimi  = Double.parseDouble(foititikoField.getText());
				Date time = (Date) timeSpinner.getValue();
				
				Locale localeObject = new Locale("en");
				DateFormat dateFormat = new SimpleDateFormat("HH:mm",localeObject);
				String wra = dateFormat.format(time);
				
				DromologioController dromologio = new DromologioController();
				boolean prostethike = dromologio.addDromologio(anaxwrisi,proorismos,wra,kanonikiTimi,foititikiTimi);
				
				if (prostethike == true){
					JOptionPane.showMessageDialog(framePanel,"Το δρομολόγιο προστέθικε επιτυχός!",
						    "Success",JOptionPane.INFORMATION_MESSAGE);
				}
				else{
					JOptionPane.showMessageDialog(framePanel,"Σφάλμα! Δεν ήταν δυνατή η προσθήκη δρομολογίου",
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
