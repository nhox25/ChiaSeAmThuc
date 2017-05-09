package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.About;

public class AboutDAO {
	static DataBase db = new DataBase();
	public ArrayList<About> getListAbout() {
		ArrayList<About> listAbout = new ArrayList<About>();
		String query = "SELECT idabout, title, detail FROM about";
		try {
			Statement stm = db.connectDB().createStatement();
			ResultSet rs = stm.executeQuery(query);
			About about;
			while(rs.next()){
				about = new About(rs.getInt(1), rs.getString(2), rs.getString(3));
				listAbout.add(about);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listAbout;
	}
	public boolean editAbout(About about) {
		String query = "UPDATE about SET title = ?, detail = ? WHERE idabout = 1";
		int check=0;
		try {
			PreparedStatement pstm = db.connectDB().prepareStatement(query);
			pstm.setString(1, about.getTitle());
			pstm.setString(2, about.getDetail());
			check = pstm.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (check>0){
			return true;
		}
		else
		{
			return false;
		}
	}
	public About getAboutDetail() {
		About about = null;
		String query = "Select idabout, title, detail from about where idabout = 1";
		try {
			Statement stm = db.connectDB().createStatement();
			ResultSet rs = stm.executeQuery(query);
			
			while(rs.next()){
				about = new About(rs.getInt(1), rs.getString(2), rs.getString(3));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return about;
	}
	public boolean addAbout(About about) {
		// TODO Auto-generated method stub
		return false;
	}
}
