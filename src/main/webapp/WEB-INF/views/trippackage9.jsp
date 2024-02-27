<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%@ taglib prefix='form' uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html class="html -webkit-">
<head>
<meta charset="UTF-8" content="text/html" http-equiv="Content-Type">
<title>${title}</title>
<link rel='stylesheet' href='${pageContext.request.contextPath}/CSS/Project.css'  type="text/css" />
<link href="https://fonts.googleapis.com/css?family=Noto+Sans+TC:700" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Righteous" rel="stylesheet">
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.parallax-1.1.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.localscroll-1.2.7-min.js"></script>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.scrollTo-1.4.2-min.js"></script>
<link rel='stylesheet' href='${pageContext.request.contextPath}/CSS/TogetherDetail1.css'  type="text/css" />
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

	 //////////////////////////////////////////////////////////////////////////////////
	 var $tabPanel = $('#tab-panel') ,
     $tabs = $tabPanel.find('.tabs') ,
     $tab = $tabs.find('a') ,
     $tabContent = $tabPanel.find('.tab-content') ,
     $content = $tabContent.find('> li');
	  
	 $tab.eq(0).addClass('active');
	 $content.eq(0).show();
	  
	 $tab.click(function(){
	     var $tabIndex = $(this).index();
	     $(this).addClass('active').siblings().removeClass('active');
	     $content.eq($tabIndex).show().siblings().hide();
	 });
	 for(let index=1;index<10;index++){
	 console.log(index);
	 $("#flip"+index+"").click(function() {
		 $("#panel"+index+"").slideToggle(800);
		    $(".xs1").toggle();
		    $(".xs2").toggle();
	 }); 
	 $("#flip"+index+"").click(function() {
		var view =  $("#span"+index+"").text();
		if(view=="展開行程內容"){
			$("#span"+index+"").html("收合行程內容");
		}else{
			$("#span"+index+"").html("展開行程內容");
		}
	 });
	 }
	// Get the modal
	 var modal = document.getElementById('myModal');

	 // Get the <span> element that closes the modal
	 var span = document.getElementsByClassName("close")[0];

	

	 // When the user clicks on <span> (x), close the modal
	 span.onclick = function() {
	   modal.style.display = "none";
	 }

	 // When the user clicks anywhere outside of the modal, close it
	 window.onclick = function(event) {
	   if (event.target == modal) {
	     modal.style.display = "none";
	   }
	 }
	 ///////////////////////////////////////////////////////////////////
	 $("#join").click(function(){
		 var master = $("#masterid").text();
		 var tripname = $("#tripname").text();
		 var needid = $("#joinNeedId").text();
		 alert(master)
		 $.ajax({
			 type:"POST",
			 url:"${pageContext.request.contextPath}/join",
			 data:{joinaccountid:"Mary123",masteraccountid:master,tripname:tripname,needid:needid},
			 dataType:"html",
			 success:function(data){
				 if(data=="Success!"){
					 // When the user clicks on the button, open the modal 
					   modal.style.display = "block";
					  $("#viewjoin").html("報名成功")
				 }else{
					 modal.style.display = "block";
					 $(".modal-header").css({"background":"#ff5151"});
					 $("#viewjoin").html("你已報名過此行程!")
				 }
			 },
			 error:function(){
				 alert("error")
			 }
		 })
	 })
 })
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
</div>
<nav class="nav1" style="position: fixed;top:0;">
<div class="div4">
<a href="${pageContext.request.contextPath}/planeticketsearch" ><label class="label1">機票搜詢</label></a>
<a href="${pageContext.request.contextPath}/customerpackage" ><label class="label1">套裝行程</label></a>
<a href="${pageContext.request.contextPath}/CustomerSceneryfirst" ><label class="label1">自訂行程</label></a>
<a href="${pageContext.request.contextPath}/GetTogether" ><label class="label1">尋找出團</label></a>
<a href="${pageContext.request.contextPath}/scenery" ><label class="label1">熱門景點</label></a>
</div>
</nav>
</header>

<div class="BodyDiv">
<!-- The Modal -->
<div id="myModal" class="modal">
<!-- Modal content -->
<div class="modal-content">
  <div class="modal-header">
    <span class="close">&times;</span>
    <h2><i class="fas fa-exclamation-circle"></i>&nbsp&nbsp系統訊息</h2>
  </div>
  <div class="modal-body">
    <p id="viewjoin"></p>
    
  </div>
