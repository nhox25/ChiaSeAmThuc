package action_home;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Contact;
import bo.ContactBO;

/**
 * Servlet implementation class AddCatAction
 */
public class SendContactAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendContactAction() {
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
		
		
		String submit = request.getParameter("add");
		ContactBO contactBO = new ContactBO();
		Contact contact = new Contact();
		if(submit!=null){
			
			String title = new String(request.getParameter("Title"));
			String fullname = new String(request.getParameter("Name"));
			String email = new String(request.getParameter("Email"));
			String phone = new String(request.getParameter("Phone Number"));
			String website = new String(request.getParameter("Website"));
			String message = new String(request.getParameter("Message"));
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
			String time = sdf.format(new Date());
			
			contact.setTitle(title);
			contact.setFullname(fullname);
			contact.setEmail(email);
			contact.setPhone(phone);
			contact.setWebsite(website);
			contact.setContent(message);
			contact.setDatecreate(time);
			
			
			if(contactBO.addContact(contact)){
				response.sendRedirect(request.getContextPath()+	"/home/contact?msg1=Success! Thank you for contacting us, we will respond to you as soon as possible!");
			}else{
				RequestDispatcher rd = request.getRequestDispatcher("/home/contact.jsp?msg=Sorry, there were some problems, please contact us again!");
				rd.forward(request, response);
			}
		}else{
			RequestDispatcher rd = request.getRequestDispatcher("/contact.jsp");
			rd.forward(request, response);
		}
		
		
	}

}
