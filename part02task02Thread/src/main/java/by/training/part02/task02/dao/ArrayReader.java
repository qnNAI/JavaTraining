package by.training.part02.task02.dao;

import by.training.part02.task02.dao.daoException.DAOException;

public interface ArrayReader {
    int[][] readArray(String path) throws DAOException;
}
