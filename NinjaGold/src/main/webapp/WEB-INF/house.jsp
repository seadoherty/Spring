<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<article>
	<h1>House</h1>
	<p>(earns 2-5 gold)</p>
	<form method="POST" action="/update">
		<input type="hidden" name="location" value="house"> 
		<input type="submit" value="Find Gold">
	</form>
</article>