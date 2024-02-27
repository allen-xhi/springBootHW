<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="zh-tw">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>jQuery UI Slider - Range slider</title>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
	$(function() {
		$("#slider-range1").slider({
			range : true,
			min : 0,
			max : 1439,
			
			values : [ 0, 1439 ],
			slide : function(event, ui) {
				var hours1 = Math.floor(ui.values[0] / 60);
	            var minutes1 = ui.values[0] - (hours1 * 60);
	            if(hours1.toString().length == 1) hours1 = '0' + hours1;
	            if(minutes1.toString().length == 1) minutes1 = '0' + minutes1;
				
	            var hours2 = Math.floor(ui.values[1] / 60);
	            var minutes2 = ui.values[1] - (hours2 * 60);
	            if(hours2.toString().length == 1) hours2 = '0' + hours2;
	            if(minutes2.toString().length == 1) minutes2 = '0' + minutes2;
	            
	            var timeRange = hours1 + ":" +　minutes1 + " - " +　hours2 + ":" +　minutes2;
				
	            $( "#amount1" ).val( timeRange );
			}
		});
		
		var hoursD1 = Math.floor($("#slider-range1").slider("values", 0) / 60);
        var minutesD1 = $("#slider-range1").slider("values", 0) - (hoursD1 * 60);
        if(hoursD1.toString().length == 1) hoursD1 = '0' + hoursD1;
        if(minutesD1.toString().length == 1) minutesD1 = '0' + minutesD1;
		
        var hoursD2 = Math.floor($("#slider-range1").slider("values", 1) / 60);
        var minutesD2 = $("#slider-range1").slider("values", 1) - (hoursD2 * 60);
        if(hoursD2.toString().length == 1) hoursD2 = '0' + hoursD2;
        if(minutesD2.toString().length == 1) minutesD2 = '0' + minutesD2;
        
        var timeRangeD = hoursD1 + ":" +　minutesD1 + " - " +　hoursD2 + ":" +　minutesD2;
		
		$("#amount1").val( timeRangeD );
	});
	
	$(function() {
		$("#slider-range2").slider({
			range : true,
			min : 0,
			max : 1439,
			
			values : [ 0, 1439 ],
			slide : function(event, ui) {
				var hours1 = Math.floor(ui.values[0] / 60);
	            var minutes1 = ui.values[0] - (hours1 * 60);
	            if(hours1.toString().length == 1) hours1 = '0' + hours1;
	            if(minutes1.toString().length == 1) minutes1 = '0' + minutes1;
				
	            var hours2 = Math.floor(ui.values[1] / 60);
	            var minutes2 = ui.values[1] - (hours2 * 60);
	            if(hours2.toString().length == 1) hours2 = '0' + hours2;
	            if(minutes2.toString().length == 1) minutes2 = '0' + minutes2;
	            
	            var timeRange = hours1 + ":" +　minutes1 + " - " +　hours2 + ":" +　minutes2;
				
	            $( "#amount2" ).val( timeRange );
			}
		});
		
		var hoursD1 = Math.floor($("#slider-range2").slider("values", 0) / 60);
        var minutesD1 = $("#slider-range2").slider("values", 0) - (hoursD1 * 60);
        if(hoursD1.toString().length == 1) hoursD1 = '0' + hoursD1;
        if(minutesD1.toString().length == 1) minutesD1 = '0' + minutesD1;
		
        var hoursD2 = Math.floor($("#slider-range2").slider("values", 1) / 60);
        var minutesD2 = $("#slider-range2").slider("values", 1) - (hoursD2 * 60);
        if(hoursD2.toString().length == 1) hoursD2 = '0' + hoursD2;
        if(minutesD2.toString().length == 1) minutesD2 = '0' + minutesD2;
        
        var timeRangeD = hoursD1 + ":" +　minutesD1 + " - " +　hoursD2 + ":" +　minutesD2;
		
		$("#amount2").val( timeRangeD );
	});
	
	$(function() {
		$("#slider-range3").slider({
			range : true,
			min : 0,
			max : 1439,
			
			values : [ 0, 1439 ],
			slide : function(event, ui) {
				var hours1 = Math.floor(ui.values[0] / 60);
	            var minutes1 = ui.values[0] - (hours1 * 60);
	            if(hours1.toString().length == 1) hours1 = '0' + hours1;
	            if(minutes1.toString().length == 1) minutes1 = '0' + minutes1;
				
	            var hours2 = Math.floor(ui.values[1] / 60);
	            var minutes2 = ui.values[1] - (hours2 * 60);
	            if(hours2.toString().length == 1) hours2 = '0' + hours2;
	            if(minutes2.toString().length == 1) minutes2 = '0' + minutes2;
	            
	            var timeRange = hours1 + ":" +　minutes1 + " - " +　hours2 + ":" +　minutes2;
				
	            $( "#amount3" ).val( timeRange );
			}
		});
		
		var hoursD1 = Math.floor($("#slider-range3").slider("values", 0) / 60);
        var minutesD1 = $("#slider-range3").slider("values", 0) - (hoursD1 * 60);
        if(hoursD1.toString().length == 1) hoursD1 = '0' + hoursD1;
        if(minutesD1.toString().length == 1) minutesD1 = '0' + minutesD1;
		
        var hoursD2 = Math.floor($("#slider-range3").slider("values", 1) / 60);
        var minutesD2 = $("#slider-range3").slider("values", 1) - (hoursD2 * 60);
        if(hoursD2.toString().length == 1) hoursD2 = '0' + hoursD2;
        if(minutesD2.toString().length == 1) minutesD2 = '0' + minutesD2;
        
        var timeRangeD = hoursD1 + ":" +　minutesD1 + " - " +　hoursD2 + ":" +　minutesD2;
		
		$("#amount3").val( timeRangeD );
	});
	
	$(function() {
		$("#slider-range4").slider({
			range : true,
			min : 0,
			max : 1439,
			
			values : [ 0, 1439 ],
			slide : function(event, ui) {
				var hours1 = Math.floor(ui.values[0] / 60);
	            var minutes1 = ui.values[0] - (hours1 * 60);
	            if(hours1.toString().length == 1) hours1 = '0' + hours1;
	            if(minutes1.toString().length == 1) minutes1 = '0' + minutes1;
				
	            var hours2 = Math.floor(ui.values[1] / 60);
	            var minutes2 = ui.values[1] - (hours2 * 60);
	            if(hours2.toString().length == 1) hours2 = '0' + hours2;
	            if(minutes2.toString().length == 1) minutes2 = '0' + minutes2;
	            
	            var timeRange = hours1 + ":" +　minutes1 + " - " +　hours2 + ":" +　minutes2;
				
	            $( "#amount4" ).val( timeRange );
			}
		});
		
		var hoursD1 = Math.floor($("#slider-range4").slider("values", 0) / 60);
        var minutesD1 = $("#slider-range4").slider("values", 0) - (hoursD1 * 60);
        if(hoursD1.toString().length == 1) hoursD1 = '0' + hoursD1;
        if(minutesD1.toString().length == 1) minutesD1 = '0' + minutesD1;
		
        var hoursD2 = Math.floor($("#slider-range4").slider("values", 1) / 60);
        var minutesD2 = $("#slider-range4").slider("values", 1) - (hoursD2 * 60);
        if(hoursD2.toString().length == 1) hoursD2 = '0' + hoursD2;
        if(minutesD2.toString().length == 1) minutesD2 = '0' + minutesD2;
        
        var timeRangeD = hoursD1 + ":" +　minutesD1 + " - " +　hoursD2 + ":" +　minutesD2;
		
		$("#amount4").val( timeRangeD );
	});
</script>
<style>
* {
	font-family: 微軟正黑體;
	font-size: 14px;
}
</style>
</head>
<body>

	<span>去程：<span id="scheduleGo"></span></span>
	<p>
		<label for="amount1">起飛：</label> <input type="text" id="amount1"
			readonly style="border: 0; color: black; font-weight: bold;">
	</p>
	<div id="slider-range1" style="width: 250px;background-color:orange"></div>
	<p>
		<label for="amount2">抵達：</label> <input type="text" id="amount2"
			readonly style="border: 0; color: black; font-weight: bold;">
	</p>
	<div id="slider-range2" style="width: 250px;"></div>
	
	<br>
	<br>
	<span>回程：<span id="scheduleBack"></span></span>
	<p>
		<label for="amount3">起飛：</label> <input type="text" id="amount3"
			readonly style="border: 0; color: black; font-weight: bold;">
	</p>
	<div id="slider-range3" style="width: 250px;"></div>
	<p>
		<label for="amount4">抵達：</label> <input type="text" id="amount4"
			readonly style="border: 0; color: black; font-weight: bold;">
	</p>
	<div id="slider-range4" style="width: 250px;"></div>

</body>
</html>