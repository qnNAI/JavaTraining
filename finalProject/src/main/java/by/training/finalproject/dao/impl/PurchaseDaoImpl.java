package by.training.finalproject.dao.impl;

import by.training.finalproject.beans.Purchase;
import by.training.finalproject.dao.DAOexception.DAOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PurchaseDaoImpl {
    private PurchaseDaoImpl() {}

    public static void addPurchase(Connection connection, Purchase purchase) throws DAOException {
        String insert = "INSERT INTO workshopDB.purchase (product_id, user_id, finalPrice, address, localAddress_id, date, state," +
                " obtainingMethod_id) VALUES (?,?,?,?,?,?,?,?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(insert)) {
         //  preparedStatement
        } catch (SQLException e) {
            throw new DAOException("Error add purchase", e);
        }
    }
}
