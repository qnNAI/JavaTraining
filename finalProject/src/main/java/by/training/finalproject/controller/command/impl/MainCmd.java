package by.training.finalproject.controller.command.impl;

import by.training.finalproject.beans.Product;
import by.training.finalproject.beans.infoEnum.Role;
import by.training.finalproject.controller.command.Command;
import by.training.finalproject.controller.command.commandException.CommandException;
import by.training.finalproject.dao.DAOexception.DAOException;
import by.training.finalproject.service.ProductService;
import by.training.finalproject.service.serviceException.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Set;

public class MainCmd extends Command {
    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        Forward forward = new Forward("/main.jsp", false);
        List<Product> products;
        try {
            ProductService productService = factory.getProductService();
            products = productService.makeProductsList();
        } catch (DAOException | ServiceException e) {
            throw new CommandException(e);
        }
        if (products != null) {
            request.setAttribute("products", products);
        }
        return forward;
    }

    @Override
    public void setAllowedRoles(Set<Role> allowedRoles) {
        super.setAllowedRoles(allowedRoles);
    }
}
