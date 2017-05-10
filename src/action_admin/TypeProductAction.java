
package action_admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.TypeProduct;
import bean.Users;
import bo.TypeProductBO;

/**
 * Servlet implementation class CatAction
 */
	public class TypeProductAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final int NUMBER_NEWS_PER_PAGE = 5;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TypeProductAction() {
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

		
		TypeProductBO typeBO = new TypeProductBO();
		ArrayList<TypeProduct> listType = typeBO.getListCat();
		request.setAttribute("listType", listType);

 		
//		HttpSession session = request.getSession();
//		String idCat = request.getParameter("id");
//		session.setAttribute("idCat", idCat);
//		
		
//		String trang = request.getParameter("trang");
//		int  offset , totalP;
//		int p=0;
//		if(trang!=null){
//			p= Integer.parseInt(trang);
//			 offset= (p-1)*NUMBER_NEWS_PER_PAGE;
//		}else{
//			offset=0;
//			p=1;
//		}
//		int sotin = proBO.countAllPro(idCat);
//		totalP = (int)Math.ceil((float)sotin/NUMBER_NEWS_PER_PAGE);
//		request.setAttribute("totalP", totalP);
//		request.setAttribute("p", p);
//		
//		ArrayList<Products> listPro1 = proBO.getListProByCatPerPage(idCat , offset , NUMBER_NEWS_PER_PAGE );
//		request.setAttribute("listPro", listPro1);
		
//		int id = Integer.parseInt(request.getParameter("id"));
//		TypeProduct nameCat = typeBO.getNameCat(id);
//		request.setAttribute("nameCat", nameCat);
		RequestDispatcher rd = request.getRequestDispatcher("/admin/index-type-products.jsp");
		rd.forward(request,response);
		
		
	}
}