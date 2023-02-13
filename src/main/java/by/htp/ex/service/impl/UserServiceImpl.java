package by.htp.ex.service.impl;

import by.htp.ex.bean.User;
import by.htp.ex.dao.DaoException;
import by.htp.ex.dao.DaoProvider;
import by.htp.ex.dao.IUserDAO;
import by.htp.ex.dao.UserDAOException;
import by.htp.ex.service.ServiceException;
import by.htp.ex.util.validation.ValidationProvider;
import by.htp.ex.util.validation.impl.LoginationValidatorImpl;
import by.htp.ex.util.validation.impl.RegistrationValidatorImpl;
import by.htp.ex.service.IUserService;

public class UserServiceImpl implements IUserService {

	private final IUserDAO userDAO = DaoProvider.getInstance().getUserDao();
	private final LoginationValidatorImpl loginationValidator = ValidationProvider.getInstance()
			.getLoginationValidator();

	@Override
	public User signIn(String login, String password) throws ServiceException {
		User user = null;
		try {
			if (loginationValidator.checkLoginationData(login, password)) {
				user = userDAO.logination(login, password);
			}
		} catch (UserDAOException e) {
			throw new ServiceException(e);
		}
		return user;
	}

	private final RegistrationValidatorImpl registrationValidator = ValidationProvider.getInstance()
			.getRegistrationValidator();

	@Override
	public boolean registration(User user) throws ServiceException {
		String userName = user.getUsername();
		String password = user.getPassword();
		String email = user.getEmail();

		try {
			if (registrationValidator.checkRegistrationData(userName, password, email)) {
				if (userDAO.registration(user)) {
					return true;
				}
			}
		} catch (UserDAOException e) {
			throw new ServiceException(e);
		}
		return false;
	}

	@Override
	public String getRole(User user) throws ServiceException {
		String role = null;
		try {
			role = userDAO.getRole(user);
		} catch (UserDAOException e) {
			throw new ServiceException(e);
		}
		return role;
	}
}