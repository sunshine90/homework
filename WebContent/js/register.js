
/*===========================
 * 		登录界面的jquery运用
 * ==========================*/

$(document).ready(function(){

	// box_1
	 $(".box_1 .username").focus(function(){
		 setHtml(".box_1","成功");
		 remain(".box_1");
	 }).blur(function(){
		if($.trim($(this).val()) == ""){
			warning(".box_1","用户名不能为空！");
		}else if(valLength(this) < 2 || valLength(this) >28){
			warning(".box_1","用户名长度在2-28之间！");
		}else{
			// 此处需要ajax与后台打交道，=====================
			$.get("userServlet",{username:value(this)},function(data,status){
				if(status == "success"){
					if(data == "true"){
						warning(".box_1","该用户名已经存在！");
					}else if(data == "false"){
						success(".box_1");
						setHtml(".box_1","1");
					}
				}
			});	
		}
	 });

		// box_2
	 $("#pwd").focus(function(){
		 setHtml(".box_2","成功");
		 remain(".box_2");
	 }).blur(function(){
		 if(value(this) == ""){
				warning(".box_2","密码不能为空！");
			}else{
				if(valLength(this) < 6 || valLength(this) >24){
					warning(".box_2","密码长度在6-24之间！");
				}else if(/^\d{6,9}$/.test(value(this))){
					warning(".box_2","不能为9位以下的纯数字！");
				}else{
					success(".box_2");
					setHtml(".box_2","1");
				}
			}
	 });
	
		// box_3
	 $("#re_pwd").focus(function(){
		 setHtml(".box_3","成功");
		 remain(".box_3");
	 }).blur(function(){
		 if(value(this) == value("#pwd")){
			 success(".box_3");
			 setHtml(".box_3","1");
		 }else{
			 warning(".box_3","请重新确认密码正确！");
		 }
	 });
	 
		// box_4
	 $("#rel_name").focus(function(){
		 setHtml(".box_4","成功");
		 remain(".box_4");
	 }).blur(function(){
		 if(valLength(this) < 2 || valLength(this) >20){
			 warning(".box_4","真实姓名字符长在2-20之间！");
		 }else{
			 success(".box_4");
			 setHtml(".box_4","1");
		 }
	 });
	 
	// box_5
	 $(".sex_choose").focus(function(){
		 remain(".box_5");
	 }).blur(function(){
		success(".box_5");
	 });
	 
	// box_6
	 $("#studentID").focus(function(){
		 setHtml(".box_6","成功");
		 remain(".box_6");
	 }).blur(function(){
		 if(valLength(this) == 10){
			 success(".box_6");
			 setHtml(".box_6","1");
		 }else{
			 warning(".box_6","请确认输入的学号！");
		 }		
	 });
	 
	// box_7
	 $("#depart_select").focus(function(){
		 setHtml(".box_7","成功");
		 remain(".box_7");
	 }).change(function(){
		if(value(this) == 0){
			warning(".box_7","请重新选择！");
		}else{
			success(".box_7");
			setHtml(".box_7","1");
		}
	 });
	 
	// box_8
	 $("#tel").focus(function(){
		 setHtml(".box_8","成功");
		 remain(".box_8");
	 }).blur(function(){
		 if(valLength(this) < 5 || valLength(this) >20){
			 warning(".box_8","请重新确定号码！");
		 }else{
			 success(".box_8");
			 setHtml(".box_8","1");
		 }		
	 });
	 
	// box_9
	 $("#code").focus(function(){
		 setHtml(".box_9","成功");
		 remain(".box_9");
	 }).blur(function(){
		 var str = $("#codeImg").attr("src");
		 var str1 = str.substring(11,15);
		 if(value(this).toUpperCase() == str1){
			 success(".box_9");
			 setHtml(".box_9","1");
		 }else{
			 warning(".box_9","请重新确定验证码！");
		 };
	 });
	 
	 // ajax随机切换验证码图片
	 $(".codeChange").click(function(){
		 var num = getRandom(1,30);
		 $.post("CodeServlet",
				{
			 		code:num
			 	},
			 	function(data,status){
			 		if(status == "success"){
			 			$("#codeImg").attr("src","images/yzm/"+data+".png");
			 		}
			 	});
	 });
	 
	 // 当页面加载的时候进行自动触发事件换验证码识别
	 $(".codeChange").trigger("click");

	 
	 // 表单提交按钮功能控制   =========  利用改变页面中的文本来进行判断是否可以提交
	 $("#submit").click(function(event){
		 if(htm(".box_1") == 1 && htm(".box_2") == 1 && htm(".box_3") == 1 && htm(".box_4") == 1
			&& htm(".box_6") == 1 && htm(".box_7") == 1 && htm(".box_8") == 1 && htm(".box_9") == 1)
		 {
			 $("form").submit();
		 }else{
			 event.preventDefault(); 
		 }
	 });
	 
	 
	 
});




// 判断value的字符长度
function valLength(obj){
	return $.trim($(obj).val()).length;
}

// 获取当前的value值
function value(obj){
	return $.trim($(obj).val());
}

// 获取class="success"字段的HTML值
function htm(obj){
	return $(obj).find(".success").html();
}

// 设置class="success"字段的HTML值
function setHtml(obj,str){
	$(obj).find(".success").html(str);
}



// 设置现实与隐藏=====提醒显示结果
function remain(obj){
	$(obj).find(".remain").css("display","block");
	$(obj).find(".success").css("display","none");
	$(obj).find(".warning").css("display","none");
	return $(obj);
}

// warning提示结果，信息的输入
function warning(obj,str){
	$(obj).find(".warning_txt").html(str);
	$(obj).find(".remain").css("display","none");
	$(obj).find(".success").css("display","none");
	$(obj).find(".warning").css({"display":"block","color":"red"});
	return $(obj);
}

// success提示结果，
function success(obj){
	$(obj).find(".remain").css("display","none");
	$(obj).find(".success").css("display","block");
	$(obj).find(".warning").css("display","none");
	return $(obj);
}

// 获取随机数
function getRandom(min,max){   
	var range = max - min;   
	var rand = Math.random();   
	return (min + Math.round(rand * range));   
}














