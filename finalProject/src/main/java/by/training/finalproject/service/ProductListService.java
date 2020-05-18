package by.training.finalproject.service;

import by.training.finalproject.beans.ProductList;
import by.training.finalproject.service.serviceException.ServiceException;

import java.util.List;

public interface ProductListService extends Service<ProductList> {
    void delete(int purchaseID, int productID) throws ServiceException;

    ProductList findByID(Integer purchaseID, Integer productID) throws ServiceException;

    List<ProductList> findAll() throws ServiceException;

    List<ProductList> findProductListWithIdOnlyByPurchaseId(int purchaseID) throws ServiceException;

    List<ProductList> findProductListByPurchaseId(int purchaseID) throws ServiceException;
}
