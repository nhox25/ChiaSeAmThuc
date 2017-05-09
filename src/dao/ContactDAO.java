package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.Contact;

public class ContactDAO {
	private DataBase db = new DataBase();
	public ArrayList<Contact> getListContact() {
		ArrayList<Contact> listContact = new ArrayList<Contact>();
		String query = "SELECT id_contact,title, fullname, email, phone, website,content, datecreate, status FROM contact"
				+ " ORDER BY status ASC, id_contact DESC";
		
		try {
			Statement stm = db.connectDB().createStatement();
			ResultSet rs = stm.executeQuery(query);
			Contact cot;
			while(rs.next()){
				cot = new Contact(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),rs.getString(8), rs.getInt(9));
				listContact.add(cot);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listContact;
		}
	public boolean getdelContact(int idcontact) {
		String query = "DELETE from contact WHERE id_contact = ?";
		int check=0;
		try {
			PreparedStatement pstm = db.connectDB().prepareStatement(query);
			pstm.setInt(1,idcontact);
			check=pstm.executeUpdate();
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
	
	public boolean getProcessedContact(int idcontact) {
		String query = "UPDATE contact set status = 1 WHERE id_contact = ?";
		int check=0;
		try {
			PreparedStatement pstm = db.connectDB().prepareStatement(query);
			pstm.setInt(1,idcontact);
			check=pstm.executeUpdate();
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
	public boolean addContact(Contact contact) {
		String query = "INSERT INTO contact(title, fullname, email, phone, website, content, datecreate) VALUES (?,?,?,?,?,?,?)";
		int check=0;
		try {
			PreparedStatement pstm = db.connectDB().prepareStatement(query);
			pstm.setString(1, contact.getTitle());
			pstm.setString(2, contact.getFullname());
			pstm.setString(3, contact.getEmail());
			pstm.setString(4, contact.getPhone());
			pstm.setString(5, contact.getWebsite());
			pstm.setString(6, contact.getContent());
			pstm.setString(7, contact.getDatecreate());
			check=pstm.executeUpdate();
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
	public Contact getDetail(String idContact) {
		String query = "SELECT id_contact,title, fullname, email, phone, website,content, datecreate,status FROM contact WHERE id_contact = " +idContact;
		Contact contact = null;
		try {
			Statement stm = db.connectDB().createStatement();
			ResultSet rs = stm.executeQuery(query);
			while(rs.next()){
				contact = new Contact();
				contact.setIdcontact(rs.getInt(1));
				contact.setTitle(rs.getString(2));
				contact.setFullname(rs.getString(3));
				contact.setEmail(rs.getString(4));
				contact.setPhone(rs.getString(5));
				contact.setWebsite(rs.getString(6));
				contact.setContent(rs.getString(7));
				contact.setDatecreate(rs.getString(8));
				contact.setStatus(rs.getInt(9));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return contact;
	}
}
