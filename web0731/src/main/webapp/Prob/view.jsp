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
<html>
<head>
<meta charset="UTF-8">
	<style>
        table { width:680px; text-align:center; }
        th    { width:100px; background-color:cyan; }
        td    { text-align:left; border:1px solid gray; }
    </style>
<title>Insert title here</title>
</head>
<body>
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
<input type="button" value="목록보기" onclick="location.href='list.jsp'">
<input type="button" value="수정"
       onclick="location.href='rework.jsp?num=<%=dto.getNum() %>'">
<input type="button" value="삭제"
       onclick="location.href='delete.jsp?num=<%=dto.getNum() %>'">

</body>
</html>