package Admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.KhachHangbean;
import bo.KhachHangbo;

/**
 * Servlet implementation class QuanLiKH
 */
@WebServlet("/QuanLiKH")
public class QuanLiKH extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuanLiKH() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			HttpSession session=request.getSession();
			KhachHangbo khb = new KhachHangbo();
			String msxoa = request.getParameter("msxoa");
			if(msxoa!=null) {
					int result = khb.xoaKhangHang(msxoa);
					if(result > 0 ) request.setAttribute("tb", "Xoá thành công !");
					else request.setAttribute("tb", "Xoá không thành công !");
					ArrayList<KhachHangbean> danhsach = khb.getKhachHang();
					request.setAttribute("danhsach", danhsach);
					RequestDispatcher rd= request.getRequestDispatcher("qlkhachhangadmin.jsp");
					rd.forward(request, response); 
			}else {
				ArrayList<KhachHangbean> danhsach = khb.getKhachHang();
				request.setAttribute("danhsach", danhsach);
				RequestDispatcher rd= request.getRequestDispatcher("qlkhachhangadmin.jsp");
				rd.forward(request, response);
			} 
			}catch (Exception e) {
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
