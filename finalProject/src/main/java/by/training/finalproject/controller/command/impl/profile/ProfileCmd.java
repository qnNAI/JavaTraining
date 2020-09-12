package by.training.finalproject.controller.command.impl.profile;

import by.training.finalproject.entity.infoEnum.Role;
import by.training.finalproject.controller.command.Command;
import by.training.finalproject.controller.command.util.UserUtil;
import by.training.finalproject.service.factory.ServiceFactory;
import by.training.finalproject.service.serviceException.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Set;

public class ProfileCmd extends Command {
    private static Logger logger = LogManager.getLogger(ProfileCmd.class.getName());

    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response, ServiceFactory factory) {
        HttpSession session = request.getSession();
        final Forward forward = new Forward("/error.jsp", false);
        try {
            if (UserUtil.loadUser(request, factory, session)) {
                return new Forward("/profile/profile.jsp", false);
            }
            return forward;
        } catch (ServiceException e) {
            logger.error("Failed to load profile page", e);
            return forward;
        }
    }

    @Override
    public Set<Role> getAllowedRoles() {
        return null;
    }
}
