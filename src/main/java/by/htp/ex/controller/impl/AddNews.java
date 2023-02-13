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

public class AddNews implements Command {

	private final INewsService newsService = ServiceProvider.getInstance().getNewsService();

	private static final String TITLE = "title";
	private static final String BRIEF = "briefNews";
	private static final String CONTENT = "content";
	private static final String USER_ID = "userId";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession() == null) {
			response.addCookie(new Cookie("warning", "Please, log in again"));
			response.sendRedirect(request.getContextPath() + "/WEB-INF/pages/tiles/session-timeout-page.jsp");
		}

		String title = request.getParameter(TITLE);
		String brief = request.getParameter(BRIEF);
		String content = request.getParameter(CONTENT);
		Integer userId = (Integer) request.getSession().getAttribute(USER_ID);
		News news = new News(title, brief, content, userId);

		try {
			newsService.addNews(news);
			response.sendRedirect("controller?command=go_to_news_list");
		} catch (ServiceException e) {
			request.setAttribute("exception", e);
			String returnTo = "controller?command=go_to_add_news_page";
			request.setAttribute("returnTo", returnTo);
			request.getRequestDispatcher("WEB-INF/pages/tiles/news-exception.jsp").forward(request, response);
		}
	}
}