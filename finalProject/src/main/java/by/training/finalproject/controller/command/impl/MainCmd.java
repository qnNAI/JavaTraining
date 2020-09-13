package by.training.finalproject.controller.command.impl;

import by.training.finalproject.entity.Product;
import by.training.finalproject.entity.ProductList;
import by.training.finalproject.entity.Purchase;
import by.training.finalproject.entity.User;
import by.training.finalproject.entity.infoEnum.Role;
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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainCmd extends Command {
    private static final Logger logger = LogManager.getLogger(MainCmd.class.getName());
    private static final int PROD_BY_PAGE = 9;

    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response, ServiceFactory factory) {
        Forward forward = new Forward("/main.jsp", false);
        HttpSession session = request.getSession();
        List<Product> products;

        try {
            ProductService productService = factory.getProductService();
            PurchaseService purchaseService = factory.getPurchaseService();
            ProductListService productListService = factory.getProductListService();
            User user = (User) session.getAttribute("authorizedUser");
            String pageStr = request.getParameter("page");
            int pageAmount;
            int page;
            if (pageStr != null && !pageStr.isEmpty()) {
                page = Integer.parseInt(pageStr);
                pageAmount = (int) session.getAttribute("pageAmount");
                if (page < 1) { // if prev page return value < 1 then set page value = 1
                    page = 1;
                } else if (page > pageAmount) { // if next page return value > pages amount then set page value = max
                    page = pageAmount;
                }
            } else {
                page = 1;
                int productAmount = productService.countProductsNotInBasket();
                pageAmount = productAmount / PROD_BY_PAGE + 1;
                if (pageAmount < 1) {
                    pageAmount = 1;
                }
                session.setAttribute("pageAmount", pageAmount);
            }
            if (user != null) {
                Purchase purchase = purchaseService.findIdWhenStateIsAddedByUserId(user.getId());
                products = productService.findAllWithoutUserID((page - 1) * PROD_BY_PAGE, PROD_BY_PAGE);
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
                products = productService.findAllWithoutUserID((page - 1) * PROD_BY_PAGE, PROD_BY_PAGE);
            }
            request.setAttribute("page", page);
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
