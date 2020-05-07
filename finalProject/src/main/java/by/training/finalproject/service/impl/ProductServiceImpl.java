package by.training.finalproject.service.impl;

import by.training.finalproject.beans.Product;
import by.training.finalproject.beans.User;
import by.training.finalproject.dao.DAOexception.DAOException;
import by.training.finalproject.dao.ProductDao;
import by.training.finalproject.dao.Transaction;
import by.training.finalproject.dao.UserDao;
import by.training.finalproject.service.ProductService;
import by.training.finalproject.service.serviceException.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class ProductServiceImpl extends BaseServiceImpl implements ProductService {
    private static Logger logger = LogManager.getLogger(ProductServiceImpl.class.getName());

    public ProductServiceImpl(Transaction transaction) {
        super(transaction);
    }

    @Override
    public void save(Product product) throws ServiceException {
        try {
            ProductDao dao = (ProductDao) transaction.createDao(ProductDao.class.getName());
            if (product.getId() == null) {
                dao.create(product);
            } else {
                dao.update(product);
            }
            transaction.commit();
        } catch (DAOException e) {
            try {
                transaction.rollback();
            } catch (DAOException ex) {
                logger.error("Failed to rollback transaction", e);
                throw new ServiceException(ex);
            }
            logger.error("Failed to save or update product", e);
            throw new ServiceException(e);
        }
    }

    @Override
    public void delete(int id) throws ServiceException {
        try {
            ProductDao dao = (ProductDao) transaction.createDao(ProductDao.class.getName());
            dao.delete(id);
            transaction.commit();
        } catch (DAOException e) {
            try {
                transaction.rollback();
            } catch (DAOException ex) {
                logger.error("Failed to rollback transaction", e);
                throw new ServiceException(ex);
            }
            logger.error("Failed to delete product", e);
            throw new ServiceException(e);
        }
    }

    @Override
    public Product findByID(int id) throws ServiceException {
        try {
            ProductDao dao = (ProductDao) transaction.createDao(ProductDao.class.getName());
            Product product = dao.read(id);
            buildProduct(Collections.singletonList(product));
            transaction.commit();
            return product;
        } catch (DAOException e) {
            try {
                transaction.rollback();
            } catch (DAOException ex) {
                logger.error("Failed to rollback transaction", e);
                throw new ServiceException(ex);
            }
            logger.error("Failed to find product by id", e);
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Product> findAll() throws ServiceException {
        try {
            ProductDao dao = (ProductDao) transaction.createDao(ProductDao.class.getName());
            List<Product> products = dao.read();
            buildProduct(products);
            transaction.commit();
            return products;
        } catch (DAOException e) {
            try {
                transaction.rollback();
            } catch (DAOException ex) {
                logger.error("Failed to rollback transaction", e);
                throw new ServiceException(ex);
            }
            logger.error("Failed to find all products", e);
            throw new ServiceException(e);
        }
    }

    private void buildProduct(List<Product> products) throws ServiceException {
        try {
            UserDao userDao = (UserDao) transaction.createDao(UserDao.class.getName());
            ProductDao productDao = (ProductDao) transaction.createDao(ProductDao.class.getName());
            Map<Integer, User> users = new HashMap<>();
            User user;
            Integer userID;

            for (Product product : products) {
                user = product.getUser();
                if (user != null) {     // if user set in product
                    userID = user.getId();
                    user = users.get(userID);
                    if (user == null) {     // if there is no user in map
                        user = userDao.read(userID);
                        users.put(userID, user);
                    }
                    product.setUser(user);
                }
            }
        } catch (DAOException e) {
            logger.error("Failed to build product", e);
            throw new ServiceException(e);
        }

    }
}