</div>
</div>

<c:set var="a" value="0"/>
<div style="width:95%;border:1px solid #DCDCDC;padding:10px;margin:auto; border-left:3px solid green;">
<c:forEach var="tripDetail" items="${detaillist}">
<input type="hidden" value="${tripDetail.tripbean.tripId}">
<c:if test="${tripDetail.whichday!=a}">

<c:set var="a" value="${tripDetail.whichday}"/>
<div class="whichday"><span style="margin:auto;color:white;">第<label style="font-size:33px;margin-right:5px;color:white;">
${tripDetail.whichday}</label>天</span></div>
<c:forEach var="tripDetail1" items="${detaillist}">
<c:if test="${tripDetail1.whichday==a}">
<label class="countrydiv">${tripDetail1.sceneryBean.country}&nbsp&nbsp${tripDetail1.sceneryBean.city}：${tripDetail1.sceneryBean.name}&nbsp&nbsp&nbsp&nbsp
</label>

</c:if>
</c:forEach>
<c:set var="b" value="0"/>
<div class="panel" id="panel${tripDetail.whichday}">
<c:forEach var="tripDetail1" items="${detaillist}">
<c:if test="${tripDetail1.whichday==a}">
<div class="citydiv">●【${tripDetail1.sceneryBean.country}&nbsp&nbsp&nbsp${tripDetail1.sceneryBean.city}：${tripDetail1.sceneryBean.name}】</div>
<img style="width:100%"src="<c:url value='/getphoto/${tripDetail1.sceneryBean.viewid}'/>">
<div class="viewdiv" >${tripDetail1.sceneryBean.introduction}</div>
<div class="viewdiv" >
<span style="font-weight: 10;">景點地址 :</span> <a href="https://www.google.com.tw/maps/search/${tripDetail1.sceneryBean.address}" target="_blank" style="font-family:微軟正黑體;" >${tripDetail1.sceneryBean.address}</a></div>
<div class="viewdiv" >購票需求 : <c:if test="${tripDetail1.sceneryBean.needticket=='1'}">是</c:if>
<c:if test="${tripDetail1.sceneryBean.needticket=='0'}">否</c:if> &nbsp&nbsp價位 : ${tripDetail1.sceneryBean.price}</div>
</c:if>
</c:forEach>
</div>
<div class="flip" id="flip${tripDetail.whichday}"><span class="1" id="span${tripDetail.whichday}">展開行程內容</span></div>
</c:if>
</c:forEach>
<div class="info">
<div style="width:100%">
<h2>東京酒店住宿</h2>
<p>東京交通網絡完善，所以景點間的交通連接很方便，不過如果可以住在東京的中心，去各個景點的時間都可以縮短，換言之可以把握時間去更多景點! 如果你對東京的交通不太熟識，可以考慮住在池袋、新宿及銀座等商業區，除了交通容易接駁，附近更有不少大商場及食店，十分方便!</p>
</div>
<div style="width:100%">
<h2>東京交通安排</h2>
<p>在東京自由行，最主要都是以鐵路連接不同的景點，而鐵路又分為JR、東京地鐵、都營地鐵、私鐵及一些特別線路如百合海鷗線和臨海線等，對自由行旅客來說確實是比較複雜。小編建議大家出發前可以下載日本交通app，如jorudan乗換案内，可以用手機快速搜尋搭車路線，清晰又方便。</p>
<h2>JR東日本路線網絡</h2>
<img style="width:100%"src="${pageContext.request.contextPath}/images/JR東日本路線網絡.jpg">
<h2>東京Metro地鐵路線圖</h2>
<img style="width:100%"src="${pageContext.request.contextPath}/images/東京Metro地鐵路線圖.jpg">
</div>
</div>
<c:forEach var="tripDetail" items="${detaillist}">
<c:set var="tripid" value="${tripDetail.tripbean.tripId}"></c:set>
</c:forEach>
<div style="text-align: center;margin-top:50px;">
<a href="${pageContext.request.contextPath}/customerpackage" class="button">返回上一頁</a>
<a href="${pageContext.request.contextPath}/selectNeed/${tripid}" class="button" id="join">我要出發去</a></div>


</div>

</div>

</div>

</body>

</html>