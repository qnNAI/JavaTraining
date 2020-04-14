package by.training.finalproject.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import by.training.finalproject.dao.*;
import by.training.finalproject.dao.DAOexception.DAOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class TransactionImpl implements Transaction {
	private static Logger logger = LogManager.getLogger(TransactionImpl.class.getName());

	private static Map<String, BaseDaoImpl> classes = new ConcurrentHashMap<>();
	private Connection connection;

	static {
		classes.put(UserDao.class.getName(), new UserBaseDaoImpl());
		classes.put(ProductDao.class.getName(), new ProductBaseDaoImpl());
		classes.put(LocalAddressDao.class.getName(), new LocalAddressBaseDaoImpl());
		classes.put(OrderDao.class.getName(), new OrderBaseDaoImpl());
		classes.put(ConfirmedOrderDao.class.getName(), new ConfirmedOrderBaseDaoImpl());
		classes.put(PurchaseDao.class.getName(), new PurchaseBaseDaoImpl());
	}

	public TransactionImpl(Connection connection) {
		this.connection = connection;
	}

	@Override
	public BaseDaoImpl createDao(String className) throws DAOException {
		BaseDaoImpl dao = classes.get(className);
		if(dao != null) {
			dao.setConnection(connection);
			return dao;
		}
		return null;
	}

	@Override
	public void commit() throws DAOException {
		try {
			connection.commit();
		} catch(SQLException e) {
			logger.error("Fail to commit transaction", e);
			throw new DAOException(e);
		}
	}

	@Override
	public void rollback() throws DAOException {
		try {
			connection.rollback();
		} catch(SQLException e) {
			logger.error("Fail to rollback transaction", e);
			throw new DAOException(e);
		}
	}
}
