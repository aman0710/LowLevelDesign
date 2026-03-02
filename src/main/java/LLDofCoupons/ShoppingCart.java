package LLDofCoupons;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    List<Product> productList;

    public ShoppingCart() {
        this.productList = new ArrayList<>();
    }

    public void addToCart(Product product) {
        Product productWithEligibleCouponsApplied = new ProductTypeCoupon(new PercentageCoupon(product, 10), 3, product.getProductType());
        this.productList.add(productWithEligibleCouponsApplied);
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for(Product product: productList) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }
}
