package by.training.finalproject.service;

import by.training.finalproject.dao.Transaction;

public abstract class ServiceImpl implements Service {
    protected Transaction transaction = null;

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
}
