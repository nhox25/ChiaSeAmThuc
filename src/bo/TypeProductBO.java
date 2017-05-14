package bo;

import java.util.ArrayList;

import bean.TypeProduct;
import dao.TypeProductDAO;


public class TypeProductBO {
	
	TypeProductDAO typeProDAO = new TypeProductDAO();

	public ArrayList<TypeProduct> getListCat() {
		// TODO Auto-generated method stub
		return typeProDAO.getListCat();
	}

	public boolean addCat(String nameCat) {
		return typeProDAO.addCat(nameCat);
		
	}

	public boolean delCat(int idCat) {
		// TODO Auto-generated method stub
		return typeProDAO.delCat(idCat);
	}

	public TypeProduct getCatDetail(int idCat) {
		// TODO Auto-generated method stub
		return typeProDAO.getCatDetail(idCat);
	}

	public boolean editCat(TypeProduct cat) {
		return typeProDAO.editCat(cat);
	}

//	public int countAllNews() {
//		// TODO Auto-generated method stub
//		return typeProDAO.countAllNews();
//	}

	public TypeProduct getNameCat(int idcat) {
		return typeProDAO.getNameType(idcat);
	}

	public TypeProduct getDetail(int idCat) {
		// TODO Auto-generated method stub
		return typeProDAO.getDetail(idCat);
	}



}
