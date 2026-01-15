package ATMLLD;

public class BankAccount {

    int balance;

    public void withdrawalBalance(int amount) {
        this.balance = this.balance - amount;
    }
}
