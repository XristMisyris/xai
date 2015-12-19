package org.teipir.softeng.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import org.teipir.softeng.DateLabelFormatter;
import org.teipir.softeng.controllers.DromologioController;
import org.teipir.softeng.controllers.EisitirioController;
import org.teipir.softeng.models.Dromologio;

@SuppressWarnings("serial")
public class EkdosiEisitiriouPanel extends JPanel{
	
	private JComboBox<String> dromologiaCombo = new JComboBox<>();
	
	private List<String> unavailableSeats = new ArrayList<String>();
	private Object[] theseisObj = {};
	private JComboBox<Object> thesiCombo = new JComboBox<>(theseisObj);
	
	private UtilDateModel model = new UtilDateModel();
	private JRadioButton kanonikoButton = new JRadioButton("Κανονικό");
	private JRadioButton foititikoButton = new JRadioButton("Φοιτητικό/Στρατιοτητό");
	
	private JDatePickerImpl datePicker = null;
	private List<Dromologio> dromologia = null;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JPanel ekdosiPanel = new JPanel();
	
	
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
		this.ekdosiPanel = new JPanel();
		ekdosiPanel.setLayout(new BoxLayout(ekdosiPanel, BoxLayout.Y_AXIS));
		ekdosiPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		setUpComponents();
		
		ekdosiPanel.add(this.selectDromologio());
		ekdosiPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		ekdosiPanel.add(this.createMera());
		ekdosiPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		ekdosiPanel.add(this.createTipos());
		ekdosiPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		ekdosiPanel.add(this.createThesi());
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
		buttonGroup.add(foititikoButton);
		buttonGroup.add(kanonikoButton);
		kanonikoButton.setSelected(true);
		
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
		
		Date date = new Date();
	    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	    String reportDate = df.format(date);
		
		this.datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		datePicker.getJFormattedTextField().setText(reportDate);
		
		// Panel
		JPanel meraPanel = new JPanel();
		meraPanel.setLayout(new BoxLayout(meraPanel, BoxLayout.X_AXIS));
		meraPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		meraPanel.add(meraLabel);
		meraPanel.add(Box.createRigidArea(new Dimension(32, 0)));
		meraPanel.add(datePicker);
		
		return meraPanel;
	}

	private JComponent createThesi() {
		// Components
		JLabel thesiLabel = new JLabel("Θέση : ");
		
		// Panel
		JPanel thesiPanel = new JPanel();
		thesiPanel.setLayout(new BoxLayout(thesiPanel, BoxLayout.X_AXIS));
		thesiPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		thesiPanel.add(thesiLabel);
		thesiPanel.add(Box.createRigidArea(new Dimension(39, 0)));
		thesiPanel.add(thesiCombo);
		
		thesiCombo.addPopupMenuListener(new PopupMenuListener(){
			public void popupMenuWillBecomeVisible(PopupMenuEvent popupMenuEvent) {
				//System.out.println("Becoming Visible");
				
				thesiCombo.removeAllItems();

				EisitirioController ec = new EisitirioController();
				
			    int selectedDromologio = dromologiaCombo.getSelectedIndex();
				    
				String anaxwrisi = dromologia.get(selectedDromologio).getAnaxwrisi();
				String proorismos = dromologia.get(selectedDromologio).getProorismos();
				String reportDate = datePicker.getJFormattedTextField().getText();
				   
				unavailableSeats = ec.checkAvailableSeats(anaxwrisi,proorismos,reportDate);
				setTheseis();
			}
			public void popupMenuWillBecomeInvisible(PopupMenuEvent popupMenuEvent) {
				//System.out.println("Becoming InVisible");
			}
			public void popupMenuCanceled(PopupMenuEvent popupMenuEvent) {
				//System.out.println("Becoming Visible");
			}
		});
		
		return thesiPanel;
	}

	private JComponent createButtons() {
		// Components
		JButton okButton = new JButton("Έκδοση Εισιτηρίου");
		
		JPanel framePanel = this;
		
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    int selectedDromologio = dromologiaCombo.getSelectedIndex();
			    Object thesiObj = thesiCombo.getItemAt(thesiCombo.getSelectedIndex());
			    int thesi = Integer.parseInt(thesiObj.toString());
			    
			    String anaxwrisi = dromologia.get(selectedDromologio).getAnaxwrisi();
			    String proorismos = dromologia.get(selectedDromologio).getProorismos();
			    Date wra = dromologia.get(selectedDromologio).getWra();
			    
			    String reportDate = datePicker.getJFormattedTextField().getText();
			    
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
				boolean prostethike = dromologio.addEisitirio(anaxwrisi,proorismos,reportDate,thesi,tiposEisitirio,timi);
				
				dromologio.createEisitirioFrame(anaxwrisi,proorismos,wra,reportDate,thesi,tiposEisitirio,timi);
			    
				if (prostethike == false){
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
	
	private void setTheseis(){
		for(int i = 1; i <= 49; i++){
			thesiCombo.addItem(makeObj(Integer.toString(i)));
		}
		
		int temp = 0;
		for(int i = 0; i < thesiCombo.getItemCount() - temp; i++){
			String currentThesi = thesiCombo.getItemAt(i).toString();
			for(int z = 0; z < unavailableSeats.size(); z++){
				if(currentThesi.equals(unavailableSeats.get(z))){
					thesiCombo.removeItemAt(i);
					temp++;
					i--;
				}
			}
		}
	}
	
	private Object makeObj(final String item)  {
		return new Object() { public String toString() { return item; } };
	}
}
