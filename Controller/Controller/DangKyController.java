package Controller;

import java.io.IOException;

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
 * Servlet implementation class DangKyController
 */
@WebServlet("/DangKyController")
public class DangKyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DangKyController() {
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
		      
			  KhachHangbo khbo = new KhachHangbo();
			  HttpSession session=request.getSession();
		      String hoten = request.getParameter("user");
		      String diachi = request.getParameter("diachi");
		      String sodt= request.getParameter("sodt");
		      String email= request.getParameter("email");
		      String tendn= request.getParameter("tendn");
		      String pass= request.getParameter("pass");
		      if(hoten != null && diachi != null && sodt !=null && email!= null && tendn !=null && pass!=null){
		      	   KhachHangbean kh = khbo.addKH(hoten,diachi,sodt,email,tendn,pass);
		      		   if(kh!=null) {
		      			 session.setAttribute("kh", kh);
		      		   }else request.setAttribute("thongbao", "Trung ten dang nhap");
		      		 
	          }
	          RequestDispatcher rd= request.getRequestDispatcher("HtSanPhamController");
	          rd.forward(request, response);
		      
		} catch (Exception e) {
			// TODO: handle exception
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
