<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

		<!-- 登录框部分 -->
		<div id="lock_screen"></div>
		<div id="enter_box" class="clearfix porel">
			<h2 class="porel">
				<div class="mll"><span  class="log_logo mrs">enter_logo</span>登录界面</div>
				<div class="close_img">
					<img class="close mts" src="images/close.png" alt="close" title="关闭"/>
				</div>
			</h2>
			<div class="log_content hcen">
				<div id="errormessage"></div>
				<form action="loginServlet" method="post">
					<p class="uam mbl">
						<label for="login_user" class="mrs user">用户名:</label>
						<input id="login_user" type="text" name="user" autocomplete="off" placeholder="用户名/手机号"/>
					</p>
					<p class="uam mbm">
						<label for="login_pwd" class="mrs pwd">密 码:</label>
						<input id="login_pwd" type="password" name="password" placeholder="密码"/>
					</p>
					<p class="check mbm mtl porel">
						<input id="login_check" type="checkbox" checked="checked" />
						<label for="login_check">记住登录</label>
						<a class="a" href="register.html">立即注册 ?</a>
					</p>
					<p class="login_sub mtl">
						<input type="button" id="login_submit" value="登         录" />
					</p>
				</form>
			</div>
		</div>
		
		<!--header 部分-->
		<div id="header" class="clearfix porel mbs">
			<div class="header_border">dsf</div>
			
			<div class="header_box clearfix">
				<span class="register mrm"><a href="register.html" class="a register">注册</a></span>
				<span class="mls mrs cu_none">|</span>
				<span class="login">登录</span>
			</div>
			
			<div id="logo">
				<a href="index.jsp">
					<img src="images/logo.png" alt="logo图片" title="图书管理系统" width="240px" height="80px"/>
				</a>
			</div>
			<div id="login_box">
				<span id="nowdate" class="mll">nowdate</span>
				<ul>
					<li>本馆概况
						<ul class="clearfix second">
							<li><a class="a" href="#">本馆简介</a></li>
							<li><a class="a" href="#">机构设置</a></li>
							<li><a class="a" href="#">部门领导</a></li>
							<li class="last"><a class="a" href="#">馆内新闻</a></li>
						</ul>
					</li>
					<li class="mrs">参考咨询
						<ul class="clearfix second">
							<li><a class="a" href="#">原文传递</a></li>
							<li><a class="a" href="#">学科馆员</a></li>
							<li><a class="a" href="#">代查代理</a></li>
							<li><a class="a" href="#">科技查新</a></li>
							<li class="last"><a class="a" href="#">核心期刊</a></li>
						</ul>
					</li>
					<li class="mrs">服务指南
						<ul class="clearfix second">
							<li><a class="a" href="#">入馆须知</a></li>
							<li><a class="a" href="#">证件办理</a></li>
							<li><a class="a" href="#">借阅规则</a></li>
							<li><a class="a" href="#">开放时间</a></li>
							<li><a class="a" href="#">馆藏分布</a></li>
							<li class="last"><a class="a" href="#">部门电话</a></li>
						</ul>
					</li>
					<li class="mrs">兴趣资源
						<ul class="clearfix second">
							<li><a class="a" href="#">用户培训</a></li>
							<li><a class="a" href="#">投稿指南</a></li>
							<li class="last"><a class="a" href="#">文献传递</a></li>
						</ul>
					</li>
					<li class="mrs">信息资源
						<ul class="clearfix second">
							<li><a class="a" href="#">电子图书</a></li>
							<li><a class="a" href="#">中文数据库</a></li>
							<li><a class="a" href="#">外文数据库</a></li>
							<li><a class="a" href="#">光盘资源</a></li>
							<li><a class="a" href="#">特色资源</a></li>
							<li class="last"><a class="a" href="#">文献传递</a></li>
						</ul>
					</li>
					<li class="mrs">公共检索
						<ul class="clearfix second">
							<li><a class="a" href="#">书刊检索</a></li>
							<li><a class="a" href="#">读者信息</a></li>
							<li><a class="a" href="#">新书通报</a></li>
							<li><a class="a" href="#">读者捐赠</a></li>
							<li><a class="a" href="#">留言回复</a></li>
							<li class="last"><a class="a" href="#">使用说明</a></li>
						</ul>
					</li>
					<li class="mrs">读者服务
						<ul class="clearfix second">
							<li><a class="a" href="#">学科服务</a></li>
							<li><a class="a" href="#">定题服务</a></li>
							<li><a class="a" href="#">读者教育</a></li>
							<li><a class="a" href="#">馆际互借</a></li>
							<li class="last"><a class="a" href="#">网络服务</a></li>
						</ul>
					</li>
					<li class="mrs"><a href="index.jsp">首页</a></li>
				</ul>
			</div>
			
		</div>
		