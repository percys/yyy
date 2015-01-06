<?xml version="1.0" encoding="UTF-8"?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <base href="<%=basePath%>">
    
    <title>申请加盟</title>
    
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0" />
	<jsp:include page="resource/commons/jslib.jsp" />

  </head>
  <style>
#mytable {   
padding: 0;
margin: 0;   
border-collapse:collapse;
}

td {
border: 1px solid #C1DAD7;   
background: #fff;
font-size:11px;
padding: 6px 6px 6px 12px;
color: #4f6b72;
}

td.alt {
background: #F5FAFA;
color: #797268;
}
#center{
MARGIN-RIGHT: auto;
MARGIN-LEFT: auto;
height:200px;
width:700px;
vertical-align:middle;
line-height:23px;
margin-top:40px;
}
</style>
  <body>
<div id="center">
<form action="perinfo_addPerinfo.action" method="post">
<h3>个人信息</h3>
<table width="750" id="mytable" cellspacing="0">
<tr>
<td align="right" class="alt"><font color=red>*</font>申请人：</td>
<td><input type="text" name="perinfo.userInfo.username" value="张三"/></td>
<td align="right" class="alt"><font color=red>*</font>性别：</td>
<td><input type="radio" name="perinfo.userInfo.userSex" value="0" checked> 男  
<input type="radio" name="perinfo.userInfo.userSex" value="1"> 女</td>
</tr>
<tr>
<td align="right" class="alt"><font color=red>*</font>身高：</td>
<td><input type="text" name="perinfo.userInfo.userHigh" value="180"/></td>
<td align="right" class="alt"><font color=red>*</font>出生日期：</td>
<td><input type="text" name="perinfo.userInfo.userDate" value="1990-11-11"/></td>
</tr>
<tr>
<td align="right" class="alt"><font color=red>*</font>籍贯：</td>
<td><input type="text" name="perinfo.userInfo.userDate" value="四川"/></td>
<td align="right" class="alt"><font color=red>*</font>婚姻：</td>
<td><input type="radio" name="perinfo.userInfo.userMarriage" value="0" checked> 是  
<input type="radio" name="perinfo.userInfo.userMarriage" value="1">否</td>
</tr>
<tr>
<td align="right" class="alt"><font color=red>*</font>身份证号码：</td>
<td colspan="3"><input type="text" name="perinfo.userInfo.userCard" maxlength="18" value="123456789987456123"/></td>
</tr>
<tr>
<td align="right" class="alt">配偶姓名：</td>
<td><input type="text" name="perinfo.userInfo.userSpouse" value="小红"/></td>
<td align="right" class="alt">出生日期：</td>
<td><input type="text" name="perinfo.userInfo.userSpouseDate" value="1999-11-11"/></td>
</tr>
<tr>
<td align="right" class="alt">身高：</td>
<td><input type="text" name="perinfo.userInfo.userSpouseHigh" value="180"/></td>
<td align="right" class="alt">配偶工作单位：</td>
<td><input type="text" name="perinfo.userInfo.userSpouseWork" value="无"/></td>
</tr>
<tr>
<td align="right" class="alt">公司电话：</td>
<td><input type="text" name="perinfo.userInfo.userCompanyPhone" value="654123"/></td>
<td align="right" class="alt"><font color=red>*</font>手机：</td>
<td><input type="text" name="perinfo.userInfo.userPhone" value="13333452222"/></td>
</tr>
<tr>
<td align="right" class="alt"><font color=red>*</font>现居住地址：</td>
<td><input type="text" name="perinfo.userInfo.userAddress" value="上海"/></td>
<td align="right" class="alt">E-mail：</td>
<td><input type="text" name="perinfo.userInfo.userEmail" value="123456@qq.com"/></td>
</tr>
<tr>
<td align="right" class="alt">传真：</td>
<td colspan="3"><input type="text" name="perinfo.userInfo.userFax" value="无"/></td>
</tr>
</table>
<h3>教育程度（最高学历）</h3>
<table width="750" id="mytable" cellspacing="0" id="tab" value="本科">
<tr>
<td align="right" class="alt">毕业时间：</td>
<td><input type="text" name="perinfo.degreeInfo.degreeSchool" value="2013-07-01"/></td>
</tr>
<tr>
<td align="right" class="alt">在校时间：</td>
<td><input type="text" name="perinfo.degreeInfo.degreeDate" value="2009-09-01"/></td>
</tr>
<tr>
<td align="right" class="alt">专业：</td>
<td><input type="text" name="perinfo.degreeInfo.degreeSkills" value="模特"/></td>
</tr>
<tr>
<td align="right" class="alt">获奖情况：</td>
<td><input type="text" name="perinfo.degreeInfo.degreePrize" value="无"/></td>
</tr>
</table>
<h3>职业经验（最近工作）</h3>
<table width="750" id="mytable" cellspacing="0" id="tab">
<tr>
<td align="right" class="alt">时间：</td>
<td><input type="text" name="perinfo.workInfo.workDate" value="无"/></td>
</tr>
<tr>
<td align="right" class="alt">公司名称：</td>
<td><input type="text" name="perinfo.workInfo.workName" value="无"/></td>
</tr>
<tr>
<td align="right" class="alt">公司性质：</td>
<td><input type="text" name="perinfo.workInfo.workType" value="无"/></td>
</tr>
<tr>
<td align="right" class="alt">职位：</td>
<td><input type="text" name="perinfo.workInfo.workPosition" value="无"/></td>
</tr>
<tr>
<td align="right" class="alt">工作内容：</td>
<td><input type="text" name="perinfo.workInfo.workContent"value="无"/></td>
</tr>
<tr>
<td align="right" class="alt">月薪：</td>
<td><input type="text" name="perinfo.workInfo.workMoney"value="无"/></td>
</tr>
<tr>
<td align="right" class="alt">离职原因：</td>
<td><input type="text" name="perinfo.workInfo.workMoney"value="无"/></td>
</tr>
</table>
<h3>经商经验</h3>
<table width="750" id="mytable" cellspacing="0" id="tab">
<tr>
<td align="right" class="alt">经商经验：</td>
<td>经营内容：<input type="text" name="perinfo.businessInfo.shopInfo.shopContent" value="无"/> 时间：<input type="text" name="perinfo.businessInfo.shopInfo.shopDate" value="无"/> 销售额：<input type="text" size="1px;" name="perinfo.businessInfo.shopInfo.shopSales" value="无"/>万/月</td>
</tr>
<tr>
<td align="right" class="alt">现经营或加盟品牌：</td>
<td>经营内容：<input type="text" name="perinfo.businessInfo.joinInfo.joinContent" value="无"/> 时间：<input type="text" name="perinfo.businessInfo.joinInfo.joinDate" value="无"/ > 销售额：<input type="text" size="1px;" name="perinfo.businessInfo.joinInfo.joinDate.joinSales" value="无"/>万/月</td>
</tr>
<tr>
<td align="right" class="alt">曾经做过连锁加盟：</td>
<td>经营内容：<input type="text" name="perinfo.businessInfo.onceInfo.onceContent" value="无"/> 时间：<input type="text" name="perinfo.businessInfo.onceInfo.onceDate" value="无"/ > 销售额：<input type="text" size="1px;" name="perinfo.businessInfo.onceInfo.onceSales" value="无"/>万/月</td>
</tr>
</table>
<h3>拟经营地情况</h3>
<table width="750" id="mytable" cellspacing="0" id="tab">
<tr>
<td align="right" class="alt">拟加盟地区：</td>
<td><input type="text" name="perinfo.situationInfo.situationRegion" value="上海"/></td>
</tr>
<tr>
<td align="right" class="alt">拟经营地周边商业情况：</td>
<td><input type="radio" name="perinfo.situationInfo.situationSurround" value="大型购物中心" checked>大型购物中心  
<input type="radio" name="perinfo.situationInfo.situationSurround" value="附近有农贸市场">附近有农贸市场<input type="radio" name="perinfo.situationInfo.situationSurround" value="大型社区" checked>大型社区  
<input type="radio" name="perinfo.situationInfo.situationSurround" value="其他">其他</td>
</tr>
<tr>
<td align="right" class="alt">拟经营地有无品牌熟食店铺：</td>
<td><input type="text" size="60px;" name="perinfo.situationInfo.situationStore" value="无"/><font color=red>多个以，号分隔</font></td>
</tr>
<tr>
<td align="right" class="alt">拟经营地熟食经营情况：</td>
<td><input type="text" size="60px;" name="perinfo.situationInfo.situationSituation" value="无"/></td>
</tr>
</table>
<h3>加盟商资源</h3>
<table width="750" id="mytable" cellspacing="0" id="tab">
<tr>
<td align="right" class="alt">加盟商店铺情况：</td>
<td><input type="radio" name="perinfo.resourcesInfo.resourcesSituaction" value="自有" checked>自有  
<input type="radio" name="perinfo.resourcesInfo.resourcesSituaction" value="租赁">租赁<input type="radio" name="perinfo.resourcesInfo.resourcesSituaction" value="寻找着" checked>寻找着</td>
</tr>
<tr>
<td align="right" class="alt">营业面积：</td>
<td><input type="text" name="perinfo.resourcesInfo.resourcesArea"  value="180"/></td>
</tr>
<tr>
<td align="right" class="alt">车辆情况：</td>
<td><input type="text" name="perinfo.resourcesInfo.resourcesVehicle" value="2"/></td>
</tr>
<tr>
<td align="right" class="alt">房产情况：</td>
<td><input type="radio" name="perinfo.resourcesInfo.resourcesEstate" value="自有" checked>自有
<input type="radio" name="perinfo.resourcesInfo.resourcesEstate" value="租赁">租赁</td>
</tr>
<td align="right" class="alt">投资方式：</td>
<td><input type="radio" name="perinfo.resourcesInfo.resourcesInvestment" value="独资" checked />独资
<input type="radio" name="perinfo.resourcesInfo.resourcesInvestment" value="合伙">合伙</td>
</tr>
</table>

