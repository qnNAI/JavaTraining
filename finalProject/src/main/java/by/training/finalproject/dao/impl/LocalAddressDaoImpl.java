package by.training.finalproject.dao.impl;

import by.training.finalproject.beans.LocalAddress;
import by.training.finalproject.dao.DAOexception.DAOException;
import by.training.finalproject.dao.LocalAddressDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LocalAddressDaoImpl extends DaoImpl implements LocalAddressDao {

    @Override
    public void create(LocalAddress localAddress) throws DAOException {
        String insert = "INSERT INTO workshopDB.localAddress (address) VALUE (?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(insert)) {
            preparedStatement.setString(1, localAddress.getAddress());

        } catch (SQLException e) {
            throw new DAOException("Error add local address", e);
        }
    }

    @Override
    public void delete(int id) throws DAOException {
        String delete = "DELETE FROM workshopDB.localAddress WHERE id=" + id;

        try (PreparedStatement preparedStatement = connection.prepareStatement(delete)) {
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new DAOException("Error remove local address ID=" + id, e);
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
                localAddress.setId(resultSet.getInt(1));
                localAddress.setAddress(resultSet.getString(2));
            }
            return localAddress;
        } catch (SQLException e) {
            throw new DAOException("Error read local address", e);
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {}
        }
    }

    @Override
    public void update(LocalAddress entity) throws DAOException {
        throw new DAOException("Updating local address is not allowed");
    }

    public ResultSet makeLocalAddressesSet() throws DAOException {
        String select = "SELECT * FROM workshopDB.localAddress";

        try (PreparedStatement preparedStatement = connection.prepareStatement(select)) {
            return preparedStatement.executeQuery();

        } catch (SQLException e) {
            throw new DAOException("Error make local addresses set", e);
        }
    }

}
