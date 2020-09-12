package by.training.finalproject.service.impl;

import by.training.finalproject.entity.Purchase;
import by.training.finalproject.dao.DAOexception.DAOException;
import by.training.finalproject.dao.PurchaseDao;
import by.training.finalproject.dao.Transaction;
import by.training.finalproject.service.PurchaseService;
import by.training.finalproject.service.serviceException.ServiceException;
import by.training.finalproject.service.util.BuildEntityUtility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collections;
import java.util.List;

public class PurchaseServiceImpl extends BaseServiceImpl implements PurchaseService {
    private static Logger logger = LogManager.getLogger(PurchaseServiceImpl.class.getName());

    public PurchaseServiceImpl(Transaction transaction) {
        super(transaction);
    }

    @Override
    public void save(Purchase purchase) throws ServiceException {
        try {
            PurchaseDao dao = (PurchaseDao) transaction.createDao(PurchaseDao.class.getName());
            if (purchase.getId() == null) {
                dao.create(purchase);
            } else {
                dao.update(purchase);
            }
            transaction.commit();
        } catch (DAOException e) {
            try {
                transaction.rollback();
            } catch (DAOException ex) {
                logger.error("Failed to rollback transaction", e);
                throw new ServiceException(ex);
            }
            logger.error("Failed to save or update purchase", e);
            throw new ServiceException(e);
        }
    }

    @Override
    public void delete(int id) throws ServiceException {
        try {
            PurchaseDao dao = (PurchaseDao) transaction.createDao(PurchaseDao.class.getName());
            dao.delete(id);
            transaction.commit();
        } catch (DAOException e) {
            try {
                transaction.rollback();
            } catch (DAOException ex) {
                logger.error("Failed to rollback transaction", e);
                throw new ServiceException(ex);
            }
            logger.error("Failed to delete purchase", e);
            throw new ServiceException(e);
        }
    }

    @Override
    public Purchase findByID(int id) throws ServiceException {
        try {
            PurchaseDao dao = (PurchaseDao) transaction.createDao(PurchaseDao.class.getName());
            Purchase purchase = dao.read(id);
            BuildEntityUtility.buildPurchase(Collections.singletonList(purchase), transaction);
            transaction.commit();
            return purchase;
        } catch (DAOException e) {
            try {
                transaction.rollback();
            } catch (DAOException ex) {
                logger.error("Failed to rollback transaction", e);
                throw new ServiceException(ex);
            }
            logger.error("Failed to find purchase by id", e);
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Purchase> findAll() throws ServiceException {
        try {
            PurchaseDao dao = (PurchaseDao) transaction.createDao(PurchaseDao.class.getName());
            List<Purchase> purchases = dao.read();
            BuildEntityUtility.buildPurchase(purchases, transaction);
            transaction.commit();
            return purchases;
        } catch (DAOException e) {
            try {
                transaction.rollback();
            } catch (DAOException ex) {
                logger.error("Failed to rollback transaction", e);
                throw new ServiceException(ex);
            }
            logger.error("Failed to find purchases", e);
            throw new ServiceException(e);
        }
    }

    @Override
    public Purchase findIdWhenStateIsAddedByUserId(int userID) throws ServiceException {
        try {
            PurchaseDao dao = (PurchaseDao) transaction.createDao(PurchaseDao.class.getName());
            List<Purchase> purchases = dao.readIdAndStateByUserId(userID);
            purchases.removeIf(purchase -> purchase.getState() != Purchase.State.ADDED);
            transaction.commit();
            if (!purchases.isEmpty()) {
                return purchases.get(0);
            } else {
                return null;
            }
        } catch (DAOException e) {
            try {
                transaction.rollback();
            } catch (DAOException ex) {
                logger.error("Failed to rollback transaction", e);
                throw new ServiceException(ex);
            }
            logger.error("Failed to find purchases with id and state is ADDED by user id", e);
            throw new ServiceException(e);
        }
    }

}
