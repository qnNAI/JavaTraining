package by.training.finalproject.dao;

import by.training.finalproject.beans.LocalAddress;
import by.training.finalproject.dao.DAOexception.DAOException;

import java.sql.ResultSet;
import java.util.List;

public interface LocalAddressDao extends Dao<LocalAddress> {
    List<LocalAddress> read() throws DAOException;
}
