package bean;

public class Dictricts {
	public int id_dictricts;
	public String nam_dictricts;
	public int getId_dictricts() {
		return id_dictricts;
	}
	public void setId_dictricts(int id_dictricts) {
		this.id_dictricts = id_dictricts;
	}
	public String getNam_dictricts() {
		return nam_dictricts;
	}
	public void setNam_dictricts(String nam_dictricts) {
		this.nam_dictricts = nam_dictricts;
	}
	public Dictricts(int id_dictricts, String nam_dictricts) {
		super();
		this.id_dictricts = id_dictricts;
		this.nam_dictricts = nam_dictricts;
	}
	public Dictricts() {
		super();
	}
	
	
}
