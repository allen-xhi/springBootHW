<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-TW">
<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="IE=edge, chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale = 1.0, maximum-scale=1.0, user-scalable=no" />
<meta http-equiv="Content-Language" content="zh-TW" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>

<!-- Icon -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.1.0/css/all.css"
	integrity="sha384-lKuwvrZot6UHsBSfcMvOkWwlCMgc0TaWr+30HWe3a4ltaBwTZhyTEggF5tJv8tbt"
	crossorigin="anonymous">

<!-- Jquery UI -->
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"
	integrity="sha256-VazP97ZCwtekAsvgPBSUwPFKdrwD3unUfSGVYrahUqU="
	crossorigin="anonymous"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/bootstrap-popover.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/bootstrap-tooltip.js"></script>

<title>機票搜尋</title>
<style>
#selectFormDiv {
	height: 65px;
	background-color:#FFF8DC;
	position: fixed;
	top: 94px;
	z-index: 999999;
	display: table-row;
	width: 100%;
	text-align: center;
	font-family: 微軟正黑體;
	font-size: 14px;

	
}

#selectFormRow {
	width: 100%;
	margin: 0;
}

#tripTypeDiv, #departureCityDiv, #arrivalCityDiv, #goDateDiv,
	#backDateDiv, #classTypeDiv {
	margin: 0px 5px;
}

#tripTypeDivLabel, #classTypeDivLabel, #adultDivLabel, #childDivLabel {
	width: 30px;
}

#departureCityDivLabel {
	width: 50px;
	text-align: left;
}

#arrivalCityDivLabel {
	width: 50px;
}

#goDateDivLabel, #backDateDivLabel {
	width: 70px;
}

#adultDiv {
	margin: 10px 0px 10px 5px;
}

#childDiv {
	margin: 10px 10px 10px 0px;
}

#selectFormSubmit {
	margin: 10px 0px;
}

#mainRow {
	width: 90%;
	margin: 10px auto;
	border-radius: 10px;
	/* 	border: 1px solid gray; */
	font-family: 微軟正黑體;
	font-size: 14px;
	
}

#mainRowLeft4, #mainRowRight8 {
	
	
	
}
#mainRowLeft4{
margin
}


#timeSliderCardHeader, #selectByAirlineCardHeader,
	#airlineNameCardHeader {
	font-weight: bold;
	
}

#timeSliderIFrame {
	width: 275px;
	height: 350px;
	border: none;
}

#pricePerTicketCardHeader, #ticketButtonRow {
	text-align:right;
}

.tripAndTime {
	font-size: 18px;
}

#arrowBetweenTripAndTime {
	font-size: 24px;
	padding-top: 10px;
}

#planeIconInFlightDetail {
	font-size: 14px;
}

#tableOfPriceDetail2, #tableOfBaggageInfo1 {
	border: 1px solid #dee2e6;
}

#tableOfBaggageInfo2 {
	border-bottom: 1px solid #dee2e6;
}

#tdOfBaggageInfo2No {
	width: 50px;
	text-align: center;
	font-weight: bold;
}

#tableOfPriceDetail1 {
	text-align: center;
	border: 1px solid #dee2e6;
}

#tableOfPriceDetail1Total {
	text-align: right;
}

.tableOfPriceDetail1TotalAmt {
	color: red;
}

#tableOfPriceDetail2-1 {
	width: 100px;
	text-align: center;
	background-color: #e9ecef;
}

#tableOfPriceDetail2-2 {
	width: 100px;
	text-align: center;
	background-color: #e9ecef;
	padding-top: 32px;
}

#tableOfPriceDetail2-3 {
	width: 100px;
	text-align: center;
	background-color: #e9ecef;
	padding-top: 20px;
}
.t-line{border-top:2px dotted black;position:relative;margin:2px auto}

