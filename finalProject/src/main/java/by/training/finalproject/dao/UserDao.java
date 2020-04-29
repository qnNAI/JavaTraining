package by.training.finalproject.dao;

import by.training.finalproject.beans.User;
import by.training.finalproject.dao.DAOexception.DAOException;

import java.sql.ResultSet;
import java.util.List;

public interface UserDao extends Dao<User> {
    List<User> read() throws DAOException;
    User read(String login, String password) throws DAOException;
    void updateAccount(User user) throws DAOException;
}
