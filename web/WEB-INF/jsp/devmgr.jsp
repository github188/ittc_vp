<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>设备配置</title>
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
/*摄像机组列表*/
#main_left #left_list{
	width: 250px;
	height: 580px;
	float: left;
}
#main_padding{
	width: 40px;
	height: 675px;
	float: left;
}

#left_list #list_zb{
	float: left;
	height: 50px;
	width: 239px;
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

#main_left #left_list ul li .grpbtn{
	float:right;
	width: 70px;
	margin-right: 27px;
	margin-top:16px;
	display: none;
}

#main_right{
	width: 840px;
	height: 675px;
	float: left;
}

#main_right .right_title{
	width: 829px;
	height: 36px; 
	float: left;
	background-image: url("images/devmgr/table_title.png");
	margin-top: 60px;
}

#main_right .right_title input{
	float: left;
	margin-left: 5px;
	margin-top: 5px;
	width: 18px;
	height: 18px;
}

#main_right .right_table{
	width: 834px;
	height: 545px;
	float: left;
	background-image: url("images/devmgr/table_bg.jpg");
}
#main_right .table_content{
	width: 834px;
	height:470px;
	float: left;
	overflow-y:auto;
	overflow-x: hidden;
	scrollbar-3d-light-color:#303030;
	scrollbar-arrow-color:black;
	scrollbar-base-color:#1A1A1A;
	scrollbar-face-color:white;
}
.right_table table {
	width: 834px;
	float: left;
}
#main_right .table_page{
	float:left;
	width: 830px;
}

.table_cz{
	width: 220px;
	float: left;
}


#copyCameraDiv,#cutCameraDiv{
	width: 270px;
	height:300px;
	background-color: #add1db;
	display: none;
	text-align:center;
	margin:0 auto;
}
.addCameraDiv{
	display: none;
}

