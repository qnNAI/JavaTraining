package by.training.finalproject.dao.impl;

import by.training.finalproject.beans.LocalAddress;
import by.training.finalproject.beans.Purchase;
import by.training.finalproject.beans.User;
import by.training.finalproject.beans.infoEnum.ObtainingMethod;
import by.training.finalproject.dao.DAOexception.DAOException;
import by.training.finalproject.dao.PurchaseDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class PurchaseDaoImpl extends BaseDaoImpl implements PurchaseDao {
    @Override
    public void create(Purchase purchase) throws DAOException {
        String insert;

        if (purchase.getLocalAddress() != null) {
            insert = "INSERT INTO workshopDB.purchase (user_id, state, address, localAddress_id, date, obtainingMethod) VALUES (?,?,?,?,?,?)";
        } else {
            insert = "INSERT INTO workshopDB.purchase (user_id, state) VALUES (?,?)";
        }

        try (PreparedStatement preparedStatement = connection.prepareStatement(insert)) {
            if (purchase.getLocalAddress() != null) {
                setFullPurchaseStatement(purchase, preparedStatement);
            } else {
                preparedStatement.setInt(1, purchase.getUser().getId());
                preparedStatement.setString(2, purchase.getState().getName());
            }
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Failed to add purchase", e);
        }
    }

    @Override
    public Purchase read(int id) throws DAOException {
        String select = "SELECT user_id, state, address, localAddress_id, date, obtainingMethod FROM workshopdb.purchase WHERE id=" + id;

        try (PreparedStatement preparedStatement = connection.prepareStatement(select)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            Purchase purchase = null;

            if (resultSet.next()) {
                purchase = new Purchase();
                purchase.setId(id);
                setPurchaseFields(resultSet, purchase);
            }
            return purchase;
        } catch (SQLException e) {
            throw new DAOException("Failed to read purchase", e);
        }
    }

    @Override
    public void update(Purchase purchase) throws DAOException {
        String update = "UPDATE workshopdb.purchase SET user_id=?, state=?, address=?, localAddress_id=?, date=?, obtainingMethod=? WHERE id=" + purchase.getId() ;

        try (PreparedStatement preparedStatement = connection.prepareStatement(update)) {
            setFullPurchaseStatement(purchase, preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Failed to update purchase", e);
        }
    }

    @Override
    public void delete(int id) throws DAOException {
        String delete = "DELETE FROM workshopDB.purchase WHERE id=" + id;

        try (PreparedStatement preparedStatement = connection.prepareStatement(delete)) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Failed to delete purchase");
        }
    }

    @Override
    public List<Purchase> read() throws DAOException {
        String select = "SELECT * FROM workshopdb.purchase";

        try (PreparedStatement preparedStatement = connection.prepareStatement(select)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Purchase> purchases = new ArrayList<>();
            Purchase purchase;

            while (resultSet.next()) {
                purchase = new Purchase();
                purchase.setId(resultSet.getInt("id"));
                setPurchaseFields(resultSet, purchase);
                purchases.add(purchase);
            }
            return purchases;
        } catch (SQLException e) {
            throw new DAOException("Failed to read purchases", e);
        }
    }

    @Override
    public List<Purchase> readIdAndStateByUserId(int userID) throws DAOException {
        String select = "SELECT id, state FROM workshopdb.purchase WHERE user_id=" + userID;

        try (PreparedStatement preparedStatement = connection.prepareStatement(select)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Purchase> purchases = new ArrayList<>();
            Purchase purchase;

            while (resultSet.next()) {
                purchase = new Purchase();
                purchase.setId(resultSet.getInt("id"));
                purchase.setState(Purchase.State.getByName(resultSet.getString("state")));
                purchases.add(purchase);
            }
            return purchases;
        } catch (SQLException e) {
            throw new DAOException("Failed to read purchases id and state by user id", e);
        }
    }

    private void setPurchaseFields(ResultSet resultSet, Purchase purchase) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("user_id"));
        purchase.setUser(user);
        purchase.setState(Purchase.State.getByName(resultSet.getString("state")));
        String method = resultSet.getString("obtainingMethod");
        if (!resultSet.wasNull()) {
            ObtainingMethod obtainingMethod = ObtainingMethod.getByName(method);
            if (obtainingMethod == ObtainingMethod.DELIVERY) {
                String address = resultSet.getString("address");
                if (!resultSet.wasNull()) {
                    purchase.setAddress(address);
                }
            } else {
                LocalAddress localAddress = new LocalAddress();
                int localAddressId = resultSet.getInt("localAddress_id");
                if (!resultSet.wasNull()) {
                    localAddress.setId(localAddressId);
                    purchase.setLocalAddress(localAddress);
                }
            }
            purchase.setObtainingMethod(obtainingMethod);
        }
        java.sql.Date date = resultSet.getDate("date");
        if (!resultSet.wasNull()) {
            purchase.setDate(date.toLocalDate());
        }

    }

    private void setFullPurchaseStatement(Purchase purchase, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setInt(1, purchase.getUser().getId());
        preparedStatement.setString(2, purchase.getState().getName());
        ObtainingMethod obtainingMethod = purchase.getObtainingMethod();
        if (obtainingMethod == ObtainingMethod.DELIVERY) {
            preparedStatement.setString(3, purchase.getAddress());
            preparedStatement.setNull(4, Types.INTEGER);
        } else {
            preparedStatement.setNull(3, Types.VARCHAR);
            preparedStatement.setInt(4, purchase.getLocalAddress().getId());
        }
        preparedStatement.setDate(5, java.sql.Date.valueOf(purchase.getDate()));
        preparedStatement.setString(6, obtainingMethod.getName());
    }
}
