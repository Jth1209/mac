<%@page import="member.memberDTO"%>
<%@page import="member.memberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	String pw = request.getParameter("password");
	String name = request.getParameter("name");
	
	memberDAO dao = new memberDAO();
	memberDTO dto = new memberDTO(id,pw,name);
	dao.updateUser(dto);
	
	out.println("<script type='text/javascript'>");
    out.println("alert('정보 수정 완료. 다시 로그인 해주세요.');");
    out.println("window.location.href = 'L_login.jsp';");
    out.println("</script>");
%>