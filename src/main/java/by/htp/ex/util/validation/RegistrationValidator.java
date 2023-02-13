package by.htp.ex.util.validation;

public interface RegistrationValidator extends Validator {
	String EMAIL_TEMPLATE_REGEX = "([.[^@\\\\s]]+)@([.[^@\\\\s]]+)\\\\.([a-z]+)";

	boolean checkRegistrationData(String login, String password, String email);
}