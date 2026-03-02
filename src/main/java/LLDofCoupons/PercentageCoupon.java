package LLDofCoupons;

public class PercentageCoupon extends ProductCoupon{
    Product product;
    double percentageDiscount;

    public PercentageCoupon(Product product, double percentageDiscount) {
        this.product = product;
        this.percentageDiscount = percentageDiscount;
    }

    @Override
    public double getPrice() {
        double price = product.getPrice();
        return price - (price * percentageDiscount) / 100;
    }
}
