function loadWebSocket(i) {
    //獲取DOM元件
	var send =document.getElementById("send"+i);
    var loginBtn = document.getElementById("loginBtn"+i);
    var userNameInput = document.getElementById("userNameInput"+i);
    var infoWindow = document.getElementById("infoWindow"+i);
    var userinput = document.getElementById("userinput"+i);
    var chatRoomForm = document.getElementById("chatRoomForm"+i);
    var messageDisplay = document.getElementById("messageDisplay"+i);
    var webSocket;
    var isConnectSuccess = false;
  
    var member=sessionStorage.getItem("lastname");
    //設置登入鈕的動作，沒有登出，登入才可發言
    
    chatRoomForm.addEventListener("click", function () {
    //檢查有無輸入名稱
        if (userNameInput.value && userNameInput.value !== "") {
            initWebSocket();  //設置WebSocket連接
            infoWindow.innerHTML=""
        } else {
            infoWindow.innerHTML = "請輸入名稱";
        }
    });
    //Submit Form時送出訊息
    chatRoomForm.addEventListener("submit", function () {
        sendMessage();
        return false;
    });
    //使用webSocket擁有的function, send(), 送出訊息
    function sendMessage() {
        //檢查WebSocket連接狀態
        if (webSocket && isConnectSuccess) {
            var messageInfo = {
                userName: userNameInput.value,
                message: userinput.value
            }
            webSocket.send(JSON.stringify(messageInfo));
        } else {
            infoWindow.innerHTML = "未登入";
        }
    }

    //設置WebSocket
    function initWebSocket() {
        //開始WebSocket連線
    	  var roomName = document.getElementById("roomName"+i).value;
         // 房间名不能为空
         if (roomName == null || roomName == "") {
             alert("PlzEnterName");
             return;
         }
         if ("WebSocket" in window) {
        	 //alert("瀏覽器支持 WebSocket!");
             if (webSocket == null) {
            	//跳出房名// alert(roomName.value);
                 var url = "ws://localhost:8080/FinalProject/chat/n " + roomName;
                 // 打开一个 web socket 
                 webSocket = new WebSocket(url);
             } else {
                 
             }
                     
        //以下開始偵測WebSocket的各種事件
         //事件物件
        //onerror , 連線錯誤時觸發  
        webSocket.onerror = function (event) {
            loginBtn.disabled = false;
            userNameInput.disabled = false;
            infoWindow.innerHTML = "登入失敗";
        };
 
        //onopen , 連線成功時觸發
        webSocket.onopen = function (event) {
            isConnectSuccess = true;
            loginBtn.disabled = true;
            userNameInput.disabled = true;
            infoWindow.innerHTML = "";
            
            
            //送一個登入聊天室的訊息(*)
//            var firstLoginInfo = {
//                userName : "系統",
//                message : userNameInput.value + " 登入了聊天室"
//            };
//            webSocket.send(JSON.stringify(firstLoginInfo));
        };
        //onmessage , 接收到來自Server的訊息即時傳輸
        webSocket.onmessage = function (event) {
            var messageObject = JSON.parse(event.data);
            if(member==(messageObject.userName))
            messageDisplay.innerHTML += '<br>'+'<div class="toolboxA" style=text-align:left;>' +  messageObject.message+'<div>';
            else
            messageDisplay.innerHTML += '<br>'+'<div class="toolboxB" maign="right" style=text-align:right;>' + messageObject.message+'<div>';
        };
         }
    }
};