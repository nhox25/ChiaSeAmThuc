package action_admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Category;
import bean.Users;
import bo.CatBO;

/**
 * Servlet implementation class EditCatAction
 */
public class EditCatAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCatAction() {
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
		Users users = (Users)session.getAttribute("users");
		if(users==null){
			response.sendRedirect(request.getContextPath()+"/admin/login");
			return;
		}
		
		int idCat = Integer.parseInt(request.getParameter("idcat"));
		String submit = request.getParameter("edit");
		CatBO catBO = new CatBO();
		Category cat = catBO.getCatDetail(idCat);
		if(submit!=null){
			String nameCat = request.getParameter("namecat");
			cat.setNameCat(nameCat);
			if(catBO.editCat(cat)){
				response.sendRedirect("list-cat");
			}else{
				RequestDispatcher rd = request.getRequestDispatcher("/admin/editCat.jsp?msg=Có lỗi");
				rd.forward(request, response);
			}
		}else{
			request.setAttribute("cat", cat);
			RequestDispatcher rd = request.getRequestDispatcher("editCat.jsp");
			rd.forward(request, response);
		}
		
	}

}
