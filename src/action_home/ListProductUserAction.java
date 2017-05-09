package action_home;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Products;
import bean.Users;
import bo.ProductBO;

/**
 * Servlet implementation class ListProAdminAction
 */
public class ListProductUserAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final int NUMBER_NEWS_PER_PAGE = 5;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListProductUserAction() {
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
			response.sendRedirect(request.getContextPath()+"/home/login");
			return;
		}
		
		ProductBO proBO = new ProductBO();
//		String trang = request.getParameter("trang");
//		int p = 0, offset, totalP;
//		if(trang!=null){
//			p = Integer.parseInt(trang);
//			offset = (p-1)*NUMBER_NEWS_PER_PAGE;
//		}else{
//			offset = 0;
//			p = 1;
//		}
//		int sotin = proBO.countAllPro();
//		totalP =(int)Math.ceil((float)sotin/NUMBER_NEWS_PER_PAGE);
//		request.setAttribute("totalP", totalP);
//		request.setAttribute("p", p);
		
//		ArrayList<Products> listPro = proBO.getlistProPerPage(offset,NUMBER_NEWS_PER_PAGE );
//		request.setAttribute("listPro", listPro);
		
		ArrayList<Products> listPro = proBO.getlistPro(users);
		request.setAttribute("listPro", listPro);
		RequestDispatcher rd = request.getRequestDispatcher("/list-product-user.jsp");
		rd.forward(request, response);
		
	}

}
