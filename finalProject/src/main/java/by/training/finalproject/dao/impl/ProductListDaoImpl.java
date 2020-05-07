package by.training.finalproject.dao.impl;

import by.training.finalproject.beans.ProductList;
import by.training.finalproject.dao.DAOexception.DAOException;
import by.training.finalproject.dao.ProductListDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductListDaoImpl extends BaseDaoImpl implements ProductListDao {
    @Override
    public void create(ProductList productList) throws DAOException {
        String insert = "INSERT INTO workshopdb.productlist (purchase_id, product_id, finalPrice, amount) VALUES (?,?,?,?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(insert)) {
            preparedStatement.setInt(1, productList.getPurchaseID());
            preparedStatement.setInt(2, productList.getProductID());
            preparedStatement.setDouble(3, productList.getFinalPrice());
            preparedStatement.setInt(4, productList.getAmount());preparedStatement.executeUpdate();
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Failed to create product list", e);
        }
    }

    @Override
    public ProductList read(int purchaseID, int productID) throws DAOException {
        String select = "SELECT finalPrice, amount FROM workshopdb.productlist WHERE purchase_id=? AND product_id=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(select)) {
            preparedStatement.setInt(1, purchaseID);
            preparedStatement.setInt(2, productID);
            ResultSet resultSet = preparedStatement.executeQuery();
            ProductList productList = null;

            if (resultSet.next()) {
                productList = new ProductList();
                productList.setPurchaseID(purchaseID);
                productList.setProductID(productID);
                productList.setFinalPrice(resultSet.getDouble("finalPrice"));
                productList.setAmount(resultSet.getInt("amount"));
            }

            return productList;
        } catch (SQLException e) {
            throw new DAOException("Failed to read product list", e);
        }
    }

    @Override
    public void update(ProductList productList) throws DAOException {
        String update = "UPDATE workshopdb.productlist SET finalPrice=?, amount=? WHERE purchase_id=? AND product_id=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(update)) {
            preparedStatement.setDouble(1, productList.getFinalPrice());
            preparedStatement.setInt(2, productList.getAmount());
            preparedStatement.setInt(3, productList.getPurchaseID());
            preparedStatement.setInt(4, productList.getProductID());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new DAOException("Failed to update product list", e);
        }
    }

    @Override
    public void delete(int purchaseID, int productID) throws DAOException {
        String delete = "DELETE FROM workshopdb.productlist WHERE purchase_id=? AND product_id=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(delete)) {
            preparedStatement.setInt(1, purchaseID);
            preparedStatement.setInt(2, productID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Failed to delete product list", e);
        }
    }

    @Override
    public List<ProductList> read() throws DAOException {
        String select = "SELECT * FROM workshopdb.productlist";

        try (PreparedStatement preparedStatement = connection.prepareStatement(select)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            List<ProductList> listOfProductList = new ArrayList<>();
            ProductList productList;

            while (resultSet.next()) {
                productList = new ProductList();
                productList.setPurchaseID(resultSet.getInt("purchase_id"));
                productList.setProductID(resultSet.getInt("product_id"));
                productList.setFinalPrice(resultSet.getDouble("finalPrice"));
                productList.setAmount(resultSet.getInt("amount"));
                listOfProductList.add(productList);
            }
            return listOfProductList;
        } catch (SQLException e) {
            throw new DAOException("Failed to read product list", e);
        }
    }
}
