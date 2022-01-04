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
	<h2>게시물 작성하기</h2>
	<form name="frm_board" id="frm_board" method="POST">
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
		<br/>
		<div id="hiddenZone">
			<input type="hidden" name="findStr" value="${page.findStr }" />
			<input type="hidden" name="nowPage" value="${page.nowPage }" />
		</div>
	</form>
	<form name="frm_upload" id="frm_upload" method="post">
		<label>첨부</label><input type="file" value="찾아보기..." name="attfile" id="attFile" multiple="multiple" />
		
		<input type="hidden" name="findStr" value="${page.findStr }" />
		<input type="hidden" name="nowPage" value=${page.nowPage }>	
		<input type="hidden" name="grp" />
		
	</form>
		<div id="btnZone">
			<input type="button" id="btnSave" value="저장" />
			<input type="button" id="btnList" value="목록" />
		</div>
</div>

</body>
</html>