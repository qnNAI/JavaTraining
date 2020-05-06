package by.training.finalproject.dao;

import by.training.finalproject.beans.Order;
import by.training.finalproject.dao.DAOexception.DAOException;

import java.sql.ResultSet;
import java.util.List;

public interface OrderDao extends Dao<Order> {
    void delete(int id) throws DAOException;
    Order read(int id) throws DAOException;
    List<Order> read() throws DAOException;
}
