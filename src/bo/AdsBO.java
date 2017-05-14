package bo;

import java.util.ArrayList;

import dao.AdsDAO;
import bean.Ads;

public class AdsBO {
	
	AdsDAO adsDAO = new AdsDAO();

	public ArrayList<Ads> getListAds() {
		return adsDAO.getListAds();
	}

	public boolean addAds(Ads ads) {
		return adsDAO.addAds(ads);
	}

	public Ads getDetail(String idAds) {
		
		return adsDAO.getDetail(idAds);
	}

	public boolean editAds(Ads ads) {
		return adsDAO.editAds(ads);
		
	}

	public ArrayList<Ads> getlistNewsPerPage(int offset, int number) {
		return adsDAO.getListNewsPerPage(offset,number);
	}

	public int countAllAds() {
		// TODO Auto-generated method stub
		return adsDAO.countAllAds();
	}

	public boolean delAds(String idAds) {
		// TODO Auto-generated method stub
		return adsDAO.delAds(idAds);
	}



}
