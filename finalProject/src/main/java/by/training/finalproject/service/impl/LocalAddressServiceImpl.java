package by.training.finalproject.service.impl;

import by.training.finalproject.entity.LocalAddress;
import by.training.finalproject.dao.DAOexception.DAOException;
import by.training.finalproject.dao.LocalAddressDao;
import by.training.finalproject.dao.Transaction;
import by.training.finalproject.service.LocalAddressService;
import by.training.finalproject.service.serviceException.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;


public class LocalAddressServiceImpl extends BaseServiceImpl implements LocalAddressService {
    private static Logger logger = LogManager.getLogger(LocalAddressServiceImpl.class.getName());

    public LocalAddressServiceImpl(Transaction transaction) {
        super(transaction);
    }

    @Override
    public void save(LocalAddress localAddress) throws ServiceException {
        try {
            LocalAddressDao dao = (LocalAddressDao) transaction.createDao(LocalAddressDao.class.getName());
            if (localAddress.getId() == null) {
                dao.create(localAddress);
            } else {
                dao.update(localAddress);
            }
            transaction.commit();
        } catch (DAOException e) {
            try {
                transaction.rollback();
            } catch (DAOException ex) {
                logger.error("Failed to rollback transaction", e);
                throw new ServiceException(ex);
            }
            logger.error("Failed to save or update local address", e);
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
                logger.error("Failed to rollback transaction", e);
                throw new ServiceException(ex);
            }
            logger.error("Failed to delete local address", e);
            throw new ServiceException(e);
        }
    }

    @Override
    public LocalAddress findByID(int id) throws ServiceException {
        try {
            LocalAddressDao dao = (LocalAddressDao) transaction.createDao(LocalAddressDao.class.getName());
            LocalAddress localAddress = dao.read(id);
            transaction.commit();
            return localAddress;
        } catch (DAOException e) {
            try {
                transaction.rollback();
            } catch (DAOException ex) {
                logger.error("Failed to rollback transaction", e);
                throw new ServiceException(ex);
            }
            logger.error("Failed to find local address by id", e);
            throw new ServiceException(e);
        }
    }

    @Override
    public List<LocalAddress> findAll() throws ServiceException {
        try {
            LocalAddressDao dao = (LocalAddressDao) transaction.createDao(LocalAddressDao.class.getName());
            List<LocalAddress> localAddresses = dao.read();
            transaction.commit();
            return localAddresses;
        } catch (DAOException e) {
            try {
                transaction.rollback();
            } catch (DAOException ex) {
                logger.error("Failed to rollback transaction", e);
                throw new ServiceException(ex);
            }
            logger.error("Failed to find all local addresses", e);
            throw new ServiceException(e);
        }
    }
}
