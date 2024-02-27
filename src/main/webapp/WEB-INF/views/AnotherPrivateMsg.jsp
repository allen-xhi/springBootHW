<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>WebSocket Test</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<script src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<link href="https://fonts.googleapis.com/css?family=Libre+Barcode+128+Text" rel="stylesheet">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/Websocket.js"></script>
<link rel='stylesheet' href='${pageContext.request.contextPath}/CSS/dia.css' type="text/css" />
<link rel='stylesheet' href='${pageContext.request.contextPath}/CSS/dialog.css' type="text/css" />
<script>

//暫定會員名 
var member=sessionStorage.getItem("lastname");
var unread=0;

$(document).ready(function() {
//寫死，會員資料
var booleanarr=[true,true,true];
var namearr=["mario","Water","emily"]; 
var mailboxname=[];
var IMG=[1,2,3];
var mix=namearr;

//寫死BOOLEAN，控制視窗開關
var mixboolean=new Boolean();
for(var i=0;i<100;i++){
mixboolean[i]=true;
}


	//1.以點選圖片方式 與XX對象私聊
	for(var p=0;p<3;p++){
	$("img.img"+p).click(function(){
	var num = this.getAttribute("class").substr(3);
	var end = p;
	chatwindow(num);
	});
	};
	
	
//讀取會員未讀訊息數
getunread(member);	
	function getunread() {
		var myUrl = "${pageContext.request.contextPath}/getunread?memberid="+member;
	    $.ajax({
	        type: 'get',
	        url: myUrl,
	        success: function(data){
	        var Unread =data;
			for(i in Unread){
			$("#person").text(Unread[i].count);
				}
	        }, 
	        error: function() {}
	    });	
	}
	
	
//點擊 提醒訊息 (黃底藍字數字) 開關信箱
	$("#person").click(function(){
	$(".NewMs").toggle('size',150);
	ShowUnread();
	});
	
		//建立信箱視窗
		function ShowUnread(){
		var myUrl = "${pageContext.request.contextPath}/getNotice?memberid="+member;
	    $.ajax({
	        type: 'get',
	        url: myUrl,
	        success: function(data){
	        	var Sender =data;
				var mailbox ="";
				for(i in Sender){
					mailbox+='<div class="NewMs" id="NewMs'+i+'">'+
					'<div class="MSnumber" id="MSnumber'+i+'" style="border:2px #D68B00 solid;padding:10px;">'+
					Sender[i].UnreadName+'</div>'+
					'<div class="count" id="count'+i+'" style="border:2px">'+Sender[i].counts+'</div>'+'</div>';
					mailboxname[i]=Sender[i].UnreadName;
				}
					$("#Onoff").html(mailbox);
					Paramfilter();
					//點擊聯絡人名單
				$("#friend").click(function(){
					$("#Onoff").toggle();
				});
				

	   		//2.點選信箱聯絡人名單，與XX對象私聊
				$(".NewMs").click(function(){
					var num = this.getAttribute("id").substr(5);
					Number(num);
					var number = new Number(num)
					number+=(namearr.length);
					//呼叫建立聊天視窗 chatwindow();
					chatwindow(number);	
				});
	        						}, 
	        	error: function() {   
	        	}
	    	});	
		};


		
	//圖片ID與信箱ID整合成一陣列
	function Paramfilter(){
	mix=namearr.concat(mailboxname);
	}

	//建立聊天視窗方法，起始括弧
	function chatwindow(end) {
	var i = end;
	var memberA=mix[i];
	if(mixboolean[i]){
	//}
	//(縮小)聊天列:命名toAccountid(收訊人)
	var div = document.getElementById("Namelist");
	var div2 = document.createElement("div");
	div2.setAttribute('class','Namezoom');
    div2.setAttribute('id', memberA);
    

	//(縮小聊天列):放關閉圖片(X)
	var Xbutton = document.createElement("img");
    Xbutton.src="${pageContext.request.contextPath}/images/close.png";
   Xbutton.setAttribute("class", "Xbutton");
   Xbutton.setAttribute("id","Xbutton"+i);
	Xbutton.setAttribute( "onClick","event.cancelBubble = true")
	
  		//(縮小)聊天列點擊後再讀取 視窗HTML
          var inputform='<!--對話欄:最外層DIV -->'+'<div class="div6" id="div6'+i+'"><!--對話欄:屋頂--><div class="header">'
          +'<div style="text-align: center;">'+'<h1 style="margin-top: 0px" style="color:#f7f1e3;">'+memberA+'</h1>'
          +'</div>'+'</div>'+'<div class="div7" id="div7'+i+'"">'+'<div id="messageDisplay'+i+'"+style="height: auto; width: 97%; float: right; margin-right: 6px;"></div>'
          +'</div>'+'<!-- Input欄位-->'+'<div class="enter'+i+'"+ style="clear: both; border: 1px solid #18dcff;">'
          +'<form id="chatRoomForm'+i+'"+ onsubmit="return false;">'+'  <input type="hidden" id="roomName'+i+'" size="10" maxlength="100" ><br>'
          +'</br> <input type="hidden" type="text" id="userNameInput'+i+'"/>'+'</br><input type="hidden" type="button"id="loginBtn'+i+'" value="登入" /> '
          +'<span id="infoWindow'+i+'"></span> '+'<input type="text" id="userinput'+i+'" /> <input id="send'+i+'"  type="submit" value="送出訊息" />'
          +'</form>'+'</div>'+'</div>'+'<!-- 置底名稱欄位-->'+'</div>';
			
          
			
			div.appendChild(div2);
			$("#"+memberA).text(memberA);
			$("#"+memberA).show();
		//先讀取inputform進BODY
			$("body").append(inputform);
		//先選取inputform的div6
			var chatroomNo =document.getElementById("div6"+i);
			var chatwin = document.getElementById("chatwindow");
			chatwin.append(chatroomNo);

			
			
			$("#"+memberA).append(Xbutton);
			loadWebSocket(i);//讀取JS檔案 呼叫方法
			window.onload = function(){
			var buildwebsocket = init;}
			
			
			
//儲存對話至SQL
			$("#send"+i).click(function() {
			    var myUrl = "${pageContext.request.contextPath}/addPrivateMsg?sentence=" + $("#userinput"+i).val()+"&name="+
			    $('#userNameInput'+i).val()+"&roomname="+$("#roomName"+i).val()+"&toaccountid="+$("#"+memberA).text()+"&isreadornot="+0;
			    $.ajax({
			        type: 'get',
			        url: myUrl,
			        success: function(data){
			        }, 
			        error: function() {    
			        }
			    });
			});
			
//讀取聊天室編號
			$("#"+memberA).click(function() {
			    var myUrl = "${pageContext.request.contextPath}/getroom?toaccountid="+$("#"+memberA).text()+"&accountid="+member;
			    $.ajax({
			        type: 'get',
			        url: myUrl,
			        success: function(data){
			        //使用舊有ID
			        $("#roomName"+i).val(data);
			        }, 
			        error: function() {   
			        //新建聊天室ID
			        //*瀏覽器會發出錯誤訊息
			        var roomname=Math.floor(Math.random()*10000000000)+1;
			        $("#roomName"+i).val(roomname);
					
			        }
			    });
			});
					
//對話紀錄讀取
			$("#"+memberA).click(function() {
			    var myUrl = "${pageContext.request.contextPath}/getrecord?toaccountid="+$("#"+memberA).text()+"&accountid="+member;
			    $.ajax({
			        type: 'POST',
			        url: myUrl,
			        success: function(data){
					var result =data;
						var record ="";
					//迴圈後再放對話框
			        	for(a in result){
			        //對方輸入
			        	if(result[a].toaccountid==$("#"+memberA).text()){
			        	record+=('<br>'+'<div class="toolboxA" style=text-align:left;>' +  result[a].sentence+'</div>');
			        //本人輸入
			        	}else{
			        	record+=('<br>'+'<div class="toolboxB" maign="right" style=text-align:right;>' + result[a].sentence+'</div>');
			        	 };
			        //顯示對話紀錄
			        	 $("#messageDisplay"+i).html(record);
			        	
			        	}
						 }, 
						 
			        error: function() {    
			        }
			    });
			});
			
//縮放聊天室
			$("#"+memberA).click(function(){
				$("#div6"+i).toggle('size',150);
				$("#userNameInput"+i).val(member);
				});
			
//點擊更改未讀訊息
			$("#"+memberA).click(function() {
			
			    $.ajax({
			        type: 'POST',
			        url: "${pageContext.request.contextPath}/Readed?toaccountid="+$("#"+memberA).text()+"&accountid="+member,
			       success: function(data){
						 }, 
			        error: function() {    
			        }
			    });
			});
					
//控制視窗的BOOLEAN改成
			for(var a=0;a<mix.length;a++){
			if(mix[a]==memberA)
			mixboolean[a]=false;
			};
			
			$("#Xbutton"+i).click(function(){
				$("#"+memberA).remove();
				$("#div6"+i).hide();
			for(var a=0;a<mix.length;a++){
				if(mix[a]==memberA)
				mixboolean[a]=true;
				}
			});
		};	//建立視窗結束括弧
				
	};
});
</script>
</head>


<body>
	<!--其它使用者頭像(暫定) -->
	<img class="img0" src="${pageContext.request.contextPath}/images/member.jpg">
	<img class="img1" src="${pageContext.request.contextPath}/images/cccat.jpg">
	<img class="img2" src="${pageContext.request.contextPath}/images/cat.jpg">
	
	
	<h1 id='unread'></h1>



<div id="Notice" style="width:100%; background-size:cover;background-position:center;position:relative;"> 
<span id="person" class="toolboxB" style="position:absolute;color:#3742fa;font-weight:800;font-size:25px;top:20%;left:93%;transform: translate(-64%, -74%);z-index:1000;"></span>
<img id="friend" class="MyMessage"  src="${pageContext.request.contextPath}/images/er.png" style="display:block;max-width:100%;float:right; margin:0 auto;" >
<div id="Onoff"></div>
</div>





<div class="chatwindow" id="chatwindow"></div>
	<div class="Namelist" id="Namelist">	
	</div>
	
</body>
</html>