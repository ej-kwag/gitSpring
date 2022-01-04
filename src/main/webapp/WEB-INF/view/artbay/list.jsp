<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>artbay-list</title>
</head>
<body>
<form name="frm_list" method="post">
	<!-- 섹션/정렬 영역 -->
	<div class="nav">
		<ul>
			<li>전체</li>
			<li>paint</li>
			<li>pottery</li>
		</ul>
	</div>
	<br/>
	<!-- 검색 영역 -->
	<div class="serach">
		<div class="search_box">
			<input type="text" id="serach_input" placeholder="작가 또는 작품명" />
			<input type="button" id="btnSearch" value="검색" />
		</div>
		<div class="listBox">
			<!-- sort -->
			<div class="dropdown_01">
				<a id="sort_price_desc">높은 시작가 순</a>
				<a id="sort_price_asec">낮은 시작가 순</a>
				<a id="sort_bid_cnt_desc">응찰 많은 순</a>
				<a id="sort_bid_cnt_asec">응찰 낮은 순</a>
			</div>
			<!-- page size -->
			<div class="dropdown_02">
				<a id="page_size_10" class="dropdown_item"></a>
				<a id="page_size_20" class="dropdown_item"></a>
				<a id="page_size_30" class="dropdown_item"></a>
				<a id="page_size_40" class="dropdown_item"></a>
				<a id="page_size_50" class="dropdown_item"></a>
			</div>
		</div>
	</div>
	<br/>
	<!-- 선택된 검색 옵션 -->
	<div class="selected_option_area">
		<div><p>검색된 옵션</p></div>
		<div id="selected_option"><div class="selected_list"><span>Clear All</span></div></div>
	</div>
	<div class="listBox">
		<div class="listInner">
		<!-- onclick = 필요 -->
			<p class="img">사진</p>
			<br/>
			<p class="painter">작가명</p>
			<p class="name">그림 제목</p>
			<p class="material">재료</p>
			<p class="paintSize">사이즈</p>
			<p>추정가</p>
			<p class="approximateStart">KRW 4,000,000</p>
			<p>~</p>
			<p class="approximateEnd">9,000,000</p>
			<p>시작가</p>
			<p class="minimumPrice">KRW 2,500,000</p>
			<p>현재가</p>>
			<p class="currentPrice">KRW 9,000,000</p>
			<p class="endDate">마감 01-04 오후 4:00</p>
			<p class="bid_cnt">25회</p>
		</div>
	</div>
	<div id="pageZone">
		<input type="button" value="&lt&lt" />
		<input type="button" value="&lt" />
		<input type="button" value="1" />
		<input type="button" value="&gt" />
		<input type="button" value="&gt&gt" />
	</div>
</form>
</body>
</html>