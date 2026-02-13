package InventoryManagmentLLD;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    Map<Integer, Integer> productCategoryIdVsCount;

    public Cart() {
        this.productCategoryIdVsCount = new HashMap<>();
    }

    public void addItemsToCart(int productCategoryId, int count) {
        if(productCategoryIdVsCount.containsKey(productCategoryId)) {
            int itemsAlreadyInCart = productCategoryIdVsCount.get(productCategoryId);
            productCategoryIdVsCount.put(productCategoryId, itemsAlreadyInCart + count);
        } else {
            productCategoryIdVsCount.put(productCategoryId, count);
        }
    }

    public void removeItemsFromCart(int productCategoryId, int count) {
        if(productCategoryIdVsCount.containsKey(productCategoryId)) {
            int itemsAlreadyInCart = productCategoryIdVsCount.get(productCategoryId);
            if(itemsAlreadyInCart - count == 0) {
                productCategoryIdVsCount.remove(productCategoryId);
            } else {
                productCategoryIdVsCount.put(productCategoryId, itemsAlreadyInCart - count);
            }
        }
    }

    public void emptyCart() {
        productCategoryIdVsCount = new HashMap<>();
    }

    public Map<Integer, Integer> getCartItems() {
        return this.productCategoryIdVsCount;
    }
}
