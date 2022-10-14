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

import bean.DonHangbean;
import bean.KhachHangbean;
import bo.donHangBo;

/**
 * Servlet implementation class HienThiDHController
 */
@WebServlet("/HienThiDHController")
public class HienThiDHController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HienThiDHController() {
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
			donHangBo dhbo = new donHangBo();
			KhachHangbean khachhang = (KhachHangbean)session.getAttribute("kh");
			if(khachhang != null) {
				ArrayList<DonHangbean> ds = dhbo.getDH(khachhang.getMaKhachHang());
				request.setAttribute("donhang", ds);
				RequestDispatcher rd= request.getRequestDispatcher("htDonHang.jsp");
		      	rd.forward(request, response);
			}else {
				request.setAttribute("thongbao", "vui long dang nhap de su dung chuc nang");
				RequestDispatcher rd= request.getRequestDispatcher("HtSanPhamController");
		      	rd.forward(request, response);
			}
			
		} catch (Exception e) {
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
