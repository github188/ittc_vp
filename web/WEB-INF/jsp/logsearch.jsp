<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>日志查询</title>
<!-- 菜单css -->
<link href="styles/menu.css" rel="stylesheet" type="text/css" media="screen" />
<style type="text/css">
/*组菜单*/
#main #main_left{
	float: left;
	width: 250px;
	height: 667px;
	background-image: url("images/usermgr/main_left_bg.jpg");
	}
	/*实时时间*/
#main_left .main_time{
	background-image: url("images/usermgr/time_bg.png");
	width: 200px;
	height: 72px;
	margin-left: 25px;
}
/*实时日期*/
#main_left .main_time .time_time{
	height:40px;
	line-height:45px;
	overflow:hidden;
	font-size: 22pt;
}
/*组别列表*/
#main_left #left_list{
	width: 250px;
	height: 580px;
	float: left;
}

#left_list #list_ul{
	float: left;
	width: 239px;
}
#main_left #left_list ul{
	margin: 0px;
	padding: 0px;
}
#main_left #left_list ul li{
	list-style:none;
	height: 55px;
	width: 239px;
	background-image: url('images/usermgr/z_bg.jpg');
}
#main_left #left_list ul li font{
	font-size:14px;
	line-height: 55px;
}
#main_right{
	float: left;
	width: 840px;
	height: 675px;
}
#main_right #right_menu{
	width: 840px;
	height: 100px;
	margin-top: 15px;
}
#main_right #right_info{
	width: 840px;
	height: 39px;
	background-image: url("images/log/title_bg.png");
}
#right_info table{
	line-height: 30px;
}
#right_info #info_detail{
	width: 840px;
	height: 450px;
}
</style>
<script type="text/javascript" src="scripts/jquery-1.8.1.js"></script>
<script type="text/javascript" src="scripts/jquery.ui.draggable.js"></script> 
<script type="text/javascript" src="scripts/jquery.alerts.js" ></script>
<link href="scripts/jquery.alerts.css" rel="stylesheet" type="text/css" media="screen" />

<!--日历插件  -->
<script type="text/javascript" src="scripts/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="scripts/jquery.zxxbox.3.0.js"></script>
<!-- jquery模板 -->
<script src="scripts/jquery.tmpl.js" type="text/javascript"></script>
<script type="text/javascript">




