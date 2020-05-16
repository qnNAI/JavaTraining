package by.training.finalproject.controller.filter;

import by.training.finalproject.beans.User;
import by.training.finalproject.beans.infoEnum.Role;
import by.training.finalproject.controller.command.Command;
import by.training.finalproject.controller.command.impl.MainCmd;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SecurityFilter implements Filter {
	private static Logger logger = LogManager.getLogger(SecurityFilter.class.getName());

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		if(request instanceof HttpServletRequest && response instanceof HttpServletResponse) {
			HttpServletRequest httpRequest = (HttpServletRequest)request;
			HttpServletResponse httpResponse = (HttpServletResponse)response;
			Command command = (Command)httpRequest.getAttribute("command");
			Set<Role> allowedRoles = command.getAllowedRoles();
			String userName = "unauthorized user";
			HttpSession session = httpRequest.getSession(false);
			User user = null;
			if(session != null) {
				user = (User)session.getAttribute("authorizedUser");
				String errorMessage = (String)session.getAttribute("SecurityFilterMessage");
				if(errorMessage != null) {
					httpRequest.setAttribute("message", errorMessage);
					session.removeAttribute("SecurityFilterMessage");
				}
			}
			boolean canExecute = allowedRoles == null;
			if(user != null) {
				userName = "\"" + user.getLogin() + "\" user";
				canExecute = canExecute || allowedRoles.contains(user.getRole());
			}
			if(canExecute) {
				chain.doFilter(request, response);
			} else {
				logger.info(String.format("Trying of %s access to forbidden resource \"%s\"", userName, command.getName()));
				if(session != null && command.getClass() != MainCmd.class) {
					session.setAttribute("SecurityFilterMessage", "Доступ запрещён");
				}
				httpResponse.sendRedirect(httpRequest.getContextPath() + "/login.html");
			}
		} else {
			logger.error("It is impossible to use HTTP filter");
			request.getServletContext().getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
		}
	}

	@Override
	public void destroy() {}
}
