package by.training.finalproject.service;

import by.training.finalproject.entity.Entity;
import by.training.finalproject.service.serviceException.ServiceException;

public interface Service<Type extends Entity> {
    void save(Type entity) throws ServiceException;
}
