package by.training.finalproject.service;

import by.training.finalproject.beans.LocalAddress;
import by.training.finalproject.service.serviceException.ServiceException;

import java.util.List;

public interface LocalAddressService {
    void save(LocalAddress localAddress) throws ServiceException;
    void delete(int id) throws ServiceException;
    LocalAddress findLocalAddressByID(int id) throws ServiceException;
    List<LocalAddress> findAll() throws ServiceException;
}
