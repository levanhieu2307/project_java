package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.SanPhambean;

public class SanPhamDao {
	DungChung dc= new DungChung();
	
	public boolean Timanh(String key) throws Exception{
		dc.KetNoi();
		ArrayList<SanPhambean> ds = new ArrayList<SanPhambean>();
		String sql="select * from SanPham where anh = ?";
		PreparedStatement cmd= dc.cn.prepareStatement(sql);
		cmd.setString(1, "image_sach/"+ key+".jpg");
		ResultSet rs = cmd.executeQuery();
		if(rs.next()!=false) {
			   return true;
		   }
		   rs.close();
		   dc.cn.close();
		return false;
	}
	
	public ArrayList<SanPhambean> TimChung(String key) throws Exception{
		dc.KetNoi();
		ArrayList<SanPhambean> ds = new ArrayList<SanPhambean>();
		String sql="select * from SanPham where tenSanPham like ? or maLoai like ?";
		PreparedStatement cmd= dc.cn.prepareStatement(sql);
		cmd.setString(1, "%"+ key +"%");
		cmd.setString(2,  "%"+ key +"%");
		ResultSet rs = cmd.executeQuery();
		while(rs.next()) {
			 String masp = rs.getString("maSanPham");
			   String tensp= rs.getString("tenSanPham");
			   Long gia = rs.getLong("gia");
			   Long soluong = rs.getLong("soluong");
			   String anh = rs.getString("anh");
			   String maloai = rs.getString("maLoai");
			   ds.add(new SanPhambean(masp, tensp, gia, soluong, anh, maloai));
		}
		   rs.close();
		   dc.cn.close();
		return ds;
	}
	
	
	public ArrayList<SanPhambean> getSanPham() throws Exception{
		dc.KetNoi();
		ArrayList<SanPhambean> ds= new ArrayList<SanPhambean>();
		  //b1: Ket noi vao csdl
		   //b2: Lay du lieu ve
		   String sql="select * from SanPham";
		   PreparedStatement cmd= dc.cn.prepareStatement(sql);
//b3: Truyen tham so vao cmd: bo qua
		   //b4: Thuc hien cau lenh
		   ResultSet rs= cmd.executeQuery();
		   //b5: Duyet tap ket qua: rs
		   while(rs.next()) {
			   String masp = rs.getString("maSanPham");
			   String tensp= rs.getString("tenSanPham");
			   Long gia = rs.getLong("gia");
			   Long soluong = rs.getLong("soluong");
			   String anh = rs.getString("anh");
			   String maloai = rs.getString("maLoai");
			   ds.add(new SanPhambean(masp, tensp, gia, soluong, anh, maloai));
		   }
//b6: Dong all 
		   rs.close();
		   dc.cn.close();
		   return ds;
	   }
	public int themSanPham(String masp, String tensp, Long gia, Long soluong, String anh, String maloai) throws Exception {
		dc.KetNoi();
		String sql = "Select* from SanPham WHERE maSanPham = ?";
		PreparedStatement pr = dc.cn.prepareStatement(sql);
		pr.setString(1, masp);
		ResultSet rs = pr.executeQuery();
		if(rs.next() != false) {
			dc.cn.close();
			return -1;
		}
		String sqlin = "INSERT INTO SanPham(maSanPham,tenSanPham,soLuong,gia,maLoai,anh,ngayNhap) VALUES(?,?,?,?,?,?,?)";
		PreparedStatement cmd = dc.cn.prepareStatement(sqlin);
		cmd.setString(1, masp);
		cmd.setString(2, tensp);
		cmd.setLong(3, soluong);
		cmd.setLong(4,gia);
		cmd.setString(5, maloai);
		cmd.setString(6, anh);
		java.sql.Date date = new java.sql.Date(new java.util.Date().getTime());
		cmd.setDate(7, date);
	
		int add = cmd.executeUpdate();
		dc.cn.close();
		return add;
	}
	
	public int capNhat(String maSanPham, String tenSanPham, Long gia, Long soluong, String anh, String maloai) throws Exception {
		dc.KetNoi();
			System.out.println("co anh");
			String sql ="Update SanPham SET tenSanPham =?,gia= ?,maLoai =?,soLuong=?,anh =? WHERE maSanPham = ?";
			PreparedStatement cmd = dc.cn.prepareStatement(sql);
			cmd.setString(1, tenSanPham);
			cmd.setLong(2,gia);
			cmd.setString(3, maloai);
			cmd.setLong(4,soluong);
			cmd.setString(5, anh);
			cmd.setString(6, maSanPham);
			int check = cmd.executeUpdate();
			dc.cn.close();
			return check;
	}
	 public int xoaSanPham(String msxoa) throws Exception {
		 dc.KetNoi();
		 String sql ="DELETE FROM SanPham WHERE maSanPham = ?";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setString(1,msxoa);
		int check = cmd.executeUpdate();
		dc.cn.close();
		return check;
	 }
}
