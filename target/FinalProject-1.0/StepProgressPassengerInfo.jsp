<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>stepProcess</title>
<style type="text/css">
 * { 
/*  	font-family: 微軟正黑體;  */
/*  	font-size: 14px;  */
 } 

.progressBarContainer {
	width: 950px;
	height: 60px;
}

.progressbar {
	counter-reset: step;
}

.progressbar li {
	list-style-type: none;
	width: 25%;
	float: left;
	font-size: 12px;
	position: relative;
	text-align: center;
	text-transform: uppercase;
	color: #7d7d7d;
}

.progressbar li:before {
	width: 30px;
	height: 30px;
	content: counter(step);
	counter-increment: step;
	line-height: 30px;
	border: 2px solid #7d7d7d;
	display: block;
	text-align: center;
	margin: 0 auto 10px auto;
	border-radius: 50%;
	background-color: white;
}

.progressbar li:after {
	width: 100%;
	height: 2px;
	content: '';
	position: absolute;
	background-color: #7d7d7d;
	top: 15px;
	left: -50%;
	z-index: -1;
}

.progressbar li:first-child:after {
	content: none;
}

.progressbar li.active {
	color: green;
	font-weight: bold;
}

.progressbar li.active:before {
	border-color: #55b776;
}

.progressbar li.active+li:after {
	background-color: #55b776;
}
</style>
</head>
<body>
<div class="progressBarContainer">
		<ul class="progressbar">
			<li class="active">選擇機票</li>
			<li class="active">填寫乘客資訊</li>
			<li>付款</li>
			<li>交易完成</li>
		</ul>
	</div>

</body>
</html>