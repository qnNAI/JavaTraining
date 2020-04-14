package by.training.finalproject.dao.impl;

import by.training.finalproject.beans.User;
import by.training.finalproject.beans.infoEnum.Role;
import by.training.finalproject.dao.DAOexception.DAOException;
import by.training.finalproject.dao.UserDao;

import java.sql.*;

public class UserBaseDaoImpl extends BaseDaoImpl implements UserDao {
    //private UserBaseDaoImpl() {}

    @Override
    public void create(User user) throws DAOException {
        String insert = "INSERT INTO workshopDB.user ('login', 'password', 'role', 'state', 'name', " +
                "'surname', 'patronymic', 'email', 'phone') VALUES(?,?,?,?,?,?,?,?,?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(insert)) {
            setFullUserStatement(user, preparedStatement);

        } catch (SQLException e) {
            throw new DAOException("Error add user", e);
        }
    }

    @Override
    public void delete(int id) throws DAOException {
        String delete = "DELETE FROM workshopDB.user WHERE id=" + id;

        try (PreparedStatement preparedStatement = connection.prepareStatement(delete)) {
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new DAOException("Error remove user ID=" + id, e);
        }
    }

    @Override
    public void updateAccount(User user) throws DAOException {
        String update = "UPDATE workshopDB.user SET login=?, password=?, role=?, state=? WHERE id=" + user.getId();

        try (PreparedStatement preparedStatement = connection.prepareStatement(update)) {
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setInt(3, user.getRole().getIdentity());
            preparedStatement.setInt(4, user.getState());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Error update user account ID=" + user.getId(), e);
        }
    }

    @Override
    public void update(User user) throws DAOException {
        String update = "UPDATE workshopDB.user SET login=?, password=?, role=?, state=?, name=?, surname=?," +
                " patronymic=?, email=?, phone=? WHERE id=" + user.getId();

        try (PreparedStatement preparedStatement = connection.prepareStatement(update)) {
            setFullUserStatement(user, preparedStatement);
        } catch (SQLException e) {
            throw new DAOException("Error update user account ID=" + user.getId(), e);
        }
    }

    @Override
    public User read(int id) throws DAOException {
        String select = "SELECT login, password, role, state, name, surname, patronymic, email, phone " +
                "FROM workshopDB.user WHERE id=" + id;
        ResultSet resultSet = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(select)) {
            resultSet = preparedStatement.executeQuery();
            User user = null;

            if (resultSet.next()) {
                user = new User();
                user.setId(id);
                user.setLogin(resultSet.getString(1));
                user.setPassword(resultSet.getString(2));
                user.setRole(Role.getByIdentity(resultSet.getInt(3)));
                user.setState(resultSet.getInt(4));
                user.setName(resultSet.getString(5));
                user.setSurname(resultSet.getString(6));
                String patronymic = resultSet.getString(7);
                if (!resultSet.wasNull()) {
                    user.setPatronymic(patronymic);
                }
                user.setEmail(resultSet.getString(8));
                String phone = resultSet.getString(9);
                if (!resultSet.wasNull()) {
                    user.setPhone(phone);
                }
            }

            return user;
        } catch (SQLException e) {
            throw new DAOException("Error read user id=" + id, e);
        } finally {
            try {
                resultSet.close();
            } catch (SQLException e) {}
        }
    }

    @Override
    public User read(String login, String password) throws DAOException {
        String select = "SELECT id, role FROM workshopDB.user WHERE login=? AND password=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(select)) {
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
            User user = null;

            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setLogin(login);
                user.setPassword(password);
                user.setRole(Role.getByIdentity(resultSet.getInt("role")));
            }
            return user;

        } catch (SQLException e) {
            throw new DAOException("Fail to read user", e);
        }
    }

    @Override
    public ResultSet makeUsersSet() throws DAOException {
        String select = "SELECT * FROM workshopDB.user";

        try (PreparedStatement preparedStatement = connection.prepareStatement(select)) {
            return preparedStatement.executeQuery();

        } catch (SQLException e) {
            throw new DAOException("Error make users set", e);
        }
    }

    private void setFullUserStatement(User user, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, user.getLogin());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.setInt(3, user.getRole().getIdentity());
        preparedStatement.setInt(4, user.getState());
        preparedStatement.setString(5, user.getName());
        preparedStatement.setString(6, user.getSurname());
        if (user.getPatronymic().isEmpty()) {
            preparedStatement.setNull(7, Types.VARCHAR);
        } else {
            preparedStatement.setString(7, user.getPatronymic());
        }
        preparedStatement.setString(8, user.getEmail());
        if (user.getPhone().isEmpty()) {
            preparedStatement.setNull(9, Types.VARCHAR);
        } else {
            preparedStatement.setString(9, user.getPhone());
        }

        preparedStatement.executeUpdate();
    }
}
