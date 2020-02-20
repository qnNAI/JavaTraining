package by.training.task01.service.readWriteData;

import by.training.task01.dao.DataWriter;
import by.training.task01.dao.daoException.DAOException;
import by.training.task01.dao.factory.DAOFactory;
import by.training.task01.service.serviceException.ServiceException;

public class WriteFile implements WriteData {
    @Override
    public void writeData(String data, String param) throws ServiceException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        DataWriter dataWriter = daoFactory.getDataWriter();

        try {
            dataWriter.writeData(data, param);
        } catch (DAOException ex) {
            throw new ServiceException("Data write -> DAO exception", ex);
        }
    }
}
