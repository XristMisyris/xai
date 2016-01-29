package org.teipir.softeng;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLHelper {
	
	public static Connection connectDB(){
		Connection conn = null;
		
		try {
			
			// JDBC driver name and database URL
			final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
			final String DB_URL = "jdbc:mysql://localhost:3306/mixaniki?useUnicode=true&characterEncoding=utf8";
			//  Database credentials
			final String USER = "";
			final String PASS = "";
			Class.forName(JDBC_DRIVER);
			
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public static ResultSet executeQuery(String query, Connection conn){
		Statement stmt;
		
		if (conn != null) {
			try {
				stmt = conn.createStatement();
				stmt.execute(query);
				return stmt.getResultSet();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public static boolean executeUpdate(String query, Connection conn){
		Statement stmt;
		
		if (conn != null) {
			try {
				stmt = conn.createStatement();
				int result = stmt.executeUpdate(query);
				stmt.close();
				if (result > 0){
					return true;
				}
				else return false;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public static void closeConn(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
