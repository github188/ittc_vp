<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 登录人信息 -->
	<div id="menu_left">
		<div class="img">
			<img src="images/home/hf.png"><img src="images/home/user.png" class="userDetail" title="修改用户信息">
		</div>
		<div class="font">
		<!--  
			<font>登录人:${userModel.userName }</font>
		-->	
			<font>登录人:${session.USER_INFO.userName }</font>
			
		</div>
		
	</div>
	<!-- 空白 -->
	<div id="menu_middle">
	</div>
	<!-- 菜单 -->
	<div id="menu_right">
			<img alt="" src="images/live/preview.jpg" class="preview" ><img 
			alt="" src="images/home/logsearch.jpg" class="logsearch"><img 
			alt="" src="images/home/devcfg.jpg"  class="devcfg"><img 
			alt="" src="images/home/devmgr.jpg" class="devmgr"><img 
			alt="" src="images/home/usermgr.jpg" class="usermgr">
	</div>

	
	<div id="modifyUserInfoDiv" style="display: none; width: 280px;height: 120px;color: black;text-align: center;margin: 0 auto;">
		<table style="width: 100%">
			<tr>
				<td>旧&nbsp;&nbsp;&nbsp;密码:</td>
				<td><input name="oldPwd" type="password"></td>
			</tr>
			<tr>
				<td>新&nbsp;&nbsp;&nbsp;密码:</td>
				<td><input name="newPwd" type="password"></td>
			</tr>
			<tr>
				<td>确认密码:</td>
				<td><input name="pwd2" type="password"></td>
			</tr>
			<tr>
				<td><input type="button" value="确认" class="modifySure"></td>
				<td><input type="button" value="取消" class="modifyCancel"></td>
			</tr>
		</table>
	</div>
	
<script type="text/javascript">
 function muneLink(){
	 $(".preview").click(function(){
		 location.href="go_preview.action";
	 });
	$(".home").click(function(){
		location.href="go_home.action";
	});
	 
	$(".logsearch").click(function(){
		location.href="go_logsearch.action";
		//jAlert("亲，<i><b>日志查询</b></i>功能，小编正在努力为您研发中，请继续关注哦！","温馨提示");
	});
	$(".devcfg").click(function(){
		location.href="go_devcfg.action";
		//jAlert("亲，<i><b>设备配置</b></i>功能，小编正在努力为您研发中，请继续关注哦！","温馨提示");
	});
	
	$(".devmgr").click(function(){
		location.href="go_devmgr.action";
		
	});
	
	$(".usermgr").click(function(){
		location.href="go_usermgr.action";
	});
}
 

	//页面显示实时时间
	function getDate(){
		var myDate=new Date();
		var yyyy=myDate.getFullYear();
		var mm=myDate.getMonth()+1;		////获取当前月份(0-11,0代表1月)
		if(mm<10){
			mm="0"+mm;
		}
		var dd=myDate.getDate();        //获取当前日(1-31)
		if(dd<10){
			dd="0"+dd;
		}
		var hh=myDate.getHours();       //获取当前小时数(0-23)
		if(hh<10){
			hh="0"+hh;
		}
		var ms=myDate.getMinutes();     //获取当前分钟数(0-59)
		if(ms<10){
			ms="0"+ms;
		}
		
		var ss=myDate.getSeconds();		//获取当前秒数(0-59)
		if(ss<10){
			ss="0"+ss;
		}
		$("#main .time_time").html(hh+":"+ms+":"+ss);
		$("#main .time_date").html(yyyy+"/"+mm+"/"+dd);
	}
	

</script>
<script type="text/javascript">
$(document).ready(function(){
	$(".userDetail").click(function(){
		//alert("修改密码");
		//jAlert("123");
		if(location.href.indexOf("preview")<0){
			$("#modifyUserInfoDiv").zxxbox({
				bar: false,
			    bgclose: true
			});
		}
		
	});
	
	$(".modifySure").click(function(){
		var oldPwd=$("input[name='oldPwd']").val();
		var newPwd=$("input[name='newPwd']").val();
		var pwd2=$("input[name='pwd2']").val();
		
		if(oldPwd==""){
			jAlert("请输入旧密码！","提示");
			return;
		}
		if(newPwd==""){
			jAlert("请输入新密码！","提示");
			return;
		}
		if(pwd2==""){
			jAlert("请输入确认密码！","提示");
			return;
		}
		if(newPwd!=pwd2){
			jAlert("二次密码输入不一致！","提示");
			return;
		}
		$.ajax({
			url:"json_UserAction_modifyPwd.action",
			data:"oldPwd="+oldPwd+"&newPwd="+newPwd,
			type:"POST",
			dataType:"json",
			cache:false,
			success:function(json){
				$.zxxbox.hide();
				var jsonData=eval("("+json+")");//转换为json对象 
				var success=jsonData.success;
				if(success){
					alert("修改成功,请重新登录！","提示");
					location.href="login.jsp";
				}else{
					jAlert("修改失败！","提示");
				}
				//jAlert("修改成功！","提示");
				//location.href="login.jsp";
			},error:function(){
				jAlert("网络异常！","提示");
			}
		});
		//jAlert(oldPwd+"修改成功！"+newPwd+","+pwd2);
	});
	
	$(".modifyCancel").click(function(){
		$("input[name='oldPwd']").val("");
		$("input[name='newPwd']").val("");
		$("input[name='pwd2']").val("");
		$.zxxbox.hide();
	});
});
</script>
