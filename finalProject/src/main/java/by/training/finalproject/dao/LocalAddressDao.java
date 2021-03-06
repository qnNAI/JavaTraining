package by.training.finalproject.dao;

import by.training.finalproject.entity.LocalAddress;
import by.training.finalproject.dao.DAOexception.DAOException;

import java.util.List;

public interface LocalAddressDao extends Dao<LocalAddress> {
    LocalAddress read(int id) throws DAOException;

    void delete(int id) throws DAOException;

    List<LocalAddress> read() throws DAOException;
}
