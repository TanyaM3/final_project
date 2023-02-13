<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="by.htp.ex.service.ServiceException"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:setLocale value="${sessionScope.theLocale}" />
<fmt:setBundle basename="localization.locale" var="locale" />
<fmt:message bundle="${locale}" key="registrationExceptionPage.sorry"
	var="registrationExceptionPage_sorry" />
<fmt:message bundle="${locale}" key="registrationExceptionPage.back"
	var="registrationExceptionPage_back" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<%
	ServiceException exception = (ServiceException) request.getAttribute("exception");
	String returnTo = (String) request.getAttribute("returnTo");
	%>

	<h3>${registrationExceptionPage_sorry}</h3>

	<br>
	<br>
	<%=exception.getMessage()%>
	<br>
	<br>

	<div>
		<a href="<%=returnTo%>">${registrationExceptionPage_back}</a>
	</div>


</body>
</html>