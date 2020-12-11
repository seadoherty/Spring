<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- <link href="style.css" rel="stylesheet" /> -->
</head>
<body>
	<main>
		<nav>
			<form:form action="/language/${language.id}" method="post"
				modelAttribute="language">
				<input type="hidden" name="_method" value="delete">
				<input type="submit" value="Delete">
			</form:form>
			<a href="/language">Dashboard</a>
		</nav>
		<form action="/language/${language.id }" method="post">
			<input type="hidden" name="_method" value="put">
			<div>
				<p>Name</p>
				<input type="text" name="name" value="${language.name}">
			</div>
			<div>
				<p>Creator</p>
				<input type="text" name="creator" value="${language.creator}">
			</div>
			<div>
				<p>Version</p>
				<input type="text" name="currentVersion" value="${language.currentVersion}">
			</div>
			<input type="submit" value="Update" />
		</form>
	</main>

</body>
</html>