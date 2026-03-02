package LLDofCoupons;

import java.util.ArrayList;
import java.util.List;

public class ProductTypeCoupon extends ProductCoupon{

    Product product;
    double percentageDiscount;
    ProductType productType;
    static List<ProductType> eligibleProductTypes = new ArrayList<>();
    static {
        eligibleProductTypes.add(ProductType.FURNITURE);
        eligibleProductTypes.add(ProductType.DECORATIVE_GOODS);
    }

    public ProductTypeCoupon(Product product, double percentageDiscount, ProductType productType) {
        this.product = product;
        this.percentageDiscount = percentageDiscount;
        this.productType = productType;
    }

    @Override
    public double getPrice() {
        if(eligibleProductTypes.contains(this.productType)) {
            double price = product.getPrice();
            return price - (price * percentageDiscount) / 100;
        }
        return product.getPrice();
    }
}
