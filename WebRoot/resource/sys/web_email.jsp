<%@ page language="java" import="java.util.*" pageEncoding="UTf-8"%>

<script type="text/javascript" charset="utf-8">

function onSendSelectRow(rowIndex, rowData){
	var dg=$('#datagrid_acc').datagrid('getSelections');
	if(dg.length!=1){
		$('#sendEditButton').linkbutton('disable');
	}else{
		$('#sendEditButton').linkbutton('enable');
	}
}
function onSendUnSelectRow(rowIndex, rowData){
	var dg=$('#datagrid_acc').datagrid('getSelections');
	if(dg.length!=1){
		$('#sendEditButton').linkbutton('disable');
	}else{
		$('#sendEditButton').linkbutton('enable');
	}
}

function onSendsSelectRows(rowIndex, rowData){
	var dg=$('#datagrid_send').datagrid('getSelections');
	if(dg.length!=1){
		$('#sendEditButtons').linkbutton('disable');
	}else{
		$('#sendEditButtons').linkbutton('enable');
	}
}
function onSendsUnSelectRows(rowIndex, rowData){
	var dg=$('#datagrid_send').datagrid('getSelections');
	if(dg.length!=1){
		$('#sendEditButtons').linkbutton('disable');
	}else{
		$('#sendEditButtons').linkbutton('enable');
	}
}

