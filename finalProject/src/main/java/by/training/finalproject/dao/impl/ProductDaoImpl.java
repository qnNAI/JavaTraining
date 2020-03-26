package by.training.finalproject.dao.impl;

import by.training.finalproject.beans.Product;
import by.training.finalproject.dao.DAOexception.DAOException;
import by.training.finalproject.dao.ProductDao;

import java.sql.*;

public class ProductDaoImpl extends DaoImpl implements ProductDao {
    @Override
    public void create(Product product) throws DAOException {
        String insert = "INSERT INTO workshopDB.product (name, price, description, image_path) VALUES (?,?,?,?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(insert)) {
            setProductStatement(product, preparedStatement);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Error add product", e);
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
            throw new DAOException("Error update product ID=" + product.getId(), e);
        }
    }

    @Override
    public void delete(int id) throws DAOException {
        String delete = "DELETE FROM workshopDB.product WHERE id=" + id;

        try (PreparedStatement preparedStatement = connection.prepareStatement(delete)) {
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new DAOException("Error remove product ID=" + id, e);
        }
    }

    @Override
    public Product read(int id) throws DAOException {
        String select = "SELECT name, price, description, image_path FROM workshopDB.product WHERE id=" + id;
        ResultSet resultSet = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(select)) {
            resultSet = preparedStatement.executeQuery();
            Product product = null;

            if (resultSet.next()) {
                product = new Product();
                product.setId(id);
                product.setName(resultSet.getString(1));
                product.setPrice(resultSet.getDouble(2));
                String description = resultSet.getString(3);
                if (!resultSet.wasNull()) {
                    product.setDescription(description);
                }
                String path = resultSet.getString(4);
                if (!resultSet.wasNull()) {
                    product.setImagePath(path);
                }
            }

            return product;
        } catch (SQLException e) {
            throw new DAOException("Error read product id=" + id, e);
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {}
        }
    }

    @Override
    public ResultSet makeProductsSet() throws DAOException {
        String select = "SELECT * FROM workshopDB.product";

        try (PreparedStatement preparedStatement = connection.prepareStatement(select)) {
            return preparedStatement.executeQuery();

        } catch (SQLException e) {
            throw new DAOException("Error make products set", e);
        }
    }

    private void setProductStatement(Product product, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, product.getName());
        preparedStatement.setDouble(2, product.getPrice());

        if (product.getDescription().isEmpty()) {
            preparedStatement.setNull(3, Types.VARCHAR);
        } else {
            preparedStatement.setString(3, product.getDescription());
        }

        if (product.getImagePath().isEmpty()) {
            preparedStatement.setNull(4, Types.VARCHAR);
        } else {
            preparedStatement.setString(4, product.getImagePath());
        }
    }
}
