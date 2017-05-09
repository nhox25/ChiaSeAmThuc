package bean;

public class About {
	private int idabout;
	private String title;
	private String detail;
	public int getIdabout() {
		return idabout;
	}
	public void setIdabout(int idabout) {
		this.idabout = idabout;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public About(int idabout, String title, String detail) {
		super();
		this.idabout = idabout;
		this.title = title;
		this.detail = detail;
	}
	public About() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
