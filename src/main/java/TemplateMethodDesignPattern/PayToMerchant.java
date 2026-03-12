package TemplateMethodDesignPattern;

public class PayToMerchant extends PaymentFlow{
    @Override
    public void validateRequest() {
        System.out.println("Validate payment to merchant");
    }

    @Override
    public void debitMoney() {
        System.out.println("Debit money for paying to merchant");
    }

    @Override
    public void calculateFees() {
        System.out.println("2% fees charged");
    }

    @Override
    public void creditMoney() {
        System.out.println("Credit the remaining amount");
    }
}
