package LLDofCoupons;

public class Item extends Product{
    public Item(String name, double price, ProductType productType) {
        super(name, price, productType);
    }

    @Override
    public double getPrice() {
        return this.price;
    }
}
