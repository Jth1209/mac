<%@page import="member.DAO"%>
<%@page import="util.Cookies"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
request.setCharacterEncoding("UTF-8");
String id = request.getParameter("id");
String pw = request.getParameter("password");

DAO dao = new DAO();

if(dao.findId(id,pw) == true){
	
	response.addCookie(
		Cookies.createCookie("AUTH",id,"/",-1)
		);


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
로그인 쿠키 생성 
</body>
</html>
<%
}else{
%>
<body>
쿠키 생성 실패
</body>
<%
}
%>