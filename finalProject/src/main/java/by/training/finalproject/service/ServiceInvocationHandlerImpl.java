package by.training.finalproject.service;

import by.training.finalproject.dao.DAOexception.DAOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ServiceInvocationHandlerImpl implements InvocationHandler {
	private static Logger logger = LogManager.getLogger(ServiceInvocationHandlerImpl.class.getName());

	private ServiceImpl service;

	public ServiceInvocationHandlerImpl(ServiceImpl service) {
		this.service = service;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] arguments) throws Throwable {
		try {
			Object result = method.invoke(service, arguments);
			service.transaction.commit();
			return result;
		} catch(DAOException e) {
			rollback(method);
			throw e;
		} catch(InvocationTargetException e) {
			rollback(method);
			throw e.getCause();
		}
	}

	private void rollback(Method method) {
		try {
			service.transaction.rollback();
		} catch(DAOException e) {
			logger.warn("Fail to rollback transaction", e);
		}
	}
}
