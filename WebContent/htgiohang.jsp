<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="bean.LoaiBean"%>
<%@page import="bean.GioHangbean"%>
<%@page import="bo.GioHangbo"%>
<%@page import="bean.KhachHangbean"%>
<%@page import="bo.KhachHangbo"%>

<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Giỏ hàng</title>
</head>
<body>
<%
    request.setCharacterEncoding("utf-8") ;
    response.setCharacterEncoding("utf-8");
    ArrayList<LoaiBean> dsloai=(ArrayList<LoaiBean>)request.getAttribute("dsloai");    
	Locale localeEN = new Locale("en", "EN");
	NumberFormat en = NumberFormat.getInstance(localeEN);
    
      %>
 	<nav class="navbar navbar-inverse">
  
    
    <ul class="nav navbar-nav">
      <li class="active"><a href="HtSanPhamController">Trang chủ</a></li>
  
      <li><a href="GioHangController">Giỏ hàng</a></li>
      <li><a href="HienThiDHController">Lịch sử mua hàng</a></li>
    </ul>
    <!-- Đăng nhập đăng ký -->
    <ul class="nav navbar-nav navbar-right">
       
        <%          
           KhachHangbean kh = (KhachHangbean)session.getAttribute("kh");
           if(kh != null) {
        	   out.print("<li><a href = 'DangNhapController'>Xin Chào " +kh.getHoTen()+ "</a></li> <li><a href = 'DangXuatController'>Logout   </a></li>");
        	   
           }else {
        	   out.print("<li><a href='#' data-toggle='modal' data-target='#myModaldangnhap'><span class='glyphicon glyphicon-log-in'></span> Đăng nhập</a></li>");
        	   if(session.getAttribute("tb")!= null){
        		   out.print("<script>alert('"+session.getAttribute("tb")+"')</script>");
        	   }
           }
          %>         	           
      
      
          <% 
             if(kh != null) {
          	   out.print("<li><a href='#' style = 'display: none;' data-toggle='modal' data-target='#myModaldangky'><span class='glyphicon glyphicon-log-in'></span> Đăng ký</a></li>");
             }else {
          	   out.print("<li><a href='#' data-toggle='modal' data-target='#myModaldangky'><span class='glyphicon glyphicon-log-in'></span>Đăng ký</a></li>");
             }
          	 %>
      
      
    </ul>
  
</nav>
    <table class = "table">
    <tr>
  
   <td valign="top" width="20%">
            <table class= "table table-hover">
                    <%
               for(LoaiBean loai: dsloai){
           %>
               <tr>
                  <td>
                      <a  href="HtSanPhamController?ml=<%=loai.getMaLoai()%>">
                         <%=loai.getTenLoai()%>
                      </a> 
                  </td>
               </tr>
               <%} %>
            </table>
       </td>
   
   <td valign="top" width="80%">
	<table class= "table table-dark table-striped"> 
        <tbody>
         <%
     		GioHangbo ghtam = (GioHangbo)session.getAttribute("gh");
    		if(ghtam!=null){
    			ArrayList<GioHangbean> list  = ghtam.ds;
    			for(GioHangbean g:list){
       %>
    	<tr>		
		<td valign="top"><span style="color:black;"><b><%=g.getTenSanPham() %></b></span><br>
		<form method="post" action="GioHangController">
		<b>Giá: <span style="color:#6d2524"><%=en.format(g.getGia())+"đ" %></span></b> x Số lượng: 
		 <input type="hidden" name="mscn" value=<%=g.getMaSanPham()%>>
		 <input type="number" name="slmoi" style="width:90px; height: 34px" value=<%=g.getSoLuongMua()%>>  
		 <button class="btn btn-warning" type="submit" name = "capnhat">Cập nhật</button>
		 
		  </form>
		   <a class = "btn btn-primary" href="GioHangController?mspxoa=<%=g.getMaSanPham()%>">Trả lại</a></span>
		</td></tr>
    	<%		}
    			
    		}%>
   	</tbody>
   	</table>	
   	
    <%
    	if(ghtam!=null){
    		out.print("<div><b>Tổng : "+en.format(ghtam.Tongtien())+"đ<b></div>");
    	}
    
    %>
    <div >
       <%    
       if(ghtam == null) {
    	   out.print("<a class = 'btn btn-primary' style = 'margin-right: 10px' href = 'HtSanPhamController' >Mua sách tại đây</a>");
    	   out.print("<a class = 'btn btn-info' style = 'display:none; margin-right: 10px;' href = 'ThanhToanController' >Xác nhận đặt mua</a>");
    	   out.print("<a class = 'btn-success' style = 'display:none;' href= 'GioHangController?xoaall="+ghtam+"'>Trả lại toàn bộ</a>");
    	   
       }else {
    	   out.print("<a class = 'btn btn-primary'  style = 'margin-right: 10px' href = 'HtSanPhamController' >Tiếp tục mua hàng </a>");
    	   out.print("<a class = 'btn btn-info' style = ' margin-right: 10px;' href = 'ThanhToanController' >Xác nhận đặt mua</a>");
    	   out.print("<a class = 'btn btn-success' href= 'GioHangController?xoaall="+ghtam+"'	>Trả lại toàn bộ</a>");
       }      
       %>  
    </div> 
 </td>
 
 </table>
   
</div>
<div class="modal fade" id="myModaldangnhap">
    <div class="modal-dialog modal-sm">
      <div class="modal-content">
      
        <!-- Modal Header -->
        <div class="modal-header">
          <h4 class="modal-title">Thông tin đăng nhập</h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        
        <!-- Modal body -->
        <div class="modal-body">
        <form action="DangNhapController" method="POST">
        Tên đăng nhập: <input type="text" placeholder="Nhập địa chỉ email" name="txtuser" class="form-control"><br>     
        Mật khẩu: <input type="password"  placeholder="Nhập mật khẩu" name="txtpass" class="form-control"><br>      
        <input class="form-check-input" type="checkbox" name="remember"> Remember me <br>    
        <input type="submit" name="btn" value="Đăng nhập" class="btn btn-primary">
    </form>
        </div>
                
      </div>
    </div>
 </div>
 <div class="modal fade" id="myModaldangky">
    <div class="modal-dialog modal-sm">
      <div class="modal-content">
      
        <!-- Modal Header -->
        <div class="modal-header">
          <h4 class="modal-title">Thông tin đăng kí</h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        
        <!-- Modal body -->
        <div class="modal-body">
        <form action="DangKyController" method="POST">
        họ và tên: <input type="text" placeholder="Nhập địa chỉ email" name="user" class="form-control" required><br>
        Địa chỉ: <input type="text"  placeholder="Nhập mật khẩu" name="diachi" class="form-control" required><br>
        Số điện thoại: <input type="text"  placeholder="Nhập lại mật khẩu" name="sodt" class="form-control" required><br>
        email: <input type="email"  placeholder="Nhập lại mật khẩu" name="email" class="form-control" required><br>
        tên đăng nhập: <input type="text"  placeholder="Nhập lại mật khẩu" name="tendn" class="form-control" required><br>
      	mật khẩu: <input type="password"  placeholder="Nhập lại mật khẩu" name="pass" class="form-control" required><br>
        <input type="submit" placeholder="Nhập mật khẩu" name="but1" value="Đăng ký" class="btn btn-primary">
    </form>
        </div>
                
      </div>
    </div>
 </div>
</body>
</html>