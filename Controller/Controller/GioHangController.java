package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.LoaiBean;
import bo.GioHangbo;
import bo.Loaibo;

/**
 * Servlet implementation class GioHangController
 */
@WebServlet("/GioHangController")
public class GioHangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GioHangController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  try {
	        	request.setCharacterEncoding("utf-8") ;
			    response.setCharacterEncoding("utf-8");
			    //lấy về mã sách, tên sách, tác giả, giá.
				String msp = request.getParameter("msp");
				String tsp = request.getParameter("tsp");
				String dongia = request.getParameter("gia");
				
				String mspxoa = request.getParameter("mspxoa");
				String mspcn = request.getParameter("mscn");
				String slmoi = request.getParameter("slmoi");
				String xoaall = request.getParameter("xoaall");
				
				HttpSession session = request.getSession();
				
				
		         
				// tạo ra giỏ hàng.
				GioHangbo gh=null;
				if(session.getAttribute("gh")==null){
					gh=new GioHangbo();
				    session.setAttribute("gh", gh);
				}
				//them 1 sach
				if(msp!=null && tsp!=null && dongia!=null){	
				       gh=(GioHangbo)session.getAttribute("gh");///gián sesion  ra biến
				       gh.Them(msp, tsp, Long.parseLong(dongia), (long)1);// thao tác trên biến: hàm thêm
				       session.setAttribute("gh", gh);

			       
				}
				//xoa 1 sach
			    if(mspxoa!=null){
			    	gh = (GioHangbo)session.getAttribute("gh");
			    	gh.Xoa(mspxoa);
			    	session.setAttribute("gh", gh);
			       
			    }
			    
			    //cap nhat
			     if(mspcn!=null && slmoi!=null){
			    	gh = (GioHangbo)session.getAttribute("gh");
			    	gh.Capnhat(mspcn,Long.parseLong(slmoi));
			    	session.setAttribute("gh", gh);
			        
			    }
			    //xoa all
			    if(xoaall != null){
			    	gh = (GioHangbo)session.getAttribute("gh");
			    	gh.XoaAll();
			    	session.setAttribute("gh", gh);
			    	response.sendRedirect("HtSachController");
			    	return;	     
			    }
			    
			    Loaibo lbo= new Loaibo();	   	          
			    ArrayList<LoaiBean> dsloai=lbo.getloai();		      	  
		        request.setAttribute("dsloai", dsloai);	
		        
//		        RequestDispatcher rd= request.getRequestDispatcher("htgiohang.jsp");
//		  		   rd.forward(request, response);		    
		        response.sendRedirect("HtGioHangController");
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
