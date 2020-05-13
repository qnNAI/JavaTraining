package by.training.finalproject.service;

import by.training.finalproject.beans.Product;
import by.training.finalproject.beans.ProductList;
import by.training.finalproject.service.serviceException.ServiceException;

import java.util.List;

public interface ProductService extends Service<Product> {
    void delete(int id) throws ServiceException;

    Product findByID(int id) throws ServiceException;

    List<Product> findAllWithUserID() throws ServiceException;

    List<Product> findAllWithoutUserID() throws ServiceException;

    List<Product> findAllWithoutUserIdById(List<ProductList> listOfProductList) throws ServiceException;
}
