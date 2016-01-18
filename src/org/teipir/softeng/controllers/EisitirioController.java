package org.teipir.softeng.controllers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.teipir.softeng.SQLHelper;
import org.teipir.softeng.models.Eisitirio;
import org.teipir.softeng.views.EisitirioFrame;

public class EisitirioController {
	
	private Connection conn;
	private List<String> theseis = new ArrayList<String>();
	private List<Eisitirio> eisitiria = new ArrayList<Eisitirio>();

	public EisitirioController() {
		conn = SQLHelper.connectDB();
	}
	
	public boolean addEisitirio(String anaxwrisi, String proorismos, String date,int thesi, int tiposEisitiriou, double timi ){
		String query = "INSERT INTO eisitiria (anaxwrisi,proorismos,date,thesi,tiposEisitiriou,timi) VALUES('"+ anaxwrisi +"','" + proorismos + "','" + date + "','" + thesi + "','" + tiposEisitiriou + "','" + timi + "')";
		
		boolean result = SQLHelper.executeUpdate(query, conn);
		if(result == true){
			return true;
		}
		else {
			return false;
		}
	}

	public void createEisitirioFrame(String anaxwrisi, String proorismos,Date wra, String date, int thesi, int tiposEisitiriou, double timi) {
		new EisitirioFrame(anaxwrisi,proorismos,wra,date,thesi,tiposEisitiriou,timi);
	}
	
	public List<Eisitirio> getAllEisitiria() {
		String query = "SELECT anaxwrisi,proorismos,date,thesi,tiposEisitiriou,timi FROM eisitiria";
		ResultSet resultSet = SQLHelper.executeQuery(query, conn);
		if (resultSet != null) {
			try {
				while (resultSet.next()) {
					String anaxwrisi = resultSet.getString("anaxwrisi");
					String proorismos = resultSet.getString("proorismos");
					Date date = resultSet.getDate("date");
					int thesi = resultSet.getInt("thesi");
					int tipos = resultSet.getInt("tiposEisitiriou");
					double timi = resultSet.getDouble("timi");
					
					Eisitirio eisit = new Eisitirio();
					
					eisit.setAnaxwrisi(anaxwrisi);
					eisit.setProorismos(proorismos);
					eisit.setDate(date.toString());
					eisit.setArithmosThesis(thesi);
					eisit.setTiposEisitiriou(tipos);
					eisit.setTimi(timi);
					eisitiria.add(eisit);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return eisitiria;
	} 
	
	public List<String> checkAvailableSeats(String anaxwrisi,String proorismos,String reportDate){
		String query = "SELECT thesi FROM eisitiria WHERE anaxwrisi='" + anaxwrisi + "' AND proorismos='" + proorismos + "' AND date='" + reportDate + "' ";
		ResultSet resultSet = SQLHelper.executeQuery(query, conn);
		
		if (resultSet != null) {
			try {
				while (resultSet.next()) {
					theseis.add(resultSet.getString("thesi"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return theseis;
	}

}
