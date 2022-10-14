package Admin;

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
 * Servlet implementation class XuLiLoai
 */
@WebServlet("/XuLiLoai")
public class XuLiLoai extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XuLiLoai() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			Loaibo lbo = new Loaibo();
			String maloai = request.getParameter("maloai");
			String id=request.getParameter("id");
			String tenloai = request.getParameter("tenloai");
			String maxoa = request.getParameter("maxoa");
			ArrayList<LoaiBean> danhsach = lbo.getloai();
			if(maloai!=null && tenloai!=null) {
						int check = lbo.addLoai(maloai, tenloai);
						if(check > 0) {
							danhsach = lbo.getloai();
							request.setAttribute("danhsach", danhsach);
							request.setAttribute("tb", "thêm thành công");
							RequestDispatcher rd= request.getRequestDispatcher("qlloaiadmin.jsp");
							rd.forward(request, response);  
						}
						else {
							request.setAttribute("tb", "thêm không thành công");
							RequestDispatcher rd= request.getRequestDispatcher("themsualoai.jsp");
							rd.forward(request, response);  
						}
			  
			}else if(id!=null && !id.equals("") && tenloai!=null ) {
				int check = lbo.capnhat(id, tenloai);
				if(check > 0) {
					danhsach = lbo.getloai();
					request.setAttribute("tb", "cập nhật thành công");
					request.setAttribute("danhsach", danhsach);
					RequestDispatcher rd= request.getRequestDispatcher("qlloaiadmin.jsp");
					rd.forward(request, response);  
				}
				else {
					request.setAttribute("tb", "cập nhật không thành công");
					RequestDispatcher rd= request.getRequestDispatcher("QuanLiLoai?maloai="+maloai+"&tenloai"+tenloai);
					rd.forward(request, response);  
				}
			}
			else if(maxoa!=null) {
				int check = lbo.xoaLoai(maxoa);
				if(check > 0) {
					request.setAttribute("tb", "xóa thành công");
					danhsach = lbo.getloai();
					request.setAttribute("danhsach", danhsach);
					RequestDispatcher rd= request.getRequestDispatcher("qlloaiadmin.jsp");
					rd.forward(request, response);  
				}
				else {
					request.setAttribute("tb", "xóa không thành công");
					RequestDispatcher rd= request.getRequestDispatcher("qlloaiadmin.jsp");
					rd.forward(request, response);  
				}
			}else {
				request.setAttribute("danhsach", danhsach);
				RequestDispatcher rd= request.getRequestDispatcher("QuanLiLoai");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

}
