package com.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUts {
	
	static Connection connection = null;
	private ConnectionUts() throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
	}
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		if (connection == null) {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb?","root","dev@0920");
			
		}
		
		return connection;
	}

}
