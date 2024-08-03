
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
DTO dtoc = dao.findId(id);
DTO dto = new DTO(id,password,name);

if(dtoc != null){
	out.println("<script type='text/javascript'>");
	out.println("alert('이미 존재하는 아이디입니다.');");
	out.println("window.location.href = 'register.jsp';");
	out.println("</script>");

}else{
	dao.insertUser(dto);
	out.println("<script type='text/javascript'>");
	out.println("alert('회원가입 성공');");
	out.println("window.location.href = 'home.jsp';");
	out.println("</script>");
	
}

%>
