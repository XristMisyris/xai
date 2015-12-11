package org.teipir.softeng.views;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

import org.teipir.softeng.views.AddDromologioPanel;
import org.teipir.softeng.views.EkdosiEisitiriouPanel;

@SuppressWarnings("serial")
public class MainFrame extends JFrame{

	private static final int DIAXIRISTIS_MODE = 0;
	private static final int TAMIAS_MODE = 1;
	
	public MainFrame(int mode){
		super("Εφαρμογή υπεραστικών λεωφορείων");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(true);
	    this.setLocation(400,200);
	    this.setSize(500,350);
	    this.addWindowListener(new WindowAdapter() {
	    	public void windowClosed(WindowEvent e) {
	    		super.windowClosed(e);
	    		SwingUtilities.invokeLater(new Runnable() {
		            public void run() {
		            	new AnakoinwseisFrame();
		            }
		        });
	    		//System.exit(0);
	    	}
		});
	    //Add content to the window.
	    this.add(this.createMainTabbedPanel(mode), BorderLayout.CENTER);
	    
	    //Display the window.
	    //this.pack(); //automatically resize
	    this.setVisible(true);
	}
	
	private JPanel createMainTabbedPanel(int mode) {
		JPanel panel = new JPanel(new GridLayout(1, 1));
		JTabbedPane tabbedPane = new JTabbedPane();
		
		if(mode == DIAXIRISTIS_MODE) {
			JComponent tab = new AddDromologioPanel();
			tabbedPane.addTab("Προσθήκη Δρομολογίου", null, tab, "Προσθήκη Δρομολογίο");
			JComponent tab2 = new EkdosiEisitiriouPanel();
			tabbedPane.addTab("Έκδοση Εισιτηρίου", null, tab2, "Έκδοση Εισιτηρίου");
			JComponent tab3 = new AddAnakoinwseisPanel();
			tabbedPane.addTab("Προσθήκη Ανακοίνωσης", null, tab3, "Προσθήκη Ανακοίνωσης");
		} else if (mode == TAMIAS_MODE) {
			JComponent tab2 = new EkdosiEisitiriouPanel();
			tabbedPane.addTab("Έκδοση Εισιτηρίου", null, tab2, "Έκδοση Εισιτηρίου");
		}
		
		// Add the tabbed pane to this panel.
		panel.add(tabbedPane);

		// The following line enables to use scrolling tabs.
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		
		return panel;
	}
	

}
