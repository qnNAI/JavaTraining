package by.training.finalproject.dao.impl;

import by.training.finalproject.beans.Product;
import by.training.finalproject.beans.User;
import by.training.finalproject.dao.DAOexception.DAOException;
import by.training.finalproject.dao.ProductDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl extends BaseDaoImpl implements ProductDao {
    @Override
    public void create(Product product) throws DAOException {
        String insert = "INSERT INTO workshopDB.product (user_id, name, price, description, image_path) VALUES (?,?,?,?,?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(insert)) {
            setProductStatement(product, preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            /* TODO write logger error */
            throw new DAOException("Failed to add product", e);
        }
    }

    @Override
    public void update(Product product) throws DAOException {
        String update = "UPDATE workshopDB.product SET name=?, price=?, description=?, image_path=? WHERE id=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(update)) {
            setProductStatement(product, preparedStatement);
            preparedStatement.setInt(5, product.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Failed to update product", e);
        }
    }

    @Override
    public void delete(int id) throws DAOException {
        String delete = "DELETE FROM workshopDB.product WHERE id=" + id;

        try (PreparedStatement preparedStatement = connection.prepareStatement(delete)) {
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new DAOException("Failed to remove product", e);
        }
    }

    @Override
    public Product read(int id) throws DAOException {
        String select = "SELECT name, price, description, image_path FROM workshopDB.product WHERE id=" + id;

        try (PreparedStatement preparedStatement = connection.prepareStatement(select)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            Product product = null;

            if (resultSet.next()) {
                product = new Product();
                product.setId(id);
                setProductFields(resultSet, product);
            }
            return product;
        } catch (SQLException e) {
            throw new DAOException("Failed to read product", e);
        }
    }

    @Override
    public List<Product> read() throws DAOException {
        String select = "SELECT * FROM workshopDB.product";

        try (PreparedStatement preparedStatement = connection.prepareStatement(select)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Product> products = new ArrayList<>();
            Product product;

            while (resultSet.next()) {
                product = new Product();
                product.setId(resultSet.getInt("id"));
                setProductFields(resultSet, product);
                products.add(product);
            }
            return products;
        } catch (SQLException e) {
            throw new DAOException("Failed to read products", e);
        }
    }

    private void setProductStatement(Product product, PreparedStatement preparedStatement) throws SQLException {
        if (product.getUser() == null) {
            preparedStatement.setNull(1, Types.INTEGER);
        } else {
            preparedStatement.setInt(1, product.getUser().getId());
        }

        preparedStatement.setString(2, product.getName());
        preparedStatement.setDouble(3, product.getPrice());

        if (product.getDescription().isEmpty()) {
            preparedStatement.setNull(4, Types.VARCHAR);
        } else {
            preparedStatement.setString(4, product.getDescription());
        }

        if (product.getImagePath().isEmpty()) {
            preparedStatement.setNull(5, Types.VARCHAR);
        } else {
            preparedStatement.setString(5, product.getImagePath());
        }
    }

    private void setProductFields(ResultSet resultSet, Product product) throws SQLException {
        int userID = resultSet.getInt("user_id");
        if (!resultSet.wasNull()) {
            User user = new User();
            user.setId(userID);
            product.setUser(user);
        }
        product.setName(resultSet.getString("name"));
        product.setPrice(resultSet.getDouble("price"));
        String description = resultSet.getString("description");
        if (!resultSet.wasNull()) {
            product.setDescription(description);
        }
        String path = resultSet.getString("image_path");
        if (!resultSet.wasNull()) {
            product.setImagePath(path);
        }
    }
}
