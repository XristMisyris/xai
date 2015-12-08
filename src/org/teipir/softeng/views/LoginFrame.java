package org.teipir.softeng.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import org.teipir.softeng.controllers.UserController;

public class LoginFrame extends JFrame {
	
	private UserController userCtrl = new UserController();
	
	private JComboBox loginAsCombo = new JComboBox(new String[] {"Διαχειριστής","Ταμίας"});
	private JTextField usernameField = new JTextField(20);
	private JPasswordField passwordField = new JPasswordField(20);
	
	public LoginFrame() {
		super();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setResizable(false);
	    this.setLocation(400,200);

	    this.add(this.createLoginPanel(), BorderLayout.CENTER);
	    
	    this.displayWindow();
	}
	
	public void displayWindow() {
		this.pack();
        this.setVisible(true);
	}
	
	private JComponent createLoginPanel() {
		JPanel loginPanel = new JPanel();
		loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.Y_AXIS));
		loginPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 0));
		
		loginPanel.add(this.createLoginAs());
		loginPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		loginPanel.add(this.createUsername());
		loginPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		loginPanel.add(this.createPassword());
		loginPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		loginPanel.add(this.createButtons());	
		return loginPanel;
	}
	
	private JComponent createLoginAs() {
		// Components
		JLabel loginAsLabel = new JLabel("Σύνδεση ως : ");
		loginAsCombo.setSelectedIndex(0);
		
		// Panel
		JPanel loginAsPanel = new JPanel();
		loginAsPanel.setLayout(new BoxLayout(loginAsPanel, BoxLayout.LINE_AXIS));
		loginAsPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		loginAsPanel.add(loginAsLabel);
		loginAsPanel.add(Box.createRigidArea(new Dimension(5, 0)));
		loginAsPanel.add(loginAsCombo);
		return loginAsPanel;
	}
	
	private JComponent createUsername() {
		// Components
		JLabel label = new JLabel("Username : ");
		
		// Panel
		JPanel component = new JPanel();
		component.setLayout(new BoxLayout(component, BoxLayout.LINE_AXIS));
		component.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		component.add(label);
		component.add(Box.createRigidArea(new Dimension(10, 0)));
		component.add(usernameField);
		return component;
	}
	
	private JComponent createPassword() {
		// Components
		JLabel label = new JLabel("Password : ");
		
		// Panel
		JPanel component = new JPanel();
		component.setLayout(new BoxLayout(component, BoxLayout.LINE_AXIS));
		component.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		component.add(label);
		component.add(Box.createRigidArea(new Dimension(12, 0)));
		component.add(passwordField);
		return component;
	}
	
	private JComponent createButtons() {
		// Components
		JButton okButton = new JButton("Σύνδεση");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int loginAs = loginAsCombo.getSelectedIndex();
				String username = usernameField.getText();
				String password = new String(passwordField.getPassword());
				loginUser(username, password, loginAs);
			}
		});
		JButton cancelButton = new JButton("Έξοδος");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Exit Program!");
				System.exit(0);
			}
		});
		
		// Panel
		JPanel component = new JPanel();
		component.setLayout(new BoxLayout(component, BoxLayout.LINE_AXIS));
		component.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		component.add(okButton);
		component.add(Box.createRigidArea(new Dimension(10, 0)));
		component.add(cancelButton);
		return component;
	}
	
	private void loginUser(String username, String password, final int mode) {
		boolean isValidUser = false;
		if(mode == 0) {
			isValidUser = userCtrl.isValidDiaxiristis(username, password);
		} else if (mode == 1) {
			isValidUser = userCtrl.isValidTamias(username, password);
		}
		if(isValidUser) {
			System.out.println("User is valid");
			this.setVisible(false);
			SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	            	MainFrame mainFrame = new MainFrame(mode);
	            }
	        });
		} else {
			JOptionPane.showMessageDialog(this,"Wrong username or password",
				    "Login error",JOptionPane.ERROR_MESSAGE);
		}
	}
	
}