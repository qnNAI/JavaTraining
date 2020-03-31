package by.training.finalproject.dao.impl;

import by.training.finalproject.beans.Order;
import by.training.finalproject.dao.DAOexception.DAOException;
import by.training.finalproject.dao.OrderDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDaoImpl extends DaoImpl implements OrderDao {
    private OrderDaoImpl() {}

    @Override
    public void create(Order order) throws DAOException {
        String insert = "INSERT INTO workshopDB.order (name, wishes, user_id) VALUES (?,?,?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(insert)) {
            preparedStatement.setString(1, order.getName());
            preparedStatement.setString(2, order.getWishes());
            preparedStatement.setInt(3, order.getUser().getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Error add order", e);
        }
    }

    @Override
    public void delete(int id) throws DAOException {
        String delete = "DELETE FROM workshopDB.order WHERE id=" + id;

        try (PreparedStatement preparedStatement = connection.prepareStatement(delete)) {
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new DAOException("Error remove order ID=" + id, e);
        }
    }

    @Override
    public Order read(int id) throws DAOException {
        String select = "SELECT name, wishes, user_id FROM workshopDB.order WHERE id=" + id;
        ResultSet resultSet = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(select)) {
            resultSet = preparedStatement.executeQuery();
            Order order = null;

            if (resultSet.next()) {
                order = new Order();
                order.setId(id);
                order.setName(resultSet.getString(1));
                order.setWishes(resultSet.getString(2));
                order.getUser().setId(resultSet.getInt(3));
            }

            return order;
        } catch (SQLException e) {
            throw new DAOException("Error read order id=" + id, e);
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {}
        }
    }

    @Override
    public void update(Order entity) throws DAOException {
        throw new DAOException("Updating order is not allowed");
    }

    @Override
    public ResultSet makeOrdersSet() throws DAOException {
        String select = "SELECT * FROM workshopDB.order";

        try (PreparedStatement preparedStatement = connection.prepareStatement(select)) {
            return preparedStatement.executeQuery();

        } catch (SQLException e) {
            throw new DAOException("Error make orders set", e);
        }
    }
}
