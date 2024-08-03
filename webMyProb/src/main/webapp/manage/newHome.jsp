<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
if((String)session.getAttribute("id") !=null){
	response.sendRedirect("list.jsp");
}else{
	out.println("<script type='text/javascript'>");
    out.println("alert('로그인 한 후 사용할 수 있는 기능입니다.');");
    out.println("window.location.href = 'home.jsp';");
    out.println("</script>");
}
%>