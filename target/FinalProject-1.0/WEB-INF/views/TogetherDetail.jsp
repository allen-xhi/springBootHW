<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%@ taglib prefix='form' uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html class="html -webkit-">
<head>
<meta charset="UTF-8" content="text/html" http-equiv="Content-Type">
<title>${title}</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous"/>
<link rel='stylesheet' href='${pageContext.request.contextPath}/CSS/Project.css'  type="text/css" />
<link href="https://fonts.googleapis.com/css?family=Noto+Sans+TC:700" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Righteous" rel="stylesheet">
<link rel='stylesheet' href='${pageContext.request.contextPath}/CSS/board.css'  type="text/css" />
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.parallax-1.1.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.localscroll-1.2.7-min.js"></script>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.scrollTo-1.4.2-min.js"></script>
<link rel='stylesheet' href='${pageContext.request.contextPath}/CSS/TogetherDetail.css'  type="text/css" />
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

     
	 //////////////////////////////////////////////////////////////
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
		 $("#panel"+index+"").slideToggle(500);
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
	 //////////////////////////////判斷登入者是否為版主//////////////////////////////////
	 var master = $("#masterid").text()
	 var NeedId = $("#joinNeedId").text();
	 if(master=="${memberBean.email}"){
		 $("#buttondiv").append("<a href='${pageContext.request.contextPath}/updateNeed/"+ NeedId +"' class='button' id='departure'>確定出團</a>");
	 	$("#Reviewjoin").show();
	 }else{
		$("#buttondiv").append("<button class='button' id='join'>我要參加</button>");
	 }
	 
// 	 $("#departure").click(function(){
// 		 var NeedidGo = $("#joinNeedId").text();
// 		 $.ajax({
// 			 type:"POST",
// 			 url:"updateNeed",
// 			 date:{NeedId:NeedidGo},
// 			 success:function(data){
// 				alert("success")
// 					 location.href = "${pageContext.request.contextPath}/planeticketsearch";
// 			 }
// 			 error:function(){
// 				 alert("error")
// 			 }
// 		 })
// 	 }
	 ///////////////////////////////////////////////////////////////////
	 $("#join").click(function(){
		 var master = $("#masterid").text();
		 var tripname = $("#tripname").text();
		 var needid = $("#joinNeedId").text();
		 var joinid = $("#joinid").text();
		
		 $.ajax({
			 type:"POST",
			 url:"${pageContext.request.contextPath}/join",
			 data:{joinaccountid:joinid,masteraccountid:master,tripname:tripname,needid:needid},
			 dataType:"html",
			 success:function(data){
				 
				 if(data=="Success!"){
					 // When the user clicks on the button, open the modal 
					   modal.style.display = "block";
					   $(".modal-header").css({"background":"#00bb00"});
					  $("#viewjoin").html("報名成功")
					$.ajax({
						 type:"POST",
						 url:"${pageContext.request.contextPath}/SendEmail",
						 data:{joinaccountid:joinid,masteraccountid:master,tripname:tripname,needid:needid},
						 dataType:"html",
						 success:function(data){
						 alert(data);
						 }
					})
				 }else if(data=="Fail"){
					 modal.style.display = "block";
					 $(".modal-header").css({"background":"#ff5151"});
					 $("#viewjoin").html("你已報名過此行程!")
				 }else{
					 modal.style.display = "block";
					 $(".modal-header").css({"background":"#ff5151"});
					 $("#viewjoin").html("此行程名額已滿!")
				 }
			 },
			 error:function(){
				 modal.style.display = "block";
				 $(".modal-header").css({"background":"#ff5151"});
				 $("#viewjoin").html("請先登入會員!")
				 window.onclick = function(event) {
	   				if (event.target == modal) {
	    			 modal.style.display = "none";
	   }
				 location.href="${pageContext.request.contextPath}/login";
				 }
			 }
		 })
	 })
	 ///////////////////////////////////////留言板/////////////////////////////////////////////////
	 sessionStorage.setItem("lastname", "${memberBean.id}");
		var member=sessionStorage.getItem("lastname");
		var message;
	 $("#send").click(function() {
			var sentence = $('#input').val();
			<c:forEach var="NeedDetail" items="${NeedDetail}">
			var needid = ${NeedDetail.needId};
			</c:forEach>
	       // var myUrl = "${pageContext.request.contextPath}/addboard?sentence=" + $('#input').val()+"&name="+member+"&needid="+${needNo};
	        $.ajax({
	            type: 'POST',
	            url: "${pageContext.request.contextPath}/addboard",
	            data:{sentence:sentence,userid:member,needid:needid},
	            dataType: 'json',
	            success: function(data){
	            	alert("success")  
	            	for(i in data){

// 	            message =$.parseJSON(data.jsondata);
	            		commentframe.innerHTML  +='<br>'+'<div class="message">'+
	            								'<label style="float:left">'+data[i].member+
	            								" 留言: "+data[i].sentence+'</label>'+
	            								'<label style="float:right">'+data[i].time+'<label>'+"</div>";
	            	}
	            	$('#input').val("");
	            	
	            }, 
	            error: function() {
	            	modal.style.display = "block";
					 $(".modal-header").css({"background":"#ff5151"});
					 $("#viewjoin").html("請先登入會員!")
					 window.onclick = function(event) {
		   				if (event.target == modal) {
		    			 modal.style.display = "none";
		   				}
					 location.href="${pageContext.request.contextPath}/login";
					 }
	            }
	        });
	    });
	 ////////////////////////////////////////同意報名/////////////////////////////////////////////////
	 $(".masterupdate").click(function(){
		 var id = this.id;
		 $.ajax({
			 type: 'POST',
	            url: "${pageContext.request.contextPath}/MasterAgree",
	            data:{appid:id},
	            dataType: 'text',
	            success:function(data){
	            	if(data=="Success"){
	            	 modal.style.display = "block";
					 $(".modal-header").css({"background":"#00bb00"});
					 $("#viewjoin").html("操作成功")
					 window.onclick = function(event) {
		   				if (event.target == modal) {
		    			 modal.style.display = "none";
		   					}
					 location.reload(); 
	           		 }
	         	}
	         },
	            error:function(){
	            	alert("error")
	            }
		 })
	 });
	 ////////////////////////////////////////拒絕報名//////////////////////////////////////////////////
	 $(".masterdelete").click(function(){
		 var id = this.id;
		 $.ajax({
			 type: 'POST',
	            url: "${pageContext.request.contextPath}/MasterRefuse",
	            data:{appid:id},
	            dataType: 'text',
	            success:function(data){
	            	if(data=="Delete"){
	            	 modal.style.display = "block";
					 $(".modal-header").css({"background":"#00bb00"});
					 $("#viewjoin").html("操作成功")
					  window.onclick = function(event) {
		   				if (event.target == modal) {
		    			 modal.style.display = "none";
		   				}
	            		location.reload();
	            	}
	            }
	           },
	            error:function(){
	            	alert("error")
	            }
		 })
	 });
	 ///////////////////////////////////沒有審核中的人  顯示無人報名////////////////////////////////
	 var none = $("#joinName").text();
	 if(none == null ||none =="" || none== undefind ){
		 $("#nonepeople").show();
	 }
 })
