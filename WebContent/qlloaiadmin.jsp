
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Quản lí Loại</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
  <nav class="navbar navbar-inverse">
  <div class="container-fluid">
    
    <ul class="nav navbar-nav">
  <li ><a href="HtSanPhamController">Trang chủ</a></li>
  
      <li class="active"><a href="QuanLiSanPham">Quản lí sản phẩm</a></li>
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
 <div class="text-right">
 <a href="QuanLiLoai?them" class="btn btn-danger">Thêm loại</a>
 </div>
 <br>
 <table class="table table-hover">
      <thead>
        <tr>
          <th>Mã loại</th>
          <th>Tên loại</th>
          <th>Xoá</th>
           <th>Cập nhật</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach items="${danhsach}" var="L"> 
        <tr>
          <td> ${L.maLoai}</td>
           <td > ${L.tenLoai }</td>
           <td> <form action="XuLiLoai" method="post">
            		 <input id="maxoa" type="hidden" name="maxoa" value="${L.maLoai}">
            		<button type="submit" class="btn">Xoá</button>
            	</form></td>
         <td> <a href="QuanLiLoai?maloai=${L.maLoai}&tenloai=${L.tenLoai}" class="btn btn-success">Cập nhật</a></td>
          <%--   --%>
        </tr>
     </c:forEach>
      </tbody>
    </table>

 </div>
</div>

</div> 
</script>
</body>
</html>