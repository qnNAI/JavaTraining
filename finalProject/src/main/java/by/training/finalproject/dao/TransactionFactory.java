package by.training.finalproject.dao;

import by.training.finalproject.dao.DAOexception.DAOException;

public interface TransactionFactory {
	Transaction createTransaction() throws DAOException;

	void close() throws DAOException;
}
