<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<title>乘客資訊</title>
<script>
	$(document).ready(function(){
		
			 $("#selCon").change(function(){
				 var select = $("#selCon").val()
				 alert(select);
				 var Gender = $("#gender"+select).val();
				 alert(Gender)
				 if(Gender=="M"){
					 $("#conGender option:eq(1)").attr('selected', true)
				 }else{
					 $("#conGender option:eq(2)").attr('selected', true)
				 }
				 var LastName = $("#chLastName"+select).val();
				 var FirstName =  $("#chFirstName"+select).val();
				 var EngLastName = $("#lastName"+select).val();
				 var EngFirstName = $("#firstName"+select).val();
				 var Date = $("#bornDate"+select).val();
				 $("#conBornDate").val(Date);
				 $("#conChLastName").val(LastName);
				 $("#conChFirstName").val(FirstName);
				 $("#conLastName").val(EngLastName);
				 $("#conFirstName").val(EngFirstName);
				 
				 
			 })
		 
	})
			

</script>
<style>
table.table-form {
	table-layout: fixed;
	clear: both
}

table.table-form.table-form-full {
	width: 100%
}

table.table-form.table-form-full>tbody>tr>th {
	width: 95px
}

table.table-form>tbody>tr>th {
	width: 110px;
	padding: 5px 10px 5px 0;
	border-right: 1px solid #e3e3e3;
	color: #060;
	line-height: 24px;
	vertical-align: top;
	text-align: right
}

table.table-form>tbody>tr>th.required:before {
	vertical-align: bottom;
	content: "*";
	font-size: 24px;
	color: #FF6A11;
	display: inline-block;
	line-height: 18px;
	font-family: "Gudea", "Heiti", "微軟正黑體", "Microsoft JhengHei"
}

table.table-form>tbody>tr>td {
	padding: 5px 5px 5px 10px;
	line-height: 24px;
	vertical-align: middle
}

table.table-form>tbody>tr>td>table {
	margin-bottom: 15px
}

table.table-form>tbody>tr>td>table:last-child {
	margin-bottom: 0px
}

table.table-form>tbody>tr>td>table>tbody>tr>th {
	font-weight: normal
}

table.table-form>tbody>tr>td>table>tbody>tr>td {
	vertical-align: top
}

table.table-form input[type=text] {
	line-height: 18px;
	margin: 0px 10px 0px 0px;
	padding: 4px 8px;
	vertical-align: middle
}

table.table-form input[type=text].input-address {
	margin-top: 10px
}

table.table-form .bootstrap-select .dropdown-menu {
	width: 100%
}

table.table-form .bootstrap-select .dropdown-menu>li>a {
	padding: 3px 15px;
	white-space: normal
}

table
.table-form
.bootstrap-select
.modifyInputWidth
:not
(
[
class
*=
span
]

)
:not

(
[
class
*=
col-
]
)
:not
(
[
class
*=
form-control
]
)
:not
(
.input-group-btn
){
width
:
182
px
}
table.table-form .bootstrap-select .btn {
	padding: 4px 8px
}

table.table-form .bootstrap-select.btn-group {
	margin-bottom: 0;
	margin-right: 10px
}

table.table-form p {
	display: inline-block;
	margin: 0px 0px 5px
}

table
.table-for
:not
(
){
display
:
inline-block
;
margi
5
px
}
table.table-form .name span {
	display: inline-block;
	vertical-align: middle;
	width: 105px;
	line-height: 28px;
	margin-right: 0
}

table.table-form .name input[type=text] {
	display: inline-block
}

table.table-form .name input[type=text]:first-child {
	margin-bottom: 10px
}

.th-head {
	display: inline-block;
	color: #060;
	line-height: 26px;
	vertical-align: middle;
	margin-left: 5px
}

.th-head.required:before {
	vertical-align: bottom;
	content: "*";
	font-size: 24px;
	color: #FF6A11;
	display: inline-block;
	line-height: 18px;
	font-family: "Gudea", "Heiti", "微軟正黑體", "Microsoft JhengHei";
	margin-right: 2px
}

.th-head+.bootstrap-select {
	display: inline-block;
	vertical-align: middle
}

.table-head {
	margin-left: 38px
}

.table-head h4 {
	position: relative;
	margin: 0 10px 0 -20px;
	font-weight: bold;
	padding-left: 10px
}

.table-head h4 .icon-arrowLeft {
	position: absolute;
	top: 7px;
	left: -3px;
	width: 0;
	height: 0;
	border-top: 6px solid transparent;
	border-bottom: 6px solid transparent;
	border-left: 7px solid #e3e3e3
}

