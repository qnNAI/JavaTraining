package by.training.finalproject.dao;

import by.training.finalproject.beans.ConfirmedOrder;
import by.training.finalproject.dao.DAOexception.DAOException;

import java.util.List;

public interface ConfirmedOrderDao extends Dao<ConfirmedOrder> {
    void delete(int id) throws DAOException;

    ConfirmedOrder read(int id) throws DAOException;

    List<ConfirmedOrder> read() throws DAOException;
}
