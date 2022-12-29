package com.example.jenkinsapplication.dao;

import com.example.jenkinsapplication.entity.User;
import com.example.jenkinsapplication.util.ConnectionManager;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private static final UserDao instance = new UserDao();

    private UserDao() {

    }

    public static UserDao getInstance() {
        return instance;
    }

    public List<User> list() {
        List<User> users = new ArrayList<>();

        try (Connection connection = ConnectionManager.open()) {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM public.users";
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                User user = new User();

                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setSurname(resultSet.getString("surname"));
                user.setAge(resultSet.getInt("age"));

                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public User getUser(int id) {
        User user = null;
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM public.users " +
                    "WHERE id=?");

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();

            user = new User();

            user.setId(resultSet.getInt("id"));
            user.setName(resultSet.getString("name"));
            user.setSurname(resultSet.getString("surname"));
            user.setAge(resultSet.getInt("age"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public void save(User user) {
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO public.users " +
                    "(name, surname, age) VALUES(?,?,?)");

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setInt(3, user.getAge());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(int id, User user) {
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE public.users SET " +
                    "name=?, surname=?, age=? WHERE id=?");

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setInt(3, user.getAge());
            preparedStatement.setInt(4, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM public.users " +
                    "WHERE id=?");

            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
