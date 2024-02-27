<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%@ taglib prefix='form' uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html class="html -webkit-">
<head>
<meta charset="UTF-8">
<title>${title}</title>
<link rel='stylesheet' href='${pageContext.request.contextPath}/CSS/CustomerScenery.css'  type="text/css" />
<%-- <link rel='stylesheet' href='${pageContext.request.contextPath}/CSS/Project.css'  type="text/css" /> --%>
<link rel='stylesheet' href='${pageContext.request.contextPath}/CSS/google.css' type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/backpack.js"></script>
<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/js/dragdroptest.js"></script> --%>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="//apps.bdimg.com/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="//apps.bdimg.com/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>
<link href="https://fonts.googleapis.com/css?family=Noto+Sans+TC:700" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Righteous" rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script defer src="https://use.fontawesome.com/releases/v5.7.2/js/all.js" integrity="sha384-0pzryjIRos8mFBWMzSSZApWtPl/5++eIfzYmTgBBmXYdhvxPc+XcFEk+zJwDgWbP" crossorigin="anonymous"></script>
<script type="text/javascript">

function dragStart(event) {
	  event.dataTransfer.setData("Text", event.target.id);
	 $(function saveview() {
			
			var viewid = $('#placeid').html();
			var name = $('.123').html();
		    var address = $('#address').html();
		    var city = $('#city').html();
		    var country = $('#country').html();
		    var introduction = $('#temp').html();
		    
		    $.ajax({
		    	
		        url: "customerscenery",
		        
		        data: { viewid:viewid, name:name, address:address, city:city, country:country, introduction:introduction},
		       
		        type: "POST",
		       
		        success: function (data) {
		         
		        }
		    })
		})
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
			
		
		}

$(document).ready(function(){
		$("#submit").click(submit)
	function submit(){
	var days = $("#tripdays").val();
	
	var trip = $("#tripid").val();
	alert(trip)
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
		url:"customerdetails",
		data:{tripdetails: tripdetails,tripId: trip},
		type:"post",
		dataType:"html",
		success:function(data){
			window.location.href = data;
		}
		})
	}
	});
	
$(document).ready(function(){
	$("#delete").click(function(){
	$(".dragItemStyle").remove();
	});
	});
	
	
</script>
</head>
<body >
<!-- <div class="div0"><br/><br/> -->
<!-- <header class="header1"> -->
<!-- <div class="div1"> -->
<!--     <a href="#"><label class="lab0">To-touring</label></a> -->
<!--     <a href=""><label class="lab1">註冊</label></a> -->
<%--     <a href="editor"><label class="lab1">登入</label><img class="img2" src="${pageContext.request.contextPath}/images/login.png"> --%>
<!--     </a> -->
<!--     <img class="img1" alt="" src=""> -->
<!--     <a href="editorpackage"><label class="lab2" style="background-color: rgb(255, 119, 51)">製作套裝</label></a> -->
<!--     <a href="editorviews"><label class="lab2">增加景點</label></a> -->
<!--     <a href=""><label class="lab2">會員管理</label></a> -->
<!--     <a href=""><label class="lab2">報表分析</label></a> -->
<!--     </div> -->
<!--     </header> -->
<!-- <div class="div0" style="z-index:999999;background: radial-gradient(#F5DEB3,#D2B48C,#AAAAAA);"> -->
	
			<div style="height:auto; z-index:999999;background: radial-gradient(#F5DEB3,#D2B48C,#AAAAAA);">
				<a href="${pageContext.request.contextPath}/" style="height:40px;width: 30%; font-family: 'Righteous', cursive; font-size: 40px; color: rgb(0, 0, 0);margin-left: 5%;text-decoration:none" id="logo">
					<em style="color:#2F4F4F">To-touring</em></a>
				<a href="${pageContext.request.contextPath}/register"><label id="registerLabel"
					style="width: 60px;font-family:微軟正黑體; font-size: 17px; text-align: center; margin-top: 20px; margin-left: 1px; margin-right: 5px; background-color:#DAA520; border-radius: 5px; float: right;"><i style="color:#556B2F">註冊</i> </label></a>
				<a href="${pageContext.request.contextPath}/login"><label id="loginLabel"
					style="width: 60px; float: right;font-family:微軟正黑體; font-size: 17px; text-align: center; margin-top: 20px; margin-left: 1px; margin-right: 5px; background-color:#DAA520; border-radius: 5px;"><i style="color:#556B2F">登入</i> </label><img
					style="height: 37px; margin-top: 15px; float: right;"
					src="${pageContext.request.contextPath}/images/login.png"> </a> <img
					class="img1" alt="" src="">
				<hr style="margin:0; border:none; border-top: 5px solid	#8B4513;">
			</div>
			<div style="background: radial-gradient(#FF8C00,#F4A460,#CD853F)">
				<div class="container">
					<div class="row" style="display:flex;">

						<a href="${pageContext.request.contextPath}/planeticketsearch" style="color: #8B4513; width: 20%; text-align: center;font-family:微軟正黑體;font-size: 20px;font-weight: bold;text-decoration:none" id=g1><i>機票搜尋</i> </a> 
						
						<a href="${pageContext.request.contextPath}/customerpackage" style="color:  #8B4513; width: 20%; text-align: center;font-family:微軟正黑體;font-size: 20px;font-weight: bold;text-decoration:none" id=g2><i>套裝行程</i></a>

						<a href="${pageContext.request.contextPath}/" style="color:  #8B4513; width: 20%; text-align: center;font-family:微軟正黑體;font-size: 20px;font-weight: bold;text-decoration:none" id=g3><i>自訂行程</i></a>

						<a href="${pageContext.request.contextPath}/GetTogether" style="color:  #8B4513; width: 20%; text-align: center;font-family:微軟正黑體;font-size: 20px;font-weight: bold;text-decoration:none" id=g4><i>尋找出團</i></a>

						<a href="${pageContext.request.contextPath}/scenery" style="color:  #8B4513; width: 20%; text-align: center;font-family:微軟正黑體;font-size: 20px;font-weight: bold;text-decoration:none" id=g5><i>熱門景點</i></a>
					</div>

				</div>

			</div>
		
	</div>
 <div class="div3">
