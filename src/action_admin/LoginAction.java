package action_admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Users;
import bo.UsersBO;

/**
 * Servlet implementation class LoginAction
 */
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String submit = request.getParameter("login");
		if(submit!=null){
			//xử lý đăng nhập
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			UsersBO usersBO = new UsersBO();
			Users usersadmin = usersBO.checkLogin(username,password);
			System.out.println(usersadmin);
			if(usersadmin!=null){
				//đăng nhập thành công
				HttpSession session = request.getSession();
				session.setAttribute("usersadmin",usersadmin);
				response.sendRedirect(request.getContextPath()+"/admin/list-users");
			}else{
				RequestDispatcher rd = request.getRequestDispatcher("/admin/login.jsp?msg=Sai tên đăng nhập hoặc mật khẩu");
				rd.forward(request, response);
			}
		} else {
			//load form đăng nhập
			RequestDispatcher rd = request.getRequestDispatcher("/admin/login.jsp");
			rd.forward(request, response);
		}
	}

}
