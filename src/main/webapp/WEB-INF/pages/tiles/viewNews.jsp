<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:setLocale value="${sessionScope.theLocale}" />
<fmt:setBundle basename="localization.locale" var="locale" />
<fmt:message bundle="${locale}" key="viewPage.newsLink"
	var="viewPage_newsLink" />
<fmt:message bundle="${locale}" key="viewPage.viewNews"
	var="viewPage_viewNews" />
<fmt:message bundle="${locale}" key="viewPage.newsTitle"
	var="viewPage_newsTitle" />
<fmt:message bundle="${locale}" key="viewPage.newsDate"
	var="viewPage_newsDate" />
<fmt:message bundle="${locale}" key="viewPage.brief"
	var="viewPage_brief" />
<fmt:message bundle="${locale}" key="viewPage.content"
	var="viewPage_content" />
<fmt:message bundle="${locale}" key="viewPage.editButton"
	var="viewPage_editButton" />
<fmt:message bundle="${locale}" key="viewPage.deleteButton"
	var="viewPage_deleteButton" />
<script type="text/javascript">
	function checkDelete() {
		if (confirm("Are you sure?")) {
			return true;
		} else {
			return false;
		}
	}
</script>
<div class="body-title">
	<a href="controller?command=go_to_news_list">${viewPage_newsLink}
		>> </a> ${viewPage_viewNews}

	<div class="add-table-margin">
		<table class="news_text_format">
			<tr>
				<td class="space_around_title_text">${viewPage_newsTitle}</td>

				<td class="space_around_view_text"><div class="word-breaker">
						<c:out value="${requestScope.news.title }" />
					</div></td>
			</tr>
			<tr>
				<td class="space_around_title_text">${viewPage_newsDate}</td>

				<td class="space_around_view_text"><div class="word-breaker">
						<c:out value="${requestScope.news.newsDate }" />
					</div></td>
			</tr>
			<tr>
				<td class="space_around_title_text">${viewPage_brief}</td>
				<td class="space_around_view_text"><div class="word-breaker">
						<c:out value="${requestScope.news.briefNews }" />
					</div></td>
			</tr>
			<tr>
				<td class="space_around_title_text">${viewPage_content}</td>
				<td class="space_around_view_text"><div class="word-breaker">
						<c:out value="${requestScope.news.content }" />
					</div></td>
			</tr>
		</table>
	</div>


	<c:if test="${sessionScope.role eq 'admin'}">
		<div class="first-view-button">
			<form action="controller" method="get">
				<input type="hidden" name="command" value="go_to_edit_page" /> <input
					type="hidden" name="id" value="${requestScope.news.idNews}" /> <input
					type="submit" value="${viewPage_editButton}" />
			</form>
		</div>

		<div class="second-view-button">
			<form action="controller" method="post"
				onsubmit="return checkDelete()">
				<input type="hidden" name="command" value="delete_news" /> <input
					type="hidden" name="id" value="${requestScope.news.idNews}" /> <input
					type="submit" value="${viewPage_deleteButton}" />
			</form>
		</div>
	</c:if>