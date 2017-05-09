package bo;

import java.util.ArrayList;

import dao.ProductDAO;
import bean.Products;
import bean.Users;

public class ProductBO {
	
	ProductDAO ProductDAO = new ProductDAO();

	public ArrayList<Products> getlistPro(Users user) {
		return ProductDAO.getListPro(user);
	}
	public ArrayList<Products> getAllProducts() {
		return ProductDAO.getAllProducts();
	}
	public ArrayList<Products> getAllProducts2() {
		return ProductDAO.getAllProducts2();
	}
	public boolean addPro(Products pro) {
		return ProductDAO.getaddPro(pro);
	}

	public Products getDetail(String idPro) {
		
		return ProductDAO.getDetail(idPro);
	}
//
//	public boolean editPro(Products pro) {
//		return ProductDAO.editPro(pro);
//		
//	}
//
//	public ArrayList<Products> getListProByCat(int idcat) {
//
//		return ProductDAO.getListProByCat(idcat);
//	}
//
	public ArrayList<Products> getlistProPerPage(int offset, int number) {
		return ProductDAO.getlistProPerPage(offset,number);
					
	}

	public int countAllPro() {
		// TODO Auto-generated method stub
		return ProductDAO.countAllPro();
	}

	public boolean delPro(String idPro) {
		// TODO Auto-generated method stub
		return ProductDAO.delPro(idPro);
	}
//
//	public ArrayList<Products> getListProByCatPerPage(String idCat, int offset,
//			int numberProPerPage) {
//		return ProductDAO.getListProByCatPerPage(idCat ,offset, numberProPerPage);
//	}
//
//	public ArrayList<Products> getListProByCat(Products pro) {
//		// TODO Auto-generated method stub
//		return ProductDAO.getListProByCat(pro);
//	}
//
//	public int countAllPro(String idCat) {
//		// TODO Auto-generated method stub
//		return ProductDAO.countAllPro(idCat);
//	}

}
