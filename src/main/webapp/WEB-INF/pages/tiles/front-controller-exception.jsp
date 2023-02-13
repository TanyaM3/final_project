<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<%
	String message = (String) request.getAttribute("message");
	%>

	<h3><%=message%></h3>

	<br>
	<br>

	<div>
		<form action="controller" method="post">
			<input type="hidden" name="command" value="do_sign_out" /> <input
				type="submit" value="To welcome page" />
		</form>
	</div>
</body>
</html>