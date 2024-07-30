<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Connection conn = null;
PreparedStatement pstmt = null;

String URL = "jdbc:mysql://localhost:3306/spring5fs";
String id = "root";
String pw = "k1030112233!@#";

String sqlTmp = "";
String numT = "";
String writerT = "";
String titleT = "";
String contentT = "";
String regtimeT = "";
String hitsT = "";

Class.forName("com.mysql.cj.jdbc.Driver");
conn = DriverManager.getConnection(URL,id,pw);


%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <style>
        table     { width:680px; text-align:center; }
        th        { background-color:cyan; }
        
        .num      { width: 80px; }
        .title    { width:230px; }
        .writer   { width:100px; }
        .regtime  { width:180px; }
                
        a:link    { text-decoration:none; color:blue; }
        a:visited { text-decoration:none; color:gray; }
        a:hover   { text-decoration:none; color:red;  }
    </style>
</head>
<body>

<table>
    <tr>
        <th class="num"    >번호    </th>
        <th class="title"  >제목    </th>
        <th class="writer" >작성자  </th>
        <th class="regtime">작성일시</th>
        <th                >조회수  </th>
    </tr>
<%
sqlTmp = "select * from board";
pstmt = conn.prepareStatement(sqlTmp);
ResultSet rs = pstmt.executeQuery();
while(rs.next()){
	numT = rs.getString("num");
	writerT = rs.getString("writer");
	titleT = rs.getString("title");
	contentT = rs.getString("content");
	regtimeT = rs.getString("regtime");
	hitsT = rs.getString("hits");
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