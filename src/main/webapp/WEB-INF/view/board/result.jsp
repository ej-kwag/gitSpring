<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<script src="http://code.jquery.com/jquery-3.6.0.js"></script>
<link rel="stylesheet" type="text/css" href="./css/board.css">
<script src ="./js/board.js"></script>
</head>
<body>
<div id="board">
	<form name="frm_board" id="frm_board" method="post">
		${msg }
		<br/>
		<input type="button" id="btnList" value="목록으로"/>	
		<div id="hiddenZone">
			<input type="text" name="findStr" value="${page.findStr }" />
			<input type="text" name="nowPage" value=${page.nowPage }>
			<input type="text" name="serial" value=${vo.serial }>			
			<input type="text" name="grp" value=${vo.grp }>			
			<input type="text" name="seq" value=${vo.seq }>			
			<input type="text" name="deep" value=${vo.deep }>
		</div>
	</form>
</div>
</body>
</html>