package org.teipir.softeng.views;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import org.teipir.softeng.DateLabelFormatter;
import org.teipir.softeng.controllers.DromologioController;
import org.teipir.softeng.controllers.EisitirioController;
import org.teipir.softeng.models.Dromologio;
import javax.swing.JRadioButton;

public class EkdosiEisitiriouPanel extends JPanel{
	
	private JComboBox dromologiaCombo = new JComboBox();
	private UtilDateModel model = new UtilDateModel();
	JRadioButton kanonikoButton = new JRadioButton("Κανονικό");
	JRadioButton foititikoButton = new JRadioButton("Φοιτητικό/Στρατιοτητό");
	
	JDatePickerImpl datePicker = null;
	List<Dromologio> dromologia = null;
	
	public EkdosiEisitiriouPanel() {
		super();
		
		this.add(this.createEkdosiPanel(), BorderLayout.CENTER);
	}
	
	private void setUpComponents() {
		dromologiaCombo.removeAllItems();
	
		DromologioController dr = new DromologioController();
		
		this.dromologia = dr.getAllDromologia();
		for (Dromologio dromologio : dromologia) {
			
			Date wra = dromologio.getWra();
			SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
			String time = formatter.format(wra);
			
			dromologiaCombo.addItem(dromologio.getAnaxwrisi() + "-" + dromologio.getProorismos() + " - " + time);
		}
	}

	private JComponent createEkdosiPanel() {
		JPanel ekdosiPanel = new JPanel();
		ekdosiPanel.setLayout(new BoxLayout(ekdosiPanel, BoxLayout.Y_AXIS));
		ekdosiPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		setUpComponents();
		
		ekdosiPanel.add(this.selectDromologio());
		ekdosiPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		ekdosiPanel.add(this.createTipos());
		ekdosiPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		ekdosiPanel.add(this.createMera());
		ekdosiPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		ekdosiPanel.add(this.createButtons());
		
		
		return ekdosiPanel;
	}

	private JComponent selectDromologio() {
		// Components
		JLabel dromologiaLabel = new JLabel("Δρομολόγιο : ");
		
		// Panel
		JPanel dromologiaPanel = new JPanel();
		dromologiaPanel.setLayout(new BoxLayout(dromologiaPanel, BoxLayout.X_AXIS));
		dromologiaPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		dromologiaPanel.add(dromologiaLabel);
		dromologiaPanel.add(Box.createRigidArea(new Dimension(5, 0)));
		dromologiaPanel.add(dromologiaCombo);
		
		dromologiaCombo.addPopupMenuListener(new PopupMenuListener(){
			 public void popupMenuWillBecomeVisible(PopupMenuEvent popupMenuEvent) {
				 //System.out.println("Becoming Visible");
				 setUpComponents();
			 }
			 public void popupMenuWillBecomeInvisible(PopupMenuEvent popupMenuEvent) {
				 //System.out.println("Becoming InVisible");
			 }
			 public void popupMenuCanceled(PopupMenuEvent popupMenuEvent) {
				 //System.out.println("Becoming Visible");
			 }
		});
		
		return dromologiaPanel;
	}
	
	private JComponent createTipos() {
		// Components
		JLabel tiposLabel = new JLabel("Τύπος : ");
		
		// Panel
		JPanel tiposPanel = new JPanel();
		tiposPanel.setLayout(new BoxLayout(tiposPanel, BoxLayout.X_AXIS));
		tiposPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		tiposPanel.add(tiposLabel);
		tiposPanel.add(Box.createRigidArea(new Dimension(30, 0)));
		tiposPanel.add(kanonikoButton);
		tiposPanel.add(foititikoButton);
		
		return tiposPanel;
	}
	
	private JComponent createMera() {
		// Components
		JLabel meraLabel = new JLabel("Ημέρα : ");
		
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		
		// Panel
		JPanel meraPanel = new JPanel();
		meraPanel.add(meraLabel);
		meraPanel.add(Box.createRigidArea(new Dimension(10, 0)));
		meraPanel.add(datePicker);
		
		return meraPanel;
	}

	private Component createThesi() {
		
		return null;
	}

	private JComponent createButtons() {
		// Components
		JButton okButton = new JButton("Έκδοση Εισιτηρίου");
		
		JPanel framePanel = this;
		
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    int selectedDromologio = dromologiaCombo.getSelectedIndex() + 1;
			    
			    String anaxwrisi = dromologia.get(selectedDromologio).getAnaxwrisi();
			    String proorismos = dromologia.get(selectedDromologio).getProorismos();
			    Date wra = dromologia.get(selectedDromologio).getWra();
			    
			    //need fix
			    int thesi = 0;
			    
			    int tiposEisitirio = 0;
			    double timi = 0;
			   
			    if(kanonikoButton.isSelected()){
			    	tiposEisitirio = 0;
			    }
			    else if(foititikoButton.isSelected()){
			    	tiposEisitirio = 1;
			    }
			    
			    if(tiposEisitirio == 0){
			    	timi = dromologia.get(selectedDromologio).getKanonikiTimi();
			    }
			    else
			    	timi = dromologia.get(selectedDromologio).getFoititikiTimi();
			    
				EisitirioController dromologio = new EisitirioController();
				boolean prostethike = dromologio.addEisitirio(anaxwrisi,proorismos,wra,thesi,tiposEisitirio,timi);
			    
				if (prostethike == true){
					JOptionPane.showMessageDialog(framePanel,"Το εισιτήριο εκδόθηκε επιτυχώς!",
						    "Success",JOptionPane.INFORMATION_MESSAGE);
				}
				else{
					JOptionPane.showMessageDialog(framePanel,"Σφάλμα! Δεν ήταν δυνατή η έκδοση εισιτηρίου",
						    "Error",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		// Panel
		JPanel component = new JPanel();
		component.setLayout(new BoxLayout(component, BoxLayout.LINE_AXIS));
		component.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		component.add(okButton);
		
		return component;
	}
}
