package com.tech.blog.helper;

import java.sql.*;

public class ConnectionProvider {
	
	private static Connection conn;
	
	public static Connection getConnection() {
		
		try {
			if(conn == null) {
				// Driver class load
				Class.forName("com.mysql.jdbc.Driver");
				
				// Create a connection
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/techblog", "root", "root");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
}
