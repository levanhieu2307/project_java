package bo;

import java.util.ArrayList;

import bean.SanPhambean;
import dao.SanPhamDao;

public class SanPhambo {
	SanPhamDao sdao = new SanPhamDao();
	public boolean timanh(String key) throws Exception{
		return sdao.Timanh(key);
	}
	
	
	public ArrayList<SanPhambean> getsanpham() throws Exception{
		return sdao.getSanPham();
	}
	
	public Long demSach(String maloai) throws Exception {
		ArrayList<SanPhambean> ds= getsanpham();
		   Long d=(long)0;
		   for(SanPhambean s: ds)
			   if(s.getMaLoai().equals(maloai))
				   d++;
		   return d;
	}
    
	 public ArrayList<SanPhambean> TimLoai(String maloai) throws Exception {
		   ArrayList<SanPhambean> ds= getsanpham();
		   ArrayList<SanPhambean> tam= new ArrayList<SanPhambean>();
		   for(SanPhambean s: ds)
			   if(s.getMaLoai().equals(maloai))
				   tam.add(s);
		   return tam;
	   }
	 public ArrayList<SanPhambean> Tim(String key) throws Exception {
		   ArrayList<SanPhambean> ds= getsanpham();
		   ArrayList<SanPhambean> tam= new ArrayList<SanPhambean>();
		   for(SanPhambean s: ds)
			   if(s.getTenSanPham().trim().toLowerCase().contains(key.trim().toLowerCase()))
				   tam.add(s);
		   return tam;
	  }
	 public ArrayList<SanPhambean> TimChung(String key) throws Exception {
			return sdao.TimChung(key);
		 }
	 
	 public int themSanPham(String masanpham, String tensanpham, Long gia, Long soluong, String anh, String maloai) throws Exception {
		return sdao.themSanPham(masanpham, tensanpham,  gia, soluong, anh, maloai);
	 }

	 public int capNhat(String masanpham, String tensanpham, Long gia, Long soluong, String anh, String maloai) throws Exception {
		 return sdao.capNhat(masanpham, tensanpham, gia, soluong, anh, maloai);
	 }
	 public int xoaSanPham(String msxoa) throws Exception {
		 return sdao.xoaSanPham(msxoa);
	 }
}
