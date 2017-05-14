package action_home;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Ads;
import bean.Products;
import bo.AdsBO;
import bo.ProductBO;

/**
 * Servlet implementation class AddCatAction
 */
public class SearchModuleAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchModuleAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		ProductBO proBO = new ProductBO();
		
		AdsBO adsBO = new AdsBO();
		ArrayList<Ads> listAds = adsBO.getListAds();
		request.setAttribute("listAds", listAds);

		String submit = request.getParameter("search-home");
		if (submit != null) {
			String[] typepro = request.getParameterValues("typepro");
			String[] dictrict = request.getParameterValues("district");

			if ((typepro == null) && (dictrict == null)) {
				System.out.println("vào null-------------------------");
				ArrayList<Products> listProSearch = proBO.getAllProducts();
				request.setAttribute("listProSearch", listProSearch);
			} else if ((typepro == null) && (dictrict != null)) {
					System.out.println("vào 1-------------------");
					ArrayList<Products> listProSearch = proBO.searchModuleDictricst(dictrict);
					request.setAttribute("listProSearch", listProSearch);
			} else if ((typepro != null) && (dictrict == null)) {
					System.out.println("Vào 2-------------------------");
					ArrayList<Products> ListProSearch = proBO.searchModuleType(typepro);
					request.setAttribute("listProSearch", ListProSearch);
			} else {
				System.out.println("Vào all-------------------------");
				ArrayList<Products> listProSearch = proBO.searchModule(typepro,dictrict);
				request.setAttribute("listProSearch", listProSearch);
			}
			ArrayList<Products> listProDeXuat = proBO.getAllProducts();
			request.setAttribute("listProDeXuat", listProDeXuat);

			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
			rd.forward(request, response);
		} else {
			ArrayList<Products> listProSearch = proBO.getAllProducts();
			request.setAttribute("listProSearch", listProSearch);

			ArrayList<Products> listProDeXuat = proBO.getAllProducts();
			request.setAttribute("listProDeXuat", listProDeXuat);
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
			rd.forward(request, response);
		}
	}

}
