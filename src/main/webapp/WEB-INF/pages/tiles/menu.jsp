<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:setLocale value="${sessionScope.theLocale}" />
<fmt:setBundle basename="localization.locale" var="locale" />
<fmt:message bundle="${locale}" key="menu.title" var="menu_title" />
<fmt:message bundle="${locale}" key="menu.newsListLink"
	var="menu_newsListLink" />
<fmt:message bundle="${locale}" key="menu.addNewsLink"
	var="menu_addNewsLink" />


<div class="menu-wrapper">
	<div class="menu-title-wrapper">
		<div class="menu-title">${menu_title}</div>
	</div>

	<div class="list-menu-invisible-wrapper">
		<div class="list-menu-wrapper" style="float: right;">
			<ul style="list-style-image: url(images/img.jpg); text-align: left;">
				<li style="padding-left: 15px;"><a
					href="controller?command=go_to_news_list">${menu_newsListLink}</a><br />
				</li>

				<c:if test="${sessionScope.role eq 'admin'}">
					<li style="padding-left: 15px;"><a
						href="controller?command=go_to_add_news_page">${menu_addNewsLink}
					</a> <br /></li>
				</c:if>
			</ul>
		</div>
		<div class="clear"></div>
	</div>
	<div style="height: 25px;"></div>
</div>