t-line:before,.t-line:after{content:'';position:absolute;top:50%;-o-transform:translateY(-50%);-webkit-transform:translateY(-50%);-moz-transform:translateY(-50%);-ms-transform:translateY(-50%);transform:translateY(-50%);width:8px;height:8px;border-radius:100%;background-color:#fff;border:2px #ccc solid}.t-line:before{left:-8px}.t-line:after{right:-8px}
</style>
</head>
<body>
	<jsp:include page="Homeheader.jsp" />


	<div id="selectFormDiv">
		<div class="row" id="selectFormRow" >
			<form class="form-inline" style="height: 54px; width: 100%"
				method="POST"
				action="${pageContext.request.contextPath}/showticketsearch">
				<div id="tripTypeDiv" style="margin-left: 10%">
					<label id="tripTypeDivLabel" for="tripType" style="color:gray">航段</label> <select
						class="form-control form-control-sm" name="tripType">
						<option value="1" selected="selected" style="color:gray">來回</option>
						<option value="0" style="color:gray">單程</option>
					</select>
				</div>
				<div id="departureCityDiv">
					<label id="departureCityDivLabel" for="orgin" style="color:gray">出發地</label> <input
						class="form-control form-control-sm" id="orgin"
						style="width: 130px" type="text" name="orgin" placeholder="請選擇出發地"
						autocomplete="off" value="${ticketsearch.orgin}">
				</div>
				<div id="arrivalCityDiv">
					<label id="arrivalCityDivLabel" for="destination" style="color:gray">目的地</label> <input
						class="form-control form-control-sm" id="destination"
						style="width: 130px" type="text" name="destination"
						placeholder="請選擇目的地" autocomplete="off"
						value="${ticketsearch.destination}">
				</div>
				<div id="goDateDiv">
					<label id="goDateDivLabel" for="departdatepicker" style="color:gray">出發日期</label> <input
						class="form-control form-control-sm" id="departdatepicker"
						type="date" style="width: 150px" name="departdatepicker"
						autocomplete="off" value="${ticketsearch.departdatepicker}">
				</div>
				<div id="backDateDiv">
					<label id="backDateDivLabel" for="returndatepicker" style="color:gray">回程日期</label> <input
						class="form-control form-control-sm" id="returndatepicker"
						type="date" style="width: 150px" name="returndatepicker"
						autocomplete="off" value="${ticketsearch.returndatepicker}">
				</div>
				<div id="classTypeDiv">
					<label id="cabinsDivLabel" for="cabintype" style="color:gray">艙等</label> <select
						class="form-control form-control-sm" name="cabintype">
						<c:forEach var="cabin" items="${cabins}">
							<c:set var="cabinid">${cabin.cabinid}</c:set>
							<option value="${cabin.cabinid}"
								${cabinid == ticketsearch.cabintype ? 'selected' : ''}>${cabin.cabinname}</option>
						</c:forEach>
					</select>
				</div>
				<div id="adultDiv">
					<label id="adultDivLabel" for="adult" style="color:gray">成人</label> <select
						class="form-control form-control-sm" data-label="成人" name="adult">
						<c:forEach var="i" begin="1" end="9" step="1">
							<option value="${i}" ${i == ticketsearch.adult ? 'selected' : ''}>${i}位</option>
						</c:forEach>
					</select>
				</div>
				<div id="childDiv">
					<label id="childDivLabel" for="child" style="color:gray">兒童</label> <select
						class="form-control form-control-sm" name="child">
						<c:forEach var="i" begin="0" end="4" step="1">
							<option value="${i}" ${i == ticketsearch.child ? 'selected' : ''}>${i}位</option>
						</c:forEach>
					</select>
				</div>
				<div id="selectFormSubmit" style="margin: auto">
					<input type="submit" style="font-size: 14px;"
						class="btn btn-success" value="修改條件">
				</div>
			</form>
		</div>
	</div>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<div id="mainRow" class="row">
		<div id="mainRowLeft4" class="col-sm-4">
			<div class="card">
				<div id="timeSliderCardHeader" class="card-header">根據時間搜索</div>
				<div class="card-body">
					<iframe id="timeSliderIFrame" src="TimeSlider.jsp"></iframe>
				</div>
			</div>
			<div class="card">
				<div id="selectByAirlineCardHeader" class="card-header">根據航空公司搜索</div>
				<div id="selectByAirlineCardBody" class="card-body">
					<div class="form-check">
						<label class="form-check-label"> <input type="checkbox"
							class="form-check-input" value="ALL" checked="checked">全部顯示
						</label>
					</div>
					<c:forEach var="ticketresultByAirline"
						items="${ticketresultsByAirline}">
						<div class="row">
							<div class="col-sm-6">
								<div class="form-check">
									<label class="form-check-label"> <input type="checkbox"
										class="form-check-input" name="selectedAirline"
										value="${ticketresultByAirline.value.OperatingAirlineCodeGo}">${ticketresultByAirline.value.OperatingAirlineNameGo}&nbsp;(${ticketresultByAirline.value.times})
									</label>
								</div>
							</div>
							<div class="col-sm-6" style="font-family:微軟正黑體;color:red">
								TWD$${ticketresultByAirline.value.EquivFareAdult}&nbsp;起</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>

		<div id="mainRowRight8" class="col-sm-8" >

			<c:forEach var="ticketsearchresults" items="${ticketsearchresults}"
				varStatus="status">
				<div class="card"  
					id="ALL${ticketsearchresults.OperatingAirlineCodeGo}${status.index+1}">
					
					<script >		
		$("#ALL${ticketsearchresults.OperatingAirlineCodeGo}${status.index+1}").hover(function(){
    $("#ALL${ticketsearchresults.OperatingAirlineCodeGo}${status.index+1}").css("border","2px solid gray");
    $("#ALL${ticketsearchresults.OperatingAirlineCodeGo}${status.index+1}").css("background","#FFF8DC");
},function(){
    $("#ALL${ticketsearchresults.OperatingAirlineCodeGo}${status.index+1}").css("border","none");
    $("#ALL${ticketsearchresults.OperatingAirlineCodeGo}${status.index+1}").css("background","none");
  
})
		</script>
					<div class="card-header">
						<div class="row" style="height:25px">
							<div id="airlineNameCardHeader" class="col-sm-6" style="font-weight:bold;font-size:20px"><em>${ticketsearchresults.OperatingAirlineNameGo}&nbsp;<img src="images/${ticketsearchresults.OperatingAirlineCodeGo}.gif" style="width:20px;margin-bottom: 3px"></em> </div>
							<div id="pricePerTicketCardHeader" class="col-sm-6">
								
								<label
									id="${ticketsearchresults.OperatingAirlineCodeGo}${status.index+1}" style="font-size: 25px; font-family: 微軟正黑體; color: red; font-weight: bold;" ></label>/每成人
							<!-- /////////////////////////////////////////////////////////////////	 -->							
									<script>
								var b = "${ticketsearchresults.EquivFareAdult}".replace(",","");
								var p = parseInt(b);
								var addpercent =parseInt(${addpercent});
								var addprice =parseInt(${addprice});
								var price = (p*addpercent)+addprice;			
							     document.getElementById("${ticketsearchresults.OperatingAirlineCodeGo}${status.index+1}").innerHTML ="NT$"+price;															
								</script>
			<!-- /////////////////////////////////////////////////////////////////	 -->
							</div>
						</div>
					</div>
					<div class="card-body" style="padding-bottom: 0">
						<div class="row">
							<div class="col-sm-3">
								<b class="tripAndTime" style="color:gray">去程</b><br>
							</div>
							<div class="col-sm-2" style="padding-right:0">
							<i class="tripAndTime" style="font-color:gray;font-size: 12px">${ticketsearchresults.DepartureDateGo}</i><br>
								<b class="tripAndTime">${ticketsearchresults.DepartureTimeGo}</b>
								<br>${ticketsearchresults.DepartureAirportLocationNameGo}
							</div>
							<div class="col-sm-1"style="padding-left:0;text-align:center;line-height:68px">
								<img src="${pageContext.request.contextPath}/images/icon_f4.png" width="40px">
							</div>
							<div class="col-sm-4">
							<i class="tripAndTime" style="font-color:gray;font-size: 12px">${ticketsearchresults.ArrivalDateGo}</i><br>
								<b class="tripAndTime">${ticketsearchresults.ArrivalTimeGo}</b>
								<br>${ticketsearchresults.ArrivalAirportLocationNameGo}
							</div>
							<div class="col-sm-2" style="text-align: center">
								<b class="tripAndTime">${ticketsearchresults.ElapsedTimeGo}</b>
								<br>直達
							</div>
						</div>
						<hr>
						<div class="row">
							<div class="col-sm-3">
								<b class="tripAndTime" style="color:gray">回程</b><br>
							</div>
							<div class="col-sm-2" style="padding-right:0">
							<i class="tripAndTime" style="font-color:gray;font-size: 12px">${ticketsearchresults.DepartureDateBack}</i><br>
								<b class="tripAndTime">${ticketsearchresults.DepartureTimeBack}</b>
								<br>${ticketsearchresults.DepartureAirportLocationNameBack}
							</div>
							<div class="col-sm-1" style="padding-left:0;text-align:center;line-height:68px">
								<i><img src="${pageContext.request.contextPath}/images/icon_f4.png" width="40px"></i>
							</div>
							<div class="col-sm-4">
							<i class="tripAndTime" style="font-color:gray;font-size: 12px">${ticketsearchresults.ArrivalDateBack}</i><br>
								<b class="tripAndTime">${ticketsearchresults.ArrivalTimeBack}</b>
								<br>${ticketsearchresults.ArrivalAirportLocationNameBack}
							</div>
							<div class="col-sm-2" style="text-align: center;">
								<b class="tripAndTime">${ticketsearchresults.ElapsedTimeBack}</b>
								<br>直達
							</div>
						</div>
						<br>
						<div class="row">
							<div  class="col-sm-12">
							
							<button type="button" class="btn btn-info" style="text-align:left;font-size: 14px;background-color:gray;border-color:gray"
									data-toggle="collapse" 
									data-target="#detailInfo${status.index+1}">詳細資訊</button>
					
								<button type="button" id="orderGo${status.index+1}"
									style="font-size: 25px; background-color: orange; border-color: orange;margin-left:70%;margin-right:0;border-radius:2px"
									class="btn btn-success">&nbsp;訂票<i id="arrowBetweenTripAndTime" class="fa fa-arrow-right fa-1"></i></button>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-12">
								<div id="detailInfo${status.index+1}" class="collapse">
									<ul class="nav nav-tabs">
										<li class="nav-item"><a class="nav-link active"
											data-toggle="tab" href="#flightDetail${status.index+1}">航班詳情</a></li>
										<li class="nav-item"><a class="nav-link"
											data-toggle="tab" href="#luggageDetail${status.index+1}">行李說明</a></li>
										<li class="nav-item"><a class="nav-link"
											data-toggle="tab" href="#priceDetail${status.index+1}">票價資訊</a></li>
									</ul>
									<div class="tab-content">
										<div class="tab-pane container active"
											id="flightDetail${status.index+1}">
											<br>
											<div class="row">
												<div class="col-sm-2">
													<button type="button" class="btn btn-dark"
														disabled="disabled">
														去程&nbsp;<i id="planeIconInFlightDetail"
															class="fa fa-plane"></i>
													</button>
												</div>
												<div class="col-sm-3">
													<b class="tripAndTime"
														id="DepartureTimeGo${status.index+1}">${ticketsearchresults.DepartureTimeGo}</b>
												</div>
												<div class="col-sm-1"></div>
												<div class="col-sm-3">
													<b class="tripAndTime" id="ArrivalTimeGo${status.index+1}">${ticketsearchresults.ArrivalTimeGo}</b>
												</div>
												<div class="col-sm-3"></div>
											</div>
											<div class="row">
												<div class="col-sm-2"></div>
												<div class="col-sm-3">${ticketsearchresults.DepartureAirportLocationNameGo}</div>
												<div class="col-sm-1">
													<i class="fa fa-arrow-right" id="planeIconInFlightDetail"></i>
												</div>
												<div class="col-sm-3">${ticketsearchresults.ArrivalAirportLocationNameGo}</div>
												<div class="col-sm-3" ><img src="images/${ticketsearchresults.OperatingAirlineCodeGo}.gif" style="width:20px;margin-bottom: 3px">${ticketsearchresults.OperatingAirlineNameGo}&nbsp;${ticketsearchresults.OperatingAirlineCodeGo}${ticketsearchresults.OperatingAirlineFlightNumberGo}<br><img src="${pageContext.request.contextPath}/images/icon_f2.png" width="18px">${ticketsearchresults.Cabin}<br><img src="${pageContext.request.contextPath}/images/icon_f4.png" width="20px">機型${ticketsearchresults.AirEquipTypeGo}</div>
											</div>
											<div class="row">
												<div class="col-sm-2"></div>
												<div class="col-sm-3" id="DepartureDateGo${status.index+1}">${ticketsearchresults.DepartureDateGo}</div>
												<div class="col-sm-1"></div>
												<div class="col-sm-3" id="ArrivalDateGo${status.index+1}">${ticketsearchresults.ArrivalDateGo}</div>
												<div class="col-sm-3"></div>
											</div>
											<div class="row">
												<div class="col-sm-2">
													<span style="display: none;"
														id="DepartureAirportLocationCodeGo${status.index+1}">${ticketsearchresults.DepartureAirportLocationCodeGo}</span>
													<span style="display: none;"
														id="ArrivalAirportLocationCodeGo${status.index+1}">${ticketsearchresults.ArrivalAirportLocationCodeGo}</span>
													<span style="display: none;"
														id="OperatingAirlineCodeGo${status.index+1}">${ticketsearchresults.OperatingAirlineCodeGo}</span>
													<span style="display: none;"
														id="OperatingAirlineFlightNumberGo${status.index+1}">${ticketsearchresults.OperatingAirlineFlightNumberGo}</span>
													<span style="display: none;"
														id="Cabin${status.index+1}">${ticketsearchresults.CabinCode}</span>
													<span style="display: none;"
														id="AirEquipTypeGo${status.index+1}">${ticketsearchresults.AirEquipTypeGo}</span>
												</div>
												<div class="col-sm-10" style="display: none;" id="ElapsedTimeGo${status.index+1}">${ticketsearchresults.ElapsedTimeGo}</div>
											</div>
											<hr>
											<div class="row">
												<div class="col-sm-2">
													<button type="button" class="btn btn-dark"
														disabled="disabled">
														回程&nbsp;<i id="planeIconInFlightDetail"
															class="fa fa-plane"></i>
													</button>
												</div>
												<div class="col-sm-3">
													<b class="tripAndTime"
														id="DepartureTimeBack${status.index+1}">${ticketsearchresults.DepartureTimeBack}</b>
												</div>
												<div class="col-sm-1"></div>
												<div class="col-sm-3">
													<b class="tripAndTime"
														id="ArrivalTimeBack${status.index+1}">${ticketsearchresults.ArrivalTimeBack}</b>
												</div>
												<div class="col-sm-3"></div>
											</div>
											<div class="row">
												<div class="col-sm-2"></div>
												<div class="col-sm-3">${ticketsearchresults.DepartureAirportLocationNameBack}</div>
												<div class="col-sm-1">
													<i id="planeIconInFlightDetail" class="fa fa-arrow-right"></i>
												</div>
												<div class="col-sm-3">${ticketsearchresults.ArrivalAirportLocationNameBack}</div>
												<div class="col-sm-3" ><img src="images/${ticketsearchresults.OperatingAirlineCodeBack}.gif" style="width:20px;margin-bottom: 3px">${ticketsearchresults.OperatingAirlineNameBack}&nbsp;${ticketsearchresults.OperatingAirlineCodeBack}${ticketsearchresults.OperatingAirlineFlightNumberBack}<br><img src="${pageContext.request.contextPath}/images/icon_f2.png" width="18px">${ticketsearchresults.Cabin}<br><img src="${pageContext.request.contextPath}/images/icon_f4.png" width="20px">機型${ticketsearchresults.AirEquipTypeBack}</div>
											</div>
											<div class="row">
												<div class="col-sm-2"></div>
												<div class="col-sm-3"
													id="DepartureDateBack${status.index+1}">${ticketsearchresults.DepartureDateBack}</div>
												<div class="col-sm-1"></div>
												<div class="col-sm-3" id="ArrivalDateBack${status.index+1}">${ticketsearchresults.ArrivalDateBack}</div>
												<div class="col-sm-3"></div>
											</div>
											<div class="row">
												<div class="col-sm-2">
													<span style="display: none;"
														id="DepartureAirportLocationCodeBack${status.index+1}">${ticketsearchresults.DepartureAirportLocationCodeBack}</span>
													<span style="display: none;"
														id="ArrivalAirportLocationCodeBack${status.index+1}">${ticketsearchresults.ArrivalAirportLocationCodeBack}</span>
													<span style="display: none;"
														id="OperatingAirlineCodeBack${status.index+1}">${ticketsearchresults.OperatingAirlineCodeBack}</span>
													<span style="display: none;"
														id="OperatingAirlineFlightNumberBack${status.index+1}">${ticketsearchresults.OperatingAirlineFlightNumberBack}</span>
													<span style="display: none;"
														id="AirEquipTypeBack${status.index+1}">${ticketsearchresults.AirEquipTypeBack}</span>
												</div>
												<div class="col-sm-10"
													id="ElapsedTimeBack${status.index+1}"  style="display: none;">${ticketsearchresults.ElapsedTimeBack}</div>
											</div>
										</div>
										<div class="tab-pane container fade"
											id="luggageDetail${status.index+1}">
											<br>
											<table id="tableOfBaggageInfo1" class="table">
												<thead class="thead-light">
													<tr>
														<th>航段</th>
														<th>航班</th>
														<th>托運行李</th>
													</tr>
												</thead>
												<tbody>
													<tr>
														<td id="scheduleGo">${ticketsearchresults.DepartureAirportLocationNameGo}&nbsp;→&nbsp;${ticketsearchresults.ArrivalAirportLocationNameGo}</td>
														<td>${ticketsearchresults.OperatingAirlineCodeGo}<img src="${pageContext.request.contextPath}/images/icon_f4.png" width="20px">${ticketsearchresults.OperatingAirlineFlightNumberGo}</td>
														<td id="BaggageAllowanceGo${status.index+1}">${ticketsearchresults.BaggageAllowanceGo}</td>
													</tr>
													<tr>
														<td id="scheduleBack">${ticketsearchresults.DepartureAirportLocationNameBack}&nbsp;→&nbsp;${ticketsearchresults.ArrivalAirportLocationNameBack}</td>
														<td>${ticketsearchresults.OperatingAirlineCodeBack}${ticketsearchresults.OperatingAirlineFlightNumberBack}</td>
														<td id="BaggageAllowanceBack${status.index+1}">${ticketsearchresults.BaggageAllowanceBack}</td>
													</tr>
												</tbody>
											</table>
											<br>
											<table id="tableOfBaggageInfo2" class="table">
												<tbody>
													<tr>
														<td id="tdOfBaggageInfo2No">註1</td>
														<td colspan="4">托運行李若以件數計算，各家航空公司規定不同，請洽客服人員或由航空公司官網查詢。</td>
													</tr>
													<tr>
														<td id="tdOfBaggageInfo2No">註2</td>
														<td colspan="4">托運行李資訊是根據航空公司於訂位系統中的票價規則進行自動分析而取得，本公司不保證質其準確性，得依實際開票時之確認為準。</td>
													</tr>
												</tbody>
											</table>
										</div>
										<div class="tab-pane container fade"
											id="priceDetail${status.index+1}">
											<br>
											<table class="table" id="tableOfPriceDetail1">
												<thead class="thead-light">
													<tr>
														<th>票別</th>
														<th>票價</th>
														<th>稅金</th>
														<th style="display: none;">票價稅金</th>
														<th>人數</th>
														<th>小計</th>
													</tr>
												</thead>
												<tbody>
													<tr>
														<td>成人</td>
														<td id="EquivFareAdult${status.index+1}">${ticketsearchresults.EquivFareAdult}</td>
														<td id="TaxesAdult${status.index+1}">${ticketsearchresults.TaxesAdult}</td>
														<td style="display: none;" id="FareAdult${status.index+1}">${ticketsearchresults.FareAdult}</td>
														<td id="QuantityAdult${status.index+1}">${ticketsearchresults.QuantityAdult}</td>
														<td>${ticketsearchresults.FareAdult1xQ}</td>
													</tr>
													<c:if
														test="${ticketsearchresults.NumberOfPassengerType=='2'}">
														<tr>
															<td>兒童</td>
															<td id="EquivFareChild${status.index+1}">${ticketsearchresults.EquivFareChild}</td>
															<td id="TaxesChild${status.index+1}">${ticketsearchresults.TaxesChild}</td>
															<td style="display: none;"
																id="FareChild${status.index+1}">${ticketsearchresults.FareChild}</td>
															<td id="QuantityChild${status.index+1}">${ticketsearchresults.QuantityChild}</td>
															<td>${ticketsearchresults.FareChild1xQ}</td>
															
														</tr>
														
													</c:if>
													<tr>
														<td colspan="4" id="tableOfPriceDetail1Total">總額&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
														<td class="tableOfPriceDetail1TotalAmt"
															id="TotalFare${status.index+1}">$&nbsp;${ticketsearchresults.TotalFare}</td>
													</tr>
												</tbody>
											</table>
											<br>
											<table class="table" id="tableOfPriceDetail2">
												<tbody>
													<tr>
														<td id="tableOfPriceDetail2-1">機票效期</td>
														<td colspan="4">依各航空公司規定。</td>
													</tr>
													<tr>
														<td id="tableOfPriceDetail2-2">改期</td>
														<td colspan="4">出發前可更改皆須改票，每次收取『航空公司罰金』+『價差』+『稅差』+本公司服務費，所有更改須符合原購票之相關規定及限制（機票若有NO
															SHOW *記錄須另查）；出發後欲更改，須另洽詢，亦有可能不可更改。</td>
													</tr>
													<tr>
														<td id="tableOfPriceDetail2-3">退票</td>
														<td colspan="4">退票須於機票效期內申請；全程未用者，收取航空公司罰金+本公司退票手續費；機票一經使用或NO
															SHOW者可能無退票價值。</td>
													</tr>
												</tbody>
											</table>
											<br>
											<table id="tableOfBaggageInfo2" class="table">
												<tbody>
													<tr>
														<td id="tdOfBaggageInfo2No">註1</td>
														<td colspan="4">No-Show：
															未於機票載立航班及日期24~48小時前取消或更改，視同No-Show，各家航空規定不一，
															改票及退票最終依航空公司公告為主。</td>
													</tr>
													<tr>
														<td id="tdOfBaggageInfo2No">註2</td>
														<td colspan="4">以上更改及退票費用皆以每人每次計算，且限可更改及可退票票種。</td>
													</tr>
													<tr>
														<td id="tdOfBaggageInfo2No">註3</td>
														<td colspan="4">以上航空公司之罰金是根據公司於訂位系統中的票價規則進行自動分析而取得，本公司不保證其準
															確性，須以實際發生改期或退票需求時，依原購票之相關規定及限制確認回覆為準。</td>
													</tr>
												</tbody>
											</table>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
				
	<script>
		$("button[id^='orderGo']")
				.click(
						function() {
							var flightToOrder = this.id.slice(7);
							
							var DepartureTimeGo = $(
									"#" + "DepartureTimeGo" + flightToOrder)
									.text();
							var ArrivalTimeGo = $(
									"#" + "ArrivalTimeGo" + flightToOrder)
									.text();
							var DepartureAirportLocationCodeGo = $(
									"#" + "DepartureAirportLocationCodeGo"
											+ flightToOrder).text();
							var ArrivalAirportLocationCodeGo = $(
									"#" + "ArrivalAirportLocationCodeGo"
											+ flightToOrder).text();
							var DepartureDateGo = $(
									"#" + "DepartureDateGo" + flightToOrder)
									.text();
							var ArrivalDateGo = $(
									"#" + "ArrivalDateGo" + flightToOrder)
									.text();
							var OperatingAirlineCodeGo = $(
									"#" + "OperatingAirlineCodeGo"
											+ flightToOrder).text();
							var OperatingAirlineFlightNumberGo = $(
									"#" + "OperatingAirlineFlightNumberGo"
											+ flightToOrder).text();
							var ElapsedTimeGo = $(
									"#" + "ElapsedTimeGo" + flightToOrder)
									.text();
							var AirEquipTypeGo = $(
									"#" + "AirEquipTypeGo" + flightToOrder)
									.text();
							var Cabin = $(
									"#" + "Cabin" + flightToOrder)
									.text();

							var DepartureTimeBack = $(
									"#" + "DepartureTimeBack" + flightToOrder)
									.text();
							var ArrivalTimeBack = $(
									"#" + "ArrivalTimeBack" + flightToOrder)
									.text();
							var DepartureAirportLocationCodeBack = $(
									"#" + "DepartureAirportLocationCodeBack"
											+ flightToOrder).text();
							var ArrivalAirportLocationCodeBack = $(
									"#" + "ArrivalAirportLocationCodeBack"
											+ flightToOrder).text();
							var DepartureDateBack = $(
									"#" + "DepartureDateBack" + flightToOrder)
									.text();
							var ArrivalDateBack = $(
									"#" + "ArrivalDateBack" + flightToOrder)
									.text();
							var OperatingAirlineCodeBack = $(
									"#" + "OperatingAirlineCodeBack"
											+ flightToOrder).text();
							var OperatingAirlineFlightNumberBack = $(
									"#" + "OperatingAirlineFlightNumberBack"
											+ flightToOrder).text();
							var ElapsedTimeBack = $(
									"#" + "ElapsedTimeBack" + flightToOrder)
									.text();
							var AirEquipTypeBack = $(
									"#" + "AirEquipTypeBack" + flightToOrder)
									.text();

							var FareAdult = $("#" + "FareAdult" + flightToOrder)
									.text();
							var QuantityAdult = $(
									"#" + "QuantityAdult" + flightToOrder)
									.text();
							
							var EquivFareAdult = $(
									"#" + "EquivFareAdult" + flightToOrder)
									.text();
							var TaxesAdult = $(
									"#" + "TaxesAdult" + flightToOrder).text();
							var FareChild = $("#" + "FareChild" + flightToOrder)
									.text();
							var QuantityChild = $(
									"#" + "QuantityChild" + flightToOrder)
									.text();
							var EquivFareChild = $(
									"#" + "EquivFareChild" + flightToOrder)
									.text();
							var TaxesChild = $(
									"#" + "TaxesChild" + flightToOrder).text();
							var TotalFare = $("#" + "TotalFare" + flightToOrder)
									.text();
							var BaggageAllowanceGo=$("#" + "BaggageAllowanceGo" + flightToOrder).text();alert(BaggageAllowanceGo);
							var BaggageAllowanceBack=$("#" + "BaggageAllowanceBack" + flightToOrder).text();

							var flightToOrderJsonText = '{"DepartureTimeGo":"'
									+ DepartureTimeGo + '","ArrivalTimeGo":"'
									+ ArrivalTimeGo
									+ '","DepartureAirportLocationCodeGo":"'
									+ DepartureAirportLocationCodeGo
									+ '","ArrivalAirportLocationCodeGo":"'
									+ ArrivalAirportLocationCodeGo
									+ '","DepartureDateGo":"' + DepartureDateGo
									+ '","ArrivalDateGo":"' + ArrivalDateGo
									+ '","OperatingAirlineCodeGo":"'
									+ OperatingAirlineCodeGo
									+ '","OperatingAirlineFlightNumberGo":"'
									+ OperatingAirlineFlightNumberGo
									+ '","ElapsedTimeGo":"' + ElapsedTimeGo
									+ '","AirEquipTypeGo":"' + AirEquipTypeGo
									+ '","Cabin":"' + Cabin
									+ '","DepartureTimeBack":"'
									+ DepartureTimeBack
									+ '","ArrivalTimeBack":"' + ArrivalTimeBack
									+ '","DepartureAirportLocationCodeBack":"'
									+ DepartureAirportLocationCodeBack
									+ '","ArrivalAirportLocationCodeBack":"'
									+ ArrivalAirportLocationCodeBack
									+ '","DepartureDateBack":"'
									+ DepartureDateBack
									+ '","ArrivalDateBack":"' + ArrivalDateBack
									+ '","OperatingAirlineCodeBack":"'
									+ OperatingAirlineCodeBack
									+ '","OperatingAirlineFlightNumberBack":"'
									+ OperatingAirlineFlightNumberBack
									+ '","ElapsedTimeBack":"' + ElapsedTimeBack
									+ '","AirEquipTypeBack":"'
									+ AirEquipTypeBack + '","FareAdult":"'
									+ FareAdult + '","QuantityAdult":"'
									+ QuantityAdult + '","EquivFareAdult":"'
									+ EquivFareAdult + '","TaxesAdult":"'
									+ TaxesAdult + '","FareChild":"'
									+ FareChild + '","QuantityChild":"'
									+ QuantityChild + '","EquivFareChild":"'
									+ EquivFareChild + '","TaxesChild":"'
									+ TaxesChild + '","TotalFare":"'
									+ TotalFare + '","BaggageAllowanceGo":"'
									+BaggageAllowanceGo+'","BaggageAllowanceBack":"'
									+BaggageAllowanceGo+
									'"}';
							var flightToOrderJson = JSON
									.parse(flightToOrderJsonText);

							var form = document.createElement("form");
							form.action ="createOrder";
							form.method = "POST";

							// append input attribute and valus
							for ( var key in flightToOrderJson) {
								if (flightToOrderJson.hasOwnProperty(key)) {
									var val = flightToOrderJson[key];
									input = document.createElement("input");
									input.type = "hidden";
									input.name = key;
									input.value = val;

									// append key-value to form
									form.appendChild(input)
								}
							}

							// send post request
							document.body.appendChild(form);
							form.submit();

							// remove form from document
							document.body.removeChild(form);

						});
		

		var pAir = [];
		var pDepGo = [];
		var pArrGo = [];
		var pDepBack = [];
		var pArrBack = [];
		var right = null;
		var count = null;
		window.onload = function(){
// 			right = document.getElementById("mainRowRight8");
// 			count = right.getElementsByClassName("card").length;
// 			for(var i=0;i<count;i++){
// 				pAir[i]=1;
// 				pDepGo[i]=1;
// 				pArrGo[i]=1;
// 				pDepBack[i]=1;
// 				pArrBack[i]=1;
// 			}
		};
		
		$("#selectByAirlineCardBody").contents().find(":checkbox").bind('change',function() {			
			for(var i=0;i<count;i++){
				pAir[i]=0;
			}
			var thisVal = $(this).val();
			var thisChecked = $(this).prop("checked");
			$("#selectByAirlineCardBody input:checkbox").each(function(index) {
				var eachVal = $(this).val();
				var eachChecked = $(this).prop("checked");
				if (thisVal == "ALL" && thisChecked == true) {
					$("#selectByAirlineCardBody input[value!='ALL']").each(function(index) {
						$(this).prop('checked', false);
					});
					$("[id*='ALL']").each(function(index) {
						var thisID = $(this).attr('id');
						var idNo = parseInt(thisID.substr(5));
						pAir[idNo-1]=1;
							
						if(pAir[idNo-1]+pDepGo[idNo-1]+pArrGo[idNo-1]+pDepBack[idNo-1]+pArrBack[idNo-1]==5){
							$(this).show();
						}
					});
				} else if (thisVal != "ALL" && thisChecked == true) {
					$("#selectByAirlineCardBody input[value='ALL']").each(function(index) {
						$(this).prop('checked', false);
					});
					$("[id*='ALL']").each(function(index) {
						$(this).hide();
					});
					$("#selectByAirlineCardBody input[value!='ALL']").each(function(index) {
						var showVal = $(this).val();
						var showChecked = $(this).prop("checked");
						if (showChecked == true) {
							$("[id*='ALL" + showVal + "']").each(function(index) {
								var thisID = $(this).attr('id');
								var idNo = parseInt(thisID.substr(5));
								pAir[idNo-1]=1;
								if(pAir[idNo-1]+pDepGo[idNo-1]+pArrGo[idNo-1]+pDepBack[idNo-1]+pArrBack[idNo-1]==5){
									$(this).show();
								}
							});
						} else if (showChecked == false) {
							$("[id*='ALL" + showVal + "']").each(function(index) {
								$(this).hide();
							});
						}
					});
				} else if (thisVal != "ALL" && thisChecked == false) {
					$("[id*='ALL" + thisVal + "']").each(function(index) {
						$(this).hide();
					});
				}
			});
		});
		
		var iframe = document.getElementById("timeSliderIFrame");
// 		right = document.getElementById("mainRowRight8");
// 		count = right.getElementsByClassName("card").length;
		
		window.onload = function() {
			
			right = document.getElementById("mainRowRight8");
			count = right.getElementsByClassName("card").length;
			for(var i=0;i<count;i++){
				pAir[i]=1;
				pDepGo[i]=1;
				pArrGo[i]=1;
				pDepBack[i]=1;
				pArrBack[i]=1;
			}
			
			var scheduleGo = document.getElementById("scheduleGo").innerText ;
			var scheduleBack = document.getElementById("scheduleBack").innerText ;
			var scheduleGoI = iframe.contentWindow.document.getElementById("scheduleGo");
			var scheduleBackI = iframe.contentWindow.document.getElementById("scheduleBack");
			scheduleGoI.innerText=scheduleGo;
			scheduleBackI.innerText=scheduleBack;
			
			var sliderRange1 = iframe.contentWindow.document.getElementById("slider-range1");
			
			sliderRange1.onslidechange = function() {
				
				var text = iframe.contentWindow.document.getElementById("amount1").value;			
				var sHourB = parseInt(text.substr(0, 2));				
				var sMinB = parseInt(text.substr(3, 2));				
				var sHourE = parseInt(text.substr(8, 2));				
				var sMinE = parseInt(text.substr(11, 2));				
				var sNumB = sHourB*60+sMinB;				
				var sNumE = sHourE*60+sMinE;				
				for(var i=1;i<=count;i++){											
						pDepGo[i-1]=0;					
					var timeObj = document.getElementById("DepartureTimeGo"+i);				
					var cardID = timeObj.parentElement.parentElement.parentElement.parentElement.parentElement.parentElement.parentElement.parentElement.parentElement.id;
					var timeText = timeObj.textContent;
					var bHour = parseInt(timeText.substr(0, 2));
					var bMin = parseInt(timeText.substr(3, 2));
					var bNum = bHour*60+bMin;
					if(sNumB<=bNum&&bNum<=sNumE){						
						pDepGo[i-1]=1;
						if(pAir[i-1]+pDepGo[i-1]+pArrGo[i-1]+pDepBack[i-1]+pArrBack[i-1]==5){
							document.getElementById(cardID).style.display="block";
						}
					}else{
						if(pAir[i-1]+pDepGo[i-1]+pArrGo[i-1]+pDepBack[i-1]+pArrBack[i-1]!=5){
							document.getElementById(cardID).style.display="none";
						}
					}					
				}
			}
			
			var sliderRange2 = iframe.contentWindow.document.getElementById("slider-range2");
			sliderRange2.onslidechange = function() {
				var text = iframe.contentWindow.document.getElementById("amount2").value;
				var sHourB = parseInt(text.substr(0, 2));
				var sMinB = parseInt(text.substr(3, 2));
				var sHourE = parseInt(text.substr(8, 2));
				var sMinE = parseInt(text.substr(11, 2));
				var sNumB = sHourB*60+sMinB;
				var sNumE = sHourE*60+sMinE;
				
			
				
				for(var i=1;i<=count;i++){
					pArrGo[i-1]=0;
					var timeObj = document.getElementById("ArrivalTimeGo"+i);
					var cardID = timeObj.parentElement.parentElement.parentElement.parentElement.parentElement.parentElement.parentElement.parentElement.parentElement.id;
					var timeText = timeObj.textContent;
					var bHour = parseInt(timeText.substr(0, 2));
					var bMin = parseInt(timeText.substr(3, 2));
					var bNum = bHour*60+bMin;
					if(sNumB<=bNum&&bNum<=sNumE){
						pArrGo[i-1]=1;
						if(pAir[i-1]+pDepGo[i-1]+pArrGo[i-1]+pDepBack[i-1]+pArrBack[i-1]==5){
							document.getElementById(cardID).style.display="block";
						}
					}else{
						if(pAir[i-1]+pDepGo[i-1]+pArrGo[i-1]+pDepBack[i-1]+pArrBack[i-1]!=5){
							document.getElementById(cardID).style.display="none";
						}
					}					
				}
			}
			
			var sliderRange3 = iframe.contentWindow.document.getElementById("slider-range3");
			sliderRange3.onslidechange = function() {
				var text = iframe.contentWindow.document.getElementById("amount3").value;
				var sHourB = parseInt(text.substr(0, 2));
				var sMinB = parseInt(text.substr(3, 2));
				var sHourE = parseInt(text.substr(8, 2));
				var sMinE = parseInt(text.substr(11, 2));
				var sNumB = sHourB*60+sMinB;
				var sNumE = sHourE*60+sMinE;
				for(var i=1;i<=count;i++){
					pDepBack[i-1]=0;
					var timeObj = document.getElementById("DepartureTimeBack"+i);
					var cardID = timeObj.parentElement.parentElement.parentElement.parentElement.parentElement.parentElement.parentElement.parentElement.parentElement.id;
					var timeText = timeObj.textContent;
					var bHour = parseInt(timeText.substr(0, 2));
					var bMin = parseInt(timeText.substr(3, 2));
					var bNum = bHour*60+bMin;
					if(sNumB<=bNum&&bNum<=sNumE){
						pDepBack[i-1]=1;
						if(pAir[i-1]+pDepGo[i-1]+pArrGo[i-1]+pDepBack[i-1]+pArrBack[i-1]==5){
							document.getElementById(cardID).style.display="block";
						}
					}else{
						if(pAir[i-1]+pDepGo[i-1]+pArrGo[i-1]+pDepBack[i-1]+pArrBack[i-1]!=5){
							document.getElementById(cardID).style.display="none";
						}
					}					
				}
			}
			
			var sliderRange4 = iframe.contentWindow.document.getElementById("slider-range4");
			sliderRange4.onslidechange = function() {
				var text = iframe.contentWindow.document.getElementById("amount4").value;
				var sHourB = parseInt(text.substr(0, 2));
				var sMinB = parseInt(text.substr(3, 2));
				var sHourE = parseInt(text.substr(8, 2));
				var sMinE = parseInt(text.substr(11, 2));
				var sNumB = sHourB*60+sMinB;
				var sNumE = sHourE*60+sMinE;
				for(var i=1;i<=count;i++){
					pArrBack[i-1]=0;
					var timeObj = document.getElementById("ArrivalTimeBack"+i);
					var cardID = timeObj.parentElement.parentElement.parentElement.parentElement.parentElement.parentElement.parentElement.parentElement.parentElement.id;
					var timeText = timeObj.textContent;
					var bHour = parseInt(timeText.substr(0, 2));
					var bMin = parseInt(timeText.substr(3, 2));
					var bNum = bHour*60+bMin;
					if(sNumB<=bNum&&bNum<=sNumE){
						pArrBack[i-1]=1;
						if(pAir[i-1]+pDepGo[i-1]+pArrGo[i-1]+pDepBack[i-1]+pArrBack[i-1]==5){
							document.getElementById(cardID).style.display="block";
						}
					}else{
						if(pAir[i-1]+pDepGo[i-1]+pArrGo[i-1]+pDepBack[i-1]+pArrBack[i-1]!=5){
							document.getElementById(cardID).style.display="none";
						}
					}					
				}
			}
		};
// 		};
</script>


</body>
</html>