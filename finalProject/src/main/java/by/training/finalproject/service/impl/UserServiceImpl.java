package by.training.finalproject.service.impl;

import by.training.finalproject.beans.User;
import by.training.finalproject.dao.DAOexception.DAOException;
import by.training.finalproject.dao.Transaction;
import by.training.finalproject.dao.UserDao;
import by.training.finalproject.service.Service;
import by.training.finalproject.service.UserService;
import by.training.finalproject.service.serviceException.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserServiceImpl extends Service implements UserService {
    private static Logger logger = LogManager.getLogger(UserServiceImpl.class.getName());

    public UserServiceImpl(Transaction transaction) {
        super(transaction);
    }

    @Override
    public void save(User user) throws ServiceException {
        try {
            UserDao dao = (UserDao) transaction.createDao(UserDao.class.getName());
            dao.create(user);
            transaction.commit();
        } catch (DAOException e) {
            try {
                transaction.rollback();
            } catch (DAOException ex) {
                logger.error("Fail to rollback transaction", e);
                throw new ServiceException(ex);
            }
            logger.error("Fail to save user", e);
            throw new ServiceException(e);
        }
    }

    @Override
    public void delete(int id) throws ServiceException {
        try {
            UserDao dao = (UserDao) transaction.createDao(UserDao.class.getName());
            dao.delete(id);
            transaction.commit();
        } catch (DAOException e) {
            try {
                transaction.rollback();
            } catch (DAOException ex) {
                logger.error("Fail to rollback transaction", e);
                throw new ServiceException(ex);
            }
            logger.error("Fail to delete user", e);
            throw new ServiceException(e);
        }
    }

    @Override
    public User checkUserByLoginPassword(String login, String password) throws ServiceException {
        try {
            UserDao dao = (UserDao) transaction.createDao(UserDao.class.getName());
            User user = dao.read(login, password);
            transaction.commit();
            return user;
        } catch (DAOException e) {
            try {
                transaction.rollback();
            } catch (DAOException ex) {
                logger.error("Fail to rollback transaction", e);
                throw new ServiceException(ex);
            }
            logger.error("Fail to check user by login password", e);
            throw new ServiceException(e);
        }
    }

    @Override
    public User findUserByID(int id) throws ServiceException {
        try {
            UserDao dao = (UserDao) transaction.createDao(UserDao.class.getName());
            User user = dao.read(id);
            transaction.commit();
            return user;
        } catch (DAOException e) {
            try {
                transaction.rollback();
            } catch (DAOException ex) {
                logger.error("Fail to rollback transaction", e);
                throw new ServiceException(ex);
            }
            logger.error("Fail to find user by id", e);
            throw new ServiceException(e);
        }
    }

    @Override
    public void updateFullUserInfo(User user) throws ServiceException {
        try {
            UserDao dao = (UserDao) transaction.createDao(UserDao.class.getName());
            dao.update(user);
            transaction.commit();
        } catch (DAOException e) {
            try {
                transaction.rollback();
            } catch (DAOException ex) {
                logger.error("Fail to rollback transaction", e);
                throw new ServiceException(ex);
            }
            logger.error("Fail to update full user info", e);
            throw new ServiceException(e);
        }
    }

    @Override
    public void updateUserAccount(User user) throws ServiceException {
        try {
            UserDao dao = (UserDao) transaction.createDao(UserDao.class.getName());
            dao.updateAccount(user);
            transaction.commit();
        } catch (DAOException e) {
            try {
                transaction.rollback();
            } catch (DAOException ex) {
                logger.error("Fail to rollback transaction", e);
                throw new ServiceException(ex);
            }
            logger.error("Fail to update user account", e);
            throw new ServiceException(e);
        }
    }
}
