<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>
		<c:out value="${category.name}" />
	</h1>

	<h2>Categories</h2>
	<ul>
		<c:forEach items="${category.products}" var="product">
			<li><c:out value="${product.name}" /></li>
		</c:forEach>
	</ul>

	<form method="post" action="/categories">
		<input name="category_id" type="hidden" value="${category.id }" /> <select
			name="product_id" id="">
			<c:forEach items="${products}" var="product">				
				<option value="${product.id }">${product.name}</option>				
			</c:forEach>
		</select> 
		<input type="submit" value="Add" />
	</form>

</body>
</html>