<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Ninja</title>
<style>
form {
	width: 600px; display : flex;
	flex-direction: column;
	display: flex;
}

input, select {
	width: 100px;
}

div {
	display: flex;
}
</style>
</head>
<body>

	<h1>New Ninja</h1>

	<form:form action="/ninjas/new" method="post" modelAttribute="ninja">
		<div>
			<form:label path="dojo">Dojo:</form:label>
			<form:select path="dojo">
				<c:forEach items="${dojos}" var="dojo">
					<form:option value="${dojo.id }">
						<c:out value="${dojo.name}" />
					</form:option>
				</c:forEach>
			</form:select>
		</div>
		<div>
			<form:label path="firstName">First Name:</form:label>
			<form:errors path="firstName" />
			<form:input type="text" path="firstName" />
		</div>
		<div>
			<form:label path="lastName">Last Name:</form:label>
			<form:errors path="lastName" />
			<form:input type="text" path="lastName" />
		</div>
		<div>
			<form:label path="age">Age:</form:label>
			<form:errors path="age" />
			<form:input type="number" path="age" />
		</div>
		<input type="submit" value="Create" />
	</form:form>
</body>
</html>