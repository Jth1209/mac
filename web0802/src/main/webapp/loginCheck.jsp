<%@page import="util.Cookies"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
Cookies cookies = new Cookies(request);

if(cookies.getValue("AUTH") != null){
	

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
현재 로그인된 아이디는 <%=cookies.getValue("AUTH") %> 입니다.
</body>
</html>
<%
} else {
%>
<body>
저장된 아이디가 없습니다.
</body>
<%
}
%>