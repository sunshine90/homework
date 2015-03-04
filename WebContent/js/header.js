
/*================
	头部 header.js
=======================*/

$(function(){
	// 登录框
	var login = $("#enter_box");
	var screen = $("#lock_screen");
	login.center(450,370).resize(function(){
		if(login.css("display") == "block"){
			screen.lock();
		}
	});
	$('.close_img').click(function(){
		login.css("display","none");
		screen.unlock();
	});
	$(".login").click(function(){
		login.center(450,370);
		login.css("display","block");
		screen.lock();
	});
	
	// 实现弹出框的拖拽功能
	login.drag($('#enter_box h2').first());
	
	// 对时间格式化的输出
	function time(){
		function toall(num){  		//对获取的时间进行字符串的处理，小于10的进行前面加“0”的处理后变字符串的形式；
			if(num < 10){ 
				return  '0'+ num;
			}else{
				return '' + num;
			}
		}
		var myDate = new Date();
		
		var arr = ["星期日","星期一","星期二","星期三","星期四","星期五","星期六"];
		var index = myDate.getDay();
		
		var year = myDate.getFullYear();
		var month = myDate.getMonth()+1;
		var date = myDate.getDate();
		var hours = toall(myDate.getHours());
		var mimutes = toall(myDate.getMinutes());
		var seconds = toall(myDate.getSeconds());
		
		var str = year +"年"+ month +"月"+ date +"日  "+ arr[index] +"  "+ hours +":"+ mimutes +":"+ seconds;
		
		$("#nowdate").html(str);
	}
	time();
	setInterval(time,1000);
	
	
	
	
	
	
});














