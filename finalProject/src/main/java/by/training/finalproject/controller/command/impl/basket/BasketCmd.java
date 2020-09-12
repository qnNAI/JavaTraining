package by.training.finalproject.controller.command.impl.basket;

import by.training.finalproject.entity.ProductList;
import by.training.finalproject.entity.Purchase;
import by.training.finalproject.entity.User;
import by.training.finalproject.entity.infoEnum.Role;
import by.training.finalproject.controller.command.Command;
import by.training.finalproject.service.ProductListService;
import by.training.finalproject.service.PurchaseService;
import by.training.finalproject.service.factory.ServiceFactory;
import by.training.finalproject.service.serviceException.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Set;

public class BasketCmd extends Command {
    private static Logger logger = LogManager.getLogger(BasketCmd.class.getName());

    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response, ServiceFactory factory) {
        Forward forward = new Forward("/basket/basket.jsp", false);
        HttpSession session = request.getSession();
        List<ProductList> listOfProductList = null;
        try {
            PurchaseService purchaseService = factory.getPurchaseService();
            ProductListService productListService = factory.getProductListService();
            User user = (User) session.getAttribute("authorizedUser");
            if (user != null) {
                Purchase purchase = purchaseService.findIdWhenStateIsAddedByUserId(user.getId());
                if (purchase != null) {
                    int purchaseID = purchase.getId();
                    listOfProductList = productListService.findProductListByPurchaseId(purchaseID);
                    request.getSession().setAttribute("purchaseID", purchaseID);
                }
            } else {
                /* check cookies for basket */
            }

        } catch (ServiceException e) {
            logger.error("Failed to load basket");
            return new Forward("/error.jsp", false);
        }

        if (listOfProductList != null) {
            request.setAttribute("listOfProductList", listOfProductList);
        }

        return forward;
    }

    @Override
    public Set<Role> getAllowedRoles() {
        return null;
    }
}
