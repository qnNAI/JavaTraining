package by.training.finalproject.dao;

import by.training.finalproject.dao.DAOexception.DAOException;

public interface Transaction {
	<Type extends Dao<?>> Type createDao(Class<Type> key) throws DAOException;

	void commit() throws DAOException;

	void rollback() throws DAOException;
}
