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


	public class ProductsByTypeAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductsByTypeAction() {
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
			
		ProductBO proBO = new ProductBO();

		String idPro = request.getParameter("id");
		ArrayList<Products> listProType = proBO.getListProType(idPro);
		request.setAttribute("listProType", listProType);
		
		ArrayList<Products> listProDeXuat = proBO.getAllProducts();
		request.setAttribute("listProDeXuat", listProDeXuat);
		
		RequestDispatcher rd = request.getRequestDispatcher("/productsByType.jsp");
		rd.forward(request,response);
	}

}
