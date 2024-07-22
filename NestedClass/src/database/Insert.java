package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Insert {

	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		String URL = "jdbc:mysql://localhost:3306/spring5fs";
		Scanner sc = new Scanner(System.in);
		
		System.out.print("부서 번호: ");
		int dID = Integer.parseInt(sc.nextLine());
		
		System.out.print("부서 이름: ");
		String dName = sc.nextLine();
		
		System.out.print("부서 위치: ");
		String dLoc = sc.nextLine();
		
		String insert = String.format("insert into dept(deptno,dname,loc) values (%d,'%s','%s');",dID,dName,dLoc);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL,"root","k1030112233!@#");
			stmt = con.createStatement();
			stmt.executeUpdate(insert);
			System.out.println("테이블 데이터 입력 완료");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
