package by.htp.ex.util.validation;

import by.htp.ex.util.validation.impl.LoginationValidatorImpl;
import by.htp.ex.util.validation.impl.NewsValidatorImpl;
import by.htp.ex.util.validation.impl.RegistrationValidatorImpl;

public final class ValidationProvider {
	private static final ValidationProvider instance = new ValidationProvider();
	private LoginationValidatorImpl loginationValidator = new LoginationValidatorImpl();
	private RegistrationValidatorImpl registrationValidator = new RegistrationValidatorImpl();
	private NewsValidatorImpl newsValidator = new NewsValidatorImpl();
	
	private ValidationProvider() {

	}

	public static ValidationProvider getInstance() {
		return instance;
	}

	public LoginationValidatorImpl getLoginationValidator() {
		return loginationValidator;
	}

	public RegistrationValidatorImpl getRegistrationValidator() {
		return registrationValidator;
	}
	
	public NewsValidatorImpl getNewsValidator() {
		return newsValidator;
	}
	

}