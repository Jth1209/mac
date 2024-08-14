<%@page import="item.itemDTO"%>
<%@page import="item.itemDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	String iname = request.getParameter("iname");
	System.out.println(iname);

	itemDAO dao = new itemDAO();
	
	if(dao.selectUser(iname) == 1){
		dao.updateNum(iname);
	}else{
   		dao.insertUser(iname);
	}
	
    
    response.sendRedirect("item.jsp");
%>
