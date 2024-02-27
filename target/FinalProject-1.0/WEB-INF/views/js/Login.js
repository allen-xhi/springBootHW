  $(document).ready(function(){
 	var loginStatus = "${loginStatus}";
			 if(loginStatus=='true'){
				 var email = "${memberBean.email}";
				 var account = (email.split('@'))[0];
				 $("#registerLabel").text("登出");
				($("#registerLabel").parent()).click(function(){
					 event.preventDefault();
					})	
				 $("#registerLabel").click(function(){
				 $.ajax({
					url:"logout",
					type:"get",
					success:function(data){
						alert(data);
						location.href = "${pageContext.request.contextPath}";
					},error:function(data){
								
					}
					});
					 });
				 $("#loginLabel").text(account);
				($("#loginLabel").parent()).click(function(){
					 event.preventDefault();
				});
				$("#loginLabel").click(function(){
					 location.href = "needLogin/showUserInfo";
				 })
				 }
});