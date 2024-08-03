<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
boolean rememberId = false;
String Uname = "";

if((String)session.getAttribute("Rid") != null){
	rememberId = true;
	Uname = (String)session.getAttribute("Rid");
}
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .login-container {
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .login-container h2 {
            margin-bottom: 20px;
        }
        .login-container input[type="text"], input[type="password"]{
            width: 95%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        .login-container input[type="checkbox"]{
        	margin-bottom: 30px;
        }
        .login-container button {
            width: 100%;
            padding: 10px;
            background-color: #333;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
    </style>
</head>
<body>
    <div class="login-container">
        <h2>Login</h2>
        <form action="loginProcess.jsp" method="post">
            <input type="text" name="username" placeholder="Username" value="<%= rememberId ? Uname : "" %>" required>
            <input type="password" name="password" placeholder="Password" required>
            <input type="checkbox" id="Rid" name="Rid" <%= rememberId ? "checked" : " " %>><label for="Rid">아이디 저장</label>
            <button type="submit">Login</button>
        </form>
    </div>
<%
session.removeAttribute("Rid");
%>
</body>
</html>