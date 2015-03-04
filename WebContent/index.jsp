<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html> 
<html> 
<head> 
<meta charset="utf-8" /> 
<title>图书馆管理系统</title> 
<meta name="keywords" content="关键词" /> 
<meta name="description" content="关键词描述" /> 
	<link rel="stylesheet" href="css/index.css" type="text/css" />
	<script src="js/tool.js" type="text/javascript"></script>
	<script src="js/basic.js" type="text/javascript"></script>
	<script src="js/basic_drag.js" type="text/javascript"></script>
	
	
	<%@ include file="/public/publicStyle.jsp" %>
	<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="js/index.js"></script>
	<script src="js/header.js" type="text/javascript"></script>
</head> 
<body>		
	<div id="container" class="clearfix hcen">
		<%@ include file="/public/header.jsp" %>

		<!--body 部分-->
		<div id="body" class="clearfix">
			<div id="nav" class="clearfix">
				<div class="head_img"></div>
				<div class="nav_content">
					<p class="manage_login teal">管理员身份登录</p>
				</div>
				<form id="manager_login" class="mtm clearfix" action="ManagerLogin" method="post">
					<div class="m_err_log"></div>
					<p class="text mbm mts">
						<label for="manager_name" class="">管理身份:</label>
						<input id="manager_name" type="text" name="manager" autocomplete="off" placeholder="身份名/手机号" value="${managersession.name}"/>
					</p>
					<p class="text mbm">
						<label for="manager_pwd" class="">密码验证:</label>
						<input id="manager_pwd" type="password" name="password"  placeholder="密码验证"/>
					</p>
					<p class="login_sub mbl">
						<input type="button" class="mrm" id="m_login" value="登  录" />
						<input type="button" class="mlm" id="m_del" value="取  消" />
					</p>
				</form>
			</div>
			<div id="content" class="clearfix porel">
				<div class="first_box clearfix">
					<h2 class="head">
						<div class="title">中文数据库</div>
					</h2>
					<div class="main"></div>
					<p class="foot"></p>
				</div>
				<div class="second_box clearfix">
					<h2 class="head">
						<div class="title">外文数据库</div>
					</h2>
					<div class="main"></div>
					<p class="foot"></p>
				</div>
				<div class="third_box clearfix">
					<h2 class="head">
						<div class="title">适用数据库</div>
					</h2>
					<div class="main"></div>
					<p class="foot"></p>
				</div>
				<div class="fourth_box clearfix">
					<h2 class="head">
						<div class="title">光盘资源库</div>
					</h2>
					<div class="main"></div>
					<p class="foot"></p>
				</div>
			</div>
		</div>
		
		
		<%@ include file="/public/footer.jsp" %>
		
	</div>
</body>
</html>



















