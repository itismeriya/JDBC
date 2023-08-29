package com.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertusingPs {

	public static void main(String[] args) {
		try(Connection con = DatabaseConnection.getDbConnection(); Scanner sc = new Scanner(System.in))
		{
			
			String insert = "insert into employee2 values(?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(insert);
			
			System.out.println("Enter employee id: ");
			int empId = sc.nextInt();
			
			sc.nextLine();
			System.out.println("Enter employee name: ");
			String empName = sc.nextLine();
			
			System.out.println("Enter employee email: ");
			String empEmail = sc.nextLine();
			
			System.out.println("Enter employee salary: ");
			int empSal = sc.nextInt();
			
			
			pst.setInt(1, empId);
			pst.setString(2, empName);
			pst.setString(3, empEmail);
			pst.setInt(4, empSal);
			
			int row = pst.executeUpdate();
			
			System.out.println(row+" records inserted succesfully");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}