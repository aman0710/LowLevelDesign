package LLDofCouponSystem;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    List<Product> productList;

    public ShoppingCart() {
        this.productList = new ArrayList<>();
    }

    public void addToCart(Product product) {
        Product productAfterDiscount = new TypeCouponDecorator(new PercentageCouponDecorator(product, 10), 3, product.getProductType());
        productList.add(productAfterDiscount);
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for(Product product: productList) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }
}
