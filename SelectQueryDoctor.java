package com.jdbc;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
public class SelectQueryDoctor {
	public static void main(String[] args) {
		try(Connection conn=DatabaseConnection.getDbConnection())
		{
			Statement st=conn.createStatement();
			
			//select query
			String query="select * from doctor";
			ResultSet rs=st.executeQuery(query);
			while(rs.next()) {
				System.out.println("Doctor Id: "+rs.getInt(1));
				System.out.println("Doctor Name: "+rs.getString(2));
				System.out.println("Speciality: "+rs.getString("speciality"));
				System.out.println("Contact no: "+rs.getString("contact_no"));
				System.out.println("Cabin no: "+rs.getInt(5));
				System.out.println("===================================");
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
