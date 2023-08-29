package com.jdbc;
import java.sql.Connection;
import java.sql.Statement;
public class InsertRecordDoctor {
	public static void main(String[] args) {
		try(Connection con=DatabaseConnection.getDbConnection();)
		{
			//create statement
			Statement st=con.createStatement();
		
			//insert query
			String insert="insert into doctor values(102,'Deesha','ENT','9374077298',10),"
					+"(103,'Bhavna','CHILD','8395038837',30)";
			int row=st.executeUpdate(insert);
			System.out.println(row+" records inserted successfully ");
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}
