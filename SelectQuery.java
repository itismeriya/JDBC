package com.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectQuery {

	public static void main(String[] args) {
		try(Connection conn=DatabaseConnection.getDbConnection())
		{
			Statement st=conn.createStatement();
			
			//select query
			String query="select * from employee1";
			ResultSet rs=st.executeQuery(query);
			while(rs.next()) {
				System.out.println("Employee Id: "+rs.getInt(1));//column index
				System.out.println("Name: "+rs.getString(2));
				System.out.println("Email: "+rs.getString("email"));
				System.out.println("Salary: "+rs.getInt("salary"));//column name
				System.out.println("===================================");
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
