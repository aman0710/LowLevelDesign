package TemplateMethodDesignPattern;

public class Main {
    public static void main(String[] args) {
        PaymentFlow friendFlow = new PayToFriend();
        PaymentFlow merchantFlow = new PayToMerchant();

        friendFlow.sendMoney();
        System.out.println("\n");
        merchantFlow.sendMoney();
    }
}
