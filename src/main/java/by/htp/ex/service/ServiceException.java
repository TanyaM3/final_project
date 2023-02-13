package by.htp.ex.service;

public class ServiceException extends Exception {

	private static final long serialVersionUID = 1L;

	public ServiceException() {

	}

	public ServiceException(String e) {
		super(e);
	}

	public ServiceException(Exception e) {
		super(e);
	}

	public ServiceException(String s, Exception e) {
		super(s, e);
	}
}