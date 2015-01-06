<%@page pageEncoding="UTF-8"%>
<html>
<!-- 
  - Author(s): Administrator
  - Date: 2013-08-13 14:27:32
  - Description:
-->
<head>
<title>Title</title>
<script type="text/javascript" charset="utf-8">
     window.UEDITOR_HOME_URL = "<%=request.getContextPath() %>/ueditor/"; 
</script>
<link href="<%=request.getContextPath() %>/ueditor/themes/default/css/ueditor.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="<%=request.getContextPath() %>/ueditor/ueditor.config.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/ueditor/ueditor.all.js"></script>
<script type="text/javascript" src="/default/common/nui/nui.js"></script>
</head>
<body>

<div class="nui-toolbar" style="padding:2px;border-top:0;border-left:0;border-right:0;">                
            
            <a class="nui-button" iconCls="icon-add" plain="true" onclick="review()">预览</a>
            <a class="nui-button" id="zansave" iconCls="icon-remove" plain="true" onclick="zanSave()">暂存</a>     
            <span class="separator"></span>             
            <a class="nui-button"  id="submit"  iconCls="icon-save" plain="true" onclick="saveData()">提交</a>                  
</div>
      


 <input name="tid"  id="tid" class="nui-hidden"/>
<form action="" method="post" name='myForm' id='myForm'>
    
	<textarea name="worksummary" id="myEditor" style="width:100%;height:70%"></textarea>
    
</form>



<script type="text/javascript">
  var editor = UE.getEditor('myEditor');
    
  function here(str){
    //alert(editor.getContent());
    //"<span>\$\{"+var1+"</span\>}"
    editor.execCommand("insertHtml",str,true);
  }
  function getContent(){  // 纯文本
  	 return editor.getContentTxt();
  }
   function getContent2(){  
  	 return editor.getContent();   //源码文本
  
  }
  
//以上为ueditor 所用方法

  nui.parse();
  debugger;
    var tid=nui.get("tid");
     var editor = UE.getEditor('myEditor');
		 nui.ajax({
		    async: false,
		    url:"com.primeton.commitData.commitData.queryYearSum.biz.ext",
		    type: "post",
		    success: function (text) {
		      var a=text.data[0];
		       console.log(a);
		      var content=a.worksummary;
		       //editor.setContent(content);                 ///未起作用 
		       tid.setValue(a.tid);                          //未起作用 
		    }
		});
		//editor.setContent("d");
		
		console.log(editor+"111111");
		editor.setContent="dddd";
		
 



//暂存
function zanSave(){
       var a=new Date();
       // var date=d.toLocaleDateString();
        debugger;
       // date=a.getFullYear()+"-"+a.getMonth()+"-"+a.getDate()+"-"+a.getHours()+"-"+a.getMinutes();
       var mon=a.getMonth()+1;
        date=a.getFullYear()+"-"+mon+"-"+a.getDate();
         var editor = UE.getEditor('myEditor');
         var content=editor.getContent();
            var data2={
               worksummary:content,
               submitdate:date
              // test:1, //提交标识
            };
            var data={temp:data2}; 
            var json = nui.encode(data);
               nui.ajax({
                url: "com.primeton.commitData.commitData.saveYearSum.biz.ext",
                type: 'POST',
                data: json,
                contentType:"text/json",
                success: function (text) {
                    nui.alert("暂存成功！","提示");
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    nui.alert(jqXHR.responseText);
                }
            });
          
        
}
 //提交
   
function saveData(){
       debugger;
       var button= nui.get("submit");
       var d=new Date();
        var date=d.toLocaleDateString();
        debugger;
        //a.getFullYear()+a.getMonth()+a.getDate()+a.getHours()+a.getMinutes();
         var editor = UE.getEditor('myEditor');
         var content=editor.getContent();
            var data2={
               tid:nui.get("tid").getValue(),//   
               worksummary:content,
               //submitdate:date,
               test:1, //提交标识
            };
            var data={temp:data2}; 
            var json = nui.encode(data);
            nui.confirm("一旦提交将不可再修改,确认提交吗？", "提示", function (action){
               debugger;
              if (action == "ok") {
               nui.ajax({
                url: "com.primeton.commitData.commitData.saveYearSum.biz.ext",
                type: 'POST',
                data: json,
                contentType:"text/json",
                success: function (text) {
                    nui.alert("提交成功！","提示");
                    button.setEnabled(false);  //按钮变灰色
                    
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    nui.alert(jqXHR.responseText);
                }
            });
               }
              
            });
          
        
}


function review(){
    nui.open({
				    url: "/default/eos/commitData/xjInfo.jsp",
				    showMaxButton: false,
				    title: "年度工作小结预览",
				    width: 1000,
				    height: 550
				    
				 
				});
  
   
}

  
  
  
  
</script>
</body>

</html>