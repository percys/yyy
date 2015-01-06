<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
	$('#webwbygRoleDatagrid').datagrid({   
    rowStyler:function(index,row){   
        if (index%2==0){   
            return 'background-color:#FFC;';   
        }   
    }   
});
		function csv(){
			var begindate=$('#begindate').datebox('getValue');	
			var enddate=$('#enddate').datebox('getValue');
			var grid = $('#webwbygRoleDatagrid');  
			var options = grid.datagrid('getPager').data("pagination").options;  
		    var url = 'externalYg_csv.action?page='+options.pageNumber+'&rows='+options.total+'&begindate='+begindate+'&enddate='+enddate;  
		    window.location.href = url;
			};
		function onSelectRow(rowIndex, rowData){
			var dg=$('#webwbygRoleDatagrid').datagrid('getSelections');
			if(dg.length!=1){
				$('#roleEditButton').linkbutton('disable');
			}else{
				$('#roleEditButton').linkbutton('enable');
			}
		}
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
<div id="outygroletoolbar">
	<form id="outygWebRoleForm">
		日期查询：<input id="begindate" type="text" class="easyui-datetimebox" name="interwb.beginDate"  data-options="formatter:myformatter,parser:myparser" style="width: 200px;"  >
		&nbsp;&nbsp;&nbsp;至&nbsp;&nbsp;&nbsp;
		<input id="enddate" type="text" class="easyui-datetimebox" data-options="formatter:myformatter,parser:myparser" name="interwb.endDate" style="width: 200px;">
		<a href="javascript:" class="easyui-linkbutton" plain="false" iconCls="icon-search" onclick="searchForm('#webwbygRoleDatagrid','#outygWebRoleForm')">查询</a>
		<a href="javascript:" class="easyui-linkbutton" plain="false" iconCls="icon-search" onclick="formClean('#outygWebRoleForm')">清空</a>
		<br />
		<br />
		<a href="javascript:" class="easyui-linkbutton" plain="true" iconCls="icon-print" onclick="csv()">导出</a>
	</form>
</div>
<table id="webwbygRoleDatagrid" class="easyui-datagrid" style="height: 400px; width: 100px;"
data-options="title:'账单详细列表',url:'externalYg_getAll.action',border:false,fit:true,fitColumns:false,columns:[[
{field:'ck',checkbox:true,halign:'center'},
{field:'tid',title:'账单编号',width:70,sortable:false,align:'center'},
{field:'entid',title:'组织编码',width:150,halign:'center'},
{field:'rptdate',title:'报表日期',width:100,align:'center'},
{field:'orgcode',title:'组织编码',width:100,halign:'center'},
{field:'orgname',title:'组织名称',width:100,align:'center'},
{field:'pstotal',title:'配送金额',width:100,align:'center'},
{field:'thtotal',title:'配送异常金额',width:100,align:'center'},
{field:'gqtotal',title:'过期退货',width:100,align:'center'},
{field:'zltotal',title:'作料金额',width:100,align:'center'},
{field:'mdzl',title:'门店质量',width:100,align:'center'},
{field:'bctotal',title:'包材',width:100,align:'center'},
{field:'hytotal',title:'会员折扣',width:100,align:'center'},
{field:'txtotal',title:'特许费用',width:100,align:'center'},
{field:'sbtotal',title:'商标使用费',width:100,align:'center'},
{field:'savetotal',title:'卡存款',width:100,align:'center'},
{field:'sstotal',title:'刷卡消费',width:100,align:'center'},
{field:'jfzftotal',title:'积分支付金额',width:100,align:'center'},
{field:'cqtotal',title:'总结算金额',width:100,align:'center'},
{field:'xstotal',title:'销售金额',width:100,align:'center'}
]],toolbar: '#outygroletoolbar',pagination:true,nowrap:false,onSelect:onSelectRow,onUnselect:onSelectRow
">
</table>