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
    <li ><a href="HtSachController">Thêm Sửa Sản Phẩm</a></li>
  
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
     <div class="card shadow mb-4">
        <div class="card-body">
                  <form method="post" action="XuLiSach" enctype="multipart/form-data">
                  <input type="hidden" name="id" value="<c:out value="${not empty sachct ? sachct.getMasach() : ''}" />">
                    <c:if test="${empty sachct}">
                   <div class="form-group">
                       <label> Mã sách: </label>
                       <input type="text" name="masach" 
                       class="form-control" required>
                   </div>
                    </c:if> 
                   <div class="form-group">
                       <label> Tên sách: </label>
                       <input type="text" name="tensach" value="<c:out value="${not empty sachct ? sachct.getTensach() : ''}" />"
                       class="form-control" required>
                   </div>
                       <div class="form-group">
                       <label>Số lượng:</label>
                       <input type="text" name="soluong" value="<c:out value="${not empty sachct ? sachct.getSoluong() : ''}" />"
                       class="form-control" required>
                   </div>
                   <div class="form-group">
                       <label>Giá (vnđ):</label>
                       <input type="text" name="gia" value="<c:out value="${not empty sachct ? sachct.getGia() : ''}" />"
                       class="form-control" required>
                   </div>
                   <div class="form-group">
                       <label>Tác giả:</label>
                       <input type="text" name="tacgia" value="<c:out value="${not empty sachct ? sachct.getTacgia() : ''}" />"
                       class="form-control" required>
                   </div>
                    <div class="form-group">
                    <label>Mã loại:</label>
                   	 <input type="text" name="maloai" value="<c:out value="${not empty sachct ? sachct.getMaloai() : ''}" />"
                       class="form-control" required>
                    </div>
                   <div class="form-group">
                   <label>Ảnh:</label>
                 	<input type="file" name="upload" name="anh">
                     </div>
                   <a href="QuanLiSach" class="btn"> Trở lại </a>
                   <button type="submit" class="btn btn-info"> Xác nhận </button>
               </form>
        </div>
    </div>
</div>
</div>
</div>
</body>
</html>