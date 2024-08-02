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
	
	DTO dto;
	
	private String FIND_ID = "select * from member where id = ? and pw = ?";
	private String FIND_ID2 = "select * from member where id = ?";
	private String INSERT_USER = "insert into member (id,pw,name) values (?,?,?)";
	private String UPDATE_INFO = "update member set pw = ? , name = ? where id = ?";
	
	public DTO findId(String id , String pw) {
		conn = JDBCUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(FIND_ID);
			pstmt.setString(1,id);
			pstmt.setString(2,pw);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new DTO(rs.getString("id"),rs.getString("pw"),rs.getString("name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dto;
	}
	
	public DTO findId(String id) {
		conn = JDBCUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(FIND_ID2);
			pstmt.setString(1,id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new DTO(rs.getString("id"),rs.getString("pw"),rs.getString("name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dto;
	}
	
	public void insertUser(DTO dto) {
		conn = JDBCUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(INSERT_USER);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getName());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void updateInfo(String pw,String name , String id) {
		conn = JDBCUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(UPDATE_INFO);
			pstmt.setString(1,pw);
			pstmt.setString(2,name);
			pstmt.setString(3,id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
