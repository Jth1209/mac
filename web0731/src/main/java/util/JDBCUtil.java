package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtil {
	public static Connection conn;
	
	public static Connection getConnection() {//데이터베이스 연결 메소드
		String URL = "jdbc:mysql://localhost:3306/spring5fs";
		String id = "root";
		String pw = "k1030112233!@#";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(URL,id,pw);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void close(PreparedStatement stmt, Connection con) {//사용 후 닫아주기
		try {
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		try {
			stmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rs, PreparedStatement pstmt, Connection con) {//사용 후 닫아주기
		try {
			rs.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		try {
			pstmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}

	}
}
