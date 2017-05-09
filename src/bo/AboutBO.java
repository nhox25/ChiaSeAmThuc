package bo;

import java.util.ArrayList;

import bean.About;
import dao.AboutDAO;

public class AboutBO {
	 AboutDAO aboutDAO = new AboutDAO();
	public ArrayList<About> getListAbout() {
		return aboutDAO.getListAbout();
	}
	public boolean editAbout(About about) {
		// TODO Auto-generated method stub
		return aboutDAO.editAbout(about);
	}
	public About getAboutDetail() {
		// TODO Auto-generated method stub
		return aboutDAO.getAboutDetail();
	}
	public boolean addAbout(About about) {
		// TODO Auto-generated method stub
		return aboutDAO.addAbout(about);
	}
}
