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
#main_left #left_list{
	width: 250px;
	height: 400px;
	text-align: left;
}
#main_right{
	margin-top:20px;
	width: 885px;
	height: 668px;
	float: left;
}
#main_right .right_left{
	width: 390px;
	height: 410px;
	float: left;
	border:0px solid white;
	float: left;
}
.right_left div{
	width: 389px;
	height:407px;
	background-image: url('images/devcfg/bg1.png');
}
.right_right div,.right_left div{
	overflow-y: auto;
	overflow-x: hidden;
	scrollbar-3d-light-color:#1A1A1A;
	scrollbar-arrow-color:white;
	scrollbar-base-color:#303030;
}
#main_right .right_middle{
	width: 65px;
	height: 410px;
	float: left;
}
.right_middle .middle_border{
	width: 65px;
	height: 180px;
	float: left;
}
#main_right .right_right{
	width: 390px;
	height: 410px;
	float: left;
	border:0px solid white;
	float: left;
}
.right_right div{
	width: 389px;
	height:407px;
	background-image: url('images/devcfg/bg1.png');
}

#main_right #dev_right{
	width: 360px;
	height: 360px;
}
#main_right #dev_left{
	width: 360px;
	height: 380px;
}
#main_right .right_sbqx{
	width: 885px;
	height: 190px;
	float: left;
	border:0px solid white;
}
#main_right .right_czan{
	width: 885px;
	height: 50px;
}

#copyUserDiv{
	width: 270px;
	height:300px;
	background-color: #add1db;
	display: none;
	text-align:center;
	margin:0 auto;
}
</style>
<script type="text/javascript" src="scripts/jquery-1.8.1.js"></script>
<script type="text/javascript" src="scripts/jquery.ui.draggable.js"></script> 
<script type="text/javascript" src="scripts/jquery.alerts.js" ></script>
<link href="scripts/jquery.alerts.css" rel="stylesheet" type="text/css" media="screen" />

<!-- zTree -->
<link href="styles/zTreeStyle/zTreeStyle.css" rel="stylesheet" type="text/css" />  

<!-- jquery模板 -->
<script src="scripts/jquery.tmpl.js" type="text/javascript"></script>

<script src="scripts/zTree/jquery.ztree.core-3.5.js" type="text/javascript"></script>  
<script src="scripts/zTree/jquery.ztree.excheck-3.5.js" type="text/javascript"></script>  
<script src="scripts/zTree/jquery.ztree.exedit-3.5.js" type="text/javascript"></script>  
<!--zxxbox  -->
<script type="text/javascript" src="scripts/jquery.zxxbox.3.0.js"></script>
<script type="text/javascript">


var user_setting = {
		view: {
			selectedMulti: false,
			showIcon:false
		}, data: {  
            simpleData: {  
                enable:true,  
                idKey: "id",  
                pIdKey: "pId",  
                rootPId: ""  
            }  
        },callback:{
        	onClick:function(event, treeId, treeNode){
        		
        		if(!treeNode.isParent){
        			userId=treeNode.id;
        			//getCameraByUser(userId);
        			//alert(treeNode.name);
        			userName=treeNode.name;
        		}else{
        			userId=-1;
        		}
        		getCameraByUser(userId);
        		getAllAuthority();
        		//
        		//alert(userId);
        		
			}
        }
	};
var settingCopy = {
		check:{
			enable:true
		},
		view: {
			selectedMulti: false,
			showIcon:false
		}, data: {
            simpleData: {  
                enable:true,  
                idKey: "id",  
                pIdKey: "pId",  
                rootPId: ""  
            }  
        },callback:{
        	onClick:function(event, treeId, treeNode){
        		//getCameraByUser(1);
        		
			}
        }
	};
var dev_left_setting = {
		edit: {
			enable: true,
			showRemoveBtn: false,
			showRenameBtn: false
		},
		data: {
			keep:{
				parent:true,
				leaf:true
			},
			simpleData: {  
                enable:true,  
                idKey: "id",  
                pIdKey: "pId",  
                rootPId: ""  
            } 
		},
		callback: {
			beforeDrag: beforeDrag,
			beforeDrop: beforeDrop,
			beforeClick:function(treeId, treeNode){
				return !treeNode.isCur;
			}
			
		}
	};