.table-head h4, .table-head span, .table-head select {
	display: inline-block;
	line-height: 26px;
	vertical-align: middle
}

.table-head .bootstrap-select .btn {
	padding: 0px 8px;
	margin-bottom: 0px
}

.table-head .bootstrap-select.btn-group {
	margin-bottom: 0
}

td {
	font-size: 12px;
}

.order-title {
	padding: 0 15px;
	overflow: hidden
}

.order-title i.icon-marker {
	float: left;
	font-style: normal;
	display: inline-block;
	width: 40px;
	height: 40px;
	background: url("../images/order/Item_bg.png") no-repeat;
	vertical-align: middle;
	line-height: 40px;
	color: white;
	text-align: center;
	padding-left: 2px
}

.order-title span {
	margin-right: 15px
}

.order-title h6 {
	max-width: 584px;
	margin-left: 15px
}

.order-title h3, .order-title h4, .order-title h5, .order-title h6 {
	float: left;
	display: inline-block;
	vertical-align: middle;
	line-height: 24px
}

.orderDetail-table thead>tr>th {
	border-top: 1px solid #abea45;
	border-bottom: 1px solid #abea45;
	background: #FFDAB9;
	color: #F08080;
	font-size: 14px;
	font-family: "微軟正黑體";
	line-height: 28px;
	vertical-align: middle;
	padding: 0 9px;
	-webkit-font-smoothing: antialiased;
	-moz-osx-font-smoothing: grayscale
}

@media ( min-width :992px) {
	.orderDetail-table thead>tr>th {
		font-size: 13px;
		padding-left: 15px;
		padding-right: 15px
	}
}

.orderDetail-table thead>tr>th:first-child {
	text-align: center;
	width: 35px;
	padding: 0
}

@media ( min-width :992px) {
	.orderDetail-table thead>tr>th:first-child {
		width: 40px
	}
}

@media ( max-width :991px) {
	.orderDetail-table thead>tr>th.orderDetail-airline {
		width: 108px
	}
}

.orderDetail-table tbody>tr>td.orderDetail-devieLine {
	padding: 0;
	line-height: 0
}

.orderDetail-table .hz-line {
	margin: 0;
	border-color: #abea45
}

.hz-line {
	margin: 10px 0px;
	border-top: 1px solid #C4CDBA;
	height: 1px;
	width: 100%;
	display: inline-block;
	vertical-align: middle
}

@media ( min-width :992px) {
	.table-line {
		border-left: 1px solid #e3e3e3;
		border-right: 1px solid #e3e3e3
	}
	.table-line.pad-offset {
		padding: 15px 35px
	}
	.member-login a {
		font-size: 15px
	}
	.member-login input[type=checkbox].css-checkbox+label.css-label {
		font-size: 15px
	}
	.member-login label.css-label {
		margin-left: 220px
	}
	.member-login .input-group {
		margin-left: 120px
	}
}

.cabin-hint-box {
	margin-left: 10px;
	padding: 1px 7px 1px 7px;
	width: 40px;
	height: 20px;
	border-radius: 3px;
	border: solid 1px #4fc83d;
	font-family: MicrosoftJhengHei;
	color: #006600
}

.cabin-hint-box:hover {
	color: #006600
}

