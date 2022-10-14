package dao;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import java.security.MessageDigest;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.KhachHangbean;

public class KhachHangDao {
	DungChung dc= new DungChung();
    public	KhachHangbean ktdn(String tk, String mk) throws Exception{
		  //b1: Ket noi vao csdl
		   
		   dc.KetNoi();
		   //b2: Lay du lieu ve
		   String sql="select * from KhachHang where tenDangNhap = ? and pass = ?";
		   PreparedStatement cmd= dc.cn.prepareStatement(sql);
		   cmd.setString(1,tk);
		   cmd.setString(2,mk);
//		   String sql = "select * from KhachHang where tendn = 'nkchung' and pass = '123'";
//		   PreparedStatement cmd = dc.cn.prepareStatement(sql);
		   //b3: Truyen tham so vao cmd: bo qua
		   //b4: Thuc hien cau lenh
		   ResultSet rs= cmd.executeQuery();
		   if(rs.next()==false) {
			   return null;
		   }else 
		   { 	
				System.out.println("dn thanh cong");
			   String makhachhang = rs.getString("maKhachHang");
			   String hoten = rs.getString("hoTen");
			   String diachi = rs.getString("diaChi");
			   String sdt = rs.getString("soDienThoai");
			   String email = rs.getString("email");
			   String tendn = rs.getString("tenDangNhap");
			   String matkhau = rs.getString("pass");
			   KhachHangbean kh = new KhachHangbean(makhachhang, hoten, diachi, sdt, email, tendn, matkhau);
			   rs.close();
			   dc.cn.close();
			   return kh;
		   }
    }
    public int addKH(String hoten,String diachi,String sodt,String email,String tendn,String pass) throws Exception {
			//b1.ket noi vao csdl
			DungChung dc= new DungChung();
			dc.KetNoi();
			String sql="select * from KhachHang where tendangnhap = ? ";
			PreparedStatement cmd= dc.cn.prepareStatement(sql);
			cmd.setString(1, tendn);
			ResultSet rs=cmd.executeQuery();
			if(rs.next() != false) {
				cmd.close();
				dc.cn.close();
				return -9;
			}else {
				


				//----------------------------------
					
//					        MessageDigest md = MessageDigest.getInstance("MD5");
//					        md.update(pass.getBytes());
//					        byte[] digest = md.digest();
//					        String passMD5 = DatatypeConverter.printHexBinary(digest);
//					    
						//------------------------

				
				sql = "insert into  KhachHang(hoTen,diaChi,soDienThoai,email,tenDangNhap,pass) VALUES (?,?,?,?,?,?)";
				 cmd= dc.cn.prepareStatement(sql);
				   cmd.setString(1,hoten);
				   cmd.setString(2,diachi);
				   cmd.setString(3,sodt);
				   cmd.setString(4,email);
				   cmd.setString(5,tendn);
				   cmd.setString(6,pass);
				   int c = cmd.executeUpdate();
				   cmd.close();
				   dc.cn.close();
				   return c;
		   
			}
			 
}
    public int xoaKhangHang(String makh) throws Exception {
		 dc.KetNoi();
		 String sql ="DELETE FROM khachhang WHERE maKhachHang = ?";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setString(1,makh);
		int result = cmd.executeUpdate();
		dc.cn.close();
		return result;
	 }
    public ArrayList<KhachHangbean> getKhachHang() throws Exception {
		dc.KetNoi();
		ArrayList<KhachHangbean> ds = new ArrayList<KhachHangbean>();
		String sql = "Select* from khachhang";
		PreparedStatement pr = dc.cn.prepareStatement(sql);
		ResultSet rs = pr.executeQuery();
		while (rs.next()) {
			String makh = rs.getString(1);
			String hoten = rs.getString(2);
			String diachi = rs.getString(3);
			String sodt = rs.getString(4);
			String email = rs.getString(5);
			String tendn = rs.getString(6);
			String mk = rs.getString(7);
			KhachHangbean kha = new KhachHangbean(makh, hoten, diachi, sodt, email, tendn, mk);
			ds.add(kha);
		}
		dc.cn.close();
		return ds;
	}
}
