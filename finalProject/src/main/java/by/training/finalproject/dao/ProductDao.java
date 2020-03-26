package by.training.finalproject.dao;

import by.training.finalproject.beans.Product;
import by.training.finalproject.dao.DAOexception.DAOException;

import java.sql.ResultSet;

public interface ProductDao extends Dao<Product> {
    ResultSet makeProductsSet() throws DAOException;
}