<h3>加盟计划</h3>
<table width="750" id="mytable" cellspacing="0">
<tr>
<td align="right" class="alt"><font color=red>*</font>拟加盟时间：</td>
<td><input type="text" name="perinfo.planInfo.planDate" value="2015-02-01"/></td>
<td align="right" class="alt"><font color=red>*</font>拟定法人代表：</td>
<td><input type="text" name="perinfo.planInfo.planName"  value="张三"/></td>
</tr>
<tr>
<td colspan="4" class="alt"><font color=red>*</font>
拟投入资金金额：<input type="text" size="1px;" name="perinfo.planInfo.planMoney"  value="20"/>万元
    自有资金：<input type="text" size="1px;" name="perinfo.planInfo.planSource"  value="50"/>万元
        向亲友借款：<input type="text" size="1px;" name="perinfo.planInfo.planFriends"  value="10"/>万元
            银行贷款：<input type="text" size="1px;" name="perinfo.planInfo.planBank"  value="10"/>万元
                其他：<input type="text" size="1px;" name="perinfo.planInfo.planElse"  value="10"/>万元</td>
</tr>
<tr>
<td align="right" class="alt"><font color=red>*</font>是否有后备资金及金额：</td>
<td><input type="text" name="perinfo.planInfo.planStandby" value="10"/></td>
<td align="right" class="alt"><font color=red>*</font>心里回报期限：</td>
<td><input type="text" size="2px;" name="perinfo.planInfo.planStandby" value="12"/>月</td>
</tr>
<tr>
<td><input type="submit" value="提交"/></td>
</tr>
</table>
</form>
</div>
  </body>
</html>
