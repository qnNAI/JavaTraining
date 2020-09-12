package by.training.finalproject.controller.command.impl.profile;

import by.training.finalproject.entity.User;
import by.training.finalproject.entity.infoEnum.Role;
import by.training.finalproject.controller.command.Command;
import by.training.finalproject.controller.command.util.UserUtil;
import by.training.finalproject.service.UserService;
import by.training.finalproject.service.factory.ServiceFactory;
import by.training.finalproject.service.serviceException.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Set;

public class SavePasswordCmd extends Command {
    private static Logger logger = LogManager.getLogger(SavePasswordCmd.class.getName());

    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response, ServiceFactory factory) {
        Forward error = new Forward("/error.jsp", false);
        try {
            HttpSession session = request.getSession();
            UserService service = factory.getUserService();
            User user = (User)session.getAttribute("authorizedUser");

            if (!UserUtil.checkIsUserSetInSession(user, service)) {
                return error;
            }
            String oldPassword = request.getParameter("oldPassword");
            if (oldPassword != null) {
                user = service.findUserByLoginPassword(user.getLogin(), oldPassword);
                if (user  != null) {
                    String newPassword = request.getParameter("newPassword");
                    String newPassConf = request.getParameter("newPasswordConf");
                    if (newPassword != null && newPassConf != null) {
                        if (newPassword.equals(newPassConf)) {
                            user.setPassword(newPassword);
                            service.updateUserAccount(user);
                        }
                    }
                }
            }


            return new Forward("/profile.html", true);
        } catch (ServiceException e) {
            logger.error("Failed to save user info");
            return error;
        }
    }

    @Override
    public Set<Role> getAllowedRoles() {
        return null;
    }
}
