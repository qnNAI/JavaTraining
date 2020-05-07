package by.training.finalproject.service.impl;

import by.training.finalproject.beans.LocalAddress;
import by.training.finalproject.beans.Purchase;
import by.training.finalproject.beans.User;
import by.training.finalproject.dao.DAOexception.DAOException;
import by.training.finalproject.dao.LocalAddressDao;
import by.training.finalproject.dao.PurchaseDao;
import by.training.finalproject.dao.Transaction;
import by.training.finalproject.dao.UserDao;
import by.training.finalproject.service.PurchaseService;
import by.training.finalproject.service.serviceException.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            buildPurchase(Collections.singletonList(purchase));
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
            buildPurchase(purchases);
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

    private void buildPurchase(List<Purchase> purchases) throws ServiceException {
        try {
            UserDao userDao = (UserDao) transaction.createDao(UserDao.class.getName());
            LocalAddressDao localAddressDao = (LocalAddressDao) transaction.createDao(LocalAddressDao.class.getName());
            Map<Integer, User> users = new HashMap<>();
            Map<Integer, LocalAddress> localAddresses = new HashMap<>();
            User user;
            LocalAddress localAddress;
            Integer id;

            for (Purchase purchase : purchases) {
                user = purchase.getUser();
                if (user != null) {     // if user set in purchase
                    id = user.getId();
                    user = users.get(id);
                    if (user == null) {     // if there is no user in map
                        user = userDao.read(id);
                        users.put(id, user);
                    }
                    purchase.setUser(user);
                }
                localAddress = purchase.getLocalAddress();
                if (localAddress != null) {
                    id = localAddress.getId();
                    localAddress = localAddresses.get(id);
                    if (localAddress == null) {
                        localAddress = localAddressDao.read(id);
                        localAddresses.put(id, localAddress);
                    }
                    purchase.setLocalAddress(localAddress);
                }
            }
        } catch (DAOException e) {
            logger.error("Failed to build purchase", e);
            throw new ServiceException(e);
        }
    }
}
