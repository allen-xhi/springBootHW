<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%@ taglib prefix='form' uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>To-touring</title>
<link href="https://fonts.googleapis.com/css?family=Righteous" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Noto+Sans+TC" rel="stylesheet">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
<link href="${pageContext.request.contextPath}/CSS/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.parallax-1.1.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.localscroll-1.2.7-min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.scrollTo-1.4.2-min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$('#nav').localScroll(800);
	
	//.parallax(xPosition, speedFactor, outerHeight) options:
	//xPosition - Horizontal position of the element
	//inertia - speed to move relative to vertical scroll. Example: 0.1 is one tenth the speed of scrolling, 2 is twice the speed of scrolling
	//outerHeight (true/false) - Whether or not jQuery should use it's outerHeight option to determine when a section is in the viewport
	$('#intro').parallax("50%", 0.1);
	$('#second').parallax("50%", 0.1);
	$('.bg').parallax("50%", 0.4);
	$('#third').parallax("50%", 0.3);
 	
	$(".search-box").mouseover(function(){
		$(".label1").show();
		$(".search-box").mouseout(function(){
			$(".label1").hide();
		})
	})
})
</script>
</head>

<body>
	<ul id="nav">
		<li><a href="#intro" title="Next Section"><img src="${pageContext.request.contextPath}/images/dot.png" alt="Link" /></a></li>
	    <li><a href="#second" title="Next Section"><img src="${pageContext.request.contextPath}/images/dot.png" alt="Link" /></a></li>
	    <li><a href="#third" title="Next Section"><img src="${pageContext.request.contextPath}/images/dot.png" alt="Link" /></a></li>
	    <li><a href="#fifth" title="Next Section"><img src="${pageContext.request.contextPath}/images/dot.png" alt="Link" /></a></li>
	</ul>
	
	<div id="intro">
		<div class="story">
	    	<div class="float-left">
			<h1 style="font-family: 'Righteous', cursive;">To-touring</h1><br><br>
	        <p style="font-size:20px;">每次旅行都需要行程規劃，每次出發都需要積極地詢問身邊的人是否有空一起出遊，每一次的旅行都想要記錄下規劃的行程，每次旅行都想要找到最合適的機票</p>
	        </div>
	    </div> <!--.story-->
	</div> <!--#intro-->
	
	<div id="second">
		<div class="story"><div class="bg"></div>
	    	<div class="float-right" style=";margin-top:200px">
	            <h1 style="color:black;font-weight: 20px">尋找旅伴將會有全新的體驗</h1><br><br>
	            <p style="font-size:20px;color:black;font-weight: 20px">在我們的平台找到符合自己需求以及志同道合的朋友，讓你的行前規劃不再因為找不到伴而煩惱，湊不到相同時間而取消</p><br>
	            <p style="font-size:20px;color:black;font-weight: 20px">透過互動式景點篩選，GOOGLEMAP自主式行程規劃，規劃所有人的私房景點，並分享出去找到合適的夥伴，一起溝通行前的安排，最後回來可以為自己的型打上分數</p>
	        </div>
	    </div> <!--.story-->
	    
	</div> <!--#second-->
	
	<div id="third">
		<div class="story">
	    	<div class="float-left">
	        	<h1 style="font-weight: bold">想出國趕快來體驗吧</h1><br><br>
	            <p style="font-size:20px;font-weight: bold">想要甚麼時候、找到合適的伴侶、最齊全的機票搜索、多元付款方式，前所未聞的出國規劃，趕快來體驗吧！！！！</p>
	        </div>
	    </div> <!--.story-->
	</div> <!--#third-->
	
	<div id="fifth">
<div class="search-box">
<a class="search-btn" href="${pageContext.request.contextPath}/planeticketsearch">
<label class="label1" style="font-size:40px;display:none;font-weight:bold;">ENTER</label>
<i class="fas fa-globe-asia" style="font-size:30px;"></i>
</a>
</div>
	</div> <!--#fifth-->
</body>
</html>
