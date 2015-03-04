<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>图书馆管理系统-用户界面</title>

<%@ include file="/public/publicStyle.jsp" %>
<link rel="stylesheet" href="css/welcome.css" type="text/css" /> 


</head>
<body>	
	<div id="container" class="clearfix hcen">
		<!--header 部分-->
		<div id="header" class="clearfix porel mbs">
			<div class="header_border">dsf</div>
			<div id="logo">
				<a href="index.jsp">
					<img src="images/logo.png" alt="logo图片" title="图书管理系统" width="240px" height="80px"/>
				</a>
			</div>
			<div id="login_box">
				<span id="nowdate" class="mll porel">欢迎:
					<span id="username">${usersession.user}</span>
					<a href="javascript:void(0)" class="a unenter">退出登录</a>
				</span>
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
		
		<div id="body" class="clearfix"></div>
		
		<%@ include file="/public/footer.jsp" %>
	</div>
	<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript">
		$(function(){
			$(".unenter").click(function(){
				$.get("loginServlet",function(data,status){
					if(status =='success'){
						alert("成功退出！");
						location.href = data;
					}
				});
			});
		});
	</script>
</body>
</html>