package by.training.finalproject.controller.command.impl.basket;

import by.training.finalproject.entity.LocalAddress;
import by.training.finalproject.entity.Purchase;
import by.training.finalproject.entity.infoEnum.ObtainingMethod;
import by.training.finalproject.entity.infoEnum.Role;
import by.training.finalproject.controller.command.Command;
import by.training.finalproject.service.PurchaseService;
import by.training.finalproject.service.factory.ServiceFactory;
import by.training.finalproject.service.serviceException.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.Set;

public class ConfirmPurchaseCmd extends Command {
    private static Logger logger = LogManager.getLogger(ConfirmPurchaseCmd.class.getName());

    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response, ServiceFactory factory) {
        HttpSession session = request.getSession();
        if (session.getAttribute("authorizedUser") == null) {
            return new Forward("/error.jsp", false);
        }
        try {
            PurchaseService purchaseService = factory.getPurchaseService();
            if (session.getAttribute("purchaseID") != null) {
                Integer purchaseID = (Integer) session.getAttribute("purchaseID");
                String method = request.getParameter("method");
                Purchase purchase = purchaseService.findByID(purchaseID);
                if (purchase != null) {
                    purchase.setState(Purchase.State.ORDERED);
                    if (!method.isEmpty()) {
                        if (method.equalsIgnoreCase("pickup")) {
                            int localAddressID = Integer.parseInt(request.getParameter("localAddressID"));
                            LocalAddress localAddress = new LocalAddress();
                            localAddress.setId(localAddressID);
                            purchase.setLocalAddress(localAddress);
                            purchase.setDate(LocalDate.now());
                            purchase.setObtainingMethod(ObtainingMethod.getByName("самовывоз"));
                        } else {
                            String address = request.getParameter("address");
                            purchase.setAddress(address);
                            purchase.setDate(LocalDate.now());
                            purchase.setObtainingMethod(ObtainingMethod.getByName("доставка"));
                        }
                        purchaseService.save(purchase);
                    }
                }
                session.removeAttribute("purchaseID");
            }
        } catch (NumberFormatException | ServiceException e) {
            logger.error("Failed to confirm purchase", e);
            return new Forward("/error.jsp", false);
        }
        return new Forward("/main.html", true);
    }

    @Override
    public Set<Role> getAllowedRoles() {
        return null;
    }
}
