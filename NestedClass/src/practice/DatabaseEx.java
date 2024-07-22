package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;


public class DatabaseEx {
	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		String URL = "jdbc:mysql://localhost:3306/spring5fs";
		String id = "root";
		String pw = "k1030112233!@#";
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL,id,pw);
			stmt = con.createStatement();
			System.out.println("접속 성공");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

