package by.training.finalproject.controller.command.impl.basket;

import by.training.finalproject.beans.Product;
import by.training.finalproject.beans.ProductList;
import by.training.finalproject.beans.Purchase;
import by.training.finalproject.beans.User;
import by.training.finalproject.beans.infoEnum.Role;
import by.training.finalproject.controller.command.Command;
import by.training.finalproject.service.ProductListService;
import by.training.finalproject.service.ProductService;
import by.training.finalproject.service.PurchaseService;
import by.training.finalproject.service.factory.ServiceFactory;
import by.training.finalproject.service.serviceException.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.InputMismatchException;
import java.util.Set;

public class AddToBasketCmd extends Command {
    private static Logger logger = LogManager.getLogger(AddToBasketCmd.class.getName());

    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response, ServiceFactory factory) {
        Forward forward = new Forward("/main.html", true);
        HttpSession session = request.getSession();
        try {
            Integer productID = Integer.valueOf(request.getParameter("productID"));
            if (productID != null) {
                User user = (User) session.getAttribute("authorizedUser");
                if (user != null) {
                    ProductService productService = factory.getProductService();
                    PurchaseService purchaseService = factory.getPurchaseService();
                    ProductListService productListService = factory.getProductListService();
                    Product product = productService.findByID(productID);
                    if (product != null) {
                        Purchase purchase = purchaseService.findIdWhenStateIsAddedByUserId(user.getId());
                        if (purchase != null) {
                            ProductList productList = new ProductList();
                            productList.setProduct(product);
                            productList.setPurchase(purchase);
                            productList.setFinalPrice(product.getPrice());
                            productList.setAmount(Integer.parseInt(request.getParameter("productAmount")));
                            productListService.save(productList);
                        } else {
                            purchase = new Purchase();
                            purchase.setUser(user);
                            purchase.setState(Purchase.State.ADDED);
                            purchaseService.save(purchase);
                            purchase = purchaseService.findIdWhenStateIsAddedByUserId(user.getId());
                            ProductList productList = new ProductList();
                            productList.setProduct(product);
                            productList.setPurchase(purchase);
                            productList.setFinalPrice(product.getPrice());
                            productList.setAmount(Integer.parseInt(request.getParameter("productAmount")));
                            productListService.save(productList);
                        }
                    }
                } else {
                    /* TODO add to cookies */
                }
            }
        } catch (InputMismatchException | NumberFormatException | ServiceException e) {
            logger.error("Failed to add product to basket", e);
            return new Forward("/error.jsp", false);
        }
        return forward;
    }

    @Override
    public Set<Role> getAllowedRoles() {
        return null;
    }
}
