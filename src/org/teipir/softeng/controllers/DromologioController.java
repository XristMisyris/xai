package org.teipir.softeng.controllers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.teipir.softeng.SQLHelper;
import org.teipir.softeng.models.Dromologio;

public class DromologioController {
	
	private Connection conn;

	public DromologioController() {
		conn = SQLHelper.connectDB();
	}
	
	public boolean addDromologio(String anaxwrisi, String proorismos, String wra){
		String query = "INSERT INTO dromologia (anaxwrisi,proorismos,wra) VALUES('"+ anaxwrisi +"','" + proorismos + "','" + wra + "')";
		
		boolean result = SQLHelper.executeUpdate(query, conn);
		if(result == true){
			System.out.println("Dromologio Prostethike");
			return true;
		}
		else {
			System.out.println("Error Inserting Dromologio");
			return false;
		}
	}
	
	public List<Dromologio> getAllDromologia() {
		List<Dromologio> dromologia = new ArrayList<Dromologio>();
		String query = "SELECT anaxwrisi,proorismos,wra FROM dromologia";
		ResultSet resultSet = SQLHelper.executeQuery(query, conn);
		if (resultSet != null) {
			try {
				while (resultSet.next()) {
					String anaxwrisi = resultSet.getString("anaxwrisi");
					String proorismos = resultSet.getString("proorismos");
					String wra = resultSet.getString("wra");
					Dromologio drom = new Dromologio();
					drom.setAfiksi(anaxwrisi);
					drom.setProorismos(proorismos);
					drom.setWra(wra);
					dromologia.add(drom);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dromologia;
	} 
}
