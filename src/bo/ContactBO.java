package bo;

import java.util.ArrayList;

import dao.ContactDAO;
import bean.Contact;

public class ContactBO {
	static ContactDAO contactDAO = new ContactDAO();
	public ArrayList<Contact> getListContact() {
		// TODO Auto-generated method stub
		return contactDAO.getListContact();
}
	public static boolean delContact(int idcontact) {
		// TODO Auto-generated method stub
		return contactDAO.getdelContact(idcontact);
	}
	public static boolean getProcessedContact(int idcontact) {
		// TODO Auto-generated method stub
		return contactDAO.getProcessedContact(idcontact);
	}
	public boolean addContact(Contact contact) {
		// TODO Auto-generated method stub
		return contactDAO.addContact(contact);
	}
	public Contact getDetail(String idContact) {
		// TODO Auto-generated method stub
		return contactDAO.getDetail(idContact);
	}
}
