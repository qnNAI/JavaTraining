package by.training.finalproject.service;

import by.training.finalproject.entity.Product;
import by.training.finalproject.entity.ProductList;
import by.training.finalproject.service.serviceException.ServiceException;

import java.util.List;

public interface ProductService extends Service<Product> {
    void delete(int id) throws ServiceException;

    Product findByID(int id) throws ServiceException;

    int countProductsNotInBasket() throws ServiceException;

    List<Product> findAll(int start, int amount) throws ServiceException;

    List<Product> findAllWithUserID(int start, int amount) throws ServiceException;

    List<Product> findAllWithoutUserID(int start, int amount) throws ServiceException;

    List<Product> findAllWithoutUserIdById(List<ProductList> listOfProductList) throws ServiceException;
}

