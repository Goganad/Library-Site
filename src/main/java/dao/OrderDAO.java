package dao;

import beans.Order;
import utilities.SetConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {
    public Order getOrderByState(boolean state) throws Exception {
        Connection connection = SetConnection.connect();

        try {
            PreparedStatement query = connection.prepareStatement("SELECT * FROM order WHERE state LIKE ?");
            query.setBoolean(1, state);

            ResultSet result = query.executeQuery();
            if (result.next()) {
                int _id = result.getInt(1);
                int _idUser = result.getInt(2);
                int _idBook = result.getInt(3);
                LocalDateTime _dateTime = LocalDateTime.parse(result.getString(4));
                Order.Type _type = Order.Type.valueOf(result.getString(5).toUpperCase());
                boolean _state = result.getBoolean(6);
                return new Order(_id, _idUser, _idBook, _dateTime, _type, _state);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Order getOrderByID(int id) throws Exception {
        Connection connection = SetConnection.connect();

        try {
            PreparedStatement query = connection.prepareStatement("SELECT * FROM order WHERE id LIKE ?");
            query.setString(1, Integer.toString(id));

            ResultSet result = query.executeQuery();
            if (result.next()) {
                int _id = result.getInt(1);
                int _idUser = result.getInt(2);
                int _idBook = result.getInt(3);
                LocalDateTime _dateTime = LocalDateTime.parse(result.getString(4));
                Order.Type _type = Order.Type.valueOf(result.getString(5).toUpperCase());
                boolean _state = result.getBoolean(6);
                return new Order(_id, _idUser, _idBook, _dateTime, _type, _state);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Order> getOrders() throws Exception {
        Connection connection = SetConnection.connect();

        try {
            List<Order> orders = new ArrayList<>();

            PreparedStatement query = connection.prepareStatement("SELECT * FROM order");
            ResultSet result = query.executeQuery();
            while (result.next()) {
                int _id = result.getInt(1);
                int _idUser = result.getInt(2);
                int _idBook = result.getInt(3);
                LocalDateTime _dateTime = LocalDateTime.parse(result.getString(4));
                Order.Type _type = Order.Type.valueOf(result.getString(5).toUpperCase());
                boolean _state = result.getBoolean(6);
                orders.add(new Order(_id, _idUser, _idBook, _dateTime, _type, _state));
            }

            return orders;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean addOrder(Order order) throws Exception {
        Connection connection = SetConnection.connect();

        try {
            PreparedStatement addOrderQuery = connection.prepareStatement("INSERT INTO order (user_id, book_id, date, type, state) VALUES (?, ?, ?, ?, ?)");
            addOrderQuery.setInt(1, order.idUser);
            addOrderQuery.setInt(2, order.idBook);
            addOrderQuery.setString(3, order.date.toString());
            addOrderQuery.setString(4, order.type.toString().toLowerCase());
            addOrderQuery.setBoolean(5, order.state);
            addOrderQuery.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean isOrderExists(int id) throws Exception {
        return getOrderByID(id) != null;
    }
}
