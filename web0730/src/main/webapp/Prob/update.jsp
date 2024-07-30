<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
Connection conn = null;
PreparedStatement pstmt = null;

String URL = "jdbc:mysql://localhost:3306/spring5fs";
String id = "root";
String pw = "k1030112233!@#";

String title = request.getParameter("title");
String writer = request.getParameter("writer");
String content = request.getParameter("content");
String num = request.getParameter("num");

String sqlTmp = "";
String numT = "";
String writerT = "";
String titleT = "";
String contentT = "";
String regtimeT = "";
String hitsT = "";

Class.forName("com.mysql.cj.jdbc.Driver");
conn = DriverManager.getConnection(URL,id,pw);

sqlTmp = "update board set title = ?, writer = ?, content = ?, regtime = now(), hits = 0 where num = ?";
pstmt = conn.prepareStatement(sqlTmp);
pstmt.setString(1,title);
pstmt.setString(2,writer);
pstmt.setString(3,content);
pstmt.setString(4,num);
pstmt.executeUpdate();

response.sendRedirect("list.jsp");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>