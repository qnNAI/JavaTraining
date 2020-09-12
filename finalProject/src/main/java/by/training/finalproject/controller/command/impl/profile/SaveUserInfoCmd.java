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

public class SaveUserInfoCmd extends Command {
    private static Logger logger = LogManager.getLogger(SaveUserInfoCmd.class.getName());

    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response, ServiceFactory factory) {
        Forward error = new Forward("/error.jsp", false);
        try {
            UserService service = factory.getUserService();
            HttpSession session = request.getSession();
            User user = (User)session.getAttribute("authorizedUser");

            if (!UserUtil.checkIsUserSetInSession(user, service)) {
                return error;
            }

            String login = request.getParameter("login");
            String name = request.getParameter("name");
            String surname = request.getParameter("surname");
            String patronymic = request.getParameter("patronymic");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");

            if (login != null && !login.isEmpty()) {
                user.setLogin(login);
            }
            if (name != null && !name.isEmpty()) {
                user.setName(name);
            }
            if (surname != null && !surname.isEmpty()) {
                user.setSurname(surname);
            }
            if (patronymic != null && !patronymic.isEmpty()) {
                user.setPatronymic(patronymic);
            }
            if (email != null && !email.isEmpty()) {
                user.setEmail(email);
            }
            if (phone != null && !phone.isEmpty()) {
                user.setPhone(phone);
            }
            service.save(user);

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
