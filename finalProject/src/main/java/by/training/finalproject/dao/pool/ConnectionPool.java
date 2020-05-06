package by.training.finalproject.dao.pool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import by.training.finalproject.dao.DAOexception.DAOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

final public class ConnectionPool {
	private static Logger logger = LogManager.getLogger(ConnectionPool.class.getName());

	private String url;
	private String user;
	private String password;
	private int maxSize;
	private int checkConnectionTimeout;

	private Lock locker = new ReentrantLock();

	private BlockingQueue<Connection> freeConnections = new LinkedBlockingQueue<>();
	private BlockingQueue<Connection> usedConnections = new LinkedBlockingQueue<>();

	private static ConnectionPool instance = new ConnectionPool();

	private ConnectionPool() {}

	public static ConnectionPool getInstance() {
		return instance;
	}

	public synchronized Connection getConnection() throws DAOException {
		locker.lock();
		Connection connection = null;
		while(connection == null) {
			try {
				if(!freeConnections.isEmpty()) {
					connection = freeConnections.take();
					if(!connection.isValid(checkConnectionTimeout)) {
						try {
							connection.close();
						} catch(SQLException e) {}
						connection = null;
					}
				} else if(usedConnections.size() < maxSize) {
					connection = createConnection();
					usedConnections.put(connection);
				} else {
					logger.error("The limit of number of database connections is exceeded");
					throw new DAOException();
				}
			} catch(InterruptedException | SQLException e) {
				logger.error("Error connection to database", e);
				throw new DAOException(e);
			}
		}
		usedConnections.add(connection);
		logger.debug(String.format("Connection was received from pool. Current pool size: %d used connections; %d free connection", usedConnections.size(), freeConnections.size()));
		locker.unlock();
		return connection;
	}

	public synchronized void freeConnection(Connection connection) {
		try {
			if(connection.isValid(checkConnectionTimeout)) {
				connection.clearWarnings();
				connection.setAutoCommit(true);
				usedConnections.remove(connection);
				freeConnections.put(connection);
				logger.debug(String.format("Connection was returned into pool. Current pool size: %d used connections; %d free connection", usedConnections.size(), freeConnections.size()));
			}
		} catch(SQLException | InterruptedException e1) {
			logger.warn("Error return connection to pool", e1);
			try {
				connection.close();
			} catch(SQLException e2) {}
		}
	}

	public synchronized void init(String driverClass, String url, String user, String password, int startSize,
								  int maxSize, int checkConnectionTimeout) throws DAOException {
		try {
			destroy();
			Class.forName(driverClass);
			this.url = url;
			this.user = user;
			this.password = password;
			this.maxSize = maxSize;
			this.checkConnectionTimeout = checkConnectionTimeout;
			for(int counter = 0; counter < startSize; counter++) {
				freeConnections.put(createConnection());
			}
		} catch(ClassNotFoundException | SQLException | InterruptedException e) {
			logger.fatal("Error initialize connection pool", e);
			throw new DAOException(e);
		}
	}

	private Connection createConnection() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}

	public synchronized void destroy() {
		usedConnections.addAll(freeConnections);
		freeConnections.clear();
		for(Connection connection : usedConnections) {
			try {
				connection.close();
			} catch(SQLException e) {}
		}
		usedConnections.clear();
	}

	@Override
	protected void finalize() throws Throwable {
		destroy();
	}
}
