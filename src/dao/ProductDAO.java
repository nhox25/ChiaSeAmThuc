package dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.Products;
import bean.Users;

public class ProductDAO {
	DataBase db = new DataBase();
	public ArrayList<Products> getListPro(Users user) {
		ArrayList<Products> listPro = new ArrayList<Products>();
		String query = "SELECT id_product,name_product, address_product, ditric_product, price_product, phone_product, email_product,"
				+ " website_product, description_product, type_product, user_product, picture1_product,"
				+ " timecreate_product, status_procduct FROM products WHERE user_product = '"+user.getUsername()+"'"
				+ " ORDER BY id_product DESC";
		System.out.println("user: "+user.getUsername());
		
		try {
			Statement stm = db.connectDB().createStatement();
			ResultSet rs = stm.executeQuery(query);
			Products pro;
			while(rs.next()){
				pro = new Products(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), 
						rs.getInt(5), rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9),
						rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13),
						rs.getInt(14));
				listPro.add(pro);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listPro;
	}
	public ArrayList<Products> getAllProducts() {
		ArrayList<Products> listPro = new ArrayList<Products>();
		String query = "SELECT id_product,name_product, address_product, ditric_product, price_product, phone_product, email_product,"
				+ " website_product, description_product, type_product, user_product, picture1_product,"
				+ " timecreate_product, status_procduct FROM products "
				+ " ORDER BY id_product DESC "
				+ " LIMIT 0,10 ";
		
		try {
			Statement stm = db.connectDB().createStatement();
			ResultSet rs = stm.executeQuery(query);
			Products pro;
			while(rs.next()){
				pro = new Products(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), 
						rs.getInt(5), rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9),
						rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13),
						rs.getInt(14));
				listPro.add(pro);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listPro;
	}
	public ArrayList<Products> getAllProducts2() {
		ArrayList<Products> listPro = new ArrayList<Products>();
		String query = "SELECT id_product,name_product, address_product, ditric_product, price_product, phone_product, email_product,"
				+ " website_product, description_product, type_product, user_product, picture1_product,"
				+ " timecreate_product, status_procduct FROM products "
				+ " ORDER BY id_product DESC "
				+ " LIMIT 10,10" ;
		
		try {
			Statement stm = db.connectDB().createStatement();
			ResultSet rs = stm.executeQuery(query);
			Products pro;
			while(rs.next()){
				pro = new Products(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), 
						rs.getInt(5), rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9),
						rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13),
						rs.getInt(14));
				listPro.add(pro);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listPro;
	}
	
	public int countAllPro() {
		String query = "SELECT count(*) as sotin FROM products";
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
		System.out.println("so tin : "+sotin);
		return sotin;
	}
	public ArrayList<Products> getlistProPerPage(int offset, int number) {
		Products pro;
		ArrayList<Products> listPro = new ArrayList<Products>();
		String query = "SELECT id_product,name_product, address_product, ditric_product, price_product, phone_product, email_product,"
				+ " website_product, description_product, type_product, user_product, picture1_product,"
				+ " timecreate_product, status_procduct FROM products"
				+ " ORDER BY id_product DESC "
				+ " LIMIT "+offset+","+number +"" ;
		
		try {
			Statement stm = db.connectDB().createStatement();
			ResultSet rs = stm.executeQuery(query);
			while(rs.next()){
				pro = new Products(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), 
						rs.getInt(5), rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9),
						rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13),
						rs.getInt(14));
				listPro.add(pro);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listPro;
	}
	public boolean getaddPro(Products pro) {
		String query = "INSERT INTO "
				+ "products(name_product, address_product, ditric_product, price_product, phone_product, email_product,"
				+ "website_product, description_product, type_product, user_product, picture1_product,"
				+ "timecreate_product, status_procduct)"
				+ " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		int check = 0;
		try {
			PreparedStatement pstm = (PreparedStatement) db.connectDB().prepareStatement(query);
			pstm.setString(1, pro.getName_product());
			pstm.setString(2, pro.getAddress_product());
			pstm.setString(3, pro.getDictric_product());
			pstm.setInt(4, pro.getPrice_product());
			pstm.setInt(5, pro.getPhone_product());
			pstm.setString(6, pro.getEmail_product());
			pstm.setString(7, pro.getWebsite_product());
			pstm.setString(8, pro.getDescription_product());
			pstm.setString(9, pro.getTyple_product());
			pstm.setString(10, pro.getUser_product());
			pstm.setString(11, pro.getPicture1_product());
//			pstm.setString(12, pro.getPicture2_product());
			pstm.setString(12, pro.getTimecreate_product());
			pstm.setInt(13, pro.getStatus_product());
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
	public Products getDetail(String idPro) {
		String query = "SELECT id_product,name_product, address_product, ditric_product, price_product, phone_product, email_product,"
				+ " website_product, description_product, type_product, user_product, picture1_product,"
				+ " timecreate_product, status_procduct FROM products WHERE id_product = " +idPro;
		Products pro = null;
		try {
			Statement stm = db.connectDB().createStatement();
			ResultSet rs = stm.executeQuery(query);
			while(rs.next()){
				pro = new Products();
				pro.setId_product(rs.getInt(1));
				pro.setName_product(rs.getString(2));
				pro.setAddress_product(rs.getString(3));
				pro.setDictric_product(rs.getString(4));
				pro.setPrice_product(rs.getInt(5));
				pro.setPhone_product(rs.getInt(6));
				pro.setEmail_product(rs.getString(7));
				pro.setWebsite_product(rs.getString(8));
				pro.setDescription_product(rs.getString(9));
				pro.setTyple_product(rs.getString(10));
				pro.setUser_product(rs.getString(11));
				pro.setPicture1_product(rs.getString(12));
				pro.setTimecreate_product(rs.getString(13));
				pro.setStatus_product(rs.getInt(14));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pro;
	}
	public boolean delPro(String idPro) {
		String query = "DELETE FROM products WHERE id_product ="+idPro;
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
//	public boolean editPro(Products pro) {
//		String query = "UPDATE product SET "
//				+ "title = '"+pro.getTitle()+"', "
//				+ "description = '"+pro.getDescription()+"', "
//				+ "detail = '"+pro.getDetail()+"', "
//				+ "picture = '"+pro.getPicture()+"', "
//				+ "datecreate = '"+pro.getDatecreate()+"', "
//				+ "username = '"+pro.getUsername()+"', "
//				+ "cost = '"+pro.getCost()+"', "
//				+ "id_cat = "+pro.getId_cat()+" " 
//				+ "WHERE id_pro = "+pro.getid_pro();
//			int check = 0;
//			try {
//				PreparedStatement pstm = (PreparedStatement) db.connectDB().prepareStatement(query);
//				check = pstm.executeUpdate(query);
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			if(check > 0){
//				return true;
//			}else{
//				return false;
//				}
//	}
//	public ArrayList<Products> getListProByCat(int idcat) {
//		ArrayList<Products> listPro = new ArrayList<Products>();
//		String query = "SELECT id_pro, id_cat, title, description, detail, picture, datecreate, username, cost, c.name FROM product"
//				+ " INNER JOIN category as c USING(id_cat)"
//				+ " WHERE n.id_cat = "+idcat
//				+ " ORDER BY id_pro DESC LIMIT 0,4";
//		
//		try {
//			Statement stm = db.connectDB().createStatement();
//			ResultSet rs = stm.executeQuery(query);
//			Products pro;
//			while(rs.next()){
//				pro = new Products(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getString(10));
//				listPro.add(pro);
//				
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return listPro;
//	}
//	public ArrayList<Products> getListProByCatPerPage(String idCat, int offset, int numberProPerPage) {
//		ArrayList<Products> listPro = new ArrayList<Products>();
//		Products pro;
//		String query = "SELECT id_pro,id_cat ,title, description,detail ,picture,datecreate,username , cost  ,c.name as cname FROM product as n " +
//		"INNER JOIN category as c USING (id_cat)" 
//				+" WHERE n.id_cat=" +idCat
//				+ " ORDER BY id_pro DESC " + " LIMIT "+ offset +"," + numberProPerPage ;
//		try {
//			Statement stm = db.connectDB().createStatement();
//			ResultSet rs = stm.executeQuery(query);
//			while(rs.next()){
//				pro = new Products(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getString(10));
//				listPro.add(pro);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return listPro;
//	}
//	public ArrayList<Products> getListProByCat(Products pro) {
//		ArrayList<Products> listProByCat = new ArrayList<Products>();
//		String query = "SELECT id_pro, id_cat, title, description, detail, picture, datecreate, username, cost, name FROM product INNER JOIN category USING(id_cat)"
//				+ " WHERE id_cat = "+pro.getId_cat()
//				+ " AND id_pro != "+pro.getid_pro()
//				+ " ORDER BY id_pro DESC LIMIT 5";
//		try {
//			Statement stm = db.connectDB().createStatement();
//			ResultSet rs = stm.executeQuery(query);
//			Products listProB;
//			while(rs.next()){
//				listProB = new Products(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getString(10));
//				listProByCat.add(listProB);
//				
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return listProByCat;
//	}
//	public int countAllPro(String idCat) {
//		String query = "SELECT count(*) as sotin FROM product Where id_cat = "+idCat;
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
}
