
<%@page import="login.DTO"%>
<%@page import="login.DAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");

String id = request.getParameter("id");
String password = request.getParameter("password");
String name = request.getParameter("name");

DAO dao = new DAO();
DTO dto = new DTO(id,password,name);
dao.insertUser(dto);

out.println("<script type='text/javascript'>");
out.println("alert('회원가입 성공');");
out.println("window.location.href = 'home.jsp';");
out.println("</script>");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>

</body>
</html>