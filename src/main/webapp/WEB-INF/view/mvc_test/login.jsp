<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
</head>
<body>
<h1>spring mvc test</h1>
<form name="frm" method="post" action="/mvc_test/login_result">
	<label>ID</label>
	<input type="text" name="mid" value="ej" />
	<br/>
	<label>PWD</label>
	<input type="password" name="pwd" value="1234"/>
	<br/>	
	<input type="submit" name="submit" value="확인" />
	

</form>
</body>
</html>