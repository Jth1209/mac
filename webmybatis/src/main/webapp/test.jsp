<%@page import="Login.LoginDTO"%>
<%@page import="Login.LoginDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
LoginDAO dao = new LoginDAO();
LoginDTO dto = new LoginDTO("xkgs","123","test");
int cnt = dao.searchUser(dto);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%= cnt %>
</body>
</html>