<%@page import="bean.LoaiBean"%>
<%@page import="bean.SanPhambean"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="bean.KhachHangbean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="bean.DonHangbean"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Trang chủ nhà sách Minh khai</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
    <%
    request.setCharacterEncoding("utf-8") ;
    response.setCharacterEncoding("utf-8");
    ArrayList<SanPhambean> ds=(ArrayList<SanPhambean>)request.getAttribute("dssanpham");
    ArrayList<LoaiBean> dsloai=(ArrayList<LoaiBean>)request.getAttribute("dsloai");
    if(request.getAttribute("thongbao")!=null){
		out.print("<script>alert('"+request.getAttribute("thongbao")+"')</script>");
    }
      %>
     
  <nav class="navbar navbar-inverse">
  
    
    <ul class="nav navbar-nav">
      <li class="active"><a href="HtSachController">Trang chủ</a></li>
  
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

<%
    request.setCharacterEncoding("utf-8") ;
    response.setCharacterEncoding("utf-8");
   ResultSet rs=(ResultSet)request.getAttribute("rs");
%><table class="table">
  <thead>
    <tr>
      <th scope="col">stt</th>
      <th scope="col">tên sách</th>
      <th scope="col">số lượng</th>
      <th scope="col">ảnh</th>
       <th scope="col">Thành tiền</th>

    </tr>
  </thead>
  <tbody>
  <% 
  int i=0;
  Long tong= new Long(0);
  while(rs.next()!=false){tong+=rs.getLong("tongtien"); %>

    <tr>
      <th scope="row"><%=++i %></th>
      <td><%=rs.getString("tenSanPham") %></td>
      <td><%=rs.getLong("soLuongMua") %></td>
      <td><img src="<%=rs.getString("anh")%>" alt="Girl in a jacket" width="100" height="100"></td>
      <td><%=rs.getLong("tongtien") %></td>
    </tr>
    <%} %>  
  </tbody>
</table>
Thành Tiền: <%=tong %>
</body>
</html>