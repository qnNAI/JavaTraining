package by.training.task01.service.readWriteData;

import by.training.task01.dao.DataReader;
import by.training.task01.dao.daoException.DAOException;
import by.training.task01.dao.factory.DAOFactory;
import by.training.task01.service.serviceException.ServiceException;

public class ReadFile implements ReadData {
    @Override
    public String readData(String param) throws ServiceException  {
        DAOFactory daoFactory = DAOFactory.getInstance();
        DataReader dataReader = daoFactory.getDataReader();
        String data;

        try {
            data = dataReader.readData(param);
        } catch (DAOException ex) {
            throw new ServiceException("Read data -> DAO exception", ex);
        }

        return data;
    }
}
