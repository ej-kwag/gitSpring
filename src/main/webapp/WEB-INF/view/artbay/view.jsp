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
			<p>μ¬μ§</p>
			<br/>
			<p id="like">β€οΈ</p>
			<p id="share">π</p>
			<p id="magnifier">π</p>
		</div>
		<div class="view_detail">
			<p class="writer"><span>μκ° μ΄λ¦</span></p>
		</div>
		<div class="deadline_time">
			<span>λ¨μ μκ°</span>
			<span class="remainTime"></span>
		</div>
		<div class="price">
			<p>
				<strong>μΆμ κ°</strong>
					KRW 6,000,000~8,000,000
			</p>
			<p>
				<strong>μμκ°</strong>
					KRW 4,000,000
			</p>
			<p>
				<strong>νμ¬κ°</strong>
					KRW 9,000,000
			</p>
		</div>
		<div class="rigt_modal">
			<div class="closing_hour">
				λ§κ° μκ°
				<span>01/04 - 04:00 PM</span>
			</div>
			<ul>
				<li class="right_modal_btn">
					<p><span>λμ°° μμλ£</span></p>
				</li>
				<li class="right_modal_btn">
					<p><span>μμ λ°°μ‘λΉ</span></p>
				</li>
				<li class="right_modal_btn">
					<p><span>κ²½λ§€ νΈκ°ν</span></p>
				</li>
				<li class="right_modal_btn">
					<p><span>μ€μΉ λ° λ³΄κ΄</span></p>
				</li>
			</ul>
		</div>
	</div>
	<div class="work_info">
		<h3>μν μ λ³΄</h3>
		<div class="cont">
			<p> signed, titled and dated on the reverse<br/>Acrylic Frame </p>
		</div>
	</div>
	<div class="caution">
		<h3>Condition Report</h3>
			<div class="inquiry">
				<li>μ€λ¬Όμ λ°λμ νμΈν ν μμ°° λ°λλλ€. μ€λ¬Όμ νμΈνμ§ μμ λ°μλλ λ¬Έμ μ λν μ±μμ μμ°°μμκ² μμ΅λλ€.</li>
			</div>
	</div>	
	<!-- λμ°° μμλ£ λͺ¨λ¬ -->
	<div class="rightmodal_m1" style="border:1px solid grey;">
		<div class="modal_title">
			<p>λμ°° μμλ£ μλ΄</p>
		</div>
		<div class="modal_body">
			<table class="commission_rate">
				<thread>
					<tr>
						<th scope="col" class="bid">λμ°°κ° (μ)</th>
						<th scope="col" class="cm_rate">μμλ£μ¨ (VAT ν¬ν¨)</th>
					</tr>
				</thread>
				<tbody>
					<tr>
						<td>~ 10,000,000</td>
						<td> λμ°°κ°μ 19.8%</td>
					</tr>
					<tr>
						<td>10,000,001</td>
						<td>1,000λ§μ x 19.8% + (λμ°°κ°-1,000λ§μ) x 16.5%</td>
					</tr>
				</tbody>
				<div class="exam">
					<p>μμ&#41; λμ°°κ° 5,000λ§μμΌ κ²½μ°</p>
					<p>λμ°° μμλ£ :</p>
					<p>198λ§μ + (5,000λ§μ - 1,000λ§μ) * 16.5% = 8,580,000μ</p>
					<p>μ΄ κ΅¬λ§€λκΈ :</p>
					<p>λμ°°κ° + λμ°°μμλ£ = 58,580,000μ</p>
				</div>
			</table>
		</div>
	</div>
	<!-- λ°°μ‘ λͺ¨λ¬ -->
	<div class="rightmodal_m2">
		<div class="modal_title">
			<p>λ°°μ‘ κ΄λ ¨ μλ΄</p>
		</div>
		<div class="modal_body">
			<ul>
				<li> μ¨λΌμΈ κ²½λ§€μ λμ°°μμ μ§μ  ν½μμ΄ μμΉμ΄λ, λΆκ°λ₯ν κ²½μ° λ°°μ‘μ μμ²­ν  μ μμΌλ©°, μλμ κ°μ΄ λ°°μ‘λΉκ° λΆκ³Ό λ©λλ€.
					<div class="table">
						<table>
							<tbody>
								<tr>
									<td colspan="2">κ΅­λ΄</td>
									<td colspan="2">ν΄μΈ</td>
								</tr>
								<tr>
									<td class="place" style="width: 25%;">μμΈ</td>
									<td style="width: 25%;">5λ§μ</td>
									<td colspan="2"	rowspan="3" style="width: 50%;">λ³λ λ°°μ‘λΉ
								</tr>
								<tr>
									<td class="place">μλκΆ</td>
									<td>10λ§μ</td>
								</tr>
								<tr>
									<td class="place">κ·Έ μΈ κ΅­λ΄μ§μ­</td>
									<td>15λ§μ</td>
								</tr>
							</tbody>
						</table>
					</div>
				</li>
			</ul>
		</div>
	</div>
	<!-- κ²½λ§€ νΈκ°ν λͺ¨λ¬-->
	<div class="rigtmodal_m3">
		<div class="modal_title">
			κ²½λ§€ νΈκ°ν μλ΄
		</div>
		<div class="modal_body">
			<table class="bid_price_standard">
				<tr>
					<th scope="col">νμ¬κ° κ΅¬κ° (μ)</th>
					<th scope="col">νΈκ° λ¨μ (μ)</th>
				</tr>
				<tbody>
					<tr>
						<td>30λ§ λ―Έλ§</td>
						<td>20,000</td>
					</tr>
					<tr>
						<td>30λ§ μ΄μ ~ 100λ§ λ―Έλ§</td>
						<td>50,000</td>
					</tr>
					<tr>
						<td>100λ§ μ΄μ ~ 300λ§ λ―Έλ§</td>
						<td>100,000</td>
					</tr>
					<tr>
						<td>300λ§ μ΄μ ~ 500λ§ λ―Έλ§</td>
						<td>200,000</td>
					</tr>
					<tr>
						<td>500λ§ μ΄μ ~ 1,000λ§ λ―Έλ§</td>
						<td>500,000</td>
					</tr>
					<tr>
						<td>1,000λ§ μ΄μ ~ 3,000λ§ λ―Έλ§</td>
						<td>1,000,000</td>
					</tr>
					<tr>
						<td>3,000λ§ μ΄μ ~ 5,000λ§ λ―Έλ§</td>
						<td>2,000,000</td>
					</tr>
					<tr>
						<td>5,000λ§ μ΄μ ~ 2μ΅ λ―Έλ§</td>
						<td>5,000,000</td>
					</tr>
					<tr>
						<td>2μ΅ μ΄μ ~ 5μ΅ λ―Έλ§</td>
						<td>10,000,000</td>
					</tr>
					<tr>
						<td>5μ΅ μ΄μ</td>
						<td>20,000,000</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<!-- μ€μΉ λ° λ³΄κ΄ λͺ¨λ¬-->
	<div class="rigtmodal_m4">
		<div class="modal_title">
			<p>μ€μΉ λ° λ³΄κ΄ μλ΄</p>
		</div>
		<div class="modal_body">
			<p>λΉμ¬ λμ°° μ νμ ννμ¬ λ°°μ‘ μ μ€μΉλ₯Ό ν¨κ» μμ²­νμ€ μ μμΌλ©°, μ¬μ  μμ½μ΄ νμν©λλ€.</p>
			<p>λμ°° λ° νλ§€ μ΄ν 7μΌ κ²½κ³Ό μ μκΈμ¬λΆμ λ¬΄κ΄νκ² μΌ 30,000μ/μ μ λΉμ©μ΄ λ°μν©λλ€.</p>
		</div>
	</div>
	<!-- λ‘κ·ΈμΈ λͺ¨λ¬ -->
	<div class="login">
		<h3> LOGIN </h3>
		<input type="text" id="mid" placeholder="μμ΄λ" /><br/>		
		<input type="password" id="pwd" placeholder="λΉλ°λ²νΈ" /><br/>
		<p><span> λ‘κ·ΈμΈνμλ©΄ μμ°°μ΄ κ°λ₯ν©λλ€.</span></p>
		<div class="login_modal_btn">
			<div>
				<input type="checkbox" id="check_login" value="0" />
				<label for="check_login">λ‘κ·ΈμΈ μν μ μ§</label>
			</div>
			<div>
				<a href="/μμ΄λμ°ΎκΈ° μ£Όμ">μμ΄λ μ°ΎκΈ°</a>
				<a href="/λΉλ°λ²νΈμ°ΎκΈ° μ£Όμ">λΉλ°λ²νΈ μ°ΎκΈ°</a>
			</div>
			<button type="button">
				<span>λ‘κ·ΈμΈ</span>
			</button>
			<div class="bottom_join">
				<p>μμ§ μνΈλ² μ΄ νμμ΄ μλμΈμ?<a href="/νμκ°μ μ£Όμ">νμκ°μ</a></p>
			</div>
		</div>
	</div>
	<!-- μμ°° μμ -->
	<div class="bid_price">
		<p>μμ°°λ΄μ­></p>
		<div class="bidList_btn">
			<ul>
				<li>μ μ²΄</li>
				<li>λ΄ μμ°°</li>
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
					<strong>μμκ°</strong>
					<div>
						<strong>KRW 4,000,000</strong>
					</div>
				</div>
				<div>
					<strong>νμ¬κ°</strong>
					<div>
						<strong>KRW 11,000,000 (μμ°°νμ 20ν)</strong>
					</div>
				</div>
				<div class="my_choice">
					<strong>μμ°°κ°</strong>
					<div class="price_dropdown">
						μ΅κ³  μμ°°κ°λ₯Ό μ ννμΈμ.
					</div>
				</div>
			</div>
			<button class="bid">μμ°°νκΈ°</button>
		</div>
	</div>
</form>
</body>
</html>