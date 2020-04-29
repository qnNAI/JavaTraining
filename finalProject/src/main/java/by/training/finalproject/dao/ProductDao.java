package by.training.finalproject.dao;

import by.training.finalproject.beans.Product;
import by.training.finalproject.dao.DAOexception.DAOException;

import java.sql.ResultSet;
import java.util.List;

public interface ProductDao extends Dao<Product> {
    List<Product> read() throws DAOException;
}
