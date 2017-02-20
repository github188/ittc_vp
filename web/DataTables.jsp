<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>DataTables测试</title>
<link rel="stylesheet" type="text/css" href="scripts/DataTables/css/jquery.dataTables.css">
<script type="text/javascript" src="scripts/jquery-1.8.1.js"></script>
<script type="text/javascript" language="javascript" src="scripts/DataTables/js/jquery.dataTables.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#example").dataTable({
		"bProcessing": true,
		"sAjaxSource":"data/objects.json",
		"bLengthChange":false,
		"bFilter":false,
        "aoColumns": [
                      { "mData": "name" },
                      { "mData": "ip" },
                      { "mData": "title"},
                      { "mData": "control"}
                  ],
       "aoColumnDefs": [
		           {
		              "mRender": function ( data, type, row ) {
		             	 return '<input type="checkbox" />'+""+data;
		                },
		               "aTargets": [ 0 ]
		             },{ 
		            	 "bVisible": true,  "aTargets": [ 3 ] 
		             },{
		            	 "sClass": "center", "aTargets": [ 1 ] 
		             },{
                  		"mRender": function ( data, type, row ) {
                 	 			return '<input type="image" src="images/devmgr/copy.png" />'+" "
                 	 					+'<input type="image" src="images/devmgr/cut.png" />'+" "
                 	 					+'<input type="image" src="images/devmgr/delete.png" />';
                    		},"aTargets": [ 3 ]
                 	},
       		],
       	"sPaginationType" : "full_numbers",
       	"oLanguage": {
       		"sLengthMenu": "每页显示 _MENU_ 条记录",
            "sZeroRecords": "抱歉， 没有找到记录",
            "sInfo": "从 _START_ 到 _END_ /共 _TOTAL_ 条数据",
            "sInfoEmpty": "没有数据",
            "sInfoFiltered": "(从 _MAX_ 条数据中检索)",
            "sZeroRecords": "抱歉，没有检索到数据",
             "sSearch": "搜索:",
            "oPaginate": {
            	"sFirst": "首页",
            	"sPrevious": "上一页",
            	"sNext": "下一页",
            	"sLast": "尾页"
            }
       	}      


	});
});
</script>
</head>
<body>
<table id="example" class="display" cellspacing="0" width="100%">
				<thead>
					<tr>
						<th>Name</th>
						<th>IP</th>
						<th>Title</th>
						<th>control</th>
						
					</tr>
				</thead>
				<!-- 
				<tfoot>
					<tr>
						<th>Name</th>
						<th>Position</th>
						<th>Office</th>
						<th>Extn.</th>
						
					</tr>
				</tfoot>
				 -->	
			</table>
</body>
</html>