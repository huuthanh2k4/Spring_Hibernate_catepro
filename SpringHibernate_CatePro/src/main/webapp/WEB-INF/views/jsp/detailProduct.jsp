<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
    <%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>	THÔNG TIN CHI TIẾT SẢN PHẨM</title>
</head>
<body>
	<h1>Insert Product</h1>
	
		<table>
			<tr>
				<td>Product Id: </td>
				<td> ${p.proId } </td>
			</tr>
			
			<tr>
				<td>Product Name: </td>
				<td> ${p.proName } </td>
			</tr>
			
			<tr>
				<td>Category: </td>
				<td>${p.cate.cateName}</td>
			</tr>
			
			<tr>
				<td>Producer: </td>
				<td> ${p.producer } </td>
			</tr>
			
			<tr>
				<td>Year Making: </td>
				<td> ${p.yearMaking } </td>
			</tr>
			
			<tr>
				<td>Expire Date: </td>
				<td> 
					<f:formatDate value="${p.expireDate }" pattern="dd-MM-yyyy"/>
				</td>
			</tr>
			
			<tr>
				<td>Quantity: </td>
				<td> ${p.quantity } </td>
			</tr>
			
			<tr>
				<td>Price: </td>
				<td> 
					<f:formatNumber value="${p.price }" type="currency" currencySymbol="VNĐ" ></f:formatNumber>
				 </td>
			</tr>
			
			<a href="preCapNhapSP?proId=${p.proId}">Cập nhập thông tin</a>
			
		</table>

	<a href="listProducts">Thoát</a>
</body>
</html>