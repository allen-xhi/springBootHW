<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%@ taglib prefix='form' uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous"/>
<link href="https://fonts.googleapis.com/css?family=Noto+Sans+TC:700" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Righteous" rel="stylesheet">
<link rel='stylesheet' href='${pageContext.request.contextPath}/CSS/editorpackagefirst.css'  type="text/css" />
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	$(document).ready(function({
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
	}))

</script>
</head>
<body style="margin-top:100px;">
<div class="div0">
<div class="div0" style="position:fixed; ;z-index:999999;background: radial-gradient(#F5DEB3,#D2B48C,#AAAAAA);top:0;margin-bottom:20px;">
		<header>
			<div style="height:auto;text-align:left">
				<a href="${pageContext.request.contextPath}/" style="height:40px;width: 30%; font-family: 'Righteous', cursive; font-size: 40px; color: rgb(0, 0, 0);margin-left: 5%;text-decoration:none" id="logo">
					<em style="color:#2F4F4F">To-touring</em></a>
					<img class="img1" alt="" src="">
				<a href="${pageContext.request.contextPath}/register"><label id="registerLabel"
					style="font-family:微軟正黑體; font-size: 17px; text-align: center; margin-top: 20px; margin-left: 1px; margin-right: 5px; background-color:#DAA520; border-radius: 5px; float: right;padding:4px;"><i style="color:#556B2F">註冊</i> </label></a>
				<a href="${pageContext.request.contextPath}/login"><label id="loginLabel"
					style="float: right;font-family:微軟正黑體; font-size: 17px; text-align: center; margin-top: 20px; margin-left: 1px; margin-right: 5px; background-color:#DAA520; border-radius: 5px;padding:4px;"><i style="color:#556B2F">登入</i> </label><img
					style="height: 37px; margin-top: 15px; float: right;"
					src="${pageContext.request.contextPath}/images/login.png"> </a> <img
					class="img1" alt="" src="">
				    <a href="${pageContext.request.contextPath}/editorpackagefirst"><label class="lab2">製作套裝</label></a>
				    <a href="${pageContext.request.contextPath}/editorviews"><label class="lab2">增加景點</label></a>
				    <a href="${pageContext.request.contextPath}/changeflightprice"><label class="lab2">機票價格</label></a>
				    <a href="${pageContext.request.contextPath}/excel"><label class="lab2">報表分析</label></a>
				    <a href="${pageContext.request.contextPath}/tripnumber1"><label class="lab2">出團次數</label></a>
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
    
 <div class="div3">
<div>
<form:form method='POST' modelAttribute="TripBean" enctype="multipart/form-data" >
<div class="div4" style="box-shadow:  5px 15px 15px #218c74;">
<br><span class="spn1">套裝照片:</span>
<form:input path="packageImage" type="file" accept="image/x-png,image/gif,image/jpeg" onchange="document.getElementById('blah').src = window.URL.createObjectURL(this.files[0])"/>
<div class="div4" style="margin-top:10%;margin-bottom:2%;width:95%">
  <img id="blah"width="100%" height="100%" style="border: 2px solid rgb(0, 0, 0);" alt="PICTURE" />
  </div>
</div>
<form:hidden path="triptype" value="套裝行程"/>
<span class="spn1">套裝名稱:</span><form:input class="inp1" path="tripname" type="text" placeholder="tripname"/><br>
<span class="spn1">套裝天數:</span><form:input class="inp1" path="tripdays" type="text" placeholder="tripdays"/><br>
<span class="spn1">城市國家:</span><form:input class="inp1" path="countrycity" type="text" placeholder="countrycity"/><br>
<span class="spn1">最低價格:</span><form:input class="inp1" path="lowestprice" type="text" placeholder="lowestprice"/><br>
<input class="inp3" style="height:40px"type="submit" value="ENTER">
</form:form>
</div>
</div>
</div>
</body>
</html>