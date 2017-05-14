package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.Dictricts;

import com.mysql.jdbc.PreparedStatement;


public class DictrictsDAO {
	private DataBase db = new DataBase();
	public ArrayList<Dictricts> getListDictricts() {
		ArrayList<Dictricts> listCat = new ArrayList<Dictricts>();
		String query = "SELECT id_dictricts, name_dictricts FROM dictricts ORDER BY id_dictricts DESC";
		try {
			Statement stm = db.connectDB().createStatement();
			ResultSet rs = stm.executeQuery(query);
			Dictricts cat;
			while(rs.next()){
				cat = new Dictricts(rs.getInt("id_dictricts"), rs.getString("name_dictricts"));
				listCat.add(cat);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listCat;
	}

	public boolean addDictricts(String name_dictricts) {
		String query = "INSERT INTO dictricts(name_dictricts) VALUES(?)";
		int check = 0;
		try {
			PreparedStatement pstm = (PreparedStatement) db.connectDB().prepareStatement(query);
			pstm.setString(1, name_dictricts);
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

	public boolean delDictricts(int id_dictricts) {
		String query = "DELETE FROM dictricts WHERE id_dictricts = ? ";
		int check = 0;
		try {
			PreparedStatement pstm = (PreparedStatement) db.connectDB().prepareStatement(query);
			pstm.setInt(1, id_dictricts);
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

	public Dictricts getDictrictsDetail(int id_dictricts) {
		String query = "SELECT id_dictricts, name_dictricts FROM dictricts WHERE id_dictricts = " +id_dictricts;
		Dictricts cat = null;
		try {
			Statement stm = db.connectDB().createStatement();
			ResultSet rs = stm.executeQuery(query);
			while(rs.next()){
				cat = new Dictricts(rs.getInt("id_dictricts"), rs.getString("name_dictricts"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cat;
	}

	public boolean editDictricts(Dictricts dictricts) {
		String query = "UPDATE dictricts SET name_dictricts = '"+dictricts.getNam_dictricts()+"' WHERE id_dictricts = "+dictricts.getId_dictricts();
		int check = 0;
		try {
			Statement stm = db.connectDB().createStatement();
			check  = stm.executeUpdate(query);
			
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

//	public int countAllNews() {
//		String query = "SELECT count(*) as sotin FROM news";
//		int sotin = 0;
//		try {
//			Statement stm = db.connectDB().createStatement();
//			ResultSet rs = stm.executeQuery(query);
//			while(rs.next()){
//				sotin = rs.getInt(1);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return sotin;
//	}

	public Dictricts getNameDictricts(int id_dictricts) {
		String query = "SELECT id_dictricts, name_dictricts FROM dictricts WHERE id_dictricts = " +id_dictricts;
		Dictricts cat = null;
		try {
			Statement stm = db.connectDB().createStatement();
			ResultSet rs = stm.executeQuery(query);
			while(rs.next()){
				cat = new Dictricts(rs.getInt("id_dictricts"), rs.getString("name_dictricts"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cat;
	}

	public Dictricts getDetail(int id_dictricts) {
		String query = "SELECT id_dictricts, name_dictricts FROM dictricts WHERE id_dictricts = " +id_dictricts;
		Dictricts cat = null;
		try {
			Statement stm = db.connectDB().createStatement();
			ResultSet rs = stm.executeQuery(query);
			while(rs.next()){
				cat = new Dictricts();
				cat.setId_dictricts(rs.getInt(1));
				cat.setNam_dictricts(rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cat;
	}

	public boolean searchModule(String district) {
		// TODO Auto-generated method stub
		
		return false;
	}

}
