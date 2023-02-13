package by.htp.ex.util.validation.impl;

import by.htp.ex.util.validation.RegistrationValidator;

public class RegistrationValidatorImpl implements RegistrationValidator {

	@Override
	public boolean checkRegistrationData(String login, String password, String email) {
		if (login.matches(LOGIN_TEMPLATE_REGEX) && password.matches(PASSWORD_TEMPLATE_REGEX)
				&& email.matches(EMAIL_TEMPLATE_REGEX)) {
			return true;
		} else {
			return false;
		}
	}
}