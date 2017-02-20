<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JQuery Peity</title>
<script type="text/javascript" src="scripts/jquery-1.8.1.js"></script>
<script type="text/javascript" src="scripts/Peity/jquery.peity.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	 $(".bar-colours-1").peity("bar", { 
         colours: ["red", "green", "blue"],width: 100,height:100  
       });
	 $(".bar-colours-2").peity("bar", {  
         colours: function(value) {  
           return value > 0 ? "green" : "red"  
         },width: 100,height:100  
       });
	 $(".bar-colours-3").peity("bar", {  
         colours: function(_, i, all) {  
           var g = parseInt((i / all.length) * 255)  
           return "rgb(255, " + g + ", 0)"  
         },width: 100,height:100  
       });
	 
	 $(".pie-colours-1").peity("pie", {
         colours: ["cyan", "magenta", "yellow", "black"],diameter:100  
       });
	 $(".pie-colours-2").peity("pie", {  
         colours: function(_, i, all) {  
           var g = parseInt((i / all.length) * 255)  
           return "rgb(255, " + g + ", 0)"  
         },diameter:100  
       });
	 
	 var updatingChart = $(".updating-chart").peity("line", { width: 150,height:50})  
     setInterval(function() {  
       var random = Math.round(Math.random() * 10)  
       var values = updatingChart.text().split(",")  
       values.shift()  
       values.push(random)  
       updatingChart  
         .text(values.join(","))  
         .change()  
     }, 1000);
});
</script>
</head>
<body>
   <span class="bar-colours-1">5,3,9,6,5,9,7,3,5,2</span>  
    <span class="bar-colours-2">5,3,2,-1,-3,-2,2,3,5,2</span>  
    <span class="bar-colours-3">0,-3,-6,-4,-5,-4,-7,-3,-5,-2</span>  
    <br />  
    <span class="pie-colours-1">4,7,6,5</span>  
    <span class="pie-colours-2">5,3,9,6,5</span>  
    <br />  
    <span class="updating-chart">5,3,9,6,5,9,7,3,5,2,5,3,9,6,5,9,7,3,5,2</span>
</body>
</html>