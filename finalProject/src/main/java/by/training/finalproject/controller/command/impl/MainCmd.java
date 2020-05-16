package by.training.finalproject.controller.command.impl;

import by.training.finalproject.beans.Product;
import by.training.finalproject.beans.ProductList;
import by.training.finalproject.beans.Purchase;
import by.training.finalproject.beans.User;
import by.training.finalproject.beans.infoEnum.Role;
import by.training.finalproject.controller.command.Command;
import by.training.finalproject.controller.command.commandException.CommandException;
import by.training.finalproject.dao.DAOexception.DAOException;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MainCmd extends Command {
    private static Logger logger = LogManager.getLogger(MainCmd.class.getName());

    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response, ServiceFactory factory) throws CommandException {
        Forward forward = new Forward("/main.jsp", false);
        HttpSession session = request.getSession();
        List<Product> products;
        try {
            ProductService productService = factory.getProductService();
            PurchaseService purchaseService = factory.getPurchaseService();
            ProductListService productListService = factory.getProductListService();
            User user = (User) session.getAttribute("authorizedUser");
            if (user != null) {
                Purchase purchase = purchaseService.findIdWhenStateIsAddedByUserId(user.getId());
                products = productService.findAllWithoutUserID();
                if (purchase != null) {
                    List<ProductList> listOfProductList = productListService.findProductListWithIdOnlyByPurchaseId(purchase.getId());
                    List<Integer> productIdentities = new ArrayList<>(); // products in basket
                    for (ProductList productList : listOfProductList) {
                        productIdentities.add(productList.getProduct().getId());
                    }
                    for (Product product : products) {
                        if (productIdentities.contains(product.getId())) {
                            product.setInBasket(true);
                        }
                    }
                }
            } else {
                /* check cookies for basket */
                products = productService.findAllWithoutUserID();
            }
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        if (products != null) {
            request.setAttribute("products", products);
        }
        return forward;
    }

    @Override
    public Set<Role> getAllowedRoles() {
        return null;
    }
}
