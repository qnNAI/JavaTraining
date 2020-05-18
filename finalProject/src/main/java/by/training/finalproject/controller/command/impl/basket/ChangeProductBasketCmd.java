package by.training.finalproject.controller.command.impl.basket;

import by.training.finalproject.beans.Product;
import by.training.finalproject.beans.ProductList;
import by.training.finalproject.beans.Purchase;
import by.training.finalproject.beans.infoEnum.Role;
import by.training.finalproject.controller.command.Command;
import by.training.finalproject.service.ProductListService;
import by.training.finalproject.service.factory.ServiceFactory;
import by.training.finalproject.service.serviceException.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Set;

public class ChangeProductBasketCmd extends Command {
    private static Logger logger = LogManager.getLogger(ChangeProductBasketCmd.class.getName());

    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response, ServiceFactory factory) {
        HttpSession session = request.getSession();
        try {
            ProductListService productListService = factory.getProductListService();
            if (session.getAttribute("purchaseID") != null) {
                Integer purchaseID = (Integer) session.getAttribute("purchaseID");
                ProductList productList = new ProductList();
                Purchase purchase = new Purchase();
                Product product = new Product();
                purchase.setId(purchaseID);
                product.setId(Integer.parseInt(request.getParameter("productIDchange")));
                productList.setPurchase(purchase);
                productList.setProduct(product);
                productList.setFinalPrice(Double.parseDouble(request.getParameter("productFinalPrice")));
                productList.setAmount(Integer.parseInt(request.getParameter("productAmount")));
                productListService.save(productList);
            }
        } catch (NumberFormatException | ServiceException e) {
            logger.error("Failed to change product in basket", e);
            return new Forward("/error.jsp", false);
        }
        return new Forward("/basket.html", true);
    }

    @Override
    public Set<Role> getAllowedRoles() {
        return null;
    }
}
