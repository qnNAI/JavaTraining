package by.training.finalproject.service;

import by.training.finalproject.dao.DAOexception.DAOException;

public interface ServiceFactory {
	<Type extends Service> Type getService(Class<Type> key) throws DAOException;

	void close();
}
