<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
session.invalidate();

out.println("<script type='text/javascript'>");
out.println("alert('로그아웃 성공');");
out.println("window.location.href = 'home.jsp';");
out.println("</script>");
%>
</body>
</html>