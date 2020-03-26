package by.training.finalproject.dao.impl;

import java.sql.Connection;

public abstract class DaoImpl {
    protected Connection connection;

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
