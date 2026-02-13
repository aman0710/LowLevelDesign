package InventoryManagmentLLD;

import java.util.Map;

public class Warehouse {
    Inventory inventory;
    Address address;

    public void addItemToInventory(Map<Integer, Integer> productCategoryIdVsCount) {
        // update inventory to add the count in each product category
    }

    public void removeItemsFromInventory(Map<Integer, Integer> productCategoryIdVsCount) {
        inventory.removeItems(productCategoryIdVsCount);
    }
}
