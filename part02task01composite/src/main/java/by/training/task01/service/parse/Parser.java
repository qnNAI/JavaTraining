package by.training.task01.service.parse;

import by.training.task01.composite.Component;
import by.training.task01.service.serviceException.ServiceException;

public interface Parser {
    void parse(String data, Component component) throws ServiceException;
}
