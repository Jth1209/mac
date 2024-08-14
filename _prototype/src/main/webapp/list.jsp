<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
table {
	width: 680px;
	text-align: center;
}

th {
	background-color: cyan;
}

.num {
	width: 80px;
}

.title {
	width: 230px;
}

.writer {
	width: 100px;
}

.regtime {
	width: 180px;
}

a:link {
	text-decoration: none;
	color: blue;
}

a:visited {
	text-decoration: none;
	color: gray;
}

a:hover {
	text-decoration: none;
	color: red;
}

.pgn:visited {
	text-decoration: none;
	color: blue;
}
</style>
<meta name="viewport" content="width=device-width, initial-scale=1">

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>

	<table>
		<tr>
			<th class="num">번호</th>
			<th class="title">제목</th>
			<th class="writer">작성자</th>
			<th class="regtime">작성일시</th>
			<th>조회수</th>
		</tr>

		<c:forEach var="msg" items="${msgList}">
			<tr>
				<td>${msg.num}</td>
				<td style="text-align: left;"><a
					href="view?num=${msg.num}&page=${param.page}"> ${msg.title} </a></td>
				<td>${msg.writer}</td>
				<td>${msg.regtime}</td>
				<td>${msg.hits}</td>
			</tr>
		</c:forEach>
	</table>

	<br>
	<div style="width: 680px; text-align: center;">
		<c:forEach var="pgn" items="${pgnList}">
			<a class="pgn" href="list?page=${pgn.pageNo}"> <c:choose>
					<c:when test="${pgn.curPage}">
						<u>${pgn.display}</u>
					</c:when>
					<c:otherwise>
                     ${pgn.display}
                 </c:otherwise>
				</c:choose>
			</a>&nbsp;
    </c:forEach>
	</div>

	<br>

	<input type="button" class="btn btn-outline-secondary" value="글쓰기"
		onclick="location.href='write'">


</body>
</html>