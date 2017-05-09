package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.Users;

public class UsersDAO {
	static DataBase db = new DataBase();
	public ArrayList<Users> getListUsers() {
		ArrayList<Users> listUsers = new ArrayList<Users>();
		String query = "Select username , password , fullname , address , phone, email, position from users"
					 + " ORDER BY position DESC ,username ASC";
		try {
			Statement stm = db.connectDB().createStatement();
			ResultSet rs = stm.executeQuery(query);
			Users users;
			while(rs.next()){
				users = new Users(rs.getString(1),rs.getString(2),rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
				listUsers.add(users);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listUsers;
	}
	public boolean editUser(Users users) {
		String query = "UPDATE users SET fullname =?,password =?,address =?,phone =?, email =?,position =? WHERE username = '"+users.getUsername()+"'";
		int check=0;
		try {
			PreparedStatement pstm = db.connectDB().prepareStatement(query);
			pstm.setString(1, users.getFullname());
			pstm.setString(2, users.getPassword());
			pstm.setString(3, users.getAddress());
			pstm.setString(4, users.getPhone());
			pstm.setString(5, users.getEmail());
			pstm.setString(6, users.getPosition());
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
	public Users getUserDetail(String username) {
		Users users = null;
		String query = "Select username , password , fullname , address , phone, email,position from users where username = '"+username+"'";
		try {
			Statement stm = db.connectDB().createStatement();
			ResultSet rs = stm.executeQuery(query);
			
			while(rs.next()){
				users = new Users(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5), rs.getString(6), rs.getString(7));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}
	public boolean addUser(Users users) {
		String query = "INSERT INTO users(username,password,fullname,address,phone,email) VALUES (?,?,?,?,?,?)";
		int check=0;
		try {
			PreparedStatement pstm = db.connectDB().prepareStatement(query);
			pstm.setString(1,users.getUsername());
			pstm.setString(2, users.getPassword());
			pstm.setString(3, users.getFullname());
			pstm.setString(4, users.getAddress());
			pstm.setString(5, users.getPhone());
			pstm.setString(6, users.getEmail());
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
	public boolean addUserAdmin(Users users) {
		String query = "INSERT INTO users(username,password,fullname,address,phone,email,position) VALUES (?,?,?,?,?,?,?)";
		int check=0;
		try {
			PreparedStatement pstm = db.connectDB().prepareStatement(query);
			pstm.setString(1,users.getUsername());
			pstm.setString(2, users.getPassword());
			pstm.setString(3, users.getFullname());
			pstm.setString(4, users.getAddress());
			pstm.setString(5, users.getPhone());
			pstm.setString(6, users.getEmail());
			pstm.setString(7, users.getPosition());
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
	public boolean delUser(String username) {
		String query = "DELETE from users WHERE username=?";
		int check=0;
		try {
			PreparedStatement pstm = db.connectDB().prepareStatement(query);
			pstm.setString(1,username);
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
	public Users checkLogin(String username, String password) {
		String query = "Select username , password , fullname, address, phone, email from users where username = '"+username+"' && password = '"+password+"' && position = '1'" ;
		Users users = null;
		try {
			Statement stm = db.connectDB().createStatement();
			ResultSet rs = stm.executeQuery(query);
			
			while(rs.next()){
				users = new Users(rs.getString(1),rs.getString(2),rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}
	public Users checkLoginHome(String username, String password) {
		String query = "Select username , password , fullname, address, phone, email from users where username = '"+username+"' && password = '"+password+"'";
		Users users = null;
		try {
			Statement stm = db.connectDB().createStatement();
			ResultSet rs = stm.executeQuery(query);
			
			while(rs.next()){
				users = new Users(rs.getString(1),rs.getString(2),rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}
}
