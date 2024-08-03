<%@page import="board.DAO"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");

String title = request.getParameter("title");
String writer = request.getParameter("writer");
String content = request.getParameter("content");
String num = request.getParameter("num");

DAO dao = new DAO();

dao.updateAll(num, writer, title, content);

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