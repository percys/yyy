
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<style>
.usertd{
	padding: 5px 8px;
	font-family: "微软雅黑";
}
</style>
<script type="text/javascript">
	$('#webUserDatagrid').datagrid({   
    rowStyler:function(index,row){   
        if (index%2==0){
            return 'background-color:#FFC;';
        }   
    }   
});

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
$(function(){
	$("#webUserAddForm").find("td").addClass("usertd");
});
function webUserIsuseFormatter(value,row,index){
	if (value=='T') {
		return '正常';
	}
	return '禁用';
}
function webUnitNameFormatter(value,row,index){
	return row['webUnit']['name'];
}
function onUserSelectRow(rowIndex, rowData){
	var dg=$('#webUserDatagrid').datagrid('getSelections');
	if(dg.length!=1){
		$('#userEditButton').linkbutton('disable');
	}else{
		$('#userEditButton').linkbutton('enable');
	}
}
function onUserUnSelectRow(rowIndex, rowData){
	var dg=$('#webUserDatagrid').datagrid('getSelections');
	if(dg.length!=1){
		$('#userEditButton').linkbutton('disable');
	}else{
		$('#userEditButton').linkbutton('enable');
	}
}
/**
 * 添加用户
 */
function addUser(){
	$('#webUserAddForm').form('clear');
	//加载部门tree
	$("#addWebUnit").combotree({
		url:'unit_unitTree.action',
		lines:true,
		required:true,
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
	//加载角色tree
	$("#addWebRole").combobox({
		url:'role_getAllRole.action',
		required:true,
		valueField:'roleid',
		textField:'name',
		multiple:true,
		panelHeight:150
	});
	//加载门店编码
	$("#addOrgCode").combobox({
		url:'user_getOrgCode.action',
		required:true,
		valueField:'orgcode',
		textField:'orgname',
		multiple:true,
		panelHeight:150
	});
	//显示添加用户表单
	$("#webUserAddDialog").show().dialog({
       	title:'添加用户',
        modal:true,
        iconCls:'icon-save',
        resizable:false,
        buttons:[{
        	text:'保存',
        	handler:function(){
        		if(!$("#webUserAddForm").form("validate")){return;}
        		$.post("user_add.action",$("#webUserAddForm").serialize(),function(r){
        			if (r&&r.success) {
       					$.messager.show({title:'提示',msg:'添加成功!',timeout:3000});
        				$('#webUserDatagrid').datagrid('load');
       					$('#webUserDatagrid').datagrid('unselectAll');
       					$('#webUserAddDialog').dialog("close");
        			}else{
        				$.messager.show({title:'提示',msg:r.msg,timeout:3000});
        			}
        		},"json");
        	}
        },{
        	text:'取消',
        	handler:function(){
        		$('#webUserAddDialog').dialog('close');
        	}
        }]
	});
}
function delUser(){
    var rows =$('#webUserDatagrid').datagrid('getSelections');
    var ids=[];
    if(rows.length>0){
    	$.messager.confirm('提示','您确定要删除当前所选项目吗?',function(bool){
    		if(bool){
    			for(var i=0;i<rows.length;i++){
    				ids[i]=rows[i].userid;
    			}
    			$.ajax({
    				url:'user_delete.action',
    				data:{ids:ids.join(',')},
    				method:'post',
    				dataType:'json',
    				success:function(r){
    					if(r&&r.success){
           					$('#webUserDatagrid').datagrid('load');
           					$('#webUserDatagrid').datagrid('unselectAll');
           					$.messager.show({title:'提示',msg:r.msg,timeout:3000});
    					}else{
    						$.messager.show({title:'提示',msg:r.msg,timeout:3000});
    					}
    				}
    			});
    		}
    	});
    }
}

function editUser(){
	$('#webUserEditForm').form('clear');
	var row = $('#webUserDatagrid').datagrid('getSelected');
	if (row){
		//加载部门tree
		$("#webUserEditForm #addWebUnit").combotree({
			url:'unit_unitTree.action',
			required:true,
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
		//加载角色
		$("#webUserEditForm #addWebRole").combobox({
			url:'role_getAllRole.action',
			required:true,
			valueField:'roleid',
			textField:'name',
			multiple:true,
			panelHeight:150,
			onLoadSuccess:function (){
				$.post("role_getUserRoles.action",{
					'webUser.userid':row.userid
				},function(r){
					var roles=[];
					$.each(r,function(index, data){
						roles[index]=data.roleid;
					});
					$('#webUserEditForm #addWebRole').combobox("setValues",roles);
				},"json");
			}
		});
		//加载门店编码
		$("#webUserEditForm #addOrgCode").combobox({
			url:'user_getOrgCode.action',
			required:true,
			valueField:'orgcode',
			textField:'orgname',
			multiple:true,
			panelHeight:150,
			onLoadSuccess:function (){
				$.post("user_getUserOrgCode.action",{
					'webUser.orgcode':row.orgcode
				},function(r){
					var orgname=[];
					$.each(r,function(index, data){
						orgname[index]=data.orgcode;
					});
					$('#webUserEditForm #addOrgCode').combobox("setValues",orgname);
				},"json");
			}
		});
		$('#webUserEditForm #userid').val(row.userid);
		$('#webUserEditForm #username').val(row.username);
		$('#webUserEditForm #password').val(row.password);
		$('#webUserEditForm #bz').val(row.bz);
		$('#webUserEditForm #agentId').val(row.agentId);
		$('#webUserEditForm #addOrgCode').val(row.orgname);
		$('#webUserEditForm #isuse').val(row.isuse);
		$('#webUserEditForm #addWebUnit').combotree("setValue",row.webUnit.unitid);
		$("#webUserEditDialog").show().dialog({
	       	title:'编辑用户',
	        modal:true,
	        iconCls:'icon-save',
	        resizable:false,
	        buttons:[{
	        	text:'保存',
	        	handler:function(){
	        		if(!$("#webUserEditForm").form("validate")){return;}
	        		$.post("user_save.action",$("#webUserEditForm").serialize(),function(r){
	        			if (r&&r.success) {
	       					$.messager.show({title:'提示',msg:'保存成功!',timeout:3000});
	        				$('#webUserDatagrid').datagrid('load');
	       					$('#webUserDatagrid').datagrid('unselectAll');
	       					$('#webUserEditDialog').dialog("close");
	        			}else{
	        				$.messager.show({title:'提示',msg:r.msg,timeout:3000});
	        			}
	        		},"json");
	        	}
	        },{
	        	text:'取消',
	        	handler:function(){
	        		$('#webUserEditDialog').dialog('close');
	        	}
	        }]
		});
	}
}
function valid(){
	var agentId=$("#agentId").val();
	alert(agentId+"asdasdsad");
			$.ajax({
				url:"user_valid.action",
				type:"POST",
				dataType:"text",
				success: function(r){
					alert(r);
					$("#agentId").val(r);
				},
				error:function(jqXHR,textStatus,errorThrown){
					alert(jqXHR.responseText+"未找到该员工号码,请确认!");
				}
			});
	}
		
	$(function () {
		//绑定tabs的右键菜单
		$("#webUserDatagrid").datagrid({
			onRowContextMenu : function (e, title) {
				e.preventDefault();
				$('#tabsUserMenu').menu('show', {
					left : e.pageX,
					top : e.pageY
				}).data("tabTitle", title);
		}
	});
	//实例化menu的onClick事件
	$("#tabsUserMenu").menu({
		onClick : function (item) {
			addMailBox();
		}
	});
	
	//发送通知
	function addMailBox(){        
		var ids = [];
		var rows =$('#webUserDatagrid').datagrid('getSelections');
		if (rows.length > 0) {
			for ( var i = 0; i < rows.length; i++) {
				ids.push(rows[i].username);
			}
		$('#webMailboxAddForm #sendname').val(ids.join(','));
		$('#webMailboxAddForm #date').val(formatDate(new Date(), "yyyy-MM-dd"));
 		$("#webMailboxDialog").show().dialog({                                                    
        title:'发布通知',                                                                                                                                                                                       
        iconCls:'icon-save',   
        resizable:false,
        buttons:[{                                                                                               
          text:'发送',                                                                                             
          handler:function(){                                                                                 
              if(!$("#webMailboxAddForm").form("validate")){return;}                                            
            	 $.post("eamil_savesend.action",$("#webMailboxAddForm").serialize(),function(r){                            
	              if (r&&r.success) {                                                           
	                 $.messager.show({title:'提示',msg:'添加成功!',timeout:3000});                                         
	                 $('#webUserDatagrid').datagrid('load');                                                          
	                 $('#webUserDatagrid').datagrid('unselectAll');                                                  
	                 $('#webMailboxDialog').dialog("close");                                                 
	              }else{                                                                                             
	                 $.messager.show({title:'提示',msg:r.msg,timeout:3000});                                            
	              }                                                                                                  
            },"json");                                                                                           
          }                                                                                                      
        },{                                                                                                      
          text:'取消',                                                                                             
          handler:function(){                                                                                    
            $('#webMailboxDialog').dialog('close');                                                              
          }                                                                                                      
        }]                                                                                                       
  });                                                                                                            
	}}                                                                                                            
});      
                                                     
</script>
<div id="userToolbar">
	<form id="searchWebUserForm">
		<table>
			<tr>
				<th>用&nbsp;户&nbsp;编&nbsp;号：</th>
				<td><input name="queryWebUser.userid" /></td>
				<th>用&nbsp;户&nbsp;名&nbsp;称：</th>
				<td><input name="queryWebUser.username" /></td>
				<td><a href="javascript:" class="easyui-linkbutton" plain="false" iconCls="icon-search" onclick="searchForm('#webUserDatagrid','#searchWebUserForm')">查询</a></td>
			</tr>
			<tr>
				<th>用&nbsp;户&nbsp;部&nbsp;门：</th>
				<td><input name="queryWebUser.webUnit.name" /></td>
				<th>用户状态：</th>
				<td><select name="webUser.isuse" style="width:150px;">
					<option value="T">正常</option>
					<option value="F">禁用</option>
				</select></td>
				<th>门店性质：</th>
				<td><select name="queryWebUser.bz" name="roles" style="width:150px;">
					<option></option>
					<option>内部加盟</option>
					<option>外部加盟</option>
					<option>直营加盟</option>
					<option>个体加盟</option>
				</select></td>
				<td><a href="javascript:" class="easyui-linkbutton" plain="false" iconCls="icon-cancel" onclick="formClean('#searchWebUserForm')">清空</a></td>
			</tr>
		</table>
		<a href="javascript:" class="easyui-linkbutton" plain="true" iconCls="icon-add" onclick="addUser()">增加</a>
		<a id="userEditButton" href="javascript:" class="easyui-linkbutton" disabled="true" plain="true" iconCls="icon-edit" onclick="editUser()">编辑</a>
		<a href="javascript:" class="easyui-linkbutton " plain="true" iconCls="icon-cancel" onclick="delUser()">删除</a>
	</form>
</div>
<table id="webUserDatagrid" class="easyui-datagrid" data-options="title:'角色管理',url:'user_list.action',border:false,fit:true,fitColumns:true,columns:[[
{field:'ck',checkbox:true,halign:'center'},
{field:'userid',title:'用户编号',width:70,sortable:false,align:'center'},
{field:'username',title:'用户名称',width:150,align:'center'},
{field:'agentId',title:'员工工号',width:100,align:'center'},
{field:'orgname',title:'门店名称',width:100,align:'center'},
{field:'webUnit.name',title:'用户部门',width:100,align:'center',formatter:webUnitNameFormatter},
{field:'phoneno',title:'电话号码',width:100,align:'center'},
{field:'bz',title:'用户说明',width:100,align:'center'},
{field:'isuse',title:'用户状态',width:100,align:'center',formatter:webUserIsuseFormatter}
]],toolbar: '#userToolbar',pagination:true,nowrap:false,onSelect:onUserSelectRow,onUnselect:onUserUnSelectRow
">
</table>
<div id="webUserAddDialog" style="width: 530px; height: 360px; display: none; padding: 10px;">
	<form id="webUserAddForm">
		<table>
			<tr>
				<td>员工工号</td>
				<td><input id="agentId" name="webUser.agentId" class="easyui-validatebox" data-options="required:true" /></td>
				<td>用户姓名</td>
				<td><input id="username" name="webUser.username" class="easyui-validatebox" data-options="required:true" /></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input id="password" type="password" name="webUser.password" class="easyui-validatebox" data-options="required:true" /></td>
				<td>确认密码</td>
				<td><input id="repwd" type="password" class="easyui-validatebox" data-options="required:true" validType="eqPwd['#webUserAddForm #password']" /></td>
			</tr>
			<tr>
				<td>电子邮件</td>
				<td><input id="email" name="webUser.email" class="easyui-validatebox" data-options="validType:'email'" /></td>
				<td>电话号码</td>
				<td><input id="phoneno" name="webUser.phoneno" class="easyui-validatebox"/></td>
			</tr>
			<tr>
				<td>门店名称</td>
				<td colspan="3"><select id="addOrgCode" name="manage.orgcode" style="width:390px;"></select></td>
			</tr>
			<tr>
				<td>用户部门</td>
				<td colspan="3"><select id="addWebUnit" name="webUser.webUnit.unitid" style="width:390px;"></select></td>
			</tr>
			<tr>
				<td>用户角色</td>
				<td colspan="3"><select id="addWebRole" name="roles" style="width:390px;"></select></td>
			</tr>
			<tr>
				<td colspan="3"><input type="hidden" id="bz" name="webUser.bz" style="width: 390px; height: 80px; overflow: hidden;resize: none"></input></td>
			</tr>
		</table>
	</form>
</div>
<div id="webUserEditDialog" style="width: 530px; height: 360px; display: none; padding: 10px;">
	<form id="webUserEditForm">
		<table>
			<tr>
				<td>员工工号</td>
				<td><input id="agentId" readonly="readonly" name="webUser.agentId" class="easyui-validatebox" data-options="required:true" /></td>
				<td>用户名称</td>
				<td><input id="username" name="webUser.username" class="easyui-validatebox" data-options="required:true" /></td>
			</tr>
			<tr>
				<td><input id="userid" readonly="readonly" name="webUser.userid" type="hidden" class="easyui-validatebox"/></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input id="password" type="password" name="webUser.password" class="easyui-validatebox" data-options="required:true" /></td>
				<td>电子邮件</td>
				<td><input id="email" name="webUser.email" class="easyui-validatebox" data-options="validType:'email'" /></td>
			</tr>
			<tr>
				<td>电话号码</td>
				<td><input id="phoneno" name="webUser.phoneno" class="easyui-validatebox"/></td>
				<td>用户状态</td>
				<td><select id="isuse" name="webUser.isuse" style="width:150px;">
					<option value="T">正常</option>
					<option value="F">禁用</option>
				</select></td>
			</tr>
			<tr>
				<td>门店名称</td>
				<td colspan="3"><select id="addOrgCode" name="manage.orgcode" style="width:390px;"></select></td>
			</tr>
			<tr>
				<td>用户部门</td>
				<td colspan="3"><select id="addWebUnit" name="webUser.webUnit.unitid" style="width:390px;"></select></td>
			</tr>
			<tr>
				<td>用户角色</td>
				<td colspan="3"><select id="addWebRole" name="roles" style="width:390px;"></select></td>
			</tr>
			<tr>
				<td colspan="3"><input type="hidden" id="bz" name="webUser.bz" style="width: 390px; height: 80px; overflow: hidden;resize: none"></input></td>
			</tr>
		</table>
	</form>
</div>
<div id="webMailboxDialog"  style="width: 750px; height: 630px; display: none;">
  <form id="webMailboxAddForm">
     <table>
   <tr> 
      <th>收件人</th>
      <td>
        <input id="sendname" type="text" name="sendname" style="width: 630px;" readOnly="true"/>  
    </td>
   </tr>
    <tr>
      <td height="30px">时间:</td>
        <td><input id="date" name="mailbox.mailboxDetails.mdSendTime" readOnly="true"/></td>
      </tr>
      <tr>
        <td>通知主题:</td>
        <td><input id="mdTitle" type="text" name="mailbox.mailboxDetails.mdTitle" style="width: 630px;" class="easyui-validatebox" data-options="required:true" /></td>
      </tr>
      <tr>
        <td>通知内容:</td>
        <td colspan="3"><textarea name="mailbox.mailboxDetails.mdContent" id="myEditor" style="width: 630px; height: 300px;"></textarea></td>
      </tr>
    </table>
  </form>
</div>
<div data-options="region:'south',split:true" style="height:50px;"></div>
  <div id="tabsUserMenu" class="easyui-menu" style="width:50px;">
    <div name="sendMailbox">发送通知</div>
  </div>
  <script type="text/javascript">
  var editor = UE.getEditor('myEditor');
  function here(str){
    //alert(editor.getContent());
    //"<span>\$\{"+var1+"</span\>}"
    editor.execCommand("insertHtml",str,true);
  }
  </script>