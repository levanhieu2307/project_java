package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.LoaiBean;
import bean.SanPhambean;
import bo.Loaibo;
import bo.SanPhambo;

/**
 * Servlet implementation class HtSanPhamController
 */
@WebServlet("/HtSanPhamController")
public class HtSanPhamController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HtSanPhamController() {
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
			  Loaibo lbo= new Loaibo();
		      SanPhambo spbo= new SanPhambo();
		      //sai sachbo lay sach va tim kiem
		      ArrayList<SanPhambean> dssanpham= spbo.getsanpham();
		      String ml=request.getParameter("ml");
		      String key=request.getParameter("timkiem");
		      if(ml!=null) dssanpham=spbo.TimLoai(ml);
		      else
		    	  if(key!=null) dssanpham= spbo.TimChung(key);
	          //sai loaibo lay loai ve
		      ArrayList<LoaiBean> dsloai=lbo.getloai();
		      	  
	          request.setAttribute("dsloai", dsloai);
		      request.setAttribute("dssanpham", dssanpham);
		      
		      RequestDispatcher rd= request.getRequestDispatcher("trangchu.jsp");
				rd.forward(request, response);
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
