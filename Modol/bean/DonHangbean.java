package bean;

public class DonHangbean {
	private String maHoaDon;
	private String maKhachHang;
	private String ngayMua;
	private int daMua;
	/**
	 * 
	 */
	public DonHangbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param maHoaDon
	 * @param maKhachHang
	 * @param ngayMua
	 * @param daMua
	 */
	public DonHangbean(String maHoaDon, String maKhachHang, String ngayMua, int daMua) {
		super();
		this.maHoaDon = maHoaDon;
		this.maKhachHang = maKhachHang;
		this.ngayMua = ngayMua;
		this.daMua = daMua;
	}
	public String getMaHoaDon() {
		return maHoaDon;
	}
	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}
	public String getMaKhachHang() {
		return maKhachHang;
	}
	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}
	public String getNgayMua() {
		return ngayMua;
	}
	public void setNgayMua(String ngayMua) {
		this.ngayMua = ngayMua;
	}
	public int getDaMua() {
		return daMua;
	}
	public void setDaMua(int daMua) {
		this.daMua = daMua;
	}
	
	
}
