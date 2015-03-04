package myservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myproject.books;
import myproject.booksDAO;
import myproject.booksDAOImpl;

/**
 * Servlet implementation class AddBookServlet
 */
public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		name = new String(name.getBytes("iso-8859-1"),"utf-8");
		
		booksDAO bdao = new booksDAOImpl();
		boolean bool = bdao.isExist(name);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		if(bool){
			out.print("true");
		}else{
			out.print("false");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String name = request.getParameter("name");
		String type = request.getParameter("type");
		String date = request.getParameter("date");
		String author = request.getParameter("author");
		String price = request.getParameter("price");
		
		booksDAO bdao = new booksDAOImpl();
		books book = new books();
		book.setAuthor(author);
		book.setDate(date);
		book.setName(name);
		book.setPrice(price);
		book.setType(type);
		
		bdao.add(book);
		
		PrintWriter out = response.getWriter();
		out.print("true");
		
	}

}















