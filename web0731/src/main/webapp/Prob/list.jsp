<%@page import="java.util.List"%>
<%@page import="board.DTO"%>
<%@page import="board.DAO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String sqlTmp = "";
String numT = "";
String writerT = "";
String titleT = "";
String contentT = "";
String regtimeT = "";
String hitsT = "";

%>
<!DOCTYPE html>
<%
    String username = null;

    if((String)session.getAttribute("id") != null){
    	username = (String)session.getAttribute("name");
    }
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
            background-color: #f4f4f4;
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
        .content {
            padding: 20px;
            text-align: center;
        }
        .content img {
            max-width: 100%;
            height: auto;
        }
    </style>
</head>
<body>
    <header>
        <h1>TEST 게시판</h1>
    </header>
    <nav>

 		<a href="home.jsp">홈</a>
        <a href="newHome.jsp">게시판</a>
 <%        
  if(username != null){
 %>
         <a href="userInfo.jsp">회원정보관리</a>
 <% 
 }else{
 %>
 		 <a></a>
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
 		 <a></a>
 <% 
 }else{
 %>
 		 <a href ="register.jsp">회원가입</a>
 <%
 }
 %>

<table>
    <tr>
        <th class="num"    >번호    </th>
        <th class="title"  >제목    </th>
        <th class="writer" >작성자  </th>
        <th class="regtime">작성일시</th>
        <th                >조회수  </th>
    </tr>
<%
DAO dao = new DAO();
List<DTO> dto = dao.selectAll();
for(DTO dt : dto){
	numT = String.valueOf(dt.getNum());
	writerT = dt.getWriter();
	titleT = dt.getTitle();
	regtimeT = dt.getRegtime();
	hitsT = String.valueOf(dt.getHits());
%>    
    <tr>
        <td><%=numT %></td>
        <td style="text-align:left;">
            <a href="view.jsp?num=<%=numT %>"><%=titleT %></a>
        </td>
        <td><%=writerT %></td>
        <td><%=regtimeT %></td>
        <td><%=hitsT %></td>
    </tr>   
<%
}
%>
</table>

<br>
<input type="button" value="글쓰기" onclick="location.href='write.jsp'">

</body>
</html>