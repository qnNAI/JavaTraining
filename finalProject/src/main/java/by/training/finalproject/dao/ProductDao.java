package by.training.finalproject.dao;

import by.training.finalproject.entity.Product;
import by.training.finalproject.dao.DAOexception.DAOException;

import java.util.List;

public interface ProductDao extends Dao<Product> {
    Product read(int id) throws DAOException;

    void delete(int id) throws DAOException;

    int countRecordsWhereIdIsNull() throws DAOException;

    List<Product> read(int start, int amount) throws DAOException;

    List<Product> readWithIdIsNull(int start, int amount) throws DAOException;
}
