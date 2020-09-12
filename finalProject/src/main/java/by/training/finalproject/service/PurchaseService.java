package by.training.finalproject.service;

import by.training.finalproject.entity.Purchase;
import by.training.finalproject.service.serviceException.ServiceException;

import java.util.List;

public interface PurchaseService extends Service<Purchase> {
    void delete(int id) throws ServiceException;

    List<Purchase> findAll() throws ServiceException;

    Purchase findByID(int id) throws ServiceException;

    Purchase findIdWhenStateIsAddedByUserId(int userID) throws ServiceException;
}
