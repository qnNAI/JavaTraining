package by.training.finalproject.controller.command.util;

import by.training.finalproject.entity.User;
import by.training.finalproject.service.UserService;
import by.training.finalproject.service.factory.ServiceFactory;
import by.training.finalproject.service.serviceException.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class UserUtil {
    private UserUtil() {}

    public static boolean loadUser(HttpServletRequest request, ServiceFactory factory, HttpSession session) throws ServiceException {
        UserService service = factory.getUserService();
        User user = (User) session.getAttribute("authorizedUser");
        if (user == null) {
            return false;
        }
        user = service.findByID(user.getId());
        if (user == null) {
            return false;
        }
        request.setAttribute("user", user);
        return true;
    }

    public static boolean checkIsUserSetInSession(User user, UserService service) throws ServiceException {
        if (user == null) {
            return false;
        }
        user = service.findByID(user.getId());
        return user != null;
    }
}
