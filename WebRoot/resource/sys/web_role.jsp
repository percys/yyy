<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
	$('#webRoleDatagrid').datagrid({   
    rowStyler:function(index,row){   
        if (index%2==0){   
            return 'background-color:#FFC;';   
        }   
    }   
});
function addRole(){
	$("#quanxian").combotree({
		url:'role_resouce.action',
		lines:true,
		multiple:true,
		onLoadSuccess:function(node,data){
			var temp=$(this);
			if (data) {
				$(data).each(function(index,d){
					if (this.state=='closed') {
						temp.tree('expandAll');
					}
				});
			}
		}
	});
	$('#roleid').attr('disabled',null);
		$('#webRoleForm').form('clear');
        	$('#roleDialog').show().dialog({
            	title:'添加角色',
                modal:true,
                iconCls:'icon-save',
                resizable:false,
                buttons:[{
					text:'保存',
                    handler:function(){
                	var nodes = $('#quanxian').combotree('tree').tree('getChecked');
                	var quanxians=[];
                	for(var i=0;i<nodes.length;i++)
                	{
                		quanxians[i]=nodes[i].id;
                	}
                   	$.ajax({
           				url:'role_add.action',
           				data:{
           					'webRole.roleid':$('#roleid').val(),
           					'webRole.name':$('#rolename').val(),
                   			quanxians:quanxians.join(",")
           				},
           				method:'post',
           				dataType:'json',
           				success:function(r){
           					if(r&&r.success){
	           					$('#webRoleDatagrid').datagrid('load');
	           					$('#webRoleDatagrid').datagrid('unselectAll');
	           					$('#webRoleForm').form('clear');
	           					$.messager.show({
	           						title:'提示',
	           						msg:'添加成功!',
	           						timeout:3000
	           					});
	           					$('#roleDialog').dialog("close");
           					}else{
           						$.messager.show({
	           						title:'提示',
	           						msg:'添加失败!',
	           						timeout:3000
	           					});
           					}
           				}
           			});
                }
				},{
					text:'取消',
                    handler:function(){
                    	$('#roleDialog').dialog('close');
                    }
				}]
            });
        }
        
function delRole(){
            var rows =$('#webRoleDatagrid').datagrid('getSelections');
            var ids=[];
            if(rows.length>0){
            	$.messager.confirm('提示','您确定要删除当前所选项目吗?',function(bool){
            		if(bool){
            			for(var i=0;i<rows.length;i++){
            				ids[i]=rows[i].roleid;
            			}
            			$.ajax({
            				url:'role_delete.action',
            				data:{
            					ids:ids.join(',')
            				},
            				method:'post',
            				dataType:'json',
            				success:function(r){
            					if(r&&r.success){
		           					$('#webRoleDatagrid').datagrid('load');
		           					$('#webRoleDatagrid').datagrid('unselectAll');
		           					$.messager.show({
		           						title:'提示',
		           						msg:'删除成功!'
		           					});
            					}else{
            						$.messager.show({
		           						title:'提示',
		           						msg:'删除失败!'
		           					});
            					}
            				}
            			});
            		}
            	});
            }
        }

