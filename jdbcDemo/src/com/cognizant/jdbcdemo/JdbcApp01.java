package com.cognizant.jdbcdemo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcApp01 {

	public static void main(String[] args) throws Exception {
		// Load and register driver
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		
		//Establish Connection between Java Application and Database
		Connection con = DriverManager.getConnection("jdbc:odbc:nag","system","rahul");
		
		//Create statement
		Statement st = con.createStatement();
		
		// Create BufferedReader and Take Table name as dynamic input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Table Name  :" );
		String tname = br.readLine();
		
		// Write and Execute SQL Query
		String query = "create table "+tname+"(ENO number(3) primary key,ENAME varchar2(10), ESAL float(5),EADDR varchar2(10))";
		st.executeUpdate(query);
		System.out.println("Table "+tname+" Created Successfully");
		
		
		//Close the resources
		con.close();
		st.close();
	}

}
