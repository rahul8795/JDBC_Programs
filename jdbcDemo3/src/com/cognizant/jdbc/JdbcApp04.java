package com.cognizant.jdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcApp04 {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		BufferedReader br = null;
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
			st = con.createStatement();
			br = new BufferedReader(new InputStreamReader(System.in));
			while(true){
				System.out.println("Employee Number : ");
				int eno = Integer.parseInt(br.readLine());
				System.out.println("Employee Name : ");
				String ename = br.readLine();
				System.out.println("Employee Salary : ");
				float esal = Float.parseFloat(br.readLine());
				System.out.println("Employee Address : ");
				String eaddr = br.readLine();
				
				int rowCount = st.executeUpdate("insert into emp2 values("+eno+",'"+ename+"',"+esal+",'"+eaddr+"')");
				if(rowCount == 1){
					System.out.println("Employee "+eno+" Inserted Successfully");
				}else{
					System.out.println("Employee Insertion Failure");
				}
				System.out.println("One More Employee?[Yes/No] : ");
				String option = br.readLine();
				if(option.equalsIgnoreCase("yes")){
					continue;
				}else{
					break;
				}
			}
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
