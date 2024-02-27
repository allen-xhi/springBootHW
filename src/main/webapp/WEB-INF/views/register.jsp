<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous"/>
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
	var wrongMsg = new Array();
	var canRegister = false;
	$(document).ready(function(){
		$("#email").keyup(function(){
			if(checkEmail()){
			$.ajax({
				url:"checkEmail",
				type:"post",
				data:{email:$("#email").val()},
				success:function(data){
// 					alert(data)
					if(data=='true'){
						$("#spanForEmail").text("該Email已有人使用");
					}else{
						$("#spanForEmail").text("該Email可使用");
					}
				},error:function(data){
					console.log("something wrong")
				}
			})
			}else{
				$("#spanForEmail").text("email has problem")
			}
		})
	});
	
</script>
</head>
<body style="margin-top:120px;">

<div class="div0">
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

		<article>
			
				<form:form modelAttribute="memberBean" method="POST">
					<fieldset>
						<div class="rowDiv">
						<div class="rowDiv-col2 divInRow">
						<label class="registerLabel">Email</label>
						<form:input path="email" id="email" placeholder="Email"/>
<!-- 								 <input type="button" id="sendEmail" value="驗證"/> -->
						<small></small>
						</div>
	<!-- 					<input type="button" value="檢查" onclick=""/> -->
						<div class="rowDiv-col2 divInRow">
						<label class="registerLabel">Password</label>
						<form:password path="password" id="password" placeholder="Password"/>
						<div></div>
						</div>
						</div>
						
						
						<div class="rowDiv">
						<div class="rowDiv-col3 divInRow">
						<label class="registerLabel">User name</label>
						<form:input path="memberName" id="memberName" placeholder="User name"/>
						<div></div>
						</div>
					
						<div class="rowDiv-col3 divInRow">
						<label class="registerLabel">First name</label>
						<form:input path="firstName" id="firstName" placeholder="First name"/>
						<div></div>
						</div>
						
						<div class="rowDiv-col3 divInRow">
						<label class="registerLabel">Last name</label>
						<form:input path="lastName" id="lastName" placeholder="Last name"/>
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
								<input type="submit" value="註冊" onclick="return check()" class="submit"/>
							</div>
						</div> 
					</fieldset>
				</form:form>
			
		</article>
	
	</div>
	
</body>
</html>