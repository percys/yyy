<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<style type="text/css">
.unit-padd
{
	padding: 5px 8px;
	font-family: "微软雅黑";
}
</style>
<script type="text/javascript">
	$('#webUnitDatagrid').datagrid({   
    rowStyler:function(index,row){   
        if (index%2==0){   
            return 'background-color:#FFC;';   
        }   
    }   
});
function onUnSelectRow(rowIndex, rowData){
	var dg=$('#webUnitDatagrid').datagrid('getSelections');
	if(dg.length!=1){
		$('#webUnitEditButton').linkbutton('disable');
	}else{
		$('#webUnitEditButton').linkbutton('enable');
	}
}
	function parentWebUnitFormatter(value,row,index){
		if(row['webUnit']!=null){
			return row['webUnit']['name'];
		}
		return null;
	}
	function addForm()
	{
		$('#webUnitForm').form('clear');
		$('#unitid').attr('readonly',null);
		//加载部门tree
		$("#webUnitParent").combotree({
			url:'unit_unitTree.action',
			lines:true,
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
    	$('#WebUnitDialog').show().dialog({
        	title:'添加部门',
            modal:true,
            iconCls:'icon-save',
            resizable:false,
            buttons:[{
				text:'保存',
				iconCls:'icon-ok',
                handler:function(){
                	if(!$("#webUnitForm").form("validate")){return;}
            		$.post("unit_add.action",$("#webUnitForm").serialize(),function(r){
            			if (r&&r.success) {
           					$.messager.show({title:'提示',msg:'添加成功!',timeout:3000});
            				$('#webUnitDatagrid').datagrid('load');
           					$('#webUnitDatagrid').datagrid('unselectAll');
           					$('#WebUnitDialog').dialog("close");
            			}else{
            				$.messager.show({title:'提示',msg:r.msg,timeout:3000});
            			}
            		},"json");
                }
			},{
				text:'取消',
				iconCls:'icon-cancel',
                handler:function(){
                	$('#WebUnitDialog').dialog('close');
                }
			}]
        });
	}
	
function editForm()
{
	$('#webUnitForm').form('clear');
	$('#unitid').attr('readonly','readonly');
	var row = $('#webUnitDatagrid').datagrid('getSelected');
	if (row){
		//加载部门tree
		$("#webUnitParent").combotree({
			url:'unit_unitTree.action',
			lines:true,
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
		$('#unitid').val(row.unitid);
		$('#name').val(row.name);
		$('#areano').val(row.areano);
		$('#bz').val(row.bz);
		$('#webUnitParent').combotree("setValue",row.webUnit.unitid);
    	$('#WebUnitDialog').show().dialog({
        	title:'编辑部门',
            modal:true,
            iconCls:'icon-save',
            resizable:false,
            buttons:[{
				text:'保存',
				iconCls:'icon-ok',
                handler:function(){
                	if(!$("#webUnitForm").form("validate")){return;}
            		$.post("unit_update.action",$("#webUnitForm").serialize(),function(r){
            			if (r&&r.success) {
           					$.messager.show({title:'提示',msg:'保存成功!',timeout:3000});
            				$('#webUnitDatagrid').datagrid('load');
           					$('#webUnitDatagrid').datagrid('unselectAll');
           					$('#WebUnitDialog').dialog("close");
            			}else{
            				$.messager.show({title:'提示',msg:r.msg,timeout:3000});
            			}
            		},"json");
                }
			},{
				text:'取消',
				iconCls:'icon-cancel',
                handler:function(){
                	$('#WebUnitDialog').dialog('close');
                }
			}]
        });
	}
}

	function delUnit()
	{
		var rows =$('#webUnitDatagrid').datagrid('getSelections'); //获得所有选中的行
        var ids=[];   //存放选中行的id
        if(rows.length>0){
        	$.messager.confirm('提示','您确定要删除当前所选项目吗?',function(bool){
        		if(bool){
        			for(var i=0;i<rows.length;i++){
        				ids[i]=rows[i].unitid;
        			}//[1,3,4,7]
        			$.ajax({
        				url:'unit_delete.action',
        				data:{
        					ids:ids.join(',')//ids: ids.join()意思是拼接数组为字符串，以,号隔开1,2,3,4,5
        				},
        				type:'post',
        				dataType:'json',
        				success:function(r){
        					if(r&&r.success){
	           					$('#webUnitDatagrid').datagrid('load');
	           					$('#webUnitDatagrid').datagrid('unselectAll');
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
</script>

<div id="toolbar" style="padding: 10px 10px 10px 20px;">
	<form id="searchWebUnitForm">
		<table>
			<tr>
				<th>部&nbsp;门&nbsp;编&nbsp;号：</th>
				<td><input name="queryWebUnit.unitid" /></td>
				<th>部&nbsp;门&nbsp;名&nbsp;称：</th>
				<td><input name="queryWebUnit.name" /></td>
				<td><a href="javascript:" class="easyui-linkbutton" plain="false" iconCls="icon-search" onclick="searchForm('#webUnitDatagrid','#searchWebUnitForm')">查询</a></td>
			</tr>
			<tr>
				<th>部&nbsp;门&nbsp;区&nbsp;号：</th>
				<td><input name="queryWebUnit.areano" /></td>
				<th>上级部门名称：</th>
				<td><input name="queryWebUnit.fatherName" /></td>
				<td><a href="javascript:" class="easyui-linkbutton" plain="false" iconCls="icon-cancel" onclick="formClean('#searchWebUnitForm')">清空</a></td>
			</tr>
		</table>
		<a href="javascript:" class="easyui-linkbutton" plain="true" iconCls="icon-remove" onclick="addForm()">添加</a>
		<a href="javascript:" id="webUnitEditButton" disabled="true" class="easyui-linkbutton" plain="true" iconCls="icon-edit" onclick="editForm()">修改</a>
		<a href="javascript:" class="easyui-linkbutton" plain="true" iconCls="icon-cancel" onclick="delUnit()">删除</a>
	</form>
</div>
<table id="webUnitDatagrid"  class="easyui-datagrid" data-options="title:'部门管理',url:'unit_list.action',border:false,fit:true,height:600,fitColumns:true,toolbar:'#toolbar',rownumbers:true,
pagination:true,nowrap:false,checkOnSelect:true,selectOnCheck:true,onSelect:onUnSelectRow,onUnselect:onUnSelectRow">
	<thead>
		<tr>
			<th data-options="field:'ck',checkbox:true"></th>
			<th data-options="field:'unitid',width:100,align:'center'">部门编号</th>
			<th data-options="field:'name',width:100,align:'center'">部门名称</th>
			<th data-options="field:'areano',width:100,align:'center'">区号</th>
			<th data-options="field:'webUnit.name',width:100,align:'center',formatter:parentWebUnitFormatter">上级部门</th>
			<th data-options="field:'bz',width:100,align:'center'">部门说明</th>
		</tr>
	</thead>
</table>
<div id="WebUnitDialog" style="width:300px;height:300px; display:none; padding:10px 10px 10px 20px;">
<form id="webUnitForm">
<table>
	<tr>
		<th>部门编号</th>
		<td class="unit-padd"><input id="unitid" name="webUnit.unitid" class="easyui-validatebox" data-options="required:true" style="width:150px;" /></td>
	</tr>
	<tr>
		<th>部门名称</th>
    	<td class="unit-padd"><input id="name" name="webUnit.name" class="easyui-validatebox" data-options="required:true" style="width:150px;" /></td>
	</tr>
    <tr>
		<th>区号</th>
		<td class="unit-padd"><input id="areano" name="webUnit.areano" class="easyui-validatebox" style="width:150px;" /></td>
	</tr>
	<tr>
		<th>上级部门</th>
    	<td class="unit-padd"><select id="webUnitParent" name="webUnit.webUnit.unitid" style="width:150px;"></select></td>
	</tr>
    <tr>
		<th>部门说明</th>
		<td class="unit-padd"><textarea id="bz" name="webUnit.bz" style="width: 150px; height: 60px; overflow: hidden;resize: none"></textarea></td>
	</tr>
</table>
</form>
</div>