<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Quản lí sản phẩm</title>
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
   <div class="col-xs-3">
  		<div>
  		 <a href="QuanLiSanpham">Tất cả</a> <hr>
  		 	 <c:forEach items="${dsloai}" var="DS"> 
  		 	 	 <a href="QuanLiSanPham?ml=${DS.maLoai}">${DS.tenLoai}</a> <hr>
  		 	 	
				  

           </c:forEach>
  		</div>
   </div>

 <div class="col-xs-9">
 <div class="text-right">
 <a href="QuanLiSanPham?them" class="btn btn-danger">Thêm mới</a>
 </div>
 <br>
     <table class="table table-hover">
      <thead>
        <tr>
          <th>Mã sản phẩm</th>
          <th>Tên sản phẩm</th>
           <th>Số lượng kho</th>
          <th>Giá</th>
          <th>Ảnh</th>
           <th>Mã loại</th>
           <th>Cập nhật</th>
          <th>Xoá</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach items="${dssanpham}" var="L"> 
        <tr>
          <td> ${L.maSanPham}</td>

           <td style="width: 160px"> ${L.tenSanPham}</td>
             <td style="width: 40px"> ${L.soluong}</td>
           <td>${L.gia} vnđ</td>
          <td><img src="${L.anh}" style="width: 30px;height: 30px"></td>
          <td style="width: 140px"> ${L.maLoai}</td>
             <td> <a href="QuanLiSanPham?masanpham=${L.maSanPham}&tensanpham=${L.tenSanPham}&gia=${L.gia}&soluong=${L.soluong}&anh=${L.anh}&maloai=${L.maLoai}" class="btn">Cập nhật</a></td>
            <td> 
            <form action="XuLiSanPham" method="post">
            		 <input id="msxoa" type="hidden" name="msxoa" value="${L.maSanPham}">
            		<button type="submit" class="btn btn-danger">Xoá</button>
            	</form></td>
        
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