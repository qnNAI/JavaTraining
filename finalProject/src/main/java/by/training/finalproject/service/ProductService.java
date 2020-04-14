package by.training.finalproject.service;

import by.training.finalproject.beans.Product;
import by.training.finalproject.service.serviceException.ServiceException;

import java.util.List;

public interface ProductService {
    void save(Product product) throws ServiceException;
    void delete(int id) throws ServiceException;
    void update(Product product) throws ServiceException;
    Product findProductByID(int id) throws ServiceException;
    List<Product> makeProductsList() throws ServiceException;
}