</script>
</head>
<body style="margin-top:20px;">
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

<div class="leftdiv"><c:forEach var="NeedDetail" items="${NeedDetail}">
<div class="title" >揪團資訊</div>
<%-- ID : ${NeedDetail.needId}<br> --%>

<div style="border-bottom:2px solid black;margin:8px;">主辦人 :<span style="text-align: center;" ><a href="" class="user" id="masterid">${NeedDetail.memberBean.email}</a></span>
<span style="display:none" id="joinid">${memberBean.id}</span></div><br>
<div class="NeedLeft">出發時間 : ${NeedDetail.departureTime}</div>
<div class="NeedLeft">需求人數 : ${NeedDetail.requiredPeople}</div>
<div class="NeedLeft">回程時間 : ${NeedDetail.comebackTime}</div>
<div class="NeedLeft">初估預算 : ${NeedDetail.budget}</div>
<div class="NeedLeft">揪團截止日 :${NeedDetail.deadline}</div>
<div class="NeedLeft">如未揪滿人，是否開團 :<c:if test="${NeedDetail.whetherFull=='0'}">否</c:if><c:if test="${NeedDetail.whetherFull=='1'}">是</c:if></div>
<div class="NeedLeft">有人未付款，是否出團 :<c:if test="${NeedDetail.noPayGoOrNot=='0'}">否</c:if><c:if test="${NeedDetail.noPayGoOrNot=='1'}">是</c:if></div>
<label style="display:none;" id="tripname">${NeedDetail.tripBean.tripname}</label>
<label style="display:none;" id="joinNeedId">${NeedDetail.needId}</label>
</c:forEach>
<div id="Reviewjoin" class="Reviewjoindiv" style="margin-top:20px;" >
<fieldset class="agreeornot" ><legend style="color:red;">報名審核中</legend>
<div style="height:30px; margin:15px;margin-top:20px;display:none;color:#9d9d9d;text-align: center;" id="nonepeople"><label id="">---------------目前無人報名---------------</label></div>
<c:forEach var="Reviewjoin" items="${Reviewjoin}">
	<div style="height:30px; margin:15px;margin-top:20px;border-bottom:1px solid black;"><a class="user" href="${pageContext.request.contextPath}/needLogin/showUserDetailInfo/${Reviewjoin.memberBean.id}"><label id="joinName">${Reviewjoin.memberBean.memberName}</label></a>
	<button class="masterupdate" id="${Reviewjoin.appId}">同意</button><button class="masterdelete" id="${Reviewjoin.appId}">拒絕</button></div>
	</c:forEach>
	</fieldset> 
</div>
</div>
<div class="BodyDiv">
<!-- The Modal -->
<div id="myModal" class="modal">
<!-- Modal content -->
<div class="modal-content">
  <div class="modal-header">
    <h2><i class="fas fa-exclamation-circle"></i>&nbsp;&nbsp;系統訊息</h2>
    <span class="close">&times;</span>
  </div>
  <div class="modal-body">
    <p id="viewjoin"></p>
    
  </div>
