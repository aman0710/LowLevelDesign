package InventoryManagmentLLD;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderController {
    List<Order> orderList;
    Map<Integer, List<Order>> userIdVsOrders;

    public OrderController() {
        this.orderList = new ArrayList<>();
        this.userIdVsOrders = new HashMap<>();
    }

    public Order createNewOrder(User user, Warehouse warehouse) {
        Order order = new Order(user, warehouse);
        orderList.add(order);
        if(userIdVsOrders.containsKey(user.userId)) {
            List<Order> userOrders = userIdVsOrders.get(user.userId);
            userOrders.add(order);
            userIdVsOrders.put(user.userId, userOrders);
        } else {
            List<Order> userOrders = new ArrayList<>();
            userOrders.add(order);
            userIdVsOrders.put(user.userId, userOrders);
        }
        return order;
    }

    public void removeOrder(Order order) {
        // remove the order
    }

    public List<Order> getOrdersByUserId(int userId) {
        return null;
    }

    public Order getOrderByOrderId(int orderId) {
        return null;
    }
}
