<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<br>
	<br> ${cookie.warning.value}
	<br>
	<br>


	<div>
		<form action="controller" method="post">
			<input type="hidden" name="command" value="do_sign_out" /> <input
				type="submit" value="Log in again" /><br />
		</form>
	</div>

</body>
</html>