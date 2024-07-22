package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Create {

	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		
		String URL = "jdbc:mysql://localhost:3306/spring5fs";
		
		String create = "create table dept ("+
				"deptno int primary key,"+
				"dname varchar(14),"+
				"loc varchar(13));";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL,"root","k1030112233!@#");
			stmt = con.createStatement();
			stmt.executeUpdate(create);
			System.out.println("테이블 생성 완료");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
