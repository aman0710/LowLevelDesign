package InventoryManagmentLLD;

import java.util.ArrayList;
import java.util.List;

public class ProductCategory {
    int productCategoryId;
    String categoryName;
    List<Product> products = new ArrayList<>();
    double price;

    public ProductCategory(int productCategoryId, String categoryName, double price) {
        this.productCategoryId = productCategoryId;
        this.categoryName = categoryName;
        this.price = price;
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void removeProducts(int count) {
        for(int i=0; i<count; i++)
            this.products.remove(0);
    }
}
