<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="ko">
<head>
	<style>
        section {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
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
            background-color: #bf3b3b;
            border: none;
            border-radius: 4px;
            color: #fff;
            font-size: 16px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #000;
        }
    </style>
	
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>æspa</title>
    <link rel="icon" href="logo.ico" type="image/x-icon">
    <script src="https://kit.fontawesome.com/c47106c6a7.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="css/style.css">
    <script src="js/ie.js"></script>
</head>

<body>

    <header>
        <div class="inner">
            <h1><a href="index.jsp">æspa</a></h1>

            <ul id="gnb">
                <li><a href="https://www.smentertainment.com/en/">DEPARTMENT</a></li>
                <li><a href="https://blip.kr/artists/aespa/gallery">GALLERY</a></li>
                <li><a href="https://www.youtube.com/@aespa">YOUTUBE</a></li>
                <li><a href="boards.jsp">COMMUNITY</a></li>
            </ul>

            <ul class="util">
                <li><a href="L_login.jsp">Login</a></li>
                <li><a href="L_join.jsp">Join</a></li>
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