package LLDofCoupons;

public class Main {
    public static void main(String[] args) {
        Product item1 = new Item("SOFA", 2000, ProductType.FURNITURE);
        Product item2 = new Item("FAN", 1000, ProductType.ELECTRONICS);

        ShoppingCart cart = new ShoppingCart();
        cart.addToCart(item1);
        cart.addToCart(item2);

        System.out.println("The total price of the items after discount: " + cart.getTotalPrice());
    }
}
