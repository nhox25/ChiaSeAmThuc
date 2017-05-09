package bo;

import java.util.ArrayList;

import dao.UsersDAO;
import bean.Users;


public class UsersBO {
	static UsersDAO usersDAO = new UsersDAO();
	public ArrayList<Users> getListUsers() {
		// TODO Auto-generated method stub
		return usersDAO.getListUsers();
	}
	public boolean editUser(Users users) {
		// TODO Auto-generated method stub
		return usersDAO.editUser(users);
	}
	public Users getUserDetail(String username) {
		// TODO Auto-generated method stub
		return usersDAO.getUserDetail(username);
	}
	public static boolean addUser(Users users) {
		// TODO Auto-generated method stub
		return usersDAO.addUser(users);
	}
	public static boolean addUserAdmin(Users users) {
		// TODO Auto-generated method stub
		return usersDAO.addUserAdmin(users);
	}
	public boolean delUser(String username) {
		// TODO Auto-generated method stub
		return usersDAO.delUser(username);
	}
	public Users checkLogin(String username, String password) {
		return usersDAO.checkLogin(username,password);
		
	}
	public Users checkLoginHome(String username, String password) {
		return usersDAO.checkLoginHome(username,password);
		
	}
}
