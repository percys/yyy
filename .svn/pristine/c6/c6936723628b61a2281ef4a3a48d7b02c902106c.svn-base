<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<style>
.table-condensed th,
.table-condensed td {
  padding: 4px 5px;
}
.table-hover tbody tr:hover > td,
.table-hover tbody tr:hover > th {
  background-color: #f5f5f5;
}
</style>
<script type="text/javascript" charset="utf-8">
var easyUITheme=getCookie("theme");
if(easyUITheme!=null){
	changeTheme(easyUITheme);
}
function changeTheme(theme){
	$("#easyuiTheme").attr("href","jquery-easyui/themes/"+theme+"/easyui.css");
	setCookie("theme", theme);
}
function exit(){
	$.messager.confirm('提示','确定要退出系统吗?',function(b){
		if (b) {
			window.location.href="user_exit.action";
				
		}
	});
}
function myInfo(){
	$("#myInfo").show().dialog({
		title : '个人信息',
		width:450,
		href:'user_info.action',
		onLoad:function(){
			$("#myInfo").dialog("resize",{
				height:$("#myInfo").dialog("panel").outerHeight(true)
			});
			$("#myInfo").dialog("center");
		}
	});
}
function editUserPwd() {
	$("#editPwd").show().dialog({
		title : '修改密码',
		width : 270,
		height : 190,
		modal:true,
		buttons : [ {
			text : '修改',
			handler : function() {
				$.post("user_editPwd.action",$("#editUserPwdForm").serialize(),function(r){
					if (r&&r.success) {
						$("#editPwd").dialog("close");
						$.messager.show({
							title:'提示',
							msg:r.msg,
							timeout:5000
						});
					}else{
						$.messager.show({
							title:'提示',
							msg:r.msg,
							timeout:5000
						});
					}
				},"json");
			}
		}]
	});
}
</script>
<div >
<img src="images/logo.png">
</div>
<div style="position: absolute; right: 0px; bottom: 0px;">
<a href="javascript:void(0);" class="easyui-menubutton" data-options="menu:'#layout_north_pfMenu',iconCls:'icon-olor_wheel'">更换皮肤</a> <a href="javascript:void(0);" class="easyui-menubutton" data-options="menu:'#layout_north_kzmbMenu',iconCls:'icon-cog'">控制面板</a> <a href="javascript:void(0);" class="easyui-menubutton" data-options="menu:'#layout_north_zxMenu',iconCls:'icon-user_delete'">注销</a>
</div>
<div style="position: absolute; text-align:left; vertical-align:middle; right: 0px; top: 0px; width:240px; height: 30px; font-size:13px; color:#3a87ad; line-height: 20px; padding: 8px 20px 8px 15px;border-radius: 4px ">
	欢迎 <strong>[${sessionScope.login.username}]</strong>登录！<br/>
</div>
<div id="layout_north_pfMenu" style="width: 120px; display: none;">
	<div onclick="changeTheme('default');" title="default">default</div>
	<div onclick="changeTheme('gray');" title="gray">gray</div>
	<div onclick="changeTheme('metro');" title="metro">metro</div>
	<div onclick="changeTheme('cupertino');" title="cupertino">cupertino</div>
	<div onclick="changeTheme('dark-hive');" title="dark-hive">dark-hive</div>
	<div onclick="changeTheme('sunny');" title="sunny">sunny</div>
	<div onclick="changeTheme('bootstrap');" title="bootstrap">bootstrap</div>
	<div onclick="changeTheme('black');" title="black">black</div>
	<div class="menu-sep"></div>
	<div onclick="changeTheme('metro-blue');" title="metro-blue">metro-blue</div>
	<div onclick="changeTheme('metro-gray');" title="metro-gray">metro-gray</div>
	<div onclick="changeTheme('metro-green');" title="metro-green">metro-green</div>
	<div onclick="changeTheme('metro-orange');" title="metro-orange">metro-orange</div>
	<div onclick="changeTheme('metro-red');" title="metro-red">metro-red</div>
</div>
<div id="layout_north_kzmbMenu" style="width: 100px; display: none;">
	<div data-options="iconCls:'icon-user_edit'" onclick="editUserPwd()">修改密码</div>
	<div class="menu-sep"></div>
	<div data-options="iconCls:'icon-vcard'" onclick="myInfo()">我的信息</div>
</div>
<div id="layout_north_zxMenu" style="width: 100px; display: none;">
	<div data-options="iconCls:'icon-delete'" onclick="exit()">退出系统</div>
</div>
<!-- 修改密码 -->
<div id="editPwd" style="display:none;">
<form id="editUserPwdForm">
	<table style="font-size:14px; margin: 5px 10px;" class="table table-hover table-condensed">
		<tr>
			<th>原密码</th>
			<td><input name="oldPwd" type="password" placeholder="请输入原密码" class="easyui-validatebox" data-options="required:true"></td>
		</tr>
		<tr>
			<th>新密码</th>
			<td><input name="pwd" type="password" placeholder="请输入新密码" class="easyui-validatebox" data-options="required:true"></td>
		</tr>
		<tr>
			<th>重复</th>
			<td><input name="rePwd" type="password" placeholder="请再次输入新密码" class="easyui-validatebox" data-options="required:true,validType:'eqPwd[\'#editUserPwdForm input[name=pwd]\']'"></td>
		</tr>
	</table>
</form>
</div>
<!-- 个人信息展示 -->
<div id="myInfo" style="text-align:center; padding:10px;display:none;">
</div>