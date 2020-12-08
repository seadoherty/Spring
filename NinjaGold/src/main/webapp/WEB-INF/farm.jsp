<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<article>
	<h1>Farm</h1>
	<p>(earns 10-20 gold)</p>
	<form method="POST" action="/update">
		<input type="hidden" name="location" value="farm"> 
		<input type="submit" value="Find Gold">
	</form>
</article>