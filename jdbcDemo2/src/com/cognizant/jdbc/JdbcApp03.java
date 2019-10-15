package com.cognizant.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcApp03 {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		BufferedReader br = null;
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
			st = con.createStatement();
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Table Name : ");
			String tname = br.readLine();
			String primaryKeyCols = "";
			int primaryKeyColumnsCount = 0;
			String query = "create table "+tname+"(";
			while(true){
				System.out.println("Column Name  : ");
				String colName = br.readLine();
				System.out.println("Column Type : ");
				String colType = br.readLine();
				System.out.println("Column Size : ");
				int colSize = Integer.parseInt(br.readLine());
				System.out.println("Is it primary key Column[Yes/No]? : ");
				String primary_Key_Option = br.readLine();
				if(primary_Key_Option.equalsIgnoreCase("Yes")){
					if(primaryKeyColumnsCount == 0)
					primaryKeyCols = primaryKeyCols + colName;
					primaryKeyColumnsCount += 1;
				}else{
					primaryKeyCols = primaryKeyCols + ","+ colName;
				}
				query = query + colName + " " + colType + "(" + colSize + ")";
				System.out.println("One more column?[Yse/No]");
				String columnOption = br.readLine();
				if(columnOption.equalsIgnoreCase("Yes")){
					query = query + ",";
					continue;
				}else{
					query = query + ", primary key(" + primaryKeyCols + "))";
					break;
				}
			}
			st.executeUpdate(query);
			System.out.println("Table "+tname+" Is created Successfully");
		}catch(Exception e){
			System.out.println("Table creation Failure");
			e.printStackTrace();
		}finally{
			try{
				br.close();
				st.close();
				con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}

	}

}
