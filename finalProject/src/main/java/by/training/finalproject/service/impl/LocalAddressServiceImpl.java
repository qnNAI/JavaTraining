package by.training.finalproject.service.impl;

import by.training.finalproject.beans.LocalAddress;
import by.training.finalproject.dao.DAOexception.DAOException;
import by.training.finalproject.dao.LocalAddressDao;
import by.training.finalproject.service.LocalAddressService;
import by.training.finalproject.service.ServiceImpl;
import by.training.finalproject.service.serviceException.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LocalAddressServiceImpl extends ServiceImpl implements LocalAddressService {
    private static Logger logger = LogManager.getLogger(LocalAddressServiceImpl.class.getName());

    @Override
    public void create(LocalAddress localAddress) throws ServiceException {
        try {
            LocalAddressDao dao = transaction.createDao(LocalAddressDao.class);
            dao.create(localAddress);
        } catch (DAOException e) {
            logger.error("Fail to save local address", e);
            throw new ServiceException(e);
        }
    }

    @Override
    public void delete(int id) throws ServiceException {
        try {
            LocalAddressDao dao = transaction.createDao(LocalAddressDao.class);
            dao.delete(id);
        } catch (DAOException e) {
            logger.error("Fail to delete local address", e);
            throw new ServiceException(e);
        }
    }

    @Override
    public LocalAddress findLocalAddressByID(int id) throws ServiceException {
        try {
            LocalAddressDao dao = transaction.createDao(LocalAddressDao.class);
            return dao.read(id);
        } catch (DAOException e) {
            logger.error("Fail to find local address by id", e);
            throw new ServiceException(e);
        }
    }
}
