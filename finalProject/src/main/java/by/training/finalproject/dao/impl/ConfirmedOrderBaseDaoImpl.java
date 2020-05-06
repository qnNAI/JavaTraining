package by.training.finalproject.dao.impl;

import by.training.finalproject.beans.ConfirmedOrder;
import by.training.finalproject.beans.LocalAddress;
import by.training.finalproject.beans.Order;
import by.training.finalproject.beans.infoEnum.ObtainingMethod;
import by.training.finalproject.dao.ConfirmedOrderDao;
import by.training.finalproject.dao.DAOexception.DAOException;
import org.jetbrains.annotations.NotNull;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class ConfirmedOrderBaseDaoImpl extends BaseDaoImpl implements ConfirmedOrderDao {
    @Override
    public void create(ConfirmedOrder confirmedOrder) throws DAOException {
        String insert = "INSERT INTO workshopDB.confirmedOrder (order_id, state, finalPrice, amount, address, localAddress_id, date, obtainingMethod) VALUES (?,?,?,?,?,?,?,?)";

        try(PreparedStatement preparedStatement = connection.prepareStatement(insert)) {
            setFullConfirmedOrderStatement(confirmedOrder, preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Failed to create confirmed order", e);
        }
    }

    @Override
    public ConfirmedOrder read(int id) throws DAOException {
        String select = "SELECT order_id, state, finalPrice, amount, address, localAddress_id, date, obtainingMethod FROM workshopdb.confirmedOrder WHERE id=" + id;

        try (PreparedStatement preparedStatement = connection.prepareStatement(select)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            ConfirmedOrder confirmedOrder = null;

            if (resultSet.next()) {
                confirmedOrder = new ConfirmedOrder();
                confirmedOrder.setId(id);
                setConfirmedOrderFields(resultSet, confirmedOrder);
            }
            return confirmedOrder;
        } catch (SQLException e) {
            throw new DAOException("Failed to read confirmed order", e);
        }
    }

    @Override
    public void update(ConfirmedOrder confirmedOrder) throws DAOException {
        String update = "UPDATE workshopdb.confirmedorder SET order_id=?, state=?, finalPrice=?, amount=?, address=?, localAddress_id=?, date=?, obtainingMethod=? WHERE id=" + confirmedOrder.getId();

        try(PreparedStatement preparedStatement = connection.prepareStatement(update)) {
            setFullConfirmedOrderStatement(confirmedOrder, preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Failed to update confirmed order", e);
        }
    }

    @Override
    public void delete(int id) throws DAOException {
        String delete = "DELETE FROM workshopdb.confirmedorder WHERE id=" + id;

        try(PreparedStatement preparedStatement = connection.prepareStatement(delete)) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Failed to remove confirmed order", e);
        }
    }

    @Override
    public List<ConfirmedOrder> read() throws DAOException {
        String select = "SELECT * FROM workshopdb.confirmedOrder";

        try (PreparedStatement preparedStatement = connection.prepareStatement(select)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            List<ConfirmedOrder> confirmedOrders = new ArrayList<>();
            ConfirmedOrder confirmedOrder;

            while (resultSet.next()) {
                confirmedOrder = new ConfirmedOrder();
                confirmedOrder.setId(resultSet.getInt("id"));
                setConfirmedOrderFields(resultSet, confirmedOrder);
                confirmedOrders.add(confirmedOrder);
            }
            return confirmedOrders;
        } catch (SQLException e) {
            throw new DAOException("Failed to read confirmed orders", e);
        }
    }

    @NotNull
    private ConfirmedOrder setConfirmedOrderFields(ResultSet resultSet, ConfirmedOrder confirmedOrder) throws SQLException {
        Order order = new Order();
        order.setId(resultSet.getInt("order_id"));
        confirmedOrder.setOrder(order);
        confirmedOrder.setState(ConfirmedOrder.State.getByName(resultSet.getString("state")));
        confirmedOrder.setFinalPrice(resultSet.getDouble("finalPrice"));
        confirmedOrder.setAmount(resultSet.getInt("amount"));
        ObtainingMethod obtainingMethod = ObtainingMethod.getByName(resultSet.getString("obtainingMethod"));
        if (obtainingMethod == ObtainingMethod.DELIVERY) {
            confirmedOrder.setAddress(resultSet.getString("address"));
        } else {
            LocalAddress localAddress = new LocalAddress();
            localAddress.setId(resultSet.getInt("localAddress_id"));
            confirmedOrder.setLocalAddress(localAddress);
        }
        confirmedOrder.setDate(resultSet.getDate("date").toLocalDate());
        confirmedOrder.setObtainingMethod(obtainingMethod);
        return confirmedOrder;
    }

    private void setFullConfirmedOrderStatement(ConfirmedOrder confirmedOrder, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setInt(1, confirmedOrder.getOrder().getId());
        preparedStatement.setString(2, String.valueOf(confirmedOrder.getState().getName()));
        preparedStatement.setDouble(3, confirmedOrder.getFinalPrice());
        preparedStatement.setInt(4, confirmedOrder.getAmount());
        if (confirmedOrder.getObtainingMethod() == ObtainingMethod.PICKUP) {
            preparedStatement.setNull(5, Types.VARCHAR);
            preparedStatement.setInt(6, confirmedOrder.getLocalAddress().getId());
        } else {
            preparedStatement.setString(5, confirmedOrder.getAddress());
            preparedStatement.setNull(6, Types.INTEGER);
        }
        preparedStatement.setDate(7, java.sql.Date.valueOf(confirmedOrder.getDate()));
        preparedStatement.setString(8, confirmedOrder.getObtainingMethod().getName());
    }
}
