
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Quản lí sách</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
  <nav class="navbar navbar-inverse">
  <div class="container-fluid">
    
    <ul class="nav navbar-nav">
<li ><a href="HtSachController">Trang chủ</a></li>
  
      <li class="active"><a href="QuanLiSach">Quản lí sách</a></li>
      <li><a href="QuanLiLoai">Quản lí loại</a></li>
        <li><a href="QuanLiKH">Quản lí khách hàng</a></li>
                <li><a href="QuanLyHD">Quản lí hóa đơn</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
           <li>
           
      </li>
      <li>
        
       </li>
      
    </ul>
  </div>
</nav>
<div class="container-fluid">
     <c:if test="${not empty tb}">
        <script>
        let message = "${tb}";
        alert(message);
   		 </script>
    </c:if>      
  <div class="row">
  
 <div class="col-xs-12">
  <table class="table table-hover">
      <thead>
        <tr>
      <th >Mã HĐ</th>
      <th >Mã Kh</th>
      <th >Trạng Thái</th>
      <th >Ngày mua</th>
      <th >Xác nhận</th>
        <th >Xem chi tiết</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach items="${donhang}" var="L"> 
        <tr>
         <td> ${L.maHoaDon}</td>
             <td > ${L.maKhachHang}</td>
           <td > ${L.daMua }</td>
           <td > ${L.ngayMua}</td>
            <td><c:if test ="${L.daMua==0}">
		        <a class="btn btn-info" href = "ThanhtoanController?Mahd=${L.maHoaDon}">Xác nhận</a><br>
		      </c:if>
      </td>
     <td> <a  class="btn btn-success" href ="ChiTietController?Mahd=${L.maKhachHang}">Xem chi tiết hóa đơn</a></td>
     
    
        </tr>
     </c:forEach>
      </tbody>
    </table>
 </div>
</div>

</div>
</body>
</html>