<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆页面</title>
<style type="text/css">
.loginName{text-align: center;}
</style>
<script type="text/javascript" src="scripts/jquery-1.8.1.js"></script>
<script type="text/javascript" src="scripts/jquery.ui.draggable.js"></script> 
<script type="text/javascript" src="scripts/jquery.alerts.js" ></script>
<link href="scripts/jquery.alerts.css" rel="stylesheet" type="text/css" media="screen" />
<link rel="shortcut icon" href="http://love-love-l.blog.163.com/blog/favicon.ico" type="image/x-icon" /> 
<script type="text/javascript">
$(function(){
	function login(){
		if($.trim($(".loginName").val())==""){
			jAlert("请输入用户名！","提示");
			return;
		}
		if($.trim($(".loginPwd").val())==""){
			jAlert("请输入密码！","提示");
			return;
		}
		$("form").submit();
	}
	
	$("#btnLogin").hover(function(){
		$(this).attr("src","images/login/Login_30.png");
	},function(){
		$(this).attr("src","images/login/Login_30.jpg");
	}).click(function(){
		login();
		
	});
	
	//键盘按下
	$(window).keydown(function(event){
		  if(parseInt(event.keyCode)==13){
			  login();
		  }
	});
	
	$("#btnReset").hover(function(){
		$(this).attr("src","images/login/Login_32.png");
	},function(){
		$(this).attr("src","images/login/Login_32.jpg");
	}).click(function(){
		$(".loginName").val("");
		$(".loginPwd").val("");
	});
	/**
	$(".loginName").focusout(function(){
		if($.trim($(this).val())==""){
			jAlert("请输入用户名！","提示");
			return;
		}
	});
	$(".loginPwd").focusout(function(){
		if($.trim($(this).val())==""){
			jAlert("请输入密码！","提示");
		}
	});
	**/
});
</script>
</head>
<body>
<div style="text-align: center;margin: 0 auto;width: 910px;height: 610px;">
	<!-- Save for Web Slices (4.jpg) -->
	<!-- 
	<form action="action_UserAction_login_preview_error.action" method="post">
	 -->
	<form action="action_UserAction_login_preview_error.action" method="post">
	<table id="__01" width="900" height="600" border="0" cellpadding="0" cellspacing="0" >
		<tr>
			<td>
				<img src="images/login/Login_01.jpg" width="172" height="80" alt=""></td>
			<td>
				<img src="images/login/Login_02.jpg" width="201" height="80" alt=""></td>
			<td colspan="3">
				<img src="images/login/Login_03.jpg" width="189" height="80" alt=""></td>
			<td>
				<img src="images/login/Login_04.jpg" width="171" height="80" alt=""></td>
			<td>
				<img src="images/login/Login_05.jpg" width="167" height="80" alt=""></td>
		</tr>
		<tr>
			<td>
				<img src="images/login/Login_06.jpg" width="172" height="72" alt=""></td>
			<td>
				<img src="images/login/Login_07.jpg" width="201" height="72" alt=""></td>
			<td colspan="3">
				<img src="images/login/Login_08.jpg" width="189" height="72" alt=""></td>
			<td>
				<img src="images/login/Login_09.jpg" width="171" height="72" alt=""></td>
			<td>
				<img src="images/login/Login_10.jpg" width="167" height="72" alt=""></td>
		</tr>
		<tr>
			<td>
				<img src="images/login/Login_11.jpg" width="172" height="78" alt=""></td>
			<td>
				<img src="images/login/Login_12.jpg" width="201" height="78" alt=""></td>
			<td colspan="3">
				<img src="images/login/Login_13.jpg" width="189" height="78" alt=""></td>
			<td>
				<img src="images/login/Login_14.jpg" width="171" height="78" alt=""></td>
			<td>
				<img src="images/login/Login_15.jpg" width="167" height="78" alt=""></td>
		</tr>
		<tr>
			<td rowspan="3">
				<img src="images/login/Login_16.jpg" width="172" height="80" alt=""></td>
			<td rowspan="3">
				<img src="images/login/Login_17.jpg" width="201" height="80" alt=""></td>
			<td colspan="3">
				
				<input class="loginName" name="userModel.loginName" type="text" style="width: 183px;height: 25px;text-align: left;" title="请输入用户名">
			</td>
			<td rowspan="3">
				<img src="images/login/Login_19.jpg" width="171" height="80" alt=""></td>
			<td rowspan="3">
				<img src="images/login/Login_20.jpg" width="167" height="80" alt=""></td>
		</tr>
		<tr>
			<td colspan="3">
				<img src="images/login/Login_21.jpg" width="189" height="14" alt=""></td>
		</tr>
		<tr>
			<td colspan="3">
				<input class="loginPwd" name="userModel.loginPwd" type="password" style="width: 183px;height: 25px" title="请输入密码">	
			</td>
		</tr>
		<tr>
			<td rowspan="3">
				<img src="images/login/Login_23.jpg" width="172" height="78" alt=""></td>
			<td rowspan="3">
				<img src="images/login/Login_24.jpg" width="201" height="78" alt=""></td>
			<td>
				<img src="images/login/Login_25.jpg" width="79" height="25" alt=""></td>
			<td>
				<img src="images/login/Login_26.jpg" width="32" height="25" alt=""></td>
			<td>
				<img src="images/login/Login_27.jpg" width="78" height="25" alt=""></td>
			<td rowspan="3">
				<img src="images/login/Login_28.jpg" width="171" height="78" alt=""></td>
			<td rowspan="3">
				<img src="images/login/Login_29.jpg" width="167" height="78" alt=""></td>
		</tr>
		<tr>
			<td>
				<img id="btnLogin" src="images/login/Login_30.jpg" width="79" height="29" alt=""></td>
			<td>
				<img src="images/login/Login_31.jpg" width="32" height="29" alt=""></td>
			<td>
				<img id="btnReset" src="images/login/Login_32.jpg" width="78" height="29" alt=""></td>
		</tr>
		<tr>
			<td>
				<img src="images/login/Login_33.jpg" width="79" height="24" alt=""></td>
			<td>
				<img src="images/login/Login_34.jpg" width="32" height="24" alt=""></td>
			<td>
				<img src="images/login/Login_35.jpg" width="78" height="24" alt=""></td>
		</tr>
		<tr>
			<td>
				<img src="images/login/Login_36.jpg" width="172" height="97" alt=""></td>
			<td>
				<img src="images/login/Login_37.jpg" width="201" height="97" alt=""></td>
			<td colspan="3">
				<img src="images/login/Login_38.jpg" width="189" height="97" alt=""></td>
			<td>
				<img src="images/login/Login_39.jpg" width="171" height="97" alt=""></td>
			<td>
				<img src="images/login/Login_40.jpg" width="167" height="97" alt=""></td>
		</tr>
		<tr>
			<td>
				<img src="images/login/Login_41.jpg" width="172" height="115" alt=""></td>
			<td>
				<img src="images/login/Login_42.jpg" width="201" height="115" alt=""></td>
			<td colspan="3">
				<img src="images/login/Login_43.jpg" width="189" height="115" alt=""></td>
			<td>
				<img src="images/login/Login_44.jpg" width="171" height="115" alt=""></td>
			<td>
				<img src="images/login/Login_45.jpg" width="167" height="115" alt=""></td>
		</tr>
	</table>
	</form>
<!-- End Save for Web Slices -->
	
</div>
</body>
</html>