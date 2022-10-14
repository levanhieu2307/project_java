package dao;

import java.beans.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sun.jdi.connect.spi.Connection;

import bean.LoaiBean;

public class Loaidao {
		DungChung dc= new DungChung();
		public ArrayList<LoaiBean> getloai() throws Exception{
				   ArrayList<LoaiBean> ds= new ArrayList<LoaiBean>();
				  //b1: Ket noi vao csdl
				   dc.KetNoi();
				   //b2: Lay du lieu ve
				   String sql="select * from Loai";
				   PreparedStatement cmd= dc.cn.prepareStatement(sql);
		//b3: Truyen tham so vao cmd: bo qua
				   //b4: Thuc hien cau lenh
				   ResultSet rs= cmd.executeQuery();
				   //b5: Duyet tap ket qua: rs
				   while(rs.next()) {
					   String maloai =rs.getString("maLoai");
					   String tenloai=rs.getString("tenLoai");
					   ds.add(new LoaiBean(maloai, tenloai));
				   }
		//b6: Dong all 
				   rs.close();
				   dc.cn.close();
				   return ds;
	
	
//	
//	public List<loaibean> getListlloaibean(){
//		try {
//			String query = "select * from loai";
//		    DungChung conn = new DungChung();
//		    conn.KetNoi();
//		    Statement st = conn.createStatement();
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		
//	return null;	
//	}
		}
		
		
		public LoaiBean layMot(String ml) throws Exception{
			dc.KetNoi();
			String sql = "Select* from Loai where maLoai = ?";
			PreparedStatement pr = dc.cn.prepareStatement(sql);
			pr.setString(1, ml);
			ResultSet rs = pr.executeQuery();
			if(rs.next() != false) {
				String mloai = rs.getString(1);
				String tl = rs.getString(2);
				LoaiBean lb = new LoaiBean(mloai,tl);
				dc.cn.close();
				return lb;
			}
			rs.close();
			dc.cn.close();
			return null;
		}
		
		
		
		 public int addLoai(String ml,String tenloai) throws Exception {
				dc.KetNoi();
			   String sql = "Select* from Loai WHERE maLoai = ?";
				PreparedStatement c = dc.cn.prepareStatement(sql);
				c.setString(1, ml);
				ResultSet rs = c.executeQuery();
				if(rs.next() != false) {
					dc.cn.close();
					return -1;
				}
				String sql1 = "INSERT INTO loai(maLoai,tenLoai) VALUES(?,?)";
				PreparedStatement pr = dc.cn.prepareStatement(sql1);
				pr.setString(1, ml);
				pr.setString(2, tenloai);
				int result = pr.executeUpdate();
				pr.close();
				dc.cn.close();
				return result;
			}
		 
		 public int capnhat(String ml,String tenloai) throws Exception {
				dc.KetNoi();
				String sql ="Update Loai SET tenloai= ? WHERE maLoai = ?";
				PreparedStatement cmd = dc.cn.prepareStatement(sql);
				cmd.setString(1,tenloai);
				cmd.setString(2, ml);
				int check = cmd.executeUpdate();
				dc.cn.close();
				return check;
		 }
		 public int xoaLoai(String ml) throws Exception {
			dc.KetNoi();
			String sql ="DELETE FROM Loai WHERE maLoai = ?";
			PreparedStatement cmd = dc.cn.prepareStatement(sql);
			cmd.setString(1,ml);
			int check = cmd.executeUpdate();
			dc.cn.close();
			return check;
		 }
		

}
