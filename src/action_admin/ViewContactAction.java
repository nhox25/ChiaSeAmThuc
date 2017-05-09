package action_admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Contact;
import bean.Users;
import bo.ContactBO;

/**
 * Servlet implementation class ListCatAdminAction
 */
public class ViewContactAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewContactAction() {
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
		
		HttpSession session = request.getSession();
		Users usersadmin = (Users)session.getAttribute("usersadmin");
		if(usersadmin==null){
			response.sendRedirect(request.getContextPath()+"/admin/login");
			return;
		}
		
		ContactBO contactBO = new ContactBO();
		
		String idContact = request.getParameter("idContact");
		Contact contact = contactBO.getDetail(idContact);
		request.setAttribute("contact", contact);
		
		
		
		ArrayList<Contact> listContact = contactBO.getListContact();
		request.setAttribute("listContact", listContact);
		RequestDispatcher rd = request.getRequestDispatcher("/admin/view-contact.jsp");
		rd.forward(request, response);
		
		
	}

}
