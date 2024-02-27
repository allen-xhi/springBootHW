<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" content="width=device-width ,initial-scale=1.0">
<title>${title}</title>
<script src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
<script src="${pageContext.request.contextPath}/js/Login.js"></script>
	<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
	<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous"/>
<link rel='stylesheet' href='${pageContext.request.contextPath}/CSS/Project.css' type="text/css" />
<link rel='stylesheet' href='${pageContext.request.contextPath}/CSS/Together.css' type="text/css" />
<link href="https://fonts.googleapis.com/css?family=Noto+Sans+TC:700" rel="stylesheet">
<link href="${pageContext.request.contextPath}/CSS/jquery-ui.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Righteous" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<style type="text/css">
	.ui-datepicker{
		top:150;
	
	}
</style>
	<script type="text/javascript">
	
			$(document).ready(function(){
			
				//////////////////////////////////////////////////////////////////////////////////
				var loginStatus = "${loginStatus}";
				 if(loginStatus=='true'){
					 var name = "${memberBean.memberName}";
					 
					 $("#registerLabel").text("登出");
					 $("#registerLabel").parent().attr("href","${pageContext.request.contextPath}/needLogin/logout");
					
					 $("#loginLabel").text(name);
					 $("#loginLabel").parent().attr("href","${pageContext.request.contextPath}/needLogin/showUserDetailInfo/${memberBean.id}");

					 }else{
						 $("#registerLabel").text("註冊");
						 $("#registerLabel").parent().attr("href","${pageContext.request.contextPath}/register");
						
						 $("#loginLabel").text("登入");
						 $("#loginLabel").parent().attr("href","${pageContext.request.contextPath}/login"); 
					 }

			
		///////////////////////////////////////////////////////
				$("#DepartureTime").click(function(){
					
					$('.ui-datepicker').css({"top":150})
				})
				

				
					 
					$(function() {

						$("#DepartureTime").datepicker({
							
// 							defaultDate: "+1w",
// 							changeMonth: false,
// 							numberOfMonths: 2,
// 							minDate:"0d",
// 							dateFormat : "yy-mm",
// 							onClose: function(selectedDate) {
								
// 							}
									
							changeYear: true, // 年下拉選單

							changeMonth: true, // 月下拉選單

							showButtonPanel: true, // 顯示介面

							showMonthAfterYear: true, // 月份顯示在年後面

							dateFormat: 'yy-mm-dd',

							showButtonPanel: true,

							monthNamesShort: ["1月", "2月", "3月", "4月", "5月", "6月", "7月", "8月", "9月", "10月", "11月", "12月"], // 月名中文 

							prevText: '上月', // 上月按鈕 

							nextText: '下月', // 下月按鈕

							currentText: "本月", // 本月按鈕

							closeText: "送出", // 送初選項按鈕 
							
							onClose: function(selectedDate) {
								var year = $("#ui-datepicker-div .ui-datepicker-year option:selected").val(); 
								var month = $("#ui-datepicker-div .ui-datepicker-month option:selected").val();
								var parseIntmonth=parseInt(month)+1;

								if(parseIntmonth < 10){

								correctmonth = '0'+parseIntmonth;

								}else{

								correctmonth = parseIntmonth;

								} 
								var intmonth = parseInt(month)
								$("#DepartureTime").val(year+"-"+correctmonth);
	 							}
						});
						})
					});
			
			
			
	
	</script>
</head>
<body style="background-color:#F5F5F5;padding-top:10px;font-family:微軟正黑體;">  	 

	<div class="div0" style="position:fixed;z-index:999999;background: radial-gradient(#F5DEB3,#D2B48C,#AAAAAA);top:0;margin-bottom:20px;">
		<header>
			<div style="height:auto;text-align:left">
				<a href="${pageContext.request.contextPath}/" style="height:40px;width: 30%; font-family: 'Righteous', cursive; font-size: 40px; color: rgb(0, 0, 0);margin-left: 5%;text-decoration:none" id="logo">
					<em style="color:#2F4F4F">To-touring</em></a>
				<a href="${pageContext.request.contextPath}/register"><label id="registerLabel"
					style="font-family:微軟正黑體; font-size: 17px; text-align: center; margin-top: 20px; margin-left: 1px; margin-right: 5px; background-color:#DAA520; border-radius: 5px; float: right;padding:4px;"><i style="color:#556B2F">註冊</i> </label></a>
				<a href="${pageContext.request.contextPath}/login"><label id="loginLabel"
					style="float: right;font-family:微軟正黑體; font-size: 17px; text-align: center; margin-top: 20px; margin-left: 1px; margin-right: 5px; background-color:#DAA520; border-radius: 5px;padding:4px;"><i style="color:#556B2F">登入</i> </label><img
					style="height: 37px; margin-top: 15px; float: right;"
					src="${pageContext.request.contextPath}/images/login.png"> </a> <img
					class="img1" alt="" src="">
				<hr style="margin:0; border:none; border-top: 5px solid	#8B4513;">
			</div>
			<div style="background: radial-gradient(#FF8C00,#F4A460,#CD853F)">
				<div class="container">
					<div class="row">

						<a href="${pageContext.request.contextPath}/planeticketsearch" style="color: #8B4513; width: 20%; text-align: center;font-family:微軟正黑體;font-size: 20px;font-weight: bold;text-decoration:none" id=g1><i>機票搜尋</i> </a> 
						
						<a href="${pageContext.request.contextPath}/customerpackage" style="color:  #8B4513; width: 20%; text-align: center;font-family:微軟正黑體;font-size: 20px;font-weight: bold;text-decoration:none" id=g2><i>套裝行程</i></a>

						<a href="${pageContext.request.contextPath}/CustomerSceneryfirst" style="color:  #8B4513; width: 20%; text-align: center;font-family:微軟正黑體;font-size: 20px;font-weight: bold;text-decoration:none" id=g3><i>自訂行程</i></a>

						<a href="${pageContext.request.contextPath}/GetTogether" style="color:  #8B4513; width: 20%; text-align: center;font-family:微軟正黑體;font-size: 20px;font-weight: bold;text-decoration:none" id=g4><i>尋找出團</i></a>

						<a href="${pageContext.request.contextPath}/scenery" style="color:  #8B4513; width: 20%; text-align: center;font-family:微軟正黑體;font-size: 20px;font-weight: bold;text-decoration:none" id=g5><i>熱門景點</i></a>
					</div>

				</div>

			</div>
		</header>
	</div>

	
			<div class="ALLDIV">
		<div class="togetherdiv0">
		<div style="margin:auto; width:80%;height:170px;">

					<fieldset>