<fieldset class="fie1"><legend>歡迎參加 ${tripname} </br> ${tripdays}天  自由行</legend>
<form action="Filter1" method="post">
<input style="display:none"name="title" value="${tripname}" >
<input style="display:none"  id="tripdays" name="days" value="${tripdays}" >
<input style="display:none"  id="tripid" name="id" value="${tripid}" >
<!-- <input class="search-txt" type="text" name="country" placeholder="Country"> -->
<!-- <input class="search-txt" type="text" name="city" placeholder="City"><br> -->
<!-- <input class="inp1" type="submit"> -->
</form><br>
<%--  <h2>${packagetitle}</h2> <h4>${day}</h4> --%>
 <c:forEach var="i" begin="1" end="${tripdays}" step="1" varStatus="check">
<div  class="div6">
<label class="lab3">第${i}天</label>
<div>

<ul id="${i}" class="div6" style="width:100%;" ondrop='bigdrop(event)' ondragover='allowDrop(event)' ></ul>

</div>

</div>
</c:forEach>
<button id="submit" class="submit">送出</button>

 </fieldset>
 <div style="display: none">
        <input id="pac-input"
               class="controls"
               type="text"
               placeholder="Enter a location">
    </div>       
    <div id="map"></div>
  
    		<div class="box">
    		
            <div class="reviews">網友評論:<ul id="rl" class="review-list"></ul></div>
            
           	<div id="move">
           	<fieldset class="intro"><legend>簡介</legend>
           	        <p style="display:none" id="placeid" name="placeid">1</p>	  	     
	         Rating:<p id="rating" name="rating"></p>
	      <br/>
	                       地點:<p  name="spot" class="123" draggable="true" ondragstart="dragStart(event)" ondragend="dragEnd(event)"></p>
	             <br/>
	            <p style="display:none" id="country" name=country></p>
	            <p style="display:none" id="city" name=city></p>
	                       地址:<p id="address"name=address></p>
	         <br/>                   
	                       網址:<p id="website" name=website></p>
	         <br/>                           
	                       電話:<p id="tel" name=tel></p>
	         <br/>                                   
	                       營業時間:<p id="open" name=open></p>
	               <p style="display:none" id="temp"></p> 
	          </fieldset> 
	       </div>
	       <div id="slide" name="photo"></div>
           </div>
  		   </div>
     
<!--  </div> -->
 

 <script async defer
        src="http://maps.googleapis.com/maps/api/js?libraries=places&key=AIzaSyB843AmWX8hF0Sh9jMPr3kvmYfvWQu7mLM&callback=initMap">
        </script>
</body>
</html>