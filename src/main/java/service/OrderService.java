package service;

import beans.Order;
import dao.OrderDAO;

import java.util.List;

public class OrderService {
    public static List<Order> getAll() {
        try {
            return new OrderDAO().getOrders();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Order byID(int id) {
        try {
            return new OrderDAO().getOrderByID(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Order byState(boolean state) {
        try {
            return new OrderDAO().getOrderByState(state);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
