package action_admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.TypeProduct;
import bean.Users;
import bo.TypeProductBO;


public class EditTypeProductsAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditTypeProductsAction() {
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
		
		//kiểm tra đăng nhập
		HttpSession session = request.getSession();
		Users usersadmin = (Users)session.getAttribute("usersadmin");
		if(usersadmin==null){
			response.sendRedirect(request.getContextPath()+"/admin/login");
			return;
		}
		
		int idCat = Integer.parseInt(request.getParameter("id"));
		String submit = request.getParameter("edit");
		TypeProductBO catBO = new TypeProductBO();
		TypeProduct cat = catBO.getCatDetail(idCat);
		if(submit!=null){
			String nameCat = request.getParameter("name");
			cat.setNameTypePro(nameCat);
			if(catBO.editCat(cat)){
				response.sendRedirect(request.getContextPath()+"/admin/list-typeproducts");
			}else{
				RequestDispatcher rd = request.getRequestDispatcher("/admin/edit-typeproducts.jsp?msg=Có lỗi");
				rd.forward(request, response);
			}
		}else{
			request.setAttribute("editcat", cat);
			RequestDispatcher rd = request.getRequestDispatcher("/admin/edit-typeproducts.jsp");
			rd.forward(request, response);
		}
		
	}

}
