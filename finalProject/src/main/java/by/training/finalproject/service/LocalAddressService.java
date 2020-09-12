package by.training.finalproject.service;

import by.training.finalproject.entity.LocalAddress;
import by.training.finalproject.service.serviceException.ServiceException;

import java.util.List;

public interface LocalAddressService extends Service<LocalAddress> {
    void delete(int id) throws ServiceException;

    LocalAddress findByID(int id) throws ServiceException;

    List<LocalAddress> findAll() throws ServiceException;
}
