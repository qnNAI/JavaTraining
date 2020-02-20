package by.training.task01.service.readWriteData;

import by.training.task01.service.serviceException.ServiceException;

public interface WriteData {
    void writeData(String data, String param) throws ServiceException;
}
