<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>

<body>
	<nav class="navbar navbar-expand-lg bg-body-tertiary">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">홈페이지</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavDropdown">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="list">게시판</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">자료실</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="shop">쇼핑몰</a>
        </li>
        <li class="nav-item dropdown">
        <%
        	if(session.getAttribute("uname") != null){
        %>
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            ${uname }님
          </a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="logoutProcess">로그아웃</a></li>
            <li><a class="dropdown-item" href="update">회원정보수정</a></li>
            <li><a class="dropdown-item" href="delete">회원정보삭제</a></li>
          </ul>
        <%
        	}else{
        %>	
        	<a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            로그인이 필요합니다
          </a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="login">로그인</a></li>
            <li><a class="dropdown-item" href="register">회원가입</a></li>          
            </ul>	
        <% 	
        	}
        %>
        </li>
      </ul>
    </div>
  </div>
</nav>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
	
    <header>
        <div class="inner">
            <h1><a href="index.jsp">æspa</a></h1>

            <ul id="gnb">
                <li><a href="https://www.smentertainment.com/en/">DEPARTMENT</a></li>
                <li><a href="https://blip.kr/artists/aespa/gallery">GALLERY</a></li>
                <li><a href="https://www.youtube.com/@aespa">YOUTUBE</a></li>
                <li><a href="/list">COMMUNITY</a></li>
                <li><a href="S_shops.jsp">GOODS</a></li>
            </ul>

            <ul class="util">
            <%
                if(session.getAttribute("uname") != null){
            %>
            	<li><a href="#">${uname }님</a></li>
                <li><a href="L_logout.jsp">Logout</a></li>
                <li><a href="L_update.jsp">회원정보수정</a></li>
            <%
            	}else{	
            %>		
                <li><a href="L_login.jsp">Login</a></li>
                <li><a href="L_join.jsp">Join</a></li>
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
            <p>SM entertainment 소속 아티스트 aespa <br>
               에스파 컨셉 웹 사이트입니다</p>
            <a href="https://namu.wiki/w/aespa?from=%EC%97%90%EC%8A%A4%ED%8C%8C">자세히 알아보기</a>
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
                    <h2><a href="https://namu.wiki/w/%EC%B9%B4%EB%A6%AC%EB%82%98">Karina</a></h2>
                    <p>대한민국의 가수. SM엔터테인먼트 소속 4인조 걸그룹 aespa의 멤버이자 리더.</p>
                </article>

                <article>
                    <div class="pic">
                        <img src="img/winter.jpg" alt="2번째 콘텐츠 이미지">
                    </div>
                    <h2><a href="https://namu.wiki/w/%EC%9C%88%ED%84%B0(aespa)">Winter</a></h2>
                    <p>대한민국의 가수. SM엔터테인먼트 소속 4인조 걸그룹 aespa의 멤버.
                    </p>
                </article>

                <article>
                    <div class="pic">
                        <img src="img/giselle.jpg" alt="3번째 콘텐츠 이미지">
                    </div>
                    <h2><a href="https://namu.wiki/w/%EC%A7%80%EC%A0%A4(aespa)">Giselle</a></h2>
                    <p>SM엔터테인먼트 소속 4인조 걸그룹 aespa의 멤버.</p>
                </article>

                <article>
                    <div class="pic">
                        <img src="img/ningning.jpg" alt="4번째 콘텐츠 이미지">
                    </div>
                    <h2><a href="https://namu.wiki/w/%EB%8B%9D%EB%8B%9D">Ningning</a></h2>
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