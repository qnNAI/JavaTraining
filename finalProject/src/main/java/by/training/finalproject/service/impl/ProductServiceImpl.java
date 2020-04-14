package by.training.finalproject.service.impl;

import by.training.finalproject.beans.Product;
import by.training.finalproject.dao.DAOexception.DAOException;
import by.training.finalproject.dao.ProductDao;
import by.training.finalproject.dao.Transaction;
import by.training.finalproject.service.ProductService;
import by.training.finalproject.service.Service;
import by.training.finalproject.service.serviceException.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl extends Service implements ProductService {
   // private static Logger logger = LogManager.getLogger(ProductServiceImpl.class.getName());

    public ProductServiceImpl(Transaction transaction) {
        super(transaction);
    }

    @Override
    public void save(Product product) throws ServiceException {
        try {
            ProductDao dao = (ProductDao) transaction.createDao(ProductDao.class.getName());
            dao.create(product);
        } catch (DAOException e) {
       //     logger.error("Fail to save product", e);
            throw new ServiceException(e);
        }
    }

    @Override
    public void delete(int id) throws ServiceException {
        try {
            ProductDao dao = (ProductDao) transaction.createDao(ProductDao.class.getName());
            dao.delete(id);
        } catch (DAOException e) {
         //   logger.error("Fail to delete product", e);
            throw new ServiceException(e);
        }
    }

    @Override
    public void update(Product product) throws ServiceException {
        try {
            ProductDao dao = (ProductDao) transaction.createDao(ProductDao.class.getName());
            dao.update(product);
        } catch (DAOException e) {
         //   logger.error("Fail to update product", e);
            throw new ServiceException(e);
        }
    }

    @Override
    public Product findProductByID(int id) throws ServiceException {
        try {
            ProductDao dao = (ProductDao) transaction.createDao(ProductDao.class.getName());
            return dao.read(id);
        } catch (DAOException e) {
      //      logger.error("Fail to find product by id", e);
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Product> makeProductsList() throws ServiceException {
        try {
            ProductDao dao = (ProductDao) transaction.createDao(ProductDao.class.getName());
            ArrayList<Product> products = null;

            return products;
        } catch (DAOException e) {
         //   logger.error("Fail to make products list", e);
            throw new ServiceException(e);
        }
    }
}
