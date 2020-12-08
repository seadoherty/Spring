<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="style.css" rel="stylesheet" />
</head>
<body>
	<main>
		<section>
			<h1>Submitted Info</h1>
			<div>
				<p>Name:</p>
				<p>
					<c:out value="${name}" />
				</p>
			</div>
			<div>
				<p>Dojo Location:</p>
				<p>
					<c:out value="${location }" />
				</p>
			</div>
			<div>
				<p>Favorite Language:</p>
				<p>
					<c:out value="${language }" />
				</p>
			</div>
			<div>
				<p>Comment:</p>
				<p>
					<c:out value="${comment }" />
				</p>
			</div>
		</section>

	</main>

</body>
</html>