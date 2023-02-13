package by.htp.ex.service.impl;

import java.util.List;

import by.htp.ex.bean.News;
import by.htp.ex.dao.DaoProvider;
import by.htp.ex.dao.INewsDAO;
import by.htp.ex.dao.NewsDAOException;
import by.htp.ex.service.INewsService;
import by.htp.ex.service.ServiceException;
import by.htp.ex.util.validation.ValidationProvider;
import by.htp.ex.util.validation.impl.NewsValidatorImpl;

public class NewsServiceImpl implements INewsService {

	private final INewsDAO newsDAO = DaoProvider.getInstance().getNewsDAO();
	private final NewsValidatorImpl newsValidator = ValidationProvider.getInstance().getNewsValidator(); 
	
	@Override
	public List<News> latestList(int count) throws ServiceException {
		try {
			return newsDAO.getLatestsList(count);
		} catch (NewsDAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public List<News> list() throws ServiceException {
		try {
			return newsDAO.getList();
		} catch (NewsDAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public News findById(int id) throws ServiceException {
		try {
			return newsDAO.fetchById(id);
		} catch (NewsDAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void editNews(News news) throws ServiceException {
		try {
			newsDAO.editNews(news);
		} catch (NewsDAOException e) {
			throw new ServiceException(e);
		}

	}

	@Override
	public void deleteNews(int id) throws ServiceException {
		try {
			newsDAO.deleteNews(id);
		} catch (NewsDAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void deleteNewses(String[] idNewses) throws ServiceException {
		try {
			newsDAO.deleteNewses(idNewses);
		} catch (NewsDAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void addNews(News news) throws ServiceException {
		if(newsValidator.checkNews(news)) {
			try {
				newsDAO.addNews(news);
			} catch (NewsDAOException e) {
				throw new ServiceException(e);
			}
		}	
	}
}