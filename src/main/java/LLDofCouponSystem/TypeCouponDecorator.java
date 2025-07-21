package LLDofCouponSystem;

import java.util.ArrayList;
import java.util.List;

public class TypeCouponDecorator extends CouponDecorator{

    Product product;
    int percentageDiscount;
    ProductType productType;
    static List<ProductType> eligibleProductTypes = new ArrayList<>();
    static {
        eligibleProductTypes.add(ProductType.FURNITURE);
        eligibleProductTypes.add(ProductType.SPORTS);
    }

    public TypeCouponDecorator(Product product, int percentageDiscount, ProductType productType) {
        this.product = product;
        this.percentageDiscount = percentageDiscount;
        this.productType = productType;
    }

    @Override
    public double getPrice() {
        double price = product.getPrice();
        if(eligibleProductTypes.contains(this.productType)) {
            price = price - (price * percentageDiscount) / 100;
        }
        return price;
    }
}
