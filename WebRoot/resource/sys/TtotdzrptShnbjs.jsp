<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
	$('#webNbDatagrid').datagrid({   
    rowStyler:function(index,row){   
        if (index%2==0){   
            return 'background-color:#FFC;';   
        }   
    }   
});
function csv(){
	var orgcode=document.getElementById('orgcode').value;
	var begindate=$('#begindate').datebox('getValue');	
	var enddate=$('#enddate').datebox('getValue');
	var grid = $('#webNbDatagrid');  
	var options = grid.datagrid('getPager').data("pagination").options;  
    var url = 'internal_csv.action?page='+options.pageNumber+'&rows='+options.total+'&orgcode='+orgcode+'&begindate='+begindate+'&enddate='+enddate;  
    window.location.href = url; 
};

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
	           					$('#webNbDatagrid').datagrid('load');
	           					$('#webNbDatagrid').datagrid('unselectAll');
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
            var rows =$('#webNbDatagrid').datagrid('getSelections');
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
		           					$('#webNbDatagrid').datagrid('load');
		           					$('#webNbDatagrid').datagrid('unselectAll');
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
	var row = $('#webNbDatagrid').datagrid('getSelected');
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
           					$('#webNbDatagrid').datagrid('load');
           					$('#webNbDatagrid').datagrid('unselectAll');
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
	var dg=$('#webNbDatagrid').datagrid('getSelections');
	if(dg.length!=1){
		$('#roleEditButton').linkbutton('disable');
	}else{
		$('#roleEditButton').linkbutton('enable');
	}
}
</script>
<script type="text/javascript">
		function myformatter(date){
			var y = date.getFullYear();
			var m = date.getMonth()+1;
			var d = date.getDate();
			return y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d);
		}
		function myparser(s){
			if (!s) return new Date();
			var ss = (s.split('-'));
			var y = parseInt(ss[0],10);
			var m = parseInt(ss[1],10);
			var d = parseInt(ss[2],10);
			if (!isNaN(y) && !isNaN(m) && !isNaN(d)){
				return new Date(y,m-1,d);
			} else {
				return new Date();
			}
		}
	</script>
<div id="inroletoolbar">
	<form id="inWebRoleForm">
		日期查询：<input id="begindate" type="text" class="easyui-datetimebox" name="internb.beginDate"  data-options="formatter:myformatter,parser:myparser" style="width: 200px;"  >
		&nbsp;&nbsp;&nbsp;至&nbsp;&nbsp;&nbsp;
		<input id="enddate" type="text" class="easyui-datetimebox"  data-options="formatter:myformatter,parser:myparser" name="internb.endDate" style="width: 200px;">
		组织编码：<input id="orgcode" type="text" name="internb.orgcode" style="width: 150px; ">
		<a href="javascript:" class="easyui-linkbutton" plain="false" iconCls="icon-search" onclick="searchForm('#webNbDatagrid','#inWebRoleForm')">查询</a>
		<a href="javascript:" class="easyui-linkbutton" plain="false" iconCls="icon-search" onclick="formClean('#inWebRoleForm')">清空</a>
		
		<br />
		<br />
		<a href="javascript:" class="easyui-linkbutton" plain="true" iconCls="icon-print" onclick="csv()">导出</a>
	</form>
</div>
<table id="webNbDatagrid" class="easyui-datagrid" style="height: 400px; width: 100px;"
data-options="title:'账单详细列表',url:'internal_getAll.action',border:false,fit:true,fitColumns:false,columns:[[
{field:'ck',checkbox:true,halign:'center'},
{field:'tid',title:'账单编号',width:70,sortable:false,align:'center'},
{field:'entid',title:'组织编码',width:150,halign:'center'},
{field:'rptdate',title:'报表日期',width:100,align:'center'},
{field:'orgcode',title:'组织编码',width:100,halign:'center'},
{field:'orgname',title:'组织名称',width:100,align:'center'},
{field:'pstotal',title:'配送金额',width:100,align:'center'},
{field:'thtotal',title:'退货金额',width:100,align:'center'},
{field:'bstotal',title:'报损金额',width:100,align:'center'},
{field:'zltotal',title:'作料金额',width:100,align:'center'},
{field:'mdzl',title:'门店质量',width:100,align:'center'},
{field:'gkth',title:'顾客退货',width:100,align:'center'},
{field:'sunhaototal',title:'损耗',width:100,align:'center'},
{field:'sgmltotal',title:'手工抹零',width:100,align:'center'},
{field:'kdtotal',title:'口袋金额',width:100,align:'center'},
{field:'gqtotal',title:'过期退货',width:100,align:'center'},
{field:'savetotal',title:'卡存款',width:100,align:'center'},
{field:'sstotal',title:'刷卡消费',width:100,align:'center'},
{field:'jfzftotal',title:'积分支付金额',width:100,align:'center'},
{field:'cqtotal',title:'总金额结算',width:100,align:'center'},
{field:'xstotal',title:'销售金额',width:100,align:'center'}
]],toolbar: '#inroletoolbar',pagination:true,nowrap:false,onSelect:onSelectRow,onUnselect:onSelectRow
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