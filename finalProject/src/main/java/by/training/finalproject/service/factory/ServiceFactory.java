package by.training.finalproject.service.factory;

import by.training.finalproject.dao.DAOexception.DAOException;
import by.training.finalproject.dao.TransactionFactory;
import by.training.finalproject.service.*;
import by.training.finalproject.service.impl.*;
import by.training.finalproject.service.serviceException.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ServiceFactory {
    private static Logger logger = LogManager.getLogger(ServiceFactory.class.getName());
    private TransactionFactory transactionFactory;

    public ServiceFactory(TransactionFactory transactionFactory) {
        this.transactionFactory = transactionFactory;
    }

    public UserService getUserService() throws ServiceException {
        try {
            return new UserServiceImpl(transactionFactory.createTransaction());
        } catch (DAOException e) {
            logger.error("Failed to create user service", e);
            throw new ServiceException(e);
        }
    }

    public ProductService getProductService() throws ServiceException {
        try {
            return new ProductServiceImpl(transactionFactory.createTransaction());
        } catch (DAOException e) {
            logger.error("Failed to create product service", e);
            throw new ServiceException(e);
        }
    }

    public LocalAddressService getLocalAddressService() throws ServiceException {
        try {
            return new LocalAddressServiceImpl(transactionFactory.createTransaction());
        } catch (DAOException e) {
            logger.error("Failed to create local address service", e);
            throw new ServiceException(e);
        }
    }

    public PurchaseService getPurchaseService() throws ServiceException {
        try {
            return new PurchaseServiceImpl(transactionFactory.createTransaction());
        } catch (DAOException e) {
            logger.error("Failed to create purchase service", e);
            throw new ServiceException(e);
        }
    }

    public ProductListService getProductListService() throws ServiceException {
        try {
            return new ProductListServiceImpl(transactionFactory.createTransaction());
        } catch (DAOException e) {
            logger.error("Failed to create product list service", e);
            throw new ServiceException(e);
        }
    }
}
