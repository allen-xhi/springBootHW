<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%@ taglib prefix='form' uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html class="html -webkit-">
<head>
<meta charset="UTF-8">
<title>${title}</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous"/>
<link rel='stylesheet' href='${pageContext.request.contextPath}/CSS/Project3.css'  type="text/css" />
<link href="https://fonts.googleapis.com/css?family=Noto+Sans+TC:700" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Righteous" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
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
	})
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
  <form:form method='POST' modelAttribute="SceneryBean" enctype="multipart/form-data" >
  <div class="div5"> 
  <div class="div4" style="box-shadow:  5px 15px 15px #218c74;">
  <div class="div4" style="margin-top:6%;">
  <img id="blah"width="100%" height="100%" style="border: 2px solid rgb(0, 0, 0)" alt="PICTURE" />
  </div>
  <br><span class="spn1">景點照片:</span>
  <form:input type="file" class="inp1" id="imgInp" path="viewImage" accept="image/x-png,image/gif,image/jpeg" style="width:40%;height:50px;margin-top:10px"  onchange="document.getElementById('blah').src = window.URL.createObjectURL(this.files[0])"/><br>
  <span class="spn1">景點介紹:</span><br>
  <form:textarea path="introduction" style="width:40%;height:50%;margin-left:30px;border: 2px solid rgb(0, 0, 0);padding:5px" placeholder='景點介紹...' />
  </div><br>
 <span class="spn1">景點名稱:</span><form:input type="text" class="inp1" path="name" placeholder='景點名稱'/><br>
 <span class="spn1">景點國家:</span><form:input type="text" class="inp1" path="country" placeholder='景點國家'/><br>
 <span class="spn1">景點城市:</span><form:input type="text" class="inp1" path="city" placeholder='景點城市'/><br>
 <span class="spn1">景點地址:</span><form:input type="text" class="inp1" path="address" placeholder='景點地址'/><br>
 <span class="spn1">是否要買票:</span><span style="font-size:20px">&nbsp;&nbsp;是</span><form:radiobutton class="inp2" name="needticket" path="needticket" value="1"/>
                                     <span style="font-size:20px">&nbsp;&nbsp;否</span><form:radiobutton class="inp2" name="needticket" path="needticket" value="0"/><br>
 <span class="spn1">景點門票:</span><form:input type="text" class="inp1" path="price" placeholder='景點價格'/><br>
<input type="submit" class="inp3" value="ENTER">
 </div>
 </form:form>
</div>
</body>
</html>