function formatDate(date, format) {
    if (!date) return;
    if (!format) format = "yyyy-MM-dd";
    switch(typeof date) {
        case "string":
            date = new Date(date.replace(/-/, "/"));
            break;
        case "number":
            date = new Date(date);
            break;
    } 
    if (!date instanceof Date) return;
    var dict = {
        "yyyy": date.getFullYear(),
        "M": date.getMonth() + 1,
        "d": date.getDate(),
        "H": date.getHours(),
        "m": date.getMinutes(),
        "s": date.getSeconds(),
        "MM": ("" + (date.getMonth() + 101)).substr(1),
        "dd": ("" + (date.getDate() + 100)).substr(1),
        "HH": ("" + (date.getHours() + 100)).substr(1),
        "mm": ("" + (date.getMinutes() + 100)).substr(1),
        "ss": ("" + (date.getSeconds() + 100)).substr(1)
    };    
    return format.replace(/(yyyy|MM?|dd?|HH?|ss?|mm?)/g, function() {
        return dict[arguments[0]];
    });                
}

	$('#datagrid_acc').datagrid({   
    rowStyler:function(index,row){   
        if (index%2==0){   
            return 'background-color:#FFC;';   
        }
    }   
});
	var datagrid_acc;
	var editRow = undefined;
	$(function() {
	
		datagrid_acc = $('#datagrid_acc').datagrid( {
			url : 'eamil_getAll.action',
			pagination : true,
			pageSize : 5,
			pageList : [ 5, 10, 20],
			fit : true,
			fitColumns : true,
			nowarp : false,
			border : false,
			idField : 'mbId',
			columns : [ [ {
				title : '编号',
				field : 'mbId',
				width : 200,
				sortable : true,
				checkbox : true
			}, {
				title : '状态',
				field : 'mbState',
				width : 200,
				formatter:function(value,rowData,rowIndex){   
				if(value==0){
    			return '<span style="color:red">未读</span>';
    			}else{
    			return '<span style="color:green">已读</span>';
    			} 
    			//return value.mdSendTime; 
				}
			
			}, {
				title : '发送人',
				field : 'sendname',
				width : 200
				
			}
			, {
				title : '主题',
				field : 'mdTitle',
				width : 200,
				formatter:function(value,rowData,rowIndex){   
    			return rowData.mailboxDetails.mdTitle; 
    			//return value.mdTitle; 
				}	
			}
			,
			{
				title : '时间',
				field : 'mdSendTime',
				width : 200,
				formatter:function(value,rowData,rowIndex){   
    			return rowData.mailboxDetails.mdSendTime; 
    			//return value.mdSendTime; 
				}
			}
			 ] ],
			toolbar : [ {
				text : '发件箱',
				iconCls : 'icon-edit',
				handler : function(){
				
			datagrid_send = $('#datagrid_send').datagrid( {
			url : 'eamil_getAlls.action',
			iconCls : 'icon-save',
			pagination : true,
			pageSize : 5,
			pageList : [ 5, 10, 20],
			fit : true,
			fitColumns : true,
			nowarp : false,
			border : false,
			idField : 'mbId',
			columns : [[ {
				title : '编号',
				field : 'mbId',
				width : 200,
				sortable : true,
				checkbox : true
			}, {
				title : '状态',
				field : 'mbState',
				width : 200,
				formatter:function(value,rowData,rowIndex){   
				if(value==0){
    			return '<span style="color:red">未读</span>';
    			}else{
    			return '<span style="color:green">已读</span>';
    			} 
				}
			
			}, {
				title : '收件人',
				field : 'receivename',
				width : 200
				
			}
			, {
				title : '主题',
				field : 'mdTitle',
				width : 200,
				formatter:function(value,rowData,rowIndex){   
    			return rowData.mailboxDetails.mdTitle; 
    			//return value.mdTitle; 
				}	
			}
			,
			{
				title : '时间',
				field : 'mdSendTime',
				width : 200,
				formatter:function(value,rowData,rowIndex){   
    			return rowData.mailboxDetails.mdSendTime; 
    			//return value.mdSendTime; 
				}
			}
			 ] ],
			toolbar : [ {
				text : '查看信息',
				id : 'sendEditButtons',
				disabled : true,
				iconCls : 'icon-redo',
				handler : function(){
				var row = $('#datagrid_send').datagrid('getSelected');
				$('#websendEditForm #title').val(row.mailboxDetails.mdTitle);
				$('#websendEditForm #sendname').val(row.sendname);
				$('#websendEditForm #mdSendTime').val(row.mailboxDetails.mdSendTime);
				$('#websendEditForm #receivename').val(row.receivename);
				$('#websendEditForm #mdContent').val(row.mailboxDetails.mdContent);
				$("#websendEditDialog").show().dialog({
	       		title:'查看信息',
	       	 modal:true,
	         iconCls:'icon-save',
	        resizable:false,
	        buttons:[{
	        	text:'确定',
	        	handler:function(){
					$('#websendEditDialog').dialog('close');
	        	
	        	}
	        },{
	        	text:'返回',
	        	handler:function(){
	        		$('#websendEditDialog').dialog('close');
	        	
	        	}
	        }]
		});
				
				}
			}],
			onSelect:onSendsSelectRows,
			onUnselect:onSendsUnSelectRows
		});	
	        $("#sendEditDialog").show().dialog({
	       	title:'发件箱',
	        modal:true,
	        iconCls:'icon-save',
	        resizable:false,
	        buttons:[{
	        	text:'确定',
	        	handler:function(){
	        	$('#sendEditDialog').dialog('close');
	        	}
	        },{
	        	text:'返回',
	        	handler:function(){
	        		$('#sendEditDialog').dialog('close');
	        	}
	        }]
		});
				}
			}, '-' ,{
				text : '标示为已读',
				iconCls : 'icon-save',
				handler : function(){
					var ids = [];
				var rows = $('#datagrid_acc').datagrid('getSelections');
				if (rows.length > 0) {
				$.messager.confirm('请确认', '全部标示为已读？', function(r) {
				console.info( rows.length);
				if (r) {
					for ( var i = 0; i < rows.length; i++) {
						ids.push(rows[i].mbId);
						
					}
					console.info(ids.join(','));
					$.ajax({
						url : 'eamil_updateAll.action',
						data : {
							ids : ids.join(',')
						},
						cache : false,
						dataType : "json",
						success : function(r) {
						if (r&&r.success) {
							$.messager.show({
							title:'提示',
							msg:r.msg,
							timeout:5000
							});
							}
							$('#datagrid_acc').datagrid('load',{});
						}
					});
				}
			});
		} else {
			$.messager.alert('提示', '请选择要标识的记录！', 'error');
		}
				}
			}, '-',{
				id : 'sendEditButton',
				text : '查看信息',
				disabled : true,
				iconCls : 'icon-redo',
				handler : function(){
				 var editor = UE.getEditor('mdContent');
 				 function here(str){
   				 //alert(editor.getContent());
   				 //"<span>\$\{"+var1+"</span\>}"
  				  editor.execCommand("insertHtml",str,true);
  					}
				var row = $('#datagrid_acc').datagrid('getSelected');
					$.post("eamil_updateState.action",{
					'Mailid':row.mbId
				});
				$('#websendEditForm #title').val(row.mailboxDetails.mdTitle);
				$('#websendEditForm #sendname').val(row.sendname);
				$('#websendEditForm #mdSendTime').val(row.mailboxDetails.mdSendTime);
				$('#websendEditForm #receivename').val(row.receivename);
				$('#websendEditForm #mdContent').val(row.mailboxDetails.mdContent);
				$("#websendEditDialog").show().dialog({
	       	title:'查看信息',
	        modal:true,
	        iconCls:'icon-save',
	        resizable:false,
	        buttons:[{
	        	text:'回复',
	        	handler:function(){
	        	 var editor = UE.getEditor('info');
 				 function here(str){
   				 //alert(editor.getContent());
   				 //"<span>\$\{"+var1+"</span\>}"
  				  editor.execCommand("insertHtml",str,true);
  					}
				$('#webEditForm #cont').val('回复:'+row.mailboxDetails.mdTitle);
				$('#webEditForm #send').val(row.receivename);
				$('#webEditForm #date').val(formatDate(new Date(), "yyyy-MM-dd"));
				$('#webEditForm #receive').val(row.sendname);
	        $('#websendEditDialog').dialog('close');
	        $("#webEditDialog").show().dialog({
	       	title:'查看信息',
	        modal:true,
	        iconCls:'icon-save',
	        resizable:false,
	        buttons:[{
	        	text:'确定',
	        	handler:function(){
	        		if(!$("#webEditForm").form("validate")){return;}
	        		$.post("eamil_save.action",$("#webEditForm").serialize(),function(r){
	        			if (r&&r.success) {
	       					$.messager.show({title:'提示',msg:r.msg,timeout:3000});
	        			
	        			}else{
	        				$.messager.show({title:'提示',msg:r.msg,timeout:3000});
	        			}
	        		},"json");
	        	}
	        },{
	        	text:'返回',
	        	handler:function(){
	        		$('#webEditDialog').dialog('close');
	        		$('#datagrid_acc').datagrid('load',{});
	        	}
	        }]
		});
	        	}
	        },{
	        	text:'返回',
	        	handler:function(){
	        		$('#websendEditDialog').dialog('close');
	        		$('#datagrid_acc').datagrid('load',{});
	        	}
	        }]
		});
				}
			},'-'],
			onSelect:onSendSelectRow,
			onUnselect:onSendUnSelectRow
		});
		

	

	});


