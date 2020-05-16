package by.training.finalproject.controller.command.impl;

import by.training.finalproject.beans.infoEnum.Role;
import by.training.finalproject.controller.command.Command;
import by.training.finalproject.controller.command.commandException.CommandException;
import by.training.finalproject.service.ProductListService;
import by.training.finalproject.service.PurchaseService;
import by.training.finalproject.service.factory.ServiceFactory;
import by.training.finalproject.service.serviceException.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Set;

public class RemoveFromBasketCmd extends Command {
    private static Logger logger = LogManager.getLogger(RemoveFromBasketCmd.class.getName());

    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response, ServiceFactory factory) throws CommandException {
        HttpSession session = request.getSession();
        try {
            PurchaseService purchaseService = factory.getPurchaseService();
            ProductListService productListService = factory.getProductListService();

            if (session.getAttribute("purchaseID") != null) {
                Integer purchaseID = (Integer) session.getAttribute("purchaseID");
                int productID = Integer.parseInt(request.getParameter("productID"));
                productListService.delete(purchaseID, productID);
                if (productListService.findProductListWithIdOnlyByPurchaseId(purchaseID).isEmpty()) {
                    purchaseService.delete(purchaseID);
                }
            }
        } catch (NumberFormatException | ServiceException e) {
            logger.error("Failed to remove product from basket", e);
        }

        return new Forward("/basket.html", true);
    }

    @Override
    public Set<Role> getAllowedRoles() {
        return null;
    }
}
