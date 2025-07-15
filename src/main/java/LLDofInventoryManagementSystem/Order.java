package LLDofInventoryManagementSystem;

import java.util.Map;

public class Order {
    User user;
    Address deliveryAddress;
    Map<Integer, Integer> productCategoryAndCount;
    Warehouse warehouse;
    Invoice invoice;
    Payment payment;
    OrderStatus orderStatus;

    public Order(User user, Warehouse warehouse){
        this.user = user;
        this.productCategoryAndCount = user.getUserCart().getCartItems();
        this.warehouse = warehouse;
        invoice = new Invoice();
        invoice.generateInvoice();
    }

    public void checkout(){

        //1. update inventory
        warehouse.removeItemsFromInventory(productCategoryAndCount);

        //2. make Payment
        boolean isPaymentSuccess = makePayment(new UPIPaymentMode());

        //3. make cart empty
        if(isPaymentSuccess) {
            user.getUserCart().emptyCart();
        }
        else{
            warehouse.addItemsToInventory(productCategoryAndCount);
        }

    }

    public boolean makePayment(PaymentMode paymentMode){
        payment = new Payment(paymentMode);
        return payment.makePayment();
    }


    public void generateOrderInvoice(){
        invoice.generateInvoice();
    }


}
