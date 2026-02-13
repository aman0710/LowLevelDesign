package InventoryManagmentLLD;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Main mainObj = new Main();
        List<Warehouse> warehouseList = new ArrayList<>();
        warehouseList.add(mainObj.addWarehouseAndItsInventory());

        List<User> userList = new ArrayList<>();
        userList.add(mainObj.createUser());

        DeliveryApp deliveryApp = new DeliveryApp(userList, warehouseList);

        mainObj.runDeliveryFlow(deliveryApp, 1);
    }

    private Warehouse addWarehouseAndItsInventory(){

        Warehouse warehouse = new Warehouse();

        Inventory inventory = new Inventory();

        inventory.addCategory(0001, "Peppsii Large Cold Drink" , 100);
        inventory.addCategory(0004, "Doovee small Soap" , 50);

        //CREATE 3 Products

        Product product1 = new Product();
        product1.productId = 1;
        product1.productName = "Peepsii";

        Product product2 = new Product();
        product2.productId = 2;
        product2.productName = "Peepsii";

        Product product3 = new Product();
        product1.productId = 3;
        product1.productName = "Doovee";


        inventory.addProduct(product1, 0001);
        inventory.addProduct(product2, 0001);
        inventory.addProduct(product3, 0004);

        warehouse.inventory = inventory;
        return warehouse;
    }

    private User createUser(){
        User user = new User();
        user.userId = 1;
        user.userName = "SJ";
        user.address = new Address(230011, "city", "state");
        return user;
    }

    private void runDeliveryFlow(DeliveryApp deliveryApp, int userId) {
        User user = deliveryApp.getUser(userId);
        Warehouse warehouse = deliveryApp.getWarehouse(new NearestWarehouseSelectionStrategy());
        Inventory inventory = deliveryApp.getInventory(warehouse);
        ProductCategory productCategoryIWantToOrder = null;
        for(ProductCategory productCategory: inventory.productCategoryList) {
            if(productCategory.categoryName.equals("Peepsii Large Cold Drink")) {
                productCategoryIWantToOrder = productCategory;
            }
        }
        deliveryApp.addProductToCart(user, productCategoryIWantToOrder, 2);
        Order order = deliveryApp.placeOrder(user, warehouse);
        deliveryApp.checkout(order);
    }
}
