package bean;

public class LoaiBean {
	private String maLoai;
    private String tenLoai;
	/**
	 * 
	 */
	public LoaiBean() {
		super();
	}
	public String getMaLoai() {
		return maLoai;
	}
	public void setMaLoai(String maLoai) {
		this.maLoai = maLoai;
	}
	public String getTenLoai() {
		return tenLoai;
	}
	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}
	/**
	 * @param maLoai
	 * @param tenLoai
	 */
	public LoaiBean(String maLoai, String tenLoai) {
		super();
		this.maLoai = maLoai;
		this.tenLoai = tenLoai;
	}



    
}
