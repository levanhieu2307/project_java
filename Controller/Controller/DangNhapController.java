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
 * Servlet implementation class DangNhapController
 */
@WebServlet("/DangNhapController")
public class DangNhapController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DangNhapController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try {
		  request.setCharacterEncoding("utf-8");
	      response.setCharacterEncoding("utf-8");
	      
		  KhachHangbo khbo = new KhachHangbo();
	     	      
	      String tk = request.getParameter("txtuser");
	      String pass = request.getParameter("txtpass");
	      HttpSession session=request.getSession();
          if(tk != null && pass != null){
	      	   KhachHangbean kh = khbo.Kiemtrakh(tk, pass);
	      	if(kh!=null)
	      		session.setAttribute("kh", kh);
	      	else {
	      		session.setAttribute("tb", "Thông tin đăng nhập sai");
			}
	      		
	      	RequestDispatcher rd= request.getRequestDispatcher("HtSanPhamController");
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
