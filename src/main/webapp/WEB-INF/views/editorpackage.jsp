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
	crossorigin="anonymous"/>
<link rel='stylesheet' href='${pageContext.request.contextPath}/CSS/editorpackage.css'  type="text/css" />
<link href="https://fonts.googleapis.com/css?family=Noto+Sans+TC:700" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Righteous" rel="stylesheet">
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js"></script>
<script defer src="https://use.fontawesome.com/releases/v5.7.2/js/all.js" integrity="sha384-0pzryjIRos8mFBWMzSSZApWtPl/5++eIfzYmTgBBmXYdhvxPc+XcFEk+zJwDgWbP" crossorigin="anonymous"></script>
<script type="text/javascript">
$(document).ready(function(){
	////////////////////////////////////////////////////////////////
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
 //////////////////////////////////////////////////////////////////////////////////////////////
function dragStart(event) {
	  event.dataTransfer.setData("Text", event.target.id);
	  }
function dragStart2(event) {
	  var index = $(event.target).index()
	  event.dataTransfer.setData("Text", event.target.id);
	  event.dataTransfer.setData('index', index)
	}
	function dragEnd(event) {
		
	}

	function allowDrop(event) {
	  event.preventDefault();
	  
	}
	function bigdrop(event){
		var data = event.dataTransfer.getData("Text");	
		if($("#"+data).attr("class") =="123"){
			drop(event);
		}else{
			drop2(event);
		}	 
	}

	function drop(event) {
		event.preventDefault();	 
		var data = event.dataTransfer.getData("Text");	
		var eleObj =document.getElementById(data);
		var divObj = document.createElement("li");
		divObj.innerHTML=eleObj.innerHTML;
		divObj.setAttribute("class","li1");
		divObj.setAttribute("id",eleObj.innerHTML+"_1")
		divObj.setAttribute("name",eleObj.innerHTML)
		divObj.setAttribute("draggable","true");
		divObj.setAttribute("drop","drop2(event)");
		divObj.setAttribute("ondragstart","dragStart2(event)");
		divObj.setAttribute("ondragend","dragEnd(event)");
		event.currentTarget.appendChild(divObj);
		$("li").click(click);
		};
			
		function drop2(event){		
			event.preventDefault();	 
			event.stopPropagation();
			var data = event.dataTransfer.getData("Text");
			var oldParent = $("#"+data).parent().attr("id");
			var oldParent2 =$("#"+data).parent();
			var target = $(event.target);
			var targetParent = target.parent().attr("id");
			var oldIndex = event.dataTransfer.getData('index');
			var newIndex = target.index();	
			if(oldParent == targetParent){
			if (newIndex < oldIndex) {
			    target.before($("#"+oldParent+" "+"li:eq("+ oldIndex +")").remove())
			  } else {
			    target.after($("#"+oldParent+" "+"li:eq("+ oldIndex +")").remove())
			  }	
			}else if(target.attr("class") == "div6"){
				var eleObj =document.getElementById(data);
				var divObj = document.createElement("li");
				divObj.innerHTML=eleObj.innerHTML;
				divObj.setAttribute("class","li1");
				divObj.setAttribute("id",eleObj.innerHTML+"_1");
				divObj.setAttribute("name",eleObj.innerHTML);
				divObj.setAttribute("draggable","true");
				divObj.setAttribute("drop","drop2(event)");
				divObj.setAttribute("ondragstart","dragStart2(event)");
				divObj.setAttribute("ondragend","dragEnd(event)");
				event.currentTarget.appendChild(divObj);
				$("#"+oldParent+" "+"li:eq("+ oldIndex +")").remove();
			}
			else{
				 target.after($("#"+oldParent+" "+"li:eq("+ oldIndex +")").remove())
			}
			$("li").click(click);
		
		}
	function click(){
		var innerclick = $(this).attr("id");
		$("#showinfo").css({"display":"block"})
		$.ajax({
			url:"viewintro",
			data:{viewname: innerclick},
			type:"post",
			success:function(data){
				$("#introname").html(data.name);
				$("#introcountry").html(data.country);
				$("#introaddress").html(data.address);
				$("#intro").html(data.introduction);
			}
		})
	}
	$(document).ready(function(){
		$("#submit").click(submit)
	function submit(){
	var days = $("#tripdays").val();
	var trip = $("#tripid").val();
	var tripdetails ={};
	for(var i = 1;i<= days;i++){
		var lis = $("#"+i+">li").length;
		var li="";
		for(var j = 0;j<= lis - 1;j++){
		 li +=  $("#"+i+" "+"li:eq("+j+")").attr("name")+","		 
		}
		tripdetails[i] = li ;
	}
	$.ajax({
		url:"tripdetails",
		data:{tripdetails: tripdetails,tripId: trip},
		type:"post",
		dataType:"html",
		success:function(data){
			window.location.href = data;
		},error:function(data){
			alert("請妥善安排行程");			
		}
		})
	}
	});
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

 <div class="div5">
 <c:forEach var="viewcity" items="${view}">
 <h2>${viewcity}</h2>
<c:forEach var="view" items="${Views}">
<c:if test="${viewcity==view.city}">
<div class="div4">
<div id="${view.name}" class="123" style="height:50px;float:left" draggable="true" ondragstart="dragStart(event)" ondragend="dragEnd(event)">${view.name}</div>
<img src="<c:url value='/getphoto/${view.viewid}'/>" style="height:50px;width:67px;float:right"/>
</div>
</c:if>
</c:forEach>
 </c:forEach>
</div>

<fieldset class="fie1"><legend>請輸入國家或城市</legend>
<form action="Filter1" method="post">
<input type="hidden" name="title" value="${tripname}" >
<input type="hidden"  id="tripdays" name="days" value="${tripdays}" >
<input type="hidden"  id="tripid" name="id" value="${tripid}" >
<input class="search-txt" type="text" name="country" placeholder="Country">
<input class="search-txt" type="text" name="city" placeholder="City"><br>
<input class="inp1" type="submit">
</form><br><br><br>
 <h2>${packagetitle}</h2> <h4>${day}</h4>
 <c:forEach var="i" begin="1" end="${days}" step="1" varStatus="check">
<div class="div6">
<label class="lab3">第${i}天</label>
<div>
<ul id="${i}" class="div6" style="width:100%;" ondrop='bigdrop(event)' ondragover='allowDrop(event)'></ul>
</div>

</div>
</c:forEach>
<input type="button" id="submit" value="ENTER">
 </fieldset>
 <div id="showinfo" style="width:30%;height:align-items;background-color: #CDDC39;border-radius:25px;padding:10px;position:fixed;top:40%;left:35%;display: none;"> 
 <label id="introname" class="lab4"></label><br><br><br>
 <label id="introcountry" class="lab5"></label>
 <label id="introaddress" class="lab5"></label><br>
 <p id="intro" style="float: left"></p>
 </div>


</div>

</div>

</body>

</html>