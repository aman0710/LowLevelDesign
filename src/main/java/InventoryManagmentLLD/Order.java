package InventoryManagmentLLD;

import java.util.HashMap;
import java.util.Map;

public class Order {
    User user;
    Address deliveryAddress;
    Map<Integer, Integer> productCategoryIdVsCount;
    Warehouse warehouse;
    Invoice invoice;
    Payment payment;
    OrderStatus orderStatus;

    public Order(User user, Warehouse warehouse) {
        this.user = user;
        this.productCategoryIdVsCount = user.getUserCart().getCartItems();
        this.warehouse = warehouse;
        this.deliveryAddress = user.address;
        this.invoice = new Invoice();
        invoice.generateInvoice(this);
    }

    public void checkout() {
        // 1. update inventory
        warehouse.removeItemsFromInventory(productCategoryIdVsCount);

        // 2. make payment
        boolean isPaymentSuccess = makePayment(new UPIPaymentMode());
        if(isPaymentSuccess) {
            user.getUserCart().emptyCart();
        } else {
            warehouse.addItemToInventory(productCategoryIdVsCount);
        }
    }

    public boolean makePayment(PaymentMode paymentMode) {
        payment = new Payment(paymentMode);
        return payment.makePayment();
    }

    public void generateOrderInvoice() {
        invoice.generateInvoice(this);
    }
}
