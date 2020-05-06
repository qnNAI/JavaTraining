package by.training.finalproject.dao;

import by.training.finalproject.beans.ProductList;
import by.training.finalproject.dao.DAOexception.DAOException;

import java.util.List;

public interface ProductListDao extends Dao<ProductList> {
    ProductList read(int purchaseID, int productID) throws DAOException;

    void delete(int purchaseID, int productID) throws DAOException;

    List<ProductList> read() throws DAOException;
}
