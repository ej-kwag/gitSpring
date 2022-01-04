<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>

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
<link rel="stylesheet" type="text/css" href="./css/board.css">
</head>
<body>
<div id="board">
	<form name="frm_board" id="frm_board" method="post">
		<label >작성자</label>
		<input type="text" name="mid" id="lbl_mid" value="${vo.mid }"/>
		<label id="lbl_pwd">암호</label>
		<input type="password" name="pwd" id="lbl_pwd"/>
		<br/>
		<label>제목</label>
		<input type="text" name="subject" value="${vo.subject }"/>
		<br/>
		<label id="content">내용</label>
		<textarea id="summernote" name="doc" id="summernote">${vo.doc }</textarea>
		
		<label>첨부 파일</label>
		<div class="attZone">
			<c:if test="${not empty vo.attList }">
				<c:forEach var="att" items="${vo.attList }">
					<div>
						<label id="check"><span>${att.attFile }</span>
						<input type="checkbox" name="delFile" id="delFile" value="${att.attFile }">삭제</label>
					</div>
				</c:forEach>
			</c:if>
		</div>
		<input type="hidden" name="serial" value="${vo.serial }">				
		<input type="hidden" name="seq" value="${vo.seq }">				
	</form>
	<form name="frm_upload" id="frm_upload" method="post">
		<label>첨부</label>
		<input type="file" value="찾아보기..." name = "attfile" id="btnAtt" multiple="multiple">
		<br/>
		<div id="hiddenZone">
			<input type="hidden" name="findStr" value="${page.findStr }" />
			<input type="hidden" name="nowPage" value="${page.nowPage }">
			<input type="hidden" name="serial" id="serial" value="${vo.serial }">			
			<input type="hidden" name="grp" id="grp" value="${vo.grp }">			
			<input type="hidden" name="seq" id="seq" value="${vo.seq }">			
			<input type="hidden" name="deep" value="${vo.deep }">
		</div>
	</form>
	<div id="btnZone">
		<input type="button" id="btnModifySave" value="저장" />
		<input type="button" id="btnList" 		value="목록"/>
	</div>
	<div id="pwd_check" class="pwd_check">
		<form name="modal" method="post">
			<label> 암호를 입력 하세요 </label>
			<br/>
			<input type="password" name="modalPwd"/>
			<br/>
			<input type="button" name="btnPwdCheckModify" value="저장" onclick="pwdCheckSave()"/>
			<input type="button" name="btnPwdCheckCancel" value="취소" onclick="pwdCheckClose()"/>
		</form>
	</div>
</div>
</body>
</html>