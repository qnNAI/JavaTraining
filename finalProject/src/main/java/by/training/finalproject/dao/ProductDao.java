package by.training.finalproject.dao;

import by.training.finalproject.beans.Product;
import by.training.finalproject.dao.DAOexception.DAOException;

public interface ProductDao extends Dao<Product> {
    Product read(int id) throws DAOException;

    void delete(int id) throws DAOException;
}
