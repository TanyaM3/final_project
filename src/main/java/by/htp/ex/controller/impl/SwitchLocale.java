package by.htp.ex.controller.impl;

import java.io.IOException;


import by.htp.ex.controller.Command;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class SwitchLocale implements Command{
	private static final String LOCALE = "locale";
	private static final String URL = "url";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String theLocale = request.getParameter(LOCALE);
		HttpSession session = request.getSession(true);
		session.setAttribute("theLocale", theLocale);		
		String redirectTo = (String)session.getAttribute(URL);
		response.sendRedirect(redirectTo);
	}
}