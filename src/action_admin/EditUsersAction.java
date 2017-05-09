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
 * Servlet implementation class EditUsersAction
 */

public class EditUsersAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditUsersAction() {
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
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		//kiểm tra đăng nhập
		HttpSession session = request.getSession();
		Users usersadmin = (Users)session.getAttribute("usersadmin");
		if(usersadmin==null){
			response.sendRedirect(request.getContextPath()+"/admin/login");
			return;
		}
		
		String submit = request.getParameter("edit");
		UsersBO userBO = new UsersBO();

		if(submit!=null){
			
			Users users = new Users();
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String fullname = request.getParameter("fullname");
			String address = request.getParameter("address");
			String phone = request.getParameter("phone");
			String email = request.getParameter("email");
			String position = request.getParameter("position");
			
			users.setUsername(username);
			users.setPassword(password);
			users.setFullname(fullname);
			users.setAddress(address);
			users.setPhone(phone);
			users.setEmail(email);
			users.setPosition(position);
			
			if(userBO.editUser(users)){
				response.sendRedirect(request.getContextPath()+"/admin/list-users");
			}
			else{
				request.setAttribute("users",users);
				RequestDispatcher rd = request.getRequestDispatcher("/admin/edit-users.jsp?msg=Có lỗi");
				rd.forward(request, response);
			}
		}
		else{
			String username = request.getParameter("username");
			Users users = userBO.getUserDetail(username);
			request.setAttribute("users",users);
			RequestDispatcher rd = request.getRequestDispatcher("edit-users.jsp");
			rd.forward(request, response);
		}
		
	}

}
