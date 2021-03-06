package action_home;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import bean.Dictricts;
import bean.Products;
import bean.TypeProduct;
import bean.Users;
import bo.DicTrictstBO;
import bo.ProductBO;
import bo.TypeProductBO;

/**
 */

public class CreateProductAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateProductAction() {
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
		
		TypeProductBO catBO = new TypeProductBO();
		DicTrictstBO dictrictsBO= new DicTrictstBO();
		
		
		ArrayList<TypeProduct> listCat = catBO.getListCat();
		request.setAttribute("listCat", listCat);
		
		ArrayList<Dictricts> listDictricts = dictrictsBO.getListDictricts();
		request.setAttribute("listDictricts", listDictricts);
		
		String type = request.getParameter("type");
		if(!"load".equals(type)){	
			String name_product="", address_product="", email="", website="",description="";
			String picture1=""; int idCat=0; int dicrit_product= 0;
			int price=0; int phone = 0; int status = 0;	
			DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
			try {
				List<FileItem> formitems = upload.parseRequest(request);
				for (FileItem item : formitems) {
					if (item.isFormField()) { // phan tu khong phai la file
						
						String name = item.getFieldName();
						String value = new String(item.getString().getBytes("ISO-8859-1"),"UTF-8");
						switch (name) {	
						case "name_product": name_product = value; break;
						case "address_product": address_product = value; break;
						case "dicrit_product": dicrit_product = Integer.parseInt(value); break;
						case "email": email = value; break;
						case "website": website = value; break;
						case "description": description = value; break;
						case "style": idCat = Integer.parseInt(value); break;
						case "price": price = Integer.parseInt(value); break;
						case "phone": phone = Integer.parseInt(value); break;
							}	
					} else { // la file
						// lay ten file
						String filename = item.getName();
						// tao duong dan thu muc de upload file
						String dirUpload = request.getServletContext()
								.getRealPath("")+ File.separator + "files";
						File dir = new File(dirUpload);
						if (!dir.exists()) {
							dir.mkdir();
							System.out.println("duong dan" +dirUpload);
						}
						picture1 = "Product-"+System.nanoTime()+"."+FilenameUtils.getExtension(filename);
//						picture2 = "Product-"+System.nanoTime()+"."+FilenameUtils.getExtension(filename);
						// duong dan file upload
						String pathUploadFile1 = dirUpload + File.separator + picture1;
//						String pathUploadFile2 = dirUpload + File.separator + picture2;
						// UPLOAD FILE LEN SERVER
						File file1 = new File(pathUploadFile1);
//						File file2 = new File(pathUploadFile2);
						item.write(file1);
//						item.write(file2);
						
//						System.out.println("link "+pathUploadFile1);
//						System.out.println("link2"+pathUploadFile2);
					}
				}
			} catch (FileUploadException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
			String time = sdf.format(new Date());
			String username = users.getUsername();
			
			Products pro = new Products();
			pro.setName_product(name_product);
			pro.setAddress_product(address_product);
			pro.setIdDictricts((dicrit_product));
			pro.setEmail_product(email);
			pro.setWebsite_product(website);
			pro.setDescription_product(description);
			pro.setPicture1_product(picture1);
			pro.setTimecreate_product(time);
			pro.setUser_product(username);
			pro.setPrice_product(price);
			pro.setPhone_product(phone);
			pro.setStatus_product(status);
			pro.setIdCat(idCat);
			
			if(proBO.addPro(pro)){
				response.sendRedirect("list-product-user");	
			}else{
				RequestDispatcher rd = request.getRequestDispatcher("/create-product.jsp?msg=Có lỗi xảy ra");
				rd.forward(request, response);
			}			
		}else{
			RequestDispatcher rd = request.getRequestDispatcher("/create-product.jsp");
			rd.forward(request, response);
		}
		
	}

}
