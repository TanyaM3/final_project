<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:setLocale value="${sessionScope.theLocale}" />
<fmt:setBundle basename="localization.locale" var="locale" />
<fmt:message bundle="${locale}" key="regPage.title" var="regPage_title" />
<fmt:message bundle="${locale}" key="regPage.userName"
	var="regPage_userName" />
<fmt:message bundle="${locale}" key="regPage.password"
	var="regPage_password" />
<fmt:message bundle="${locale}" key="regPage.email" var="regPage_email" />
<fmt:message bundle="${locale}" key="regPage.doRegister"
	var="regPage_doRegister" />
<fmt:message bundle="${locale}" key="regPage.backToMainPage"
	var="regPage_backToMainPage" />
<fmt:message bundle="${locale}" key="regPage.toLoginationPage"
	var="regPage_toLoginationPage" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${regPage_title}</title>
</head>
<body>
	<h1>${regPage_title}:</h1>

	<br>
	<br>

	<form action="controller" method="post">
		<input type="hidden" name="command" value="do_register" />
		<table>
			<tr>
				<td>${regPage_userName}:</td>
				<td><input type="text" name="userName" /></td>
			</tr>
			<tr>
				<td>${regPage_password}:</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td>${regPage_email}:</td>
				<td><input type="text" name="email" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="${regPage_doRegister}" /></td>
			</tr>
		</table>
	</form>

	<br>
	<br>

	<form action="controller" method="post">
		<input type="hidden" name="command" value="go_to_base_page" /> <input
			type="submit" value="${regPage_backToMainPage}" />
	</form>

	<br>
	<br>

	<form action="controller" method="post">
		<input type="hidden" name="command" value="go_to_logination_page" /> <input
			type="submit" value="${regPage_toLoginationPage}" />
	</form>



</body>
</html>
