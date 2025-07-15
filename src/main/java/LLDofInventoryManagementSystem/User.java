package LLDofInventoryManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class User {
    int userId;
    String userName;
    Address address;
    Cart cart;
    List<Integer> orderIds;

    public User() {
        this.cart = new Cart();
        this.orderIds = new ArrayList<>();
    }

    public Cart getUserCart() {
        return this.cart;
    }

}
