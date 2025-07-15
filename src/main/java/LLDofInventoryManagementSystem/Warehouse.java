package LLDofInventoryManagementSystem;

import java.util.Map;

public class Warehouse {
    Inventory inventory;
    Address address;

    public void removeItemsFromInventory(Map<Integer, Integer> productCategoryAndCount) {
        inventory.removeItems(productCategoryAndCount);
    }

    public void addItemsToInventory(Map<Integer, Integer> productCategoryAndCount) {

    }
}
