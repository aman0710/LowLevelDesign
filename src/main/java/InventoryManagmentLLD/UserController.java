package InventoryManagmentLLD;

import java.util.ArrayList;
import java.util.List;

public class UserController {
    List<User> userList;

    public UserController(List<User> userList) {
        this.userList = userList;
    }

    public void addUser(User user) {
        this.userList.add(user);
    }

    public void removeUser(User user) {
        this.userList.remove(user);
    }

    public User getUser(int userId) {
        for(User user: userList) {
            if(user.userId == userId)
                return user;
        }
        return null;
    }
}
