package by.training.finalproject.dao.impl;

import by.training.finalproject.beans.Purchase;
import by.training.finalproject.dao.DAOexception.DAOException;
import by.training.finalproject.dao.PurchaseDao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PurchaseBaseDaoImpl extends BaseDaoImpl implements PurchaseDao {
   // private PurchaseBaseDaoImpl() {}

    @Override
    public void create(Purchase purchase) throws DAOException {
        String insert = "INSERT INTO workshopDB.purchase (product_id, user_id, finalPrice, address, localAddress_id, date, state," +
                " obtainingMethod_id) VALUES (?,?,?,?,?,?,?,?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(insert)) {
         //  preparedStatement
        } catch (SQLException e) {
            throw new DAOException("Fail add purchase", e);
        }
    }

    @Override
    public Purchase read(int id) throws DAOException {
        return null;
    }

    @Override
    public void update(Purchase entity) throws DAOException {

    }

    @Override
    public void delete(int id) throws DAOException {

    }
}
