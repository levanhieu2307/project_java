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

import bean.LoaiBean;
import bo.Loaibo;

/**
 * Servlet implementation class QuanLiLoai
 */
@WebServlet("/QuanLiLoai")
public class QuanLiLoai extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuanLiLoai() {
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
		    Loaibo lb = new Loaibo();
			String maloai = request.getParameter("maloai");
			String tenloai = request.getParameter("tenloai");
			String add = request.getParameter("them");
			
//			XoÃ¡ mess
			if(maloai!=null && tenloai!=null){
				// cap nhat
				LoaiBean lbean = new LoaiBean(maloai, tenloai);
				request.setAttribute("loai", lbean);
				RequestDispatcher rd= request.getRequestDispatcher("themsualoai.jsp");
				rd.forward(request, response);  
			}else if(add!=null) {
				//tao moi
				RequestDispatcher rd= request.getRequestDispatcher("themsualoai.jsp");
				rd.forward(request, response);  
			}
			else {
//				trang chinh lay tat ca danh sach loai
				ArrayList<LoaiBean> danhsach = lb.getloai();
				request.setAttribute("danhsach", danhsach);
				RequestDispatcher rd= request.getRequestDispatcher("qlloaiadmin.jsp");
				rd.forward(request, response);  
			}
			} catch (Exception e) {
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
