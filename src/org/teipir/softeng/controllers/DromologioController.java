package org.teipir.softeng.controllers;

import java.sql.Connection;
import java.util.List;

import org.teipir.softeng.SQLHelper;
import org.teipir.softeng.models.Dromologio;

public class DromologioController {
	
	private Connection conn;// need test for static

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
	
	public List<Dromologio> getDromologia(){
		return null;
	}
}