</div>
</div>

<c:set var="a" value="0"/>
<div style="border-bottom:1px solid green; width:100%;height: 60px;line-height: 60px;">
已報名團員：
<c:forEach var="joinmemeber" items="${joinmember}"> 
<c:if test="${memberBean.id!=joinmemeber.memberBean.id}">
	<label style="margin:5px; "><a href="${pageContext.request.contextPath}/needLogin/showOtherDetailInfo/${joinmemeber.memberBean.id}" class="user">${joinmemeber.memberBean.memberName}</a></label>
</c:if>
</c:forEach>
</div>
<div id="tab-panel">
  <div class="tabs">
    <a>行程規劃</a>
    <a>揪團留言板</a>
    <a>其他</a>
  </div>
  <ul class="tab-content">
 	<li>
 	
<div style="width:95%;border:1px solid #DCDCDC;padding:10px;margin:auto; border-left:3px solid green;">
<c:forEach var="tripDetail" items="${TripDetail}">

<c:if test="${tripDetail.whichday!=a}">

<c:set var="a" value="${tripDetail.whichday}"/>
<div class="whichday"><span style="margin:auto;color:white;">第<label style="font-size:33px;margin-right:5px;color:white;">
${tripDetail.whichday}</label>天</span></div>
<c:forEach var="tripDetail1" items="${TripDetail}">
<c:if test="${tripDetail1.whichday==a}">
<%-- ViewID : ${tripDetail.sceneryBean.viewid}<br> --%>
<label class="countrydiv">${tripDetail1.sceneryBean.country}&nbsp&nbsp${tripDetail1.sceneryBean.city}：${tripDetail1.sceneryBean.name}&nbsp&nbsp&nbsp&nbsp
</label>

</c:if>
</c:forEach>
<%-- <c:forEach var="tripDetail" items="${TripDetail}">  --%>
<%-- <c:forEach var="num" begin="0" end="3" step="1"> --%>
  
<c:set var="b" value="0"/>
<div class="panel" id="panel${tripDetail.whichday}">

<c:forEach var="tripDetail1" items="${TripDetail}">
<%-- <c:if test="${tripDetail1.whichday!=b}"> --%>
<%-- <c:set var="b" value="${tripDetail1.whichday}"/> --%>
<c:if test="${tripDetail1.whichday==a}">
<div class="citydiv">●【${tripDetail1.sceneryBean.country}&nbsp&nbsp&nbsp${tripDetail1.sceneryBean.city}：${tripDetail1.sceneryBean.name}】</div>
<div class="viewdiv" >${tripDetail1.sceneryBean.introduction}</div>
<div class="viewdiv" >
<span style="font-weight: 10;">景點地址 :</span> <a href="https://www.google.com.tw/maps/search/${tripDetail1.sceneryBean.address}" target="_blank" style="font-family:微軟正黑體;" >${tripDetail1.sceneryBean.address}</a></div>
<div class="viewdiv" >購票需求 : <c:if test="${tripDetail1.sceneryBean.needticket=='1'}">是</c:if>
<c:if test="${tripDetail1.sceneryBean.needticket=='0'}">否</c:if> &nbsp&nbsp價位 : ${tripDetail1.sceneryBean.price}</div>
</c:if>
<%-- </c:if> --%>

</c:forEach>
</div>
<div class="flip" id="flip${tripDetail.whichday}"><span class="1" id="span${tripDetail.whichday}">展開行程內容</span></div>
<%-- </c:forEach> --%>
</c:if>


<%-- ${tripDetail.orderby}<br> --%>

<%-- ${tripDetail.sceneryBean.photo}<br> --%>

</c:forEach>

<div style="text-align: center;margin-top:50px;" id="buttondiv"><a href="${pageContext.request.contextPath}/GetTogether" class="button">返回上一頁</a><button  class="button1" id="join1">版主審核中</button></div>
</div>

</li>
 	<li><div><fieldset id="commentframe" class=dialog>

		<div style="text-align: center;">
			<h1 style="margin-top: 30px" style="color:#009432;">MessageBoard</h1>
		</div>
		
<!-- controller 回傳的List<Boardmessage> 型態資料 -->
		<c:forEach var='boards' items='${BoardHistory}'>
			<div class="message">
				<label style="float: left">${boards.memberBean.memberName}&nbsp;&nbsp;留言:&nbsp;&nbsp;&nbsp;</label> 
				<label style="float: left">${boards.sentence}</label>
				<br>
				<label style="float: right">${boards.time}</label>
			</div>
			<br>
<!-- 虛線分隔-->
			<hr size="1" noshade="noshade" style="border: 0.2px #C8E6C9 dotted;" />
		</c:forEach>
	</fieldset>

	<fieldset id=Inputframe>
		<div class="background">
			
			<input id="input" name="input" type="text">

			 <input type="button" class="send" id="send" value="send" >
		</div>
	</fieldset></div></li>
 	<li><div></div></li>
  </ul>
</div>
</div>

</div>

</body>

</html>