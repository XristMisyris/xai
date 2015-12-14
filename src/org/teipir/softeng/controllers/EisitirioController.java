package org.teipir.softeng.controllers;

import java.sql.Connection;
import java.util.Date;

import org.teipir.softeng.SQLHelper;
import org.teipir.softeng.views.EisitirioFrame;

public class EisitirioController {
	
	private Connection conn;

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

}
