$(function(){
	$(".m_books").click(function(){
		$(".m_b_box").css("display","block");
		$(".m_u_box").css("display","none");
		$(".m_m_box").css("display","none");
	});
	$(".m_users").click(function(){
		$(".m_b_box").css("display","none");
		$(".m_u_box").css("display","block");
		$(".m_m_box").css("display","none");
	});
	$(".m_managers").click(function(){
		$(".m_b_box").css("display","none");
		$(".m_u_box").css("display","none");
		$(".m_m_box").css("display","block");
	});
	
	// 查询所有的书籍
	$("#all_books").click(function(){
		// ajax显示所有书籍
		$.get("AllBooksServlet",function(data,status){
			if(status=="success"){
				//添加动态的事件必须在动态添加的HTML后，添加相应的事件。监听删除书籍的按钮
				var obj = $("#book_result");
				obj.html(data);
				
				// 查看按钮控件的绑定
//				obj.find(".search_look").on("click",function(){
				obj.on("click",".search_look",function(){
					// 获取该表格的td对象
					var object = $(this).parents("tr").find("td");
					
					// 获取该表格中的值
					var bookid = object.find(".hidden").val();
					var bookname = object.eq(1).html();
					var booktype = object.eq(2).html();
					var bookauthor = object.eq(3).html();
					var price1 = object.eq(4).html();
					var bookprice = price1.substring(1);  // 截取字符串
					var bookdate = object.eq(5).html();
					
					// ajax 该页面上的内容 到类一个页面上
					$.post("SearchLookServlet",{
						id:bookid,name:bookname,type:booktype,author:bookauthor,
						price:bookprice,date:bookdate
					},function(data,status){
						if(status == "success"){
							if(data == "true"){
								window.location.href="lookbook.jsp";
							}
						}
					});
				});
				
				
				
				// 删除按钮控件的绑定
//				obj.find(".delete_book").on("click",function(){
				obj.on("click",".delete_book",function(){
					var bool = confirm("您确定要删除该书籍吗？");
					if(bool){
						// 获取隐藏节点的value值
						var id = $(this).parents("tr").find(".hidden").val();
						// 再次post处理删除命令
						$.post("AllBooksServlet",{Id:id},function(data,status){
							if(status=="success"){
								alert(data);
								window.location.reload();
							}
						});
					}
				});
				
			}
		});
	});
	
	
	// select的option选择改变的时候，提交信息显示
	$("#type_books").change(function(){
		if($(this).val() != '0'){
			$.get("SearchBooksServlet",{type:$(this).val()},function(data,status){
				if(status=="success"){
					//添加动态的事件必须在动态添加的HTML后，添加相应的事件。监听删除书籍的按钮
					var obj1 = $("#book_result").html(data);
					
					// 查看按钮控件的绑定，select查看中的事件控制
					obj1.find(".search_look").on("click",function(){
						// 获取该表格的td对象
						var object = $(this).parents("tr").find("td");
						
						// 获取该表格中的值
						var bookid = object.find(".hidden").val();
						var bookname = object.eq(1).html();
						var booktype = object.eq(2).html();
						var bookauthor = object.eq(3).html();
						var price1 = object.eq(4).html();
						var bookprice = price1.substring(1);  // 截取字符串
						var bookdate = object.eq(5).html();
						
						// ajax 该页面上的内容 到类一个页面上
						$.post("SearchLookServlet",{
							id:bookid,name:bookname,type:booktype,author:bookauthor,
							price:bookprice,date:bookdate
						},function(data,status){
							if(status == "success"){
								if(data == "true"){
									window.location.href="lookbook.jsp";
								}
							}
						});
					});
					
					// select查询中的删除事件控件
					obj1.find(".delete_book").on("click",function(){
						var bool = confirm("您确定要删除该书籍吗？");
						if(bool){
							// 获取隐藏节点的value值
							var id = $(this).parents("tr").find(".hidden").val();
							// 再次post处理删除命令
							$.post("AllBooksServlet",{Id:id},function(data,status){
								if(status=="success"){
									alert(data);
									window.location.reload();
								}
							});
						}
						
					});
				}
			});
		}
	});
	
	// 文字查找显示结果
	$("#text_book").click(fn1);
		// 添加按键事件
	$(".book_search").keydown(function(e){
		if(e.which == 13){
			$("#text_book").click();
		}
	});
	function fn1(){
		$.post("SearchBooksServlet",{text:$.trim($("#book").val())},function(data,status){
			if(status=="success"){
				//添加动态的事件必须在动态添加的HTML后，添加相应的事件。监听删除书籍的按钮
				var obj2 = $("#book_result").html(data);
				
				// 查看按钮控件的绑定，文本查看中的事件控制
				obj2.find(".search_look").on("click",function(){
					// 获取该表格的td对象
					var object = $(this).parents("tr").find("td");
					
					// 获取该表格中的值
					var bookid = object.find(".hidden").val();
					var bookname = object.eq(1).html();
					var booktype = object.eq(2).html();
					var bookauthor = object.eq(3).html();
					var price1 = object.eq(4).html();
					var bookprice = price1.substring(1);  // 截取字符串
					var bookdate = object.eq(5).html();
					
					// ajax 该页面上的内容 到类一个页面上
					$.post("SearchLookServlet",{
						id:bookid,name:bookname,type:booktype,author:bookauthor,
						price:bookprice,date:bookdate
					},function(data,status){
						if(status == "success"){
							if(data == "true"){
								window.location.href="lookbook.jsp";
							}
						}
					});
				});
				
				// 文本查找，动态绑定事件
				obj2.find(".delete_book").on("click",function(){
					var bool = confirm("您确定要删除该书籍吗？");
					if(bool){
						// 获取隐藏节点的value值
						var id = $(this).parents("tr").find(".hidden").val();
						// 再次post处理删除命令
						$.post("AllBooksServlet",{Id:id},function(data,status){
							if(status=="success"){
								alert(data);
								window.location.reload();
							}
						});
					}
					
				});
			}
		});
	};
	
	
	// 添加书籍模块处理
	
	// 添加书籍,弹出添加书籍的box框架
	$("#add_book,#mengban,.close_box").click(function(){
		$("#mengban,#addbookbox").toggle("slow");
	});
	
	// 校验书籍是否重名，并加以提示错误
	var nameTrue = false;
	$("#book_name").blur(function(){
		var value = $.trim($(this).val());
		if(value == ''){
			$(".warning_txt").html("书名不能为空！");
		}else{
			$.get("AddBookServlet",{name:value},function(data,status){
				if(status == "success"){
					if(data == "true"){
						$(".warning_txt").html("该书名已存在！");
					}else{
						$(".warning_txt").html("正确！");
						nameTrue = true;
					}
				}
			});
		}
	});
	$("#book_name").focus(function(){
		$(".warning_txt").html("请输入书名...");
	});
	
	// 价格输入的检验
	var priceTrue = false;
	$(".price1").blur(function(){
		var price = $.trim($("[name='price']").val());
		var bool = /^\d*\.\d*$/.test(price);
		if(bool){
			$(".price_warning").html("格式正确");
			priceTrue = true;
		}else{
			$(".price_warning").html("输入单价格式错误！");
		}
	});
	$(".price1").focus(function(){
		$(".price_warning").html("输入格式(<strong>??.??</strong>)(限数字)");
	});
	
	// 添加书籍的按钮
	$("#add").click(function(){
		var date1 = $("[name='year']").val() + '-'+$("[name='month']").val()+'-'+$("[name='day']").val();
		var type1 = $.trim($("[name='type']").val());
		var author1 = $.trim($("[name='author']").val());
		var price1 = $.trim($("[name='price']").val());
		var name1 = $.trim($("[name='name']").val());
		
		if(type1 != '' && date1 != '' && author1 != '' && nameTrue && priceTrue){
			$.post("AddBookServlet",{
				name:name1,type:type1,price:price1,author:author1,date:date1
				},function(data,status){
					if(status == 'success'){
						if(data == 'true'){
							window.location.href = "manage.jsp";
						}
					}
				});
		}
		
	});
	
	
	// 当month的值发生改变的时候，day的天数也要发生相应的改变
	// 但是在开始之前要执行一次，防止day的框为空元素
	$(".day").html(function(){
		var htm;
		for(var i=1;i<=31;i++){
			htm = htm + "<option value="+ i +">"+ i +"</option>";
		}
		return htm;
	});
	$(".month").change(function(){
		var v = $(this).val();
		$(".day").html(function(){
			var num;
			var htm;
			if(v == '2'){
				num =28;
			}else if(v == '4' || v=='6' || v=='9' || v=='11'){
				num = 30;
			}else{
				num = 31;
			}
			
			for(var i=1;i<=num;i++){
				htm = htm + "<option value="+ i +">"+ i +"</option>";
			}
			return htm;
		});
	});
	
	
	
	// 更改类型的按钮
	var selecthtml = $(".type").html();
	var texthtml = "<input name='type' type='text' autocomplete='off'/>";
	var flag = 1;
	$(".updateModel").click(function(){
		if(flag == 1){
			$(".type").html(texthtml).toggleClass("type1");
			$(".updateModel").html("类型选择");
			flag = 2;
		}else if(flag == 2){
			$(".type").html(selecthtml).toggleClass("type1");
			$(".updateModel").html("新增类型");
			flag = 1;
		}
	});
	
	
	
});












