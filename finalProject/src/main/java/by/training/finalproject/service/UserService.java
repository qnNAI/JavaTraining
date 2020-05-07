package by.training.finalproject.service;

import by.training.finalproject.beans.User;
import by.training.finalproject.service.serviceException.ServiceException;

import java.util.List;

public interface UserService extends Service<User> {
    User findUserByLoginPassword(String login, String password) throws ServiceException;
    void updateUserAccount(User user) throws ServiceException;
}
