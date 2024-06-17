<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>INSERT PRODUCUT PAGE!!</title>
</head>
<body>
	<h1>Insert Product</h1>
	<h2 style="color: red">${loi }</h2>
	<sf:form action="insertProduct" modelAttribute="p" method="post">
		<table>
			<tr>
				<td>Product Name: </td>
				<td> <sf:input path="proName"/> </td>
			</tr>
			<tr>
				<td>Category: </td>
				<td>
					 <sf:select path="cate.cateId">
                        <sf:options items="${listCate}" itemLabel="cateName" itemValue="cateId"/>
                    </sf:select>
				</td>
			</tr>
			
			<tr>
				<td>Producer: </td>
				 <td> <sf:input path="producer"/> </td>
			</tr>
			
			<tr>
				<td>Year Making: </td>
				<td> <sf:input path="yearMaking" type="number"/> </td>
			</tr>
			
			<tr>
				<td>Expire Date: </td>
				<td> <sf:input path="expireDate" type="date"/> </td>
			</tr>
			
			<tr>
				<td>Quantity: </td>
				<td> <sf:input path="quantity" type="number"/> </td>
			</tr>
			
			<tr>
				<td>Price: </td>
				<td> <sf:input path="price" type="number"/> </td>
			</tr>
			
			<tr>
				<td></td>
				<td> 
					<input type="submit" value="Thêm">
					<input type="reset" value="Làm lại">
				</td>
			</tr>

		</table>
	</sf:form>
	
	<a href="listProducts">Thoát</a>
</body>
</html>