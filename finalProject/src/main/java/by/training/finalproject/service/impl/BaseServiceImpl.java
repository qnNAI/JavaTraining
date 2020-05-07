package by.training.finalproject.service.impl;

import by.training.finalproject.dao.Transaction;


public abstract class BaseServiceImpl {
    protected Transaction transaction;

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public BaseServiceImpl(Transaction transaction) {
        this.transaction = transaction;
    }
}
