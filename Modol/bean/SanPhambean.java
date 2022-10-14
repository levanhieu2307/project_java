package bean;

public class SanPhambean {
	 private String maSanPham;
	 private String tenSanPham;
	 private Long gia;
	 private Long soluong;
	 private String anh;
	 private String maLoai;
	/**
	 * 
	 */
	/**
	 * 
	 */
	public SanPhambean() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param maSanPham
	 * @param tenSanPham
	 * @param gia
	 * @param soluong
	 * @param anh
	 * @param maLoai
	 */
	public SanPhambean(String maSanPham, String tenSanPham, Long gia, Long soluong, String anh, String maLoai) {
		super();
		this.maSanPham = maSanPham;
		this.tenSanPham = tenSanPham;
		this.gia = gia;
		this.soluong = soluong;
		this.anh = anh;
		this.maLoai = maLoai;
	}
	public String getMaSanPham() {
		return maSanPham;
	}
	public void setMaSanPham(String maSanPham) {
		this.maSanPham = maSanPham;
	}
	public String getTenSanPham() {
		return tenSanPham;
	}
	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}
	public Long getGia() {
		return gia;
	}
	public void setGia(Long gia) {
		this.gia = gia;
	}
	public Long getSoluong() {
		return soluong;
	}
	public void setSoluong(Long soluong) {
		this.soluong = soluong;
	}
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
	public String getMaLoai() {
		return maLoai;
	}
	public void setMaLoai(String maLoai) {
		this.maLoai = maLoai;
	}
	
	 
	
}
