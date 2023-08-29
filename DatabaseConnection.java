package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	static Connection con=null;
	//this method will create a connection with the database
	public static Connection getDbConnection()
	{
		try {
			//registering the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//establishing the connection
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/anpc5257","root","root");
		}
		catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return con;
	}
} 




