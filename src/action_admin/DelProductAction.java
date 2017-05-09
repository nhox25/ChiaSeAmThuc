//package action_admin;
//
//import java.io.File;
//import java.io.IOException;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import bean.Products;
//import bean.Users;
//import bo.ProductBO;
//
//
//public class DelProductAction extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public DelProductAction() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		this.doPost(request, response);
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		request.setCharacterEncoding("UTF-8");
//		response.setCharacterEncoding("UTF-8");
//		response.setContentType("text/html");
//		
//		//kiểm tra đăng nhập
//		HttpSession session = request.getSession();
//		Users usersadmin = (Users)session.getAttribute("usersadmin");
//		if(usersadmin==null){
//			response.sendRedirect(request.getContextPath()+"/admin/login");
//			return;
//		}
//		String idPro = request.getParameter("id_product");
//		
//		ProductBO proBO = new ProductBO();
//		Products pro =  proBO.getDetail(idPro);
//		if(proBO.delPro(idPro)){
//			//lấy đường dẫn thực
//			String pathFile = request.getServletContext().getRealPath("") +File.separator
//					+"files" +File.separator+pro.getPicture1_product();
//			File file = new File(pathFile);
//			file.delete();
//			response.sendRedirect("/home/list-product-user");
//		}
//		else{
//			RequestDispatcher rd = request.getRequestDispatcher("/home/list-product-user?msg=Có lỗi trong quá trình xóa");
//			rd.forward(request, response);
//		}
//	}
//
//}
