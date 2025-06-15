package LLDofATM;

public class BankAccount {
    int balance;

    public BankAccount(int amount) {
        this.balance = amount;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void deductAmount(int amount) {
        this.balance = this.balance - amount;
    }
}
