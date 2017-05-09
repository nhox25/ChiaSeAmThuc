package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBase {
	public Connection connectDB(){
		Connection cnn=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/chiaseamthuc?useUnicode=true&characterEncoding=UTF-8","root","");
			System.out.println("OKKKKKKKKKKKKK");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cnn;
	}
}
