package by.htp.ex.util.validation;

public interface Validator {
	String LOGIN_TEMPLATE_REGEX = "\\w{4,16}";
	String PASSWORD_TEMPLATE_REGEX = "\\w{4,8}";
	String EMAIL_TEMPLATE_REGEX = "([.[^@\\\\s]]+)@([.[^@\\\\s]]+)\\\\.([a-z]+)";
}
