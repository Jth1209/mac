<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>홈페이지</title>
<link rel="icon" href="sk.ico?after" type="image/x-icon">
<link rel="stylesheet" href="css/style.css?after">
<script src="js/ie.js"></script>
</head>
<body>
	<header>
		<div class="inner">
			<h1>
				<a href="index.jsp">æspa</a>
			</h1>

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


	<figure>
		<video src="img/aespaLogo.mp4" autoplay muted loop></video>
		<div class="inner">
			<h1>æspa</h1>
			<p>
				SM entertainment 소속 아티스트 aespa <br> 에스파 컨셉 웹 사이트입니다
			</p>
			<a href="https://namu.wiki/w/aespa?from=%EC%97%90%EC%8A%A4%ED%8C%8C">자세히
				알아보기</a>
		</div>
	</figure>

	<section>
		<div class="inner">
			<h1>INTRODUCE</h1>
			<div class="wrap">
				<article>
					<div class="pic">
						<img src="img/karina.jpg" alt="1번째 콘텐츠 이미지">
					</div>
					<h2>
						<a href="https://namu.wiki/w/%EC%B9%B4%EB%A6%AC%EB%82%98">Karina</a>
					</h2>
					<p>대한민국의 가수. SM엔터테인먼트 소속 4인조 걸그룹 aespa의 멤버이자 리더.</p>
				</article>

				<article>
					<div class="pic">
						<img src="img/winter.jpg" alt="2번째 콘텐츠 이미지">
					</div>
					<h2>
						<a href="https://namu.wiki/w/%EC%9C%88%ED%84%B0(aespa)">Winter</a>
					</h2>
					<p>대한민국의 가수. SM엔터테인먼트 소속 4인조 걸그룹 aespa의 멤버.</p>
				</article>

				<article>
					<div class="pic">
						<img src="img/giselle.jpg" alt="3번째 콘텐츠 이미지">
					</div>
					<h2>
						<a href="https://namu.wiki/w/%EC%A7%80%EC%A0%A4(aespa)">Giselle</a>
					</h2>
					<p>SM엔터테인먼트 소속 4인조 걸그룹 aespa의 멤버.</p>
				</article>

				<article>
					<div class="pic">
						<img src="img/ningning.jpg" alt="4번째 콘텐츠 이미지">
					</div>
					<h2>
						<a href="https://namu.wiki/w/%EB%8B%9D%EB%8B%9D">Ningning</a>
					</h2>
					<p>SM엔터테인먼트 소속 4인조 걸그룹 aespa의 멤버.</p>
				</article>
			</div>
		</div>
	</section>

	<footer>
		<div class="inner">
			<div class="upper">
				<h1>æspa</h1>
				<ul>
					<li><a href="https://m.cafe.daum.net/dafdgds/_rec">Family
							Site</a></li>
				</ul>
			</div>

			<div class="lower">
				<address>
					컴퓨터 소프트웨어학과 장태호<br> TEL : 031-111-1234 C.P : 010-1234-5678
				</address>
				<p>2024 æspa &copy; copyright all right reserved.</p>
			</div>
		</div>
	</footer>
</body>
</html>