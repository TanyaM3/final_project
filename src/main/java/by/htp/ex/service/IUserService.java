package by.htp.ex.service;

import by.htp.ex.bean.User;

public interface IUserService {

	User signIn(String login, String password) throws ServiceException;

	boolean registration(User user) throws ServiceException;

	String getRole(User user) throws ServiceException;
}