var dev_setting = {
		edit: {
			enable: true,
			showRemoveBtn: false,
			showRenameBtn: function(treeId, treeNode){
				return treeNode.isParent;
			},
			renameTitle:"重命名"
		},
		data: {
			keep:{
				parent:true,
				leaf:true
			},
			simpleData: {  
                enable:true,  
                idKey: "id",  
                pIdKey: "pId",  
                rootPId: ""  
            } 
		},
		callback: {
			beforeDrag: beforeDrag,
			beforeDrop: beforeDrop,
			beforeClick:function(treeId, treeNode){
				return !treeNode.isCur;
			},
			beforeRename:function(treeId, treeNode, newName, isCancel){
				if(!treeNode.isParent){
					isCancel = true;
				}
				//return 
			}
			
		}
	};
var depTree;
var zNodes;
var userId=-1;
var userName="";
	function beforeDrag(treeId, treeNodes) {
		if(userId==-1){
			jAlert("请先选择部门成员！","提示");
			return false;
		}
		for (var i=0,l=treeNodes.length; i<l; i++) {
			if (treeNodes[i].drag === false) {
				return false;
			}
		}
		return true;
	}
	function beforeDrop(treeId, treeNodes, targetNode, moveType) {
		return targetNode ? targetNode.drop !== false : true;
	}
	
	var newCount = 1;
	function add(e) {
		var zTree = $.fn.zTree.getZTreeObj("dev_right");
		
		isParent = e.data.isParent;
		//nodes = zTree.getSelectedNodes();
	//	treeNode = nodes[0];
		//if (treeNode) {
			//treeNode = zTree.addNodes(treeNode, {id:(100 + newCount), pId:treeNode.id, isParent:isParent, name:"new node" + (newCount++)});
	//	} else {
			treeNode = zTree.addNodes(null, {id:(100 + newCount), pId:0, isParent:isParent, name:"摄像机组" + (newCount++)});
		//}
		//if (treeNode) {
			//zTree.editName(treeNode[0]);
		//} else {
		//	alert("叶子节点被锁定，无法增加子节点");
		//}
	};
	
	function remove(e) {
		var zTree = $.fn.zTree.getZTreeObj("dev_right");
		nodes = zTree.getSelectedNodes();
		
		treeNode = nodes[0];
		alert(treeNode.children);
		if (nodes.length == 0) {
			alert("请先选择一个节点");
			return;
		}
		
		var callbackFlag = $("#callbackTrigger").attr("checked");
		zTree.removeNode(treeNode, callbackFlag);
	};
	
	//根据用户加载摄像机
	function getCameraByUser(userId){
		$.ajax({
			//url:"data/devcfg.json",
			url:"json_AuthorityAction_getCameraByUserId.action",
			data:"userAuthorityModel.userId="+userId,
			type:"POST",
			dataType:"json",
			cache:false,
			success:function(json){
				var jsonData=eval("("+json+")");//转换为json对象 
				var used=jsonData.used;
				var unused=jsonData.unused;
				var authorityIds=jsonData.authority;
				$.each(authorityIds,function(i,item){
					//alert(item.authorityId);
					$("input[name='authorityId']").each(function(i,item2){
						if(item.authorityId==$(this).val()){
							$(item2).attr("checked", "checked");
							if(item.authorityId==10){
								//$(this).children("select").val(item.level);
								//alert(item.level);
								$(item2).next("select").val(item.level);
							}
							
						}
					});
				});
				$.fn.zTree.init($("#dev_left"), dev_left_setting,unused);
				$.fn.zTree.init($("#dev_right"), dev_setting, used);
				//alert(json.data);
			},error:function(){
				jAlert("摄像机数据加载异常！","提示");
			},complete:function(){
				//保存按钮
				
			}
			
		});
	}
	
	function getAllAuthority(){
		$.ajax({
			//url:"data/devcfg.json",
			url:"json_AuthorityAction_getAllAuthority.action",
			type:"POST",
			dataType:"json",
			cache:false,
			success:function(json){
				var jsonData=eval("("+json+")");//转换为json对象 
				var authority=jsonData.data;
				$("#authorityContent").empty();
				$("#authorityTemplate").tmpl(authority).appendTo("#authorityContent");
				
				//getCameraByUser(1);
				
				
			},error:function(){
				jAlert("权限加载异常");
			}
		});
	}
	
	function loadUserList(){
		//加载所有的部门以及组成员
		$.ajax({
			url:"json_UserAction_getDepUser.action",
			type:"POST",
			dataType:"json",
			cache:false,
			success:function(json){
				 var jsonData=eval("("+json+")");//转换为json对象 
				 depTree=jsonData.data;
				 $.fn.zTree.init($("#user_tree"), user_setting, jsonData.data);
				 
			},error:function(){
				jAlert("加载部门成员列表失败！","提示");
			}
			
		});
	}
	
	function saveAuthority(){
		if(userId==-1){
			jAlert("请先选择部门成员！","提示");
			return;
		}
		var tree_right=$.fn.zTree.getZTreeObj("dev_right");
		if(tree_right.getNodes()==null||tree_right.getNodes()==""){
			jAlert("未添加<b>已授权</b>摄像机！","提示");
			return;
		}
		var authorityIds=[];
		$("input[name='authorityId']").each(function(i,item){
			if($(item).attr("checked")=="checked"){
				if($(item).val()==10){
					//alert($(this).next("select").val());
					authorityIds.push($(this).val()+"-"+$(this).next("select").val());
				}else{
					authorityIds.push($(this).val());
				}
			}
			
		});
		//alert(userName);
		//return;
		$.ajax({
			url:"json_AuthorityAction_modifyUserAuthority.action?",
			data:"jsonData="+JSON.stringify(tree_right.getNodes())+"&userAuthorityModel.userId="+userId
				+"&userAuthorityModel.userName="+encodeURI(userName)+"&userAuthorityModel.authorityIds="+authorityIds,
			type:"POST",
			dataType:"json",
			cache:false,
			success:function(json){
				jAlert("权限保存成功！","提示");
			},error:function(){
				jAlert("网络异常！","提示");
			}
			
		});
			
		
	}
	
