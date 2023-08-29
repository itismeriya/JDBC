package com.jdbc;

import java.sql.Connection;
import java.sql.Statement;

public class CreateQuery {

	public static void main(String[] args) {
		//try with resource
		try(Connection conn=DatabaseConnection.getDbConnection();)
		{
		//create statement
		Statement st= conn.createStatement();
		//write/create query
		String sql="create table employee1(id int primary key,name varchar(30) not null,"+"email varchar(50) not null unique,salary int not null)";
		//executing the sql query
		int row=st.executeUpdate(sql);
		System.out.println(row+"Table created successfully");
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
