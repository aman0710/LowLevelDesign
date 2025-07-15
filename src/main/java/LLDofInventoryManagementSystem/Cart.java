package LLDofInventoryManagementSystem;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    Map<Integer, Integer> productCategoryIdVsCount;

    public Cart() {
        this.productCategoryIdVsCount = new HashMap<>();
    }

    public void addItemInCart(int productCategoryId, int count) {
        if(productCategoryIdVsCount.containsKey(productCategoryId)) {
            int existingValue = productCategoryIdVsCount.get(productCategoryId);
            productCategoryIdVsCount.put(productCategoryId, existingValue + count);
        }
        productCategoryIdVsCount.put(productCategoryId, count);
    }

    public void removeItemFromCart(int productCategoryId, int count) {
        if(!productCategoryIdVsCount.containsKey(productCategoryId))
            return;
        int existingValueInCart = productCategoryIdVsCount.get(productCategoryId);
        if(count == existingValueInCart)
            productCategoryIdVsCount.remove(productCategoryId);
        else
            productCategoryIdVsCount.put(productCategoryId, existingValueInCart - count);
    }

    public void emptyCart() {
        productCategoryIdVsCount = new HashMap<>();
    }

    public Map<Integer, Integer> getCartItems() {
        return productCategoryIdVsCount;
    }

}
