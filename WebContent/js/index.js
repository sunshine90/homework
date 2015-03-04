var jq=jQuery.noConflict();
jq(document).ready(function(){
	
	// 获取cookie中的值
	var username = cookie('username');
	var userpwd = cookie('userpassword');
	if(username != null && userpwd != null){
		jq("#login_user").val(username);
		jq("#login_pwd").val(userpwd);
	}
	
	// 用户登录表单提交
	jq("#login_submit").click(login1);
	function login1(){
		jq("#errormessage").html("<img src='images/loading9.gif'/>");
		jq.post("loginServlet",
				{
					username : jq("#login_user").val(),
					password : jq("#login_pwd").val()
				},
				function(data,status){
					if(status == "success"){
						if(data == "true"){
							// 记住密码，设置cookie
							var check = document.getElementById("login_check").checked;
							if(check){
								// 添加cookie
								var name = jq.trim(jq("#login_user").val());
								var password = jq("#login_pwd").val();
								cookie('username',name,7);
								cookie('userpassword',password,7);
							}else{
								// 删除cookie
								if(username != null && userpwd != null){
									cookie('username',null,0);
									cookie('userpassword',null,0);
								}
							}
							// 成功登录后的页面跳转
							location.href = "welcome.jsp";
						}else if(data == "false"){
							jq("#errormessage").html("用户名或密码错误，请重新输入...").css("color","red");
						}
					}
				});
	};
	

	// 管理员身份登录界面
	jq(".manage_login,#m_del").click(function(){
		jq("#manager_login").slideToggle('slow');
	});
	
	// manager登录表单提交
		// 鼠标按键
		jq("#m_login").click(managerlogin);
		// 键盘按键事件
		jq("#manager_login").keydown(function(e){
			if(e.which == 13){
				jq("#m_login").click();
			}
		});
	function managerlogin(){
		jq(".m_err_log").html("<img src='images/loading11.gif'/>");
		jq.post("ManagerLogin",
				{
					name : jq("#manager_name").val(),
					password : jq("#manager_pwd").val()
				},
				function(data,status){
					if(status == "success"){
						if(data == "true"){
							location.href = "manage.jsp";
						}else if(data == "false"){
							jq(".m_err_log").html("登录信息错误，请重新输入...").css("color","red");
						}
					}
				});
	};

	
	
	
	// cdays大于0 的时候添加cookie，小于0的时候删除cookie，cookie函数的封装
	/* *
	 *  cookie("name","value",4);设置cookie
	 *  cookie("name",null,0);删除cookie,
	 *  cookie("name");查询cookie;
	 * */
	function cookie(cname, cvalue, cdays) {
		var args = arguments.length;	// 判断传入参数的个数
		if(args == 3){
			var cookietext = encodeURIComponent(cname) + '=' + encodeURIComponent(cvalue); //编码写入
			if(cdays > 0){
				var date = new Date();
				date.setDate(date.getDate() + cdays);
				cookietext += ";expires=" + date;
			}else if(cdays <= 0 && cvalue == null){
				var date = new Date(0);
				cookietext += ";expires=" + date;
			}
			document.cookie = cookietext;
		}else if(args == 1){
			var cookieName = encodeURIComponent(cname) + '=';
			var cookieStart = document.cookie.indexOf(cookieName);
			var cookieValue = null;
			if (cookieStart > -1) {
				var cookieEnd = document.cookie.indexOf(';', cookieStart);	// 检查键值对结束时（有时间等其他cookie的内容）
				if (cookieEnd == -1) {
					cookieEnd = document.cookie.length;		// 只有键值对的时候（没有时间等其他的内容的时候）
				}
				cookieValue = decodeURIComponent(document.cookie.substring(cookieStart + cookieName.length, cookieEnd));
			}
			return cookieValue;
		}
	}
	
});











