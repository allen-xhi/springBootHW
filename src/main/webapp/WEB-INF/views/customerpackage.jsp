<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%@ taglib prefix='form' uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html class="html -webkit-">
<head>
<meta charset="UTF-8">
<title>${title}</title>
	<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<link rel='stylesheet' href='${pageContext.request.contextPath}/CSS/package.css'  type="text/css" />
<link href="https://fonts.googleapis.com/css?family=Noto+Sans+TC:700" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Righteous" rel="stylesheet">
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js"></script>
<script defer src="https://use.fontawesome.com/releases/v5.7.2/js/all.js" integrity="sha384-0pzryjIRos8mFBWMzSSZApWtPl/5++eIfzYmTgBBmXYdhvxPc+XcFEk+zJwDgWbP" crossorigin="anonymous"></script>
</head>
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

				 });
	
</script>
<body style="margin-top:100px;">
	<div class="div0" style="position:fixed; ;z-index:999999;background: radial-gradient(#F5DEB3,#D2B48C,#AAAAAA);top:0;margin-bottom:20px;">
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
	<div style="width:100%;height: auto;background-color:#e6e6f2">
<div class="div2">
<c:forEach var="Trippackage" items="${customerpackage}">
<div class="div3">
<a href="findTripDetails/${Trippackage.tripId}">
<label style="font-size: 50px;position:absolute;margin-left:100px;margin-top:50px;color:#f1f2f6;">${Trippackage.tripname}</label>
<img style="width:100%;height:100%;border-radius: 25px" src="<c:url value='/getpackagephoto/${Trippackage.tripId}'/>"/>
</a>
</div>
</c:forEach>
</div>
</div>
</body>
</html>