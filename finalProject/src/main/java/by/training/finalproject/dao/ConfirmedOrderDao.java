package by.training.finalproject.dao;

import by.training.finalproject.beans.ConfirmedOrder;
import by.training.finalproject.dao.DAOexception.DAOException;

import java.util.List;

public interface ConfirmedOrderDao extends Dao<ConfirmedOrder> {
    ConfirmedOrder read(int id) throws DAOException;

    void delete(int id) throws DAOException;
}
