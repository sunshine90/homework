package myservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import myproject.manager;
import myproject.managerDAO;
import myproject.managerDAOImpl;

/**
 * Servlet implementation class ManagerLogin
 */
public class ManagerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		managerDAO mdao = new managerDAOImpl();
		manager man = mdao.m_login(name, name, password);
				
		if(man != null){
			HttpSession session = request.getSession();
			session.setAttribute("managersession", man);
			PrintWriter out = response.getWriter();
			out.print("true");
		}else{
			PrintWriter out = response.getWriter();
			out.print("false");
		}
		
	}

}
