package by.htp.ex.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import by.htp.ex.bean.User;
import by.htp.ex.dao.IUserDAO;
import by.htp.ex.dao.UserDAOException;
import by.htp.ex.dao.pool.ConnectionPool;
import by.htp.ex.dao.pool.ConnectionPoolException;

public class UserDAO implements IUserDAO {

	private final ConnectionPool connectionPool = ConnectionPool.getInstance();

	private final String LOGINATION_SQL = "SELECT * FROM user WHERE user_name = ? AND password = ?";

	@Override
	public User logination(String login, String password) throws UserDAOException {
		User user = null;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = connectionPool.takeConnection();
			preparedStatement = connection.prepareStatement(LOGINATION_SQL);
			preparedStatement.setString(1, login);
			preparedStatement.setString(2, password);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				String role = resultSet.getString("role");
				int userId = resultSet.getInt("user_id");
				user = new User(role, userId);
			}
		} catch (ConnectionPoolException | SQLException e) {
			throw new UserDAOException("Can't sign in the user");
		} finally {
			try {
				connectionPool.closeConnection(connection, preparedStatement, resultSet);
			} catch (ConnectionPoolException e) {
				throw new UserDAOException(e);
			}
		}

		return user;
	}

	private final String REGISTRATION_SQL = "INSERT INTO user (user_name, password, email) VALUES (?, ?, ?)";

	@Override
	public boolean registration(User user) throws UserDAOException {
		if (checkUser(user)) {
			Connection connection = null;
			PreparedStatement preparedStatement = null;

			try {
				connection = connectionPool.takeConnection();
				preparedStatement = connection.prepareStatement(REGISTRATION_SQL);
				preparedStatement.setString(1, user.getUsername());
				preparedStatement.setString(2, user.getPassword());
				preparedStatement.setString(3, user.getEmail());
				int rows = preparedStatement.executeUpdate();

				if (rows > 0) {
					return true;
				} else {
					return false;
				}

			} catch (ConnectionPoolException | SQLException e) {
				throw new UserDAOException("Can't register a new user", e);
			} finally {
				try {
					connectionPool.closeConnection(connection, preparedStatement);
				} catch (ConnectionPoolException e) {
					throw new UserDAOException(e);
				}
			}

		} else {
			return false;
		}
	}

	private final String CHECK_USER_SQL = "SELECT * FROM user WHERE user_name = ? AND email = ?";

	private boolean checkUser(User user) throws UserDAOException {

		boolean isUserPresentInDatabase = false;

		String userName = user.getUsername();
		String email = user.getEmail();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {

			connection = connectionPool.takeConnection();
			preparedStatement = connection.prepareStatement(CHECK_USER_SQL);

			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, email);

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				return isUserPresentInDatabase;
			} else {
				isUserPresentInDatabase = true;
				return isUserPresentInDatabase;
			}

		} catch (ConnectionPoolException | SQLException e) {
			throw new UserDAOException("Can't check the user", e);
		} finally {
			try {
				connectionPool.closeConnection(connection, preparedStatement, resultSet);
			} catch (ConnectionPoolException e) {
				throw new UserDAOException(e);
			}
		}
	}

	private final String GET_ROLE_SQL = "SELECT * FROM user WHERE user_name = ?";

	@Override
	public String getRole(User user) throws UserDAOException {
		String role = null;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = connectionPool.takeConnection();
			preparedStatement = connection.prepareStatement(GET_ROLE_SQL);
			preparedStatement.setString(1, user.getUsername());
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				role = resultSet.getString("role");
			}
		} catch (ConnectionPoolException | SQLException e) {
			throw new UserDAOException("Can't find the role", e);
		} finally {
			try {
				connectionPool.closeConnection(connection, preparedStatement);
			} catch (ConnectionPoolException e) {
				throw new UserDAOException(e);
			}
		}

		return role;
	}
}