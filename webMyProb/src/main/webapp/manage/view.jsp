<%@page import="board.DTO"%>
<%@page import="board.DAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");

String num = request.getParameter("num");

String sqlTmp = "";
String numT = "";
String writerT = "";
String titleT = "";
String contentT = "";
String regtimeT = "";
String hitsT = "";



DAO dao = new DAO();
dao.hits(num);

DTO dto = dao.selectNum(num);

titleT = dto.getTitle();
writerT = dto.getWriter();
regtimeT = dto.getRegtime();
hitsT = String.valueOf(dto.getHits());
contentT = dto.getContent();
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
	    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
			background-color: #fac6c6;
        }
        header {
            background-color: #ffaaaa;
            color: #ff5050;
            padding: 10px 0;
            text-align: center;
        }
        nav {
            background-color: #f56e6e;
            color: #ff5050;
            padding: 10px;
            text-align: center;
        }
        nav a {
            color: #fac6c6;
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
		td a:hover{
			color: #ff5050;
		}
		td a:visited{
			color: #ffc314;
		}
		.find-btn{
			text-align: center;
		}
		.find-btn1{
			display :inline-block;
		}
        input[type=text], textarea { width:100%; }
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
 </nav>
<table>
    <tr>
        <th>제목</th>
        <td><%=titleT %></td>
    </tr>
    <tr>
        <th>작성자</th>
        <td><%=writerT %></td>
    </tr>
    <tr>
        <th>작성일시</th>
        <td><%=regtimeT %></td>
    </tr>
    <tr>
        <th>조회수</th>
        <td><%=hitsT %></td>
    </tr>
    <tr>
        <th>내용</th>
        <td><%=contentT %></td>
    </tr>
</table>

<br>
<div class="find-btn">
<input type="button" value="목록보기" onclick="location.href='list.jsp'">
<input type="button" value="수정"
       onclick="location.href='rework.jsp?num=<%=dto.getNum() %>'">
<input type="button" value="삭제"
       onclick="location.href='delete.jsp?num=<%=dto.getNum() %>'">
</div>

</body>
</html>