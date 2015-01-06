<?xml version="1.0" encoding="UTF-8"?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>" />
<title>紫燕食品财务查询管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0" />
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
<meta http-equiv="description" content="This is my page" />
<jsp:include page="resource/commons/jslib.jsp" />
<style>
 body{text-align:center;
background-color:white;
font-size: 14px;
font-family: sans-serif;
 } 
.wz {
	width:346px;
	height:244px;
	background-image:url(images/12.png);
	position: absolute;
	top:40%;
	left:60%;
}
.bj {
	margin:10% auto;width:400px;height:100px;
	width: 1440px;
	height: 375px;
	background-image: url(images/logins.png);
	background-repeat:no-repeat;
	text-align:center;
}
</style>
<script type="text/javascript">
	function login(){
		$.post("user_login.action",$("#loginForm").serialize(),function(r){
			if (r&&r.success) {
				window.location.href="index.jsp";
			}else{
				$.messager.show({
					title:'提示',
					msg:r.msg,
					timeout:3000
				});
			}
		},"json");
	}
	  $(function(){
			$("#randimg").bind("click",function(){
				$("#randimg").attr("src","rand.action?rand=" + Math.random());
			});
		});
</script>
</head>
<body style="width:100%; height: 100%;">
	<div class="bj">
    	<form id="loginForm" action="user_login.action">
		<div class="wz">
			<table style="margin-top:50px; margin-left:60px; text-align:left" >
				<tr>
					<td width="245" height="45">用户名：<input type="text" name="webUser.username" style="width:170px;"></td>
				</tr>
				<tr>
					<td height="34">密&nbsp;&nbsp;&nbsp;码：<input type="password" name="webUser.password" style="width:170px;"></td>
				</tr>
                <tr>
					<td height="34">
					验证码：<input type="text" id="txtcode" style="width:80px;" name="txtcode">
		              <img src="rand_getlist.action" alt="点击刷新" id="randimg">
			          <span id="RequiredFieldValidator5" style="font-weight: bold; visibility: hidden;color: white">请输入验证码</span>
					</td>
				</tr>
				<tr>
					<td ><input style="margin-left: 64px; width: 50px;" type="button" value="登录" onclick="login()">&nbsp;&nbsp;&nbsp;&nbsp;<input style="width: 50px;" type="reset" value="重置"></td>
				</tr>
                
			</table>
		</div>
        </form>
	</div>
<script type="text/javascript">
	  $(function(){
			$("#randimg").bind("click",function(){
				$("#randimg").attr("src","rand_getlist.action?rand=" + Math.random());
			});
		});
</script>
</body>
</html>
