package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Select {

	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String select = String.format("select * from dept");
		
		String URL = "jdbc:mysql://localhost:3306/spring5fs";
		
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL,"root","k1030112233!@#");
			stmt = con.createStatement();
			rs = stmt.executeQuery(select);
			ResultSetMetaData rsmd = rs.getMetaData();
			int length = rsmd.getColumnCount();
			while(rs.next()) {
				for(int i = 1; i<length ; i++) {
					System.out.print(String.format("%s ,",rs.getString(i)));
				}
				System.out.println(String.format("%s ", rs.getString(length)));
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
