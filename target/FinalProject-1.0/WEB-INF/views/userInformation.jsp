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
<script src='http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.5/jquery-ui.min.js'></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/Websocket.js"></script>

<link rel='stylesheet' href='${pageContext.request.contextPath}/CSS/Project.css' type="text/css" />
<link rel='stylesheet' href='${pageContext.request.contextPath}/CSS/dia.css' type="text/css" />
<link rel='stylesheet' href='${pageContext.request.contextPath}/CSS/dialog.css' type="text/css" /> 

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
	//暫定會員名 
	sessionStorage.setItem("lastname", "${memberBean.memberName}");
	var member = "${memberBean.memberName}";
	
	var unread = 0;
	
	var mixboolean=new Boolean();
	for(var i=0;i<100;i++){
		mixboolean[i]=true;
	}
	//JSON.length()
	var booleanarr=[];
	//memberName
	var namearr=[]; 
	//UNREAD才載入
	var mailboxname=[];
	
	var mix=namearr;
	
// 	window.onload = function(){
// 		var buildwebsocket = init;
// 	}
///////////////////////////////////////////////////////////////////////////////////////////////////
	$(document).ready(function() {
		
		
/////////////////////////////////////////////////////////////////////////////////////////////////
		// 確認登入狀態
		var loginStatus = "${loginStatus}";
		 if(loginStatus=='true'&& ${memberBean.memberName!=""}){
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
		// 更新個人資料
		$("#saveChange").click(function(){
			$.ajax({
				url:"${pageContext.request.contextPath}/needLogin/updateUserInformation",
				type:"post",
				dataType:"text",
				data:{name:$(".content-div1").eq(0).val()
					,lastName:$(".content-div1").eq(1).val()
					,firstName:$(".content-div1").eq(2).val()
					,birth:$(".content-div1").eq(3).val()
					,gender:$(".content-div1").eq(4).val()
					,phone:$(".content-div1").eq(6).val()
					,password:$(".content-div1").eq(7).val()
					,introduction:$(".content-div1").eq(8).val()},
				success:function(data){
					location.href = "${pageContext.request.contextPath}/"+data;
				},error:function(){
// 					alert($(".content-div1").eq(0).text());
					console.log("error");
				}
			})
		});
//////////////////////////////////////////////////////////////////////////////////////	
		// 報名中的行程 同行旅伴
		$(".page4").click(function(){
			$.ajax({ 
				url:"${pageContext.request.contextPath}/getApplication/"+this.id,
				type:"get",
				dataType:"text",
				success:function(data){
					console.log("success");
					var json = JSON.parse(data);
					var information2 = $("#information2");
					information2.html("");
					for(var i=0;i<json.length;i++){
						var tr;
						var td1 = $("<td></td>");
						var td2	= $("<td>");
						var td3 = $("<td>");
						var td4 = $("<td>");
						var text;
						var buyTicket = json[i].buyTicket;
						if(buyTicket==0) {text="未確認";}
						else if(buyTicket==1){ text="已購買";}
						
						if(json[i].memberBean.id=="${memberBean.id}"){	// 當前使用者
							
							tr = $("<tr style='background-color:#74b9ff'></tr>");
							td2.attr("style","padding:0px;")
							td2.html("<Button type='button' class='btn btn-success' onclick='buyTicket(1,"+json[i].appId+");'>已購買</Button>"
									+"<Button type='button' class='btn btn-warning' onclick='buyTicket(0,"+json[i].appId+");'>未確認</Button>");
							var str = "${pageContext.request.contextPath}/planeticketsearch/"+json[i].needBean.needId;
							td3 = $("<td style='padding:2px;'>").html("<a href='"+str+"' class='btn btn-info btn-sm' id='buyTicket'><span class='glyphicon glyphicon-plane'></span> PlaneTicket</a>");
						}else{	// 非當前使用者
							tr = $("<tr>");
							var buyTicket = json[i].buyTicket;
							td2.text(text);
// 							td4.append("<button class='chatButton' id='chat"+i+"'>私訊</button>");
							td4.append("<i class='far fa-comment-dots chatButton' style='cursor:pointer;' id='chat"+i+"'></i>");
							booleanarr[i]=true;
							namearr[i]=json[i].memberBean.memberName;
						}
						var a = $("<a href='${pageContext.request.contextPath}/needLogin/showOtherDetailInfo/"+json[i].memberBean.id+"' target='_blank'>"+json[i].memberBean.memberName+"</a>");
						td1.append(a);
						tr.append(td1,td2,td3,td4);
						information2.append(tr); 
// 						$("#buyTicket").click(butTicket);
					}
					privatemsg();
				},error:function(){
					console.log("error");
				}
		});
	});
//////////////////////////////////////////////////////////////////////////////////////		
		// 參加過的行程 同行旅伴
		$(".page3").click(function(){
		    var thisid = this.id;
			$.ajax({ 
				url:"${pageContext.request.contextPath}/getApplication/"+this.id,
				type:"get",
				dataType:"text",
				success:function(data){
					console.log("success");
					var json = JSON.parse(data);
// 					alert(json[0])
					var information1 = $("#information1");
					information1.html("");
// 					alert(json.length)
					for(var i=0;i<json.length;i++){
						var tr;
						var tr2 = $("<tr>");
						var td1 = $("<td>");
						var td2	= $("<td>");
						var td3 = $("<td>");
						var td4 = $("<td>");
						var text;
						
						if(json[i].memberBean.id=="${memberBean.id}"){	// 當前使用者
							tr = $("<tr style='background-color:#74b9ff'></tr>");
							td2.attr("style","padding:0px;")				
							var str = "${pageContext.request.contextPath}/planeticketsearch/"+json[i].needBean.needId;
							
						}else{	// 非當前使用者
							tr = $("<tr>");
							var buyTicket = json[i].buyTicket;
							td2.text(text);
							td3.append("<button id='starmem"+json[i].memberBean.id+"' onclick='memcommentClick("+json[i].memberBean.id+")'>評價</button>");
// 							td4.append("<button class='chatButton' id='chat"+i+"'>私訊</button>");
							td4.append("<i class='far fa-comment-dots chatButton' style='cursor:pointer;' id='chat"+i+"'></i>");
							
							booleanarr[i]=true;
							namearr[i]=json[i].memberBean.memberName;
						}
						var a = $("<a id='chatname'"+json[i].memberBean.id +" href='${pageContext.request.contextPath}/needLogin/showOtherDetailInfo/"+json[i].memberBean.id+"' target='_blank'>"+json[i].memberBean.memberName+"</a>");
						td1.append(a);
						tr.append(td1,td3,td4);
						td3.attr("id",json[i].memberBean.id+"8");
						tr2.attr("id",json[i].memberBean.id+"2");
						information1.append(tr,tr2); 
// 						
						
					}
						privatemsg();
					
				},error:function(){
					console.log("error");
				}
		});
	});
//////////////////////////////////////////////////////////////////////////////////////
		
	});
//////////////////////////////////////////////////////////////////////////////////////	
	function buyTicket(num,appId){
		$.ajax({
			url:"${pageContext.request.contextPath}/needLogin/updateApplication",
			type:"post",
			data:{option:num,id:appId},
			dataType:"text",
			success:function(){
				console.log("success");
			},error:function(){
				console.log("error");
			}  
		});
	}
////////////////////////////////////////////////////////////////////////////////////////////////////
function commentClick(needId,tripId){
						var tripcomment = $("#"+needId+"1")
						tripcomment.html("");
	                    tripcomment.css({"background-color":"#74b9ff"})
	                    var tdstar = $("<td>")
	                    var stars1 = $("<a>")
	                    stars1.attr("href","javascript:click(1)");
	                    stars1.html("<img src='${pageContext.request.contextPath}/images/star.png' id='star1' onMouseOver='over(1)' onMouseOut='out(1)' class='s'/>");
	                    var stars2 = $("<a>")
	                    stars2.attr("href","javascript:click(2)");
	                    stars2.html("<img src='${pageContext.request.contextPath}/images/star.png' id='star2' onMouseOver='over(2)' onMouseOut='out(2)' class='s'/>");
	                    var stars3 = $("<a>")
	                    stars3.attr("href","javascript:click(3)");
	                    stars3.html("<img src='${pageContext.request.contextPath}/images/star.png' id='star3' onMouseOver='over(3)' onMouseOut='out(3)' class='s'/>");
	                    var stars4 = $("<a>")
	                    stars4.attr("href","javascript:click(4)");
	                    stars4.html("<img src='${pageContext.request.contextPath}/images/star.png' id='star4' onMouseOver='over(4)' onMouseOut='out(4)' class='s'/>");
	                    var stars5 = $("<a>")
	                    stars5.attr("href","javascript:click(5)");
	                    stars5.html("<img src='${pageContext.request.contextPath}/images/star.png' id='star5' onMouseOver='over(5)' onMouseOut='out(5)' class='s'/>");
	                   /*;*/
	                    
	            		tdstar.append(stars1);
	            		tdstar.append(stars2);
	            		tdstar.append(stars3);
	            		tdstar.append(stars4);
	            		tdstar.append(stars5);
	            		tdstar.append("<input type='hidden' id='starnum123'/>")
	            			            		
	            		var tripcomString1 = $("<td colspan='4'>")
	            		
	            		var tripcombutton = $("<td>")   
	            		tripcombutton.html("<Button id='${finishApp}' type='button' class='btn btn-success' onclick='sendcomment("+tripId+","+needId+");'>送出</Button>");
	            		tripcomString1.html("<input id='comment' style='width:90%'type='text'/>");
	            		tripcomment.append(tdstar,tripcomString1,tripcombutton)
							
	}
	
	function memcommentClick(memberId){
		var memcom = $("#"+memberId+"2")
		memcom.html("");
        var tdstar = $("<td>")
        var stars1 = $("<a>")
        stars1.attr("href","javascript:click(1,"+memberId+")");
        stars1.html("<img src='${pageContext.request.contextPath}/images/star.png' id='"+memberId+"star1' onMouseOver='over(1,"+memberId+")' onMouseOut='out(1,"+memberId+")' class='s'/>");
        var stars2 = $("<a>")
        stars2.attr("href","javascript:click(2,"+memberId+")");
        stars2.html("<img src='${pageContext.request.contextPath}/images/star.png' id='"+memberId+"star2' onMouseOver='over(2,"+memberId+")' onMouseOut='out(2,"+memberId+")' class='s'/>");
        var stars3 = $("<a>")
        stars3.attr("href","javascript:click(3,"+memberId+")");
        stars3.html("<img src='${pageContext.request.contextPath}/images/star.png' id='"+memberId+"star3' onMouseOver='over(3,"+memberId+")' onMouseOut='out(3,"+memberId+")' class='s'/>");
        var stars4 = $("<a>")
        stars4.attr("href","javascript:click(4,"+memberId+")");
        stars4.html("<img src='${pageContext.request.contextPath}/images/star.png' id='"+memberId+"star4' onMouseOver='over(4,"+memberId+")' onMouseOut='out(4,"+memberId+")' class='s'/>");
        var stars5 = $("<a>")
        stars5.attr("href","javascript:click(5,"+memberId+")");
        stars5.html("<img src='${pageContext.request.contextPath}/images/star.png' id='"+memberId+"star5' onMouseOver='over(5,"+memberId+")' onMouseOut='out(5,"+memberId+")' class='s'/>");
       /*;*/
        
		tdstar.append(stars1);
		tdstar.append(stars2);
		tdstar.append(stars3);
		tdstar.append(stars4);
		tdstar.append(stars5);
		tdstar.append("<input type='hidden' id='"+memberId+"starnum123'/>")
			            		
		var memcomString1 = $("<td colspan='1'>")
		
		var memcombutton = $("<td>")   
		memcombutton.html("<Button id='"+memberId+"3' type='button' class='btn btn-success' onclick='sendmemcomment("+memberId+");'>送出</Button>");
		memcomString1.html("<input id='"+memberId+"memcomment' style='width:90%'type='text'/>");
		memcom.append(tdstar,memcomString1,memcombutton)
			
	}
	
	
	function over(param,memberId){
		if(param == 1){
			$("#"+memberId+"star1").attr("class","n");
			$("#"+memberId+"star2").attr("class","s");
			$("#"+memberId+"star3").attr("class","s");
			$("#"+memberId+"star4").attr("class","s");
			$("#"+memberId+"star5").attr("class","s");
			$("#"+memberId+"starnum123").val("1");//设置提示语，下面以此类推
		}else if(param == 2){
			$("#"+memberId+"star1").attr("class","n");
			$("#"+memberId+"star2").attr("class","n");
			$("#"+memberId+"star3").attr("class","s");
			$("#"+memberId+"star4").attr("class","s");
			$("#"+memberId+"star5").attr("class","s");
			$("#"+memberId+"starnum123").val("2");
		}else if(param == 3){
			$("#"+memberId+"star1").attr("class","n");
			$("#"+memberId+"star2").attr("class","n");
			$("#"+memberId+"star3").attr("class","n");
			$("#"+memberId+"star4").attr("class","s");
			$("#"+memberId+"star5").attr("class","s");
			$("#"+memberId+"starnum123").val("3");
		}else if(param == 4){
			$("#"+memberId+"star1").attr("class","n");
			$("#"+memberId+"star2").attr("class","n");
			$("#"+memberId+"star3").attr("class","n");
			$("#"+memberId+"star4").attr("class","n");
			$("#"+memberId+"star5").attr("class","s");
			$("#"+memberId+"starnum123").val("4");
		}else if(param == 5){
			$("#"+memberId+"star1").attr("class","n");
			$("#"+memberId+"star2").attr("class","n");
			$("#"+memberId+"star3").attr("class","n");
			$("#"+memberId+"star4").attr("class","n");
			$("#"+memberId+"star5").attr("class","n");
			$("#"+memberId+"starnum123").val("5");
		}
	}

	function out(check,memberId){
		if(check == 1){
			$("#"+memberId+"star1").attr("class","n");
			$("#"+memberId+"star2").attr("class","s");
			$("#"+memberId+"star3").attr("class","s");
			$("#"+memberId+"star4").attr("class","s");
			$("#"+memberId+"star5").attr("class","s");
			$("#"+memberId+"starnum123").val("1");
		}else if(check == 2){
			$("#"+memberId+"star1").attr("class","n");
			$("#"+memberId+"star2").attr("class","n");
			$("#"+memberId+"star3").attr("class","s");
			$("#"+memberId+"star4").attr("class","s");
			$("#"+memberId+"star5").attr("class","s");
			$("#"+memberId+"starnum123").val("2");
		}else if(check == 3){
			$("#"+memberId+"star1").attr("class","n");
			$("#"+memberId+"star2").attr("class","n");
			$("#"+memberId+"star3").attr("class","n");
			$("#"+memberId+"star4").attr("class","s");
			$("#"+memberId+"star5").attr("class","s");
			$("#"+memberId+"starnum123").val("3");
		}else if(check == 4){
			$("#"+memberId+"star1").attr("class","n");
			$("#"+memberId+"star2").attr("class","n");
			$("#"+memberId+"star3").attr("class","n");
			$("#"+memberId+"star4").attr("class","n");
			$("#"+memberId+"star5").attr("class","s");
			$("#"+memberId+"starnum123").val("4");
		}else if(check == 5){
			$("#"+memberId+"star1").attr("class","n");
			$("#"+memberId+"star2").attr("class","n");
			$("#"+memberId+"star3").attr("class","n");
			$("#"+memberId+"star4").attr("class","n");
			$("#"+memberId+"star5").attr("class","n");
			$("#"+memberId+"starnum123").val("5")
		}else if(check == 0){
			$("#"+memberId+"star1").attr("class","s");
			$("#"+memberId+"star2").attr("class","s");
			$("#"+memberId+"star3").attr("class","s");
			$("#"+memberId+"star4").attr("class","s");
			$("#"+memberId+"star5").attr("class","s");
			$("#"+memberId+"starnum123").val("0");
		} 
	}

	function click(param,memberId){
		check = param;
		out(check,memberId);
	}
	function sendcomment(tripId,needId){
		var tripStarNum = $("#starnum123").val();
		var tripcoment = $("#comment").val();
		var needId = needId;
		 $.ajax({
					url:"${pageContext.request.contextPath}/tripcomment",
					type:"post",
					data:{trip:tripId,tripStarNum:tripStarNum,tripcoment:tripcoment},
					dataType:"text",
					success:function(data){	
						$("#"+needId+"1").html("");
						$("#"+needId+"2").html(data+"&nbsp;&nbsp;&nbsp;&nbsp;"+"<img src='${pageContext.request.contextPath}/images/star.png' class='n' style='width:15px;height:15px'/>")			
					}
				});
	}
	function sendmemcomment(memberID){
		var memStarNum = $("#"+memberID+"starnum123").val();
		var memcoment = $("#"+memberID+"memcomment").val();
		var memberID = memberID;
		 $.ajax({
				url:"${pageContext.request.contextPath}/memcomment123",
				type:"post",
				data:{memberID:memberID,memStarNum:memStarNum,memcoment:memcoment},
				dataType:"text",
				success:function(data){	
					$("#"+memberID+"2").html("");
					$("#"+memberID+"8").html(data+"&nbsp;&nbsp;&nbsp;&nbsp;"+"<img src='${pageContext.request.contextPath}/images/star.png' class='n' style='width:15px;height:15px'/>")			
				}
				});
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	function getunread() {
// 		alert("member:" + member)
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
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				//建立信箱視窗
				function ShowUnread(){
// 					alert("member:" + member)
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
							Paramfilter();//*1
							
							
							//點擊聯絡人名單，getread()寫這
						$("#friend").click(function(){
							$("#Onoff").toggle();
							
						});
						

			   		//點選信箱聯絡人名單，與XX對象私聊
						$(".NewMs").click(function(){
							var num = this.getAttribute("id").substr(5);
							
							Number(num);
							var number = new Number(num)
							number+=(namearr.length);
							//*2 信箱加上name陣列長度後 呼叫建立聊天視窗 chatwindow();
							chatwindow(number);	
						});
			        						}, 
			        	error: function() {   
			        	}
			    	});	
				};
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//*1圖片ID與信箱ID整合成一陣列
			function Paramfilter(){
// 				alert("member:" + member)
			mix=namearr.concat(mailboxname);
			}
			
