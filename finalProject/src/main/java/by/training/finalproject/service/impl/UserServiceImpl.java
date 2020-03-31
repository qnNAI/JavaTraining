package by.training.finalproject.service.impl;

import by.training.finalproject.beans.User;
import by.training.finalproject.dao.DAOexception.DAOException;
import by.training.finalproject.dao.UserDao;
import by.training.finalproject.service.ServiceImpl;
import by.training.finalproject.service.UserService;
import by.training.finalproject.service.serviceException.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserServiceImpl extends ServiceImpl implements UserService {
    private static Logger logger = LogManager.getLogger(UserServiceImpl.class.getName());

    @Override
    public void save(User user) throws ServiceException {
        try {
            UserDao dao = transaction.createDao(UserDao.class);
            dao.create(user);
        } catch (DAOException e) {
            logger.error("Fail to save user", e);
            throw new ServiceException(e);
        }
    }

    @Override
    public void delete(int id) throws ServiceException {
        try {
            UserDao dao = transaction.createDao(UserDao.class);
            dao.delete(id);
        } catch (DAOException e) {
            logger.error("Fail to delete user", e);
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean checkUserByLoginPassword(User user) throws ServiceException {
        try {
            UserDao dao = transaction.createDao(UserDao.class);
            return dao.checkUser(user);
        } catch (DAOException e) {
            logger.error("Fail to check user by login password", e);
            throw new ServiceException(e);
        }
    }

    @Override
    public User findUserByID(int id) throws ServiceException {
        try {
            UserDao dao = transaction.createDao(UserDao.class);
            return dao.read(id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void updateFullUserInfo(User user) throws ServiceException {
        try {
            UserDao dao = transaction.createDao(UserDao.class);
            dao.update(user);
        } catch (DAOException e) {
            logger.error("Fail to update full user info", e);
            throw new ServiceException(e);
        }
    }

    @Override
    public void updateUserAccount(User user) throws ServiceException {
        try {
            UserDao dao = transaction.createDao(UserDao.class);
            dao.updateAccount(user);
        } catch (DAOException e) {
            logger.error("Fail to update user account", e);
            throw new ServiceException(e);
        }
    }
}
