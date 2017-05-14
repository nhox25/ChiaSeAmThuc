package bo;

import java.util.ArrayList;

import bean.Dictricts;
import dao.DictrictsDAO;



public class DicTrictstBO {
	
	DictrictsDAO typeProDAO = new DictrictsDAO();

	public ArrayList<Dictricts> getListDictricts() {
		// TODO Auto-generated method stub
		return typeProDAO.getListDictricts();
	}

	public boolean addDictricts(String dictricts) {
		return typeProDAO.addDictricts(dictricts);
		
	}

	public boolean delDictricts(int idDictricts) {
		// TODO Auto-generated method stub
		return typeProDAO.delDictricts(idDictricts);
	}

	public Dictricts getDictrictsDetail(int idDictricts) {
		// TODO Auto-generated method stub
		return typeProDAO.getDictrictsDetail(idDictricts);
	}

	public boolean editDictricts(Dictricts dictricts) {
		return typeProDAO.editDictricts(dictricts);
	}

//	public int countAllNews() {
//		// TODO Auto-generated method stub
//		return typeProDAO.countAllNews();
//	}

	public Dictricts getNameDictricts(int dictricts) {
		return typeProDAO.getNameDictricts(dictricts);
	}

	public Dictricts getDetail(int dictricts) {
		// TODO Auto-generated method stub
		return typeProDAO.getDetail(dictricts);
	}



}
