<%@page import="item.itemDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String iname = request.getParameter("iname");
	itemDAO dao = new itemDAO();
	dao.updateNum(iname);
	response.sendRedirect("cart.jsp");
%>