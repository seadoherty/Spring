<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>One Product</title>
</head>
<body>

	<h1>
		<c:out value="${product.name}" />
	</h1>

	<h2>Products</h2>
	<ul>
		<c:forEach items="${product.categories}" var="category">
			<li><c:out value="${category.name}" /></li>
		</c:forEach>
	</ul>

	<form method="post" action="/products">
		<input name="product_id" type="hidden" value="${product.id }" /> <select
			name="category_id" id="">
			<c:forEach items="${categories}" var="category">				
				<option value="${category.id }">${category.name}</option>				
			</c:forEach>
		</select> 
		<input type="submit" value="Add" />
	</form>

</body>
</html>