<!-- 					<legend style="text-align:center;">偏好搜尋</legend> -->
					<form action="Filter" method="POST">
					<div class="Filterdiv"><span>輸入關鍵字，查詢行程:</span>
					<input type="text" size="12" name="tripname" id="tripname" value="${formtext}"/>
					</div>
					<div class="Filterdiv"><span>分類:</span>
					<input type="radio"  value="自訂行程"  id="triptype" name="triptype" checked  /><label for="triptype">自訂行程</label>
					<input type="radio"  value="套裝行程" id="triptype1" name="triptype" /><label for="triptype1">套裝行程</label>
					</div>
					<div class="Filterdiv"><span>輸入國家、城市關鍵字:</span>
					<input type="text" size="12" name="countrycity" value="${formtext2}" id="countrycity"/>
					</div>
					<div class="Filterdiv"><span>需求人數：</span>
					<input type="text" name="requiredPeople" value="${formtext5}" size="5"><span>人</span>
					</div>
					<div class="Filterdiv"><span>行程天數</span>
					<select  id="tripdays" name="tripdays">
						<option value="1">1</option><option value="2">2</option>
						<option value="3">3</option><option value="4">4</option>
						<option value="5">5</option><option value="6">6</option>
						<option value="7">7</option><option value="8">8</option>
						<option value="9">9</option><option value="10">10</option>
						<option value="0">不拘</option>
						</select></div>
						<div class="Filterdiv" >
						<span>選擇出發日期：</span>
						<input type="text" name="DepartureTime" id="DepartureTime" size="10" readonly="readonly" value="${formtext6}" ></div>
				
						<div class="Filterdiv"><span>基本開銷</span>
						<input  type="text" size="8" name="lowestprice" value="${formtext4}" id="lowestprice"/><span>以下</span></div>
					
						<div style="text-align:center;width:20%;height:44px;float:right;margin-right:15px;">
						<input type="submit" value="查詢" id="submit">
						
						<a href="GetTogether" style="float:right;margin:0px;" id="submit1">查看全部</a>
						</div>
						<div class="Filterdiv" style="background-color:white; float:right;"><span style="color:red;">${error}</span></div>
					</form>
					
					</fieldset>
		</div>
		
		<div class="togetherdiv1">
		<div class="together" id="together">
		<div style="width:100%;height: 30px;line-height:30px;background-color:#7b7b7b;color:white ;border:1px solid gray;border-radius: 5px;">
			<span class="titlespan" style="width:50%;">行程標題</span>
			<span class="titlespan" style="width:12%;">旅遊天數</span>
			<span class="titlespan" style="width:17%;">初估預算</span>
			<span class="titlespan" style="width:12%;">類型</span>
		共${number}筆</div>
			<c:forEach var="trip" items="${NeedTrip}">
			<a href="Detail/${trip.needId}" class="NeedDetail" id="${trip.needId}">
			<div class="togetherList">
			<div style="float:left;margin:5px;width:100%;height:80px;" id="${trip.tripBean.tripId}">
<%-- 			ID :${trip.tripBean.tripId}  --%>
			<span class="titlespanTripname" style="width:49%;">${trip.tripBean.tripname}</span>
			<span class="titlespanDay" style="width:11.5%;">${trip.tripBean.tripdays}</span>
			<span class="titlespanBudget" style="width:16%;">${trip.budget}</span>
			<span class="titlespanType" style="width:16%;">${trip.tripBean.triptype}</span>
			<div class="titleDepart">出發時間 : ${trip.departureTime}</div>
			
<%-- 			照片:	${trip.tripBean.photo} --%>		
<%-- 			國家:	${trip.tripBean.countrycity} --%>	
<%-- 			最低開銷:	${trip.tripBean.lowestprice} --%>
<%-- 			NEEDID : ${trip.needId} --%>
			
<%-- 			需求人數 : ${trip.requiredPeople} --%>
<%-- 			回程時間 : ${trip.comebackTime} --%>
<%-- 			主辦人 :${trip.acountId} --%>
<%-- 			揪團截止日 :${trip.deadline} --%>
			
<%-- 			<c:if test="${trip.whetherFull=='1'}">是</c:if> --%>

<%-- 			如未揪滿人，是否開團 :<c:if test="${trip.whetherFull=='1'}">是</c:if> --%>
<%-- 			<c:if test="${trip.whetherFull=='0'}">否</c:if> --%>
							
<%-- 			有人未付款，是否出團 :<c:if test="${trip.noPayGoOrNot=='1'}">是</c:if> --%>
<%-- 			<c:if test="${trip.noPayGoOrNot=='0'}">否</c:if> --%>
			
			
			
			
			
			
			</div>
				</div>
</a>
				
			</c:forEach>
		
		</div>
		</div>
		</div>
		</div>
</body>
</html>