<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="frm_list" method="post">
	<div class="view">
		<div class="view_top">
			<p>사진</p>
			<br/>
			<p id="like">❤️</p>
			<p id="share">🔗</p>
			<p id="magnifier">🔎</p>
		</div>
		<div class="view_detail">
			<p class="writer"><span>작가 이름</span></p>
		</div>
		<div class="deadline_time">
			<span>남은 시간</span>
			<span class="remainTime"></span>
		</div>
		<div class="price">
			<p>
				<strong>추정가</strong>
					KRW 6,000,000~8,000,000
			</p>
			<p>
				<strong>시작가</strong>
					KRW 4,000,000
			</p>
			<p>
				<strong>현재가</strong>
					KRW 9,000,000
			</p>
		</div>
		<div class="rigt_modal">
			<div class="closing_hour">
				마감 시간
				<span>01/04 - 04:00 PM</span>
			</div>
			<ul>
				<li class="right_modal_btn">
					<p><span>낙찰 수수료</span></p>
				</li>
				<li class="right_modal_btn">
					<p><span>예상 배송비</span></p>
				</li>
				<li class="right_modal_btn">
					<p><span>경매 호가표</span></p>
				</li>
				<li class="right_modal_btn">
					<p><span>설치 및 보관</span></p>
				</li>
			</ul>
		</div>
	</div>
	<div class="work_info">
		<h3>작품 정보</h3>
		<div class="cont">
			<p> signed, titled and dated on the reverse<br/>Acrylic Frame </p>
		</div>
	</div>
	<div class="caution">
		<h3>Condition Report</h3>
			<div class="inquiry">
				<li>실물을 반드시 확인한 후 응찰 바랍니다. 실물을 확인하지 않아 발생되는 문제에 대한 책임은 응찰자에게 있습니다.</li>
			</div>
	</div>	
	<!-- 낙찰 수수료 모달 -->
	<div class="rightmodal_m1" style="border:1px solid grey;">
		<div class="modal_title">
			<p>낙찰 수수료 안내</p>
		</div>
		<div class="modal_body">
			<table class="commission_rate">
				<thread>
					<tr>
						<th scope="col" class="bid">낙찰가 (원)</th>
						<th scope="col" class="cm_rate">수수료율 (VAT 포함)</th>
					</tr>
				</thread>
				<tbody>
					<tr>
						<td>~ 10,000,000</td>
						<td> 낙찰가의 19.8%</td>
					</tr>
					<tr>
						<td>10,000,001</td>
						<td>1,000만원 x 19.8% + (낙찰가-1,000만원) x 16.5%</td>
					</tr>
				</tbody>
				<div class="exam">
					<p>예시&#41; 낙찰가 5,000만원일 경우</p>
					<p>낙찰 수수료 :</p>
					<p>198만원 + (5,000만원 - 1,000만원) * 16.5% = 8,580,000원</p>
					<p>총 구매대금 :</p>
					<p>낙찰가 + 낙찰수수료 = 58,580,000원</p>
				</div>
			</table>
		</div>
	</div>
	<!-- 배송 모달 -->
	<div class="rightmodal_m2">
		<div class="modal_title">
			<p>배송 관련 안내</p>
		</div>
		<div class="modal_body">
			<ul>
				<li> 온라인 경매의 낙찰작은 직접 픽업이 원칙이나, 불가능한 경우 배송을 요청할 수 있으며, 아래와 같이 배송비가 부과 됩니다.
					<div class="table">
						<table>
							<tbody>
								<tr>
									<td colspan="2">국내</td>
									<td colspan="2">해외</td>
								</tr>
								<tr>
									<td class="place" style="width: 25%;">서울</td>
									<td style="width: 25%;">5만원</td>
									<td colspan="2"	rowspan="3" style="width: 50%;">별도 배송비
								</tr>
								<tr>
									<td class="place">수도권</td>
									<td>10만원</td>
								</tr>
								<tr>
									<td class="place">그 외 국내지역</td>
									<td>15만원</td>
								</tr>
							</tbody>
						</table>
					</div>
				</li>
			</ul>
		</div>
	</div>
	<!-- 경매 호가표 모달-->
	<div class="rigtmodal_m3">
		<div class="modal_title">
			경매 호가표 안내
		</div>
		<div class="modal_body">
			<table class="bid_price_standard">
				<tr>
					<th scope="col">현재가 구간 (원)</th>
					<th scope="col">호가 단위 (원)</th>
				</tr>
				<tbody>
					<tr>
						<td>30만 미만</td>
						<td>20,000</td>
					</tr>
					<tr>
						<td>30만 이상 ~ 100만 미만</td>
						<td>50,000</td>
					</tr>
					<tr>
						<td>100만 이상 ~ 300만 미만</td>
						<td>100,000</td>
					</tr>
					<tr>
						<td>300만 이상 ~ 500만 미만</td>
						<td>200,000</td>
					</tr>
					<tr>
						<td>500만 이상 ~ 1,000만 미만</td>
						<td>500,000</td>
					</tr>
					<tr>
						<td>1,000만 이상 ~ 3,000만 미만</td>
						<td>1,000,000</td>
					</tr>
					<tr>
						<td>3,000만 이상 ~ 5,000만 미만</td>
						<td>2,000,000</td>
					</tr>
					<tr>
						<td>5,000만 이상 ~ 2억 미만</td>
						<td>5,000,000</td>
					</tr>
					<tr>
						<td>2억 이상 ~ 5억 미만</td>
						<td>10,000,000</td>
					</tr>
					<tr>
						<td>5억 이상</td>
						<td>20,000,000</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<!-- 설치 및 보관 모달-->
	<div class="rigtmodal_m4">
		<div class="modal_title">
			<p>설치 및 보관 안내</p>
		</div>
		<div class="modal_body">
			<p>당사 낙찰 제품에 한하여 배송 시 설치를 함께 요청하실 수 있으며, 사전 예약이 필요합니다.</p>
			<p>낙찰 및 판매 이후 7일 경과 시 입금여부와 무관하게 일 30,000원/점의 비용이 발생합니다.</p>
		</div>
	</div>
	<!-- 로그인 모달 -->
	<div class="login">
		<h3> LOGIN </h3>
		<input type="text" id="mid" placeholder="아이디" /><br/>		
		<input type="password" id="pwd" placeholder="비밀번호" /><br/>
		<p><span> 로그인하시면 응찰이 가능합니다.</span></p>
		<div class="login_modal_btn">
			<div>
				<input type="checkbox" id="check_login" value="0" />
				<label for="check_login">로그인 상태 유지</label>
			</div>
			<div>
				<a href="/아이디찾기 주소">아이디 찾기</a>
				<a href="/비밀번호찾기 주소">비밀번호 찾기</a>
			</div>
			<button type="button">
				<span>로그인</span>
			</button>
			<div class="bottom_join">
				<p>아직 아트베이 회원이 아니세요?<a href="/회원가입 주소">회원가입</a></p>
			</div>
		</div>
	</div>
	<!-- 응찰 시작 -->
	<div class="bid_price">
		<p>응찰내역></p>
		<div class="bidList_btn">
			<ul>
				<li>전체</li>
				<li>내 응찰</li>
			</ul>
		</div>
		<div class="bidList">
			<div class="b1">
				<ul>
					<li>2021-12-25</li>
					<li>10:23:00</li>
					<li>4,400,000</li>
				</ul>
			</div>
			<div class="current_bid_price">
				<div>
					<strong>시작가</strong>
					<div>
						<strong>KRW 4,000,000</strong>
					</div>
				</div>
				<div>
					<strong>현재가</strong>
					<div>
						<strong>KRW 11,000,000 (응찰횟수 20회)</strong>
					</div>
				</div>
				<div class="my_choice">
					<strong>응찰가</strong>
					<div class="price_dropdown">
						최고 응찰가를 선택하세요.
					</div>
				</div>
			</div>
			<button class="bid">응찰하기</button>
		</div>
	</div>
</form>
</body>
</html>