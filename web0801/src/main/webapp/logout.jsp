<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
Cookie[] cookies = request.getCookies();

if(cookies != null){
	for(Cookie cookie : cookies){
		if(cookie.getName().equals("username")){
			cookie.setMaxAge(0);
			response.addCookie(cookie);
			break;
		}
	}
}

response.sendRedirect("home.jsp");
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