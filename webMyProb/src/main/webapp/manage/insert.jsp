<%@page import="board.DAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");

String title = request.getParameter("title");
String writer = request.getParameter("writer");
String content = request.getParameter("content");


DAO dao = new DAO();
dao.insert(writer,title,content);

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