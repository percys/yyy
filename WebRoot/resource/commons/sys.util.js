var ss;
/**
 *清空表单输入框数据
 */
function formClean(formid){
	$(formid).find("input").val("");
}
/**
 * 根据条件筛选数据，发送请求
 */
function searchForm(datagridId,formId){
	$(datagridId).datagrid("load",serializeObject($(formId)));
}
/**
 * 序列化表单数据成对象
 */
function serializeObject(form){
	var o={};
	$.each(form.serializeArray(),function(index){
		if (o[this['name']]) {
			o[this['name']]=o[this['name']]+","+this['value'];
		} else {
			o[this['name']]=this['value'];
		}
	});
	return o;
}
/**
 * 设置cookies
 */
function setCookie(name, value){
   var argv = setCookie.arguments;   
   var argc = setCookie.arguments.length;   
   var expires = (argc > 2) ? argv[2] : null;
   var LargeExpDate = new Date ();
   if(expires!=null){
       LargeExpDate.setTime(LargeExpDate.getTime() + (expires*1000*3600*24));           
   }   
   document.cookie = name + "=" + escape (value)+((expires == null) ? "" : ("; expires=" +LargeExpDate.toGMTString()));   
}
/**
 * 获得cookies
 * @param Name
 * @returns
 */
function getCookie(Name){   
   var search = Name + "=";
   if(document.cookie.length > 0){
       offset = document.cookie.indexOf(search);
       if(offset != -1){
           offset += search.length;
           end = document.cookie.indexOf(";", offset);
           if(end == -1) end = document.cookie.length;
           return unescape(document.cookie.substring(offset, end));
       }   
       else return null;
   }
}
/**
 * 验证确认密码是否与原始密码填写一直
 */
$.extend($.fn.validatebox.defaults.rules, {
	eqPwd : {
		validator : function(value, param) {
			return value == $(param[0]).val();
		},
		message : '密码不一致！'
	}
});
/**
 * 防止panel/window/dialog组件超出浏览器边界
 */
divMove = {
	onMove : function(left, top) {
		var l = left;
		var t = top;
		if (l < 1) {
			l = 1;
		}
		if (t < 1) {
			t = 1;
		}
		var width = parseInt($(this).parent().css('width')) + 14;
		var height = parseInt($(this).parent().css('height')) + 14;
		var right = l + width;
		var buttom = t + height;
		var browserWidth = $(window).width();
		var browserHeight = $(window).height();
		if (right > browserWidth) {
			l = browserWidth - width;
		}
		if (buttom > browserHeight) {
			t = browserHeight - height;
		}
		$(this).parent().css({/* 修正面板位置 */
			left : l,
			top : t
		});
	}
};
$.extend($.fn.dialog.defaults, divMove);
$.extend($.fn.window.defaults, divMove);
$.extend($.fn.panel.defaults, divMove);