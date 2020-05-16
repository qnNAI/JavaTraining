package by.training.finalproject.controller.command.impl;

import by.training.finalproject.beans.User;
import by.training.finalproject.beans.infoEnum.Role;
import by.training.finalproject.controller.command.Command;
import by.training.finalproject.controller.command.commandException.CommandException;
import by.training.finalproject.dao.DAOexception.DAOException;
import by.training.finalproject.service.UserService;
import by.training.finalproject.service.factory.ServiceFactory;
import by.training.finalproject.service.serviceException.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Set;

public class RegistrationCmd extends Command {
    private static Logger logger = LogManager.getLogger(RegistrationCmd.class.getName());

    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response, ServiceFactory factory) throws CommandException {
        HttpSession session = request.getSession();
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if (login != null && password != null && session.getAttribute("authorizedUser") == null) {
            User user;
            try {
                UserService service = factory.getUserService();
                user = service.findUserByLoginPassword(login, password);
                if (user != null) {
                    // TODO return error message
                    return new Forward("/login.html");
                } else {
                    user = new User();
                    user.setLogin(login);
                    user.setPassword(password);
                    user.setRole(Role.USER);
                    user.setState(0);
                    user.setName(request.getParameter("name"));
                    user.setSurname(request.getParameter("surname"));
                    user.setPatronymic(request.getParameter("patronymic"));
                    user.setEmail(request.getParameter("email"));
                    user.setPhone(request.getParameter("phone"));
                    service.save(user);
                    return new Forward("/login.html", true);
                }
            } catch (ServiceException e) {
                throw new CommandException(e);
            }
        }
        return null;
    }

    @Override
    public Set<Role> getAllowedRoles() {
        return null;
    }
}
