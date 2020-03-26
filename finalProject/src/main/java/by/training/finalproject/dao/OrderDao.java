package by.training.finalproject.dao;

import by.training.finalproject.beans.Order;
import by.training.finalproject.dao.DAOexception.DAOException;

import java.sql.ResultSet;

public interface OrderDao extends Dao<Order> {
    ResultSet makeOrdersSet() throws DAOException;
}
