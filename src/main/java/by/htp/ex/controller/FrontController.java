package by.htp.ex.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final CommandProvider provider = new CommandProvider();

	public FrontController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doAction(request, response);
	}

	private static final String COMMAND = "command";

	private void doAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String commandName = request.getParameter(COMMAND);
			Command command = provider.getCommand(commandName);
			command.execute(request, response);
		} catch (Exception e) {
			String exc = e.getClass().getSimpleName();
			request.setAttribute("message", "Error " + exc);
			request.getRequestDispatcher("WEB-INF/pages/tiles/front-controller-exception.jsp").forward(request,
					response);
		}
	}
}