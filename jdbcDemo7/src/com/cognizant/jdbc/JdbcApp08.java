package com.cognizant.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcApp08 {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
			st = con.createStatement();
			int rowCount1 = st.executeUpdate("create table emp3(eno number(5),ename varchar2(10))");
            int rowCount2 = st.executeUpdate("drop table emp3");
            System.out.println(rowCount1);
            System.out.println(rowCount2);
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
