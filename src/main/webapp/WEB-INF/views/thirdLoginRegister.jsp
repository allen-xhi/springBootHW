<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel='stylesheet' href='${pageContext.request.contextPath}/CSS/Project.css'  type="text/css" />
<link href="https://fonts.googleapis.com/css?family=Noto+Sans+TC:700" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Righteous" rel="stylesheet">
<title>Insert title here</title>
<style>
*{
	box-sizing: border-box;
}
fieldset{
	width:50%;
	margin:50px auto;  
	padding:10px;
	height:auto;
	border-radius: 10px; 
}

.registerLabel{
	display:inline-block;
	font-size:15px;
	font-weight: 400;
	font-family: -apple-system,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,"Noto Sans",sans-serif,"Apple Color Emoji","Segoe UI Emoji","Segoe UI Symbol","Noto Color Emoji";
	margin-bottom:.5rem;
	}
.rowDiv-col2{
	flex:0 0 50%;
	max-width:50%;
}

.rowDiv-col3{
	flex:0 0 calc(100%/3);
	max-width:calc(100%/3);
}
.divInRow{
	display: block;
	width:100%;
	padding-right: 10px;
    padding-left: 10px;
    margin-bottom: 1rem;
}
.rowDiv{
	width:100%;
	display:flex;
   	flex-wrap:wrap;
}

input,select,textarea,option{
	border:1px solid gray;
	border-radius: 5px;
	list-style-type: none;
	width:100%;
    padding: .375rem .75rem;
    font-size: 1rem;
    line-height: 1.5; 
    display: block; 
    font-family: -apple-system,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,"Noto Sans",sans-serif,"Apple Color Emoji","Segoe UI Emoji","Segoe UI Symbol","Noto Color Emoji";
	vertical-align: middle;
	outline-style: none;
}
input:hover{
	border-color:orange;
	outline-style: none;
}
textarea{
	resize: none; 
}
.submit{
	width:20%;
	cursor: pointer;
	margin-top: 1rem;
	background-color: #007bff;
    border-color: #007bff;
    color:#FFF;
}
smallValid{
	padding-right: 10px;
    padding-left: 10px;
    font-family: -apple-system,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,"Noto Sans",sans-serif,"Apple Color Emoji","Segoe UI Emoji","Segoe UI Symbol","Noto Color Emoji";
}
smallInvalid{
	padding-right: 10px;
    padding-left: 10px;
    font-family: -apple-system,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,"Noto Sans",sans-serif,"Apple Color Emoji","Segoe UI Emoji","Segoe UI Symbol","Noto Color Emoji";
}
</style>
<script>
	$(document).ready(function(){
		var loginStatus = "${loginStatus}";
		 if(loginStatus=='true'){
			 var name = "${memberBean.memberName}";
			 
			 $("#registerLabel").text("登出");
			 $("#registerLabel").parent().attr("href","${pageContext.request.contextPath}/needLogin/logout");
			
			 $("#loginLabel").text(name);
			 $("#loginLabel").parent().attr("href","${pageContext.request.contextPath}/needLogin/showUserDetailInfo/${memberBean.id}");

			 }

	})
	
	function check(){
		
	}
</script>
</head>
<body>

	<div class="div0">
		<header class="header1">
			<div class="div1">
				<a href="#"><label class="lab0">To-touring</label></a> 
				<a href="${pageContext.request.contextPath}/register"><label class="lab1" id="registerLabel">註冊</label></a> 
				<a href="${pageContext.request.contextPath}/login"><label class="lab1" id="loginLabel">登入</label>
				<img class="img2" src="${pageContext.request.contextPath}/images/login.png"> </a> 
				<img class="img1" alt="" src="">
			</div>
			<nav class="nav1">
				<div class="div4">
					<a href="${pageContext.request.contextPath}/"><label class="label1">機票搜詢</label></a> <a
						href="${pageContext.request.contextPath}/customerpackage"><label class="label1">套裝行程</label></a> <a
						href="${pageContext.request.contextPath}/CustomerSceneryfirst"><label class="label1">自訂行程</label></a>
					<a href="${pageContext.request.contextPath}/GetTogether"><label class="label1">尋找出團</label></a> <a
						href="${pageContext.request.contextPath}/scenery"><label class="label1">熱門景點</label></a>
				</div>
			</nav>
		</header>
		<article>
			<form:form modelAttribute="bean" method="POST" action="${pageContext.request.contextPath}/thirdLoginRegister">
					<fieldset>
						<div class="rowDiv">
						<div class="rowDiv-col2 divInRow">
						<label class="registerLabel">Email</label>
						<form:input path="email" id="email" placeholder="Email" value="${thirdLoginInfo.email}"/>
<!-- 								 <input type="button" id="sendEmail" value="驗證"/> -->
						<small></small>
						</div>
	<!-- 					<input type="button" value="檢查" onclick=""/> -->
<!-- 						<div class="rowDiv-col2 divInRow"> -->
<!-- 						<label class="registerLabel">Password</label> -->
<%-- 						<form:password path="password" id="password" placeholder="Password"/> --%>
<!-- 						<div></div> -->
<!-- 						</div> -->
						</div>
						
						
						<div class="rowDiv">
						<div class="rowDiv-col3 divInRow">
						<label class="registerLabel">User name</label>
						<form:input path="memberName" id="memberName" placeholder="User name" value="${thirdLoginInfo.name}"/>
						<div></div>
						</div>
					
						<div class="rowDiv-col3 divInRow">
						<label class="registerLabel">First name</label>
						<form:input path="firstName" id="firstName" placeholder="First name" value="${thirdLoginInfo.firstName}"/>
						<div></div>
						</div>
						
						<div class="rowDiv-col3 divInRow">
						<label class="registerLabel">Last name</label>
						<form:input path="lastName" id="lastName" placeholder="Last name" value="${thirdLoginInfo.lastName}"/>
						<div></div>
						</div>
						</div>
						
						<div class="rowDiv">
							<div class="rowDiv-col3 divInRow">
								<label class="registerLabel">Birth</label>
								<form:input path="birth" type="date" id="birth" placeholder="Birth"/>
								<div></div>
							</div>
						
							<div class="rowDiv-col3 divInRow">
								<label class="registerLabel">Gender</label>
								<form:select path="gender">
									<form:option value="1">male</form:option>
									<form:option value="0">female</form:option>
								</form:select>
								<div></div>
							</div>
							<div class="rowDiv-col3 divInRow">
								<label class="registerLabel">Phone</label>
								<form:input path="phone" id="phone" placeholder="Phone"/>
								<div></div>
							</div>
						</div>
						
						<div class="rowDiv">
							<div class="divInRow">
							<label class="registerLabel">Introduction</label>
							<form:textarea path="introduction" placeholder="Introduction"/>
							<div class="checkDiv"></div>
							</div>
						</div>
						<div class="rowDiv">
							<div class="divInRow">
								<input type="submit" value="Submit" onclick="return check()" class="submit"/>
							</div>
						</div> 
					</fieldset>
				</form:form>
		</article>

		</div>
</body>
</html>