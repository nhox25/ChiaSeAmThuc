package bean;

public class TypeProduct {
	private int idTypePro;
	private String nameTypePro;
	
	
	public int getIdTypePro() {
		return idTypePro;
	}


	public void setIdTypePro(int idTypePro) {
		this.idTypePro = idTypePro;
	}


	public String getNameTypePro() {
		return nameTypePro;
	}


	public void setNameTypePro(String nameTypePro) {
		this.nameTypePro = nameTypePro;
	}

	

	public TypeProduct(int idTypePro, String nameTypePro) {
		super();
		this.idTypePro = idTypePro;
		this.nameTypePro = nameTypePro;
	}


	public TypeProduct() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
