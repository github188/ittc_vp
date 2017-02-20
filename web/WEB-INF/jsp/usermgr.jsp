<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户管理</title>
<!-- 菜单css -->
<link href="styles/menu.css" rel="stylesheet" type="text/css" media="screen" />
<link href="styles/usermgr.css" rel="stylesheet" type="text/css" media="screen" />
<style type="text/css">

</style>
<script type="text/javascript" src="scripts/jquery-1.8.1.js"></script>
<script type="text/javascript" src="scripts/jquery.ui.draggable.js"></script> 
<script type="text/javascript" src="scripts/jquery.alerts.js" ></script>
<link href="scripts/jquery.alerts.css" rel="stylesheet" type="text/css" media="screen" />

<!-- jquery模板 -->
<script src="scripts/jquery.tmpl.js" type="text/javascript"></script>
<!--zxxbox  -->
<script type="text/javascript" src="scripts/jquery.zxxbox.3.0.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	//catch the right-click context menu
	$(document).bind("contextmenu",function(e) {//右键禁用			 
		//warning prompt - optional
		//alert("No right-clicking!");
		//delete the default context menu
		return false;
	});
	
	function getAllDep(){
		//异步加载部门数据
		$.ajax({
			url:"json_UserAction_getAllDep.action",
			//data:"",
			type:"POST",
			dataType:"json",
			cache:false,
			success:function(json){
				 var jsonData=eval("("+json+")");//转换为json对象 
				 $("#list_ul_container").empty();
				 $("#depTmpl").tmpl(jsonData.data).appendTo("#list_ul_container");
				 $("#addUserDepContent").empty();
				 $("#adduser_dep_tmpl").tmpl(jsonData.data).appendTo("#addUserDepContent");
				 DEPID=jsonData.data[0].depId;
				 getUserByDep(DEPID,startPage,showNum);
			},error:function(){
				jAlert("网络数据异常！","提示");
			},complete:function(){
				//组别背景切换
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
					//alert(DEPID);
					if(DEPID==$(this).find(".grpbtn").attr("lang")){
						
					}else{
						startPage=0;
						$(".curPage").html(1);
					}
					DEPID=$(this).find(".grpbtn").attr("lang");
					getUserByDep(DEPID,startPage,showNum);
					
				});
				
				//部门添加
				$(".grpbtn input:first-child,.addgrp").click(function(){
					$("#addDepDiv").zxxbox({
						bar: false,
					    bgclose: true
					});
				});
				//部门删除
				$(".grpbtn input:last-child").click(function(){
					
					var depId=$(this).parent().attr("lang");
					var depName=$(this).parent().attr("depName");
					//alert(depName);
					jConfirm("确定删除该部门及所有的成员？","提示",function(t){
						if(t){
							delDepById(depId,depName);
						}
					});
				});
			}
		});
	}


	function getUserByDep(depId,startPage,showNum){
		$.ajax({
			url:"json_UserAction_getUserByDep.action",
			data:"userModel.depId="+depId+"&userModel.startPage="+startPage+"&userModel.showNum="+showNum,
			type:"POST",
			dataType:"json",
			cache:false,
			success:function(json){//加载该部门的成员成功
				var jsonData=eval("("+json+")");//转换为json对象 
				$("#contactContainer").empty();
				$("#contactTemplate").tmpl(jsonData.data).appendTo("#contactContainer");
				count=jsonData.count;
				$(".countPage").html(count);
				
				if(count==0){
					$(".curPage").html(0);
				}
				//$(".curPage").html(startPage+1);
			},error:function(){//加载该部门的成员失败
				jAlert("网络数据加载异常！","提示");
			},complete:function(){//加载该部门的成员完成
				//var userId=0;
				//鼠标移入、移除和点击效果
				$("#main_right .right_table table tbody tr").hover(function(){
					if($(this).css("background-image").indexOf("checked")>0){
						return;
					}
					$(this).css("background-image","url('images/usermgr/move_bg.jpg')").css("cursor","pointer");
				},function(){
					if($(this).css("background-image").indexOf("checked")>0){
						return;
					}
					$(this).css("background-image","none");
				}).click(function(){
					//循环去掉背景
					$("#main_right .right_table table tbody tr").each(function(){
						$(this).css("background-image","none");
					});
					
					$(this).css("background-image","url('images/usermgr/checked.jpg')");
					editUserId=$(this).find("input[type=checkbox]").val();
					//alert(editUserId);
				});
				
				//表格 编辑组
				$(".right_table").find(".edituser").click(function(){
					
					var userId=$(this).parent().attr("lang");
					////
					//alert(userId);
					getUserById(userId);
					
					$("#addUserDiv").zxxbox({
						bar: false,
					    bgclose: true
					});
					addUserSave();
				});
				//表格 删除组
				$(".right_table").find(".deluser").click(function(){
					var userId=$(this).parent().attr("lang");
					var userName=$(this).parent().attr("tag");
					
					jConfirm("确定删除成员‘"+userName+"’？","提示",function(t){
						if(t){
							delUserById(userId,depId,userName);
							jAlert("成员‘"+userName+"’删除成功","提示");
						}
					});
				});
				
				//导出
				$(".table_page").find(".export").click(function(){
					//jAlert("亲，导出功能，小编正在努力为您研发中，请继续关注哦！","温馨提示");
					
					var page1_msg=$("input[name='startPage']").val();
					var page2_msg=$("input[name='endPage']").val();
					if(page1_msg==""||page2_msg==""||isNaN(page1_msg)||isNaN(page2_msg)||page1_msg<=0||page2_msg<=0){
						jAlert("请正确输入导出的页码","提示");
						return false;
					}
					if(page2_msg-page1_msg<0){
						jAlert("前面的页面应小于后面的页面!","提示");
						return false;
					}
					if(page2_msg-page1_msg>100){
						jAlert("最多只能导出100页!","提示");
						return false;
					}
					////var startTime_dev,endTime_dev,areaName_dev,typeName_dev,devName_dev,paraName_dev;
					//$("input[name='userModel.startTime']").val(startTime_msg);
				
					$("input[name='userModel.depId']").val(DEPID);
					$("input[name='userModel.startPage']").val((page1_msg-1)*showNum);
					$("input[name='userModel.showNum']").val(page2_msg*showNum);
					
					$(this).parent("form").submit();
					
					
				});
			
				// 按钮 删除组
				$(".right_btn").find(".deluser").click(function(){
					var userIds="";
					$("#contactContainer").find("input[type=checkbox]").each(function(){
						if($(this).attr("checked")=="checked"){
						userIds=userIds+"&userIds="+$(this).val();
						}
					});
					if(userIds==""){
						jAlert("请选择你想删除的成员！","提示");
						return;
					}
					jConfirm("确定删除这些用户？","提示",function(t){
						if(t){
							$.ajax({
								url:"json_UserAction_delUsers.action",
								data:"userIds=0"+userIds,
								type:"POST",
								dataType:"json",
								cache:false,
								error:function(){
									jAlert("网络异常,删除失败","提示");
								},success:function(json){
									jAlert("删除成功!","提示");
								},complete:function(){
									getUserByDep(depId,startPage,showNum);
									
								}
							});
							
						}
					});
				});
			}
		});
	}
	/**删除部门**/
	function delDepById(depId,depName){
		$.ajax({
			url:"json_UserAction_delDepById.action",
			data:"departmentModel.depId="+depId+"&departmentModel.depName="+depName,
			type:"POST",
			dataType:"json",
			cache:false,
			error:function(){
				jAlert("网络异常,删除失败","提示");
			},success:function(json){
				jAlert("删除成功!","提示");
			},complete:function(){
				getAllDep();
			}
		});
	}
	/**删除用户**/
	function delUserById(userId,depId,userName){
		$.ajax({
			url:"json_UserAction_delUserById.action",
			data:"userModel.isDel=1&userModel.userId="+userId+"&userModel.userName="+userName,
			type:"POST",
			dataType:"json",
			cache:false,
			error:function(){
				jAlert("网络异常,成员‘"+userName+"’删除失败","提示");
			},success:function(json){
				//jAlert("成员‘"+userName+"’删除成功","提示");
				
			},complete:function(){
				getUserByDep(depId,startPage,showNum);
			}
		});
	}
	


	function userValClear(){
		$("input[name=\"userId\"]").val("");
		$("input[name=\"loginName\"]").val("");
		$("input[name=\"userName\"]").val("");
		$("select[name=\"userType\"]").val("");
		$("#addUserDepContent").val("");
	}
	
	function depValClear(){
		$("input[name=\"departmentModel.depName\"]").val("");
		$("input[name=\"departmentModel.depDesc\"]").val("");
	}
	/**获取用户信息**/
	function getUserById(userId){
		$("#addUserDiv").zxxbox({
			bar: false,
		    bgclose: true
		}).find("font").html("编辑用户");

		//加载数据
		$.ajax({
			url:"json_UserAction_getUserById.action",
			data:"userModel.userId="+userId,
			cache:false,
			type:"POST",
			success:function(json){

				var jsonData=eval("("+json+")");//转换为json对象 
			
				var data=jsonData.data;
				$("input[name=\"userId\"]").val(data.userId);
				$("input[name=\"loginName\"]").val(data.loginName);
				$("input[name=\"userName\"]").val(data.userName);
				$("select[name=\"userType\"]").val(data.userType);
				$("#addUserDepContent").val(data.depId);
				//alert(data.userName);
			},error:function(){
				
			},complete:function(){
				
			}
		});
		$("#initPwdBtn").show();
	}
	
	function addUserSave(){
		$("#addUserOKBtn").unbind("click");
		$("#addUserCancelBtn").unbind("click");
		$("#addUserCancelBtn").click(function(){
			$.zxxbox.hide();
		});
		
		//初始化密码
		$("#initPwdBtn").click(function(){
			var userId=$("input[name=\"userId\"]").val();
			//alert(userId);
			$.ajax({
				url:"json_UserAction_initPwd.action",
				data:"userModel.userId="+userId,
				cache:false,
				type:"POST",
				success:function(){
					jAlert("密码重置成功！","提示");
					$.zxxbox.hide();
				},error:function(){
					jAlert("网络异常！","提示");
				}
			});
			
		});
		//添加用户
		$("#addUserOKBtn").click(function(){
			//alert("123");
			var userId=$("input[name=\"userId\"]").val();
			var loginName=$("input[name=\"loginName\"]").val();
			var userName=$("input[name=\"userName\"]").val();
			var userType=$("select[name=\"userType\"]").val();
			var depId=$("#addUserDepContent").val();
			var url="";
			if(userId==""){
				url="json_UserAction_addUser.action";
			}else{
				url="json_UserAction_modifyUser.action?userModel.userId="+userId;
			}
			$.ajax({
				url:url,
				data:"userModel.depId="+depId+"&userModel.loginName="+encodeURI(loginName)+"&userModel.userName="+encodeURI(userName)+"&userModel.userType="+userType,
				cache:false,
				type:"POST",
				success:function(){
					if(userId==""){
						jAlert("添加成功","提示");
					}else{
						jAlert("修改成功","提示");
					}
					
				},error:function(){
					
				},complete:function(){
					$.zxxbox.hide();
					getUserByDep(depId,startPage,showNum);
					userValClear();
				}
			});
			
			//userValClear();
		});
	}
	
	muneLink();
	getAllDep();
	addUserSave();//保存用户
	getDate();
	window.setInterval(getDate,1000);  //每隔一秒显示时间 
	
	$("#menu_right img").eq(4).attr("src","images/home/usermgr_pressed.png");
	
	$("#menu_right img").hover(function(){
		if($(this).attr("src")=="images/home/usermgr_pressed.png"){
			return;
		}
		var src=$(this).attr("src").replace(".jpg",".png");
		$(this).attr("src",src).css("cursor","pointer");
	},function(){
		if($(this).attr("src")=="images/home/usermgr_pressed.png"){
			return;
		}
		var src=$(this).attr("src").replace(".png",".jpg");
		$(this).attr("src",src);
	});

	//添加部门
	
	//添加用户
	$(".right_btn").find(".adduser").click(function(){
		$("#addUserDiv").zxxbox({
			bar: false,
		    bgclose: true
		}).find("font").html("添加用户");
		$("#initPwdBtn").hide();
	});
	
	//按钮 编辑用户
	var editUserId=0;
	$(".right_btn").find(".edituser").unbind( "click" );
	$(".right_btn").find(".edituser").click(function(){

		if(editUserId==0){
			jAlert("请选择编辑的用户！","提示");
			return;
		}
		getUserById(editUserId);
	});
	
	//添加部门  --取消
	$("#addDepCancelBtn,#addUserCancelBtn").click(function(){
		 $.zxxbox.hide();
		 depValClear();
		 userValClear();
	});

	
	//添加部门--确认
	$("#addDepOKBtn").click(function(){
		var depName=$("input[name=\"departmentModel.depName\"]").val();
		var depDesc=$("input[name=\"departmentModel.depDesc\"]").val();
		
		$.ajax({
			url:"json_UserAction_addDepartment.action",
			data:"departmentModel.depName="+encodeURI(depName)+"&departmentModel.depDesc="+encodeURI(depDesc),
			cache:false,
			type:"POST",
			success:function(){
				
				jAlert("添加成功","提示");
				
			},error:function(){
				
			},complete:function(){
				$.zxxbox.hide();
				getAllDep();
				depValClear();
			}
		});
		
	});
	
	var startPage=0;
	var showNum=10;
	var count=0;
	var DEPID=1;
	
	//首页
	$(".firstPage").click(function(){
		 startPage=0;
		 $(".curPage").html(startPage+1);
		 getUserByDep(DEPID,startPage*showNum,showNum);
	});
	//上一页
	$(".prePage").click(function(){
		startPage=startPage-1;
		if(startPage<=0){
			startPage=0;
		}
		$(".curPage").html(startPage+1);
		getUserByDep(DEPID,startPage*showNum,showNum);
	});
	//下一页
	$(".nextPage").click(function(){
		//alert(startPage+","+count);
		
		if(startPage+1>=count){
			return;
		}
		
		startPage=startPage+1;
		$(".curPage").html(startPage+1);
		getUserByDep(DEPID,startPage*showNum,showNum);
	});
	//尾页
	$(".lastPage").click(function(){
		
		startPage=count-1;
		$(".curPage").html(count);
		getUserByDep(DEPID,startPage*showNum,showNum);
	});
	
	$(".table_page").find("label").hover(function(){
		$(this).css("cursor","pointer").css("color","#55daed");
	},function(){
		$(this).css("color","white");
	});
	
	
	
	
});

