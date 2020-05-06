package by.training.finalproject.dao.impl;

import by.training.finalproject.beans.Order;
import by.training.finalproject.beans.User;
import by.training.finalproject.dao.DAOexception.DAOException;
import by.training.finalproject.dao.OrderDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderBaseDaoImpl extends BaseDaoImpl implements OrderDao {
    @Override
    public void create(Order order) throws DAOException {
        String insert = "INSERT INTO workshopDB.order (name, wishes, user_id) VALUES (?,?,?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(insert)) {
            preparedStatement.setString(1, order.getName());
            preparedStatement.setString(2, order.getWishes());
            preparedStatement.setInt(3, order.getUser().getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Failed to add order", e);
        }
    }

    @Override
    public void delete(int id) throws DAOException {
        String delete = "DELETE FROM workshopDB.order WHERE id=" + id;

        try (PreparedStatement preparedStatement = connection.prepareStatement(delete)) {
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new DAOException("Failed to remove order", e);
        }
    }

    @Override
    public Order read(int id) throws DAOException {
        String select = "SELECT name, wishes, user_id FROM workshopDB.order WHERE id=" + id;

        try (PreparedStatement preparedStatement = connection.prepareStatement(select)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            Order order = null;
            User user;

            if (resultSet.next()) {
                order = new Order();
                order.setId(id);
                order.setName(resultSet.getString("name"));
                order.setWishes(resultSet.getString("wishes"));
                user = new User();
                user.setId(resultSet.getInt("user_id"));
                order.setUser(user);
            }
            return order;
        } catch (SQLException e) {
            throw new DAOException("Failed to read order", e);
        }
    }

    @Override
    public void update(Order order) throws DAOException {
        String update = "UPDATE workshopDB.order SET name=?, wishes=?, user_id=? WHERE id=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(update)) {
            preparedStatement.setString(1, order.getName());
            preparedStatement.setString(2, order.getWishes());
            preparedStatement.setInt(3, order.getUser().getId());
            preparedStatement.setInt(4, order.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Failed to update order", e);
        }
    }

    @Override
    public List<Order> read() throws DAOException {
        String select = "SELECT * FROM workshopDB.order";

        try (PreparedStatement preparedStatement = connection.prepareStatement(select)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Order> orders = new ArrayList<>();
            Order order;
            User user;

            while(resultSet.next()) {
                order = new Order();
                order.setId(resultSet.getInt("id"));
                order.setName(resultSet.getString("name"));
                order.setWishes(resultSet.getString("wishes"));
                user = new User();
                user.setId(resultSet.getInt("user_id"));
                order.setUser(user);
                orders.add(order);
            }
            return orders;
        } catch (SQLException e) {
            throw new DAOException("Failed to read orders", e);
        }
    }
}
