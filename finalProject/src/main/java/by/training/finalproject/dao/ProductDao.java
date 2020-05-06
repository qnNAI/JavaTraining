package by.training.finalproject.dao;

import by.training.finalproject.beans.Product;
import by.training.finalproject.dao.DAOexception.DAOException;

import java.util.List;

public interface ProductDao extends Dao<Product> {
    void delete(int id) throws DAOException;

    Product read(int id) throws DAOException;

    List<Product> read() throws DAOException;
}
