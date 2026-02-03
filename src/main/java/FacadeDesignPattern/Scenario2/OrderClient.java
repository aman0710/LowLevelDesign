package FacadeDesignPattern.Scenario2;

public class OrderClient {
    public static void main(String[] args) {
        OrderFacade orderFacade = new OrderFacade();
        orderFacade.createOrder();
    }
}
