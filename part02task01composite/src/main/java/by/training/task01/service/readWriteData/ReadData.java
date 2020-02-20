package by.training.task01.service.readWriteData;

import by.training.task01.service.serviceException.ServiceException;

public interface ReadData {
    String readData(String param) throws ServiceException;
}
