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
import bean.SanPhambean;
import bo.Loaibo;
import bo.SanPhambo;

/**
 * Servlet implementation class QuanLiSanPham
 */
@WebServlet("/QuanLiSanPham")
public class QuanLiSanPham extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuanLiSanPham() {
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
			SanPhambo spb = new SanPhambo();
			Loaibo lb = new Loaibo();
			String masanpham = request.getParameter("masanpham");
			String tensanpham = request.getParameter("tensanpham");
			String gia = request.getParameter("gia");
			String soluong = request.getParameter("soluong");
			String anh =request.getParameter("anh");
			String maloai =request.getParameter("ma"
					+ "loai");
			String add = request.getParameter("them");
	
			
		
			
			System.out.println(add);
			if(tensanpham!=null ) {
				SanPhambean sanpham = new SanPhambean(masanpham, tensanpham,Long.parseLong(gia), Long.parseLong(soluong), anh, maloai);
				request.setAttribute("sanphamct", sanpham);
				RequestDispatcher rd= request.getRequestDispatcher("suasanpham.jsp");
				rd.forward(request, response);  
				
			}else if(add!=null) {
				ArrayList<LoaiBean> loaifull=new Loaibo().getloai();
				request.setAttribute("loaifull", loaifull);
				RequestDispatcher rd= request.getRequestDispatcher("themsanpham.jsp");
				rd.forward(request, response);  
			}else{
				ArrayList<SanPhambean> dssanpham=spb.getsanpham();
				ArrayList<LoaiBean> dsloai = lb.getloai();
				String ml= request.getParameter("ml");
				String key=request.getParameter("tim");
				
				if (ml!=null) {
		        	 dssanpham=spb.TimLoai(ml);
		         } else if(key!=null) dssanpham=spb.Tim(key);
				
				dsloai.toString();
				request.setAttribute("dssanpham", dssanpham);
				request.setAttribute("dsloai", dsloai);
				
	
				RequestDispatcher rd= request.getRequestDispatcher("qlsanphamadmin.jsp");
				rd.forward(request, response);  
	}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
//		HttpSession session= request.getSession();
//		try {
//			response.setCharacterEncoding("utf-8");
//			request.setCharacterEncoding("utf-8");
//			Loaibo lbo = new Loaibo();
//			ArrayList<LoaiBean> dsloai = lbo.getloai();
//			 session.setAttribute("dsloai", dsloai);
//			RequestDispatcher rd = request.getRequestDispatcher("qlsanphamadmin.jsp");
//			rd.forward(request, response);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