</script>
<!-- 用户 -->
<script id="contactTemplate" type="text/x-jquery-tmpl">
{{if userType!=0}}
<tr>
	<td style="width: 90px"><input type=checkbox value={{= userId}} >{{= rownum}} </td>
	<td style="width: 140px">{{= loginName}}</td>
	<td style="width: 211px">${'${'}userName}</td>
	<td style="width: 205px">
			普通用户
	</td>
	<td lang=${'${'}userId} tag={{= userName}}>
			<input class="edituser" title="编辑" type="image" src="images/usermgr/pencil.png">
			<input class="deluser" title="移除" type="image" src="images/usermgr/litterbin.png">
			
	</td>
</tr>
{{/if}}
</script>
<script id="contactTemplate_bak" type="text/x-jquery-tmpl">
<tr>
	<td style="width: 90px"><input type=checkbox value={{= userId}} >{{= rownum}} </td>
	<td style="width: 140px">{{= loginName}}</td>
	<td style="width: 211px">${'${'}userName}</td>
	<td style="width: 205px">
		{{if userType==0}}
			管理员
		{{else userType==1}}
			操作员
		{{else}}
			监控员
		{{/if}}
	</td>
	<td lang=${'${'}userId} tag={{= userName}}>
			<input class="edituser" title="编辑" type="image" src="images/usermgr/pencil.png">
			<input class="deluser" title="移除" type="image" src="images/usermgr/litterbin.png">
			
	</td>
