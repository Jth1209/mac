<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>데이터베이스 정보 수정</h1>
<form action = "/web0724/update.do">
업데이트 할 부서 번호: <input type = "text" name = "deptno"><br>
업데이트 할 부서 이름: <input type = "text" name = "dname"><br>
업데이트 할 부서 지역: <input type = "text" name = "loc"><br>
<input type = "submit">
</form>
</body>
</html>