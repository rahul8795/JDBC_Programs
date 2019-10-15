package com.cognizant.jdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcApp05 {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		BufferedReader br = null;
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
			st = con.createStatement();
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Bonus Amount : ");
			int bonus_Amt = Integer.parseInt(br.readLine());
			System.out.println("Salary Range : ");
			float sal_Range = Float.parseFloat(br.readLine());
			int rowCount = st.executeUpdate("update emp2 set esal = esal + "+bonus_Amt+" where esal < "+sal_Range);
			System.out.println("No of record updated : "+rowCount);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				br.close();
				st.close();
				con.close();
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
	}

}