function updateRole(){
	var row = $('#webRoleDatagrid').datagrid('getSelected');
	if (row){
		$('#roleid').attr('disabled','disabled');//设置禁用
		$('#roleid').val(row.roleid);
		$('#rolename').val(row.name);
    	$("#quanxian").combotree({
    		url:'role_ResouceById.action?webRole.roleid='+row.roleid,
    		lines:true,
    		multiple:true,
    		onLoadSuccess:function(node,data){
    			var temp=$(this);
    			if (data) {
    				$(data).each(function(index,d){
    					if (this.state=='closed') {
    						temp.tree('expandAll');
    					}
    				});
    			}
    		}
    	});
	}
	$('#roleDialog').show().dialog({
    	title:'修改角色',
        modal:true,
        iconCls:'icon-save',
        resizable:false,
        buttons:[{
			text:'保存',
            handler:function(){
        		var nodes = $('#quanxian').combotree('tree').tree('getChecked');
        		var quanxians=[];
        		for(var i=0;i<nodes.length;i++)
        		{
        			quanxians[i]=nodes[i].id;
        		}
            	$.ajax({
    				url:'role_updateOld.action',
    				data:{
    					'webRole.roleid':$('#roleid').val(),
       					'webRole.name':$('#rolename').val(),
               			quanxians:quanxians.join(",")//1,2,3,4
    				},
    				method:'post',
    				dataType:'json',
    				success:function(r){
    					if(r&&r.success){
           					$('#webRoleDatagrid').datagrid('load');
           					$('#webRoleDatagrid').datagrid('unselectAll');
           					$('#roleDialog').dialog('close');
           					$('#webRoleForm').form('clear');
           					$.messager.show({
           						title:'提示',
           						msg:'修改成功!'
           					});
    					}else{
    						$.messager.show({
           						title:'提示',
           						msg:'修改失败!'
           					});
    					}
    				}
    			});
            }
		},{
			text:'取消',
            handler:function(){
            	$('#roleDialog').dialog('close');
            }
		}]
    });
	return;
}
function onSelectRow(rowIndex, rowData){
	var dg=$('#webRoleDatagrid').datagrid('getSelections');
	if(dg.length!=1){
		$('#roleEditButton').linkbutton('disable');
	}else{
		$('#roleEditButton').linkbutton('enable');
	}
}
</script>
<div id="roletoolbar">
	<form id="searchWebRoleForm">
		角色名称：<input name="queryWebRole.name" />
		<a href="javascript:" class="easyui-linkbutton" plain="false" iconCls="icon-search" onclick="searchForm('#webRoleDatagrid','#searchWebRoleForm')">查询</a>
		<a href="javascript:" class="easyui-linkbutton" plain="false" iconCls="icon-search" onclick="formClean('#searchWebRoleForm')">清空</a>
		<br />
		<br />
		<a href="javascript:" class="easyui-linkbutton" plain="true" iconCls="icon-add" onclick="addRole()">增加</a>
		<a id="roleEditButton" href="javascript:" class="easyui-linkbutton" disabled="true" plain="true" iconCls="icon-edit" onclick="updateRole()">编辑</a>
		<a href="javascript:" class="easyui-linkbutton" plain="true" iconCls="icon-cancel" onclick="delRole()">删除</a>
	</form>
</div>
<table id="webRoleDatagrid" class="easyui-datagrid" style="height: 400px; width: 100px;"
data-options="title:'角色管理',url:'role_list.action',border:false,fit:true,fitColumns:false,columns:[[
{field:'ck',checkbox:true,halign:'center'},
{field:'roleid',title:'角色编号',width:70,sortable:false,align:'center'},
{field:'name',title:'角色名称',width:150,halign:'center'},
{field:'orderno',title:'角色排序',width:100,align:'center'},
{field:'rolelevel',title:'角色等级',width:100,halign:'center'},
{field:'posdetail',title:'工位(备用)',width:100,align:'center'},
{field:'rtype',title:'角色类型',width:100,align:'center'}
]],toolbar: '#roletoolbar',pagination:true,nowrap:false,onSelect:onSelectRow,onUnselect:onSelectRow
">
</table>
<div id="roleDialog" style="width: 400px; height: 200px; display: none; padding: 10px;">
	<form id="webRoleForm">
		<table style="padding-left: 20px;">
			<tr>
				<th>角色编号</th>
				<td><input id="roleid" name="webRole.roleid" class="easyui-validatebox" data-options="required:true" /></td>
			</tr>
			<tr>
				<th>角色名称</th>
				<td><input id="rolename" name="webRole.name" class="easyui-validatebox" data-options="required:true" /></td>
			</tr>
			<tr>
				<th>角色权限</th>
				<td>
				<select id="quanxian" style="width:200px;"></select>
				</td>
			</tr>
		</table>
	</form>
</div>