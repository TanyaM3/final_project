package by.htp.ex.util.validation;

public interface LoginationValidator extends Validator {
	boolean checkLoginationData(String login, String password);
}