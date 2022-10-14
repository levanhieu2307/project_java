package Admin;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import bo.Loaibo;
import bo.SanPhambo;

/**
 * Servlet implementation class XuLiSanPham
 */
@WebServlet("/XuLiSanPham")
public class XuLiSanPham extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XuLiSanPham() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String msxoa = request.getParameter("msxoa");
		SanPhambo spbo = new SanPhambo();
		Loaibo lbo = new Loaibo();
		  int kt = 0;
		if(msxoa!=null) {
			try {
				int xoa = spbo.xoaSanPham(msxoa);
				if(xoa > 0 ) {
					request.setAttribute("tb", "Xoá thành công ");
					 RequestDispatcher rd= request.getRequestDispatcher("QuanLiSanPham");
		     		 rd.forward(request, response); 
				}
				else {
					request.setAttribute("tb", "Xoá không thành công ");
					 RequestDispatcher rd= request.getRequestDispatcher("QuanLiSanPham");
		     		 rd.forward(request, response); 
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
	   }else {	
		  String masanpham=null,tensanpham=null,maloai=null,soluong=null,gia=null,anhupload=null;
		  DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
		  ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
	
		try {
		 List<FileItem> fileItems = upload.parseRequest(request);
         for (FileItem fileItem : fileItems) {
 			 if (!fileItem.isFormField()) {//Nếu ko phải các control=>upfile lên
				String nameimg = fileItem.getName();
				
				if (!nameimg.equals("")) {
					if(spbo.timanh(nameimg)==false) {
						 kt=-3;
					}
					
					String dirUrl = request.getServletContext().getRealPath("") +  "image_sach";
					File dir = new File(dirUrl);
					if (!dir.exists()) {//nếu ko có thư mục thì tạo ra
						dir.mkdir();
					}
				           String fileImg = dirUrl + File.separator + nameimg;
				           File file = new File(fileImg);//tạo file
				            try {
				               fileItem.write(file);// ghi file
				               anhupload =  "image_sach/"+nameimg;
				              System.out.println(anhupload);
				 } catch (Exception e) {
				    e.printStackTrace();
				}
			}
		 }
			else
			{
				String tentk=fileItem.getFieldName();
				if(tentk.equals("id")) {
					String c = fileItem.getString("UTF-8");
					if(!c.equals("")) {
						masanpham = c;
				        kt=1;						
					}
				}
				if(tentk.equals("masanpham")) masanpham = fileItem.getString("UTF-8");
				if(tentk.equals("tensanpham")) tensanpham = fileItem.getString("UTF-8");
				if(tentk.equals("maloai")) maloai = fileItem.getString("UTF-8");
				if(tentk.equals("soluong")) soluong = fileItem.getString("UTF-8");;
				if(tentk.equals("gia")) gia = fileItem.getString("UTF-8");
			}
		}
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
//      Xử lí thêm hoặc sửa
		 try {
	       if(kt==0) { //thêm
	     	 int c = spbo.themSanPham(masanpham, tensanpham, Long.parseLong(gia), Long.parseLong(soluong),anhupload, maloai);
	     	 if(c==0) {
		     		request.setAttribute("tb", "thêm sách không thành công");
		     		RequestDispatcher rd= request.getRequestDispatcher("QuanLiSanPham?add");
		     		rd.forward(request, response);
		     }else if(c==-1) {
		    	    request.setAttribute("tb", "Trùng mã sách");
		     		RequestDispatcher rd= request.getRequestDispatcher("QuanLiSanPham?add");
		     		rd.forward(request, response);
		     }else{
		     		 request.setAttribute("tb", "thêm sách thành công");
		     		 RequestDispatcher rd= request.getRequestDispatcher("QuanLiSanPham");
		     		 rd.forward(request, response);  
		     }
	     }else if (kt==-3) {//trung ten anh
	    	 request.setAttribute("tb", "thêm sách thất bại, trùng tên ảnh");
     		 RequestDispatcher rd= request.getRequestDispatcher("QuanLiSanPham");
     		 rd.forward(request, response); 
	     }else { // sửa
	    	 int update = spbo.capNhat(masanpham, tensanpham, Long.parseLong(gia), Long.parseLong(soluong), anhupload, maloai);
	     	 if(update==0) {
	     		request.setAttribute("tb", "Update không thành công");
	     		RequestDispatcher rd= request.getRequestDispatcher(
	     				"XuLiSanPham?tensanpham="+tensanpham+ "&gia="+gia+"&soluong="+soluong+"&anh="+anhupload+"&maloai="+maloai);
	     		rd.forward(request, response);
	     	 }else {
	     		 request.setAttribute("tb", "update thành công");
	     		 RequestDispatcher rd= request.getRequestDispatcher("QuanLiSanPham");
	     		 rd.forward(request, response);  
	     	 }
	    }
		} catch (Exception e) {
			e.printStackTrace();
		}
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
