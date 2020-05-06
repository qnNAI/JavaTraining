package by.training.finalproject.dao;

import by.training.finalproject.beans.Entity;
import by.training.finalproject.dao.DAOexception.DAOException;

public interface Dao<Type extends Entity> {
    void create(Type entity) throws DAOException;

    void update(Type entity) throws DAOException;
}
