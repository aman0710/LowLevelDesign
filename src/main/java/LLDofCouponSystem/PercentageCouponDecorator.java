package LLDofCouponSystem;

public class PercentageCouponDecorator extends CouponDecorator {
    Product product;
    int percentageDiscount;

    public PercentageCouponDecorator(Product product, int percentageDiscount) {
        this.product = product;
        this.percentageDiscount = percentageDiscount;
    }

    @Override
    public double getPrice() {
        double price = product.getPrice();
        return price - (price * percentageDiscount) / 100;
    }
}
