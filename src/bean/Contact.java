package bean;

public class Contact {
	private int idcontact;
	private String title;
	private String fullname;
	private String email;
	private String phone;
	private String website;
	private String content;
	private String datecreate;
	private int status;

	

	public Contact(int idcontact, String title, String fullname, String email, String phone,
			String website, String content, String datecreate, int status) {
		super();
		this.idcontact = idcontact;
		this.title = title;
		this.fullname = fullname;
		this.email = email;
		this.phone = phone;
		this.website = website;
		this.content = content;
		this.datecreate = datecreate;
		this.status = status;
	}



	public int getIdcontact() {
		return idcontact;
	}



	public void setIdcontact(int idcontact) {
		this.idcontact = idcontact;
	}



	public String getFullname() {
		return fullname;
	}



	public void setFullname(String fullname) {
		this.fullname = fullname;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public String getWebsite() {
		return website;
	}



	public void setWebsite(String website) {
		this.website = website;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}



	public String getDatecreate() {
		return datecreate;
	}



	public void setDatecreate(String datecreate) {
		this.datecreate = datecreate;
	}
	
	


	public int getStatus() {
		return status;
	}



	public void setStatus(int status) {
		this.status = status;
	}

	

	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}

}
