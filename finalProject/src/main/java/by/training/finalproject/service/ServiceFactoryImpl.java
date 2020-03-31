package by.training.finalproject.service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import by.training.finalproject.dao.DAOexception.DAOException;
import by.training.finalproject.dao.Transaction;
import by.training.finalproject.dao.TransactionFactory;
import by.training.finalproject.service.impl.LocalAddressServiceImpl;
import by.training.finalproject.service.impl.ProductServiceImpl;
import by.training.finalproject.service.impl.UserServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ServiceFactoryImpl implements ServiceFactory {
	private static Logger logger = LogManager.getLogger(ServiceFactoryImpl.class.getName());

	private static final Map<Class<? extends Service>, Class<? extends ServiceImpl>> SERVICES = new ConcurrentHashMap<>();

	static {
		SERVICES.put(UserService.class, UserServiceImpl.class);
		SERVICES.put(ProductService.class, ProductServiceImpl.class);
		SERVICES.put(LocalAddressService.class, LocalAddressServiceImpl.class);
	}

	private TransactionFactory factory;

	public ServiceFactoryImpl(TransactionFactory factory) throws DAOException {
		this.factory = factory;
	}

	@Override
	@SuppressWarnings("unchecked")
	public <Type extends Service> Type getService(Class<Type> key) throws DAOException {
		Class<? extends ServiceImpl> value = SERVICES.get(key);
		if(value != null) {
			try {
				ClassLoader classLoader = value.getClassLoader();
				Class<?>[] interfaces = {key};
				Transaction transaction = factory.createTransaction();
				ServiceImpl service = value.newInstance();
				service.setTransaction(transaction);
				InvocationHandler handler = new ServiceInvocationHandlerImpl(service);
				return (Type)Proxy.newProxyInstance(classLoader, interfaces, handler);
			} catch(DAOException e) {
				throw e;
			} catch(InstantiationException | IllegalAccessException e) {
				logger.error("Fail to instance service class", e);
				throw new DAOException(e);
			}
		}
		return null;
	}

	@Override
	public void close() {
		factory.close();
	}
}
