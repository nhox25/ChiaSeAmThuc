package action_home;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Users;
import bo.UsersBO;


@WebServlet("/AddUsersAction")
public class SignUpAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
	
		//kiểm tra đăng nhập
//		HttpSession session = request.getSession();
//		Users usersLogin = (Users)session.getAttribute("users");
//		if(usersLogin==null){
//			response.sendRedirect(request.getContextPath()+"/admin/login");
//			return;
//		}
		
		String submit = request.getParameter("add");
		Users users ;
		if(submit!=null){
			String username = request.getParameter("username");
			String password = request.getParameter("password");
//			String re_password = request.getParameter("re_password");
			String fullname = request.getParameter("fullname");
			String address = request.getParameter("address");
			String phone = request.getParameter("phone");
			String email = request.getParameter("email");
			users = new Users(username, password, fullname, address, phone, email);
			if(UsersBO.addUser(users)){
				response.sendRedirect(request.getContextPath()+"/home/login?msg2=Đăng ký thành công! Đăng nhập ngay?");
			}
			else{
				RequestDispatcher rd = request.getRequestDispatcher("/signup.jsp?msg=Đăng ký thất bại");
				rd.forward(request, response);
			}
		}
		else{
			RequestDispatcher rd = request.getRequestDispatcher("/signup.jsp");
			rd.forward(request, response);
		}
	}

}
