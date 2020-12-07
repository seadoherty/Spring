<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="style.css" rel="stylesheet" />
</head>
<body>
	<main>
	
		<form method="POST" action="/test">
		<p class="error"><c:out value="${error }"/></p><br>
			<p>What is the code?</p>
			<input type="text" name="guess"> <br>
			<button>Login</button>
		</form>
	</main>
</body>
</html>