<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CẬP NHẬP SẢN PHẨM</title>
</head>
<body>
	<h1>Cập nhập sản phẩm</h1>
	<h2 style="color: red">${tb }</h2>
	<f:form action="CapNhapSP" modelAttribute="p" method="post">
		<table>
			<tr>
				<td>Product Id: </td>
				<td> <f:input path="proId" readonly="true"/> </td>
			</tr>
		
			<tr>
				<td>Product Name: </td>
				<td> <f:input path="proName"/> </td>
			</tr>
			<tr>
				<td>Category: </td>
				<td>
					 <f:select path="cate.cateId">
                        <f:options items="${listCate}" itemLabel="cateName" itemValue="cateId"/>
                    </f:select>
				</td>
			</tr>
			
			<tr>
				<td>Producer: </td>
				 <td> <f:input path="producer"/> </td>
			</tr>
			
			<tr>
				<td>Year Making: </td>
				<td> <f:input path="yearMaking" type="number"/> </td>
			</tr>
			
			<tr>
				<td>Expire Date: </td>
				<td> <f:input path="expireDate" type="date"/> </td>
			</tr>
			
			<tr>
				<td>Quantity: </td>
				<td> <f:input path="quantity" type="number"/> </td>
			</tr>
			
			<tr>
				<td>Price: </td>
				<td> <f:input path="price" type="number"/> </td>
			</tr>
			
			<tr>
				<td></td>
				<td> 
					<input type="submit" value="Cập nhập">
					<input type="reset" value="Làm lại">
				</td>
			</tr>

		</table>
	</f:form>
	
	<a href="listProducts">Thoát</a>
</body>
</html>