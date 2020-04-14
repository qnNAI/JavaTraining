package by.training.finalproject.controller.command.impl;

import by.training.finalproject.beans.User;
import by.training.finalproject.beans.infoEnum.Role;
import by.training.finalproject.controller.command.Command;
import by.training.finalproject.controller.command.commandException.CommandException;
import by.training.finalproject.dao.DAOexception.DAOException;
import by.training.finalproject.service.UserService;
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
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        if(login != null && password != null) {
            User user;
            try {
                UserService service = factory.getUserService();
                user = service.checkUserByLoginPassword(login, password);
            } catch (ServiceException | DAOException e) {
                throw new CommandException(e);
            }

            if(user != null) {
                HttpSession session = request.getSession();
                session.setAttribute("authorizedUser", user);
                //session.setAttribute("menu", menu.get(user.getRole()));
                logger.info(String.format("user \"%s\" is logged in from %s (%s:%s)", login, request.getRemoteAddr(), request.getRemoteHost(), request.getRemotePort()));
                return new Forward("/menu.html");
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
