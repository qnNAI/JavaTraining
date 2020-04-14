package by.training.finalproject.service;

import by.training.finalproject.beans.User;
import by.training.finalproject.service.serviceException.ServiceException;

public interface UserService {
    void save(User user) throws ServiceException;
    void delete(int id) throws ServiceException;
    User checkUserByLoginPassword(String login, String password) throws ServiceException;
    User findUserByID(int id) throws ServiceException;
    void updateFullUserInfo(User user) throws ServiceException;
    void updateUserAccount(User user) throws ServiceException;
}
