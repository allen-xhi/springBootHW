<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html> 
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="https://apis.google.com/js/platform.js" async defer></script>
<script src="https://apis.google.com/js/api:client.js"></script>
<script async defer src="https://connect.facebook.net/en_US/sdk.js"></script>
<script async defer crossorigin="anonymous" src="https://connect.facebook.net/en_GB/sdk.js#xfbml=1&version=v3.2&appId=419957948576260&autoLogAppEvents=1"></script>
<!-- header css -->
<link rel='stylesheet'
	href='${pageContext.request.contextPath}/CSS/Project.css'
	type="text/css" />
<link href="https://fonts.googleapis.com/css?family=Noto+Sans+TC:700"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Righteous"
	rel="stylesheet">

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr"
	crossorigin="anonymous">
<style>
#g1:hover,#g2:hover,#g3:hover,#g4:hover,#g5:hover{  
    color:#DEB887; 
    background-color:#DEB887;  
  }
article{
	height:calc(100% - 165px);  
	padding-top:50px;  
 }
.loginIcon {
	font-size: 30px;
}

fieldset {
	width: 30%;
	margin: auto;
	box-sizing: border-box;
	padding:10px; 
}

fieldset input {
	outline: none;
	outline-style: none;
	border-right-style: none;
}

.div-row{
	height:40px;
	padding:5px;
	display: flex;
}
.form-size{
	width:80%;
	margin:auto;
	
}
#feedback{
	color:red;
}
</style>
<script>
	$(document).ready(function() {
			gapi.load(
				'auth2',
				function() {
					// Retrieve the singleton for the GoogleAuth library and set up the client.
					auth2 = gapi.auth2.init({
								client_id : '22042621167-ikc0vnt83k0rd0bs4rq4ljn2578lk124.apps.googleusercontent.com',
								cookiepolicy : 'single_host_origin',
								// Request scopes in m to 'profile' and 'email'
								scope : 'profile'
							});
					attachSignin(document.getElementById('customBtn'));
				});

				window.fbAsyncInit = function() {
					FB.init({
						appId : '419957948576260',
						cookie : true, // enable cookies to allow the server to access 
						// the session
						xfbml : true, // parse social plugins on this page
						version : 'v3.2' // The Graph API version to use for the call
					});
				};

				$("#lineLogin").click(function(response) {
					var URL = 'https://access.line.me/oauth2/v2.1/authorize?';
					URL += 'response_type=code';
					URL += '&client_id=1555069274';
					URL += '&redirect_uri=http://localhost:8081/FinalProject/lineLogin';
					URL += '&state=abcde12345';
					URL += '&scope=openid%20profile%20email';
					window.location.href = URL;
				});
			});

	function checkLoginState() {
		FB.getLoginStatus(function(response) {
			statusChangeCallback(response);
		});
	}

	function statusChangeCallback(response) {

		if (response.status === 'connected') {
			alert("connected");
			var accessToken = response.authResponse.accessToken;
			FB.api('/me?fields=name,first_name,last_name,email', function(
					response) {
				fbLoginToServer(response)
			});
		} else if (response.status === 'not_authorized') {
			alert("not_authorized");

		} else {
			alert("not login");
			FB.login(function(response) {
				if (response.authResponse) {
					console.log('Welcome!  Fetching your information.... ');
					FB.api(
						'/me?fields=name,first_name,last_name,email',
						function(response) {
							fbLoginToServer(response);
							console.log('Good to see you, '
									+ response.name + '.');
						});
				} else {
					console.log('User cancelled login or did not fully authorize.');
				}
			});
		}

	}

	function fbLoginToServer(response) {
		$.ajax({
			url : "fbLogin",
			type : "POST",
			data : {
				userInfo : JSON.stringify(response)
			},
			dataType : "html",
			async : false,
			success : function(data) {
				alert("login success" + data);
				location.href = data;
			}
		});
	}

	function attachSignin(element) { // for Google
		console.log(element.id);
		auth2.attachClickHandler(element, {}, function(googleUser) { // for google login success

			var id_token = googleUser.getAuthResponse().id_token;
			$.ajax({
				url : "${pageContext.request.contextPath}/googleLogin",
				type : "post",
				data : {
					idTokenStr : id_token
				},
				dataType:"text",
				success : function(data) {
					alert(data);
					location.href = data;
				}
			});
		}, function(error) { // for google login fail
			alert(JSON.stringify(error, undefined, 2));
		});
	}

	function loginTest() {
		$.ajax({
			url : "${pageContext.request.contextPath}/login",
			type : "post",
			dataType:"text",
			data : {
				email : $("#email1").val(),
				password : $("#password1").val()
			},
			success : function(data) {
				$("#feedback").attr("style","color:red;");
				if (data == "error") {
					$("#feedback").html("帳號或密碼錯誤");
					$("#password").val("");
				} else if (data == "account is not exist") {
					$("#feedback").html("帳號不存在");
					$("#password").val("");
				}  else if (data == "verify your email") {
					$("#feedback").html("尚未驗證信箱");
					$("#password").val("");
				}  else if (data == "you are manager") {
					location.href = "${pageContext.request.contextPath}/editor";
				}else {
					alert("login success")
					location.href = data;
				}
			},
			error : function(data) {

			}
		});
	}
	
	function searchPassword(){
		$.ajax({
			url:"${pageContext.request.contextPath}/forgetPassword",
			type:"post",
			data:{searchEmail:$("#searchByEmail").val()},
			dataType:"text",
			success:function(data){
				if(data=="success"){
				console.log("success");
				$("#feedback").text("信件已送出");
				$("#feedback").attr("style","color:green;");
				}else if(data=="error"){
					$("#feedback").text("無此帳號");
					$("#feedback").attr("style","color:red;");
				}
			},error:function(){
				console.log("error");
			}
		})
	}
