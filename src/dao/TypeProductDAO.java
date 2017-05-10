package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import bean.TypeProduct;

public class TypeProductDAO {
	private DataBase db = new DataBase();
	public ArrayList<TypeProduct> getListCat() {
		ArrayList<TypeProduct> listCat = new ArrayList<TypeProduct>();
		String query = "SELECT id_type_products, name_type_products FROM type_products ORDER BY id_type_products DESC";
		
		try {
			Statement stm = db.connectDB().createStatement();
			ResultSet rs = stm.executeQuery(query);
			TypeProduct cat;
			while(rs.next()){
				cat = new TypeProduct(rs.getInt("id_type_products"), rs.getString("name_type_products"));
				listCat.add(cat);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listCat;
	}

	public boolean addCat(String name_type_products) {
		String query = "INSERT INTO type_products(name_type_products) VALUES(?)";
		int check = 0;
		try {
			PreparedStatement pstm = (PreparedStatement) db.connectDB().prepareStatement(query);
			pstm.setString(1, name_type_products);
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

	public boolean delCat(int id_type_products) {
		String query = "DELETE FROM type_products WHERE id_type_products = ? ";
		int check = 0;
		try {
			PreparedStatement pstm = (PreparedStatement) db.connectDB().prepareStatement(query);
			pstm.setInt(1, id_type_products);
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

	public TypeProduct getCatDetail(int id_type_products) {
		String query = "SELECT id_type_products, name_type_products FROM type_products WHERE id_type_products = " +id_type_products;
		TypeProduct cat = null;
		try {
			Statement stm = db.connectDB().createStatement();
			ResultSet rs = stm.executeQuery(query);
			while(rs.next()){
				cat = new TypeProduct(rs.getInt("id_type_products"), rs.getString("name_type_products"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cat;
	}

	public boolean editCat(TypeProduct type) {
		String query = "UPDATE type_products SET name = '"+type.getNameTypePro()+"' WHERE id_type_products = "+type.getIdTypePro();
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

	public TypeProduct getNameType(int id_type_products) {
		String query = "SELECT id_type_products, name_type_products FROM type_products WHERE id_type_products = " +id_type_products;
		TypeProduct cat = null;
		try {
			Statement stm = db.connectDB().createStatement();
			ResultSet rs = stm.executeQuery(query);
			while(rs.next()){
				cat = new TypeProduct(rs.getInt("id_type_products"), rs.getString("name_type_products"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cat;
	}

	public TypeProduct getDetail(int id_type_products) {
		String query = "SELECT id_type_products, name_type_products FROM type_products WHERE id_type_products = " +id_type_products;
		TypeProduct cat = null;
		try {
			Statement stm = db.connectDB().createStatement();
			ResultSet rs = stm.executeQuery(query);
			while(rs.next()){
				cat = new TypeProduct();
				cat.setIdTypePro(rs.getInt(1));
				cat.setNameTypePro(rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cat;
	}

}
