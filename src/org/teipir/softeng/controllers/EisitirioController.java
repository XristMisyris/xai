package org.teipir.softeng.controllers;

import java.sql.Connection;
import java.util.Date;

import org.teipir.softeng.SQLHelper;

public class EisitirioController {
	
	private Connection conn;

	public EisitirioController() {
		conn = SQLHelper.connectDB();
	}
	
	public boolean addEisitirio(String anaxwrisi, String proorismos, Date date,int thesi, int tiposEisitiriou, double timi ){
		return false;
	}

}