</tr>

</script>
<!-- 部门 -->
<script type="text/x-jquery-tmpl" id="depTmpl">
<li>
<font>${'${'}depName}</font>
<div class="grpbtn" lang={{= depId}} depName={{= depName}}>
	<input type="image" src="images/usermgr/addgrp.png" title="添加新组">
	<input type="image" src="images/usermgr/removegrp.png" title="删除该组">
</div>
</li>
</script>
<!-- 添加用户  部门 -->
<script type="text/x-jquery-tmpl" id="adduser_dep_tmpl">
<option value={{= depId}} > {{= depName}} </option>
</script>

</head>
<body>
<!-- 最大的DIV -->
<div id="all">
	<!-- 标题 -->
	<div id="top">
	</div>
	<!-- 主菜单 -->
	<div id="menu">
		<!-- 登录人信息 -->
		<jsp:include page="../include/menu.jsp" flush="true" /> 
		
	</div>
	<!-- 主内容 -->
	<div id="main">
		<!-- 部门模块 -->
		<div id="main_left">
			<div class="main_time">
				<div class="time_time">09:41</div>
				<div class="time_date">2014/03/11</div>
			</div>
			<div id="left_list">
				<div id="list_zb">
					<img alt="组别" src="images/usermgr/zb.jpg">
				</div>
				<div id="list_ul">
					<ul id="list_ul_container">
	
					</ul>
				</div>
				
			</div>
		</div>
		<div id="main_padding"></div>
		<!-- 组成员明细 -->
		<div id="main_right">
			<div class="right_btn">
				<ul>
					<li><input class="addgrp" alt="添加组" type="image" src="images/usermgr/add.png" title="添加组"></li>
					<li><input class="adduser" alt="添加用户" type="image" src="images/usermgr/adduser.png" title="添加用户"></li>
					<li><input class="edituser"alt="编辑" type="image" src="images/usermgr/edituser.png" title="编辑"></li>
					<li><input class="deluser" alt="删除" type="image" src="images/usermgr/removeuser.png" title="删除"></li>
				
				</ul>
			</div>
			<div class="right_table">
				<table >
					<tbody id="contactContainer">
					</tbody>
					
				</table>
			</div>
			<div class="table_page">
				<form action="download_userInfo.action" method="post">
				<table>
					<tr>
						<td style="width: 170px;">从
							<input style="width: 30px" name="startPage">--
							<input style="width: 30px" name="endPage">页
						</td>
						<td style="width: 65px;">
							
								<input type="hidden" name="fileName" value="用户配置.xlsx">
								<input type="hidden" name="userModel.depId">
								<input type="hidden" name="userModel.startPage">
								<input type="hidden" name="userModel.showNum">
								
								<input class="export" type="image" src="images/usermgr/export.png" title="导出">
							
						</td>
						<td align="right" style="width: 383px;">
							第<label class="curPage">1</label>/<label class="countPage">20</label>页
						</td>
						<td style="width: 40px;" class="firstPage"><label>首页</label></td>
						<td style="width: 50px;" class="prePage"><label>上一页</label></td>
						<td style="width: 50px;" class="nextPage"><label>下一页</label></td>
						<td class="lastPage"><label>尾页</label></td>
					</tr>
				</table>
				</form>	
			</div>
			<div>
				
			</div>
		</div>
	</div>
	
	<div id="foot">
		<label style="line-height: 40px;">公安部第三研究所</label>
		
	</div>
