package by.training.finalproject.controller.command.impl.profile;

import by.training.finalproject.entity.User;
import by.training.finalproject.entity.infoEnum.Role;
import by.training.finalproject.controller.command.Command;
import by.training.finalproject.service.factory.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Set;

public class ChangePasswordCmd extends Command {
    private static Logger logger = LogManager.getLogger(ChangePasswordCmd.class.getName());

    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response, ServiceFactory factory) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("authorizedUser");
        if (user == null) {
            logger.error("Failed to change password : user null");
            return new Forward("/error.jsp", false);
        }
        return new Forward("/profile/changePassword.jsp", false);
    }

    @Override
    public Set<Role> getAllowedRoles() {
        return null;
    }
}
