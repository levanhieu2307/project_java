package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.DonHangbean;

public class DonHangDao {
	DungChung dc = new DungChung();
	public ArrayList<DonHangbean> getDH(String makh) throws Exception {
		
		ArrayList<DonHangbean> ds = new ArrayList<DonHangbean>();
		dc.KetNoi();
		String sql = "select * from hoadon where maKhachHang = ?";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setString(1,makh);
		ResultSet rs = cmd.executeQuery();
		while(rs.next()!=false) {
			String mahd = rs.getString("maHoaDon");
			String makh1 = rs.getString("maKhachHang");
			String ngaymua = rs.getString("ngayMua");
			int damua = rs.getInt("daMua");
			DonHangbean dh = new DonHangbean(mahd, makh1, ngaymua, damua);
			ds.add(dh);
		}
		return ds;
	}
	public int addDH(String makh) throws Exception {
		dc.KetNoi();
		String sql = "INSERT INTO hoadon(maKhachHang,ngayMua,daMua) VALUES (?,getdate(),0)";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setString(1,makh);
		cmd.executeUpdate();
		sql = "select top 1 * from hoadon where maKhachHang =? order by MaHoaDon desc";
		cmd = dc.cn.prepareStatement(sql);
		cmd.setString(1,makh);
		ResultSet rs = cmd.executeQuery();
		rs.next();
		int madh = rs.getInt("MaHoaDon");
		return madh;
	}
	public void addCT(String masp,Long soluong, int mahd) throws Exception {
		dc.KetNoi();
		String sql = "INSERT INTO ChiTietHoaDon(MaSanPham,soLuongMua,maHoaDon) VALUES(?,?,?)";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setString(1,masp);
		cmd.setLong(2,soluong);
		cmd.setInt(3,mahd);
		cmd.executeUpdate();
	}
	public void datmua(String mahd) throws Exception {
		dc.KetNoi();
		String sql = "UPDATE hoadon SET damua = 1 WHERE maHoaDon = ?";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setString(1,mahd);
		cmd.executeUpdate();
	}
	public ResultSet chitiet(String mahd) throws Exception {
		dc.KetNoi();
		String sql = "select s.tenSanPham, ct.SoLuongMua, s.gia,s.anh,(ct.SoLuongMua* s.gia) as tongtien from ChiTietHoaDon as ct join SanPham as s on ct.maSanPham = s.maSanPham where MaHoaDon = ?";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setString(1,mahd);
		ResultSet rs = cmd.executeQuery();
		return rs;
	}
public ArrayList<DonHangbean> getall() throws Exception {
		
		ArrayList<DonHangbean> ds = new ArrayList<DonHangbean>();
		dc.KetNoi();
		String sql = "select * from hoadon order by damua";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		while(rs.next()!=false) {
			String mahd = rs.getString("maHoaDon");
			String makh1 = rs.getString("maKhachHang");
			String ngaymua = rs.getString("ngayMua");
			int damua = rs.getInt("daMua");
			DonHangbean dh = new DonHangbean(mahd, makh1, ngaymua, damua);
			ds.add(dh);
		}
		return ds;
	}
}
