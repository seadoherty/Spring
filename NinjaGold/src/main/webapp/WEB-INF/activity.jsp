<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<h1>Activities:</h1>

<textarea class="last">
	<c:forEach items="${log}" var="msg">
		${msg}
	</c:forEach>   
</textarea>