package bo;

import java.util.ArrayList;

import bean.LoaiBean;
import dao.Loaidao;

public class Loaibo {
	Loaidao ldao=new Loaidao();
	public ArrayList<LoaiBean> getloai() throws Exception {
		return ldao.getloai();
	}
	
	public int addLoai(String ml,String tenloai) throws Exception {
		return ldao.addLoai(ml, tenloai);
	}
	 public int capnhat(String ml,String tenloai) throws Exception {
		 return ldao.capnhat(ml, tenloai);
	 }
	 public int xoaLoai(String ml) throws Exception {
		 return ldao.xoaLoai(ml);
	 }
}
