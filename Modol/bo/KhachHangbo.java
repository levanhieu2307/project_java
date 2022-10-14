package bo;

import java.util.ArrayList;

import bean.KhachHangbean;
import dao.KhachHangDao;

public class KhachHangbo {
	KhachHangDao khdao = new KhachHangDao();
    public KhachHangbean Kiemtrakh(String makh, String mk) throws Exception{
  	  KhachHangbean kh = khdao.ktdn(makh,mk);
  	  return kh;
    }
    public KhachHangbean addKH(String hoten,String diachi,String sodt,String email,String tendn,String pass) throws Exception {
  	  int c = khdao.addKH(hoten, diachi, sodt, email, tendn, pass);
  	  if (c==-9)
  	  {
  		  return null;
  	  }
  	  else 
  	  {	
  	
  		 KhachHangbean kh = khdao.ktdn(tendn, pass);
  		 return kh;
		  }
    }
    public int xoaKhangHang(String makh) throws Exception {
  	  return khdao.xoaKhangHang(makh);
    }
    public ArrayList<KhachHangbean> getKhachHang() throws Exception {
  	  return khdao.getKhachHang();
    }
}
