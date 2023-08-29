package com.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SelectQueryWithPs {

	public static void main(String[] args) {
		try(Connection con = DatabaseConnection.getDbConnection(); Scanner sc = new Scanner(System.in))
		{
			//we write like a normal sql query
			String query = "select * from employee2 where salary > ? limit 1";
			//create prepared statement
			PreparedStatement pst = con.prepareStatement(query);
			
			System.out.println("enter the employee sal to search: ");
			
			//Fetching the empId from the user from the console.
			int empSal = sc.nextInt();
			
			pst.setInt(1, empSal);//Parameter index != Column index
			//Parameter index depends on the sequence of ? marks
			
			ResultSet rs = pst.executeQuery();
			
			//iterating rs to get the sets.
			while(rs.next())
			{
				System.out.println("Employee id "+rs.getInt(1));//passing column Index
				System.out.println("Name: "+rs.getString(2));
				System.out.println("email: "+rs.getString(3));//passing column name
				System.out.println("salary: "+rs.getInt(4));
				System.out.println("===============================");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}