////////////////////////////////////////////////////////////////////////////////////////////////////////////////			
			//*2建立聊天視窗方法，起始括弧
			function chatwindow(end) {
// 				alert("member:" + member)
			var i = end;
			
			var memberA = mix[i];

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
		          +'<div style="text-align: center;color:white;">'+'<h1 style="margin-top: 0px" style="color:#f7f1e3;">'+memberA+'</h1>'
		          +'</div>'+'</div>'+'<div class="div7" id="div7'+i+'"">'+'<div id="messageDisplay'+i+'"+style="height: auto; width: 97%; float: right; margin-right: 6px;"></div>'
		          +'</div>'+'<!-- Input欄位-->'+'<div class="enter'+i+'"+ style="clear: both; ">'
		          +'<form id="chatRoomForm'+i+'"+ onsubmit="return false;">'+'  <input type="hidden" id="roomName'+i+'" size="10" maxlength="100" ><br>'
		          +'</br> <input type="hidden" type="text" id="userNameInput'+i+'"/>'+'</br><input type="hidden" type="button"id="loginBtn'+i+'" value="登入" /> '
		          +'<span id="infoWindow'+i+'"></span> '+'<input type="text" id="userinput'+i+'" style="width:100%;" /> <input id="send'+i+'"  type="submit" value="送出訊息" />'
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
						$("#div6"+i).toggle();
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
			}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
