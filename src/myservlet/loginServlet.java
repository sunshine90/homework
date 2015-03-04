package myservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import myproject.DBUtil;
import myproject.users;
import myproject.usersDAO;
import myproject.usersDAOImpl;

/**
 * Servlet implementation class loginServlet
 */
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		session.removeAttribute("usersession");
		PrintWriter out = response.getWriter();
		out.print("index.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		
		// 进行转码处理，tomcat默认编码为iso-8859-1，需要进行国际编码处理为utf-8.
//		username = new String(username.getBytes("iso-8859-1"),"utf-8"); 
		
		usersDAO udao = new usersDAOImpl();
		users user = udao.u_login(username, password);
		
		// 当user 不为空的时候，就是在数据库中查询到了该对应的用户！
		if(user != null){
			HttpSession session = request.getSession();
			session.setAttribute("usersession", user);
			PrintWriter out = response.getWriter();
			out.print("true");
			
//			response.sendRedirect("welcome.jsp");
//			request.getRequestDispatcher("welcome.jsp").forward(request, response);
		}else{
			PrintWriter out = response.getWriter();
			out.print("false");
		}
	}

}
