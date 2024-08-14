<%@page import="member.DTO"%>
<%@page import="member.DAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>

<%
    request.setCharacterEncoding("utf-8");
	
	DAO dao = new DAO();
	DTO dto = dao.findId((String)session.getAttribute("id"));
	
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원 정보 수정</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .container {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 300px;
        }
        h2 {
            text-align: center;
            margin-bottom: 20px;
        }
        label {
            display: block;
            margin-bottom: 5px;
        }
        input[type="text"], input[type="password"], input[type="email"] {
            width: 95%;
            padding: 8px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        input[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: #28a745;
            border: none;
            border-radius: 4px;
            color: #fff;
            font-size: 16px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #218838;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>회원 정보 수정</h2>
        <form action="userInfoChange.jsp" method="post">
            <label for="id">ID:</label>
            <input type="text" id="id" name="id" value="<%=dto.getId() %>" readOnly>
            <label for="password">Password:</label>
            <input type="text" id="password" name="password" value="<%=dto.getPw() %>"required>
            <label for="name">UserName:</label>
            <input type="text" id="name" name="name" value="<%=dto.getName() %>"required>
            <input type="submit" value="Update">
        </form>
    </div>
</body>
</html>