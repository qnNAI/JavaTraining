package by.training.task01.dao;

import by.training.task01.dao.daoException.DAOException;

import java.util.List;

public interface DataReader {
    List<String> readData(String param) throws DAOException;
}
