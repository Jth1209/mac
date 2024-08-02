package login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.JDBCUtil;

public class DAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public boolean check;
	
	private String FIND_ID = "select id,pw from user";
	private String INSERT_USER = "insert into user (id,pw,email) values (?,?,?)";
	
	public boolean findId(String id , String pw) {
		conn = JDBCUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(FIND_ID);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				if(id.equals(rs.getString("id")) && pw.equals(rs.getString("pw"))) {
					check = true;
					break;
				}else {
					check = false;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return check;
	}
	
	public void insertUser(DTO dto) {
		conn = JDBCUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(INSERT_USER);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getEmail());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
