package by.training.finalproject.dao.impl;

import by.training.finalproject.beans.User;
import by.training.finalproject.beans.infoEnum.Role;
import by.training.finalproject.dao.DAOexception.DAOException;
import by.training.finalproject.dao.UserDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends BaseDaoImpl implements UserDao {
    @Override
    public void create(User user) throws DAOException {
        String insert = "INSERT INTO workshopDB.user (login, password, role, state, name, surname, patronymic, email, phone) VALUES(?,?,?,?,?,?,?,?,?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(insert)) {
            setFullUserStatement(user, preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Failed to add user", e);
        }
    }

    @Override
    public void delete(int id) throws DAOException {
        String delete = "DELETE FROM workshopDB.user WHERE id=" + id;

        try (PreparedStatement preparedStatement = connection.prepareStatement(delete)) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Failed to remove user", e);
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
            throw new DAOException("Failed to update user account", e);
        }
    }

    @Override
    public void update(User user) throws DAOException {
        String update = "UPDATE workshopDB.user SET login=?, password=?, role=?, state=?, name=?, surname=?, patronymic=?, email=?, phone=? WHERE id=" + user.getId();

        try (PreparedStatement preparedStatement = connection.prepareStatement(update)) {
            setFullUserStatement(user, preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Failed to update user", e);
        }
    }

    @Override
    public User read(int id) throws DAOException {
        String select = "SELECT login, password, role, state, name, surname, patronymic, email, phone FROM workshopDB.user WHERE id=" + id;

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
            throw new DAOException("Failed to read user by login and password", e);
        }
    }

    @Override
    public List<User> read() throws DAOException {
        String select = "SELECT * FROM workshopDB.user";

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
        user.setRole(Role.getByIdentity(resultSet.getInt("role")));
        user.setState(resultSet.getInt("state"));
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
