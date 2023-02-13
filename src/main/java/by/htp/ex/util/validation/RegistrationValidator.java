package by.htp.ex.util.validation;

public interface RegistrationValidator extends Validator {
	boolean checkRegistrationData(String login, String password, String email);
}
