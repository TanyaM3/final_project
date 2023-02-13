<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:setLocale value="${sessionScope.theLocale}" />
<fmt:setBundle basename="localization.locale" var="locale" />
<fmt:message bundle="${locale}" key="logPage.title" var="logPage_title" />
<fmt:message bundle="${locale}" key="logPage.userName"
	var="logPage_userName" />
<fmt:message bundle="${locale}" key="logPage.password"
	var="logPage_password" />
<fmt:message bundle="${locale}" key="logPage.doLogination"
	var="logPage_doLogination" />
<fmt:message bundle="${locale}" key="logPage.backToMainPage"
	var="logPage_backToMainPage" />


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${logPage_title}</title>
</head>
<body>
	<h1>${logPage_title}:</h1>

	<br>
	<br>

	<form action="controller" method="post">
		<input type="hidden" name="command" value="do_sign_in" />
		<table>
			<tr>
				<td>${logPage_userName}:</td>
				<td><input type="text" name="login" /></td>
			</tr>
			<tr>
				<td>${logPage_password}:</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="${logPage_doLogination}" /></td>
			</tr>
		</table>
	</form>

	<br>
	<br>

	<form action="controller" method="post">
		<input type="hidden" name="command" value="go_to_base_page" /> <input
			type="submit" value="${logPage_backToMainPage}" />
	</form>


</body>
</html>
