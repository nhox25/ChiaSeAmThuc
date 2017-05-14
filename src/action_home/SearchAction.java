package action_home;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Products;
import bo.ProductBO;

/**
 * Servlet implementation class HomeAdminAction
 */
public class SearchAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchAction() {
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
		
		ProductBO proBO = new ProductBO();
		
		ArrayList<Products> listProHome = proBO.getAllProducts();
		request.setAttribute("listProHome", listProHome);
		
		ArrayList<Products> listProHome2 = proBO.getAllProducts2();
		request.setAttribute("listProHome2", listProHome2);
		
		ArrayList<Products> listProDeXuat = proBO.getAllProducts();
		request.setAttribute("listProDeXuat", listProDeXuat);
		
		ArrayList<Products> listProDeXuat2 = proBO.getAllProducts2();
		request.setAttribute("listProDeXuat2", listProDeXuat2);
	

		
		RequestDispatcher rd = request.getRequestDispatcher("/products.jsp");
		rd.forward(request, response);
	}
}
