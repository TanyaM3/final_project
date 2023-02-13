<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:setLocale value="${sessionScope.theLocale}" />
<fmt:setBundle basename="localization.locale" var="locale" />
<fmt:message bundle="${locale}" key="editPage.newsLink"
	var="editPage_newsLink" />
<fmt:message bundle="${locale}" key="editPage.editNews"
	var="editPage_editNews" />
<fmt:message bundle="${locale}" key="editPage.newsTitle"
	var="editPage_newsTitle" />
<fmt:message bundle="${locale}" key="editPage.newsDate"
	var="editPage_newsDate" />
<fmt:message bundle="${locale}" key="editPage.brief"
	var="editPage_brief" />
<fmt:message bundle="${locale}" key="editPage.content"
	var="editPage_content" />
<fmt:message bundle="${locale}" key="editPage.saveButton"
	var="editPage_saveButton" />
<fmt:message bundle="${locale}" key="editPage.cancelButton"
	var="editPage_cancelButton" />

<div class="body-title">
	<a href="controller?command=go_to_news_list">${editPage_newsLink}
		>> </a> ${editPage_editNews}
</div>


<div class="add-table-margin">
	<form action="controller" method="post">

		<input type="hidden" name="command" value="save_edited_news" /> <input
			type="hidden" name="idNews" value="${requestScope.news.idNews}" />

		<table class="news_text_format">
			<tr>
				<td class="space_around_title_text">${editPage_newsTitle}</td>
				<td class="space_around_view_text">
					<div class="word-breaker">
						<input type="text" name="title" value="${requestScope.news.title}" />
					</div>
				</td>
			</tr>

			<tr>
				<td class="space_around_title_text">${editPage_newsDate}</td>
				<td class="space_around_view_text">
					<div class="word-breaker">
						<c:out value="${requestScope.news.newsDate}" />
					</div>
				</td>
			</tr>

			<tr>
				<td class="space_around_title_text">${editPage_brief}</td>
				<td class="space_around_view_text">
					<div class="word-breaker">
						<input type="text" name="briefNews"
							value="${requestScope.news.briefNews}" />
					</div>
				</td>
			</tr>
			<tr>
				<td class="space_around_title_text">${editPage_content}</td>
				<td class="space_around_view_text">
					<div class="word-breaker">
						<textarea rows="7" cols="60" name="content">
							${requestScope.news.content }
						</textarea>
					</div>
				</td>
			</tr>
		</table>


		<c:if test="${sessionScope.role eq 'admin'}">
			<div class="first-view-button">
				<input type="submit" value="${editPage_saveButton}" />
			</div>
		</c:if>

	</form>
</div>


<c:if test="${sessionScope.role eq 'admin'}">
	<div class="second-view-button">
		<form action="controller" method="post">
			<input type="hidden" name="command" value="go_to_news_list" /> <input
				type="submit" value="${editPage_cancelButton}" />
		</form>
	</div>
</c:if>