function privatemsg(){
	//寫死BOOLEAN，控制視窗開關

		//全部按鈕建立事件在這
			//1.以點選圖片方式 與XX對象私聊
			//建立視窗
			
			$(".chatButton").click(function(){
				var id = this.id.substring(4);
				chatwindow(id);//*2
			});
		//讀取會員未讀訊息數
		getunread(member);	
			
			
		//點擊 提醒訊息 (黃底藍字數字) 開關信箱
			$("#person").click(function(){
				$(".NewMs").toggle();
				ShowUnread();
			});
		};
	
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
 	overflow: overlay; 
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
.content-div1 {
	flex: 0 0 50%;
	max-width: 50%;
	padding: 10px;
	margin: 5px;
	border-radius: 5px;
	border: 1px solid pink;
	cursor:pointer;
	outline-style: none;
}

.content-special{
	flex: 0 0 124%;
	max-width: 124%;
}
.content-div1:focus{
	border: 1px solid orange;
}
.content-div:hover {
	background-color: #f0932b;
}

.custom-table,th{
	text-align: center;
	text-decoration: none;
	box-sizing: border-box;
} 
.page4,li{
	cursor: pointer;
}
.user-tr{
	background-color: #74b9ff;
}
.plane-div-row{
	padding:8px;
	display:flex;
	background-color:white;
	width:100%;
}
.plane-div-row1{
	padding:8px;
	display:flex;
	background-color:#95a5a6;
	
	width:100%;
}
.plane-span{
	text-align: center;
	height:100%;
	line-height:30px;
}
  .s {
          -webkit-filter: grayscale(1);  /*沒有任何色彩的黑白影像*/
          width:20px;
          height:20px;
    }
   .n {
       -webkit-filter: grayscale(0);  /*顏色不變*/
        width:20px;
       height:20px;
   }