.orderDetial_borderVertical {
	border: 1px solid #e3e3e3;
}
</style>
</head>
<body>
	<jsp:include page="Homeheader.jsp" />
	<br>
	<br>
	<br>
	<br>
	<div class="row"
		style="width: 1000px; height: 90px; margin: 10px auto; border-radius: 10px;">
		<iframe src="StepProgressPassengerInfo.jsp"
			style="width: 1000px; border: none;"></iframe>
	</div>

	<div class="container">
		<div class="col-sm-10 order-title">
			<div class="row">

				<h4 style="font-family: 微軟正黑體">
					<strong>訂單明細</strong>
				</h4>

			</div>
		</div>
		<div class="table-line orderDetial_borderVertical">
			<div class="col-sm-10" style="margin-left: 10%">
				<div class="form-padding">
					<table class="table-form table-form-full">
						<tbody>
							<tr>
								<th class="loginTable_detail_title">航班資訊</th>
								<td class="orderDetail-tableWrapper">
									<table class="orderDetail-table">
										<thead>
											<tr>
												<th style="width:50px">行程</th>
												<th style="width:120px">時間</th>
												<th style="width:190px">起迄地點</th>
												<th style="width:120px">航班</th>
												<th style="width:120px">託運行李</th>
											</tr>
										</thead>
										<tbody>


											<tr>

												<td class="orderDetail-number" rowspan="1" style="text-align: center;line-height:72.8px">去程</td>
												<td style="line-height:36.4px"><fmt:formatDate pattern="yyyy/MM/dd"
														value="${flightOrderDetailGo.departureDate}" />&nbsp;&nbsp;&nbsp;<br>
													<fmt:formatDate pattern="HH:mm"
														value="${flightOrderDetailGo.departureTime}" />-<fmt:formatDate
														pattern="HH:mm" value="${flightOrderDetailGo.arrivalTime}" /></td>
												<td style="line-height:72.8px"><span>${flightOrderDetailGo.departurePlaceBean.cityname}</span>
													&nbsp;→&nbsp; <span>${flightOrderDetailGo.arrivalPlaceBean.cityname}&nbsp;&nbsp;&nbsp;</span>

												</td>
												<td style="line-height:24.2px"><span>${flightOrderDetailGo.airlineBean.airlinename}</span><br><span>${flightOrderDetailGo.airlineid}${flightOrderDetailGo.flightNumber}</span><br>
													<span class="orderDetail-cabinClass"> <c:set
															var="cabin">${flightOrderBean.cabin}</c:set> <c:choose>
															<c:when test="${cabin == 'Y'}">經濟艙
 													</c:when>
															<c:when test="${cabin == 'C'}">商務艙
 													</c:when>
															<c:when test="${cabin == 'F'}">頭等艙
 													</c:when>

														</c:choose>
												</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
												<td style="line-height:72.8px"><span>${BaggageAllowanceGo}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></td>

											</tr>

											<tr>
												<td class="orderDetail-devieLine" colspan="5">
													<div class="hz-line"></div>
												</td>
											</tr>
											<tr>

												<td class="orderDetail-number" rowspan="1" style="text-align: center;line-height:72.8px">回程</td>
												<td style="line-height:36.4px"><fmt:formatDate pattern="yyyy/MM/dd"
														value="${flightOrderDetailBack.departureDate}" /><br>

													<fmt:formatDate pattern="HH:mm"
														value="${flightOrderDetailBack.departureTime}" />-<fmt:formatDate
														pattern="HH:mm"
														value="${flightOrderDetailBack.arrivalTime}" /></td>

												<td style="line-height:72.8px"><span>${flightOrderDetailBack.departurePlaceBean.cityname}</span>
													&nbsp;→&nbsp; <span>${flightOrderDetailBack.arrivalPlaceBean.cityname}</span>
												</td>
												<td><span>${flightOrderDetailBack.airlineBean.airlinename}</span><br><span>${flightOrderDetailBack.airlineid}${flightOrderDetailBack.flightNumber}</span><br>
													<span class="orderDetail-cabinClass"><c:set
															var="cabin">${flightOrderBean.cabin}</c:set> <c:choose>
															<c:when test="${cabin == 'Y'}">經濟艙
 													</c:when>
															<c:when test="${cabin == 'C'}">商務艙
 													</c:when>
															<c:when test="${cabin == 'F'}">頭等艙
 													</c:when>
														</c:choose></span></td>
												<td style="line-height:72.8px"><span>${BaggageAllowanceBack}</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

												</td>
											</tr>

											<tr>
												<td class="orderDetail-devieLine" colspan="5">
													<div class="hz-line"></div>
												</td>
											</tr>

										</tbody>
									</table>
								</td>
							</tr>
							<tr>
								<th class="loginTable_detail_title">票價</th>
								<td><span class="ticketTaxData">
										成人票${flightOrderBean.adultCount}人(每人${flightOrderBean.adultEquipFare}+稅金${flightOrderBean.adultTax})
										<c:if test="${flightOrderBean.childCount !=0}">									
									+兒童票${flightOrderBean.childCount}人(每人${flightOrderBean.childEquipFare}+稅金${flightOrderBean.childTax})									
									</c:if>
								</span></td>
							</tr>
							<tr class="hide" id="addPurchase">
								<th class="loginTable_detail_title">應付總額</th>
								<td id="orderDetailTotal" data-original-price="5981"><span
									class="orange-dark" style="color: red; font-size: 20px">${flightOrderBean.orderTotalAmount}</span>元含稅</td>
							</tr>
							<tr>
								<th class="loginTable_detail_title"  style="color:gray ">說明</th>

								<td style="padding-left: 15px">
									<ol class="orderDetail-info">
										<li style="color:gray ">以上航班時間為起飛地和抵達地之當地時間，並以24小時制標示；航班時間有時會變動，須依航空公司公告為準。</li>
										<li  style="color:gray ">訂購成功後，請即時於線上完成付款，逾時未付將自動取消訂單及機位。</li>
										<li  style="color:gray ">如更改必須於原搭乘日前２個工作日完成。(國定假日無法提供更改服務)</li>
										<li  style="color:gray ">部分航班資訊可能於連線過程中產生變動，下單前請務必檢閱訂單明細。</li>
									</ol>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<div class="col-sm-10 order-title">
			<div class="row">

				<h4 style="font-family: 微軟正黑體">
					<strong>乘客資訊</strong>
				</h4>

			</div>
		</div>
		<form class="table-line orderDetial_borderVertical" method="post" action="updatePassenger">
			<div class="col-sm-8" style="padding: 10px; margin-left: 15%">
				<div class="card">

					<div class="card-body" style="color: orange">
						<c:forEach var="passenger" items="${passengers}"
							varStatus="status">
							<fieldset
								style="border-top: 1px solid papayawhip; padding: 10px;">
								<legend
									style="padding: 5px 10px; color: orange; width: 120px; font-size: 16px; font-weight: bold;">
									旅客${status.index+1}(
									<c:set var="passengerType">${passenger.passengerType}</c:set>
									<c:choose>
										<c:when test="${passengerType == 'C' }">
											<span>兒童</span>
										</c:when>
										<c:otherwise>
											<span>成人</span>
										</c:otherwise>
									</c:choose>
									)
								</legend>
								<div class="row">
									<div class="col-sm-6 input-group mb-3">
										<div class="input-group-prepend">
											<span class="input-group-text"
												style="font-family: 微軟正黑體; font-size: 14px;">稱謂</span>
										</div>
										<select class="form-control" id="gender${status.index+1}"
											name="gender${passenger.passengerID}"
											style="height: 39px; font-family: 微軟正黑體; font-size: 14px;">
											<option value="X" selected="selected" disabled="disabled">請選擇</option>
											<c:choose>
												<c:when test="${passengerType == 'C' }">
													<option value="M">男孩</option>
													<option value="F">女孩</option>
												</c:when>
												<c:otherwise>
													<option value="M">先生</option>
													<option value="F">小姐</option>
												</c:otherwise>
											</c:choose>
										</select>
									</div>
									<div class="col-sm-6 input-group mb-3">
										<div class="input-group-prepend">
											<span class="input-group-text"
												style="font-family: 微軟正黑體; font-size: 14px;">生日</span>
										</div>
										<input class="form-control input-sm" type="date"
											name="bornDate${passenger.passengerID}"
											id="bornDate${status.index+1}"
											style="font-family: 微軟正黑體; font-size: 14px;"
											autocomplete="off" >
									</div>
								</div>
								<div class="input-group mb-3">
									<div class="input-group-prepend">
										<span class="input-group-text"
											style="font-family: 微軟正黑體; font-size: 14px;">中文姓名</span>
									</div>
									<input type="text" class="form-control"
										name="chLastName${passenger.passengerID}"
										id="chLastName${status.index+1}"
										style="font-family: 微軟正黑體; font-size: 14px;"
										placeholder="中文姓氏"> 
										<input type="text"
										style="font-family: 微軟正黑體; font-size: 14px;"
										class="form-control"
										name="chFirstName${passenger.passengerID}"
										id="chFirstName${status.index+1}" placeholder="中文名字" >
								</div>
								<div class="input-group mb-3">
									<div class="input-group-prepend">
										<span class="input-group-text"
											style="font-family: 微軟正黑體; font-size: 14px;">英文姓名</span>
									</div>
									<input type="text" class="form-control"
										name="lastName${passenger.passengerID}"
										style="font-family: 微軟正黑體; font-size: 14px;"
										id="lastName${status.index+1}" placeholder="英文姓氏，需與護照相同" >
									<input type="text" style="font-family: 微軟正黑體; font-size: 14px;"
										id="firstName${status.index+1}" class="form-control"
										name="firstName${passenger.passengerID}"
										placeholder="英文名字，需與護照相同">
								</div>
							</fieldset>
							<c:choose>
								<c:when test="${status.last}">
								</c:when>
								<c:otherwise>
									<br>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</div>
				</div>
				<hr>
				<div class="card">
					<div class="card-body" style="color: orange">
						<fieldset style="border-top: 1px solid papayawhip; padding: 10px;">
							<div class="row">
								<label
									style="padding: 5px 10px; color: green; width: 70px; font-size: 16px; font-weight: bold;">聯絡人</label>
								<div class="col-sm-4 input-group mb-2">
									<div class="input-group-prepend">
										<span class="input-group-text"
											style="font-family: 微軟正黑體; font-size: 12px; height: 30px; background-color: gray">同旅客</span>
									</div>
									<select class="form-control" id="selCon" name="gender"
										style="height: 30px; font-family: 微軟正黑體; font-size: 14px;">
										<option value="X" selected="selected" disabled="disabled">請選擇旅客</option>
										<c:forEach var="passenger" items="${passengers}"
											varStatus="status">
											<c:set var="passengerType">${passenger.passengerType}</c:set>
											<c:choose>
												<c:when test="${passengerType == 'A' }">
													<option value="${status.index+1}">旅客${status.index+1}&nbsp;(成人)</option>
												</c:when>
											</c:choose>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-6 input-group mb-3">
									<div class="input-group-prepend">
										<span class="input-group-text"
											style="font-family: 微軟正黑體; font-size: 14px;">稱謂</span>
									</div>
									<select class="form-control" id="conGender" name="gender"
										style="height: 36px; font-family: 微軟正黑體; font-size: 14px;">
										<option value="X" selected="selected" disabled="disabled">請選擇</option>
										<option value="M">先生</option>
										<option value="F">女士</option>
									</select>
								</div>
								<div class="col-sm-6 input-group mb-3">
									<div class="input-group-prepend">
										<span class="input-group-text"
											style="font-family: 微軟正黑體; font-size: 14px;">生日</span>
									</div>
									<input class="form-control input-sm" type="date"
										name="bornDate" id="conBornDate"
										style="font-family: 微軟正黑體; font-size: 14px;"
										autocomplete="off">
								</div>
							</div>
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<span class="input-group-text"
										style="font-family: 微軟正黑體; font-size: 14px;">中文姓名</span>
								</div>
								<input type="text" class="form-control"
									name="chContactorLastName" id="conChLastName"
									style="font-family: 微軟正黑體; font-size: 14px;" placeholder="中文姓">
								<input type="text" class="form-control"
									name="chContactorFirstName" id="conChFirstName"
									style="font-family: 微軟正黑體; font-size: 14px;" placeholder="中文名">
							</div>
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<span class="input-group-text"
										style="font-family: 微軟正黑體; font-size: 14px;">英文姓名</span>
								</div>
								<input type="text" class="form-control" name="lastName"
									style="font-family: 微軟正黑體; font-size: 14px;" id="conLastName"
									placeholder="需與護照相同"> <input type="text"
									class="form-control" name="firstName" id="conFirstName"
									style="font-family: 微軟正黑體; font-size: 14px;"
									placeholder="需與護照相同">
							</div>
							<div class="row">
								<div class="col-sm-5 input-group mb-3">
									<div class="input-group-prepend">
										<span class="input-group-text"
											style="font-family: 微軟正黑體; font-size: 14px;">電話</span>
									</div>
									<input class="form-control input-sm" type="text"
										style="font-family: 微軟正黑體; font-size: 14px;" id="conTel"
										name="contactorTel" autocomplete="off">
								</div>
								<div class="col-sm-7 input-group mb-3">
									<div class="input-group-prepend">
										<span class="input-group-text"
											style="font-family: 微軟正黑體; font-size: 14px;">E-mail</span>
									</div>
									<input class="form-control input-sm" type="email"
										name="contactorEmail" id="conEmail"
										value="${member.userEmail}"
										style="font-family: 微軟正黑體; font-size: 14px;"
										autocomplete="off">
								</div>
							</div>
						</fieldset>
					</div>
					<div class="form-group form-check">
						<label class="form-check-label" style="color: gray"> <input
							class="form-check-input" id="agree" type="checkbox">我已詳細閱讀<span
							style="color: brown">航班條款與訂購須知</span>，並同意遵守上述事項。
						</label>
					</div>
					<div class="row" style="text-align: center;">
						<div class="col-sm-12">
							<button type="submit" id="goPay" disabled="disabled"
								class="btn btn-success float-sm-center">下一步
								</button>
						</div>
					</div>
					<br>
				</div>
				<br> <br>
			</div>
		</form>
	</div>
	
	<script>
		document.getElementById("agree").onchange = function() {
			$("#goPay").removeAttr("disabled");
		}
	</script>
</body>
</html>