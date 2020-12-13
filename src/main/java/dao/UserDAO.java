package dao;

import beans.User;
import utilities.SetConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UserDAO {

    public User getUserByEmail(String email) throws Exception {
        Connection connection = SetConnection.connect();

        try {
            PreparedStatement query = connection.prepareStatement("SELECT * FROM user WHERE email LIKE ?");
            query.setString(1, email);

            ResultSet result = query.executeQuery();
            if (result.next()) {
                int _id = result.getInt(1);
                String _name = result.getString(2);
                String _surname = result.getString(3);
                User.Role _role = User.Role.valueOf(result.getString(4).toUpperCase());
                String _email = result.getString(5);
                String _passwordHash = result.getString(6);
                return new User(_id, _name, _surname, _role, _email, _passwordHash);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public User getUserByID(int id) throws Exception {
        Connection connection = SetConnection.connect();

        try {
            PreparedStatement query = connection.prepareStatement("SELECT * FROM user WHERE id LIKE ?");
            query.setString(1, Integer.toString(id));

            ResultSet result = query.executeQuery();
            if (result.next()) {
                int _id = result.getInt(1);
                String _name = result.getString(2);
                String _surname = result.getString(3);
                User.Role _role = User.Role.valueOf(result.getString(4).toUpperCase());
                String _email = result.getString(5);
                String _passwordHash = result.getString(6);
                return new User(_id, _name, _surname, _role, _email, _passwordHash);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<User> getUsers() throws Exception {
        Connection connection = SetConnection.connect();

        try {
            List<User> users = new ArrayList<>();

            PreparedStatement query = connection.prepareStatement("SELECT * FROM user");
            ResultSet result = query.executeQuery();
            while (result.next()) {
                int _id = result.getInt(1);
                String _name = result.getString(2);
                String _surname = result.getString(3);
                User.Role _role = User.Role.valueOf(result.getString(4).toUpperCase());
                String _email = result.getString(5);
                String _passwordHash = result.getString(6);
                users.add(new User(_id, _name, _surname, _role, _email, _passwordHash));
            }

            return users;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean addUser(User user) throws Exception {
        Connection connection = SetConnection.connect();

        try {
            PreparedStatement addUserQuery = connection.prepareStatement("INSERT INTO user (name, surname, role, email, password_hash) VALUES (?, ?, ?, ?, ?)");
            addUserQuery.setString(1, user.name);
            addUserQuery.setString(2, user.surname);
            addUserQuery.setString(3, user.role.name().toLowerCase());
            addUserQuery.setString(4, user.email);
            addUserQuery.setString(5, user.passwordHash);
            addUserQuery.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean isUserExists(String email) throws Exception {
        return getUserByEmail(email) != null;
    }
}