$(document).ready(function(){
	//catch the right-click context menu
	$(document).bind("contextmenu",function(e) {//右键禁用			 
		//warning prompt - optional
		//alert("No right-clicking!");
		//delete the default context menu
		return false;
	});
	

	
	muneLink();
	getDate();
	window.setInterval(getDate,1000);  //每隔一秒显示时间 
	/**获取 权限 **/
	getAllAuthority();
	/** 加载成员列表**/
	loadUserList();
	/**加载摄像机**/
	getCameraByUser(0);
	//$(".btnSave").unbind("click");
	$(".btnSave").bind("click", function(){
		//var tree_right=$.fn.zTree.getZTreeObj("dev_right");
		//alert(JSON.stringify(tree_right.getNodes()));
		saveAuthority();
	});
	
	$("#menu_right img").eq(2).attr("src","images/home/devcfg_pressed.png");
	
	$("#menu_right img").hover(function(){
		if($(this).attr("src")=="images/home/devcfg_pressed.png"){
			return;
		}
		var src=$(this).attr("src").replace(".jpg",".png");
		$(this).attr("src",src).css("cursor","pointer");
	},function(){
		if($(this).attr("src")=="images/home/devcfg_pressed.png"){
			return;
		}
		var src=$(this).attr("src").replace(".png",".jpg");
		$(this).attr("src",src);
	});
	
	

	
	$(".addParent").bind("click", {isParent:true}, add);
	$(".removeParent").bind("click", remove);
	
	

	//取消按钮
	$(".btnCancel").click(function(){
		
		//cfgInit();
		//getAllAuthority();
		//alert("123");
		$("input[name='authorityId']").each(function(i,item2){	
			$(item2).removeAttr("checked");
		});
		getCameraByUser(userId);
	});
	//复制功能
	$(".btnCopy").click(function(){
		if(userId==-1){
			jAlert("请选择被复制的对象成员！","提示");
			return;
		}
		$.fn.zTree.init($("#copyUser"), settingCopy, depTree);
		$("#copyUserDiv").zxxbox({
			bar: false,
		    bgclose: true
		});
	});
	//保存复制
	$(".btnCopySave").click(function(){
		$.zxxbox.hide();
		var user_copy=$.fn.zTree.getZTreeObj("copyUser");
		
		//alert(user_copy.getCheckedNodes(true));
		var copyUserIds=[];
		$.each(user_copy.getCheckedNodes(true),function(i,n){
			if(!n.isParent){
				//alert(n.id);
				copyUserIds.push(n.id);
			}
		});
		
		//alert(copyUserIds);
		$.ajax({
			url:"json_AuthorityAction_copyAuthority.action",
			data:"copyUserIds="+copyUserIds+"&userAuthorityModel.userId="+userId,
			type:"POST",
			dataType:"json",
			cache:false,
			success:function(json){
				jAlert("权限复制成功！","提示");
			},error:function(){
				jAlert("复制异常！","提示");
			}
		});
	});
	//取消复制
	$(".btnCopyBack").click(function(){
		$.zxxbox.hide();
	});
	
	//向右移动
	//$(".node2right").bind("click", paste);
});
</script>

