package LLDofSplitWise.User;

import java.util.ArrayList;
import java.util.List;

public class UserController {
    List<User> userList;

    public UserController() {
        this.userList = new ArrayList<>();
    }

    public void addUser(User user) {
        this.userList.add(user);
    }

    public User getUser(String userId) {
        for(User user: this.userList) {
            if(user.getId().equalsIgnoreCase(userId))
                return user;
        }
        return null;
    }

    public List<User> getAllUsers() {
        return this.userList;
    }
}
