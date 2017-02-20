<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>实时预览</title>
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
#main_left #left_list{
	float: left;
	width: 253px;
	height: 600px;
	overflow-y:auto;
	overflow-x: hidden;
	scrollbar-3d-light-color:#303030;
	scrollbar-arrow-color:black;
	scrollbar-base-color:#1A1A1A;
	scrollbar-face-color:white;
}
#left_list #tree{
	width: 230px;
	
}


</style>
<script type="text/javascript" src="scripts/jquery-1.8.1.js"></script>
<script type="text/javascript" src="scripts/jquery.ui.draggable.js"></script> 
<script type="text/javascript" src="scripts/jquery.alerts.js" ></script>
<link href="scripts/jquery.alerts.css" rel="stylesheet" type="text/css" media="screen" />

<!-- jquery模板 -->
<script src="scripts/jquery.tmpl.js" type="text/javascript"></script>
<!-- zxxbox -->
<script type="text/javascript" src="scripts/jquery.zxxbox.3.0.js"></script>
<!-- zTree -->
<link href="styles/zTreeStyle/zTreeStyle.css" rel="stylesheet" type="text/css" />  
<script src="scripts/zTree/jquery.ztree.core-3.5.js" type="text/javascript"></script>  
<script src="scripts/zTree/jquery.ztree.excheck-3.5.js" type="text/javascript"></script>  
<script src="scripts/zTree/jquery.ztree.exedit-3.5.js" type="text/javascript"></script>  

<script type="text/javascript">
$(document).ready(function(){
	
	//var index=0;
	//catch the right-click context menu
	$(document).bind("contextmenu",function(e) {//右键禁用			 
		//warning prompt - optional
		//alert("No right-clicking!");
		//delete the default context menu
		return false;
	});
	
	var setting = {
			view:{
				showIcon:false
			},
			check:{
				enable: false
			},
			data: {
				keep:{
					parent:true,
					leaf:true
				},
				simpleData: {
					enable: true
				}
			},callback:{
				onClick: zTreeOnClick,
				onDblClick:function(event, treeId, treeNode){
					//index=treeNode.channelId;
					//alert(treeNode.nvrIp+","+treeNode.nvrPort+","+treeNode.nvrLoginName+","+treeNode.nvrLoginPwd);
					$("#previewActiveX")[0].logout();
					$("#previewActiveX")[0].login(treeNode.nvrIp,treeNode.nvrPort,treeNode.nvrLoginName,treeNode.nvrLoginPwd);
					$("#previewActiveX")[0].preview(treeNode.channelId);
					/**
					if(treeNode.name=="模拟组"||treeNode.getParentNode().name=="模拟组"){
						$("#previewActiveX")[0].logout();
						$("#previewActiveX")[0].login("192.168.1.149","8000","admin","12345");
					}else{
						$("#previewActiveX")[0].logout();
						$("#previewActiveX")[0].login("192.168.1.14","8000","admin","12345");
						
					}**/
					//alert("123");
					//$("#previewActiveX")[0].preview(treeNode.channelId);
					//alert("123");
				}
			}
		};
	function zTreeOnClick(event, treeId, treeNode){
		//alert(treeNode.channelId + ", " + treeNode.name);
		//alert(treeNode.getParentNode().name);
		/**
		if(treeNode.name=="模拟组"||treeNode.getParentNode().name=="模拟组"){
			$("#previewActiveX")[0].login("192.168.1.149","8000","admin","12345");
		}else{
			$("#previewActiveX")[0].login("192.168.1.14","8000","admin","12345");
		}**/
		//index=treeNode.channelId;
		$("#previewActiveX")[0].logout();
		$("#previewActiveX")[0].login(treeNode.nvrIp,treeNode.nvrPort,treeNode.nvrLoginName,treeNode.nvrLoginPwd);
		$("#previewActiveX")[0].selectionChanged(treeNode.channelId);
	}
	
	 //var zTree = $("#tree").zTree(setting, zTreeNodes1);
	//  $.fn.zTree.init($("#tree"), setting, zTreeNodes1);
	function getAllCameraGrp(){
		$.ajax({
			url:"json_CameraAction_getAllCameraGrp.action",
			cache:false,
			type:"POST",
			success:function(json){
			//	alert(json);
				var jsonData=eval("("+json+")");//转换为json对象 
			//	$("#grpContent").empty();
			//	$("#grpTemplate").tmpl(jsonData.data).appendTo("#grpContent");
				 $.fn.zTree.init($("#tree"), setting, jsonData.data);
			},error:function(){
				
			}
		});
	}
	muneLink();
	getDate();
	window.setInterval(getDate,1000);  //每隔一秒显示时间 
	getAllCameraGrp();

	$("#menu_right img").eq(0).attr("src","images/live/preview_pressed.png");
	
	$("#menu_right img").hover(function(){
		//alert($(this).attr("src"));
		if($(this).attr("src")=="images/live/preview_pressed.png"){
			return;
		}
		var src=$(this).attr("src").replace(".jpg",".png");
		
		$(this).attr("src",src).css("cursor","pointer");
	},function(){
		if($(this).attr("src")=="images/live/preview_pressed.png"){
			return;
		}
		var src=$(this).attr("src").replace(".png",".jpg");
		if(src=="images/live/preview.png"){
			return;
		}
		$(this).attr("src",src);
	});
	
	
	//$("#previewActiveX")[0].login("192.168.1.149","8000","admin","12345");
	//$("#previewActiveX")[0].login("192.168.1.14","8000","admin","12345");
	//$.ajax({
	//	url:"",
		
	//});
	//$("#previewActiveX")[0].preview();
	//$("#previewActiveX")[0].test();
});
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
		<!-- 相机列表 -->
		<div id="main_left">
			<div class="main_time">
				<div class="time_time">09:41</div>
				<div class="time_date">2014/03/11</div>
			</div>
			<div id="left_list">
				<ul id="tree" class="ztree" ></ul>
			</div>
		</div>
		<div id="main_right">
			<object id="previewActiveX" codebase="ittc.cab" classid="clsid:EF7D79E2-1FD6-4205-B716-6FC19CBF2930" height="668" width="880">
			请安装插件
			</object>
		</div>
	</div>
	
	<div id="foot">
		<label style="line-height: 40px;">公安部第三研究所</label>
	</div>
</div>

</body>
</html>