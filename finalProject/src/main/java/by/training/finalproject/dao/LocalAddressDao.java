package by.training.finalproject.dao;

import by.training.finalproject.beans.LocalAddress;
import by.training.finalproject.dao.DAOexception.DAOException;

import java.sql.ResultSet;

public interface LocalAddressDao extends Dao<LocalAddress> {
    ResultSet makeLocalAddressesSet() throws DAOException;
}
