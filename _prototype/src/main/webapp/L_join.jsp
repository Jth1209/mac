
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>SKT 하이닉스</title>
<link rel="icon" href="img/logo.ico?after" type="image/x-icon">
<link rel="stylesheet" href="css/style.css?after">
<script src="js/ie.js"></script>
<style>
	section {
	width: 100%;
	padding: 200px 0px;
	background: #ececff;
	font-family: Arial, sans-serif;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
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
	width: 100%;
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
    <header>
        <div class="inner">
            <h1><a href="index.jsp">æspa</a></h1>
            <ul id="gnb">
                <li><a href="https://blip.kr/artists/aespa/gallery">GALLERY</a></li>
                <li><a href="https://www.youtube.com/@aespa">YOUTUBE</a></li>
                <li><a href="check?identify=1">COMMUNITY</a></li>
                <li><a href="check?identify=2">자료실</a></li>
                <li><a href="check?identify=3">GOODS</a></li>
            </ul>

            <ul class="util">
            <%
        		if(session.getAttribute("uname") != null){
        	%>
            	<li><a href=#>${uname }님</a></li>
            	<li><a href="update">회원정보 수정</a></li>
                <li><a href="logoutProcess">로그아웃</a></li>
                <li><a href="delete">회원삭제</a></li>
                
            <% 		
            	}else{
            %>
                <li><a href="login">로그인</a></li>
                <li><a href="register">회원가입</a></li>
            <%		
            	}
            %>
            </ul>
        </div>
    </header>
    <section>
		<div class="container">
        <h2>회원 가입</h2>
        <form action="registerProcess" method="post">
            <label for="username">아이디:</label>
            <input type="text" id="username" name="username" required>
            <label for="password">비밀번호:</label>
            <input type="text" id="password" name="password" required>
            <label for="email">별명:</label>
            <input type="text" id="email" name="name" required>
            <input type="submit" value="Register">
        </form>
    </div>
		
    </section>
    <footer>
        <div class="inner">
            <div class="upper">
                <h1>æspa</h1>
                <ul>
                    <li><a href="https://m.cafe.daum.net/dafdgds/_rec">Family Site</a></li>
                </ul>
            </div>

            <div class="lower">
                <address>
                    컴퓨터 소프트웨어학과 장태호<br>
                    TEL : 031-111-1234 C.P : 010-1234-5678
                </address>
                <p>
                    2024 æspa &copy; copyright all right reserved.
                </p>
            </div>
        </div>
    </footer>
</body>
</html>
