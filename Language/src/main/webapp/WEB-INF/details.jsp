<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<main>
		<nav>
			<a href="/language">Dashboard</a>
		</nav>
		<p><c:out value="${language.name}" /></p>
		<p><c:out value="${language.creator}" /></p>
		<p><c:out value="${language.currentVersion}" /></p>
		<a href="/language/${language.id}/edit">Edit</a>
		<form action="/language/${language.id}" method="post">
			<input type="hidden" name="_method" value="delete"> 
			<input type="submit" value="Delete">
		</form> 
	</main>
</body>
</html>