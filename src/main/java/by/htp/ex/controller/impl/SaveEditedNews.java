package by.htp.ex.controller.impl;

import java.io.IOException;

import by.htp.ex.bean.News;
import by.htp.ex.controller.Command;
import by.htp.ex.service.INewsService;
import by.htp.ex.service.ServiceException;
import by.htp.ex.service.ServiceProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SaveEditedNews implements Command {

	private final INewsService newsService = ServiceProvider.getInstance().getNewsService();
	private static final String ID_NEWS = "idNews";
	private static final String TITLE = "title";
	private static final String BRIEF_NEWS = "briefNews";
	private static final String CONTENT = "content";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession() == null) {
			response.addCookie(new Cookie("warning", "Log in again"));
			response.sendRedirect(request.getContextPath() + "/WEB-INF/pages/tiles/session-timeout-page.jsp");
		}
		int idNews = Integer.parseInt(request.getParameter(ID_NEWS));
		String title = request.getParameter(TITLE);
		String briefNews = request.getParameter(BRIEF_NEWS);
		String content = request.getParameter(CONTENT);

		News news = new News(idNews, title, briefNews, content);

		try {
			newsService.editNews(news);
			response.sendRedirect("controller?command=go_to_news_list");
		} catch (ServiceException e) {
			request.setAttribute("exception", e);
			String returnTo = "controller?command=go_to_edit_page&id=" + idNews;
			request.setAttribute("returnTo", returnTo);
			request.getRequestDispatcher("WEB-INF/pages/tiles/news-exception.jsp").forward(request, response);
		}
	}
}