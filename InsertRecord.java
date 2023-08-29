package com.jdbc;

import java.sql.Connection;
import java.sql.Statement;

public class InsertRecord {

	public static void main(String[] args) {
		try(Connection con=DatabaseConnection.getDbConnection();)
		{
			//create statement
			Statement st=con.createStatement();
		
			//insert query
			String insert="insert into employee1 values(102,'Deesha','deesha@gmail.com',30000),"
			+"(103,'Bhavna','bhavna@gmail.com',30000)";
			int row=st.executeUpdate(insert);
			System.out.println(row+" records inserted successfully ");
		}
		catch(Exception e){
			System.out.println(e);
		}
	}

}
