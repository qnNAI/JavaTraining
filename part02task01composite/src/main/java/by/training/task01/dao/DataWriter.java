package by.training.task01.dao;

import by.training.task01.dao.daoException.DAOException;

public interface DataWriter {
    void writeData(String data, String sourceName) throws DAOException;
}