#Tab{margin:0 auto;width:460px;border:1px solid #BCE2F3;height: 300px;}
.Menubox{height:28px;border-bottom:1px solid #64B8E4;background:#E4F2FB;}
.Menubox ul{list-style:none;margin:7px 40px;padding:0;position:absolute;}
.Menubox ul li{float:left;background:#64B8E4;line-height:20px;display:block;cursor:pointer;width:100px;text-align:center;color:#fff;font-weight:bold;border-top:1px solid #64B8E4;border-left:1px solid #64B8E4;border-right:1px solid #64B8E4;}
.Menubox ul li.hover{background:#fff;border-bottom:1px solid #fff;color:#147AB8;}
.Contentbox{color: black;}
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
	
	var cutGrpCameraId=-1;
	var copyGrpCameraId=-1;
	var grpIdLeft=1;//摄像机组ID
	//catch the right-click context menu
	$(document).bind("contextmenu",function(e) {//右键禁用			 
		//warning prompt - optional
		//alert("No right-clicking!");
		//delete the default context menu
		return false;
	});
	
	//加载所有的摄像机组
	function loadCameraGrp(){
		$.ajax({
			url:"json_CameraAction_loadCameraGrp.action",
			data:"",
			type:"POST",
			dataType:"json",
			cache:false,
			success:function(json){
				//alert(json);
				 var jsonData=eval("("+json+")");//转换为json对象 
				 jsonDataG=jsonData;
				// alert(jsonData);
				 $("#list_ul_container").empty();
				 $("#grpTemplate").tmpl(jsonData.data).appendTo("#list_ul_container");
				 getCamareByGrpId(jsonData.data[0].grpId);
				 
				 
				 // 复制摄像机
				 $("#copyCameraContent").empty();
				 $("#copyCameraTemplate").tmpl(jsonData.data).appendTo("#copyCameraContent");
				 
				 //剪切摄像机
				 $("#cutCameraContent").empty();
				 $("#cutCameraTemplate").tmpl(jsonData.data).appendTo("#cutCameraContent");
				 
				
				//摄像机组添加
				$(".grpbtn input:first-child").click(function(){
					
					$("#addGrpDiv").zxxbox({
						bar: false,
						bgclose: true
					});
					
				});
				
				//摄像机组删除
				$(".grpbtn input:last-child").click(function(){
					
					var grpId=$(this).parent().attr("lang");
					//alert(grpId);
					jConfirm("确定删除该组及所有的摄像机？","提示",function(t){
						if(t){
							delGrpById(grpId);
						}
					});
				});
				
			},error:function(){
				jAlert("网络异常！","提示");
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
					grpIdLeft= $(this).find(".grpbtn").attr("lang");
					getCamareByGrpId(grpIdLeft);
				});
			}
			
		});
	}
	
	
	function delGrpById(grpId){
		$.ajax({
			url:"json_CameraAction_delCameraGrpById.action",
			data:"cameraModel.grpId="+grpId,
			type:"POST",
			dataType:"json",
			cache:false,
			error:function(){
				jAlert("网络异常,删除失败","提示");
			},success:function(json){
				jAlert("删除成功!","提示");
			},complete:function(){
				loadCameraGrp();
			}
		});
	}
	
	function getCamareByGrpId(grpId){
		$.ajax({
			url:"json_CameraAction_getCameraByGrp.action",
			data:"cameraGrpModel.grpId="+grpId,
			type:"POST",
			dataType:"json",
			cache:false,
			success:function(json){
				 var jsonData=eval("("+json+")");//转换为json对象 
				 jsonDataG=jsonData;
				 //各组的相机列表
				 $("#camera_list_container").empty();
				 $("#cameraTemplate").tmpl(jsonData.data).appendTo("#camera_list_container");
				 
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
				});
			},error:function(){
				jAlert("网络异常！","提示");
			},complete:function(){
				
				//复制摄像机
				$(".copyCamera").click(function(){
					copyGrpCameraId=$(this).attr("cameraId");
					//alert(copyGrpCameraId);
					$("#copyCameraDiv").zxxbox({
						bar: false,
					    bgclose: true
					});
				});
				//剪切摄像机
				$(".cutCamera").click(function(){
					//alert("cut");
					cutGrpCameraId=$(this).attr("lang");
					$("#cutCameraDiv").zxxbox({
						bar: false,
					    bgclose: true
					});
				});
				//删除摄像机
				$(".delCamera").click(function(){
					var cameraName=$(this).attr("cameraName");
					var cameraId=$(this).attr("lang");
					jConfirm("确定删除摄像机‘"+cameraName+"’？","提示",function(t){
						if(t){
							$.ajax({
								url:"json_CameraAction_delGrpCamera.action",
								data:"cameraGrpModel.id="+cameraId,
								type:"POST",
								dataType:"json",
								cache:false,
								success:function(){
									jAlert("摄像机‘"+cameraName+"’删除成功","提示");
								},error:function(){
									jAlert("网络异常！","提示");
								},complete:function(){
									getCamareByGrpId(grpId);
								}
							});
							
						}
					});
				});
				
			}
		});
	}
	muneLink();
	getDate();
	window.setInterval(getDate,1000);  //每隔一秒显示时间 
	
	loadCameraGrp();
	
	$("#menu_right img").eq(3).attr("src","images/home/devmgr_pressed.png");
	
	$("#menu_right img").hover(function(){
		if($(this).attr("src")=="images/home/devmgr_pressed.png"){
			return;
		}
		var src=$(this).attr("src").replace(".jpg",".png");
		$(this).attr("src",src).css("cursor","pointer");
	},function(){
		if($(this).attr("src")=="images/home/devmgr_pressed.png"){
			return;
		}
		var src=$(this).attr("src").replace(".png",".jpg");
		$(this).attr("src",src);
	});
	
	//全选
	$(".copyChkAll").click(function(){
		//alert("123");
		if($(this).attr("checked")){
			 
			 $(".copyGrp").attr("checked",'true');
		}else{
			$(".copyGrp").removeAttr("checked");
		}
	});

	//复制保存
	$(".btnCopySave").click(function(){
		
		var grpIds="";
		$(".copyGrp").each(function(i,item){
			if($(this).attr("checked")){
				//alert($(item).val());
				grpIds=grpIds+"&grpIds="+$(item).val();
			}
		});
		
		if(copyGrpCameraId<0){
			return;
		}
		if(grpIds==""){
			jAlert("请勾选你复制的组!","提示");
			return;
		}
		$.ajax({
			url:"json_CameraAction_copyGrpCamera.action",
			data:"cameraId="+copyGrpCameraId+grpIds,
			type:"POST",
			dataType:"json",
			cache:false,
			success:function(json){
				getCamareByGrpId(grpIdLeft);
				$.zxxbox.hide();
				jAlert("复制成功！","提示");
			},error:function(){
				jAlert("网络异常！","提示");
			}
			
		});
		
	});
	//返回
	$(".btnCopyBack").click(function(){
		$.zxxbox.hide();
	});
	//剪切摄像机
	$(".btnCutSave").click(function(){
		var grpId=$("#cutCameraContent input:radio:checked").val();
		if(typeof(grpId) == "undefined"){
			jAlert("请选择摄像机组","提示");
			return;
		}
		$.ajax({
			url:"json_CameraAction_cutGrpCamera.action",
			data:"id="+cutGrpCameraId+"&grpId="+grpId,
			type:"POST",
			dataType:"json",
			cache:false,
			success:function(json){
				getCamareByGrpId(grpIdLeft);
				$.zxxbox.hide();
				jAlert("剪切成功！","提示");
			},error:function(){
				jAlert("网络异常！","提示");
			}
			
		});
	});
	
	$(".btnAddCamera").click(function(){
		//加载所有NVR的信息
		$.ajax({
			url:"json_CameraAction_getAllNvrInfo.action",
			//data:"id="+cutGrpCameraId+"&grpId="+grpId,
			type:"POST",
			dataType:"json",
			cache:false,
			success:function(json){
				 var jsonData=eval("("+json+")");//转换为json对象 
				 $("#nvr_list_container").empty();
				 $("#nvrTemplate").tmpl(jsonData.data).appendTo("#nvr_list_container");
				 
				//手动添加--NVR验证
				var userId=-1;
				var nvrId=0;
				$(".handNvrCheck").click(function(){
					nvrId=$(this).prev().val();
					
					$.each(jsonData.data,function(i,item){
						
						if(nvrId==item.nvrId){
							//alert(item.nvrIp+","+item.nvrPort+","+item.nvrLoginName+","+item.nvrLoginPwd);
							
							userId=$("#nvrChann")[0].NVRLogin(item.nvrIp,item.nvrPort,item.nvrLoginName,item.nvrLoginPwd);
							if(userId<0){
								jAlert("验证失败！","提示");
								return;
							}else{
								jAlert("验证成功！","提示");
							}
						
						}
					 });
				});
				//保存 手动添加
				$(".btnHandSave").click(function(){
					if(userId<0){
						jAlert("请先验证或者你的验证没有通过！","提示");
						return;
					}
					var nvrChann=$("input[name=nvrChann]").val();
					var ip=$("input[name=handIp]").val();
					var port=$("input[name=handPort]").val();
					var name=$("input[name=handName]").val();
					var pwd=$("input[name=handPwd]").val();
					var handProtocol=$(".handProtocol").val();
					var handCameraName=$("input[name=handCameraName]").val();
					//alert(handCameraName);
					handAddCamera2Nvr(nvrId,nvrChann,ip,handCameraName,port,name,pwd,handProtocol,grpIdLeft);
					
				});
			},error:function(){
				jAlert("网络异常！","提示");
			}
		});
		
		
		//加载已有的IPC 
		$.ajax({
			url:"json_CameraAction_getAllCamera.action",
			//data:"id="+cutGrpCameraId+"&grpId="+grpId,
			type:"POST",
			dataType:"json",
			cache:false,
			success:function(json){
				//alert(json);
				 var jsonData=eval("("+json+")");//转换为json对象 
				 $("#hasIpc_list_container").empty();
				 $("#allCameraTemplate").tmpl(jsonData.data).appendTo("#hasIpc_list_container");
				 
			}
		});
		
		$(".addCameraDiv").zxxbox({
			bar: false,
		    bgclose: true
		});
		
	});

	

	
	
	//取消
	$(".btnDivCancel").click(function(){
		$.zxxbox.hide();
	});

	//手动添加
	function handAddCamera2Nvr(nvrId,nvrChann,ip,cameraName,port,name,pwd,protocol,grpId){

		if(nvrChann==""){
			jAlert("请输入通道号！","提示");
			return;
		}
		
		var expNvrChann =/^([0-9]*)$/;
		var regNvrChann=nvrChann.match(expNvrChann);
		if(regNvrChann==null){
			 jAlert("通道号不合法！","提示");
			 return false;
		}
		
		//var ip=$("input[name=handIp]").val();
		var expIp=/^(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])$/;
		var reg = ip.match(expIp);
		if(reg==null)
	    {
		    jAlert("IP地址不合法！","提示");
		    return false;
	    }
		//var port=$("input[name=handPort]").val();
		if(port==""){
			jAlert("请输入端口号！","提示");
			return;
		}
		var expPort =/^([0-9]*)$/;
		var regPort=port.match(expPort);
		if(regPort==null){
			 jAlert("端口号不合法！","提示");
			 return false;
		}
		//var name=$("input[name=handName]").val();
		//var pwd=$("input[name=handPwd]").val();
		//var handProtocol=$(".handProtocol").val();
		//alert(protocol);
		//return;
		var result=$("#nvrChann")[0].NVRCfg(ip,port,name,pwd,nvrChann,protocol);
		if(result<0){
			jAlert("NVR添加摄像机失败！","提示");
			return;
		}
		
		$.ajax({
			url:"json_CameraAction_addCamera.action",
			data:"cameraModel.cameraIp="+ip+"&cameraModel.cameraPort="+port+"&cameraModel.cameraLoginName="+name
				+"&cameraModel.cameraPwd="+pwd+"&cameraModel.channelId="+(nvrChann-1)+"&cameraModel.grpId="+grpId
				+"&cameraModel.nvrId="+nvrId+"&cameraModel.cameraName="+cameraName,
			type:"POST",
			dataType:"json",
			cache:false,
			success:function(json){
				$.zxxbox.hide();
				jAlert("成功！","提示");
				getCamareByGrpId(grpIdLeft);
			},error:function(){
				jAlert("网络异常！","提示");
			}
			
		});
		
	//});
	}
	
	//自动添加
	$(".btnAutoSave").click(function(){
		var ip=$("select[name=autoIp]").val();
		var port=$("input[name=autoPort]").val();
		var expPort =/^([0-9]*)$/;
		var regPort=port.match(expPort);
		if(regPort==null){
			 jAlert("端口号不合法！","提示");
			 return false;
		}
		var name=$("input[name=autoName]").val();
		var pwd=$("input[name=autoPwd]").val();
		$.ajax({
			url:"json_CameraAction_checkCameraLogin.action",
			data:"cameraModel.cameraIp="+ip+"&cameraModel.cameraPort="+port+"&cameraModel.cameraLoginName="+name+"&cameraModel.cameraPwd="+pwd,
			type:"POST",
			dataType:"json",
			cache:false,
			success:function(json){
				$.zxxbox.hide();
				jAlert("成功！","提示");
			},error:function(){
				jAlert("网络异常！","提示");
			}
			
		});
	});
	
	//保存 添加已有摄像机
	$(".btnHasSave").click(function(){
		var cameraIds=$("select[name=hasIps]").val();
		var cameraId="";
		$.each(cameraIds,function(i,item){
			//alert(item);
			cameraId=cameraId+"cameraIds="+item+"&";
		});
		if(cameraIds==null){
			jAlert("请选择摄像机！","提示");
			return;
		}
		//return;
		$.ajax({
			url:"json_CameraAction_addCamera2Grp.action",
			data:cameraId+"grpId="+grpIdLeft,
			type:"POST",
			dataType:"json",
			cache:false,
			success:function(json){
				$.zxxbox.hide();
				jAlert("成功！","提示");
				getCamareByGrpId(grpIdLeft);
			},error:function(){
				jAlert("网络异常！","提示");
			}
			
		});
		
	});
	$("select[name='hasIps']").click(function(){
		var name=$("select[name=hasIps]").find("option:selected").attr("lang");
		$("input[name='rename']").val(name);
		//alert("123");
	});
	//重命名
	$(".btnDivRename").click(function(){
		var cameraIds=$("select[name=hasIps]").val();
		
		if(cameraIds==null){
			jAlert("请选择摄像机！","提示");
			return;
		}
		var rename=$("input[name='rename']").val();
		
		
		$.ajax({
			url:"json_CameraAction_renameCamera.action",
			data:"cameraModel.cameraId="+cameraIds+"&cameraModel.cameraName="+rename,
			type:"POST",
			dataType:"json",
			cache:false,
			success:function(json){
				$.zxxbox.hide();
				jAlert("成功！","提示");
				getCamareByGrpId(grpIdLeft);
			},error:function(){
				jAlert("网络异常！","提示");
			}
			
		});
		
	});
	
	$("#addGrpCancelBtn").click(function(){
		$.zxxbox.hide();
	});
	
	$("#addGrpOKBtn").click(function(){
		var grpName=$("input[name=grpName]").val();
		//alert(grpName);
		
		var grpDesc=$("input[name=grpDesc]").val();
		$.ajax({
			url:"json_CameraAction_addCameraGrp.action",
			data:"cameraGrpModel.grpName="+grpName+"&cameraGrpModel.grpDesc="+grpDesc,
			type:"POST",
			dataType:"json",
			cache:false,
			success:function(json){
				$.zxxbox.hide();
				jAlert("添加摄像机组成功！","提示");
				
				loadCameraGrp();
			},error:function(){
				jAlert("网络异常！","提示");
			}
			
		});
	});
	//全选
	$(".chkAllCamera").click(function(){
		var checked=$(this).attr("checked");
		if(checked=="checked"){
			
			$("#camera_list_container").find(":checkbox").each(function(){
				$(this).attr("checked",true);
			});
		}else{
			
			$("#camera_list_container").find(":checkbox").each(function(){
				$(this).attr("checked",false);
			});
		}
		
	});
	//批量删除
	$(".delAllCamera").click(function(){
		var cameraIds="";
		$("#camera_list_container").find(":checkbox").each(function(){
			if($(this).attr("checked")=="checked"){
				//cameraIds.push($(this).attr("cameraId"));
				cameraIds+="&cameraIds="+$(this).attr("lang");
			}
		});
		if(cameraIds==""){
			jAlert("请选择勾选删除的摄像机！","提示");
			return;
		}
		jConfirm("确定批量删除选中的摄像机？","提示",function(t){
			if(t){
				$.ajax({
					url:"json_CameraAction_delCheckedCamear.action",
					data:cameraIds,
					type:"POST",
					dataType:"json",
					cache:false,
					success:function(){
						jAlert("摄像机批量删除成功","提示");
					},error:function(){
						jAlert("网络异常！","提示");
					},complete:function(){
						getCamareByGrpId(grpIdLeft);
					}
				});
			}
		});
	});

});
var tabNum=-1;
function setTab(name,cursel,n){
	for(var i=1;i<=n;i++){
		var menu=document.getElementById(name+i);
		var con=document.getElementById("con_"+name+"_"+i);
		menu.className=i==cursel?"hover":"";
		con.style.display=i==cursel?"block":"none";
		tabNum=cursel;
	}
}

