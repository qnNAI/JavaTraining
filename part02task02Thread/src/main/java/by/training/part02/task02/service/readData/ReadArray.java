package by.training.part02.task02.service.readData;

import by.training.part02.task02.service.serviceException.ServiceException;

public interface ReadArray {
    int[][] readArray(String path) throws ServiceException;
}
