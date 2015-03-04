package myservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myproject.books;
import myproject.booksDAO;
import myproject.booksDAOImpl;

/**
 * Servlet implementation class AllBooksServlet
 */
public class AllBooksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllBooksServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		booksDAO bdao = new booksDAOImpl();
		List<books> list = bdao.query();
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		
		if(!list.isEmpty()){
			out.println("<table border='1'><tr class='first_tr'><th>编号</th><th>书名</th><th>类型</th><th>所属</th><th>价格</th><th>出版日期</th><th>修改</th><th>删除</th></tr>");
			String jiou;
			for(int i=0 ;i<list.size();i++){
				if(i % 2 == 0){
					jiou = "even";
				}else{
					jiou = "odd";
				}
				out.print("<tr class="+jiou+">");
				out.print("<td><input class='hidden' type='hidden' value='"+list.get(i).getId()+"'/>"+(i+1)+"</td>");
				out.print("<td>"+list.get(i).getName()+"</td>");
				out.print("<td>"+list.get(i).getType()+"</td>");
				out.print("<td>"+list.get(i).getAuthor()+"</td>");
				out.print("<td>￥"+list.get(i).getPrice()+"</td>");
				out.print("<td>"+list.get(i).getDate()+"</td>");
				out.print("<td><a class='search_look' href='javascript:void(0)'>查看</a></td>");
				out.print("<td><a class='delete_book' href='javascript:void(0)'>删除</a></td>");
				out.println("</tr>");
			}
			out.print("</table>");
		}else{
			out.print("未查询到相关记录！");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		// 获取传送过来的id值，然后进行转化成int类型的
		String id = request.getParameter("Id");
		int Id = Integer.parseInt(id);
		
		// 删除数据
		booksDAO bdao = new booksDAOImpl();
		bdao.delete(Id);
		
		// 删除成功后做的相应信息
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("删除成功！");
		
	}

}