</script>
</head>
<body>

	<div class="div0" style="min-height:100%;">
		<header>
			<div style="height:auto; z-index:999999;background: radial-gradient(#F5DEB3,#D2B48C,#AAAAAA);"> 
				<a href="${pageContext.request.contextPath}/" style="height:40px;width: 30%; font-family: 'Righteous', cursive; font-size: 40px; color: rgb(0, 0, 0);margin-left: 5%;text-decoration:none" id="logo">
					<em style="color:#2F4F4F">To-touring</em></a>
				<a href="${pageContext.request.contextPath}/register"><label id="registerLabel"
					style="font-family:微軟正黑體; font-size: 17px; text-align: center; margin-top: 20px; margin-left: 1px; margin-right: 5px; background-color:#DAA520; border-radius: 5px; float: right;"><i style="color:#556B2F">註冊</i> </label></a>
				<a href="${pageContext.request.contextPath}/login"><label id="loginLabel"
					style="float: right;font-family:微軟正黑體; font-size: 17px; text-align: center; margin-top: 20px; margin-left: 1px; margin-right: 5px; background-color:#DAA520; border-radius: 5px;"><i style="color:#556B2F">登入</i> </label><img
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

						<a href="${pageContext.request.contextPath}/" style="color:  #8B4513; width: 20%; text-align: center;font-family:微軟正黑體;font-size: 20px;font-weight: bold;text-decoration:none" id=g3><i>自訂行程</i></a>

						<a href="${pageContext.request.contextPath}/GetTogether" style="color:  #8B4513; width: 20%; text-align: center;font-family:微軟正黑體;font-size: 20px;font-weight: bold;text-decoration:none" id=g4><i>尋找出團</i></a>

						<a href="${pageContext.request.contextPath}/scenery" style="color:  #8B4513; width: 20%; text-align: center;font-family:微軟正黑體;font-size: 20px;font-weight: bold;text-decoration:none" id=g5><i>熱門景點</i></a>
					</div>

				</div>

			</div>
		</header>
		<article style="padding-bottom:170px;padding-top:100px; ">
			<fieldset>
				<form class="form-size" action="">
					<div class="form-group">
						<label for="email1">電子郵件</label> 
						<input type="email" class="form-control" id="email1" aria-describedby="emailHelp" placeholder="Enter email"> 
					</div>
					<div class="form-group">
						<label for="password1">密碼</label> 
						<input type="password" class="form-control" id="password1" placeholder="Password">
					</div>
					<div class="form-group">
						<span id="feedback"></span>
					</div>
					<div class="form-group">
					<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">忘記密碼</button>
					<button type="button" class="btn btn-primary" onclick="loginTest()">登入</button>
					</div>
					<div class="form-group"> 
					<i class="fab fa-google loginIcon" id="customBtn" style="color:#ea4335"></i> 
					<i class="fab fa-line loginIcon" id="lineLogin" style="color:#00c300;"></i> 
					<i class="fab fa-facebook-square loginIcon" onclick="checkLoginState();" style="color:#3b5998;"></i>
					</div>	
				</form>
			</fieldset>
		</article>
		<footer > 
			<div class="divfoot">
				<span>電話:0952-388-xxx</span><br> <span>地址:11073台北市信義區松仁路100號</span>
			</div>
		</footer>
	</div>
	
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true" style="top:30%;">
					  <div class="modal-dialog modal-sm" role="document">
					    <div class="modal-content">
					      <div class="modal-header" style="padding:5px 1rem;">
					        <h6 class="modal-title" id="exampleModalLabel">輸入電子信箱</h6>
					        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
					          <span aria-hidden="true">&times;</span>
					        </button>
					      </div>
					      <div class="modal-body">
					        <input type="text" class="form-control" id="searchByEmail" placeholder="Enter email">
					      </div>
					      <div class="modal-footer" style="padding:5px 1rem;">
					        <button type="button" class="btn btn-secondary btn-sm" data-dismiss="modal">取消</button>
					        <button type="button" class="btn btn-primary btn-sm" onclick="searchPassword();" data-dismiss="modal">送出</button>
					      </div>
					    </div>
					  </div>
					</div>
		
		<div class="modal fade" id="mailHint" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
					  <div class="modal-dialog modal-sm" role="document">
					    <div class="modal-content">
					      <div class="modal-header">
					        <h5 class="modal-title" id="exampleModalLabel">查詢密碼</h5>
					        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
					          <span aria-hidden="true">&times;</span>
					        </button>
					      </div>
					      <div class="modal-body">信件已送出</div>
					      <div class="modal-footer">
					        <button type="button" class="btn btn-secondary" data-dismiss="modal">確認</button>
<!-- 					        <button type="button" class="btn btn-primary" data-dismiss="modal">送出</button> -->
					      </div>
					    </div>
					  </div>
					</div>
</body>
</html>