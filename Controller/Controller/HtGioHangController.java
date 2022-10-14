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
import bo.Loaibo;

/**
 * Servlet implementation class HtGioHangController
 */
@WebServlet("/HtGioHangController")
public class HtGioHangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HtGioHangController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Loaibo lbo= new Loaibo();	   	          
		    ArrayList<LoaiBean> dsloai;
			dsloai = lbo.getloai();
			request.setAttribute("dsloai", dsloai);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		      	  
		RequestDispatcher rd= request.getRequestDispatcher("htgiohang.jsp");
  	   	rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
