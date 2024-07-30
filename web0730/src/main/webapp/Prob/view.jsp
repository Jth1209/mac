<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Connection conn = null;
PreparedStatement pstmt = null;

request.setCharacterEncoding("UTF-8");

String URL = "jdbc:mysql://localhost:3306/spring5fs";
String id = "root";
String pw = "k1030112233!@#";

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

sqlTmp = "update board set hits = hits + 1 where num = ?";
pstmt = conn.prepareStatement(sqlTmp);
pstmt.setString(1,num);
pstmt.executeUpdate();

sqlTmp = "select * from board where num = ?";
pstmt = conn.prepareStatement(sqlTmp);
pstmt.setString(1,num);
ResultSet rs = pstmt.executeQuery();
rs.next();
numT = rs.getString("num");
writerT = rs.getString("writer");
titleT = rs.getString("title");
regtimeT = rs.getString("regtime");
contentT = rs.getString("content");
hitsT = rs.getString("hits");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<style>
        table { width:680px; text-align:center; }
        th    { width:100px; background-color:cyan; }
        td    { text-align:left; border:1px solid gray; }
    </style>
<title>Insert title here</title>
</head>
<body>
<table>
    <tr>
        <th>제목</th>
        <td><%=titleT %></td>
    </tr>
    <tr>
        <th>작성자</th>
        <td><%=writerT %></td>
    </tr>
    <tr>
        <th>작성일시</th>
        <td><%=regtimeT %></td>
    </tr>
    <tr>
        <th>조회수</th>
        <td><%=hitsT %></td>
    </tr>
    <tr>
        <th>내용</th>
        <td><%=contentT %></td>
    </tr>
</table>

<br>
<input type="button" value="목록보기" onclick="location.href='list.jsp'">
<input type="button" value="수정"
       onclick="location.href='rework.jsp?num=<%=num %>'">
<input type="button" value="삭제"
       onclick="location.href='delete.jsp?num=<%=num %>'">

</body>
</html>