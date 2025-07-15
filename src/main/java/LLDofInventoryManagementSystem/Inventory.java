package LLDofInventoryManagementSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Inventory {
    List<ProductCategory> productCategoryList;

    public Inventory() {
        this.productCategoryList = new ArrayList<>();
    }

    public void addCategory(int categoryId, String name, int price) {
        ProductCategory productCategory = new ProductCategory();
        productCategory.productCategoryId = categoryId;
        productCategory.productCategoryName = name;
        productCategory.price = price;
        productCategoryList.add(productCategory);
    }

    public void addProduct(Product product, int productCategoryId) {
        for(ProductCategory productCategory: productCategoryList) {
            if(productCategory.productCategoryId == productCategoryId) {
                productCategory.addProduct(product);
            }
        }
    }

    public void removeItems(Map<Integer, Integer> productCategoryAndCountMap){
        for(Map.Entry<Integer, Integer> entry : productCategoryAndCountMap.entrySet()) {
            ProductCategory category = getProductCategoryFromID(entry.getKey());
            category.removeProduct(entry.getValue());
        }
    }

    private ProductCategory getProductCategoryFromID(int productCategoryId) {
        for (ProductCategory productCategory : productCategoryList) {
            if (productCategory.productCategoryId == productCategoryId) {
                return productCategory;
            }
        }
        return null;
    }

    }
