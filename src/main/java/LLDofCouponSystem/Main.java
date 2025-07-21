package LLDofCouponSystem;

public class Main {
    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();
        Item item1 = new Item("VAN HEUSEN TSHIRT", ProductType.CLOTHES, 1000);
        Item item2 = new Item("TABLE", ProductType.FURNITURE, 2000);
        shoppingCart.addToCart(item1);
        shoppingCart.addToCart(item2);

        System.out.println("Total price of the order after applying discounts: " + shoppingCart.getTotalPrice());
    }
}
