package by.training.finalproject.service;

import by.training.finalproject.beans.Entity;
import by.training.finalproject.service.serviceException.ServiceException;

import java.util.List;

public interface Service<Type extends Entity> {
    void save(Type entity) throws ServiceException;

    List<Type> findAll() throws ServiceException;
}
