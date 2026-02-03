package FacadeDesignPattern.Scenario2;

public class OrderFacade {
    ProductDao productDao;
    Payment payment;
    Invoice invoice;
    Notification notification;

    public OrderFacade() {
        this.productDao = new ProductDao();
        this.payment = new Payment();
        this.invoice = new Invoice();
        this.notification = new Notification();
    }

    public void createOrder() {
        Product product = productDao.getProductById(121);
        payment.makePayment();
        boolean isInvoiceGenerated = invoice.generateInvoice();
        if(isInvoiceGenerated)
            notification.sendNotification();
    }
}
