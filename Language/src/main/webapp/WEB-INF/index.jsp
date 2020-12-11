<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Languages</title>
<link href="style.css" rel="stylesheet" />
</head>
<body>
	<main>
		<table class="table">
			<thead>
				<tr>
					<th>Name</th>
					<th>Creator</th>
					<th>Version</th>
					<th>action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${languages}" var="language">
					<tr>
						<td><a href="/language/${language.id }"> <c:out
									value="${language.name}" /></a></td>
						<td><c:out value="${language.creator}" /></td>
						<td><c:out value="${language.currentVersion}" /></td>
						<td>
							<form action="/language/${language.id}" method="post">
								<input type="hidden" name="_method" value="delete"> <input
									type="submit" value="Delete">
							</form> <a href="/language/${language.id}/edit">Edit</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<form:form class="form" method="post" action="/language"
			modelAttribute="language">
			<div class="inputWrapper">
				<p>Name</p>
				<input type="text" name="name">
				<form:errors path="name" />
			</div>
			<div class="inputWrapper">
				<p>Creator</p>
				<input type="text" name="creator">
				<form:errors path="creator" />
			</div>
			<div class="inputWrapper">
				<p>Version</p>
				<input type="text" name="currentVersion">
				<form:errors path="currentVersion" />
			</div>
			<input type="submit" value="Submit" />
		</form:form>
	</main>
</body>
</html>