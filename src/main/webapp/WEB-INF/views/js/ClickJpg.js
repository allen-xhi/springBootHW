$(document).ready(function() {
$("img.img1").click(function(){
			$("input.inp1").val("");
			$("#tab2").empty();
		 $("div.div6").toggle('size',{origin:["top","right"]},1500);
		});
});