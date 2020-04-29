package by.training.finalproject.dao.impl;

import by.training.finalproject.beans.LocalAddress;
import by.training.finalproject.dao.DAOexception.DAOException;
import by.training.finalproject.dao.LocalAddressDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LocalAddressBaseDaoImpl extends BaseDaoImpl implements LocalAddressDao {
    @Override
    public void create(LocalAddress localAddress) throws DAOException {
        String insert = "INSERT INTO workshopDB.localAddress (address) VALUE (?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(insert)) {
            preparedStatement.setString(1, localAddress.getAddress());

        } catch (SQLException e) {
            throw new DAOException("Failed to add local address", e);
        }
    }

    @Override
    public void delete(int id) throws DAOException {
        String delete = "DELETE FROM workshopDB.localAddress WHERE id=" + id;

        try (PreparedStatement preparedStatement = connection.prepareStatement(delete)) {
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new DAOException("Failed to remove local address", e);
        }
    }

    @Override
    public LocalAddress read(int id) throws DAOException {
        String select = "SELECT * FROM workshopDB.localAddress WHERE id=" + id;
        ResultSet resultSet = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(select)) {
            resultSet = preparedStatement.executeQuery();
            LocalAddress localAddress = null;

            if (resultSet.next()) {
                localAddress = new LocalAddress();
                localAddress.setId(resultSet.getInt("id"));
                localAddress.setAddress(resultSet.getString("address"));
            }
            return localAddress;
        } catch (SQLException e) {
            throw new DAOException("Failed to read local address", e);
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {}
        }
    }

    @Override
    public void update(LocalAddress localAddress) throws DAOException {
        String update = "UPDATE workshopDB.localaddress SET address=? WHERE id=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(update)) {
            preparedStatement.setString(1, localAddress.getAddress());
            preparedStatement.setInt(2, localAddress.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Failed to update local address", e);
        }
    }

    public List<LocalAddress> read() throws DAOException {
        String select = "SELECT * FROM workshopDB.localAddress";
        ResultSet resultSet = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(select)) {
            resultSet = preparedStatement.executeQuery();
            List<LocalAddress> localAddresses = new ArrayList<>();
            LocalAddress localAddress;

            while (resultSet.next()) {
                localAddress = new LocalAddress();
                localAddress.setId(resultSet.getInt("id"));
                localAddress.setAddress(resultSet.getString("address"));
                localAddresses.add(localAddress);
            }
            return localAddresses;
        } catch (SQLException e) {
            throw new DAOException("Failed to read local addresses", e);
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {}
        }
    }

}
