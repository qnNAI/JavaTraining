package by.training.finalproject.dao;

import by.training.finalproject.beans.User;
import by.training.finalproject.dao.DAOexception.DAOException;

import java.sql.ResultSet;
import java.util.List;

public interface UserDao extends Dao<User> {
    User read(int id) throws DAOException;

    User read(String login, String password) throws DAOException;

    List<User> read() throws DAOException;

    void updateAccount(User user) throws DAOException;

    void delete(int id) throws DAOException;
}
