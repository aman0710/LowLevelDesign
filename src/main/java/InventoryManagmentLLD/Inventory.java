package InventoryManagmentLLD;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Inventory {
    List<ProductCategory> productCategoryList;

    public Inventory() {
        this.productCategoryList = new ArrayList<>();
    }

    public void addCategory(int categoryId, String name, double price) {
        ProductCategory productCategory = new ProductCategory(categoryId, name, price);
        this.productCategoryList.add(productCategory);
    }

    public void addProduct(Product product, int categoryId) {
        ProductCategory productCategory = getProductCategoryFromId(categoryId);
        if(productCategory != null)
            productCategory.addProduct(product);
    }

    public void removeItems(Map<Integer, Integer> productCategoryIdVsCount) {
        for(Map.Entry<Integer, Integer> entry: productCategoryIdVsCount.entrySet()) {
            ProductCategory category = getProductCategoryFromId(entry.getKey());
            category.removeProducts(entry.getValue());
        }
    }

    public ProductCategory getProductCategoryFromId(int categoryId) {
        for(ProductCategory category: this.productCategoryList) {
            if(category.productCategoryId == categoryId)
                return category;
        }
        return null;
    }
}