$(document).ready(function(){
	//catch the right-click context menu
	$(document).bind("contextmenu",function(e) {//右键禁用			 
		//warning prompt - optional
		//alert("No right-clicking!");
		//delete the default context menu
		return false;
	});
	//系统日志
	function getSysLog(startPage,showNum){
		var depName=$("input[name=\"depName\"]").val();
		var userName=$("input[name=\"userName\"]").val();
		var startTime=$("input[name=\"startTime_sys\"]").val();
		var endTime=$("input[name=\"endTime_sys\"]").val();
		$.ajax({
			url:"json_LogAction_getSysLog.action",
			data:"sysLogModel.depName="+depName+"&sysLogModel.userName="+userName
				+"&sysLogModel.startTime="+startTime+"&sysLogModel.endTime="+endTime
				+"&sysLogModel.startPage="+startPage+"&sysLogModel.showNum="+showNum,
			type:"POST",
			dataType:"json",
			cache:false,
			error:function(){
				jAlert("网络异常!","提示");
			},success:function(json){
				//jAlert("成员‘"+userName+"’删除成功","提示");
				 var jsonData=eval("("+json+")");//转换为json对象 
				 if(jsonData.success=="0"){
					 jAlert("暂无数据！","提示");
					 $("#sys_log_container").empty();
					 $(".curPage").html(0);
					 $(".countPage").html(0);
					 return;
				 }
				 $("#sys_log_container").empty();
				 $("#sysContentTemplate").tmpl(jsonData.data).appendTo("#sys_log_container");
				 count=jsonData.count;
				 //alert(count);
				 $(".countPage").html(count);
				
			},complete:function(){
				$("#xtrz").show();
			}
		});
	}
	//查询操作日志
	function getOperateLog(startPage,showNum){
		var depName=$("input[name=\"depName_op\"]").val();
		var userName=$("input[name=\"userName_op\"]").val();
		var startTime=$("input[name=\"startTime_op\"]").val();
		var endTime=$("input[name=\"endTime_op\"]").val();
		$.ajax({
			url:"json_LogAction_getOperateLog.action",
			data:"sysLogModel.depName="+depName+"&sysLogModel.userName="+userName
				+"&sysLogModel.startTime="+startTime+"&sysLogModel.endTime="+endTime
				+"&sysLogModel.startPage="+startPage+"&sysLogModel.showNum="+showNum,
			type:"POST",
			dataType:"json",
			cache:false,
			error:function(){
				jAlert("网络异常!","提示");
			},success:function(json){
				//jAlert("成员‘"+userName+"’删除成功","提示");
				 var jsonData=eval("("+json+")");//转换为json对象 
				 if(jsonData.success=="0"){
					 jAlert("暂无数据！","提示");
					 $("#op_log_container").empty();
					 $(".op_curPage").html(0);
					 $(".op_countPage").html(0);
					 return;
				 }
				 $("#op_log_container").empty();
				 $("#sysContentTemplate").tmpl(jsonData.data).appendTo("#op_log_container");
				 count=jsonData.count;
				 //alert(count);
				 $(".op_countPage").html(count);
				
			},complete:function(){
				$("#czrz").show();
			}
		});
	}
	
	//查询报警日志
	function getWarningLog(startPage,showNum){
		var waringType=$("input[name=\"warningType\"]").val();
		var warningFrom=$("input[name=\"warningFrom\"]").val();
		var startTime=$("input[name=\"startTime_warn\"]").val();
		var endTime=$("input[name=\"endTime_warn\"]").val();
		$.ajax({
			url:"json_LogAction_getWarningLog.action",
			data:"warningLogModel.warningType="+waringType+"&warningLogModel.warningFrom="+warningFrom
				+"&warningLogModel.startTime="+startTime+"&warningLogModel.endTime="+endTime
				+"&warningLogModel.startPage="+startPage+"&warningLogModel.showNum="+showNum,
			type:"POST",
			dataType:"json",
			cache:false,
			error:function(){
				jAlert("网络异常!","提示");
			},success:function(json){
				//jAlert("成员‘"+userName+"’删除成功","提示");
				 var jsonData=eval("("+json+")");//转换为json对象 
				 if(jsonData.success=="0"){
					 jAlert("暂无数据！","提示");
					 $("#warn_log_container").empty();
					 $(".warn_curPage").html(0);
					 $(".warn_countPage").html(0);
					 return;
				 }
				 $("#warn_log_container").empty();
				 $("#warnContentTemplate").tmpl(jsonData.data).appendTo("#warn_log_container");
				 count=jsonData.count;
				 //alert(count);
				 $(".warn_countPage").html(count);
				
			},complete:function(){
				$("#bjrz").show();
			}
		});
	}
	
	function hideLogDiv(){
		$("#xtrz").hide();
		$("#czrz").hide();
		$("#bjrz").hide();
	}
	
	muneLink();
	getDate();
	window.setInterval(getDate,1000);  //每隔一秒显示时间 
	
	hideLogDiv();
	$("#menu_right img").eq(1).attr("src","images/home/logsearch_pressed.png");
	
	$("#menu_right img").hover(function(){
		if($(this).attr("src")=="images/home/logsearch_pressed.png"){
			return;
		}
		var src=$(this).attr("src").replace(".jpg",".png");
		$(this).attr("src",src).css("cursor","pointer");
	},function(){
		if($(this).attr("src")=="images/home/logsearch_pressed.png"){
			return;
		}
		var src=$(this).attr("src").replace(".png",".jpg");
		$(this).attr("src",src);
	});
	
	//左边菜单选择
	$("#list_ul li").click(function(){
		$("#list_ul li").each(function(){
			var bg=$(this).css("background-image");
			$(this).css("background-image",bg.replace(".png",".jpg"));
			$(this).children("div").hide();
		});
		var bg2=$(this).css("background-image");
		$(this).css("background-image",bg2.replace(".jpg",".png"));
		$(this).children("div").show();
		$(this).children("font").css("margin-left","20px");
		hideLogDiv();
		
		var divName=$(this).find(".grpbtn").attr("lang");
		$("#"+divName).show();
		//getUserByDep($(this).find(".grpbtn").attr("lang"));
	});
	$("#info_page").find("label").hover(function(){
		$(this).css("cursor","pointer").css("color","#55daed");
	},function(){
		$(this).css("color","white");
	});
	
	
	//getAllDep();
	

	var startPage=0;
	var showCout=10;
	var count=0;
	getSysLog(startPage,showCout);
	$(".btnSysSearch").click(function(){
		getSysLog(startPage,showCout);
	});
	//下一页
	$(".sys_nextPage").click(function(){
		startPage=(startPage+1);
		//alert(count);
		if(startPage>=count){
			startPage=count-1;
			return;
		}
		getSysLog(startPage*showCout,showCout);
		$(".curPage").html(startPage+1);
	});
	//上一页
	$(".sys_prePage").click(function(){
		startPage=(startPage-1);
		if(startPage<0){
			startPage=0;
			return;
		}
		getSysLog(startPage*showCout,showCout);
		$(".curPage").html(startPage+1);
	});
	//首页
	$(".sys_firstPage").click(function(){
		 startPage=0;
		 getSysLog(startPage*showCout,showCout);
		 $(".curPage").html(startPage+1);
	});
	//末页
	$(".sys_lastPage").click(function(){
		startPage=count-1;
		 getSysLog(startPage*showCout,showCout);
		 $(".curPage").html(startPage+1);
	});
	
	//操作日志
	$(".btnOpSearch").click(function(){ 
		getOperateLog(startPage,showCout);
	});
	//下一页
	$(".op_nextPage").click(function(){
		startPage=(startPage+1);
		//alert(count);
		if(startPage>=count){
			startPage=count-1;
			return;
		}
		getOperateLog(startPage*showCout,showCout);
		$(".op_curPage").html(startPage+1);
	});
	//上一页
	$(".op_prePage").click(function(){
		startPage=(startPage-1);
		if(startPage<0){
			startPage=0;
			return;
		}
		getOperateLog(startPage*showCout,showCout);
		$(".op_curPage").html(startPage+1);
	});
	//首页
	$(".op_firstPage").click(function(){
		 startPage=0;
		 getOperateLog(startPage*showCout,showCout);
		 $(".op_curPage").html(startPage+1);
	});
	//末页
	$(".op_lastPage").click(function(){
		startPage=count-1;
		getOperateLog(startPage*showCout,showCout);
		 $(".op_curPage").html(startPage+1);
	});
	
	
	//报警日志
	$(".btnWarnSearch").click(function(){ 
		getWarningLog(startPage,showCout);
	});
	//下一页
	$(".warn_nextPage").click(function(){
		startPage=(startPage+1);
		//alert(count);
		if(startPage>=count){
			startPage=count-1;
			return;
		}
		getWarningLog(startPage*showCout,showCout);
		$(".warn_curPage").html(startPage+1);
	});
	//上一页
	$(".warn_prePage").click(function(){
		startPage=(startPage-1);
		if(startPage<0){
			startPage=0;
			return;
		}
		getWarningLog(startPage*showCout,showCout);
		$(".warn_curPage").html(startPage+1);
	});
	//首页
	$(".warn_firstPage").click(function(){
		 startPage=0;
		 getWarningLog(startPage*showCout,showCout);
		 $(".warn_curPage").html(startPage+1);
	});
	//末页
	$(".warn_lastPage").click(function(){
		startPage=count-1;
		getWarningLog(startPage*showCout,showCout);
		 $(".warn_curPage").html(startPage+1);
	});
	
	//系统日志重置
	$(".btnSysReset").click(function(){
		
		$("input[name=\"depName\"]").val("");
		$("input[name=\"userName\"]").val("");
		$("input[name=\"startTime_sys\"]").val("");
		$("input[name=\"endTime_sys\"]").val("");
		
	});
	
	$(".btnOpReset").click(function(){
		$("input[name=\"depName_op\"]").val("");
		$("input[name=\"userName_op\"]").val("");
		$("input[name=\"startTime_op\"]").val("");
		$("input[name=\"endTime_op\"]").val("");
	});
	
	$(".btnWarnReset").click(function(){
		$("input[name=\"warningType\"]").val("");
		$("input[name=\"warningFrom\"]").val("");
		$("input[name=\"startTime_warn\"]").val("");
		$("input[name=\"endTime_warn\"]").val("");
	});
	
});


