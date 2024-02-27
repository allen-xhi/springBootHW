<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%@ taglib prefix='form' uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html class="html -webkit-">
<head>
<meta charset="UTF-8">
<title>${title}</title>
<link rel='stylesheet' href='${pageContext.request.contextPath}/CSS/Project2.css'  type="text/css" />
<link href="https://fonts.googleapis.com/css?family=Noto+Sans+TC:700" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Righteous" rel="stylesheet">
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.parallax-1.1.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.localscroll-1.2.7-min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.scrollTo-1.4.2-min.js"></script>
  <script defer src="https://use.fontawesome.com/releases/v5.7.2/js/all.js" integrity="sha384-0pzryjIRos8mFBWMzSSZApWtPl/5++eIfzYmTgBBmXYdhvxPc+XcFEk+zJwDgWbP" crossorigin="anonymous"></script>
 <script>
 /* $(document).ready(function(){
	$('.div1').localScroll(800);
	$('.div2').parallax("50%", 0.1);
	 $('#trip1').parallax("50%", 0.1);
	 $('#trip2').parallax("50%", 0.4);
	$('#trip3').parallax("50%", 0.3); 
}) */
 $(window).load(function() {
	/*  $('.div2').parallax("50%", 0.1); */
	     $(".div2").parallax({offsetY:31});  
	});
 $(document).ready(function() { 
	 $("#idback").hover(function(){
		 $("#idback").css({"background-color":"rgb(140, 140, 140)"})
	 },function(){
			$("#idback").css({"background-color":"rgb(179, 179, 179)"})});
	 $("#idnext").hover(function(){
		 $("#idnext").css({"background-color":"rgb(140, 140, 140)"})
	 },function(){
			$("#idnext").css({"background-color":"rgb(179, 179, 179)"})});
	 var i =0;
	 $("#idback").click(function(){	
		 i--;
		 if(i<0) i=0;
		 $(".div2").css({"background":"url(/FinalProject/images/next"+i+".jpg) no-repeat fixed","background-size":"100%"})		 
	 });
	 $("#idnext").click(function(){	
		 i++;
		 if(i>4) i=4;
		 $(".div2").css({"background":"url(/FinalProject/images/next"+i+".jpg) no-repeat fixed","background-size":"100%"})		
	 });
	 ///////////////////////////////////////////////////////////////////////////////////
	 	 var loginStatus = "${loginStatus}";
		 if(loginStatus=='true'){
			 var email = "${memberBean.email}";
			 var account = (email.split('@'))[0];
			 $("#registerLabel").text("登出");
			($("#registerLabel").parent()).click(function(){
				 event.preventDefault();
				})	
			 $("#registerLabel").click(function(){
			 $.ajax({
				url:"logout",
				type:"get",
				success:function(data){
					alert(data);
					location.href = "${pageContext.request.contextPath}";
				},error:function(data){
							
				}
				});
				 });
			 $("#loginLabel").text(account);
			($("#loginLabel").parent()).click(function(){
				 event.preventDefault();
			});
			$("#loginLabel").click(function(){
				 location.href = "needLogin/showUserInfo";
			 })
			 }
 });

</script>
</head>
<body>
<div class="div0">
<header class="header1">
<div class="div1">
    <a href="${pageContext.request.contextPath}/"><label class="lab0">To-touring</label></a>
    <a href="${pageContext.request.contextPath}/register"><label class="lab1" id="registerLabel">註冊</label></a>
    <a href="${pageContext.request.contextPath}/login"><label class="lab1" id="loginLabel">登入</label><img class="img2" src="${pageContext.request.contextPath}/images/login.png">
    </a>
    <img class="img1" alt="" src="">
    <a href="${pageContext.request.contextPath}/editorpackagefirst"><label class="lab2">製作套裝</label></a>
    <a href="${pageContext.request.contextPath}/editorviews"><label class="lab2">增加景點</label></a>
    <a href="${pageContext.request.contextPath}/changeflightprice"><label class="lab2">機票價格</label></a>
    <a href="${pageContext.request.contextPath}/excel"><label class="lab2">報表分析</label></a>
    <a href="${pageContext.request.contextPath}/tripnumber"><label class="lab2">出團次數</label></a>
</div>
<nav class="nav1">
<div class="div4">
<a href="${pageContext.request.contextPath}/planeticketsearch" ><label class="label1">機票搜詢</label></a>
<a href="${pageContext.request.contextPath}/customerpackage" ><label class="label1">套裝行程</label></a>
<a href="${pageContext.request.contextPath}/" ><label class="label1">自訂行程</label></a>
<a href="${pageContext.request.contextPath}/GetTogether" ><label class="label1">尋找出團</label></a>
<a href="${pageContext.request.contextPath}/scenery" ><label class="label1">熱門景點</label></a>
</div>
</nav>
<div class="div2">
 <img id="idback" class="control" src="${pageContext.request.contextPath}/images/left.png">
 <img id="idnext" class="control2" src="${pageContext.request.contextPath}/images/right.png">
</div>
</header>
<div class="search-box">
<input class="search-txt" type="text" name="" placeholder="Type to search">
<a class="search-btn" href="#">
<i class="fas fa-search"></i>
</a>
</div>
<div class="div3" id="trip1"></div>
<div class="div3" id="trip2"></div>
<div class="div3" id="trip3"></div>
<div class="div3" id="trip4"></div>
<div class="div3" id="trip5"></div>

</div>

</body>

</html>