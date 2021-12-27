<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>range</title>
</head>
<body>
<form id="range" method="post" action="/mvc_test/range_result">
	<label>x</label>
	<input type="number" name="figureX" required="required"/>
	<br/>
	<label>y</label>
	<input type="number" name="figureY" required="required"/>
	<br/>
	<input type="submit" name="submit" value="범위" />
</form>
</body>
</html>