</div >

<!-- 添加部门 -->
<div class="zxxboxHide" id="addDepDiv" style="background-image: url('images/usermgr/tjbm_bg.png'); width: 376px;height: 264px;text-align: center;margin: 0 auto;">
	<div style="width: 376px;height: 50px">
		<font style="line-height: 50px;"> 添加部门</font>
	</div>
	<div style="text-align: center;width: 260px;height: 190px;margin: 0 auto;">
		<table style="width: 260px;height: 190px;">
			<tr>
				<td>部门名称:</td>
				<td><input name="departmentModel.depName"></td>
			</tr>
			<tr>
				<td>部门描述:</td>
				<td><input name="departmentModel.depDesc"></td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="image" src="images/usermgr/tjbm_qr.png" id="addDepOKBtn">
					<input type="image" src="images/usermgr/tjbm_qx.png" id="addDepCancelBtn">
				</td>
			</tr>
		</table>
	</div>
</div>

<!-- 添加用户 -->
<div class="zxxboxHide"  id="addUserDiv" style="background-image:url('images/usermgr/tjyh_bg.png');width:611px;height: 277px; text-align: center;margin: 0 auto; ">
	<div style="text-align: center;width: 611px;height: 50px;">
		
		<font style="line-height: 50px;"> 添加用户</font>
	</div>
	<div style="text-align: center;width: 550px;height: 220px;margin: 0 auto;">
		<table style="width: 550px;height: 210px">
			<tr>
				<td>登陆名称:<input type="hidden" name="userId"></td>
				<td><input name="loginName" style="width: 180px; height: 23px;"></td>
				<td>用户名称:</td>
				<td><input name="userName" style="width: 180px; height: 23px;"></td>
			</tr>
			<tr>
				<td>用户类型:</td>
				<td>
					<select disabled="disabled" name="userType" style="width: 180px; height: 30px;" >
						<option value="0">管理员</option>
						<option value="1" selected="selected">操作员</option>
						<option value="2">监控员</option>
						<option value="3">普通用户</option>
					</select>
				</td>
				<td>所属部门:</td>
				<td>
					<select id="addUserDepContent" name="depIp" style="width: 180px; height: 30px;">
						
					</select>
				</td>
			</tr>
			<tr>
				<td><input id="initPwdBtn" type="image" src="images/usermgr/tjyh_czmm.png"></td>
				
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>
					<input type="image" src="images/usermgr/tjyh_qr.png" id="addUserOKBtn">
					<input type="image" src="images/usermgr/tjyh_qx.png" id="addUserCancelBtn">
				</td>
			</tr>
		</table>
	</div>
</div>

</body>
</html>