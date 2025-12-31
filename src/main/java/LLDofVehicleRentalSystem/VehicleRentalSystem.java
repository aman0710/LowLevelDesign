package LLDofVehicleRentalSystem;

import LLDofVehicleRentalSystem.Vehicle.VehicleInventoryManager;

import java.util.ArrayList;
import java.util.List;

public class VehicleRentalSystem {
    List<Store> storeList;
    List<User> userList;

    public VehicleRentalSystem() {
        this.storeList = new ArrayList<>();
        this.userList = new ArrayList<>();
    }

    public User getUser(int userId) {
        return userList.stream().filter(user -> user.getUserId() == userId).findFirst().get();
    }

    public Store getStore(int storeId) {
        return storeList.stream().filter(store -> store.getStoreId() == storeId).findFirst().get();
    }

    public void addStore(Store store) {
        storeList.add(store);
    }

    public void addUser(User user) {
        userList.add(user);
    }

    public void removeStore(int storeId) {
        Store store = storeList.stream().filter(s -> s.getStoreId() == storeId).findFirst().get();
        storeList.remove(store);
    }

    public void removeUser(int userId) {
        User user = userList.stream().filter(u -> u.getUserId() == userId).findFirst().get();
        storeList.remove(user);
    }
}
