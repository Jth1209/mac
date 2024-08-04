<%@page import="item.userDTO"%>
<%@page import="item.itemDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String iname = request.getParameter("iname");
	itemDAO dao = new itemDAO();
	userDTO dto = dao.selectOne2(iname);
	if(dto.getNum() > 1){
		dao.updateNum2(iname);
		response.sendRedirect("cart.jsp");
	}else{
		out.println("<script type='text/javascript'>");
		out.println("alert('하나 이상의 물건을 구매해야 합니다.');");
		out.println("window.location.href = 'cart.jsp';");
		out.println("</script>");

	}
%>