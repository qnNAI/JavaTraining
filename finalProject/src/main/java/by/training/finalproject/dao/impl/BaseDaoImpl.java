package by.training.finalproject.dao.impl;

import java.sql.Connection;

public abstract class BaseDaoImpl {
    protected Connection connection;

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
