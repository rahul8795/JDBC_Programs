package com.cognizant.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcApp10 {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
			
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
			st = con.createStatement();
			boolean b = st.execute("select *from emp2");
			System.out.println(b);
			rs = st.getResultSet();
			System.out.println("ENO\tENAME\tESAL\tEADDR");
			System.out.println("--------------------------------");
			while(rs.next()){
				System.out.print(rs.getInt("eno")+"\t");
				System.out.print(rs.getString("ename")+"\t");
				System.out.print(rs.getFloat("esal")+"\t");
				System.out.print(rs.getString("eaddr")+"\n");			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
