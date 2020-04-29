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
    private static Logger logger = LogManager.getLogger(ProductServiceImpl.class.getName());

    public ProductServiceImpl(Transaction transaction) {
        super(transaction);
    }

    @Override
    public void save(Product product) throws ServiceException {
        try {
            ProductDao dao = (ProductDao) transaction.createDao(ProductDao.class.getName());
            dao.create(product);
            transaction.commit();
        } catch (DAOException e) {
            try {
                transaction.rollback();
            } catch (DAOException ex) {
                logger.error("Fail to rollback transaction", e);
                throw new ServiceException(ex);
            }
            logger.error("Fail to save product", e);
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
                logger.error("Fail to rollback transaction", e);
                throw new ServiceException(ex);
            }
            logger.error("Fail to delete product", e);
            throw new ServiceException(e);
        }
    }

    @Override
    public void update(Product product) throws ServiceException {
        try {
            ProductDao dao = (ProductDao) transaction.createDao(ProductDao.class.getName());
            dao.update(product);
            transaction.commit();
        } catch (DAOException e) {
            try {
                transaction.rollback();
            } catch (DAOException ex) {
                logger.error("Fail to rollback transaction", e);
                throw new ServiceException(ex);
            }
            logger.error("Fail to update product", e);
            throw new ServiceException(e);
        }
    }

    @Override
    public Product findProductByID(int id) throws ServiceException {
        try {
            ProductDao dao = (ProductDao) transaction.createDao(ProductDao.class.getName());
            Product product = dao.read(id);
            transaction.commit();
            return product;
        } catch (DAOException e) {
            try {
                transaction.rollback();
            } catch (DAOException ex) {
                logger.error("Fail to rollback transaction", e);
                throw new ServiceException(ex);
            }
            logger.error("Fail to find product by id", e);
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Product> makeProductsList() throws ServiceException {
        try {
            ProductDao dao = (ProductDao) transaction.createDao(ProductDao.class.getName());
            ArrayList<Product> products = new ArrayList<>();

            Product product = new Product();
            product.setId(1);
            product.setName("Product 1");
            product.setPrice(1000);
            product.setDescription("Cat");

            Product product4 = new Product();
            product4.setId(4);
            product4.setName("Product 4");
            product4.setPrice(500);
            product4.setDescription("44444");

            Product product2 = new Product();
            product2.setId(2);
            product2.setName("Product 2");
            product2.setPrice(700);
            product2.setDescription("222222");

            Product product3 = new Product();
            product3.setId(3);
            product3.setName("Product 3");
            product3.setPrice(5000);
            product3.setDescription("333333 \n qwewweqpoege \n wopkgowg");

            Product product5 = new Product();
            product5.setId(5);
            product5.setName("Product 5");
            product5.setPrice(100);
            product5.setDescription("333333 \n qwewweqpoege \n wopkgowg");

            Product product6 = new Product();
            product6.setId(6);
            product6.setName("Product 6");
            product6.setPrice(10);
            product6.setDescription("333333 \n qwewweqpoege \n wopkgowg");

            products.add(product);
            products.add(product2);
            products.add(product3);
            products.add(product4);
            products.add(product5);
            products.add(product6);

            transaction.commit();
            return products;
        } catch (DAOException e) {
            try {
                transaction.rollback();
            } catch (DAOException ex) {
                logger.error("Fail to rollback transaction", e);
                throw new ServiceException(ex);
            }
            logger.error("Fail to make products list", e);
            throw new ServiceException(e);
        }
    }
}
