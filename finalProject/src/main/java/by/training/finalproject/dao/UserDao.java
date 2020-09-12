package by.training.finalproject.dao;

import by.training.finalproject.entity.User;
import by.training.finalproject.dao.DAOexception.DAOException;

import java.util.List;

public interface UserDao extends Dao<User> {
    void delete(int id) throws DAOException;

    User read(int id) throws DAOException;

    User read(String login, String password) throws DAOException;

    void updateAccount(User user) throws DAOException;

    List<User> read() throws DAOException;
}
