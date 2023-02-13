package by.htp.ex.util.validation.impl;

import by.htp.ex.bean.User;
import by.htp.ex.util.validation.UserDataValidation;

public class UserDataValidationImpl implements UserDataValidation{
	@Override
	public boolean checkAUthData(String login, String password) {
		return false;
	}
}