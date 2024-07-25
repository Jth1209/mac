package Jang;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Update
 */
@WebServlet("/select.do")
public class Select extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Select() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String loc = request.getParameter("loc");
		//아래 두개의 코드는 서블렛 만들자 마자 작성할 것(doGet 메소드 내부에다가 써야함
		response.setContentType("text/html;charset=UTF8");//한글 안깨지고 나오게 해주는 코드
		PrintWriter out = response.getWriter();//out.println 쓸 수 있게 해주는 코드
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String URL = "jdbc:mysql://localhost:3306/spring5fs";
		String sql = "select deptno,dname,loc from dept where loc = ?;";
		String id = "root";
		String pw = "k1030112233!@#";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String find = String.format("....Driver founded!<br>");//웹 사이트에 직접 보이게 하고싶으면 이렇게 써야함 아직까진
			out.println(find);
			conn = DriverManager.getConnection(URL,id,pw);
			String consuc = String.format("....Connection Successful!<br><br>");
			out.println(consuc);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, loc);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int cnum = rs.getInt(1);
				String cname = rs.getString(2);
				String cloc = rs.getString(3);
				String result = String.format("%d , %s , %s <br>", cnum,cname,cloc);
				out.println(result);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
