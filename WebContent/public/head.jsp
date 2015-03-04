<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

    <!--header 部分-->
		<div id="header" class="clearfix porel mbs">
			<div class="header_border">dsf</div>
			<div id="logo">
				<a href="index.jsp">
					<img src="images/logo.png" alt="logo图片" title="图书管理系统" width="240px" height="80px"/>
				</a>
			</div>
			<div id="clock_canvas">
				<canvas id="clock" width="200px" height="200px">该浏览器版本不支持HTML5，请更新。。。</canvas>
				<script type="text/javascript">
					window.onload = function (){
						var can = document.getElementById("clock");
						var cxt = can.getContext("2d");
			
			
						function draw(){
							// 清楚重画
							cxt.clearRect(0,0,200,200);
							
							// 获取当前的时间
							var date = new Date();
							var hour = date.getHours();
							var seconds = date.getSeconds();
							var minutes = date.getMinutes();
							
							hour = hour + minutes/60;
							hour = hour > 12 ? hour - 12 : hour;
							
							
							// 表盘的设计
							cxt.beginPath();
							cxt.lineWidth=5;
							cxt.strokeStyle="blue";
							cxt.arc(100,100,90,0,360,false);	// 表盘圆
							cxt.closePath();
							cxt.stroke();
							
							for(var i=0;i<12;i++){
								cxt.save();
								cxt.lineWidth=3;
								cxt.strokeStyle="#000";
								cxt.translate(100,100);
								cxt.rotate(i*30*Math.PI/180);
								
								cxt.beginPath();
								cxt.moveTo(0,-68);
								cxt.lineTo(0,-82);
								cxt.closePath();
								cxt.stroke();
								
								if(i==0 || i==3 || i==6 || i==9){
									cxt.beginPath();
									cxt.arc(0,-60,1,0,360,false);
									cxt.closePath();
									cxt.strokeStyle="#444";
									cxt.stroke();
								}
								cxt.restore();
								
								for(var j=0;j<5;j++){
									cxt.save();
									cxt.lineWidth=2;
									cxt.strokeStyle="#000";
									cxt.translate(100,100);
									cxt.rotate((i*30+6*j)*Math.PI/180);
									cxt.beginPath();
									cxt.moveTo(0,-75);
									cxt.lineTo(0,-82);
									cxt.closePath();
									cxt.stroke();
									cxt.restore();
								}
								
							}
							
							// 分针
							cxt.save();
							cxt.lineWidth=3;
							cxt.strokeStyle="#000";
							cxt.translate(100,100);
							cxt.rotate(minutes*6*Math.PI/180);
							cxt.beginPath();
							cxt.moveTo(0,15);
							cxt.lineTo(0,-57);
							cxt.closePath();
							cxt.stroke();
							cxt.restore();
							
							// 时针
							cxt.save();
							cxt.lineWidth=4;
							cxt.strokeStyle="#000";
							cxt.translate(100,100);
							cxt.rotate(hour*30*Math.PI/180);
							cxt.beginPath();
							cxt.moveTo(0,10);
							cxt.lineTo(0,-48);
							cxt.closePath();
							cxt.stroke();
							cxt.restore();
							
							
							// 秒针
							cxt.save();
							cxt.lineWidth=2;
							cxt.strokeStyle="red";
							cxt.translate(100,100);
							cxt.rotate(seconds*6*Math.PI/180);
							cxt.beginPath();
							cxt.moveTo(0,20);
							cxt.lineTo(0,-65);
							cxt.closePath();
							cxt.stroke();
							// 中心轴原点
							cxt.beginPath();
							cxt.arc(0,0,3.5,0,360,false);
							cxt.closePath();
							cxt.fillStyle="#fff";
							cxt.fill();
							cxt.stroke();
							
							// 秒针针头原点
							cxt.beginPath();
							cxt.arc(0,-50,4,0,360,false);
							cxt.closePath();
							cxt.fillStyle="#808080";
							cxt.fill();
							cxt.stroke();
							
							cxt.restore();
						}
						
						draw();
						setInterval(draw,1000);
						
					}
				</script>
			</div>
			<div id="login_box">
				<span id="nowdate" class="mll">管理员:
					<span id="managername" style="color:red">${managersession.name}</span>
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