</script>
<script id="grpTemplate" type="text/x-jquery-tmpl">
<li><font>{{= grpName}}</font>
	<div class="grpbtn" lang={{= grpId}}>
		<input type="image" src="images/usermgr/addgrp.png" title="添加新组">
		<input type="image" src="images/usermgr/removegrp.png" title="删除该组">
	</div>
</li>
</script>
<script type="text/x-jquery-tmpl" id="copyCameraTemplate">
<tr>
	<td><input type="checkbox" class="copyGrp" value="{{= grpId}}">{{= grpName}}</td>
</tr>
</script>

<script type="text/x-jquery-tmpl" id="cutCameraTemplate">
<tr><td><input type="radio" name="grp" value="{{= grpId}}">{{= grpName}}</td></tr>
</script>

<script id="cameraTemplate" type="text/x-jquery-tmpl">
<tr>
	<td align="left"><input type="checkbox" lang={{= id}} cameraId={{= cameraId}} cameraName="{{= cameraName}}"></td>
	<td style="width: 190px;text-align: left;">{{= cameraName}}</td>
	<td style="width: 158px;text-align: left;">{{= cameraIp}}</td>
	<td style="width: 230px;text-align: left;">{{= cameraMac}}</td>
	<td style="width: 135px;text-align: left;" >
		<input class="copyCamera" cameraId={{= cameraId}} lang={{= id}} type="image" src="images/devmgr/copy.png" title="复制">
		<input class="cutCamera" lang={{= id}} type="image" src="images/devmgr/cut.png" title="剪切">
		<input class="delCamera" lang={{= id}} cameraName="{{= cameraName}}" type="image" src="images/devmgr/delete.png" title="删除">
	</td>
