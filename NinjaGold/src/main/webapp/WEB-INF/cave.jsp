<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<article>
	<h1>Cave</h1>
	<p>(earns 5-10 gold)</p>
	<form method="POST" action="/update">
		<input type="hidden" name="location" value="cave"> 
		<input type="submit" value="Find Gold">
	</form>
</article>