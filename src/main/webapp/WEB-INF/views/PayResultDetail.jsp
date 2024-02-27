<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src='http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.5/jquery-ui.min.js'></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>付款成功</title>
<style>
table.table-form {
	table-layout: fixed;
	clear: both
}

table.table-form.table-form-full {
	width: 100%
}

table.table-form.table-form-full>tbody>tr>th {
	width: 150px
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
table.table-form.bootstrap-select.modifyInputWidth:not([class*=span]):not([class*=col-]):not([class*=form-control]):not(.input-group-btn){
width:182px
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
table.table-for:not(){
display:inline-block;
margin:5px;
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
*{
text-align: center;
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
		<iframe src="StepProgressFinish.jsp"
			style="width: 1000px; border: none;"></iframe>
	</div>

	<div class="row"
		style="width: 1000px; margin: 10px auto; border-radius: 10px;">
		<div class="col-sm-12"
			style="padding: 10px; text-align: center; font-size: 25px; font-weight: bold; color:#007799; font-family: 微軟正黑體;">
			付款成功</div>



		<div class="col-sm-12"
			style="padding: 10px; text-align: left; font-size: 20px; font-weight: bold; color: saddlebrown; font-family: 微軟正黑體;">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;訂位代號:<span style="color: orangered;">${flightOrderBean.orderCode}</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;訂單明細</div>

		<!-- 		</div> -->
		<div class="table-line orderDetial_borderVertical">
			<div class="col-sm-10" style="margin-left:10px">
				<div class="form-padding">
				<div style="text-align: left;font-size:20px;font-family:微軟正黑體;margin-left:70px"><strong>${flightOrderDetailGo.departurePlaceBean.cityname}
				<img src="${pageContext.request.contextPath}/images/ggggg.jpg" width=40px height="20px">${flightOrderDetailGo.arrivalPlaceBean.cityname}&nbsp;&nbsp;&nbsp;</strong></div>
					<table class="table-form table-form-full">
						<tbody>
							<tr>
								<th class="loginTable_detail_title">航班資訊</th>
								<td class="orderDetail-tableWrapper">
									<table class="orderDetail-table">
										<thead>
											<tr>
												<th style="background-color:#C63300;color:white">行程</th>
												<th style="background-color:#C63300;color:white">時間</th>
												<th style="background-color:#C63300;color:white">起迄地點</th>
												<th style="background-color:#C63300;color:white">航班</th>
												<th style="background-color:#C63300;color:white">託運行李</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td class="orderDetail-number" rowspan="1">去程</td>
												<td style="width:110px"><fmt:formatDate pattern="yyyy/MM/dd"
														value="${flightOrderDetailGo.departureDate}" /><br>
													<strong style="color:#003377;font-size:16px"><fmt:formatDate pattern="HH:mm"
														value="${flightOrderDetailGo.departureTime}" />-<fmt:formatDate
														pattern="HH:mm" value="${flightOrderDetailGo.arrivalTime}" /></strong></td>
												<td><strong style="font-size:15px">${flightOrderDetailGo.departurePlaceBean.cityname}
													&nbsp;→&nbsp;${flightOrderDetailGo.arrivalPlaceBean.cityname}</strong>

												</td>
												<td style="width:200px"><span><img src="${pageContext.request.contextPath}/images/${flightOrderDetailBack.airlineid}.gif" width="20px">${flightOrderDetailGo.airlineBean.airlinename}</span>
													<span><img src="${pageContext.request.contextPath}/images/icon_f4.png" width="20px">${flightOrderDetailGo.airlineid}${flightOrderDetailGo.flightNumber}</span>
													<span class="orderDetail-cabinClass"> <img src="${pageContext.request.contextPath}/images/icon_f2.png" width="17px"><c:set
															var="cabin">${flightOrderBean.cabin}</c:set> <c:choose>
															<c:when test="${cabin == 'Y'}">經濟艙
 													</c:when>
															<c:when test="${cabin == 'C'}">商務艙
 													</c:when>
															<c:when test="${cabin == 'F'}">頭等艙
 													</c:when>

														</c:choose>
												</span></td>
												<td><img src="${pageContext.request.contextPath}/images/icon_f3.png" width="20px">${BaggageAllowanceGo}</td>

											</tr>

											<tr>
												<td class="orderDetail-devieLine" colspan="5">
													<div class="hz-line"></div>
												</td>
											</tr>
											<tr>

												<td class="orderDetail-number" rowspan="1">回程</td>
												<td style="width:110px"><fmt:formatDate pattern="yyyy/MM/dd"
														value="${flightOrderDetailBack.departureDate}" /><br>

													<strong style="color:#003377;;font-size:16px"><fmt:formatDate pattern="HH:mm"
														value="${flightOrderDetailBack.departureTime}" />-<fmt:formatDate
														pattern="HH:mm"
														value="${flightOrderDetailBack.arrivalTime}" /></strong> </td>

												<td><strong style="font-size:15px">${flightOrderDetailBack.departurePlaceBean.cityname}
													&nbsp;→&nbsp; ${flightOrderDetailBack.arrivalPlaceBean.cityname}</strong>
												</td>
												<td style="width:200px"><span><img src="${pageContext.request.contextPath}/images/${flightOrderDetailBack.airlineid}.gif" width="20px">${flightOrderDetailBack.airlineBean.airlinename}</span>
													<span><img src="${pageContext.request.contextPath}/images/icon_f4.png" width="20px">${flightOrderDetailBack.airlineid}${flightOrderDetailBack.flightNumber}</span>
													<span class="orderDetail-cabinClass"><img src="${pageContext.request.contextPath}/images/icon_f2.png" width="17px"><c:set
															var="cabin">${flightOrderBean.cabin}</c:set> <c:choose>
															<c:when test="${cabin == 'Y'}">經濟艙
 													</c:when>
															<c:when test="${cabin == 'C'}">商務艙
 													</c:when>
															<c:when test="${cabin == 'F'}">頭等艙
 													</c:when>
														</c:choose></span></td>
												<td><img src="${pageContext.request.contextPath}/images/icon_f3.png" width="20px">${BaggageAllowanceBack}</td>
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
								<th class="loginTable_detail_title">票價資訊</th>
								<td class="orderDetail-tableWrapper">
									<table class="orderDetail-table">
										<thead style="background-color: blue">
											<tr  >
												<th style="width:120px;background-color:#0066FF;color:white">票別</th>
												<th  style="width:120px;background-color:#0066FF;color:white">票價</th>
												<th  style="width:120px;background-color:#0066FF;color:white">稅金</th>
												<th  style="width:120px;background-color:#0066FF;color:white" >人數</th>
												<th  style="width:120px;background-color:#0066FF;color:white">小計</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td class="orderDetail-number" rowspan="1">成人票</td>
												<td>${flightOrderBean.adultEquipFare}</td>
												<td>${flightOrderBean.adultTax}</td>
												<td>${flightOrderBean.adultCount}</td>
												<td>${(flightOrderBean.adultEquipFare+flightOrderBean.adultTax)*flightOrderBean.adultCount}</td>
											</tr>

											<tr>
												<td class="orderDetail-devieLine" colspan="5">
													<div class="hz-line"></div>
												</td>
											</tr>
											<c:if test="${flightOrderBean.childCount !=0}">
												<tr>
													<td class="orderDetail-number" rowspan="1">兒童票</td>
													<td>${flightOrderBean.childEquipFare}</td>
													<td>${flightOrderBean.childTax}</td>
													<td>${flightOrderBean.childCount}</td>
													<td>${(flightOrderBean.childEquipFare+flightOrderBean.childTax)*flightOrderBean.childCount}</td>
												</tr>
												<tr>
													<td class="orderDetail-devieLine" colspan="5">
														<div class="hz-line"></div>
													</td>
													
												</tr>
												
											</c:if>
										</tbody>
									</table>
									<div class="container" style="margin-left:210px">總計:<strong style="color:#008844;font-size:15px" >${flightOrderBean.orderTotalAmount}</strong> </div>					
								</td>
							</tr>
							
							<tr>
								<th class="loginTable_detail_title">行李資訊</th>
								<td class="orderDetail-tableWrapper">
									<table class="orderDetail-table">
										<thead>
											<tr>
												<th style="background-color:#00AA00;color:white">航段</th>
												<th style="background-color:#00AA00;color:white">航班</th>
												<th style="background-color:#00AA00;color:white">托運行李</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td style="width:200px"><span>${flightOrderDetailGo.departurePlaceBean.cityname}</span>
													&nbsp;→&nbsp; <span>${flightOrderDetailGo.arrivalPlaceBean.cityname}&nbsp;&nbsp;&nbsp;</span></td>
												<td style="width:200px">${flightOrderDetailGo.airlineid}${flightOrderDetailGo.flightNumber}</td>
												<td style="width:200px">${BaggageAllowanceGo}</td>
											</tr>

											<tr>
												<td class="orderDetail-devieLine" colspan="5">
													<div class="hz-line"></div>
												</td>
											</tr>
											<tr>
												<td>${flightOrderDetailBack.departurePlaceBean.cityname}
													&nbsp;→&nbsp;${flightOrderDetailBack.arrivalPlaceBean.cityname}</td>
												<td>${flightOrderDetailBack.airlineid}${flightOrderDetailBack.flightNumber}</td>
												<td>${BaggageAllowanceBack}</td>
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
								<th class="loginTable_detail_title">乘客資訊</th>
								<td class="orderDetail-tableWrapper">
									<table class="orderDetail-table">
										<thead>
											<tr>
												<th style="width:150px;background-color:#0066FF;color:white">中文姓名</th>
												<th style="width:150px;background-color:#0066FF;color:white">英文姓</th>
												<th style="width:150px;background-color:#0066FF;color:white">英文名</th>
												<th style="width:150px;background-color:#0066FF;color:white">性別</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="passenger" items="${passengers}"
												varStatus="status">
												<tr>
													<td>${passenger.chLastName}${passenger.chFirstName}</td>
													<td>${passenger.lastName}</td>
													<td>${passenger.firstName}</td>
													<td>${passenger.gender}</td>
												</tr>
												<tr>
													<td class="orderDetail-devieLine" colspan="5">
														<div class="hz-line"></div>
													</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</td>
							</tr>


							<tr>
								<th class="loginTable_detail_title">聯絡人資訊</th>
								<td class="orderDetail-tableWrapper">
									<table class="orderDetail-table">
										<thead>
											<tr>
												<th style="width:200px;background-color:#00AA00;color:white">中文姓名</th>
												<th style="width:200px;background-color:#00AA00;color:white">手機號碼</th>
												<th style="width:200px;background-color:#00AA00;color:white">信箱</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td>${flightOrderBean.contactorLastName}${flightOrderBean.contactorFirstName}</td>
												<td>${flightOrderBean.contactorTel}</td>
												<td>${flightOrderBean.contactorEmail}</td>
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

						</tbody>
					</table>
				</div>
			</div>
		</div>



				<div class="col-sm-12"
					style="padding: 10px; text-align: center; font-size: 16px; font-weight: bold; color: saddlebrown; font-family: 微軟正黑體;">
					行程表已寄至聯絡人信箱&nbsp;&nbsp;<span style="color: blue;">${flightOrderBean.contactorEmail}</span>&nbsp;&nbsp;
				</div>
				<div class="col-sm-12"
					style="padding: 10px; text-align: center; font-size: 16px; font-weight: bold; color: saddlebrown; font-family: 微軟正黑體;">
					可至會員專區&nbsp;&nbsp;<span style="color: blue;">查詢訂單紀錄</span>&nbsp;&nbsp;
				</div>
				<div class="col-sm-12"
					style="height:100px;padding: 10px; text-align: center; font-size: 16px; font-weight: bold; color: saddlebrown; font-family: 微軟正黑體;">
					<a style="font-color:gray" href="${pageContext.request.contextPath}/">回首頁</a>
				</div>
				
	</div>
</body>
</html>