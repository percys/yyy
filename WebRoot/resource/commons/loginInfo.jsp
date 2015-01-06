<?xml version="1.0" encoding="UTF-8"?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<script type="text/javascript">
$(function(){
	$("#userInfo2").find("li").addClass("userInfoli");
	$("#userInfo1,#userInfo2").addClass("userInfoTable");
	$("#userInfo1,#userInfo2").find("tr,td,th").addClass("userInfoTable");
});
</script>
<style type="text/css">
.userInfoTable{
	border:1px solid #CCC;
	border-collapse:collapse;
}
.userInfoli{
	list-style: none;
}
</style>
<table id="userInfo1" style="width:100%;">
	<tr>
    	<th style="background-color:#EEF;padding:10px 6px;">用户名</th>
    	<td><s:property value="webUser.username" /></td>
    	<th style="background-color:#EEF;padding:10px 6px;">所属部门</th>
    	<td><s:property value="webUser.webUnit.name" /></td>
    </tr>
    <tr>
    	<th style="background-color:#EEF;padding:10px 6px;">电话号码</th>
    	<td><s:property value="webUser.phoneno" /></td>
    	<th style="background-color:#EEF;padding:10px 6px;">用户说明</th>
    	<td><s:property value="webUser.bz" /></td>
    </tr>
    <tr>
    	<th style="background-color:#EEF;padding:10px 6px;">电子邮箱</th>
    	<td colspan="3"><s:property value="webUser.email" /></td>
    </tr>
</table>
<table id="userInfo2" style="margin-top:20px; width:100%;">
    <tr>
    	<td style="background-color:#EEF;padding:10px 6px;"><strong>用户角色</strong></td>
    	<td style="background-color:#EEF;padding:10px 6px;"><strong>资源权限</strong></td>
    </tr>
    <tr>
    	<td style="vertical-align:top; line-height:20px;padding:10px 6px;"">
    	<ul>
    		<s:iterator value="webRoles">
    			<li><s:property value="name" /></li>
    		</s:iterator>
        </ul>
        </td>
        <td style="vertical-align:top; line-height:20px;padding:10px 6px;">
    	<ul>
    		<s:iterator value="webResources">
    			<li><s:property value="name" /></li>
    		</s:iterator>
        </ul>
        </td>
    </tr>
</table>
