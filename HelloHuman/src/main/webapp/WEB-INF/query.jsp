<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Query</title>

</head>
<body>
	<a href="/">Back to home</a>

	<h1>
		Hello
		<c:out value="${test}" />
		!
	</h1>

	<jsp:directive.include file="bottom.jsp" />

</body>
</html>