<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:setLocale value="${sessionScope.theLocale}" />
<fmt:setBundle basename="localization.locale" var="locale" />
<fmt:message bundle="${locale}" key="addNewsPage.newsLink"
	var="addNewsPage_newsLink" />
<fmt:message bundle="${locale}" key="addNewsPage.addNews"
	var="addNewsPage_addNews" />
<fmt:message bundle="${locale}" key="addNewsPage.newsTitle"
	var="addNewsPage_newsTitle" />
<fmt:message bundle="${locale}" key="addNewsPage.brief"
	var="addNewsPage_brief" />
<fmt:message bundle="${locale}" key="addNewsPage.content"
	var="addNewsPage_content" />
<fmt:message bundle="${locale}" key="addNewsPage.addNewsButton"
	var="addNewsPage_addNewsButton" />
<fmt:message bundle="${locale}" key="addNewsPage.cancelButton"
	var="addNewsPage_cancelButton" />

<div class="body-title">
	<a href="controller?command=go_to_news_list">${addNewsPage_newsLink}
		>> </a> ${addNewsPage_addNews}
</div>


<div class="add-table-margin">
	<form action="controller" method="post">

		<input type="hidden" name="command" value="add_news" />

		<table class="news_text_format">
			<tr>
				<td class="space_around_title_text">${addNewsPage_newsTitle}</td>
				<td class="space_around_view_text">
					<div class="word-breaker">
						<input type="text" name="title" />
					</div>
				</td>
			</tr>

			<tr>
				<td class="space_around_title_text">${addNewsPage_brief}</td>
				<td class="space_around_view_text">
					<div class="word-breaker">
						<input type="text" name="briefNews" />
					</div>
				</td>
			</tr>
			<tr>
				<td class="space_around_title_text">${addNewsPage_content}</td>
				<td class="space_around_view_text">
					<div class="word-breaker">
						<textarea rows="7" cols="60" name="content">
							
						</textarea>
					</div>
				</td>
			</tr>
		</table>

		<c:if test="${sessionScope.role eq 'admin'}">
			<div class="first-view-button">
				<input type="submit" value="${addNewsPage_addNewsButton}" />
			</div>
		</c:if>

	</form>
</div>

<c:if test="${sessionScope.role eq 'admin'}">
	<div class="second-view-button">
		<form action="controller" method="post">
			<input type="hidden" name="command" value="go_to_news_list" /> <input
				type="submit" value="${addNewsPage_cancelButton}" />
		</form>
	</div>
</c:if>
