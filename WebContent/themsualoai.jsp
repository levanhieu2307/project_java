<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Quản lí loại</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
 <nav class="navbar navbar-inverse">
  <div class="container-fluid">
    
    <ul class="nav navbar-nav">
      <li ><a href="HtSachController">Trang chủ</a></li>
  
      <li class="active"><a href="QuanLiSanPham">Quản lí sản phẩm</a></li>
      <li><a href="QuanLiLoai">Quản lí loại</a></li>
        <li><a href="QuanliKH">Quản lí khách hàng</a></li>
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
<div class="container">
 <c:if test="${not empty tb}">
        <script>
        let message = "${tb}";
        alert(message);
   		 </script>
    </c:if>      
<div class="row">
 <div class="col-12">
               <form method="post" action="XuLiLoai">
                  <input id="id" type="hidden" name="id" value="<c:out value="${not empty loai ? loai.maLoai : ''}" />">
                      <c:if test="${empty loai}">
                   <div class="form-group">
                       <label> Mã loại: </label>
                       <input type="text" name="maloai" id="maloai"   
                       class="form-control" required>
                   </div>
                   </c:if> 
                   <div class="form-group">
                       <label> Tên loại: </label>
                       <input type="text" name="tenloai" id="tenloai"
                       value="<c:out value="${not empty loai ? loai.tenLoai : ''}" />"
                       class="form-control" required>
                   </div>
                   <a href="QuanLiLoai" class="btn"> BACK </a>
                   <button type="submit" id="btnSubmit" class="btn"> Submit </button>
               </form>
    </div>
</div>
</div>
</body>
</html>