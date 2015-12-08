package org.teipir.softeng.views;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import org.teipir.softeng.models.Dromologio;

public class EkdosiEisitiriouPanel extends JPanel{
	
	private JComboBox dromologiaCombo = new JComboBox();
	private UtilDateModel model = new UtilDateModel();
	
	JDatePickerImpl datePicker = null;
	
	public EkdosiEisitiriouPanel() {
		super();
		
		this.add(this.createEkdosiPanel(), BorderLayout.CENTER);
	}
	
	private void setUpComponents() {
		dromologiaCombo.removeAllItems();
	
		DromologioController dr = new DromologioController();
		
		List<Dromologio> dromologia = dr.getAllDromologia();
		for (Dromologio dromologio : dromologia) {
			dromologiaCombo.addItem(dromologio.getAfiksi() + "-" + dromologio.getProorismos() + "-" + dromologio.getWra());
		}
	}

	private JComponent createEkdosiPanel() {
		JPanel ekdosiPanel = new JPanel();
		ekdosiPanel.setLayout(new BoxLayout(ekdosiPanel, BoxLayout.Y_AXIS));
		ekdosiPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		setUpComponents();
		
		ekdosiPanel.add(this.selectDromologio());
		ekdosiPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		//ekdosiPanel.add(this.createThesi());
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
		dromologiaPanel.setLayout(new BoxLayout(dromologiaPanel, BoxLayout.LINE_AXIS));
		dromologiaPanel.setBorder(BorderFactory.createEmptyBorder(0, 5, 10, 10));
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
		meraPanel.add(Box.createRigidArea(new Dimension(23, 0)));
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
				boolean prostethike = true;//temp
				
				Date selectedDate = (Date)datePicker.getModel().getValue();
			    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			    String reportDate = df.format(selectedDate);
				
				if (prostethike == true){
					JOptionPane.showMessageDialog(framePanel,reportDate,
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
		component.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		component.add(okButton);
		
		return component;
	}


}
