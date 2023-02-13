<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="by.htp.ex.service.ServiceException"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:setLocale value="${sessionScope.theLocale}" />
<fmt:setBundle basename="localization.locale" var="locale" />
<fmt:message bundle="${locale}" key="registrationStatusPage.title"
	var="registrationStatusPage_title" />
<fmt:message bundle="${locale}" key="registrationStatusPage.success"
	var="registrationStatusPage_success" />
<fmt:message bundle="${locale}"
	key="registrationStatusPage.enterLoginAndPass"
	var="registrationStatusPage_enterLoginAndPass" />
<fmt:message bundle="${locale}" key="registrationStatusPage.doHere"
	var="registrationStatusPage_doHere" />
<fmt:message bundle="${locale}"
	key="registrationStatusPage.back2MainPage"
	var="registrationStatusPage_back2MainPage" />
<fmt:message bundle="${locale}"
	key="registrationStatusPage.toLoginationPage.noNews"
	var="registrationStatusPage_toLoginationPage" />
<fmt:message bundle="${locale}" key="registrationStatusPage.orHere"
	var="registrationStatusPage_orHere" />
<fmt:message bundle="${locale}" key="registrationStatusPage.sorry"
	var="registrationStatusPage_sorry" />
<fmt:message bundle="${locale}"
	key="registrationStatusPage.incorrectData"
	var="registrationStatusPage_incorrectData" />
<fmt:message bundle="${locale}"
	key="registrationStatusPage.toRegistrationPage.noNews"
	var="registrationStatusPage_toRegistrationPage" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${registrationStatusPage_title}</title>
</head>
<body>

	<c:if test="${requestScope.regStatus eq 'ok'}">
		<h2>${registrationStatusPage_success}</h2>
		<h2>${registrationStatusPage_enterLoginAndPass}</h2>
		<br>
		<br>
		<h2>${registrationStatusPage_doHere}</h2>
		<form action="controller" method="post">
			<input type="hidden" name="command" value="go_to_base_page" /> <input
				type="submit" value="${registrationStatusPage_back2MainPage}" />
		</form>
		<br>
		<br>
		<h2>${registrationStatusPage_orHere}</h2>
		<form action="controller" method="post">
			<input type="hidden" name="command" value="go_to_logination_page" />
			<input type="submit"
				value="${registrationStatusPage_toLoginationPage}" />
		</form>
	</c:if>

	<c:if test="${requestScope.regStatus eq 'notOk'}">
		<h2>${registrationStatusPage_sorry}</h2>
		<h2>${registrationStatusPage_incorrectData}</h2>
		<a href="controller?command=go_to_registration_page">${registrationStatusPage_toRegistrationPage}</a>
		<br>
		<br>
		<form action="controller" method="post">
			<input type="hidden" name="command" value="go_to_base_page" /> <input
				type="submit" value="${registrationStatusPage_back2MainPage}" />
		</form>
	</c:if>

</body>
</html>