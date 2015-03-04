<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>查找书籍或更改</title>
	<%@ include file="/public/publicStyle.jsp" %>
	<link rel="stylesheet" type="text/css" href="css/lookbook.css" />
	<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="js/lookbook.js"></script>
</head>
<body>
	<div id="container" class="clearfix hcen">
		<%@ include file="/public/head.jsp" %>
		
		<div class="form">
			<h2 class="names hcen porel"><a href="manage.jsp" class="returnback a">返回</a>书籍修改更新</h2>
			<form action="SearchLookServlet" method="post" class="clearfix hcen">
				<input name="id" type="hidden" readOnly="true" value='${lookBook.id}' />
				<input name="update" type="hidden" readOnly="true" value='update' />
				<div class="txt mtm">
					<label>书名</label>
					<span class="input">
						<input name="name" type="text" readOnly="true" autocomplete="off" value='${lookBook.name}' />
					</span>
					<span class="xiugai">修改</span>
				</div>
				<div class="txt">
					<label>类型</label>
					<span class="input">
						<input name="type" type="text" readOnly="true" autocomplete="off" value='${lookBook.type}' />
					</span>
					<span class="xiugai">修改</span>
				</div>
				<div class="txt">
					<label>所属</label>
					<span class="input">
						<input name="author" type="text" readOnly="true" autocomplete="off" value='${lookBook.author}' />
					</span>
					<span class="xiugai">修改</span>
				</div>
				<div class="txt">
					<label>价格</label>
					<span class="input">
						<input name="price" type="text" readOnly="true" autocomplete="off" value='￥${lookBook.price}' />
					</span>
					<span class="xiugai">修改</span>
				</div>
				<div class="txt mbl">
					<label>日期</label>
					<span class="input">
						<input name="date" type="text" readOnly="true" autocomplete="off" value='${lookBook.date}' />
					</span>
					<span class="xiugai">修改</span>
				</div>
				
				<div class="txt btn mbl">
					<input type="submit" id="xiugai" value="确认修改"/>
				</div>
			</form>
		</div>	
		
		<!-- footer部分 -->
		<%@ include file="/public/footer.jsp" %>
	</div>
		
</body>
</html>