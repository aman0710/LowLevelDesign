package LLDofCoupons;

public abstract class Product {
    String name;
    double price;
    ProductType productType;

    public Product() {

    }

    public Product(String name, double price, ProductType productType) {
        this.name = name;
        this.price = price;
        this.productType = productType;
    }

    public abstract double getPrice();

    public ProductType getProductType() {
        return this.productType;
    }
}
