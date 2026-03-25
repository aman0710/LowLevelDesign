package LLDofPaymentGateway.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UserService {
    static List<User> usersList = new ArrayList<>();

    public UserDO addUser(UserDO userDO) {
        User user = new User();
        user.setUserName(userDO.name);
        user.setEmail(userDO.getMail());
        user.setUserID((int) new Random().nextInt(100 - 10) + 10);
        usersList.add(user);
        return convertUserToUserDO(user);
    }

    private UserDO convertUserToUserDO(User user) {
        UserDO userDO = new UserDO();
        userDO.setId(user.getUserID());
        userDO.setMail(user.getEmail());
        userDO.setName(user.getUserName());
        return userDO;
    }

    public UserDO getUser(int userID) {
        UserDO userDO = new UserDO();
        for (User user: usersList) {
            if(user.getUserID() == userID) {
                userDO = convertUserToUserDO(user);
                break;
            }
        }
        return userDO;
    }
}
