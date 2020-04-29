package by.training.finalproject.dao;

import by.training.finalproject.beans.Purchase;
import by.training.finalproject.dao.DAOexception.DAOException;

import java.util.List;

public interface PurchaseDao extends Dao<Purchase> {
    List<Purchase> read() throws DAOException;
}
