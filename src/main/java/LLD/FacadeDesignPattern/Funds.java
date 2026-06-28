package LLD.FacadeDesignPattern;

public class Funds {
    public boolean sufficientFundsPresent(double amount) {
        System.out.println("Sufficient funds are available");
        return true;
    }

    public void debit(double amount) {
        System.out.println("Debited: $" + amount);
    }
}
