package by.training.finalproject.controller.command.impl;

import by.training.finalproject.beans.infoEnum.Role;
import by.training.finalproject.controller.command.Command;
import by.training.finalproject.controller.command.commandException.CommandException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Set;

public class LogoutCmd extends Command {
    private static Logger logger = LogManager.getLogger(LogoutCmd.class.getName());

    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        HttpSession session = request.getSession(false);
        if (session.getAttribute("authorizedUser") != null) {
            session.invalidate();
            logger.info("User logged out");
            return new Forward("/login.html", true);
        }
        return null;
    }

    @Override
    public Set<Role> getAllowedRoles() {
        return null;
    }
}
