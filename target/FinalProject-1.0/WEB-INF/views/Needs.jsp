<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel='stylesheet' href='${pageContext.request.contextPath}/CSS/Project3.css' type="text/css" />
<link rel='stylesheet' href='${pageContext.request.contextPath}/CSS/Need.css' type="text/css" />
<link href="https://fonts.googleapis.com/css?family=Noto+Sans+TC:700" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Righteous" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>

	<script>
		$(function() {
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

			///////////////////////////////////////////
			$("#DepartureTime").datepicker({
				defaultDate: "+1w",
				changeMonth: false,
				numberOfMonths: 2,
				minDate:"0d",
				dateFormat : "yy-mm-dd",
				onClose: function(selectedDate) {
					$("#deadline").datepicker("option", "maxDate", selectedDate);
					$("#ComebackTime").datepicker("option", "minDate", selectedDate);
				}
			});
			$("#ComebackTime").datepicker({
				defaultDate: "+1w",
				changeMonth: false,
				numberOfMonths: 2,
				dateFormat : "yy-mm-dd",
				
			});
			
			$("#deadline").datepicker({
				defaultDate: "+1w",
				changeMonth: false,
				numberOfMonths: 1,
				dateFormat : "yy-mm-dd",
				
			});
			$("#onebutton").click(function(){
				$("#requiredPeople option:eq(2)").attr('selected', true)
				$("#DepartureTime").val("2019-04-07");
				$("#ComebackTime").val("2019-04-09");
				$("#deadline").val("2019-04-05");
				$("#budget").val("25000");
				$("#CustomDemand").val("不能有不良嗜好，時間觀念要好。")
				$("#whetherFull").attr("checked",true);
				$("#NoPayGoOrNot1").attr("checked",true);
			})
		});
	</script>
</head>

<body>
	<div class="div0">
		<header class="header1">
			<div class="div1">
				<a href="${pageContext.request.contextPath}/"><label
					class="lab0">To-touring</label></a> <a href=""><label class="lab1" id="registerLabel">註冊</label></a>
				<a href="${pageContext.request.contextPath}/login"><label class="lab1" id="loginLabel">登入</label><img class="img2"
					src="${pageContext.request.contextPath}/images/login.png"> </a> <img
					class="img1" alt="" src="">
				<!--     <a href="editorpackage"><label class="lab2">製作套裝</label></a> -->
				<!--     <a href="editorviews"><label class="lab2" style="background-color: rgb(255, 119, 51)">增加景點</label></a> -->
				<!--     <a href=""><label class="lab2">會員管理</label></a> -->
				<!--     <a href=""><label class="lab2">報表分析</label></a> -->
			</div>
		</header>
		<div
			style="position: static; margin: auto; margin-top: 100px; width: 40%;">
			<fieldset>
				<legend>填寫揪伴資訊</legend>
				<form:form method="POST" modelAttribute="insertneed"
					class="form-horizontal">
					<div>
						想揪多少人 :
						<form:select path="requiredPeople" id="requiredPeople">
							<form:option value="1">1</form:option>
							<form:option value="2">2</form:option>
							<form:option value="3">3</form:option>
							<form:option value="4">4</form:option>
						</form:select>
						<input type="button" id="onebutton" value="一鍵帶入" class="button">
					</div>
					<br>
					<div style="width:600px;height:55px;">
					<div style="width: 200px; float: left; margin:auto;">
						出發日期:
						<form:input path="DepartureTime" type="text" id="DepartureTime" autocomplete="off" />
					
					</div>
					<div style="width: 200px; float: left; margin:auto;">
						回程日期:
						<form:input type="text" path="ComebackTime" id="ComebackTime" autocomplete="off"/>
					</div>
					</div>
					<hr>
					<div style="width:300px;height:55px;">
					<div style="width: 200px; float: left; margin:auto;">
						揪團截止日期:
						<form:input path="deadline" type="text" id="deadline" autocomplete="off" />
					</div>
					</div>
					<hr>

					<div style="margin:15px; float: clear;">
						<span>初估預算:</span>
						<form:input path="budget" type="text" size="6" id="budget" />
						以上
					</div>
					<hr>
					<div class="formdiv">
					<label style="margin-bottom:10px;">自訂需求:</label>
				<br>
				
					<form:textarea path="CustomDemand" rows="5" cols="50" resize="none"
						name="textarea" id="CustomDemand"/>
						</div>
						<hr>
					<div class="formdiv">
						<span style=" width: 200px;">人數未滿是否成團?</span>
						<form:radiobutton name="whetherFull" path="whetherFull"
							id="whetherFull" value="1" />
						<label for="whetherFull">是</label>
						<form:radiobutton name="whetherFull" path="whetherFull"
							id="whetherFull1" value="0" />
						<label for="whetherFull1">否</label>
					</div>
					<hr>
					<div class="formdiv">
						<span style=" width: 220px;">成團後有人未付款，是否出團?</span>
						<form:radiobutton name="NoPaygoOrNot" path="NoPayGoOrNot"
							id="NoPayGoOrNot" value="1" />
						<label for="NoPayGoOrNot">是</label>
						<form:radiobutton name="NoPaygoOrNot" path="NoPayGoOrNot"
							id="NoPayGoOrNot1" value="0" />
						<label for="NoPayGoOrNot1">否</label>
						<input type="hidden" id="hidden" name="memberId" value="${memberBean.id}"/>
					</div>
					</br>
					<div style="text-align:center;"><input type="submit" class="button" id="needbutton" value="開始揪人"></div>
				</form:form>
			</fieldset>
		</div>
	</div>
</body>
</html>