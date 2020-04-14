package by.training.finalproject.service.factory;

import by.training.finalproject.dao.DAOexception.DAOException;
import by.training.finalproject.dao.TransactionFactory;
import by.training.finalproject.service.LocalAddressService;
import by.training.finalproject.service.ProductService;
import by.training.finalproject.service.UserService;
import by.training.finalproject.service.impl.LocalAddressServiceImpl;
import by.training.finalproject.service.impl.ProductServiceImpl;
import by.training.finalproject.service.impl.UserServiceImpl;

public class ServiceFactory {
    private TransactionFactory transactionFactory;

    public ServiceFactory (TransactionFactory transactionFactory) throws DAOException {
          this.transactionFactory = transactionFactory;
    }

    public UserService getUserService() throws DAOException {
        return new UserServiceImpl(transactionFactory.createTransaction());
    }

    public ProductService getProductService() throws DAOException {
        return new ProductServiceImpl(transactionFactory.createTransaction());
    }

    public LocalAddressService getLocalAddressService() throws DAOException {
        return new LocalAddressServiceImpl(transactionFactory.createTransaction());
    }

   /* public void setTransactionFactory(TransactionFactory transactionFactory) {
        this.transactionFactory = transactionFactory;
    }*/
}
