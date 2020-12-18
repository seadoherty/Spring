<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>New Product</h1>

	<form:form action="/products/new" method="POST" modelAttribute="product">
		<form:label path="name">Name:</form:label>
		<form:errors path="name" />
		<form:input path="name" />
		
		<form:label path="description">Description:</form:label>
		<form:errors path="description" />
		<form:textarea path="description" />
		
		<form:label path="price">Price:</form:label>
		<form:errors path="price" />
		<form:input type="number" path="price" />

		<input type="submit" value="Create" />
	</form:form>

</body>
</html>