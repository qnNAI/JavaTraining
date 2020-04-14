package by.training.finalproject.dao;

import by.training.finalproject.dao.DAOexception.DAOException;
import by.training.finalproject.dao.impl.BaseDaoImpl;

public interface Transaction {
	BaseDaoImpl createDao(String className) throws DAOException;

	void commit() throws DAOException;

	void rollback() throws DAOException;
}
