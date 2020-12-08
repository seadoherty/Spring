<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<article>
	<h1>Casino!</h1>
	<p>(earns/takes 0-50 gold)</p>
	<form method="post" action="/update">
		<input type="hidden" name="location" value="casino"> 
		<input type="submit" value="Find Gold">
	</form>
</article>