.chatButton{
	font-size:18px;
	color:#f0932b;
}
</style>
</head>
<body>
			<header>
			<div style="height:auto position:fixed; ;z-index:999999;background: radial-gradient(#F5DEB3,#D2B48C,#AAAAAA);">
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
					<div class="row" style="display: flex;">

						<a href="${pageContext.request.contextPath}/planeticketsearch" style="color: #8B4513; width: 20%; text-align: center;font-family:微軟正黑體;font-size: 20px;font-weight: bold;text-decoration:none" id=g1><i>機票搜尋</i> </a> 
						
						<a href="${pageContext.request.contextPath}/customerpackage" style="color:  #8B4513; width: 20%; text-align: center;font-family:微軟正黑體;font-size: 20px;font-weight: bold;text-decoration:none" id=g2><i>套裝行程</i></a>

						<a href="${pageContext.request.contextPath}/" style="color:  #8B4513; width: 20%; text-align: center;font-family:微軟正黑體;font-size: 20px;font-weight: bold;text-decoration:none" id=g3><i>自訂行程</i></a>

						<a href="${pageContext.request.contextPath}/GetTogether" style="color:  #8B4513; width: 20%; text-align: center;font-family:微軟正黑體;font-size: 20px;font-weight: bold;text-decoration:none" id=g4><i>尋找出團</i></a>

						<a href="${pageContext.request.contextPath}/scenery" style="color:  #8B4513; width: 20%; text-align: center;font-family:微軟正黑體;font-size: 20px;font-weight: bold;text-decoration:none" id=g5><i>熱門景點</i></a>
					</div>

				</div>

			</div>
		</header>
		<div class="full-div">
			<ul class="side">
				<li>個人資訊</li>
				<li>修改個人資訊</li>
				<li>參加過的行程</li>
				<li>報名中的行程</li>
				<li>訂票紀錄</li>
			</ul>
			<article class="page-div">
				<h1>個人資訊</h1>
				<fieldset>
					<div class="div-row">
						<div class="title-div">暱稱</div>
						<div class="content-div">${memberBean.memberName}</div>
					</div>
					<div class="div-row">
						<div class="title-div">姓氏</div>
						<div class="content-div">${memberBean.lastName}</div>
					</div>
					<div class="div-row">
						<div class="title-div">名字</div>
						<div class="content-div">${memberBean.firstName}</div>
					</div>
					<div class="div-row">
						<div class="title-div">生日</div>
						<div class="content-div">${memberBean.birth}</div>
					</div>
					<div class="div-row">
						<div class="title-div">性別</div>
						<div class="content-div">${memberBean.gender==1?'Male':'Female'}</div>
						<div class="title-div">電子郵件</div>
						<div class="content-div">${memberBean.email}</div>
					</div>
					<div class="div-row">
						<div class="title-div">電話</div>
						<div class="content-div">${memberBean.phone}</div>
						<div class="title-div">密碼</div>
						<div class="content-div">
							<c:forEach begin="1" end="${memberBean.password.length()}">*</c:forEach>
						</div>
					</div>
					<div class="div-row">
						<div class="title-div">自我介紹</div>
						<div class="content-div content-special" style="">${memberBean.introduction}</div>
					</div>
					
				</fieldset>
			</article>
			<article class="page-div-hide">
				<h1>修改個人資訊</h1>
				<fieldset>
					<div class="div-row">
						<div class="title-div">暱稱</div>
						<input class="content-div1" type="text" value="${memberBean.memberName}">
					</div>
					<div class="div-row">
						<div class="title-div">姓氏</div>
						<input class="content-div1" type="text" value="${memberBean.lastName}">
					</div>
					<div class="div-row">
						<div class="title-div">名字</div>
						<input class="content-div1" type="text" value="${memberBean.firstName}">
					</div>
					<div class="div-row">
						<div class="title-div">生日</div>
						<input class="content-div1" style="padding:9px 10px;" type="date" value="${memberBean.birth}">
					</div>
					<div class="div-row">
						<div class="title-div">性別</div>
						<select class="content-div1" style="padding:8.8px 10px;">
							<c:if test="${memberBean.gender==1}">
								<option value="1" selected>Male</option>
								<option value="0">Female</option>
							</c:if>
							<c:if test="${memberBean.gender==0}">
								<option value="1" >Male</option>
								<option value="0" selected>Female</option>
							</c:if>
						</select>
						<div class="title-div">電子郵件</div>
						<div class="content-div1">${memberBean.email}</div> 
					</div>
					<div class="div-row">
						<div class="title-div">電話</div>
						<input class="content-div1" type="text" value="${memberBean.phone}">
						<div class="title-div">密碼</div>
						<input class="content-div1" type="password" value="${memberBean.password}">
					</div>
					<div class="div-row">
						<div class="title-div">自我介紹</div> 
						<input class="content-div1 content-special" value="${memberBean.introduction}">
					</div>
					<div class="div-row">
						<button type="button" class="btn content-div btn-success" id="saveChange">儲存</button> 
					</div>
					
				</fieldset>
			</article>
			<article class="page-div-hide">
				<div class="div-in-article">
					<h1>參加過的行程</h1>
					<table class="table table-dark custom-table">
						<thead>
						    <tr>
						      <th scope="col" style="width:20%">名稱</th>
						      <th scope="col" style="width:20%">出發時間</th>
						      <th scope="col" style="width:15%">人數</th>
						      <th scope="col" style="width:15%">評價</th>
						      <th scope="col" style="width:10%">天數</th>
						      <th scope="col" style="width:15%">預算</th>
						      <th scope="col" style="width:15%">#</th>
						    </tr>
						  </thead>
						 <tbody>
						 	
					<c:forEach var="finishApp" items="${userMap.finishList}">
						<tr id="${finishApp.needBean.needId}">
					      <td>${finishApp.needBean.tripBean.tripname}</td>
					      <td>${finishApp.needBean.departureTime}</td>
					      <td>${finishApp.needBean.requiredPeople}</td>
					      <td id="${finishApp.needBean.needId}2" scope="col" style="width:15%"><button onclick="commentClick('${finishApp.needBean.needId}','${finishApp.needBean.tripBean.tripId}');">評價</button></td>
					      <td>${finishApp.needBean.tripBean.tripdays}</td>
					      <td>${finishApp.needBean.budget}</td>
					      <td class="page3" id="${finishApp.needBean.needId}"><i class="fas fa-caret-down"></i></td>
					    </tr>
					    <tr id="${finishApp.needBean.needId}1"></tr>
					</c:forEach>
							
						</tbody>
					</table>
				</div>
				<div class="div-in-article">
					<h1>同行旅伴</h1>
					<table class="table table-dark custom-table">
						<thead>
						    <tr>
						      <th scope="col" style="width:25%">暱稱</th>
						      <th scope="col" style="width:20%">評價</th>
						      <th scope="col" style="width:20%">私訊</th>
						    </tr>
						  </thead>
					 <tbody id="information1">
					<c:forEach var="finishNeed" items="${userMap.finishList}">
						<tr>
					    </tr>
					</c:forEach>
						</tbody>
					</table>
				</div>
			</article>
			<article class="page-div-hide">
				<div class="div-in-article" id="page4">
					<h1>報名中的行程</h1>
					<table class="table table-dark table-striped custom-table">
						<thead>
						    <tr>
						      <th scope="col" style="width:20%">名稱</th>
						      <th scope="col" style="width:20%">截止日期</th>
						      <th scope="col" style="width:20%">出發時間</th>
						      <th scope="col" style="width:10%">預算</th>
						      <th scope="col" style="width:10%">人數</th>
						      <th scope="col" style="width:10%">天數</th>
						      <th scope="col" style="width:10%">資訊</th> 
						    </tr>
						  </thead>
						 
					 <tbody>
				 		
					<c:forEach var="payApp" items="${userMap.payList}" varStatus="status">
						<tr style="background-color: #ff7675">
					      <td><a href="${pageContext.request.contextPath}/Detail/${payApp.needBean.needId}" target="_blank">${payApp.needBean.tripBean.tripname}</a></td>
					      <td>${payApp.needBean.deadline}</td>
					      <td>${payApp.needBean.departureTime}</td>
					      <td>${payApp.needBean.budget}</td> 
					      <td>${payApp.needBean.requiredPeople}</td>
					      <td>${payApp.needBean.tripBean.tripdays}</td>
					      <td class="page4" id="${payApp.needBean.needId}"><i class="fas fa-caret-down"></i></td>
					    </tr>
					</c:forEach>
					
					<c:forEach var="executeApp" items="${userMap.executeList}" varStatus="status">
						<tr>
					      <td><a href="${pageContext.request.contextPath}/Detail/${executeApp.needBean.needId}" target="_blank">${executeApp.needBean.tripBean.tripname}</a></td>
					      <td>${executeApp.needBean.deadline}</td>
					      <td>${executeApp.needBean.departureTime}</td>
					      <td>${executeApp.needBean.budget}</td>
					      <td>${executeApp.needBean.requiredPeople}</td>
					      <td>${executeApp.needBean.tripBean.tripdays}</td>
					      <td class="page4" id="${executeApp.needBean.needId}"><i class="fas fa-caret-down"></i></td> 
					      <td></td> 
					    </tr>
					</c:forEach>
						</tbody>
						
					</table>
				</div>
				<div class="div-in-article">
					<h1>同行旅伴資訊</h1>
					<table class="table table-dark table-striped custom-table">
						<thead>
						    <tr>
						      <th scope="col" style="width:25%">同行旅伴</th>
						      <th scope="col" style="width:25%">是否購買機票</th>
						      <th scope="col" style="width:25%">購買機票</th>
						      <th scope="col" style="width:25%">私訊</th>
						    </tr>
						</thead>
					 	<tbody id="information2">
						</tbody>
					</table>
				</div>
			</article>
			<article class="page-div-hide">
				<div class="div-in-article" style="height:calc(100% - 20px);">
					<h1>訂票紀錄</h1>
