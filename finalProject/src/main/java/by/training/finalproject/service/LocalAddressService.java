package by.training.finalproject.service;

import by.training.finalproject.beans.LocalAddress;
import by.training.finalproject.service.serviceException.ServiceException;

public interface LocalAddressService extends Service {
    void create(LocalAddress localAddress) throws ServiceException;
    void delete(int id) throws ServiceException;
    LocalAddress findLocalAddressByID(int id) throws ServiceException;
}
