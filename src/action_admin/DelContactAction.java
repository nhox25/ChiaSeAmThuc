package action_admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Users;
import bo.ContactBO;

/**
 * Servlet implementation class DeleteUsersAction
 */
public class DelContactAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelContactAction() {
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
		int idcontact = Integer.parseInt(request.getParameter("id_contact"));
		if(ContactBO.delContact(idcontact)){
			response.sendRedirect(request.getContextPath()+"/admin/list-contact");
		}
	else{
		RequestDispatcher rd = request.getRequestDispatcher("/admin/list-contact?msg=Có lỗi");
		rd.forward(request, response);
	}
		
	}

}
