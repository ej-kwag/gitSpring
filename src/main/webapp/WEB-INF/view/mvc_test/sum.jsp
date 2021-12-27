<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sum</title>
<script src="/js/test.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
</head>
<body>
<form id="sum" method="post" action="/mvc_test/sum_result"
				onsubmit="return sumTest()">
	<label>x</label>
	<input type="number" name="figureX" id="x" required="required"/>
	<br/>
	<label>y</label>
	<input type="number" name="figureY" id="y" required="required"/>
	<br/>
	<input type="submit" name="submit" value="더하기" />
</form>
</body>
</html>