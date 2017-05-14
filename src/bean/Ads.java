package bean;

public class Ads {
	private int idAds;
	private String name, link, picture;
	public int getId_ads() {
		return idAds;
	}
	public void setId_ads(int idAds) {
		this.idAds = idAds;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public Ads(int idAds, String name, String link, String picture) {
		super();
		this.idAds = idAds;
		this.name = name;
		this.link = link;
		this.picture = picture;
	}
	
	public Ads(){
		super();
	}
}
