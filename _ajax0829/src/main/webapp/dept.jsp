<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Class.forName("com.mysql.cj.jdbc.Driver");
	String url = "jdbc:mysql://localhost:3306/spring5fs";
	String sql = "select json_object('deptno',deptno,'dname',dname,'loc',loc) from dept";
	String id = "root";
	String pw = "k1030112233!@#";
	conn = DriverManager.getConnection(url,id,pw);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>dept</title>
</head>
<body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script>
	const url = "http://localhost:4000/dept";
	let json = null;
	<%
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		while(rs.next()){
			String data = rs.getString(1);
	
	%>
	json = JSON.parse('<%=data%>');
	/*여기 중요하다. '' 내부에 {}객체 정보를 담아야 한다.
	parse(문자열)은 매개변수 내부의 문자열을 json객체로 형변환 해주는 메소드이기 때문에 매개변수 자리에는 항상 문자열이 들어가야한다.*/ 
	
		$.ajax({//순수 ajax를 사용한 json-server 데이터 삽입 코드(이후 fetch를 사용한 CRUD 또한 익숙해져야 한다.)
			url:url,
			method:"POST",
			contentType:"application/json",
			data:JSON.stringify(json),
			success:function(data){
				console.log(data);
			},
			error:function(error){
				console.error('Error:',error);
			}
		});
	
	<%
		}
	%>
</script>
</body>
</html>