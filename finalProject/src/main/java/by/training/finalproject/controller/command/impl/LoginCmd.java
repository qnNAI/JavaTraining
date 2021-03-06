package by.training.finalproject.controller.command.impl;

import by.training.finalproject.entity.User;
import by.training.finalproject.entity.infoEnum.Role;
import by.training.finalproject.controller.command.Command;
import by.training.finalproject.service.UserService;
import by.training.finalproject.service.factory.ServiceFactory;
import by.training.finalproject.service.serviceException.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Set;

public class LoginCmd extends Command {
    private static Logger logger = LogManager.getLogger(LoginCmd.class.getName());

    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response, ServiceFactory factory) {
        HttpSession session = request.getSession();
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        if (login != null && password != null && session.getAttribute("authorizedUser") == null) {
            User user;
            try {
                UserService service = factory.getUserService();
                user = service.findUserByLoginPassword(login, password);
            } catch (ServiceException e) {
                logger.error("Failed to authorize user", e);
                return new Forward("/error.jsp", false);
            }

            if(user != null) {
                session.setAttribute("authorizedUser", user);
                logger.info(String.format("user \"%s\" is logged in from %s (%s:%s)", login, request.getRemoteAddr(), request.getRemoteHost(), request.getRemotePort()));
                return new Forward("/main.html", true);
            } else {
                request.setAttribute("message", "Имя пользователя или пароль не опознаны");
                logger.info(String.format("user \"%s\" unsuccessfully tried to log in from %s (%s:%s)", login, request.getRemoteAddr(), request.getRemoteHost(), request.getRemotePort()));
            }
        }
        return null;
    }

    @Override
    public Set<Role> getAllowedRoles() {
        return null;
    }
}
