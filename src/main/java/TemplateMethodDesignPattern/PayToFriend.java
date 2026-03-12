package TemplateMethodDesignPattern;

public class PayToFriend extends PaymentFlow{
    @Override
    public void validateRequest() {
        System.out.println("Validate payment to friend");
    }

    @Override
    public void debitMoney() {
        System.out.println("Debit money for paying to friend");
    }

    @Override
    public void calculateFees() {
        System.out.println("0% fees charged");
    }

    @Override
    public void creditMoney() {
        System.out.println("Credit the full amount");
    }
}
