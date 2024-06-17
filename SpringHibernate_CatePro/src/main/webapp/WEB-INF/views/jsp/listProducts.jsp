<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LIST PRODUCTS!</title>
</head>
<body>
	<h1>LIST PRODUCTS!</h1>
	<h2 style="color: green">${re }</h2>
	<h2 style="color: green">${s }</h2>
	<h2 style="color: green">${tc }</h2>
	<h2 style="color: red">${d }</h2>
	
	<form action="seachSP" method="post">
		<b>Nhập  tên sản phẩm</b>
		<input type="search" name="Search">
		<input type="submit" value="Tìm kiếm">
	</form> <br><br>
	
	<table border="1">
		<tr>
			<th>ID sản phẩm</th>
			<th>Tên sản phẩm </th>
			<th>Loại</th>
			<th>Hãng</th>
			<th>Năm sản xuất</th>
			<th>Ngày sản xuất</th>
			<th>Số lượng sản phẩm</th>
			<th>Giá sản phẩm</th>
			<th>Thông tin chi tiết</th>
		</tr>
		
		<c:forEach items="${list }" var="p">
			<tr>
				<td>${p.proId}</td>
				<td>${p.proName}</td>
				<td>${p.cate.cateName}</td>
				<td> ${p.producer } </td>
				<td>${p.yearMaking}</td>
				<td>
   					 <f:formatDate value="${p.expireDate}" pattern="dd-MM-yyyy" /> 
				</td>
				<td>${p.quantity}</td>
				<td>
					<f:formatNumber value="${p.price}" type="currency" currencySymbol="VNĐ"></f:formatNumber>
				</td>
				<td>
					<a href="detailProduct?proId=${p.proId}" >Detail</a>
				</td>
				<td>
					<a href="xoaSP?proId=${p.proId}" onclick="return confirm('Bạn có chắc muốn xóa thông tin này không ???')">Xóa</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<a href="initInsertProduct">Thêm thông tin</a>
</body>
</html>