<script type="text/x-jquery-tmpl" id="authorityTemplate">
	{{if (authorityId%7)==0}}
		<br>
	{{/if}}
	{{if authorityId<10}}
		<input type="checkbox" name="authorityId" value="{{= authorityId}}" {{= checked}}>{{= authorityName}}
	{{/if}}
	{{if authorityId==10}}&nbsp;&nbsp;&nbsp;
		<input type="checkbox" name="authorityId" value="{{= authorityId}}" {{= checked}}>{{= authorityName}}
		云台优先级选择：<select title="{{= authorityDesc}}">
					<option value="1">1</option><option value="2">2</option><option value="3">3</option>
					<option value="4">4</option><option value="5" selected>5</option><option value="6">6</option>
					<option value="7">7</option><option value="8">8</option><option value="9">9</option>
					<option value="10">10</option>
				</select>级
	{{/if}}
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
		<!-- 用户模块 -->
		<div id="main_left">
			<div class="main_time">
				<div class="time_time">09:41</div>
				<div class="time_date">2014/03/11</div>
			</div>
			<div id="left_list">
				<ul id="user_tree" class="ztree" ></ul>
				
			</div>
		</div>
		
		<!-- 设备模块 -->
		<div id="main_right">
			<div class="right_left">
				<b>未授权</b>摄像机
				<div>
					<ul id="dev_left" class="ztree" ></ul>
				</div>
				
			</div>
			<div class="right_middle" >
				<div class="middle_border"></div>
				<input type="image" src="images/devcfg/2right.png" class="node2right" style="display: none;">
				<input type="image" src="images/devcfg/2left.png" class="node2left" style="display: none;">
				
			</div>
			<div class="right_right">
				<b>已授权</b>摄像机<br/>
				<div style=";">
					<ul id="dev_right" class="ztree" ></ul>
					<input style="display: none;" type="image" class="addParent" src="images/devcfg/btnAddGrp.png">
				</div>
				
			</div>
			<!-- 权限明细 -->
			<div class="right_sbqx">
				<div style="width:838px;height:45px;text-align: left; "><br/>模块权限列表</div>
				<div id="authorityContent" style="background-image: url('images/devcfg/bg3.png');height: 111px;width: 838px;">
					
				</div>
				
			</div>
			<!-- 操作按钮 -->
			<div class="right_czan">
			
				<input type="image" class="btnSave" title="确定" src="images/devcfg/btnSave.png">
				<input type="image" class="btnCancel" title="取消" src="images/devcfg/btnCancel.png">
				<input type="image" class="btnCopy" title="复制" src="images/devcfg/btnCopy.png">
				
			</div>
		</div>
	</div>
	
	<div id="foot">
		公安部第三研究所
	</div>
	<div id="copyUserDiv">
		<div style="height: 8px;"></div>
		<div style="background-color: white;color: black;width:230px;height:200px;margin: 0 auto;text-align: center;overflow-y:scroll; ">
			<ul class="ztree black_tree" id="copyUser"></ul>
		</div>
		<div style="height: 30px;"></div>
					
		<div>
			<input type="checkbox">全选
			<input type="button" value="保存" class="btnCopySave">
			<input type="button" value="返回" class="btnCopyBack">
		</div>
	</div>
</div>

</body>
</html>