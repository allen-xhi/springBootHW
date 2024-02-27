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
<link rel='stylesheet' href='${pageContext.request.contextPath}/CSS/changeflightprice.css'  type="text/css" />
<link href="https://fonts.googleapis.com/css?family=Noto+Sans+TC:700" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Righteous" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.1/jquery-ui.js"></script>
	<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.11.1/themes/smoothness/jquery-ui.css">
<style>
.ui-autocomplete {
    max-height: 150px; 
    overflow-y: auto;    
    overflow-x: hidden;
  }
</style>
<script type="text/javascript">
$(function() {
	$.ajax({
		url : "xml/CITY_CHT.xml",
		dataType : "xml",
		/********************************************************/
		/* Getting the data from XML file.                      */
		/********************************************************/
		success : function(xmlResponse) {
			// Highlight the selected text
			$.extend($.ui.autocomplete.prototype, {
				_renderItem : function(ul, item) {
					var term = this.element.val(), regex = new RegExp('('
							+ term + ')', 'gi');
					html = item.label.replace(regex, "<b>$&</b>");
					return $("<li></li>").data("item.autocomplete", item)
							.append($("<a></a>").html(html)).appendTo(ul);
				}
			});
			// Finds all the elements named "code" then return the specific elements
			var data = $("T", xmlResponse).map(
					function() {
						return {
							value : $("C", this).text() + " - "
									+ ($.trim($("D", this).text())),
						};
					}).get();
			$("#orgin").autocomplete({
				source : data,
				minLength : 0,
			});
			
			$("#destination").autocomplete({
				source : data,
				minLength : 0,
			});
		}, //function
	}); //ajax
}); //window
$(document).ready(function(){

			/////////////////////////////////////////////////////////////////////////
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
</script>
</head>
<body style="margin-top:100px;">

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
	<h1 style="border-bottom:4px double black;width:68%;font-family:'Noto Sans TC', sans-serif;margin-left:20px;">機票價格調整</h1>
    <form:form method="post" modelAttribute="FlightpriceBean">
  <div class="div2" >
 <form:input type="text" id="orgin" placeholder="國家/地區、城市或機場"
								name="orgin" path="departure"/>
<form:input type="text" id="destination" placeholder="國家/地區、城市或機場"
								name="destination" path="destination"/>
 <label>加價百分比</label><form:select path="addpercent">
 <option value="0">0</option>
 <option value="0.5">0.5</option>
 <option value="1.0">1.0</option>
 <option value="1.5">1.5</option>
 <option value="2.0">2.0</option>
 <option value="2.5">2.5</option>
 </form:select>
 
  <label>加價價格</label><form:select path="addprice">
  <option value="0">0</option>
 <option value="500">500</option>
 <option value="1000">1000</option>
 <option value="1500">1500</option>
 <option value="2000">2000</option>
 </form:select>
 <input type="submit" value="修改" id="submitticket">
    <div class="div-in-article"  >
					<table class="table table-striped" style="width:70%;margin-top:15px;">
						<thead style="font-size: 20px;" >
						    <tr >
						      <th scope="col" style="width:30%;padding:.4rem;">出發機場</th>
						      <th scope="col" style="width:30%;padding:.4rem;">抵達機場</th>
						      <th scope="col" style="width:20%;padding:.4rem;">改動百分比</th>
						      <th scope="col" style="width:20%;padding:.4rem;">加價價格</th>
						    </tr>
						  </thead>
					 <tbody id="information1" >
  						 <c:forEach var="oldprice" items="${oldprice}">
  							<tr>
  							<td>${oldprice.departure}</td>
  							<td>${oldprice.destination}</td>
  							<td>${oldprice.addpercent}</td>
  							<td>${oldprice.addprice}</td>
  							</tr>
  						</c:forEach>
  					
						</tbody>
					</table>
				</div>
  </div>  
  </form:form> 


</div>
</body>
</html>