package item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.JDBCUtil;

public class itemDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	private String selectItem = "select * from item";
	private String selectOne = "select * from item where iname = ?";
	private String insertUser = "insert into useritem (iname,num) values (?,1)";
	private String selectUserItem = "select * from useritem";
	private String selectItem2 = "select * from useritem where iname = ?";
	private String updateNum = "update useritem set num = num + 1 where iname = ?";
	private String updateNum2= "update useritem set num = num - 1 where iname = ?";
	private String userCheck = "select count(*) from useritem where iname = ?";
	private String deleteItem = "delete from useritem where iname = ?";
	
	public List<itemDTO> selectItem() {
		conn = JDBCUtil.getConnection();
		List<itemDTO> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(selectItem);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new itemDTO(rs.getString("iname"),rs.getInt("price")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		return list;
	}
	
	public itemDTO selectOne(String iname) {
		conn = JDBCUtil.getConnection();
		itemDTO dto = null;
		try {
			pstmt = conn.prepareStatement(selectOne);
			pstmt.setString(1, iname);
			rs = pstmt.executeQuery();
			if(rs.next()){
				dto = new itemDTO(rs.getString("iname"),rs.getInt("price"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		return dto;
	}
	
	public userDTO selectOne2(String iname) {
		conn = JDBCUtil.getConnection();
		userDTO dto = null;
		try {
			pstmt = conn.prepareStatement(selectItem2);
			pstmt.setString(1, iname);
			rs = pstmt.executeQuery();
			if(rs.next()){
				dto = new userDTO(rs.getString("iname"),rs.getInt("num"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		return dto;
	}
	
	public void insertUser(String iname) {
		conn = JDBCUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(insertUser);
			pstmt.setString(1,iname);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtil.close(pstmt, conn);
		}
		
	}
	
	public List<userDTO> selectUserItem() {
		conn = JDBCUtil.getConnection();
		List<userDTO> dto = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(selectUserItem);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				dto.add(new userDTO(rs.getString("iname"),rs.getInt("num")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		return dto;
	}
	
	public void updateNum(String iname) {
		conn = JDBCUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(updateNum);
			pstmt.setString(1, iname);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtil.close(pstmt, conn);
		}
		
	}
	public void updateNum2(String iname) {
		conn = JDBCUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(updateNum2);
			pstmt.setString(1, iname);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtil.close(pstmt, conn);
		}
		
	}
	
	public int selectUser(String iname) {
		conn = JDBCUtil.getConnection();
		int check = 0;
		try {
			pstmt = conn.prepareStatement(userCheck);
			pstmt.setString(1,iname);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				check = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		return check;
	}
	
	public void deleteItem(String iname) {
		conn = JDBCUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(deleteItem);
			pstmt.setString(1, iname);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtil.close(pstmt, conn);
		}
	}
}
