package by.htp.ex.service;

import java.util.List;

import by.htp.ex.bean.News;

public interface INewsService {

	List<News> latestList(int count) throws ServiceException;

	List<News> list() throws ServiceException;

	News findById(int id) throws ServiceException;

	void editNews(News news) throws ServiceException;

	void deleteNews(int id) throws ServiceException;

	void deleteNewses(String[] idNewses) throws ServiceException;

	void addNews(News news) throws ServiceException;
}