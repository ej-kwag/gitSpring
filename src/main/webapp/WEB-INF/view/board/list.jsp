<%@page import="kr.jobtc.board.BoardVO"%>
<%@page import="java.util.List"%>
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
	<form name="frm_search" id="frm_search" method="POST">
		<div id="first_line">
			<input type="button" value="작성" id="btnInsert" />
			<input type="text" name="findStr" value="${page.findStr }" />
			<input type="button" value="검색" id="btnSearch" />
		</div>
		<div id="list">
			<div id="title">
				<span class="no">NO</span>
				<span class="subject">제목</span>
				<span class="mid">작성자</span>
				<span class="mdate">일자</span>
				<span class="hit">조회수</span>
			</div>
			<c:forEach var="vo" items="${list }">
				<div id="items" onclick="brd.view(${vo.serial })">
					<span class="no">${vo.serial }</span>
					<span class="subject">${vo.subject } ${(vo.attCnt)>0? "(첨부파일 :"+=vo.attCnt+=")":""} </span>
					<span class="mid">${vo.mid }</span>
					<span class="mdate">${vo.mdate }</span>
					<span class="hit">${vo.hit }</span> <br/>
				</div>
			</c:forEach>
			<div id="btnZone">
				<c:if test="${page.startPage > 1}">
					<input type="button" value="처음으로" id="btnFirst" onclick="brd.page(1)">
					<input type="button" value="이전" id="btnPrevious" onclick="brd.page(${page.startPage-1 })">
				</c:if>	
				<c:forEach var="i" begin="${page.startPage }" end="${page.endPage }">
					<input type="button" value="${i }" onclick="brd.page(${i})"
							class = "${(i==page.nowPage)?  'here' : ''}">
				</c:forEach>
				<c:if test="${page.endPage < page.totPage}">
					<input type="button" value="다음" id="btnNext" onclick="brd.page(${page.endPage+1})">
					<input type="button" value="끝으로" id="btnEnd" onclick="brd.page(${page.totPage})">
				</c:if>
			</div>
			<div id="hiddenZone">
				<input type="text" name="nowPage" value="${page.nowPage }" onclick="brd.page(${page.endPage+1}})" />
				<input type="text" name="serial" value="${vo.serial }" onclick="brd.page(${page.totPage})" />
			</div>
		</div>	
	
	</form>

</div>
</body>
</html>
























