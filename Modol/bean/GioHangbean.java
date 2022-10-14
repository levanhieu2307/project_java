package bean;

public class GioHangbean {
	private String maSanPham;
    private String tenSanPham;
    private Long gia;
    private Long soLuongMua;
    private Long thanhTien;
    
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
	public Long getSoLuongMua() {
		return soLuongMua;
	}
	public void setSoLuongMua(Long soLuongMua) {
		this.soLuongMua = soLuongMua;
	}
	public Long getThanhTien() {
		return soLuongMua*gia;
	}
	public void setThanhTien(Long thanhTien) {
		this.thanhTien = thanhTien;
	}
	/**
	 * 
	 */
	public GioHangbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param maSanPham
	 * @param tenSanPham
	 * @param gia
	 * @param soLuongMua
	 * @param thanhTien
	 */
	public GioHangbean(String maSanPham, String tenSanPham, Long gia, Long soLuongMua) {
		super();
		this.maSanPham = maSanPham;
		this.tenSanPham = tenSanPham;
		this.gia = gia;
		this.soLuongMua = soLuongMua;
		this.thanhTien = gia*soLuongMua;
	}
    
}
