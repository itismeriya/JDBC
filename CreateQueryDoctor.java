package com.jdbc;
import java.sql.Connection;
import java.sql.Statement;
public class CreateQueryDoctor {
	public static void main(String[] args) {
		//try with resource
		try(Connection conn=DatabaseConnection.getDbConnection();)
		{
		//create statement
		Statement st= conn.createStatement();
		//write/create query
		String sql="create table doctor(doctor_id int primary key,doctor_name varchar(20),"+"speciality varchar(30) not null ,contact_no varchar(10) not null,cabin_no int)";
		//executing the sql query
		int row=st.executeUpdate(sql);
		System.out.println(row+"Table created successfully");
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
