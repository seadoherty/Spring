<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ninja Gold</title>
<link href="style.css" rel="stylesheet" />
</head>
<body>
	<main>
		<section>
			<%@ include file="yourGold.jsp"%>
		</section>
		<section>
			<%@ include file="farm.jsp"%>
			<%@ include file="cave.jsp"%>
			<%@ include file="house.jsp"%>
			<%@ include file="casino.jsp"%>
		</section>
		<section class="last">
			<%@ include file="activity.jsp"%>
		</section>
	</main>
</body>
</html>