</script>
<!-- 系统日志 -->
<script id="sysContentTemplate" type="text/x-jquery-tmpl">
<tr>
	<td width="10%">{{= id}}</td>
	<td width="20%">{{= showTime}}</td>
	<td>{{= content}}</td>
	<td width="15%">{{= depName}}</td>
	<td width="15%">{{= userName}}</td>
</tr>
</script>
<!-- 报警日志 -->
<script id="warnContentTemplate" type="text/x-jquery-tmpl">
<tr>
	<td width="10%">{{= id}}</td>
	<td width="20%">{{= showTime}}</td>
	<td>{{= content}}</td>
	<td width="15%">{{= warningFrom}}</td>
</tr>
</script>

</head>
<body>
<div id="all">
	<div id="top">
	</div>
	<div id="menu">
		<!-- 登录人信息 -->
		<jsp:include page="../include/menu.jsp" flush="true" /> 
	</div>
	<div id="main">
		<!-- 部门模块 -->
		<div id="main_left">
			<div class="main_time">
				<div class="time_time">09:41</div>
				<div class="time_date">2014/03/11</div>
			</div>
			<div id="left_list">
				<div id="list_ul">
					<ul>
						
						<li><font>系统日志</font>
							<div class="grpbtn" lang="xtrz">
							</div>
						</li>
						<li><font>操作日志</font>
							<div class="grpbtn" lang="czrz">
							</div>
						</li>
						<li><font>报警日志</font>
							<div class="grpbtn" lang="bjrz">
							</div>
						</li>
					</ul>
				</div>
			</div>
		</div>
		<div id="main_right">
			<div id="xtrz">
				<div id="right_menu">
					<table width="100%">
						<tr>
							<td width="10%">部门名称:</td>
							<td width="40%" align="left">
								<input type="text" name="depName">
							</td>
							<td width="10%">用户姓名:</td>
							<td width="15%">
								<input type="text" name="userName">
							</td>
							<td>
								<input type="image" src="images/log/reset.png" class="btnSysReset">
							</td>
						</tr>
						<tr>
							<td>开始时间:</td>
							<td align="left">
								<input name="startTime_sys" onClick="WdatePicker({startDate:'%y-%M-01 00:00:00',dateFmt:'yyyy-MM-dd HH:mm:ss',alwaysUseStartDate:true})" class="Wdate">
							</td>
							<td>结束时间:</td>
							<td align="left">
								<input name="endTime_sys" onClick="WdatePicker({startDate:'%y-%M-01 00:00:00',dateFmt:'yyyy-MM-dd HH:mm:ss',alwaysUseStartDate:true})" class="Wdate">
							</td>
							<td>
								<input type="image" src="images/log/search.png" class="btnSysSearch">
							</td>
						</tr>
					</table>
				</div>
				<!-- IDV right_menu end -->
				<div id="right_info">
					<div id="info_title">
						<table width="100%">
							<tr>
								<td width="10%">编号</td>
								<td width="20%">时间</td>
								<td>内容</td>
								<td width="15%">所属部门</td>
								<td width="15%">用户</td>
							</tr>
						</table>
					</div>
					<div id="info_detail">
						<table width="100%" id="sys_log_container">
						</table>
					</div>
					<div id="info_page">
						<table width="100%">
							<tr>
								<td align="left"></td>
								<td align="right">
									第&nbsp;<label class="curPage">1</label>/<label class="countPage">&nbsp;12</label>页
									<label class="sys_firstPage">&nbsp;&nbsp;首页&nbsp;&nbsp;</label>
									<label class="sys_prePage">上一页&nbsp;&nbsp;</label>
									<label class="sys_nextPage">下一页&nbsp;&nbsp;</label>
									<label class="sys_lastPage">&nbsp;&nbsp;末页&nbsp;&nbsp;</label>
								</td>
							</tr>
						</table>
					</div>
					<!-- DIV info_page end -->
				</div>
				<!-- DIV right_info end-->
			</div>
			<!-- DIV xtrz(系统日志) end -->
			<!-- 操作日志 -->
			<div id="czrz">
				<div id="right_menu">
					<table width="100%">
						<tr>
							<td width="10%">部门名称:</td>
							<td width="40%" align="left">
								<input type="text" name="depName_op">
							</td>
							<td width="10%">用户姓名:</td>
							<td width="15%">
								<input type="text" name="userName_op">
							</td>
							<td>
								<input type="image" src="images/log/reset.png" class="btnOpReset">
							</td>
						</tr>
						<tr>
							<td>开始时间:</td>
							<td align="left">
								<input name="startTime_op" onClick="WdatePicker({startDate:'%y-%M-01 00:00:00',dateFmt:'yyyy-MM-dd HH:mm:ss',alwaysUseStartDate:true})" class="Wdate">
							</td>
							<td>结束时间:</td>
							<td align="left">
								<input name="endTime_op" onClick="WdatePicker({startDate:'%y-%M-01 00:00:00',dateFmt:'yyyy-MM-dd HH:mm:ss',alwaysUseStartDate:true})" class="Wdate">
							</td>
							<td>
								<input type="image" src="images/log/search.png" class="btnOpSearch">
							</td>
						</tr>
					</table>
				</div>
				<!-- IDV right_menu end -->
				<div id="right_info">
					<div id="info_title">
						<table width="100%">
							<tr>
								<td width="10%">编号</td>
								<td width="20%">时间</td>
								<td>内容</td>
								<td width="15%">所属部门</td>
								<td width="15%">用户</td>
							</tr>
						</table>
					</div>
					<div id="info_detail">
						<table width="100%" id="op_log_container">
						</table>
					</div>
					<div id="info_page">
						<table width="100%">
							<tr>
								<td align="left"></td>
								<td align="right">
									第&nbsp;<label class="op_curPage">1</label>/<label class="op_countPage">&nbsp;0</label>页
									<label class="op_firstPage">&nbsp;&nbsp;首页&nbsp;&nbsp;</label>
									<label class="op_prePage">上一页&nbsp;&nbsp;</label>
									<label class="op_nextPage">下一页&nbsp;&nbsp;</label>
									<label class="op_lastPage">&nbsp;&nbsp;末页&nbsp;&nbsp;</label>
								</td>
							</tr>
						</table>
					</div>
					<!-- DIV info_page end -->
				</div>
				<!-- DIV right_info end-->
			</div>
			<!-- DIV czrz(操作日志) end -->
			<!-- DIV 报警日志 start -->
			<div id="bjrz">
				<div id="right_menu">
					<table width="100%">
						<tr>
							<td width="10%">报警类型:</td>
							<td width="40%" align="left">
								<input type="text" name="warningType">
							</td>
							<td width="10%">报警内容</td>
							<td width="15%">
								<input type="text" name="warningFrom">
							</td>
							<td>
								<input type="image" src="images/log/reset.png" class="btnWarnReset">
							</td>
						</tr>
						<tr>
							<td>开始时间:</td>
							<td align="left">
								<input name="startTime_warn" onClick="WdatePicker({startDate:'%y-%M-01 00:00:00',dateFmt:'yyyy-MM-dd HH:mm:ss',alwaysUseStartDate:true})" class="Wdate">
							</td>
							<td>结束时间:</td>
							<td align="left">
								<input name="endTime_warn" onClick="WdatePicker({startDate:'%y-%M-01 00:00:00',dateFmt:'yyyy-MM-dd HH:mm:ss',alwaysUseStartDate:true})" class="Wdate">
							</td>
							<td>
								<input type="image" src="images/log/search.png" class="btnWarnSearch">
							</td>
						</tr>
					</table>
				</div>
				<!-- IDV right_menu end -->
				<div id="right_info">
					<div id="info_title">
						<table width="100%">
							<tr>
								<td width="10%">编号</td>
								<td width="20%">时间</td>
								<td>内容</td>
								<td width="15%">设备名称</td>
							</tr>
						</table>
					</div>
					<div id="info_detail">
						<table width="100%" id="warn_log_container">
						</table>
					</div>
					<div id="info_page">
						<table width="100%">
							<tr>
								<td align="left"></td>
								<td align="right">
									第&nbsp;<label class="warn_curPage">1</label>/<label class="warn_countPage">&nbsp;0</label>页
									<label class="warn_firstPage">&nbsp;&nbsp;首页&nbsp;&nbsp;</label>
									<label class="warn_prePage">上一页&nbsp;&nbsp;</label>
									<label class="warn_nextPage">下一页&nbsp;&nbsp;</label>
									<label class="warn_lastPage">&nbsp;&nbsp;末页&nbsp;&nbsp;</label>
								</td>
							</tr>
						</table>
					</div>
					<!-- DIV info_page end -->
				</div>
				<!-- DIV right_info end-->
			</div>
			<!-- DIV 报警日志 end -->
		</div>
		<!--DIV main_right end  -->
	</div>
	
	<div id="foot">
		<label style="line-height: 40px;">公安部第三研究所</label>
	</div>
</div>

</body>
</html>