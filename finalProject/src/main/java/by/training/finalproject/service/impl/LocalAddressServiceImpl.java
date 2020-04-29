package by.training.finalproject.service.impl;

import by.training.finalproject.beans.LocalAddress;
import by.training.finalproject.dao.DAOexception.DAOException;
import by.training.finalproject.dao.LocalAddressDao;
import by.training.finalproject.dao.Transaction;
import by.training.finalproject.service.LocalAddressService;
import by.training.finalproject.service.Service;
import by.training.finalproject.service.serviceException.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class LocalAddressServiceImpl extends Service implements LocalAddressService {
    private static Logger logger = LogManager.getLogger(LocalAddressServiceImpl.class.getName());

    public LocalAddressServiceImpl(Transaction transaction) {
        super(transaction);
    }

    @Override
    public void save(LocalAddress localAddress) throws ServiceException {
        try {
            LocalAddressDao dao = (LocalAddressDao) transaction.createDao(LocalAddressDao.class.getName());
            dao.create(localAddress);
            transaction.commit();
        } catch (DAOException e) {
            try {
                transaction.rollback();
            } catch (DAOException ex) {
                logger.error("Fail to rollback transaction", e);
                throw new ServiceException(ex);
            }
            logger.error("Fail to save local address", e);
            throw new ServiceException(e);
        }
    }

    @Override
    public void delete(int id) throws ServiceException {
        try {
            LocalAddressDao dao = (LocalAddressDao) transaction.createDao(LocalAddressDao.class.getName());
            dao.delete(id);
            transaction.commit();
        } catch (DAOException e) {
            try {
                transaction.rollback();
            } catch (DAOException ex) {
                logger.error("Fail to rollback transaction", e);
                throw new ServiceException(ex);
            }
            logger.error("Fail to delete local address", e);
            throw new ServiceException(e);
        }
    }

    @Override
    public LocalAddress findLocalAddressByID(int id) throws ServiceException {
        try {
            LocalAddressDao dao = (LocalAddressDao) transaction.createDao(LocalAddressDao.class.getName());
            LocalAddress localAddress = dao.read(id);
            transaction.commit();
            return localAddress;
        } catch (DAOException e) {
            try {
                transaction.rollback();
            } catch (DAOException ex) {
                logger.error("Fail to rollback transaction", e);
                throw new ServiceException(ex);
            }
            logger.error("Fail to find local address by id", e);
            throw new ServiceException(e);
        }
    }
}
