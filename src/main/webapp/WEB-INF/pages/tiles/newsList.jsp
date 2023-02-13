<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:setLocale value="${sessionScope.theLocale}" />
<fmt:setBundle basename="localization.locale" var="locale" />
<fmt:message bundle="${locale}" key="newsList.newsLink"
	var="newsList_newsLink" />
<fmt:message bundle="${locale}" key="newsList.newsList"
	var="newsList_newsList" />
<fmt:message bundle="${locale}" key="newsList.viewLink"
	var="newsList_viewLink" />
<fmt:message bundle="${locale}" key="newsList.editLink"
	var="newsList_editLink" />
<fmt:message bundle="${locale}" key="newsList.deleteNewsesButton"
	var="newsList_deleteNewsesButton" />
<fmt:message bundle="${locale}" key="newsList.noNews"
	var="newsList_noNews" />


<script type="text/javascript">
	function checkDelete() {
		if (confirm('Are you sure?')) {
			return true;
		} else {
			return false;
		}
	};
</script>
<div class="body-title">
	<a href="controller?command=go_to_news_list">${newsList_newsLink}
		>> </a> ${newsList_newsList}
</div>

<form action="controller" method="post" onsubmit="return checkDelete()">
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
				<div class="news-link-to-wrapper">
					<div class="link-position">
						<c:if test="${sessionScope.role eq 'admin'}">
							<a href="controller?command=go_to_edit_page&id=${news.idNews}">${newsList_editLink}
							</a>
						</c:if>

						<a href="controller?command=go_to_view_news&id=${news.idNews}">${newsList_viewLink}
						</a>

						<c:if test="${sessionScope.role eq 'admin'}">
							<input type="checkbox" name="idNews" value="${news.idNews }" />
						</c:if>
					</div>
				</div>



			</div>
		</div>

	</c:forEach>

	<br> <br>
	<c:if test="${sessionScope.role eq 'admin'}">
		<input type="submit" value="${newsList_deleteNewsesButton}" />
	</c:if>
	<!-- 	<logic:notEmpty name="newsForm" property="newsList">
		<div class="delete-button-position">
			<html:submit>
				<bean:message key="locale.newslink.deletebutton" />
			</html:submit>
		</div>
	</logic:notEmpty> -->

	<div class="no-news">
		<c:if test="${requestScope.news eq null}">
        ${newsList_noNews}
	</c:if>
	</div>
</form>
