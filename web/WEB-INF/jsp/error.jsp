<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>错误页面</title>
<style type="text/css">
body{
	color: black;
	font-family: Microsoft Simhei;
	font-size: 24pt;
}
.all{
	background-image: url("images/home/error_bg.jpg");
	width: 1138px;
	height: 690px;
	text-align: center;
	margin: 0 auto;
}
.showMsg{
	float:left;
	width:1000px;
	height:100px;
	border:0px blue solid;
	text-align: left;
}
.back2login{
	float: left;
	width: 1000px;
	height: 100px;
	text-align: left;
}
</style>
<script type="text/javascript">
function login(){
	 window.location.href="login.jsp"; 
}
</script>
</head>
<body>
<div class="all">
	<div style="width: 110px;height: 690px;;float: left;"></div>
	<div style="width: 1000px;height: 350px;float: left;"></div>
	<div class="showMsg">
		 ${errorMsg }
	</div>
	<div class="back2login">
		<input type="image" src="images/home/back2login.png" onclick="login()">
	</div>
</div>

</body>
</html>