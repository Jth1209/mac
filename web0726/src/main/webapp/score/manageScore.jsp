<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
request.setCharacterEncoding("UTF-8");

String num3 = "";
String name3 = "";
String kor3 = "";
String eng3 = "";
String math3 = "";

String num = request.getParameter("num");
String name = request.getParameter("name");
String kor = request.getParameter("kor");
String eng = request.getParameter("eng");
String math = request.getParameter("math");

//String update = request.getParameter("update");
String find = request.getParameter("find");
String delete = request.getParameter("delete");

Connection conn = null;
PreparedStatement pstmt = null;
String URL = "jdbc:mysql://localhost:3306/spring5fs";

String sql = "";
Class.forName("com.mysql.cj.jdbc.Driver");
conn = DriverManager.getConnection(URL,"root","k1030112233!@#");

if(num != null){
	sql = "select count(*) from score where num = ?";
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1,num);
	ResultSet rs = pstmt.executeQuery();
	rs.next();
	int cnt = rs.getInt(1);
	if(cnt == 1){
		sql = "update score set name = ?,kor = ?, eng = ? ,math = ? where num = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,name);
		pstmt.setString(2,kor);
		pstmt.setString(3,eng);
		pstmt.setString(4,math);
		pstmt.setString(5,num);
		pstmt.executeUpdate();
	}else{
		sql = "insert into (num, name, kor, eng, math) values (?,?,?,?,?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,num);
		pstmt.setString(2,name);
		pstmt.setString(3,kor);
		pstmt.setString(4,eng);
		pstmt.setString(5,math);
		pstmt.executeUpdate();
	}
}
if(find != null){
	sql = "select * from score where = ? ";
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1,find);
	ResultSet rs = pstmt.executeQuery();
	rs.next();
	num3 = rs.getString("num");
	name3 = rs.getString("name");
	kor3 = rs.getString("kor");
	eng3 = rs.getString("eng");
	math3 = rs.getString("math");
	
}
if(delete != null){
	sql = "delete from score where num = ?";
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1,delete);
	pstmt.executeUpdate();
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 성적 관리 프로그램</title>
</head>
<body>
<form>
학번 : <input name = "num" value=<%=num3 %>><br>
이름 : <input name = "name" value=<%=name3 %>><br>
국어 : <input name = "kor" value=<%=kor3 %>><br>
영어 : <input name = "eng" value=<%=eng3 %>><br>
수학 : <input name = "math" value=<%=math3 %>><br>
<input type = "submit" value = "제출">
</form>
<table border = "1">
<caption>학생 성적 테이블</caption>
<tr bgcolor = "#99ffff">
<td>학번</td><td>이름</td>
<td>국어</td><td>영어</td><td>수학</td>
<td>총합</td><td>평균</td><td>삭제</td>
</tr>
<%
sql = "select * from score";
pstmt = conn.prepareStatement(sql);
ResultSet rs = pstmt.executeQuery();
while(rs.next()){
	String num1 = rs.getString("num");
	String name1 = rs.getString("name");
	String kor1 = rs.getString("kor");
	String eng1 = rs.getString("eng");
	String math1 = rs.getString("math");
	int sum = Integer.parseInt(kor1) + Integer.parseInt(eng1)+Integer.parseInt(math1);
	double avg = (double) sum/3;
%>

<tr>
<td><a href ="?find=<%= num1%>"><%= num1 %></a></td><td><%= name1 %></td>
<td><%= kor1 %></td><td><%= eng1 %></td><td><%= math1 %></td>
<td><%= sum %></td><td><%= avg %></td><td><button type = "button" onclick = "location.href='?delete=<%= num1 %>'">삭제</button></td>
</tr>
<%
}
%>
</table>
</body>
</html>