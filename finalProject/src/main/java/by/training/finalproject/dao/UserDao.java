package by.training.finalproject.dao;

import by.training.finalproject.beans.User;
import by.training.finalproject.dao.DAOexception.DAOException;

import java.sql.ResultSet;

public interface UserDao extends Dao<User> {
    ResultSet makeUsersSet() throws DAOException;
    User read(String login, String password) throws DAOException;
    void updateAccount(User user) throws DAOException;
}
