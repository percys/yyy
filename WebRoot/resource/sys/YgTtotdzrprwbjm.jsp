<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
	$('#webYgWBjmDatagrid').datagrid({   
    rowStyler:function(index,row){   
        if (index%2==0){   
            return 'background-color:#FFC;';   
        }   
    }   
});
function onSelectRow(rowIndex, rowData){
			var dg=$('#webwbygRoleDatagrid').datagrid('getSelections');
			if(dg.length!=1){
				$('#roleEditButton').linkbutton('disable');
			}else{
				$('#roleEditButton').linkbutton('enable');
			}
		}
function csv(){
	var begindate=$('#begindate').datebox('getValue');	
	var enddate=$('#enddate').datebox('getValue');
	var grid = $('#webYgWBjmDatagrid');  
	var options = grid.datagrid('getPager').data("pagination").options;  
    var url = 'ttotdzrptwbYg_csv.action?page='+options.pageNumber+'&rows='+options.total+'&begindate='+begindate+'&enddate='+enddate;  
    window.location.href = url; 
};
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
<div id="YgWbjmtoolbar">
	<form id="YgWBjmWebForm">
		日期查询：<input id="begindate" type="text" class="easyui-datetimebox" name="ttotdzrpt.beginDate"  data-options="formatter:myformatter,parser:myparser" style="width: 200px;"  >
		&nbsp;&nbsp;&nbsp;至&nbsp;&nbsp;&nbsp;
		<input id="enddate" type="text" class="easyui-datetimebox"  data-options="formatter:myformatter,parser:myparser" name="ttotdzrpt.endDate" style="width: 200px;">
		<a href="javascript:" class="easyui-linkbutton" plain="false" iconCls="icon-search" onclick="searchForm('#webYgWBjmDatagrid','#YgWBjmWebForm')">查询</a>
		<a href="javascript:" class="easyui-linkbutton" plain="false" iconCls="icon-search" onclick="formClean('#YgWBjmWebForm')">清空</a>
		<a href="javascript:" class="easyui-linkbutton" plain="true" iconCls="icon-print" onclick="csv()">导出</a>
	</form>
</div>
<table id="webYgWBjmDatagrid" class="easyui-datagrid" style="height: 400px; width: 100px;"
data-options="title:'账单详细列表',url:'ttotdzrptwbYg_getAll.action',border:false,fit:true,fitColumns:false,columns:[[
{field:'ck',checkbox:true,halign:'center'},                                                      
{field:'tid',title:'账单编号',width:70,sortable:false,align:'center'},           
{field:'entid',title:'组织编码',width:150,halign:'center'},                      
{field:'rptdate',title:'报表日期',width:100,align:'center'},                     
{field:'orgcode',title:'组织编码',width:100,halign:'center'},                    
{field:'orgname',title:'组织名称',width:100,align:'center'},                     
{field:'qctotal',title:'期初金额',width:100,align:'center'},                     
{field:'pstotal',title:'配送金额',width:100,align:'center'},                     
{field:'thtotal',title:'退货金额',width:100,align:'center'},                     
{field:'bstotal',title:'报损金额',width:100,align:'center'},                     
{field:'qmtotal',title:'期末金额',width:100,align:'center'},                     
{field:'xstotalA',title:'倒推',width:100,align:'center'},                      
{field:'sunhaototal',title:'损耗',width:100,align:'center'},                   
{field:'xstotalB',title:'实收合计',width:100,align:'center'},                    
{field:'xstotalDiff',title:'差账',width:100,align:'center'},                   
{field:'kdtotal',title:'口袋',width:100,align:'center'},                           
{field:'gqtotal',title:'过期',width:100,align:'center'},                      
{field:'mdzl',title:'门店质量',width:100,align:'center'},                         
{field:'hdtotal',title:'活动',width:100,align:'center'}                       
]],toolbar: '#YgWbjmtoolbar',pagination:true,nowrap:false,onSelect:onSelectRow,onUnselect:onSelectRow               
">                                                                                                                      
</table>