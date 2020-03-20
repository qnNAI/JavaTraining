package by.training.task13.service.builder;

import by.training.task13.beans.User;
import by.training.task13.service.serviceException.ServiceException;

import java.util.Set;

public abstract class BaseBuilder {
    protected Set<User> users;

    public Set<User> getUsers() {
        return users;
    }

    public abstract void buildUsers(String sourceName) throws ServiceException;
}
