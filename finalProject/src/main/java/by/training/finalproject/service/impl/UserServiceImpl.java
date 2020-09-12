package by.training.finalproject.service.impl;

import by.training.finalproject.entity.User;
import by.training.finalproject.dao.DAOexception.DAOException;
import by.training.finalproject.dao.Transaction;
import by.training.finalproject.dao.UserDao;
import by.training.finalproject.service.UserService;
import by.training.finalproject.service.serviceException.ServiceException;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class UserServiceImpl extends BaseServiceImpl implements UserService {
    private static Logger logger = LogManager.getLogger(UserServiceImpl.class.getName());

    public UserServiceImpl(Transaction transaction) {
        super(transaction);
    }

    @Override
    public void save(User user) throws ServiceException {
        try {
            UserDao dao = (UserDao) transaction.createDao(UserDao.class.getName());
            String md5 = DigestUtils.md5Hex(user.getPassword());
            user.setPassword(md5);

            if (user.getId() == null) {
                dao.create(user);
            } else {
                dao.update(user);
            }
            transaction.commit();
        } catch (DAOException e) {
            try {
                transaction.rollback();
            } catch (DAOException ex) {
                logger.error("Failed to rollback transaction", e);
                throw new ServiceException(ex);
            }
            logger.error("Failed to save or update user", e);
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
                logger.error("Failed to rollback transaction", e);
                throw new ServiceException(ex);
            }
            logger.error("Failed to delete user", e);
            throw new ServiceException(e);
        }
    }

    @Override
    public User findUserByLoginPassword(String login, String password) throws ServiceException {
        try {
            UserDao dao = (UserDao) transaction.createDao(UserDao.class.getName());
            String md5 = DigestUtils.md5Hex(password);
            User user = dao.read(login, md5);
            transaction.commit();
            return user;
        } catch (DAOException e) {
            try {
                transaction.rollback();
            } catch (DAOException ex) {
                logger.error("Failed to rollback transaction", e);
                throw new ServiceException(ex);
            }
            logger.error("Failed to check user by login password", e);
            throw new ServiceException(e);
        }
    }

    @Override
    public User findByID(int id) throws ServiceException {
        try {
            UserDao dao = (UserDao) transaction.createDao(UserDao.class.getName());
            User user = dao.read(id);
            transaction.commit();
            return user;
        } catch (DAOException e) {
            try {
                transaction.rollback();
            } catch (DAOException ex) {
                logger.error("Failed to rollback transaction", e);
                throw new ServiceException(ex);
            }
            logger.error("Failed to find user by id", e);
            throw new ServiceException(e);
        }
    }

    @Override
    public void updateUserAccount(User user) throws ServiceException {
        try {
            UserDao dao = (UserDao) transaction.createDao(UserDao.class.getName());
            String md5 = DigestUtils.md5Hex(user.getPassword());
            user.setPassword(md5);
            dao.updateAccount(user);
            transaction.commit();
        } catch (DAOException e) {
            try {
                transaction.rollback();
            } catch (DAOException ex) {
                logger.error("Failed to rollback transaction", e);
                throw new ServiceException(ex);
            }
            logger.error("Failed to update user account", e);
            throw new ServiceException(e);
        }
    }

    @Override
    public List<User> findAll() throws ServiceException {
        try {
            UserDao dao = (UserDao) transaction.createDao(UserDao.class.getName());
            List<User> users = dao.read();
            transaction.commit();
            return users;
        } catch (DAOException e) {
            try {
                transaction.rollback();
            } catch (DAOException ex) {
                logger.error("Failed to rollback transaction", e);
                throw new ServiceException(ex);
            }
            logger.error("Failed to find all users", e);
            throw new ServiceException(e);
        }
    }
}
