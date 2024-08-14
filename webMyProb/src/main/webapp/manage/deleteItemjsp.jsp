<%@page import="item.itemDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
String iname = request.getParameter("iname");

itemDAO dao = new itemDAO();
dao.deleteItem(iname);

out.println("<script type='text/javascript'>");
out.println("alert('장바구니에서 "+iname+"을(를) 삭제했습니다.')");
out.println("window.location.href = 'cart.jsp';");
out.println("</script>");
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