<%@page import="board.DTO"%>
<%@page import="board.DAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");

String num = request.getParameter("num");

DAO dao = new DAO();
DTO dto = dao.selectNum(num);
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


<form method="post" action="update.jsp">
	<input type = "hidden" name = "num" value="<%=dto.getNum() %>">
    <table>
        <tr>
            <th>제목</th>
            <td><input type="text" name="title"  maxlength="80"
                       value="<%=dto.getTitle() %>" required>
            </td>
        </tr>
        <tr>
            <th>작성자</th>
            <td><input type="text" name="writer" maxlength="20"
                       value="<%=dto.getWriter() %>" required>
            </td>
        </tr>
        <tr>
            <th>내용</th>
            <td><textarea name="content" rows="10" required><%=dto.getContent() %></textarea>
            </td>
        </tr>
    </table>

    <br>
    <div class=find-btn>
    <input type="submit" value="저장">
    <input type="button" value="취소" onclick="history.back()">
    </div>
</form>

</body>
</html>