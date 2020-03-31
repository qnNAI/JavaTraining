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

	private static Map<Class<? extends Dao<?>>, Class<? extends DaoImpl>> classes = new ConcurrentHashMap<>();
	static {
		classes.put(UserDao.class, UserDaoImpl.class);
		classes.put(ProductDao.class, ProductDaoImpl.class);
		classes.put(LocalAddressDao.class, LocalAddressDaoImpl.class);
		classes.put(OrderDao.class, OrderDaoImpl.class);
		classes.put(ConfirmedOrderDao.class, ConfirmedOrderDaoImpl.class);
		classes.put(PurchaseDao.class, PurchaseDaoImpl.class);
	}

	private Connection connection;

	public TransactionImpl(Connection connection) {
		this.connection = connection;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <Type extends Dao<?>> Type createDao(Class<Type> key) throws DAOException {
		Class<? extends DaoImpl> value = classes.get(key);
		if(value != null) {
			try {
				DaoImpl dao = value.newInstance();
				dao.setConnection(connection);
				return (Type)dao;
			} catch(InstantiationException | IllegalAccessException e) {
				logger.error("Fail to create data access object", e);
				throw new DAOException(e);
			}
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
