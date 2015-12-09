package org.teipir.softeng.controllers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.teipir.softeng.SQLHelper;
import org.teipir.softeng.models.Anakoinwsi;

public class AnakoinwseisController {
	
	private Connection conn;
	
	public AnakoinwseisController() {
		conn = SQLHelper.connectDB();
	}
	
	public boolean addAnakoinwsi(String title, String sxolio){
		
		String query = "INSERT INTO anakoinwseis (title,sxolio,date) VALUES('"+ title +"','" + sxolio + "',CURRENT_TIMESTAMP)";
		
		boolean result = SQLHelper.executeUpdate(query, conn);
		if(result == true){
			System.out.println("Anakoinwsi Prostethike");
			return true;
		}
		else {
			System.out.println("Error Inserting Anakoinwsi");
			return false;
		}
	}

	public List<Anakoinwsi> getAllAnakoinwseis() {
		List<Anakoinwsi> anakoinwseis = new ArrayList<Anakoinwsi>();
		String query = "SELECT title,sxolio,date FROM anakoinwseis";
		ResultSet resultSet = SQLHelper.executeQuery(query, conn);
		if (resultSet != null) {
			try {
				while (resultSet.next()) {
					String title = resultSet.getString("title");
					String sxolio = resultSet.getString("sxolio");
					Timestamp date = resultSet.getTimestamp("date");
					Anakoinwsi anak = new Anakoinwsi();
					anak.setTitle(title);
					anak.setSxolio(sxolio);
					anak.setDate(date);
					anakoinwseis.add(anak);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return anakoinwseis;
	} 
	
}
