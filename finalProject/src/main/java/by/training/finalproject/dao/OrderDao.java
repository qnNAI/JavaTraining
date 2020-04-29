package by.training.finalproject.dao;

import by.training.finalproject.beans.Order;
import by.training.finalproject.dao.DAOexception.DAOException;

import java.sql.ResultSet;
import java.util.List;

public interface OrderDao extends Dao<Order> {
    List<Order> read() throws DAOException;
}
