<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String local = request.getParameter("local");
Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;
String URL = "jdbc:mysql://localhost:3306/spring5fs";

String sql = "select * from dept where loc = ?";

Class.forName("com.mysql.cj.jdbc.Driver");
conn = DriverManager.getConnection(URL,"root","k1030112233!@#");
pstmt = conn.prepareStatement(sql);
pstmt.setString(1,local);
rs = pstmt.executeQuery();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form>
지역 : <input type = "text" name = "local">
<input type = "submit" value = "Result"><p/>
</form>
<table border = "1">
<tr>
<td colspan = 3><h1>Dept Table</h1></td>
</tr>
<%
	while(rs.next()){
		String deptno = rs.getString("deptno");
		String dname = rs.getString("dname");
		String loc = rs.getString("loc");
%>
	<tr>
	<td><%=deptno %></td><td><%=dname %></td><td><%=loc %></td>
	</tr>	
<%
	}
%>
</table>
</body>
</html>