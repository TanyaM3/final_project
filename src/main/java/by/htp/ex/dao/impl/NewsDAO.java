package by.htp.ex.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.htp.ex.bean.News;
import by.htp.ex.dao.INewsDAO;
import by.htp.ex.dao.NewsDAOException;
import by.htp.ex.dao.pool.ConnectionPool;
import by.htp.ex.dao.pool.ConnectionPoolException;

public class NewsDAO implements INewsDAO {
	private static final ConnectionPool connectionPool = ConnectionPool.getInstance();
	private static final String GET_LIST_SQL = "SELECT * FROM news ORDER BY pub_date DESC";

	@Override
	public List<News> getList() throws NewsDAOException {
		List<News> result = new ArrayList<News>();

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {

			connection = connectionPool.takeConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(GET_LIST_SQL);

			while (resultSet.next()) {
				int idNews = resultSet.getInt("news_id");
				Date tempDate = resultSet.getDate("pub_date");
				String newsDate = tempDate.toString();
				String briefNews = resultSet.getString("brief");
				String content = resultSet.getString("content");
				int userId = resultSet.getInt("user_id");
				String title = resultSet.getString("title");
				result.add(new News(idNews, title, briefNews, content, newsDate, userId));
			}

		} catch (ConnectionPoolException | SQLException e) {
			throw new NewsDAOException("Can't show the last news", e);
		} finally {
			try {
				connectionPool.closeConnection(connection, statement, resultSet);
			} catch (ConnectionPoolException e) {
				throw new NewsDAOException(e);
			}
		}
		return result;
	}

	private static final String FETCH_BY_ID_SQL = "SELECT * FROM news WHERE news_id = ?";

	@Override
	public News fetchById(int id) throws NewsDAOException {
		News news = null;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {

			connection = connectionPool.takeConnection();
			preparedStatement = connection.prepareStatement(FETCH_BY_ID_SQL);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				int idNews = resultSet.getInt("news_id");
				Date tempDate = resultSet.getDate("pub_date");
				String newsDate = tempDate.toString();
				String briefNews = resultSet.getString("brief");
				String content = resultSet.getString("content");
				int userId = resultSet.getInt("user_id");
				String title = resultSet.getString("title");
				news = new News(idNews, title, briefNews, content, newsDate, userId);
			}

		} catch (ConnectionPoolException | SQLException e) {
			throw new NewsDAOException("Can't find the news", e);
		} finally {
			try {
				connectionPool.closeConnection(connection, preparedStatement, resultSet);
			} catch (ConnectionPoolException e) {
				throw new NewsDAOException(e);
			}
		}

		return news;
	}

	private static final String INSERT_NEWS_SQL = "INSERT INTO news (brief, content, title, user_id) VALUES (?, ?, ?, ?)";

	@Override
	public void addNews(News news) throws NewsDAOException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {

			connection = connectionPool.takeConnection();
			preparedStatement = connection.prepareStatement(INSERT_NEWS_SQL);
			preparedStatement.setString(1, news.getBriefNews());
			preparedStatement.setString(2, news.getContent());
			preparedStatement.setString(3, news.getTitle());
			preparedStatement.setInt(4, news.getUserId());
			preparedStatement.executeUpdate();

		} catch (ConnectionPoolException | SQLException e) {
			throw new NewsDAOException("Can't add the news", e);
		} finally {
			try {
				connectionPool.closeConnection(connection, preparedStatement);
			} catch (ConnectionPoolException e) {
				throw new NewsDAOException(e);
			}
		}
	}

	@Override
	public void deleteNewses(String[] idNewses) throws NewsDAOException {
		for (int i = 0; i < idNewses.length; i++) {
			deleteNews(Integer.parseInt(idNewses[i]));
		}
	}

	private static final String SAVE_EDITED_NEWS_SQL = "UPDATE news " + "SET brief = ?, " + "content = ?, "
			+ "title = ? " + "WHERE news_id = ?";

	@Override
	public void editNews(News news) throws NewsDAOException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {

			connection = connectionPool.takeConnection();
			preparedStatement = connection.prepareStatement(SAVE_EDITED_NEWS_SQL);
			preparedStatement.setString(1, news.getBriefNews());
			preparedStatement.setString(2, news.getContent());
			preparedStatement.setString(3, news.getTitle());
			preparedStatement.setInt(4, news.getIdNews());
			preparedStatement.executeUpdate();

		} catch (ConnectionPoolException | SQLException e) {
			throw new NewsDAOException("Can't edit the news", e);
		} finally {
			try {
				connectionPool.closeConnection(connection, preparedStatement);
			} catch (ConnectionPoolException e) {
				throw new NewsDAOException(e);
			}
		}
	}

	private static final String DELETE_BY_ID_SQL = "DELETE FROM news WHERE news_id = ?";

	@Override
	public void deleteNews(int id) throws NewsDAOException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = connectionPool.takeConnection();
			preparedStatement = connection.prepareStatement(DELETE_BY_ID_SQL);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();

		} catch (ConnectionPoolException | SQLException e) {
			throw new NewsDAOException("Can't delete the news", e);
		} finally {
			try {
				connectionPool.closeConnection(connection, preparedStatement);
			} catch (ConnectionPoolException e) {
				throw new NewsDAOException(e);
			}
		}
	}

	private static final String GET_LATEST_LIST_SQL = "SELECT * FROM news ORDER BY pub_date DESC LIMIT ?";

	@Override
	public List<News> getLatestsList(int count) throws NewsDAOException {
		List<News> result = new ArrayList<News>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = connectionPool.takeConnection();
			preparedStatement = connection.prepareStatement(GET_LATEST_LIST_SQL);
			preparedStatement.setInt(1, count);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int idNews = resultSet.getInt("news_id");
				Date tempDate = resultSet.getDate("pub_date");
				String newsDate = tempDate.toString();
				String briefNews = resultSet.getString("brief");
				String content = resultSet.getString("content");
				int userId = resultSet.getInt("user_id");
				String title = resultSet.getString("title");
				result.add(new News(idNews, title, briefNews, content, newsDate, userId));
			}

		} catch (ConnectionPoolException | SQLException e) {
			throw new NewsDAOException("Can't get the latest news", e);
		} finally {
			try {
				connectionPool.closeConnection(connection, preparedStatement, resultSet);
			} catch (ConnectionPoolException e) {
				throw new NewsDAOException(e);
			}
		}

		return result;
	}
}