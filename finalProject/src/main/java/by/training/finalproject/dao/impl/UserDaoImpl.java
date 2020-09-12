package by.training.finalproject.dao.impl;

import by.training.finalproject.entity.User;
import by.training.finalproject.entity.infoEnum.Role;
import by.training.finalproject.dao.DAOexception.DAOException;
import by.training.finalproject.dao.UserDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends BaseDaoImpl implements UserDao {
    @Override
    public void create(User user) throws DAOException {
        final String insert = "INSERT INTO user (login, password, role, state, name, surname, patronymic, email, phone) VALUES(?,?,?,?,?,?,?,?,?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(insert)) {
            setFullUserStatement(user, preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Failed to add user", e);
        }
    }

    @Override
    public void delete(int id) throws DAOException {
        final String delete = "DELETE FROM user WHERE id=" + id;

        try (PreparedStatement preparedStatement = connection.prepareStatement(delete)) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Failed to remove user", e);
        }
    }

    @Override
    public void updateAccount(User user) throws DAOException {
        final String update = "UPDATE user SET login=?, password=?, role=?, state=? WHERE id=" + user.getId();

        try (PreparedStatement preparedStatement = connection.prepareStatement(update)) {
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, String.valueOf(user.getRole().getIdentity()));
            preparedStatement.setString(4, String.valueOf(user.getState()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Failed to update user account", e);
        }
    }

    @Override
    public void update(User user) throws DAOException {
        final String update = "UPDATE user SET login=?, password=?, role=?, state=?, name=?, surname=?, patronymic=?, email=?, phone=? WHERE id=" + user.getId();

        try (PreparedStatement preparedStatement = connection.prepareStatement(update)) {
            setFullUserStatement(user, preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Failed to update user", e);
        }
    }

    @Override
    public User read(int id) throws DAOException {
        final String select = "SELECT login, password, role, state, name, surname, patronymic, email, phone FROM user WHERE id=" + id;

        try (PreparedStatement preparedStatement = connection.prepareStatement(select)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            User user = null;

            if (resultSet.next()) {
                user = new User();
                user.setId(id);
                setUserFields(resultSet, user);
            }
            return user;
        } catch (SQLException e) {
            throw new DAOException("Failed to read user", e);
        }
    }

    @Override
    public User read(String login, String password) throws DAOException {
        final String select = "SELECT id, role, state FROM user WHERE login=? AND password=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(select)) {
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
            User user = null;

            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setLogin(login);
                user.setRole(Role.getByIdentity(Integer.parseInt(resultSet.getString("role"))));
                user.setState(Integer.parseInt(resultSet.getString("state")));
            }
            return user;
        } catch (SQLException e) {
            throw new DAOException("Failed to read user by login and password", e);
        }
    }

    @Override
    public List<User> read() throws DAOException {
        final String select = "SELECT * FROM user";

        try (PreparedStatement preparedStatement = connection.prepareStatement(select)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            List<User> users = new ArrayList<>();
            User user;

            while(resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                setUserFields(resultSet, user);
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            throw new DAOException("Failed to read users", e);
        }
    }

    private void setFullUserStatement(User user, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, user.getLogin());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.setString(3, String.valueOf(user.getRole().getIdentity()));
        preparedStatement.setString(4, String.valueOf(user.getState()));
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
    }

    private void setUserFields(ResultSet resultSet, User user) throws SQLException {
        user.setLogin(resultSet.getString("login"));
        user.setPassword(resultSet.getString("password"));
        user.setRole(Role.getByIdentity(Integer.parseInt(resultSet.getString("role"))));
        user.setState(Integer.parseInt(resultSet.getString("state")));
        user.setName(resultSet.getString("name"));
        user.setSurname(resultSet.getString("surname"));
        String patronymic = resultSet.getString("patronymic");
        if (!resultSet.wasNull()) {
            user.setPatronymic(patronymic);
        }
        user.setEmail(resultSet.getString("email"));
        String phone = resultSet.getString("phone");
        if (!resultSet.wasNull()) {
            user.setPhone(phone);
        }
    }
}
