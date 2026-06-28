package LLD.FacadeDesignPattern;

public class BankFacade {

    private final Account account;
    private final Security security;
    private final Funds funds;
    private final Notification notification;

    public BankFacade() {
        this.account = new Account();
        this.security = new Security();
        this.funds = new Funds();
        this.notification = new Notification();
    }

    public void withdraw(String accountNumber, int pin, double amount) {
        System.out.println("Starting the withdrawal process...");
        if(account.verifyAccount(accountNumber) && security.verifyPin(pin) && funds.sufficientFundsPresent(amount)) {
            funds.debit(amount);
            notification.sendNotification("Withdrawal of $" + amount+ " successful");
        } else {
            System.out.println("Withdrawal of amount failed!");
        }
    }
}
