package bo;

import java.sql.ResultSet;
import java.util.ArrayList;

import bean.DonHangbean;
import dao.DonHangDao;

public class donHangBo {
	DonHangDao dhdao = new DonHangDao();
	public ArrayList<DonHangbean> getDH (String makh) throws Exception {
		ArrayList<DonHangbean> ds = dhdao.getDH(makh);
		return ds;
	}
	public int addDH(String makh) throws Exception {
		int madh = dhdao.addDH(makh);
		return madh;
	}
	public void addCT(String masach,Long soluong,int mahd) throws Exception {
		dhdao.addCT(masach,soluong,mahd);
	}
	public void datmua(String Mahd) throws Exception {
		dhdao.datmua(Mahd);
	}
	public ResultSet chitiet(String Mahd) throws Exception {
		ResultSet rs = dhdao.chitiet(Mahd);
		return rs;
	}
	public ArrayList<DonHangbean> getall () throws Exception {
		ArrayList<DonHangbean> ds = dhdao.getall();
		return ds;
	}
}
