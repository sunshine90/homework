package myservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import myproject.users;
import myproject.usersDAO;
import myproject.usersDAOImpl;

/**
 * Servlet implementation class userServlet
 */
public class userServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");		// 此处处理乱码是post过来的值进行转码设置
		
		String name = request.getParameter("username");
		String value = null;
		value = new String(name.getBytes("ISO-8859-1"),"UTF-8");  // 此处处理乱码问题是get过来的值
		
		usersDAO udao = new usersDAOImpl();			// 创建一个dao的对象
		boolean bool = udao.u_existUser(value);		// 查询结果返回boolean类型的值
		
//		System.out.println(value + bool);
		
		PrintWriter out = response.getWriter();
		if(bool){
			out.print("true");		// 如果存在该用户，那么返回输出一个 true，传给js处理
		}else{
			out.print("false");		// 如果不存在该用户，那么返回输出一个 false，传给js处理
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		// 添加用户  =====  获取表单数据提交
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String rel_name = request.getParameter("rel_name");
		String sex = request.getParameter("sex");
		String sid = request.getParameter("studentID");
		String depart = request.getParameter("depart");
		String tel = request.getParameter("tel");
		
		usersDAO udao = new usersDAOImpl();
		users user = new users(username, password, rel_name, sid, sex, depart, tel);
		
		udao.u_add(user);
		
		HttpSession session = request.getSession();
		session.setAttribute("usersession", user);
		
//		response.sendRedirect("welcome.jsp");
		request.getRequestDispatcher("welcome.jsp").forward(request, response);
		
	}

}
