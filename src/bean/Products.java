package bean;

public class Products {
	private int id_product;
	private String name_product;
	private String address_product;
	private int price_product;
	private int phone_product;
	private String email_product;
	private String website_product;
	private String description_product;
	private String user_product;
	private String picture1_product;
	private String timecreate_product;
	private int status_product;
	private int idCat;
	private String nameCat;
	private int idDictricts;
	private String nameDictricts;
	
	public int getId_product() {
		return id_product;
	}
	public void setId_product(int id_product) {
		this.id_product = id_product;
	}
	public String getName_product() {
		return name_product;
	}
	public void setName_product(String name_product) {
		this.name_product = name_product;
	}
	public String getAddress_product() {
		return address_product;
	}
	public void setAddress_product(String address_product) {
		this.address_product = address_product;
	}
	public int getPrice_product() {
		return price_product;
	}
	public void setPrice_product(int price_product) {
		this.price_product = price_product;
	}
	public int getPhone_product() {
		return phone_product;
	}
	public void setPhone_product(int phone_product) {
		this.phone_product = phone_product;
	}
	public String getEmail_product() {
		return email_product;
	}
	public void setEmail_product(String email_product) {
		this.email_product = email_product;
	}
	public String getWebsite_product() {
		return website_product;
	}
	public void setWebsite_product(String website_product) {
		this.website_product = website_product;
	}
	public String getDescription_product() {
		return description_product;
	}
	public void setDescription_product(String description_product) {
		this.description_product = description_product;
	}
	public String getUser_product() {
		return user_product;
	}
	public void setUser_product(String user_product) {
		this.user_product = user_product;
	}
	public String getPicture1_product() {
		return picture1_product;
	}
	public void setPicture1_product(String picture1_product) {
		this.picture1_product = picture1_product;
	}
	public String getTimecreate_product() {
		return timecreate_product;
	}
	public void setTimecreate_product(String timecreate_product) {
		this.timecreate_product = timecreate_product;
	}
	public int getStatus_product() {
		return status_product;
	}
	public void setStatus_product(int status_product) {
		this.status_product = status_product;
	}
	
	public int getIdCat() {
		return idCat;
	}
	public void setIdCat(int idCat) {
		this.idCat = idCat;
	}
	public String getNameCat() {
		return nameCat;
	}
	public void setNameCat(String nameCat) {
		this.nameCat = nameCat;
	}
	
	public int getIdDictricts() {
		return idDictricts;
	}
	public void setIdDictricts(int idDictricts) {
		this.idDictricts = idDictricts;
	}
	public String getNameDictricts() {
		return nameDictricts;
	}
	public void setNameDictricts(String nameDictricts) {
		this.nameDictricts = nameDictricts;
	}
	public Products() {
		super();
	}
	public Products(int id_product, String name_product,
			String address_product, String dictric_product, int price_product,
			int phone_product, String email_product, String website_product,
			String description_product,String user_product, String picture1_product,
			String timecreate_product,int status_product) {
		super();
		this.id_product = id_product;
		this.name_product = name_product;
		this.address_product = address_product;
		this.price_product = price_product;
		this.phone_product = phone_product;
		this.email_product = email_product;
		this.website_product = website_product;
		this.description_product = description_product;
		this.user_product = user_product;
		this.picture1_product = picture1_product;
		this.timecreate_product = timecreate_product;
		this.status_product = status_product;
	}
	public Products(int id_product, String name_product,
			String address_product, int price_product,
			int phone_product, String email_product, String website_product,
			String description_product,String user_product, String picture1_product,
			String timecreate_product, int status_product, int idCat,int idDictricts, 
			String nameCat,String nameDictricts) {
		super();
		this.id_product = id_product;
		this.name_product = name_product;
		this.address_product = address_product;
		this.price_product = price_product;
		this.phone_product = phone_product;
		this.email_product = email_product;
		this.website_product = website_product;
		this.description_product = description_product;
		this.user_product = user_product;
		this.picture1_product = picture1_product;
		this.timecreate_product = timecreate_product;
		this.status_product = status_product;
		this.idCat = idCat;
		this.nameCat = nameCat;
		this.idDictricts = idDictricts;
		this.nameDictricts = nameDictricts;
	}
}
