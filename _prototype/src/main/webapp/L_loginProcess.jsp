<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="member.memberDAO"%>
<%@page import="member.memberDTO"%>
<%
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("username");
	String pw = request.getParameter("password");
	
	memberDTO dto = new memberDTO(id,pw,"dummy");
	memberDAO dao = new memberDAO();
	session.setAttribute("id", id);
	
	if(dao.checkUser(dto) == 1){
		memberDTO name = dao.selectOne(id);
		session.setAttribute("uname", name.getName());
%>
	<jsp:forward page="index.jsp"></jsp:forward>
<%	
	}else{
		out.println("<script type='text/javascript'>");
        out.println("alert('아이디나 비밀번호를 틀렸습니다.');");
        out.println("window.location.href = 'L_login.jsp';");
        out.println("</script>");
	}
%>