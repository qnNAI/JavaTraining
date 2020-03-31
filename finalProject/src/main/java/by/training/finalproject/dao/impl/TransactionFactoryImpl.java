package by.training.finalproject.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;

import by.training.finalproject.dao.DAOexception.DAOException;
import by.training.finalproject.dao.Transaction;
import by.training.finalproject.dao.TransactionFactory;
import by.training.finalproject.dao.pool.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class TransactionFactoryImpl implements TransactionFactory {
	private static Logger logger = LogManager.getLogger(TransactionFactoryImpl.class.getName());
	private Connection connection;
	
	public TransactionFactoryImpl() throws DAOException {
		connection = ConnectionPool.getInstance().getConnection();
		try {
			connection.setAutoCommit(false);
		} catch(SQLException e) {
			logger.error("Fail to turn off autocommit for database connection", e);
			throw new DAOException(e);
		}
	}

	@Override
	public Transaction createTransaction() throws DAOException {
		return new TransactionImpl(connection);
	}

	@Override
	public void close() {
		try {
			connection.close();
		} catch(SQLException e) {}
	}
}
