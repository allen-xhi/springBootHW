<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel='stylesheet' href='${pageContext.request.contextPath}/CSS/Project.css' type="text/css" />
<link href="https://fonts.googleapis.com/css?family=Noto+Sans+TC:700" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Righteous" rel="stylesheet">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr"
	crossorigin="anonymous">
<title>Insert title here</title>
<script>
	$(document).ready(function() {
		
		
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
//////////////////////////////////////////////////////////////////////////////////

		// 側邊選單
		$("li").click(function() {
			var i = $("li").index(this);
			$("[class='page-div']").attr("class", "page-div-hide");
			$("article").eq(i).attr("class", "page-div");
		});
		
	});
</script>
<style type="text/css">
* {
	box-sizing: border-box;
}

#g1:hover,#g2:hover,#g3:hover,#g4:hover,#g5:hover{  
    color:#DEB887; 
    background-color:#DEB887;  
  }
.full-div {
	width: 80%;
	height: 600px;
	margin: 20px auto;
	display: flex;
	padding: 10px;
	border: 2px solid orange;
	/* 	border-radius: 20px; */
}

.side {
	flex: 0 0 15%;
	max-width: 15%;
	height: 100%;
	list-style-type: none;
	border: 2px solid red;
	background: linear-gradient(135deg, #fcc274 0%, #eb48a1 100%);
}

.side li {
	height: 50px;
	padding: 10px 30px;
	border-bottom: 1px solid #FFF;
	color: #FFF;
	line-height: 30px;
}

.side li:hover {
	background: linear-gradient(135deg, #ffad99 0%, #ff0000 100%);
}

fieldset{
	padding: 15px 30px;  
}
.page-div {
	display: block;
	flex: 0 0 85%;
	max-width: 85%;
	padding:20px 40px; 
	border: 2px solid cyan;
}

.page-div-hide {
	display: none;
}

.div-in-article{
	height:calc(50% - 20px);
}
/* 已出團 報名中 CSS*/

.need-div {
	border: 1px solid green;
}

.need-airplant-div {
	border: 1px solid red;
}
/* 個人資料 CSS */
.div-row {
	display: flex;
	width: 60%;
}

.title-div {
	flex: 0 0 20%;
	max-width: 20%;
	padding: 10px;
	border-radius: 5px;
	background-color: #f0932b;
	border-width: 1px;
	border-bottom: 1px solid red;
	border-right: 1px solid red;
	opacity: 0.9;
	margin: 5px;
	opacity: 0.8;
}

.content-div {
	flex: 0 0 50%;
	max-width: 50%;
	padding: 10px;
	margin: 5px;
	border-radius: 5px;
	border: 1px solid pink;
	cursor:pointer;
}

.content-div:hover {
	background-color: #f0932b;
}

.update-info-div {
	display: none;
}

.update-info-div-show {
	position: fixed;
	left: calc(50% - 150px);
	top: calc(50% - 40px);
	height: 80px;
	width: 300px;
	background-color: orange;
	border: 1px solid white;
	z-index: 100;
	padding:20px;
}
.update-input-div{
	width:100%;
	height:80%;
	margin:auto;
}
.custom-table{
	table-layout: fixed;
}
li{
	cursor: pointer;
}
</style>
</head>
<body>

			<header>
			<div style="height:auto">
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

						<a href="${pageContext.request.contextPath}/CustomerSceneryfirst" style="color:  #8B4513; width: 20%; text-align: center;font-family:微軟正黑體;font-size: 20px;font-weight: bold;text-decoration:none" id=g3><i>自訂行程</i></a>

						<a href="${pageContext.request.contextPath}/GetTogether" style="color:  #8B4513; width: 20%; text-align: center;font-family:微軟正黑體;font-size: 20px;font-weight: bold;text-decoration:none" id=g4><i>尋找出團</i></a>

						<a href="${pageContext.request.contextPath}/scenery" style="color:  #8B4513; width: 20%; text-align: center;font-family:微軟正黑體;font-size: 20px;font-weight: bold;text-decoration:none" id=g5><i>熱門景點</i></a>
					</div>

				</div>

			</div>
		</header>
		<div class="full-div">
			<ul class="side">
				<li>個人資訊</li>
				<li>參加過的行程</li>
				<li>報名中的行程</li>
			</ul>
			<article class="page-div">
				<h1>個人資訊</h1>
				<fieldset>
					<div class="div-row">
						<div class="title-div">暱稱</div>
						<div class="content-div">${otherMap.otherBean.memberName}</div>
						<ul class="dropdown-menu" aria-labelledby="dropdownMenu4">
						  <li><a href="#">公開</a></li>
						  <li class="disabled"><a href="#">Disabled link</a></li>
						  <li><a href="#">不公開</a></li> 
						</ul>
					</div>
					<div class="div-row">
						<div class="title-div">姓氏</div>
						<div class="content-div">${otherMap.otherBean.lastName}</div>
					</div>
					<div class="div-row">
						<div class="title-div">名字</div>
						<div class="content-div">${otherMap.otherBean.firstName}</div>
					</div>
					<div class="div-row">
						<div class="title-div">生日</div>
						<div class="content-div">${otherMap.otherBean.birth}</div>
					</div>
					<div class="div-row">
						<div class="title-div">性別</div>
						<div class="content-div">${otherMap.otherBean.gender==1?'M':'F'}</div>
					</div>
					<div class="div-row">
						<div class="title-div">密碼</div>
						<div class="content-div">
							<c:forEach begin="1" end="${otherMap.otherBean.password.length()}">*</c:forEach>
						</div>
					</div>
					<div class="div-row">
						<div class="title-div">電子郵件</div>
						<div class="content-div">${otherMap.otherBean.email}</div>
					</div>
					<div class="div-row">
						<div class="title-div">電話</div>
						<div class="content-div">${otherMap.otherBean.phone}</div>
					</div>
				</fieldset>
			</article>
			<article class="page-div-hide">
				<div class="div-in-article">
					<h1>參加過的行程</h1>
					<table class="table table-dark">
						<thead>
						    <tr>
						      <th scope="col" style="width:25%">名稱</th>
						      <th scope="col" style="width:25%">截止日期</th>
						      <th scope="col" style="width:25%">出發時間</th>
						      <th scope="col" style="width:15%">人數</th>
						      <th scope="col" style="width:15%">天數</th>
						      <th scope="col" style="width:15%">預算</th>
						      <th scope="col" style="width:5%">#</th>
						    </tr>
						  </thead>
					 <tbody>
					<c:forEach var="finishApp" items="${otherMap.finishList}">
						<tr>
					      <td>${finishApp.needBean.tripBean.tripname}</td>
					      <td>${finishApp.needBean.departureTime}</td>
					      <td>${finishApp.needBean.budget}</td>
					      <td>${finishApp.needBean.requiredPeople}</td>
					      <td>${finishApp.needBean.tripBean.tripdays}</td>
					      <td><i class="fas fa-caret-down"></i></td>
					    </tr>
					</c:forEach>
						</tbody>
					</table>
				</div>
			</article>
			<article class="page-div-hide">
				<div class="div-in-article">
					<h1>報名中的行程</h1>
					<table class="table table-dark table-striped custom-table">
						<thead>
						    <tr>
						      <th scope="col" style="width:25%">名稱</th>
						      <th scope="col" style="width:25%">出發時間</th>
						      <th scope="col" style="width:15%">人數</th>
						      <th scope="col" style="width:15%">天數</th>
						      <th scope="col" style="width:15%">預算</th>
						      <th scope="col" style="width:5%">#</th> 
						    </tr>
						  </thead>
					 <tbody>
				
					<c:forEach var="payApp" items="${otherMap.payList}" varStatus="status">
						<tr style="background-color: #ff7675">
					      <td>${payApp.needBean.tripBean.tripname}</td>
					      <td>${payApp.needBean.departureTime}</td>
					      <td>${payApp.needBean.budget}</td> 
					      <td>${payApp.needBean.requiredPeople}</td>
					      <td>${payApp.needBean.tripBean.tripdays}</td>
					      <td><i class="fas fa-caret-down"></i></td>
					    </tr>
					</c:forEach>
					
					<c:forEach var="executeApp" items="${otherMap.executeList}" varStatus="status">
						<tr>
					      <td>${executeApp.needBean.tripBean.tripname}</td>
					      <td>${executeApp.needBean.departureTime}</td>
					      <td>${executeApp.needBean.budget}</td>
					      <td>${executeApp.needBean.requiredPeople}</td>
					      <td>${executeApp.needBean.tripBean.tripdays}</td>
					      <td><i class="fas fa-caret-down"></i></td> 
					      <td></td> 
					    </tr>
					</c:forEach>
						</tbody>
					</table>
				</div>
			</article>
		</div>


</body>
</html>