<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<fmt:setLocale value="${sessionScope.theLocale}" />
<fmt:setBundle basename="localization.locale" var="locale" />
<fmt:message bundle="${locale}" key="header.appName"
	var="header_appName" />
<fmt:message bundle="${locale}" key="header.en" var="header_en" />
<fmt:message bundle="${locale}" key="header.ru" var="header_ru" />
<fmt:message bundle="${locale}" key="header.regLink"
	var="header_regLink" />
<fmt:message bundle="${locale}" key="header.signinButton"
	var="header_signinButton" />
<fmt:message bundle="${locale}" key="header.signoutButton"
	var="header_signoutButton" />
<fmt:message bundle="${locale}" key="header.enterLogin"
	var="header_enterLogin" />
<fmt:message bundle="${locale}" key="header.enterPassword"
	var="header_enterPassword" />
<div class="wrapper">
	<div class="newstitle">${header_appName}</div>


	<div class="local-link">

		<div align="right">
			<a href="controller?command=switch_locale&locale=en">
				${header_en} </a> &nbsp;&nbsp; <a
				href="controller?command=switch_locale&locale=ru"> ${header_ru}
			</a> <br /> <br />
		</div>

		<c:if test="${not (sessionScope.user eq 'active')}">

			<div align="right">
				<form action="controller" method="post">
					<input type="hidden" name="command" value="do_sign_in" />
					${header_enterLogin}: <input type="text" name="login" value=""
						required="required" /><br /> ${header_enterPassword}: <input
						type="password" name="password" value="" required="required" /><br />

					<c:if test="${not (requestScope.AuthenticationError eq null)}">
						<font color="red"> <c:out
								value="${requestScope.AuthenticationError}" />
						</font>
					</c:if>

					<a href="controller?command=go_to_registration_page">${header_regLink}</a>
					<input type="submit" value="${header_signinButton}" /><br />
				</form>
			</div>

		</c:if>

		<c:if test="${sessionScope.user eq 'active'}">

			<div align="right">
				<form action="controller" method="post">
					<input type="hidden" name="command" value="do_sign_out" /> <input
						type="submit" value="${header_signoutButton}" /><br />
				</form>
			</div>

		</c:if>
	</div>

</div>
