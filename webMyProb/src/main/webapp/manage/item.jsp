<%@page import="java.util.List"%>
<%@page import="item.itemDAO"%>
<%@page import="item.itemDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String username = null;

    if((String)session.getAttribute("id") != null){
    	username = (String)session.getAttribute("name");
    }
    
    itemDAO dao = new itemDAO();
    List<itemDTO> dto = dao.selectItem();
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
            background-color: #ffffff;
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
		table {
   			width:1000px; 
   			margin: auto;
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
 <table>
    <tr>
        <th class="num"    >상품명   </th>
        <th class="title"  >수량    </th>
        <th class="writer" >삭제  </th>
    </tr>
<%
	for(itemDTO dt : dto){
	
%>    
   	 	<tr>
      	 	 <td><%=dt.getIname() %></td>
       		 <td><%=dt.getPrice() %></td>
			 <td style="text-align:center;"><button type = "button" onclick="location.href='itemProcess.jsp?iname=<%=dt.getIname() %>'">물건 담기</button>
  	 	</tr>   
	<%
}
%>
</table>
</body>
</html>