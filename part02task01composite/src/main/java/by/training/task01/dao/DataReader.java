package by.training.task01.dao;

import by.training.task01.dao.daoException.DAOException;

public interface DataReader {
    String readData(String param) throws DAOException;
}
