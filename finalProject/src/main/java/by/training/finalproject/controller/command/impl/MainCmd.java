package by.training.finalproject.controller.command.impl;

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
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MainCmd extends Command {
    private static Logger logger = LogManager.getLogger(MainCmd.class.getName());

    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response, ServiceFactory factory) {
        Forward forward = new Forward("/main.jsp", false);
        HttpSession session = request.getSession();
        List<Product> products;
        final int prodByPage = 9;

        try {
            ProductService productService = factory.getProductService();
            PurchaseService purchaseService = factory.getPurchaseService();
            ProductListService productListService = factory.getProductListService();
            User user = (User) session.getAttribute("authorizedUser");
            String pageStr = request.getParameter("page");
            String amountFullStr = request.getParameter("amountFull");
            String pageAmountStr = request.getParameter("pageAmount");
            int page;
            int amountFull;
            int pageAmount;
            if (pageStr != null && !pageStr.isEmpty()) {
                page = Integer.parseInt(pageStr);
                ++page;
                amountFull = Integer.parseInt(amountFullStr);
                pageAmount = Integer.parseInt(pageAmountStr);
            } else {
                page = 1;
                amountFull = productService.countProducts();
                pageAmount = amountFull / prodByPage;
                if (pageAmount < 1) {
                    pageAmount = 1;
                }
            }
            request.setAttribute("page", page);
            request.setAttribute("amountFull", amountFull);
            request.setAttribute("pageAmount", pageAmount);
            if (user != null) {
                Purchase purchase = purchaseService.findIdWhenStateIsAddedByUserId(user.getId());
                products = productService.findAllWithoutUserID((page - 1) * prodByPage, prodByPage);
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
                products = productService.findAllWithoutUserID((page - 1) * prodByPage, prodByPage);
            }
        } catch (ServiceException e) {
            logger.error("Failed to load products", e);
            return new Forward("/error.jsp", false);
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
