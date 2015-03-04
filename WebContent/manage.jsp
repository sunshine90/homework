
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ page import="myproject.*" %>
 <%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>管理员-管理界面</title>
	<link rel="stylesheet" href="css/manage.css" type="text/css" />
	<%@ include file="/public/publicStyle.jsp" %>
	<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="js/manage.js"></script>
</head>
<body>
	<div id="container" class="clearfix hcen">
	
		<%@ include file="/public/head.jsp" %>
		
		<!-- 添加书籍部分 -->
		<div id="mengban"></div>
		<div id="addbookbox">
			<h2 class="names">书籍的添加<span class="close_box">close</span></h2>
			<div class="clearfix form"><!-- AddBookServlet -->
				<div class="txt">
					<label>书名</label>
					<span class="input1">
						<input name="name" id="book_name" type="text" autocomplete="off"/>
					</span>
					<span class="warning_txt"></span>
				</div>
				<div class="txt">
					<label>类型</label>
					<span class="input1 type type1">
						<select name="type" class="addtype">
							<%
							// 查询类型输出
								booksDAO bdao1 = new booksDAOImpl();
								String[] str1 = bdao1.distinctType();
								for(int i = 0; i<str1.length;i++){
									out.println("<option value="+ str1[i] +">"+ str1[i] +"</option>");
								}
							%>
						</select>
					</span>
					<span class="updateModel">新增类型</span>
				</div>
				<div class="txt">
					<label>所属</label>
					<span class="input1">
						<input name="author" type="text" autocomplete="off"/>
					</span>
				</div>
				<div class="txt">
					<label>价格</label>
					<span class="input1">
						<span class="rmb">￥</span><input class="price1" name="price" type="text" autocomplete="off"/>
					</span>
					<span class="price_warning"></span>
				</div>
				<div class="txt">
					<label>日期</label>
					<span class="input1 date_select">
						<select name="year">
							<%
								for(int i=1960;i<=2015;i++){
									out.println("<option value="+ i +">"+ i +"</option>");
								}
							%>
						</select>-
						<select name="month" class="month">
							<%
								for(int i=1;i<=12;i++){
									out.println("<option value="+ i +">"+ i +"</option>");
								}
							%>
						</select>-
						<select name="day" class="day">
							<!-- 此处jquery来实现月份的更改 -->
						</select>
						<!-- <input name="date" type="text" autocomplete="off"/> -->
					</span>
				</div>
				<div class="txt btn">
					<input type="submit" id="add" value="添加"/>
				</div>
			</div>
		</div>
		
		<!-- body部分 -->
		<div id="body" class="clearfix">
			<div id="left_nav" class="clearfix">
				<a href="javascript:void(0)" class="m_books mtl mbm">书籍管理</a>
				<a href="javascript:void(0)" class="m_users mbm">用户管理</a>
				<a href="javascript:void(0)" class="m_managers">管理员身份管理</a>
			</div>
			<div id="right" class="clearfix porel">
				<div class="m_b_box">
					<h2>图书管理</h2>
					<div class="book">
						<p class="search_book porel">
							<button id="all_books">查询所有书籍</button>
							<button id="add_book">添加书籍</button>
							<span class="types">
								<label>按类型查找：</label>
								<select name="search_type" id="type_books">
									<option value="0">--请选择--</option>
									<%
									// 查询类型输出
										booksDAO bdao = new booksDAOImpl();
										String[] str = bdao.distinctType();
										for(int i = 0; i<str.length;i++){
											out.println("<option value="+ str[i] +">"+ str[i] +"</option>");
										}
									%>
								</select>
							</span>
							<span class="search_box book_search">
								<span class="input">
									<input type="text" name="book" id="book" autocomplete="off" placeholder="作者/书名关键字"/>
								</span>
								<span class="search_logo" id="text_book">search_img</span>
							</span>
							<div id="book_result"></div>
						</p>
					</div>
				</div>
				
				<div class="m_u_box">
					<h2>用户管理</h2>
					<div class="user">
						<p class="search_user porel">
							<button id="all_users">查询所有用户</button>
							<span class="search_box user_search">
								<span class="input"><input type="text" name="user" autocomplete="off" id="user"/></span>
								<span class="search_logo">search_img</span>
							</span>
							<div id="user_result">
									<%
										usersDAO udao = new usersDAOImpl();
										List<users> list = udao.u_query();
										String jiou;
										if(!list.isEmpty()){
											out.print("<table border='1'>");
											out.print("<tr class='first_tr'><th>编号</th><th>用户名</th><th>学号</th><th>真实姓名</th><th>性别</th><th>学院</th><th>联系方式</th></tr>");
											for(int i=0;i<list.size();i++){
												if(i % 2 == 0){
													jiou = "even";
												}else{
													jiou = "odd";
												}
												int id = list.get(i).getId();
												String user = list.get(i).getUser();
												String relname = list.get(i).getRel_name();
												String sid = list.get(i).getS_id();
												String depart = list.get(i).getDepart();
												String tel = list.get(i).getTel();
												String sex = list.get(i).getSex();
												
												out.print("<tr class="+jiou+"><td><input type='checkbox' name='check'/><input type='hidden' name='uid' value="+id+"/></td>"+
												"<td>"+user+"</td>"+"<td>"+sid+"</td>"+"<td>"+relname+"</td>"+"<td>"+sex+"</td>"+"<td>"+depart+"</td>"+"<td>"+tel+"</td>"+"</tr>");
											} 
											out.print("</table>");
										}
									%>
							</div>
						</p>
					</div>
				</div>
				<div class="m_m_box">
					<h2>管理员管理</h2>
					<div class="manager">
						<p class="search_manager porel">
							<button id="all_managers">查询所有管理员</button>
							<span class="search_box manager_search">
								<span class="input"><input type="text" name="manager" autocomplete="off" id="manager"/></span>
								<span class="search_logo">search_img</span>
							</span>
							<div id="manager_result">
								<%
									managerDAO mdao = new managerDAOImpl();
									List<manager> mlist = mdao.m_query();
									String mjiou;
									if(!list.isEmpty()){
										out.print("<table border='1'>");
										out.print("<tr class='first_tr'><th>编号</th><th>管理员名</th><th>性别</th><th>联系方式</th></tr>");
										for(int i=0;i<mlist.size();i++){
											if(i % 2 == 0){
												mjiou = "even";
											}else{
												mjiou = "odd";
											}
											int id = mlist.get(i).getId();
											String name = mlist.get(i).getName();
											String tel = mlist.get(i).getTel();
											String sex = mlist.get(i).getSex();
											
											out.print("<tr class="+mjiou+"><td><input type='checkbox' name='check'/><input type='hidden' name='mid' value="+id+"/></td>"+
											"<td>"+name+"</td>"+"<td>"+sex+"</td>"+"<td>"+tel+"</td>"+"</tr>");
										} 
										out.print("</table>");
									}
								%>
							</div>
						</p>
					</div>
				</div>
			</div>
		</div>
		<!-- footer部分 -->
		<%@ include file="/public/footer.jsp" %>
	</div>

</body>
</html>