package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;




import bean.Ads;

public class AdsDAO {
	DataBase db = new DataBase();
	public ArrayList<Ads> getListAds() {
		ArrayList<Ads> listAds = new ArrayList<Ads>();
		String query = "SELECT id_ads, name, link, picture FROM ads ORDER BY id_ads DESC LiMIT 0,3";
		
		try {
			Statement stm = db.connectDB().createStatement();
			ResultSet rs = stm.executeQuery(query);
			Ads  ads;
			while(rs.next()){
				ads = new Ads(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				listAds.add(ads);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listAds;
	}
	public boolean addAds(Ads ads) {
		String query = "INSERT INTO ads(name, link, picture) VALUES(?,?,?)";
		int check = 0;
		try {
			PreparedStatement pstm = db.connectDB().prepareStatement(query);
			pstm.setString(1, ads.getName());
			pstm.setString(2, ads.getLink());
			pstm.setString(3, ads.getPicture());
			check = pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(check > 0){
			return true;
		}else{
			return false;
		}
	}
	public Ads getDetail(String idAds) {
		String query = "SELECT id_ads, name, link, picture FROM ads WHERE id_ads = " +idAds;
		Ads ads = null;
		try {
			Statement stm = db.connectDB().createStatement();
			ResultSet rs = stm.executeQuery(query);
			while(rs.next()){
				ads = new Ads();
				ads.setId_ads(rs.getInt(1));
				ads.setName(rs.getString(2));
				ads.setLink(rs.getString(3));
				ads.setPicture(rs.getString(4));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ads;
	}
	public boolean editAds(Ads ads) {
		int check=0;
		String query = "update ads set name = ? , link = ?, picture=? where id_ads = '"+ads.getId_ads()+"'";
		PreparedStatement pstm;
		try {
			pstm = db.connectDB().prepareStatement(query);
			pstm.setString(1, ads.getName());
			pstm.setString(2, ads.getLink());
			pstm.setString(3, ads.getPicture());
			check = pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(check>0){
			return true;
		}
		else{
			return false;
		}
	}
	public ArrayList<Ads> getListNewsPerPage(int offset, int number) {
		ArrayList<Ads> listAds = new ArrayList<Ads>();
		String query = "SELECT id_ads, name, link, picture FROM ads "
				+ " ORDER BY id_ads DESC "
				+ "LIMIT "+offset+","+number +"" ;
		
		try {
			Statement stm = db.connectDB().createStatement();
			ResultSet rs = stm.executeQuery(query);
			Ads ads;
			while(rs.next()){
				ads = new Ads(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				listAds.add(ads);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listAds;
	}
	public int countAllAds() {
		String query = "SELECT count(*) as sotin FROM ads";
		int sotin = 0;
		try {
			Statement stm = db.connectDB().createStatement();
			ResultSet rs = stm.executeQuery(query);
			while(rs.next()){
				sotin = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sotin;
	}
	public boolean delAds(String idAds) {
		String query = "DELETE FROM ads WHERE id_ads ="+idAds;
		int check = 0;
		try {
			Statement stm = db.connectDB().createStatement();
			check = stm.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(check > 0){
			return true;
		}else{
			return false;
		}
	}
}
