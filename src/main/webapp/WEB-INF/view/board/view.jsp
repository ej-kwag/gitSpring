<%@page import="kr.jobtc.board.BoardVO"%>
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
<%
%>

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
		<div name="doc" id="doc">${vo.doc }</div>
		<br/>
		<label>첨부</label>
		<c:choose>
			<c:when test="${not empty vo.attList }">
				<div class="attZone">
					<ul>
						<c:forEach var='att' items="${vo.attList }">
							<li> <a href="./upload/${att.attFile }" download="${att.attFile }">${att.attFile }</a></li>
						</c:forEach>
					</ul>
				</div>
			</c:when>
			<c:otherwise>
				<div class="attZone">
					<label> 첨부 파일 없음 </label>
				</div>
			</c:otherwise>
		</c:choose>
		<div id="btnZone">
			<input type="button" id="btnModify" value="수정" />
			<input type="button" id="btnReply" value="답글" />
			<input type="button" id="btnDelete" value="삭제" />
			<input type="button" id="btnList" value="목록" />
		</div>
		<div id="hiddenZone">
			<input type="text" name="findStr" value="${page.findStr }" />
			<input type="text" name="nowPage" value="${page.nowPage }">
			<input type="text" name="serial" value="${vo.serial }">			
			<input type="text" name="grp" value="${vo.grp }">			
			<input type="text" name="seq" value="${vo.seq }">			
			<input type="text" name="deep" value="${vo.deep }">
		</div>
	</form>
	<div id="pwd_check" class="pwd_check">
		<form name="modal" method="post">
			<label> 암호를 입력 하세요 </label>
			<br/>
			<input type="password" name="pwd"/>
			<br/>
			<input type="button" name="btnPwdCheckDelete" value="삭제" onclick="pwdCheckDelete()"/>
			<input type="button" name="btnPwdCheckCancel" value="취소" onclick="pwdCheckClose()"/>
		</form>
	</div>
</div>
</body>
</html>