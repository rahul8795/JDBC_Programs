package com.cognizant.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcApp11 {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
			st = con.createStatement();
			boolean b = st.execute("update emp2 set esal = esal + 500 where esal < 10000");
			System.out.println(b);
			int rowCount = st.getUpdateCount();
			System.out.println(rowCount + " record updated successfully");
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				st.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
