package org.teipir.softeng.controllers;

import java.sql.*;

import org.teipir.softeng.SQLHelper;

public class UserController {
	
	Connection conn = null;
	Statement stmt = null;
	boolean validUser = false;
	
	private boolean checkUser(String username, String password, int usermode){
		
		conn = SQLHelper.connectDB();
		
		String query = "SELECT username, password, usermode FROM Users WHERE username='" + username +"' AND password='" + password + "' AND usermode=" +usermode;
		
		ResultSet result = SQLHelper.executeQuery(query, conn);
		
		try {
			if (result.isBeforeFirst() ) { // no empty query
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		SQLHelper.closeConn(conn);
		
		return false;
	}
	

	public boolean isValidTamias(String username, String password) {
		this.validUser = false;
		
		return checkUser(username,password,1);
	}

	public boolean isValidDiaxiristis(String username, String password) {
		this.validUser = false;
		
		return checkUser(username,password,999);
	}

}
