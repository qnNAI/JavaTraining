package by.training.part02.task02.service.readData;

import by.training.part02.task02.dao.ArrayReader;
import by.training.part02.task02.dao.daoException.DAOException;
import by.training.part02.task02.dao.factory.DAOFactory;
import by.training.part02.task02.service.serviceException.ServiceException;

public class ReadArrayFile implements ReadArray {
    @Override
    public int[][] readArray(String path) throws ServiceException {
        DAOFactory instance =DAOFactory.getInstance();
        ArrayReader arrayReader = instance.getArrayReader();

        try {
            return arrayReader.readArray(path);
        } catch (DAOException ex) {
            throw new ServiceException("Service -> read array exception", ex);
        }
    }
}
