package by.htp.ex.controller.impl;

import java.io.IOException;

import by.htp.ex.bean.User;
import by.htp.ex.controller.Command;
import by.htp.ex.service.IUserService;
import by.htp.ex.service.ServiceException;
import by.htp.ex.service.ServiceProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DoRegister implements Command {

	private final IUserService userService = ServiceProvider.getInstance().getUserService();
	private static final String USER_NAME = "userName";
	private static final String PASSWORD = "password";
	private static final String EMAIL = "email";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter(USER_NAME);
		String password = request.getParameter(PASSWORD);
		String email = request.getParameter(EMAIL);

		User user = new User(userName, password, email);
		try {
			boolean isRegistered = userService.registration(user);

			if (isRegistered) {
				request.setAttribute("regStatus", "ok");
				request.getRequestDispatcher("WEB-INF/pages/tiles/registration-status.jsp").forward(request, response);
			} else {
				request.setAttribute("regStatus", "notOk");
				request.getRequestDispatcher("WEB-INF/pages/tiles/registration-status.jsp").forward(request, response);
			}
		} catch (ServiceException e) {
			request.setAttribute("exception", e);
			String returnTo = "controller?command=go_to_registration_page";
			request.setAttribute("returnTo", returnTo);
			request.getRequestDispatcher("WEB-INF/pages/tiles/registration-exception.jsp").forward(request, response);
		}
	}

}
