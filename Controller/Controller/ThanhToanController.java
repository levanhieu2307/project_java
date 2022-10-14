package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.GioHangbean;
import bean.KhachHangbean;
import bo.GioHangbo;
import bo.donHangBo;

/**
 * Servlet implementation class ThanhToanController
 */
@WebServlet("/ThanhToanController")
public class ThanhToanController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThanhToanController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			HttpSession session=request.getSession();
			KhachHangbean kh = (KhachHangbean)session.getAttribute("kh");
			if(kh != null) {
			donHangBo dhbo = new donHangBo();
			int madh = dhbo.addDH(kh.getMaKhachHang());
			GioHangbo ghtam = (GioHangbo)session.getAttribute("gh");
    		if(ghtam!=null){
    			ArrayList<GioHangbean> list  = ghtam.ds;
    			for(GioHangbean g:list){
    				dhbo.addCT(g.getMaSanPham(), g.getSoLuongMua(), madh);
    				}
    			}
    		session.setAttribute("gh", null);
			RequestDispatcher rd= request.getRequestDispatcher("HienThiDHController");
			rd.forward(request, response);
		}else {
			request.setAttribute("thongbao", "vui long dang nhap de thuc hien thanh toan");
			RequestDispatcher rd= request.getRequestDispatcher("HtSanPhamController");
			rd.forward(request, response);
		}
			}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
