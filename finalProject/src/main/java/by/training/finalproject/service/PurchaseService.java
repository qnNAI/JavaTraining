package by.training.finalproject.service;

import by.training.finalproject.beans.Purchase;
import by.training.finalproject.service.serviceException.ServiceException;

public interface PurchaseService extends Service<Purchase> {
    void delete(int id) throws ServiceException;

    Purchase findByID(int id) throws ServiceException;

    Purchase findIdWhenStateIsAddedByUserId(int userID) throws ServiceException;
}
