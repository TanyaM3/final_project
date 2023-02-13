<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:setLocale value="${sessionScope.theLocale}" />
<fmt:setBundle basename="localization.locale" var="locale" />
<fmt:message bundle="${locale}" key="guestInfo.newsLink"
	var="guestInfo_newsLink" />
<fmt:message bundle="${locale}" key="guestInfo.latestNews"
	var="guestInfo_latestNews" />
<fmt:message bundle="${locale}" key="guestInfo.noNews"
	var="guestInfo_noNews" />

<div class="body-title">
	<a href="controller?command=go_to_base_page">${guestInfo_newsLink}
		>> </a> ${guestInfo_latestNews}
</div>

<form action="command.do?method=delete" method="post">
	<c:forEach var="news" items="${requestScope.news}">
		<div class="single-news-wrapper">
			<div class="single-news-header-wrapper">
				<div class="news-title">
					<c:out value="${news.title}" />
				</div>
				<div class="news-date">
					<c:out value="${news.newsDate}" />
				</div>

				<div class="news-content">
					<c:out value="${news.briefNews}" />
				</div>
			</div>
		</div>

	</c:forEach>

	<div class="no-news">
		<c:if test="${requestScope.news eq null}">
        ${guestInfo_noNews}
	</c:if>
	</div>

</form>
