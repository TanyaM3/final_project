package by.htp.ex.controller.impl;

import java.io.IOException;

import by.htp.ex.bean.News;
import by.htp.ex.controller.Command;
import by.htp.ex.service.INewsService;
import by.htp.ex.service.ServiceException;
import by.htp.ex.service.ServiceProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GoToEditPage implements Command {

	private final INewsService newsService = ServiceProvider.getInstance().getNewsService();
	private final String ID = "id";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		News news = null;
		int idNews = Integer.parseInt(request.getParameter(ID));

		try {
			String path = request.getContextPath() + "/controller?command=go_to_edit_page&id=" + idNews;
			request.getSession(true).setAttribute("url", path);
			news = newsService.findById(idNews);
			request.setAttribute("news", news);
			request.setAttribute("presentation", "editNews");
			request.getRequestDispatcher("WEB-INF/pages/layouts/baseLayout.jsp").forward(request, response);
		} catch (ServiceException e) {
			request.setAttribute("exception", e);
			String returnTo = "controller?command=go_to_news_list";
			request.setAttribute("returnTo", returnTo);
			request.getRequestDispatcher("WEB-INF/pages/tiles/news-exception.jsp").forward(request, response);
		}

	}
}