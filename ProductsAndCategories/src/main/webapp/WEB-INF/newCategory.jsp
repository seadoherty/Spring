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
	<h1>New Category</h1>

	<form:form action="/categories/new" method="POST" modelAttribute="category">
		<form:label path="name">Name:</form:label>
		<form:errors path="name" />
		<form:input path="name" />

		<input type="submit" value="Create" />
	</form:form>
</body>
</html>