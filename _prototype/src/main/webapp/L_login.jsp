<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<style>
		section {
            font-family: Arial, sans-serif;
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
        	text-align: center;
            margin-bottom: 20px;
        }
        .login-container input {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
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
        <div class="login-container">
	        <h2>로그인</h2>
	        <form action="loginProcess" method="post">
	            <input type="text" name="username" placeholder="Username" required>
	            <input type="password" name="password" placeholder="Password" required>
	            <button type="submit">로그인</button>
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