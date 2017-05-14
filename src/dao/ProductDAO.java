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
		String query = "SELECT id_product,name_product, address_product,"
				+ " price_product,phone_product, email_product,"
				+ " website_product, description_product, user_product, picture1_product,"
				+ " timecreate_product, status_procduct,id_type_products, id_dictricts, "
				+ " t.name_type_products as tname_type_products, "
				+ " d.name_dictricts as dname_dictricts FROM products"
				+ " INNER JOIN type_products as t USING(id_type_products)"
				+ " INNER JOIN dictricts as d USING(id_dictricts)"
				+ " WHERE user_product = '" + user.getUsername() + "'"
				+ " ORDER BY id_product DESC";
		System.out.println("user: " + user.getUsername());

		try {
			Statement stm = db.connectDB().createStatement();
			ResultSet rs = stm.executeQuery(query);
			Products pro;
			while (rs.next()) {
				pro = new Products(rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getInt(4), rs.getInt(5),
						rs.getString(6), rs.getString(7), rs.getString(8),
						rs.getString(9), rs.getString(10), rs.getString(11),
						rs.getInt(12), rs.getInt(13), rs.getInt(14),
						rs.getString(15), rs.getString(16));
				listPro.add(pro);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listPro;
	}

	public ArrayList<Products> getAllProductsAdmin() {
		ArrayList<Products> listPro = new ArrayList<Products>();
		String query = "SELECT id_product,name_product, address_product,"
				+ " price_product,phone_product, email_product,"
				+ " website_product, description_product, user_product, picture1_product,"
				+ " timecreate_product, status_procduct,id_type_products, id_dictricts, "
				+ " t.name_type_products as tname_type_products, "
				+ " d.name_dictricts as dname_dictricts FROM products"
				+ " INNER JOIN type_products as t USING(id_type_products)"
				+ " INNER JOIN dictricts as d USING(id_dictricts)"
				+ " ORDER BY id_product DESC ";

		try {
			Statement stm = db.connectDB().createStatement();
			ResultSet rs = stm.executeQuery(query);
			Products pro;
			while (rs.next()) {
				pro = new Products(rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getInt(4), rs.getInt(5),
						rs.getString(6), rs.getString(7), rs.getString(8),
						rs.getString(9), rs.getString(10), rs.getString(11),
						rs.getInt(12), rs.getInt(13), rs.getInt(14),
						rs.getString(15), rs.getString(16));
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
		String query = "SELECT id_product,name_product, address_product,"
				+ " price_product,phone_product, email_product,"
				+ " website_product, description_product, user_product, picture1_product,"
				+ " timecreate_product, status_procduct,id_type_products, id_dictricts,"
				+ " t.name_type_products as tname_type_products, "
				+ " d.name_dictricts as dname_dictricts FROM products"
				+ " INNER JOIN type_products as t USING(id_type_products)"
				+ " INNER JOIN dictricts as d USING(id_dictricts)"
				+ " ORDER BY id_product DESC " + " LIMIT 0,10";

		try {
			Statement stm = db.connectDB().createStatement();
			ResultSet rs = stm.executeQuery(query);
			Products pro;
			while (rs.next()) {
				pro = new Products(rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getInt(4), rs.getInt(5),
						rs.getString(6), rs.getString(7), rs.getString(8),
						rs.getString(9), rs.getString(10), rs.getString(11),
						rs.getInt(12), rs.getInt(13), rs.getInt(14),
						rs.getString(15), rs.getString(16));
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
		String query = "SELECT id_product,name_product, address_product,"
				+ " price_product,phone_product, email_product,"
				+ " website_product, description_product, user_product, picture1_product,"
				+ " timecreate_product, status_procduct,id_type_products, id_dictricts, "
				+ " t.name_type_products as tname_type_products, "
				+ " d.name_dictricts as dname_dictricts FROM products"
				+ " INNER JOIN type_products as t USING(id_type_products)"
				+ " INNER JOIN dictricts as d USING(id_dictricts)"
				+ " ORDER BY id_product DESC " + " LIMIT 10,10";

		try {
			Statement stm = db.connectDB().createStatement();
			ResultSet rs = stm.executeQuery(query);
			Products pro;
			while (rs.next()) {
				pro = new Products(rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getInt(4), rs.getInt(5),
						rs.getString(6), rs.getString(7), rs.getString(8),
						rs.getString(9), rs.getString(10), rs.getString(11),
						rs.getInt(12), rs.getInt(13), rs.getInt(14),
						rs.getString(15), rs.getString(16));
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
			while (rs.next()) {
				sotin = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("so tin : " + sotin);
		return sotin;
	}

	public boolean getaddPro(Products pro) {
		String query = "INSERT INTO "
				+ " products(name_product, address_product, price_product, phone_product, email_product,"
				+ " website_product, description_product, user_product, picture1_product,"
				+ " timecreate_product, status_procduct, id_type_products, id_dictricts)"
				+ " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		int check = 0;
		try {
			PreparedStatement pstm = (PreparedStatement) db.connectDB()
					.prepareStatement(query);
			pstm.setString(1, pro.getName_product());
			pstm.setString(2, pro.getAddress_product());
			pstm.setInt(3, pro.getPrice_product());
			pstm.setInt(4, pro.getPhone_product());
			pstm.setString(5, pro.getEmail_product());
			pstm.setString(6, pro.getWebsite_product());
			pstm.setString(7, pro.getDescription_product());
			pstm.setString(8, pro.getUser_product());
			pstm.setString(9, pro.getPicture1_product());
			pstm.setString(10, pro.getTimecreate_product());
			pstm.setInt(11, pro.getStatus_product());
			pstm.setInt(12, pro.getIdCat());
			pstm.setInt(13, pro.getIdDictricts());
			check = pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (check > 0) {
			return true;
		} else {
			return false;
		}
	}

	public Products getDetail(String idPro) {
		String query = "SELECT id_product,name_product, address_product,"
				+ " price_product,phone_product, email_product,"
				+ " website_product, description_product, user_product, picture1_product,"
				+ " timecreate_product, status_procduct,id_type_products, id_dictricts, "
				+ " t.name_type_products as tname_type_products, "
				+ " d.name_dictricts as dname_dictricts FROM products"
				+ " INNER JOIN type_products as t USING(id_type_products)"
				+ " INNER JOIN dictricts as d USING(id_dictricts)"
				+ " WHERE id_product = " + idPro;
		Products pro = null;
		try {
			Statement stm = db.connectDB().createStatement();
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				pro = new Products();
				pro.setId_product(rs.getInt(1));
				pro.setName_product(rs.getString(2));
				pro.setAddress_product(rs.getString(3));
				pro.setPrice_product(rs.getInt(4));
				pro.setPhone_product(rs.getInt(5));
				pro.setEmail_product(rs.getString(6));
				pro.setWebsite_product(rs.getString(7));
				pro.setDescription_product(rs.getString(8));
				pro.setUser_product(rs.getString(9));
				pro.setPicture1_product(rs.getString(10));
				pro.setTimecreate_product(rs.getString(11));
				pro.setStatus_product(rs.getInt(12));
				pro.setIdCat(rs.getInt(13));
				pro.setIdDictricts(rs.getInt(14));
				pro.setNameCat(rs.getString(15));
				pro.setNameDictricts(rs.getString(16));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pro;
	}

	public boolean delPro(String idPro) {
		String query = "DELETE FROM products WHERE id_product =" + idPro;
		int check = 0;
		try {
			Statement stm = db.connectDB().createStatement();
			check = stm.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (check > 0) {
			return true;
		} else {
			return false;
		}
	}

	// public boolean editPro(Products pro) {
	// String query = "UPDATE product SET "
	// + "title = '"+pro.getTitle()+"', "
	// + "description = '"+pro.getDescription()+"', "
	// + "detail = '"+pro.getDetail()+"', "
	// + "picture = '"+pro.getPicture()+"', "
	// + "datecreate = '"+pro.getDatecreate()+"', "
	// + "username = '"+pro.getUsername()+"', "
	// + "cost = '"+pro.getCost()+"', "
	// + "id_cat = "+pro.getId_cat()+" "
	// + "WHERE id_pro = "+pro.getid_pro();
	// int check = 0;
	// try {
	// PreparedStatement pstm = (PreparedStatement)
	// db.connectDB().prepareStatement(query);
	// check = pstm.executeUpdate(query);
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// if(check > 0){
	// return true;
	// }else{
	// return false;
	// }
	// }
	// public ArrayList<Products> getListProByCat(int idcat) {
	// ArrayList<Products> listPro = new ArrayList<Products>();
	// String query =
	// "SELECT id_pro, id_cat, title, description, detail, picture, datecreate, username, cost, c.name FROM product"
	// + " INNER JOIN category as c USING(id_cat)"
	// + " WHERE n.id_cat = "+idcat
	// + " ORDER BY id_pro DESC LIMIT 0,4";
	//
	// try {
	// Statement stm = db.connectDB().createStatement();
	// ResultSet rs = stm.executeQuery(query);
	// Products pro;
	// while(rs.next()){
	// pro = new Products(rs.getInt(1), rs.getInt(2), rs.getString(3),
	// rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),
	// rs.getString(8), rs.getInt(9), rs.getString(10));
	// listPro.add(pro);
	//
	// }
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// return listPro;
	// }
	
	
	 public int countProByDictricts(String id_dictricts) {
		String query = "SELECT count(*) as sotin FROM products Where id_dictricts = "
				+ id_dictricts;
		int sotin = 0;
		try {
			Statement stm = db.connectDB().createStatement();
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				sotin = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sotin;
	}

	public ArrayList<Products> searchModule(String typepro[], String dictrict[]) {
		ArrayList<Products> listPro = new ArrayList<Products>();
		String query = "SELECT id_product,name_product, address_product,"
				+ " price_product,phone_product, email_product,"
				+ " website_product, description_product, user_product, picture1_product,"
				+ " timecreate_product, status_procduct,id_type_products, id_dictricts, "
				+ " t.name_type_products as tname_type_products, "
				+ " d.name_dictricts as dname_dictricts FROM products"
				+ " INNER JOIN type_products as t USING(id_type_products)"
				+ " INNER JOIN dictricts as d USING(id_dictricts) Where 1=1 ";
		if (typepro.length == 1) {
			query += " AND t.name_type_products = '" + typepro[0] + "'";
		} else {
			query += " AND t.name_type_products = '" + typepro[0] + "'";
			for (int i = 1; i < typepro.length; i++) {
				query += " OR t.name_type_products = '" + typepro[i] + "'";
			}
		}
		if (dictrict.length == 1) {
			query += " AND d.name_dictricts = '" + dictrict[0] + "'";
		} else {
			query += " AND d.name_dictricts = '" + dictrict[0] + "'";
			for (int i = 1; i < dictrict.length; i++) {
				query += " OR d.name_dictricts = '" + dictrict[i] + "'";
			}
		}
		System.out.println("sql : " + query);

		try {
			Statement stm = db.connectDB().createStatement();
			ResultSet rs = stm.executeQuery(query);
			Products pro;
			while (rs.next()) {
				pro = new Products(rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getInt(4), rs.getInt(5),
						rs.getString(6), rs.getString(7), rs.getString(8),
						rs.getString(9), rs.getString(10), rs.getString(11),
						rs.getInt(12), rs.getInt(13), rs.getInt(14),
						rs.getString(15), rs.getString(16));
				listPro.add(pro);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listPro;
	}
	public ArrayList<Products> searchModuleDictricst(String[] dictrict) {
		ArrayList<Products> listPro = new ArrayList<Products>();
		String query = "SELECT id_product,name_product, address_product,"
				+ " price_product,phone_product, email_product,"
				+ " website_product, description_product, user_product, picture1_product,"
				+ " timecreate_product, status_procduct,id_type_products, id_dictricts, "
				+ " t.name_type_products as tname_type_products, "
				+ " d.name_dictricts as dname_dictricts FROM products"
				+ " INNER JOIN type_products as t USING(id_type_products)"
				+ " INNER JOIN dictricts as d USING(id_dictricts) Where 1=1 ";
		if (dictrict.length == 1) {
			query += " AND d.name_dictricts = '" + dictrict[0] + "'";
		} else {
			query += " AND d.name_dictricts = '" + dictrict[0] + "'";
			for (int i = 1; i < dictrict.length; i++) {
				query += " OR d.name_dictricts = '" + dictrict[i] + "'";
			}
		}
		System.out.println("sql : " + query);

		try {
			Statement stm = db.connectDB().createStatement();
			ResultSet rs = stm.executeQuery(query);
			Products pro;
			while (rs.next()) {
				pro = new Products(rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getInt(4), rs.getInt(5),
						rs.getString(6), rs.getString(7), rs.getString(8),
						rs.getString(9), rs.getString(10), rs.getString(11),
						rs.getInt(12), rs.getInt(13), rs.getInt(14),
						rs.getString(15), rs.getString(16));
				listPro.add(pro);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listPro;
	}
	public ArrayList<Products> searchModuleType(String[] typepro) {
		ArrayList<Products> listPro = new ArrayList<Products>();
		String query = "SELECT id_product,name_product, address_product,"
				+ " price_product,phone_product, email_product,"
				+ " website_product, description_product, user_product, picture1_product,"
				+ " timecreate_product, status_procduct,id_type_products, id_dictricts, "
				+ " t.name_type_products as tname_type_products, "
				+ " d.name_dictricts as dname_dictricts FROM products"
				+ " INNER JOIN type_products as t USING(id_type_products)"
				+ " INNER JOIN dictricts as d USING(id_dictricts) Where 1=1 ";
		if (typepro.length == 1) {
			query += " AND t.name_type_products = '" + typepro[0] + "'";
		} else {
			query += " AND t.name_type_products = '" + typepro[0] + "'";
			for (int i = 1; i < typepro.length; i++) {
				query += " OR t.name_type_products = '" + typepro[i] + "'";
			}
		}
		System.out.println("sql : " + query);

		try {
			Statement stm = db.connectDB().createStatement();
			ResultSet rs = stm.executeQuery(query);
			Products pro;
			while (rs.next()) {
				pro = new Products(rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getInt(4), rs.getInt(5),
						rs.getString(6), rs.getString(7), rs.getString(8),
						rs.getString(9), rs.getString(10), rs.getString(11),
						rs.getInt(12), rs.getInt(13), rs.getInt(14),
						rs.getString(15), rs.getString(16));
				listPro.add(pro);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listPro;
	}
	public ArrayList<Products> getListProDictrict(String dictrict) {
		ArrayList<Products> listPro = new ArrayList<Products>();
		String query = "SELECT id_product,name_product, address_product,"
				+ " price_product,phone_product, email_product,"
				+ " website_product, description_product, user_product, picture1_product,"
				+ " timecreate_product, status_procduct,id_type_products, id_dictricts, "
				+ " t.name_type_products as tname_type_products, "
				+ " d.name_dictricts as dname_dictricts FROM products"
				+ " INNER JOIN type_products as t USING(id_type_products)"
				+ " INNER JOIN dictricts as d USING(id_dictricts) WHERE id_dictricts = '"
				+ dictrict + "'" + " ORDER BY id_product DESC ";

		try {
			Statement stm = db.connectDB().createStatement();
			ResultSet rs = stm.executeQuery(query);
			Products pro;
			while (rs.next()) {
				pro = new Products(rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getInt(4), rs.getInt(5),
						rs.getString(6), rs.getString(7), rs.getString(8),
						rs.getString(9), rs.getString(10), rs.getString(11),
						rs.getInt(12), rs.getInt(13), rs.getInt(14),
						rs.getString(15), rs.getString(16));
				listPro.add(pro);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listPro;
	}

	public ArrayList<Products> getListProType(String idproductsByType) {
		ArrayList<Products> listPro = new ArrayList<Products>();
		String query = "SELECT id_product,name_product, address_product,"
				+ " price_product,phone_product, email_product,"
				+ " website_product, description_product, user_product, picture1_product,"
				+ " timecreate_product, status_procduct,id_type_products, id_dictricts, "
				+ " t.name_type_products as tname_type_products, "
				+ " d.name_dictricts as dname_dictricts FROM products"
				+ " INNER JOIN type_products as t USING(id_type_products)"
				+ " INNER JOIN dictricts as d USING(id_dictricts) WHERE id_type_products = "
				+ idproductsByType + " ORDER BY id_product DESC ";
		System.out.println("query :" + query);
		try {
			Statement stm = db.connectDB().createStatement();
			ResultSet rs = stm.executeQuery(query);
			Products pro;
			while (rs.next()) {
				pro = new Products(rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getInt(4), rs.getInt(5),
						rs.getString(6), rs.getString(7), rs.getString(8),
						rs.getString(9), rs.getString(10), rs.getString(11),
						rs.getInt(12), rs.getInt(13), rs.getInt(14),
						rs.getString(15), rs.getString(16));
				listPro.add(pro);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listPro;
	}


}
