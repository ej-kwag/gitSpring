<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<link rel="stylesheet" type="text/css" href="./css/board.css">

<!-- include libraries(jQuery, bootstrap) -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- include summernote css/js -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
<script src ="./js/board.js"></script>
<script>
$(function(){
	summer();
})
</script>
</head>
<body>
<div id="board">
	<form name="frm_board" id="frm_board" method="post">
		<label >작성자</label>
		<input type="text" name="mid" id="lbl_mid"/>
		<label id="lbl_pwd">암호</label>
		<input type="password" name="pwd" id="lbl_pwd"/>
		<br/>
		<label>제목</label>
		<input type="text" name="subject" />
		<br/>
		<label id="content">내용</label>
		<textarea id="summernote" name="doc"></textarea>
		<input type="text" name="grp" value="${vo.grp }">	
		<input type="text" name="serial" value="${vo.serial }">			
		<input type="text" name="seq" value="${vo.seq }">			
		<input type="text" name="deep" value="${vo.deep }">
	</form>
	<form name="frm_upload" id="frm_upload" method="post">
		<label>첨부</label>
		<input type="file" value="찾아보기..." name = "attfile" id="btnAtt" multiple="multiple">
		<br/>
		<div id="hiddenZone">
			<input type="text" name="findStr" value="${page.findStr }" />
			<input type="text" name="nowPage" value="${page.nowPage }">
			<input type="text" name="grp" value="${vo.serial }">	
			<input type="text" name="serial" id="serial" value="${vo.serial }">			
			<input type="text" name="seq" id="seq" value="${vo.seq }">			
		</div>
	</form>
	<div id="btnZone">
		<input type="button" id="btnReplySave" value="저장" />
		<input type="button" id="btnList" 		value="목록"/>
	</div>
</div>
</body>
</html>