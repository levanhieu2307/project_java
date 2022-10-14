package bo;

import java.util.ArrayList;

import bean.GioHangbean;

public class GioHangbo {

	public ArrayList<GioHangbean> ds = new ArrayList<GioHangbean>();
	
	public void Them(String maSanPham, String tenSanPham, Long gia, Long slmua) {
	    	for(GioHangbean g: ds)
	    		if(g.getMaSanPham().equals(maSanPham)) {
	    			g.setSoLuongMua(g.getSoLuongMua()+slmua);
	    			return;
	    		}
	    	ds.add(new GioHangbean(maSanPham, tenSanPham, gia, slmua));
	    }

	public void Xoa(String maSanPham) {
	    	for(GioHangbean g: ds)
	    		if(g.getMaSanPham().equals(maSanPham)) {
	    			ds.remove(g);
	    			return;
	    		}
	    }
	public ArrayList<GioHangbean> XoaAll(){
		ds.removeAll(ds);
		return ds;
	}
	public void Capnhat(String maSanPham,Long slmuamoi) {
		for(GioHangbean g: ds)
    		if(g.getMaSanPham().equals(maSanPham)) {
    		   g.setSoLuongMua(slmuamoi);
    		}
	}
	 
	 public Long Tongtien() {
	    	long s=0;
	    	for(GioHangbean g: ds)
	    		s=s+g.getThanhTien();
	    	return s;
	    }
}
