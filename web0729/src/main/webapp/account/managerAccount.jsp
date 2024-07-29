<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
Connection conn = null;
PreparedStatement pstmt = null;
String URL = "jdbc:mysql://localhost:3306/spring5fs";
String id = "root";
String pw = "k1030112233!@#";

Class.forName("com.mysql.cj.jdbc.Driver");
conn = DriverManager.getConnection(URL,id,pw);

String sqlTmp = "";
String deptnoTmp = ""; 
String dnameTmp = ""; 
String locTmp = ""; 

String deptno = request.getParameter("deptno");
String dname = request.getParameter("dname");
String loc = request.getParameter("loc");
String find = request.getParameter("find");
String delete = request.getParameter("delete");

if(deptno != null) {
	sqlTmp = "select count(*) from dept where deptno = ?";
	pstmt = conn.prepareStatement(sqlTmp);
	pstmt.setString(1,deptno);
	ResultSet rs = pstmt.executeQuery();
	rs.next();
	int cnt = rs.getInt(1);
	if(cnt == 1) {
		sqlTmp = "update dept set dname = ?, loc = ? where dptno = ?";
		pstmt = conn.prepareStatement(sqlTmp);
		pstmt.setString(1,dname);
		pstmt.setString(2,loc);
		pstmt.setString(3,deptno);
		pstmt.executeUpdate();
	}else{
		sqlTmp = "insert into dept (deptno,dname,loc) values (?,?,?)";
		pstmt = conn.prepareStatement(sqlTmp);
		pstmt.setString(1,deptno);
		pstmt.setString(2,dname);
		pstmt.setString(3,loc);
		pstmt.executeUpdate();
	}
}
if(find != null){
	sqlTmp = "select * from dept where deptno = ?";
	pstmt = conn.prepareStatement(sqlTmp);
	pstmt.setString(1,find);
	ResultSet rs = pstmt.executeQuery();
	rs.next();
	deptnoTmp = rs.getString("deptno");
	dnameTmp = rs.getString("dname");
	locTmp = rs.getString("loc");
}

if(delete != null){
	sqlTmp = "delete from dept where deptno = ?";
	pstmt = conn.prepareStatement(sqlTmp);
	pstmt.setString(1,delete);
	pstmt.executeUpdate();
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	 <style>
        table { width: 600px; text-align: left; }
        th    { width: 40px; background-color: #6699ff; }
   		button{ background-color: #cccccc}
    </style>	
<title>부서 테이블 정보 관리 프로그램</title>
</head>
<body>
<form>
부서 번호 : <input type = "text" name ="deptno" value = "<%=deptnoTmp %>"><p/>
부서 이름 : <input type = "text" name ="dname" value = "<%=dnameTmp %>"><p/>
부서 지역 : <input type = "text" name ="loc" value = "<%=locTmp %>"><p/>
<input type = "submit" value = "완료">
</form>
<table border = "1">
	<tr>
	<td>부서 번호</td><td>부서 이름</td><td>부서 지역</td><td>삭제</td>
	</tr>
<%
sqlTmp = "select * from dept";
pstmt = conn.prepareStatement(sqlTmp);
ResultSet rs = pstmt.executeQuery();

while(rs.next()){
	deptnoTmp = rs.getString("deptno");
	dnameTmp = rs.getString("dname");
	locTmp = rs.getString("loc");
%>
	<tr>
	<td><a href ="?find=<%=deptnoTmp %>"><%=deptnoTmp %></a></td><td><%=dnameTmp %></td><td><%=locTmp %></td>
	<td><button type = "button" onclick = "location.href ='?delete=<%=deptnoTmp %>'">삭제</button></td>
	</tr>
<%
}
%>
</table>
</body>
</html>