</tr>

</script>

<script id="nvrTemplate" type="text/x-jquery-tmpl">
	<option value="{{= nvrId}}">{{= nvrIp}}_{{= brand}}</option>
</script>

<script id="allCameraTemplate" type="text/x-jquery-tmpl">
	<option value="{{= cameraId}}"  lang="{{= cameraName}}">{{= cameraIp}}__{{= cameraName}}</option>
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
				<div id="list_zb">
					<img alt="组别" src="images/devmgr/zb.jpg"/>
				</div>
				<div id="list_ul">
					<ul id="list_ul_container">
						
					</ul>
				</div>
			</div>
		</div>
		
		<div id="main_padding">
		
		</div>
		<div id="main_right">
			<div class="right_title" >
				<input type="checkbox" class="chkAllCamera">
			</div>
			<div class="right_table">
				<div class="table_content">
					<table id="camera_list_container">
						
					
					</table>
				</div>
				<div class="table_cz">
					<input type="image" src="images/devmgr/plsc.png" class="delAllCamera">
					<input type="image"  class="btnAddCamera" src="images/devmgr/tjsxj.png">
				</div>
				<div class="table_page" style="display:none;">
					<table>
						<tr>
							<td style="width: 170px;">从<input style="width: 30px">--<input style="width: 30px">页</td>
							<td style="width: 65px;"><input class="export" type="image" src="images/usermgr/export.png" title="导出"></td>
							<td align="right" style="width: 383px;">第1/20页</td>
							<td style="width: 40px;" class="firstPage">首页</td>
							<td style="width: 50px;" class="prePage">上一页</td>
							<td style="width: 50px;" class="nextPage">下一页</td>
							<td class="lastPage">尾页</td>
						</tr>
					</table>
				</div>
			
			</div>
			
		</div>
		
	</div>
	
	<div id="foot">
		<label style="line-height: 40px;">公安部第三研究所</label>
	</div>
	<!-- 复制摄像机 -->
	<div id="copyCameraDiv">
		<div style="height: 8px;"></div>
		<div style="background-color: white;color: black;width:230px;height:200px;margin: 0 auto;text-align: center;overflow-y:scroll; ">
			<table id="copyCameraContent">
				
			</table>
		</div>
		<div style="height: 30px;"></div>
					
		<div>
			<input type="checkbox" class="copyChkAll">全选
			<input type="button" value="保存" class="btnCopySave">
			<input type="button" value="取消" class="btnCopyBack">
		</div>
		
	</div>
	
	<!-- 剪切摄像机 -->
	<div id="cutCameraDiv">
		
		<div style="height: 8px;"></div>
		<div style="background-color: white;color: black;width:230px;height:200px;margin: 0 auto;text-align: center;overflow-y:scroll; ">
			<table id="cutCameraContent">
				
			</table>
		
		</div>
		<div style="height: 30px;"></div>
					
		<div>
			<input type="button" value="保存" class="btnCutSave">
			<input type="button" value="取消" class="btnCopyBack">
		</div>
	</div>
	
	<!-- 新建/添加已有 摄像机 -->
	<div class="addCameraDiv" id="Tab">
		<div class="Menubox">
		    <ul>
		      <li id="menu1" onclick="setTab('menu',1,2)" class="hover">手动添加</li>
		      <li id="menu2" onclick="setTab('menu',2,2)" >添加已有</li>
		      <!-- 
		      <li id="menu2" onclick="setTab('menu',2,3)" >自动搜索</li>
			  <li id="menu3" onclick="setTab('menu',3,3)" >添加已有</li>
			   -->
		    </ul>
  		</div>
  		<div class="Contentbox" > 
    		<div id="con_menu_1" class="hover">
     			<table>
     				<tr>
     					<td>NVR：</td>
     					<td>
     						<select name="NVR" id="nvr_list_container">
					      	</select>
					      	<input type="button" value="验证" class="handNvrCheck">
     					</td>
     				</tr>
     				<tr>
     					<td>通道号：</td>
     					<td><input type="text" name="nvrChann"></td>
     				</tr>
     				<tr>
     					<td>IP地址：</td>
     					<td><input type="text" name="handIp"></td>
     				</tr>
     				<tr>
     					<td>别名：</td>
     					<td><input type="text" name="handCameraName"></td>
     				</tr>
     				<tr>
     					<td>端口：</td>
     					<td><input type="text" name="handPort" value="8000"></td>
     				</tr>
     				<tr>
     					<td>用户名：</td>
     					<td><input type="text" name="handName" value="admin"></td>
     				</tr>
     				<tr>
     					<td>密码：</td>
     					<td><input type="password" name="handPwd"></td>
     				</tr>
     				<tr>
     					<td>协议：</td>
     					<td>
     						<select class="handProtocol">
     							<option value="HIKVISION">HIKVISION</option>
     							<option value="ONVIF">ONVIF</option>
     						</select>
     					</td>
     				</tr>
     				<tr>
     					<td><input type="button" value="确定" class="btnHandSave"></td>
     					<td><input type="button" value="取消" class="btnDivCancel"></td>
     				</tr>
     			</table>
    		</div>
    		<div id="con_menu_2" style="display:none">
				<table>
					<tr>
						<td>设备IP：</td>
						<td><select multiple="multiple" size="15" name="hasIps" id="hasIpc_list_container">
							<option value="192.168.1.140">192.168.1.140</option>
							<option value="192.168.1.141">192.168.1.141</option>
							<option value="192.168.1.142">192.168.1.142</option>
							<option value="192.168.1.143">192.168.1.143</option>
							<option value="192.168.1.144">192.168.1.144</option>
							<option>192.168.1.120</option>
						<option>192.168.1.130</option>
						<option>192.168.1.131</option>
					</select></td>
					</tr>
					<tr>
	     				<td><input type="button" value="确定" class="btnHasSave"></td>
	     				<td>
	     					<input type="button" value="取消" class="btnDivCancel">
	     					<input type="button" value="重命名" class="btnDivRename">
	     					<input value="重命名" name="rename" class="rename">
	     				</td>
	     			</tr>
		    	</table>
		    </div>
    		
    		
    		
    		 <!-- 
		    <div id="con_menu_2" style="display:none">
		   
		    	<table>
     				<tr>
     					<td>IP地址：</td>
     					<td>
     						<select name="autoIp">
					      		<option>192.168.1.140</option>
					      		<option>192.168.1.141</option>
					      		<option>192.168.1.142</option>
					      		<option>192.168.1.143</option>
					      		<option>192.168.1.144</option>
					      	</select>
     					</td>
     				</tr>
     				<tr>
     					<td>端口：</td>
     					<td><input type="text" name="autoPort"></td>
     				</tr>
     				<tr>
     					<td>用户名：</td>
     					<td><input type="text" name="autoName"></td>
     				</tr>
     				<tr>
     					<td>密码：</td>
     					<td><input type="password" name="autoPwd"></td>
     				</tr>
     				<tr>
     					<td><input type="button" value="确定" class="btnAutoSave"></td>
     					<td><input type="button" value="取消" class="btnDivCancel"></td>
     				</tr>
     			</table>
		       
		       <br/>
		       <br/>
		        <br/>
		       <br/>
		      	 设备自动搜索功能，<b>阿焦</b>正在努力为您开发中……
		      	<br/>
		      	<br/>
		      	<br/>
		       <br/>
		    </div>
		    -->
		    <!-- 
			<div id="con_menu_3" style="display:none">
				<table>
					<tr>
						<td>设备IP：</td>
						<td><select multiple="multiple" size="15" name="hasIps" id="hasIpc_list_container">
							<option value="192.168.1.140">192.168.1.140</option>
							<option value="192.168.1.141">192.168.1.141</option>
							<option value="192.168.1.142">192.168.1.142</option>
							<option value="192.168.1.143">192.168.1.143</option>
							<option value="192.168.1.144">192.168.1.144</option>
							<option>192.168.1.120</option>
						<option>192.168.1.130</option>
						<option>192.168.1.131</option>
					</select></td>
					</tr>
					<tr>
	     				<td><input type="button" value="确定" class="btnHasSave"></td>
	     				<td><input type="button" value="取消" class="btnDivCancel"></td>
	     			</tr>
		    	</table>
		    </div>
			 -->
				
		</div>
	</div>
	<div style="display: none;">
		<object id="nvrChann" classid="clsid:EF7D79E2-1FD6-4205-B716-6FC19CBF2930">
			加载插件
		</object>
	</div>
</div>

<!-- 添加部摄像机组-->
<div class="zxxboxHide" id="addGrpDiv" style="background-image: url('images/usermgr/tjbm_bg.png'); width: 376px;height: 264px;text-align: center;margin: 0 auto;">
	<div style="width: 376px;height: 50px">
		<font style="line-height: 50px;"> 添加摄像机组</font>
	</div>
	<div style="text-align: center;width: 260px;height: 190px;margin: 0 auto;">
		<table style="width: 260px;height: 190px;">
			<tr>
				<td>组名称:</td>
				<td><input name="grpName"></td>
			</tr>
			<tr>
				<td>组描述:</td>
				<td><input name="grpDesc"></td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="image" src="images/usermgr/tjbm_qr.png" id="addGrpOKBtn">
					<input type="image" src="images/usermgr/tjbm_qx.png" id="addGrpCancelBtn">
				</td>
			</tr>
		</table>
	</div>
</div>

</body>
</html>