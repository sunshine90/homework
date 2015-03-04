package myservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import myproject.DBUtil;
import myproject.books;
import myproject.booksDAO;
import myproject.booksDAOImpl;

/**
 * Servlet implementation class SearchLookServlet
 */
public class SearchLookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchLookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String Id = request.getParameter("id");
		int id = Integer.parseInt(Id);
		String name = request.getParameter("name");
		String type = request.getParameter("type");
		String author = request.getParameter("author");
		String price = request.getParameter("price");
		String date = request.getParameter("date");
		
		// 获取更新类型的判断
		String update = request.getParameter("update");
		
		if(update == null){
			
			// 利用Javabean来储存books的相关信息
			books book = new books();
			book.setId(id);
			book.setName(name);
			book.setType(type);
			book.setAuthor(author);
			book.setPrice(price);
			book.setDate(date);


			// 将该对象存储到request的setattrbute属性中
			HttpSession session = request.getSession();
			session.setAttribute("lookBook", book);
			
			PrintWriter out = response.getWriter();
			out.print("true");
		}else{
//			System.out.println(update + id + name + type + author + price + date);
			price = price.substring(1);
			
			// 利用Javabean来储存books的相关信息
			books book = new books();
			book.setId(id);
			book.setName(name.trim());
			book.setType(type.trim());
			book.setAuthor(author.trim());
			book.setPrice(price.trim());
			book.setDate(date.trim());
			
			booksDAO bdao = new booksDAOImpl();
			bdao.update(book);
			
			request.getRequestDispatcher("manage.jsp").forward(request, response);
		}
		
	}

}





