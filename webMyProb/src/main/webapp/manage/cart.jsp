<%@page import="item.userDTO"%>
<%@page import="java.util.List"%>
<%@page import="item.itemDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String username = null;

    if((String)session.getAttribute("id") != null){
    	username = (String)session.getAttribute("name");
    }
	itemDAO dao = new itemDAO();
	List<userDTO> dto = dao.selectUserItem();
%>

<html>
<head>
    <meta charset="UTF-8">
    <title>My JSP Homepage</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #fffff;
        }
        body h1{
        	text-align: center;
        }
        body h2{
        	margin: auto;
        }
        header {
            background-color: #333;
            color: #fff;
            padding: 10px 0;
            text-align: center;
        }
        nav {
            background-color: #444;
            color: #fff;
            padding: 10px;
            text-align: center;
        }
        nav a {
            color: #fff;
            margin: 0 10px;
            text-decoration: none;
        }
       	a:hover {
       		color: #333;
       	}
        .content {
            padding: 20px;
            text-align: center;
        }
        .content h2{
        	color: #fff;
        }
        .content p{
        	color: #fff;
        }
        .content img {
            max-width: 100%;
            height: auto;
        }
        table {
   			width:1000px; 
   			margin: auto;
		}
		th{
			background-color: #333;
			color: #fff;
		}
		td{
			background-color: #999;
			text-align: center;
			color: #fff;
		}
		td a{
			color: #fff;
			text-decoration: none;
		}
    </style>
</head>
<body>
    <header>
        <h1>TEST 게시판</h1>
    </header>
    <nav>

 		<a href="home.jsp">홈</a>
        <a href="newItem.jsp">상품목록</a>
        <a href="newcart.jsp">장바구니</a>
 <%        
  if(username != null){
 %>
         <a href="userInfo.jsp">회원정보관리</a>
 <% 
 }else{
 %>
 <%
 }
 %>
 <%
 if(username != null){
 %>
 		 <a><%=username %> 님</a>
         <a href="logout.jsp">로그아웃</a>
 <% 
 }else{
 %>
 		 <a href ="login.jsp">로그인</a>
 <%
 }
 %>
 <%
 if(username != null){
 %>
 <% 
 }else{
 %>
 		 <a href ="register.jsp">회원가입</a>
 <%
 }
 %>
 </nav>
 <h1>장바구니에 담긴 물품</h1>
<%
if(dto == null){
%>
<h2>현재 장바구니에 담겨있는 상품이 없습니다.</h2>
<% 
}else{
	for(userDTO dt : dto){
	
%>    
 <table>
   	 	<tr>
      	 	 <td><%=dt.getIname() %></td>
       		 <td><%=dt.getNum() %></td>
			<td style="text-align:center;"><button type = "button" onclick="location.href='deleteItem.jsp?iname=<%=dt.getIname() %>'">삭제</button>
			<button type = "button" onclick="location.href='plus.jsp?iname=<%=dt.getIname() %>'">+</button>
			<button type = "button" onclick="location.href='minus.jsp?iname=<%=dt.getIname() %>'">-</button>
			</td>
  	 	</tr>   
	<%
	}
}
%>
</table>
</body>
</html>