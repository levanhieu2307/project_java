package bean;

public class KhachHangbean {
	private String maKhachHang;
	private String hoTen;
	private String diaChi;
	private String soDienThoai;
	private String email;
	private String tenDangNhap;
	private String matKhau;
	/**
	 * 
	 */
	public KhachHangbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param maKhachHang
	 * @param hoTen
	 * @param diaChi
	 * @param soDienThoai
	 * @param email
	 * @param tenDangNhap
	 * @param matKhau
	 */
	public KhachHangbean(String maKhachHang, String hoTen, String diaChi, String soDienThoai, String email,
			String tenDangNhap, String matKhau) {
		super();
		this.maKhachHang = maKhachHang;
		this.hoTen = hoTen;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
		this.email = email;
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
	}
	
	@Override
	public String toString() {
		return "KhachHangbean [maKhachHang=" + maKhachHang + ", hoTen=" + hoTen + ", diaChi=" + diaChi
				+ ", soDienThoai=" + soDienThoai + ", email=" + email + ", tenDangNhap=" + tenDangNhap + ", matKhau="
				+ matKhau + "]";
	}
	public String getMaKhachHang() {
		return maKhachHang;
	}
	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTenDangNhap() {
		return tenDangNhap;
	}
	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	
}
