<%@page import="login.DTO"%>
<%@page import="login.DAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Process</title>
</head>
<body>
<%
request.setCharacterEncoding("UTF-8");
    // Sample user data
    String id = request.getParameter("username");
    String pw = request.getParameter("password");
	
    DAO dao = new DAO();
    DTO dto = dao.findId(id, pw);
    System.out.println(dto);
    
    if (dto != null) {
     	// 로그인 성공, 쿠키 설정
        out.println("<script type='text/javascript'>");
        out.println("alert('환영합니다, " + dto.getName() + "!');");
        out.println("window.location.href = 'home.jsp';");
        out.println("</script>");
        session.setAttribute("id", dto.getId());
        session.setAttribute("name", dto.getName());
    } else {
    	out.println("<script type='text/javascript'>");
        out.println("alert('로그인 실패!');");
        out.println("window.location.href = 'login.jsp';");
        out.println("</script>");
    }

%>
</body>
</html>