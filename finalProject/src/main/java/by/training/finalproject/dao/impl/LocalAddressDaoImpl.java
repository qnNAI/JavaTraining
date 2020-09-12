package by.training.finalproject.dao.impl;

import by.training.finalproject.entity.LocalAddress;
import by.training.finalproject.dao.DAOexception.DAOException;
import by.training.finalproject.dao.LocalAddressDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LocalAddressDaoImpl extends BaseDaoImpl implements LocalAddressDao {
    @Override
    public void create(LocalAddress localAddress) throws DAOException {
        final String insert = "INSERT INTO localAddress (address) VALUE (?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(insert)) {
            preparedStatement.setString(1, localAddress.getAddress());

        } catch (SQLException e) {
            throw new DAOException("Failed to add local address", e);
        }
    }

    @Override
    public void delete(int id) throws DAOException {
        final String delete = "DELETE FROM localAddress WHERE id=" + id;

        try (PreparedStatement preparedStatement = connection.prepareStatement(delete)) {
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new DAOException("Failed to remove local address", e);
        }
    }

    @Override
    public LocalAddress read(int id) throws DAOException {
        final String select = "SELECT * FROM localAddress WHERE id=" + id;

        try (PreparedStatement preparedStatement = connection.prepareStatement(select)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            LocalAddress localAddress = null;

            if (resultSet.next()) {
                localAddress = new LocalAddress();
                localAddress.setId(resultSet.getInt("id"));
                localAddress.setAddress(resultSet.getString("address"));
            }
            return localAddress;
        } catch (SQLException e) {
            throw new DAOException("Failed to read local address", e);
        }
    }

    @Override
    public void update(LocalAddress localAddress) throws DAOException {
        final String update = "UPDATE localaddress SET address=? WHERE id=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(update)) {
            preparedStatement.setString(1, localAddress.getAddress());
            preparedStatement.setInt(2, localAddress.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Failed to update local address", e);
        }
    }

    public List<LocalAddress> read() throws DAOException {
        final String select = "SELECT * FROM localAddress";

        try (PreparedStatement preparedStatement = connection.prepareStatement(select)) {
            ResultSet resultSet = preparedStatement.executeQuery();
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
        }
    }
}
