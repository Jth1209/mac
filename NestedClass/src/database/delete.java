package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class delete {

	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		String URL = "jdbc:mysql://localhost:3306/spring5fs";
		Scanner sc = new Scanner(System.in);
		
		
		String drop = String.format("drop table dept;");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL,"root","k1030112233!@#");
			stmt = con.createStatement();
			stmt.executeUpdate(drop);
			System.out.println("테이블 데이터 입력 완료");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
