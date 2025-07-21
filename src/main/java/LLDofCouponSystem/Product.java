package LLDofCouponSystem;

public abstract class Product {
    String name;
    ProductType productType;
    double price;

    public Product(String name, ProductType productType, double price) {
        this.name = name;
        this.productType = productType;
        this.price = price;
    }

    public Product() {

    }

    public ProductType getProductType() {
        return productType;
    }

    public double getPrice() {
        return this.price;
    }

    public String getName() {
        return name;
    }
}