<!-- 					<div class="plane-div-row"> -->
<!-- 						<span style="flex:0 0 calc(250%/16)" class="plane-span">訂單時間</span> -->
<!-- 						<span style="flex:0 0 calc(200%/16)" class="plane-span">出發日期</span> -->
<!-- 						<span style="flex:0 0 calc(125%/16)" class="plane-span">出發時間</span> -->
<!-- 						<span style="flex:0 0 calc(200%/16)" class="plane-span">抵達日期</span> -->
<!-- 						<span style="flex:0 0 calc(125%/16)" class="plane-span">抵達時間</span> -->
<!-- 						<span style="flex:0 0 calc(300%/16)" class="plane-span">出發地</span> -->
<!-- 						<span style="flex:0 0 calc(300%/16)" class="plane-span">抵達地</span> -->
<!-- 						<span style="flex:0 0 calc(100%/16)" class="plane-span">#</span> -->
<!-- 					</div> -->
					<c:forEach var="oneOrderBean" items="${userMap.flightOrderBeanList}" varStatus="status">
					<div class="plane-div-row1" style="height:8%; padding:5px;">
							<div style="width:24%;" class="plane-span">訂位代號:${oneOrderBean.orderCode}</div>
							<div style="width:24%;" class="plane-span">訂單時間:${oneOrderBean.orderDate.toString().substring(0,19)}</div>
							<div style="width:24%;" class="plane-span">總金額:${oneOrderBean.orderTotalAmount}</div>
							<div style="width:24%;" class="plane-span">付款狀態:${oneOrderBean.orderStatusID==1?'已付款':'未付款'}</div>						
