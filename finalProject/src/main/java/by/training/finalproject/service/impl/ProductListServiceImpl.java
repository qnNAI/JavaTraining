package by.training.finalproject.service.impl;

import by.training.finalproject.beans.ProductList;
import by.training.finalproject.dao.DAOexception.DAOException;
import by.training.finalproject.dao.ProductListDao;
import by.training.finalproject.dao.Transaction;
import by.training.finalproject.service.ProductListService;
import by.training.finalproject.service.serviceException.ServiceException;
import by.training.finalproject.service.util.BuildEntityUtility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collections;
import java.util.List;

public class ProductListServiceImpl extends BaseServiceImpl implements ProductListService {
    private static Logger logger = LogManager.getLogger(ProductListServiceImpl.class.getName());

    public ProductListServiceImpl(Transaction transaction) {
        super(transaction);
    }

    @Override
    public void save(ProductList productList) throws ServiceException {
        try {
            ProductListDao dao = (ProductListDao) transaction.createDao(ProductListDao.class.getName());
            if (findByID(productList.getPurchase().getId(), productList.getProduct().getId()) != null) {
                dao.update(productList);
            } else {
                dao.create(productList);
            }
            transaction.commit();
        } catch (DAOException e) {
            try {
                transaction.rollback();
            } catch (DAOException ex) {
                logger.error("Failed to rollback transaction", e);
                throw new ServiceException(ex);
            }
            logger.error("Failed to save product list", e);
            throw new ServiceException(e);
        }
    }

    @Override
    public void delete(int purchaseID, int productID) throws ServiceException {
        try {
            ProductListDao dao = (ProductListDao) transaction.createDao(ProductListDao.class.getName());
            dao.delete(purchaseID, productID);
            transaction.commit();
        } catch (DAOException e) {
            try {
                transaction.rollback();
            } catch (DAOException ex) {
                logger.error("Failed to rollback transaction", e);
                throw new ServiceException(ex);
            }
            logger.error("Failed to delete product list", e);
            throw new ServiceException(e);
        }
    }

    @Override
    public ProductList findByID(Integer purchaseID, Integer productID) throws ServiceException {
        try {
            ProductListDao dao = (ProductListDao) transaction.createDao(ProductListDao.class.getName());
            ProductList productList = dao.read(purchaseID, productID);
            if (productList != null && productList.getPurchase() != null && productList.getProduct() != null) {
                BuildEntityUtility.buildProductList(Collections.singletonList(productList), transaction);
            } else {
                return null;
            }
            transaction.commit();
            return productList;
        } catch (DAOException e) {
            try {
                transaction.rollback();
            } catch (DAOException ex) {
                logger.error("Failed to rollback transaction", e);
                throw new ServiceException(ex);
            }
            logger.error("Failed to find product list by id", e);
            throw new ServiceException(e);
        }
    }

    @Override
    public List<ProductList> findAll() throws ServiceException {
        try {
            ProductListDao dao = (ProductListDao) transaction.createDao(ProductListDao.class.getName());
            List<ProductList> listOfProductList = dao.read();
            BuildEntityUtility.buildProductList(listOfProductList, transaction);
            transaction.commit();
            return listOfProductList;
        } catch (DAOException e) {
            try {
                transaction.rollback();
            } catch (DAOException ex) {
                logger.error("Failed to rollback transaction", e);
                throw new ServiceException(ex);
            }
            logger.error("Failed to find list of product list", e);
            throw new ServiceException(e);
        }
    }

    @Override
    public List<ProductList> findProductListWithIdOnlyByPurchaseId(int purchaseID) throws ServiceException {
        try {
            ProductListDao dao = (ProductListDao) transaction.createDao(ProductListDao.class.getName());
            List<ProductList> listOfProductList = dao.readIdOnlyByPurchaseId(purchaseID);
            transaction.commit();
            return listOfProductList;
        } catch (DAOException e) {
            try {
                transaction.rollback();
            } catch (DAOException ex) {
                logger.error("Failed to rollback transaction", e);
                throw new ServiceException(ex);
            }
            logger.error("Failed to find product list by purchase id", e);
            throw new ServiceException(e);
        }
    }

    @Override
    public List<ProductList> findProductListByPurchaseId(int purchaseID) throws ServiceException {
        try {
            ProductListDao dao = (ProductListDao) transaction.createDao(ProductListDao.class.getName());
            List<ProductList> listOfProductList = dao.readByPurchaseId(purchaseID);
            BuildEntityUtility.buildProductList(listOfProductList, transaction);
            transaction.commit();
            return listOfProductList;
        } catch (DAOException e) {
            try {
                transaction.rollback();
            } catch (DAOException ex) {
                logger.error("Failed to rollback transaction", e);
                throw new ServiceException(ex);
            }
            logger.error("Failed to find product list by purchase id", e);
            throw new ServiceException(e);
        }
    }
}

