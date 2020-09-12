package by.training.finalproject.controller.command.impl.basket;

import by.training.finalproject.entity.LocalAddress;
import by.training.finalproject.entity.infoEnum.Role;
import by.training.finalproject.controller.command.Command;
import by.training.finalproject.service.LocalAddressService;
import by.training.finalproject.service.factory.ServiceFactory;
import by.training.finalproject.service.serviceException.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Set;

public class PurchaseConfirmationCmd extends Command {
    private static Logger logger = LogManager.getLogger(PurchaseConfirmationCmd.class.getName());

    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response, ServiceFactory factory) {
        HttpSession session = request.getSession(false);
        if (session.getAttribute("authorizedUser") == null) {
            return new Forward("/error.jsp", false);
        }
        try {
            LocalAddressService localAddressService = factory.getLocalAddressService();
            int amount = Integer.parseInt(request.getParameter("amount"));
            double sum = Double.parseDouble(request.getParameter("sum"));
            List<LocalAddress> localAddresses = localAddressService.findAll();
            request.setAttribute("amount", amount);
            request.setAttribute("sum", sum);
            request.setAttribute("localAddresses", localAddresses);
            return new Forward("/basket/purchaseConfirmation.jsp", false);
        } catch (NumberFormatException | ServiceException e) {
            logger.error("Failed to load purchase confirmation page", e);
            return new Forward("/error.jsp", false);
        }
    }

    @Override
    public Set<Role> getAllowedRoles() {
        return null;
    }
}
