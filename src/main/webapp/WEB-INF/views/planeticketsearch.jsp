<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix='form' uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html class="html -webkit-">
<head>
<meta charset="UTF-8">

<title>${title}</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<link
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css"
	rel="stylesheet" type="text/css" />
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.11.1/themes/smoothness/jquery-ui.css">
<script
	src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.1/jquery-ui.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet" href="CSS/style111.css">

<style>
.ui-autocomplete {
    max-height: 150px; 
    overflow-y: auto; 
    
    overflow-x: hidden;
  }
</style>

<script>
	//地點選擇
	$(function() {
		$.ajax({
			url : "${pageContext.request.contextPath}/xml/CITY_CHT.xml",
			dataType : "xml",
			/********************************************************/
			/* Getting the data from XML file.                      */
			/********************************************************/
			success : function(xmlResponse) {
				// Highlight the selected text
				$.extend($.ui.autocomplete.prototype, {
					_renderItem : function(ul, item) {
						var term = this.element.val(), regex = new RegExp('('
								+ term + ')', 'gi');
						html = item.label.replace(regex, "<b>$&</b>");
						return $("<li></li>").data("item.autocomplete", item)
								.append($("<a></a>").html(html)).appendTo(ul);
					}
				});
				// Finds all the elements named "code" then return the specific elements
				var data = $("T", xmlResponse).map(
						function() {
							return {
								value : $("C", this).text() + " - "
										+ ($.trim($("D", this).text())),
							};
						}).get();
				$("#orgin").autocomplete({
					source : data,
					minLength : 0,
				});
				$("#destination").autocomplete({
					source : data,
					minLength : 0,
				});
			}, //function
		}); //ajax
	}); //window
</script>


<script>
	function changeToOneTrip() {
		var obj1 = document.getElementById("returndatepicker");
		var obj2 = document.getElementById("returndatepickerlabel");
		
		obj1.setAttribute("style", "display:none");
		obj2.setAttribute("style", "width:100px;display:none; color: #AAAAAA;");
		document.getElementById("oneTrip").setAttribute("style", "margin-top :5%;background-color:#8B4513;border-color:#8B4513;opacity:0.8");
		document.getElementById("twoTrip").setAttribute("style", "margin-top :5%;background-color:#8B4513;border-color:#8B4513;opacity:0.3");
	}
	function changeToTwoTrip() {
		var obj1 = document.getElementById("returndatepicker");
		var obj2 = document.getElementById("returndatepickerlabel");
		obj1.removeAttribute("style");
		obj2.setAttribute("style",
				"width:100px; color: #AAAAAA; font-weight: bold;");
		document.getElementById("oneTrip").setAttribute("style", "margin-top :5%;background-color:#8B4513;border-color:#8B4513;opacity:0.3");
		document.getElementById("twoTrip").setAttribute("style", "margin-top :5%;background-color:#8B4513;border-color:#8B4513;opacity:0.8");
	}

	document.addEventListener("DOMContentLoaded", function() {
		document.getElementById("oneTrip").onclick = changeToOneTrip;
		document.getElementById("twoTrip").onclick = changeToTwoTrip;
	})
</script>
</head>
<body>
	<jsp:include page="Homeheader.jsp" />
	<br>
	<br>
	<div style="background-image: url(${pageContext.request.contextPath}/images/bg3.jpg); height: 93.2%; background-repeat: no-repeat; background-size: cover;">
		<div
			style="width: 50%; margin-left: 25%; border: 1px solid gray; position: relative; top: 150px;">

			<form method="post" action="${pageContext.request.contextPath}/showticketsearch"
				style="font-family: 微軟正黑體; background-color: rgba(0, 0, 0, 0.6);">
				<div style="margin-left:5%;">
					<button id="twoTrip" type="button" name="tripType" value="1"
						autofocus class="btn btn-primary" style="margin-top :5%;background-color:#8B4513;border-color:#8B4513;opacity:0.8">&nbsp;&nbsp;來回&nbsp;&nbsp;</button>
					&nbsp;&nbsp;
					<button id="oneTrip" type="button" name="tripType" value="0" class="btn btn-primary" style="margin-top :5%;background-color:#8B4513;border-color:#8B4513;opacity:0.3">&nbsp;&nbsp;單程&nbsp;&nbsp;</button>
				</div>
				<div >
					<div style="display: inline-block; margin: 10px"
						class="col-sm-5 input-group" >
						<label style="width: 100px; color:#AAAAAA; font-weight: bold;">從</label>
						<div>
							<input type="text" id="orgin" placeholder="國家/地區、城市或機場"
								name="orgin">
						</div>
						<div>
						<i class="fa fa-arrow-right"></i>
						</div>
					</div>

					<div style="display: inline-block; margin: 10px"
						class="col-sm-5 input-group">
						<label style="width: 100px; color:#AAAAAA; font-weight: bold;">到</label>
						<div>
							<input type="text" id="destination" placeholder="國家/地區、城市或機場"
								name="destination">
						</div>
					</div>
					
						<div class="col-sm-5 input-group"
							style="margin: 10px; display: inline-block;">
							<label style="width: 100px; color:#AAAAAA; font-weight: bold;">去程</label>
							<input id="departdatepicker" name="departdatepicker" type="date"
								autocomplete="off" title="出發日期" value="${needBean.departureTime}">
						</div>

						<div class="col-sm-5 input-group"
							style="margin: 10px; display: inline-block;">
							<label style="width: 100px; color:#AAAAAA; font-weight: bold;" id="returndatepickerlabel">回程</label>
							<input id="returndatepicker" name="returndatepicker"
								autocomplete="off" type="date" title="回程日期" value="${needBean.comebackTime}">
						</div>
					
					<div class="col-sm-5 input-group"
							style="margin: 10px; display: inline-block;">
						<label style="width: 100px; color:#AAAAAA; font-weight: bold;">選擇艙等</label> <select name="cabintype">
							<option value="" disabled="disabled">請選擇</option>
							<option value="Y" selected="selected">經濟艙</option>
							<option value="C">商務艙</option>
							<option value="F">頭等艙</option>
						</select>
					</div>

					<div class="col-sm-6 input-group"
							style="margin: 10px; display: inline-block;">
						<label style="width: 100px; color:#AAAAAA; font-weight: bold;">乘客人數</label> <label for="adult" style="color:#B8860B">成人</label>&nbsp; 
						<select data-label="成人" name="adult" style="font-weight: bold">
							<option value="1" selected="selected">1位</option>
							<option value="2">2位</option>
							<option value="3">3位</option>
							<option value="4">4位</option>
							<option value="5">5位</option>
							<option value="6">6位</option>
							<option value="7">7位</option>
							<option value="8">8位</option>
							<option value="9">9位</option>
						</select> &nbsp;<label for="child" style="color:#B8860B">兒童</label>&nbsp; <select
							name="child" style="font-weight: bold">
							<option value="0" selected="selected">0位</option>
							<option value="1">1位</option>
							<option value="2">2位</option>
							<option value="3">3位</option>
							<option value="4">4位</option>
							<option value="5">5位</option>
						</select>
					</div>
				</div>

				<div class="col-sm-12" style="text-align: center">
					<button type="submit" class="btn btn-success">搜尋航班</button>
				</div>
			</form>


		</div>
	</div>
</body>
</html>