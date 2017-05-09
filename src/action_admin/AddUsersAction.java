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
 * Servlet implementation class AddUsersAction
 */
public class AddUsersAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUsersAction() {
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
		HttpSession session = request.getSession();
		Users usersadmin = (Users)session.getAttribute("usersadmin");
		if(usersadmin==null){
			response.sendRedirect(request.getContextPath()+"/admin/login");
			return;
		}
		
		String submit = request.getParameter("add");
		Users users ;
		if(submit!=null){
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String fullname = request.getParameter("fullname");
			String address = request.getParameter("address");
			String phone = request.getParameter("phone");
			String email = request.getParameter("email");
			String position = request.getParameter("position");
			users = new Users(username,password,fullname,address,phone,email,position);
			if(UsersBO.addUserAdmin(users)){
				response.sendRedirect(request.getContextPath()+"/admin/list-users");
			}
			else{
				RequestDispatcher rd = request.getRequestDispatcher("/admin/add-users.jsp?msg=Có lỗi trong quá trình thêm");
				rd.forward(request, response);
			}
		}
		else{
			RequestDispatcher rd = request.getRequestDispatcher("/admin/add-users.jsp");
			rd.forward(request, response);
		}
	}

}
