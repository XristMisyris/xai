package org.teipir.softeng.controllers;

import java.sql.*;

public class UserController {
	
	Connection conn = null;
	Statement stmt = null;
	boolean validUser = false;
	
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://83.212.118.22:3306/mixaniki";
	//  Database credentials
	static final String USER = "sponz";
	static final String PASS = "";
	
	private boolean checkUser(String username, String password, int usermode){
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			
			
			try{
				stmt = conn.createStatement();
				
				String Query = "SELECT username, password, usermode FROM Users WHERE username='" + username +"' AND password='" + password + "' AND usermode=" +usermode;
				ResultSet rs = stmt.executeQuery(Query);
				
				while(rs.next()){
					this.validUser = true;
				}
				
				rs.close();
				stmt.close();
				conn.close();
				
				if (validUser == true){
					return true;
				}

			}catch(SQLException e){
				System.out.println("ERROR");
			}
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
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
