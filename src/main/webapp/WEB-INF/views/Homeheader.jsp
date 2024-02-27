<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix='form' uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html class="html -webkit-">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel='stylesheet'
	href='${pageContext.request.contextPath}/CSS/Project.css'
	type="text/css" />
<link href="https://fonts.googleapis.com/css?family=Noto+Sans+TC:700"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Righteous"
	rel="stylesheet">
<!-- <script type="text/javascript" -->
<!-- 	src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js"></script> -->
<!-- <script type="text/javascript" -->
<%-- 	src="${pageContext.request.contextPath}/js/jquery.parallax-1.1.3.js"></script> --%>
<!-- <script type="text/javascript" -->
<%-- 	src="${pageContext.request.contextPath}/js/jquery.localscroll-1.2.7-min.js"></script> --%>
<!-- <script type="text/javascript" -->
<%-- 	src="${pageContext.request.contextPath}/js/jquery.scrollTo-1.4.2-min.js"></script> --%>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
	<style>
/*  	input:hover{  */
/*    color:#003C9D;  */
/*    background-color:#fff;  */
/*    border:1px  solid gray;  */
/*  }  */
#g1:hover,#g2:hover,#g3:hover,#g4:hover,#g5:hover{  
    color:#DEB887; 
    background-color:#DEB887;  
  }
 
</style>
<script type="text/javascript">
$(document).ready(function(){
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
	 /////////////////////////////////////////自動帶入會員資料/////////////////////////////////////////////
	 	var Name = "${memberBean.memberName}"
	 	var Date = "${memberBean.birth}";
	 	var Gender = "${memberBean.gender}"
	 	var EnglastName = "${memberBean.lastName}";
	 	var EngfirstName = "${memberBean.firstName}"
		var lastName = Name.substring(0,1);
		var firstName = Name.substring(1);
		$("#chLastName1").val(lastName);
		$("#chFirstName1").val(firstName);
		$("#lastName1").val(EnglastName);
		$("#firstName1").val(EngfirstName);
		$("#bornDate1").val(Date);
		 if(Gender=="0"){
			 $("#gender1 option:eq(1)").attr('selected', true)
		 }else{
			 $("#gender1 option:eq(2)").attr('selected', true)
		 }

})

</script>

</head>
<body>
	<div class="div0" style="position:fixed; ;z-index:999999;background: radial-gradient(#F5DEB3,#D2B48C,#AAAAAA);">
		<header>
			<div style="height:auto;text-align:left">
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
			<div style="background: radial-gradient(#FF8C00,#F4A460,#CD853F")">
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
</body>
</html>