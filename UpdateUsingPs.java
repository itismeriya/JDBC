package com.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateUsingPs {

	public static void main(String[] args) {
		try(Connection con = DatabaseConnection.getDbConnection(); Scanner sc = new Scanner(System.in))
		{
			//updating the details
			String up = "update employee2 set salary= ? where id = ?";
			PreparedStatement pst = con.prepareStatement(up);
			
			System.out.println("Enter employee id: ");
			int empId = sc.nextInt();
			
			System.out.println("Enter updated employee salary: ");
			int empSal = sc.nextInt();
			
			pst.setInt(2, empId);
			pst.setInt(1, empSal);
			
			int row = pst.executeUpdate();
			
			System.out.println(row+" records inserted succesfully");
			
			//printing updated details
			String query ="select * from employee2 where id = "+empId;
			pst = con.prepareStatement(query);
			
			
			ResultSet rs = pst.executeQuery();
			
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