<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="style.css" rel="stylesheet" />
</head>
<body>
	<main>
		<form method="POST" action="/formInfo">
			<div>
				<p>Your Name</p>
				<input type="text" name="name">
			</div>
			<div>
				<p>Dojo Location:</p>
				<select name="location">
					<option>San Jose</option>
					<option>Chicago</option>
				</select>
			</div>
			<div>
				<p>Favorite Language:</p>
				<select name="language">
					<option>Python</option>
					<option>Java</option>
					<option>Javascript</option>
				</select>
			</div>
			<p>Comment (optional):</p>
			<textarea name="comment"></textarea>
			<input type="submit" value="Button" />
		</form>
	</main>
</body>
</html>