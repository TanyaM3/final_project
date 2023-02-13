<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="by.htp.ex.service.ServiceException"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:setLocale value="${sessionScope.theLocale}" />
<fmt:setBundle basename="localization.locale" var="locale" />
<fmt:message bundle="${locale}" key="loginationExceptionPage.back"
	var="loginationExceptionPage_back" />

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


	<br>
	<br>
	<%=exception.getMessage()%>
	<br>
	<br>

	<div>
		<a href="<%=returnTo%>">${loginationExceptionPage_back}</a>
	</div>

</body>
</html>