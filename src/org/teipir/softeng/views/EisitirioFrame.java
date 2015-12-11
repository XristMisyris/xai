package org.teipir.softeng.views;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.teipir.softeng.Printer;

@SuppressWarnings("serial")
public class EisitirioFrame extends JFrame{
	
	private String anaxwrisi,proorismos,date;
	private int thesi,tiposEisitiriou;
	private double timi;
	private Date wra;
	private JPanel eisitPanel = new JPanel();

	public EisitirioFrame(String anaxwrisi, String proorismos, Date wra, String date, int thesi, int tiposEisitiriou, double timi){
		super("Εισιτήριο");
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setResizable(false);
	    this.setLocation(400,200);
	    
	    this.anaxwrisi = anaxwrisi;
	    this.proorismos = proorismos;
	    this.date = date;
	    this.thesi = thesi;
	    this.tiposEisitiriou = tiposEisitiriou;
	    this.timi = timi;
	    this.wra = wra;

	    getContentPane().add(this.createEisitirioPanel(), BorderLayout.CENTER);
	    
	    this.displayWindow();
	}
	
	public void displayWindow() {
		this.pack();
        this.setVisible(true);
	}
	
	private JComponent createEisitirioPanel() {
		this.eisitPanel = new JPanel();
		eisitPanel.setLayout(new BoxLayout(eisitPanel, BoxLayout.Y_AXIS));
		eisitPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		eisitPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		eisitPanel.add(this.createHmerominia());
		eisitPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		eisitPanel.add(this.createApoPros());
		eisitPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		eisitPanel.add(this.createKatigoria());
		eisitPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		eisitPanel.add(this.createThesiTimi());
		eisitPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		eisitPanel.add(this.createButtons());
	
		return eisitPanel;
	}
	
	private JComponent createHmerominia() {
		JLabel dateLabel = new JLabel("ΗΜΕΡΟΜΗΝΙΑ: ");
		JLabel wraLabel = new JLabel( date + " - " + wra);
		
		// Panel
		JPanel jPanel = new JPanel();
		jPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.X_AXIS));
		
		jPanel.add(Box.createRigidArea(new Dimension(10, 10)));
		jPanel.add(dateLabel);
		jPanel.add(Box.createRigidArea(new Dimension(60, 10)));
		jPanel.add(wraLabel);
		
		return jPanel;
	}
	
	private JComponent createApoPros() {
		JLabel titleLabel = new JLabel("ΑΠΟ-ΠΡΟΣ: ");
		JLabel valueLabel = new JLabel( anaxwrisi + " - " + proorismos);
		
		// Panel
		JPanel jPanel = new JPanel();
		jPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.X_AXIS));
		
		jPanel.add(Box.createRigidArea(new Dimension(10, 10)));
		jPanel.add(titleLabel);
		jPanel.add(Box.createRigidArea(new Dimension(78, 10)));
		jPanel.add(valueLabel);
		
		return jPanel;
	}
	
	private JComponent createKatigoria() {
		JLabel titleLabel = new JLabel("ΚΑΤΗΓΟΡΙΑ: ");
		JLabel valueLabel = new JLabel("Κανονικό");
		
		if (tiposEisitiriou == 0)
			valueLabel = new JLabel("Κανονικό");
		else
			valueLabel = new JLabel("Φοιτηρηκό/Στρατιωτικό");
		
		// Panel
		JPanel jPanel = new JPanel();
		jPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.X_AXIS));
		
		jPanel.add(Box.createRigidArea(new Dimension(10, 10)));
		jPanel.add(titleLabel);
		jPanel.add(Box.createRigidArea(new Dimension(75, 10)));
		jPanel.add(valueLabel);
		
		return jPanel;
	}
	
	private JComponent createThesiTimi() {
		JLabel thesiTitleLabel = new JLabel("ΘΕΣΗ: ");
		JLabel thesiValueLabel = new JLabel(Integer.toString(thesi));
		JLabel timiTitleLabel = new JLabel("ΤΙΜΗ: ");
		JLabel timiValueLabel = new JLabel(Double.toString(timi));
		
		// Panel
		JPanel jPanel = new JPanel();
		jPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.X_AXIS));
		
		jPanel.add(Box.createRigidArea(new Dimension(10, 10)));
		jPanel.add(thesiTitleLabel);
		jPanel.add(Box.createRigidArea(new Dimension(10, 10)));
		jPanel.add(thesiValueLabel);
		jPanel.add(Box.createRigidArea(new Dimension(90, 10)));
		jPanel.add(timiTitleLabel);
		jPanel.add(Box.createRigidArea(new Dimension(10, 10)));
		jPanel.add(timiValueLabel);
		
		return jPanel;
	}
	

	private JComponent createButtons() {
		// Components
		JButton okButton = new JButton("Εκτύπωση");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrinterJob pjob = PrinterJob.getPrinterJob();
				PageFormat preformat = pjob.defaultPage();
				preformat.setOrientation(PageFormat.LANDSCAPE);
				PageFormat postformat = pjob.pageDialog(preformat);
				//If user does not hit cancel then print.
				if (preformat != postformat) {
					okButton.setVisible(false);
				    //Set print component
				    pjob.setPrintable(new Printer(eisitPanel), postformat);
				    if (pjob.printDialog()) {
				        try {
							pjob.print();
						} catch (PrinterException e1) {
							e1.printStackTrace();
						}
				    }
				}
			}
		});
		
		// Panel
		JPanel component = new JPanel();
		component.setAlignmentX(Component.LEFT_ALIGNMENT);
		component.setLayout(new BoxLayout(component, BoxLayout.LINE_AXIS));
		component.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		component.add(okButton);

		return component;
	}
	
}
