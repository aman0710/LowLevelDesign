package LLDofInventoryManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class ProductCategory {
    int productCategoryId;
    String productCategoryName;
    List<Product> products = new ArrayList<>();
    double price;

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void removeProduct(int count) {
        for(int i=0; i<count; i++)
            this.products.remove(0);
    }
}
