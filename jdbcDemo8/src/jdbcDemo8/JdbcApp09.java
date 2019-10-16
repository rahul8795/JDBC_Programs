package jdbcDemo8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class JdbcApp09 {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
			st = con.createStatement();
			rs = st.executeQuery("select *from emp2");
			System.out.println(rs);
			System.out.println("ENO\tENAME\tESAL\tEAADDR");
			System.out.println("------------------------------");
			while(rs.next()){
				System.out.print(rs.getInt(1)+"\t");
				System.out.print(rs.getString(2)+"\t");
				System.out.print(rs.getFloat(3)+"\t");
				System.out.print(rs.getString(4)+"\n");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				st.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}