<%-- 						<div style="width:calc(250%/16);" class="plane-span">${oneOrderDetails.flightOrderBean.orderDate.toString().substring(0,16)}</div> --%>
<%-- 						<div style="width:calc(200%/16);" class="plane-span">${oneOrderDetails.departureDate.toString().substring(0,10)}</div> --%>
<%-- 						<div style="width:calc(125%/16);" class="plane-span">${oneOrderDetails.departureTime.toString().substring(11,16)}</div> --%>
<%-- 						<div style="width:calc(200%/16);" class="plane-span">${oneOrderDetails.arrivalDate.toString().substring(0,10)}</div> --%>
<%-- 						<div style="width:calc(125%/16);" class="plane-span">${oneOrderDetails.arrivalTime.toString().substring(11,16)}</div> --%>
<%-- 						<div style="width:calc(300%/16);" class="plane-span">${oneOrderDetails.departurePlaceBean.cityname}</div> --%>
<%-- 						<div style="width:calc(300%/16);" class="plane-span">${oneOrderDetails.arrivalPlaceBean.cityname}</div> --%>
						<i class="fas fa-caret-down plane-span" style="width:calc(100%/16);" data-toggle="collapse" data-target="#planeDetailInfo${status.index+1}"></i>  
					</div>
					<div class="collapse"  style="background-color:white;border:1px dashed black;" id="planeDetailInfo${status.index+1}">
						<c:forEach var="oneOrderDetail" items="${userMap.orderDetailsList}" varStatus="status">
						<div>
							<c:if test="${oneOrderDetail.flightOrderID==oneOrderBean.flightOrderID}">
								<div class="plane-div-row">
									<div style="width:25%;" class="plane-span">
										出發時間:${oneOrderDetail.departureDate.toString().substring(0,10)}&nbsp;${oneOrderDetail.departureTime.toString().substring(11,16)}
									</div>
									<div style="width:25%;" class="plane-span">
										抵達時間:${oneOrderDetail.arrivalDate.toString().substring(0,10)}&nbsp;${oneOrderDetail.arrivalTime.toString().substring(11,16)}
									</div>
									<div style="width:calc(50%/3);" class="plane-span">
										<img src="${pageContext.request.contextPath}/images/${oneOrderDetail.airlineid}.gif" width="20px">
										${oneOrderDetail.airlineBean.airlinename}
									</div>
									<div style="width:calc(50%/3);" class="plane-span">
										<img src="${pageContext.request.contextPath}/images/icon_f2.png" width="20px">	
										<c:choose>
											<c:when test="${oneOrderBean.cabin.toString() == 'Y'}">經濟艙</c:when>
											<c:when test="${oneOrderBean.cabin.toString() == 'C'}">商務艙</c:when>
											<c:when test="${oneOrderBean.cabin.toString() == 'F'}">頭等艙</c:when>
										</c:choose>
									</div>
									<div style="width:calc(50%/3);" class="plane-span">
										機型:${oneOrderDetail.airlineid}${oneOrderDetail.flightNumber}
									</div>
							</div>
							<div class="plane-div-row"  style="padding:5px;border-bottom:5px groove #EE5A24;">
									<div style="width:25%;" class="plane-span">
										出發地:${oneOrderDetail.departurePlaceBean.cityname}
									</div>
									<div style="width:25%;" class="plane-span">
										目的地:${oneOrderDetail.arrivalPlaceBean.cityname}
									</div>
									<div style="width:calc(50%/3);" class="plane-span">
										成人:${oneOrderBean.adultCount}
									</div>
<!-- 									<div style="width:18%;" class="plane-span"> -->
<%-- 										成人票價:${oneOrderBean.adultPrice} --%>
<!-- 									</div> -->
									<div style="width:calc(50%/3);" class="plane-span">
										小孩:${oneOrderBean.childCount}
									</div>
<!-- 									<div style="width:18%;" class="plane-span"> -->
<%-- 										小孩票價:${oneOrderBean.childPrice} --%>
<!-- 									</div> -->
									<div style="width:calc(50%/3);" class="plane-span">
										<img src="${pageContext.request.contextPath}/images/icon_f4.png" width="20px">
										 ${oneOrderDetail.elapsedTime}
									</div>
									
							</div>
							
							</c:if>
							</div>
						</c:forEach>
					</div>
					</c:forEach>
				</div>
			</article>
		</div>
		<div class="chatwindow" id="chatwindow"></div>
		<div class="Namelist" id="Namelist">	
		</div>
<!-- 		<footer> -->
<!-- 			<div class="divfoot"> -->
<!-- 				<span>電話:0952-388-xxx</span><br> <span>地址:11073台北市信義區松仁路100號</span> -->
<!-- 			</div> -->
<!-- 		</footer> -->

</body>
</html>