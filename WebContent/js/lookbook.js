$(function(){
	
	// 对书籍相关资料进行更新
	$(".xiugai").click(function(){
		var obj =  $(this).parents(".txt").find("input");
		obj.removeAttr("readOnly").focus();
		obj.blur(function(){
			obj.attr("readOnly","true");
		});
	});
	
	
});