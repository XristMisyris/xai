package org.teipir.softeng.controllers;

import java.sql.Connection;

import org.teipir.softeng.SQLHelper;

public class AnakoinwseisController {
	
	private Connection conn;
	
	public AnakoinwseisController() {
		conn = SQLHelper.connectDB();
	}
	
	public boolean addAnakoinwsi(String title, String sxolio){
		String query = "INSERT INTO anakoinwseis (title,sxolio) VALUES('"+ title +"','" + sxolio + "')";
		
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

}