</script>
<table id="datagrid_acc" title="通知中心" ></table>

<div id="websendEditDialog" style="width: 530px; height: 400px; display:none; padding: 10px;">
	<form id="websendEditForm">
		<table style="text-align: left;">
			<tr>
				<td height="30px">标题:</td>
				<td><input id="title" disabled="true" readOnly="true"  /></td>
			</tr>
			<tr>
				<td height="30px">发件人:</td>
				<td><input id="sendname" disabled="true" readOnly="true"/></td>
			</tr>
			<tr>
			<td height="30px">时间:</td>
				<td><input id="mdSendTime" disabled="true" readOnly="true"/></td>
			</tr>
			<tr>
				<td height="30px" >收件人:</td>
				<td><input id="receivename"disabled="true" readOnly="true" /></td>
			</tr>
			<tr>
				<td height="30px">内容:</td>
				<td colspan="3">
				<textarea id="mdContent" disabled="true" readOnly="true" style="width: 390px; height: 80px; overflow: hidden;resize: none"></textarea>
				</td>
			</tr>
		</table>
	</form>
</div>


<div id="webEditDialog" style="width: 530px; height: 400px; display:none; padding: 10px;">
	<form id="webEditForm">
		<table style="text-align: left;">
			<tr>
				<td height="30px">标题:</td>
				<td><input id="cont"  name="mailbox.mailboxDetails.mdTitle" readOnly="true"/></td>
			</tr>
			<tr>
				<td height="30px">发件人:</td>
				<td><input id="send"  name="mailbox.sendname"  readOnly="true" /></td>
			</tr>
			<tr>
				<td height="30px">时间:</td>
				<td><input id="date" name="mailbox.mailboxDetails.mdSendTime"  readOnly="true" /></td>
			</tr>
			<tr>
				<td height="30px">收件人:</td>
				<td><input id="receive" name="mailbox.receivename" readOnly="true"/></td>
			</tr>
			<tr>
				<td height="30px">内容:</td>
				<td colspan="3">
				<textarea id="info" name="mailbox.mailboxDetails.mdContent"  style="width: 390px; height: 80px; overflow: hidden;resize: none"></textarea>
				</td>
			</tr>
		</table>
	</form>
</div>


<div id="sendEditDialog" style="width: 530px; height: 360px; display:none;">
<table id="datagrid_send"></table>
</div>