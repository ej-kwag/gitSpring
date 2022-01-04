<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring Boot Index</title>
<link rel="stylesheet" type="text/css" href="./css/index.css">
</head>
<body>
<div id="index">
	<h1>Spring Boot Index</h1>
	<fieldset>
		<c:forEach var="i" items="${su }">
			${i }
		</c:forEach>
	</fieldset>
	<ul>
		<li><a href="/mvc_test/login">로그인</a></li>
		<li><a href="/mvc_test/sum">두 수의 합</a></li>
		<li><a href="/mvc_test/max">최대값</a></li>
		<li><a href="/mvc_test/range">범위값</a></li>
		<li><a href="/artbay/list">아트베이</a></li>
	</ul>
</div>
</body>
</html>