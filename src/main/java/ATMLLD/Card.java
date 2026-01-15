package ATMLLD;

public class Card {

    private int cardNumber;
    private int cvv;
    private int expiryDate;
    private String holderName;
    static int PIN_NUMBER;
    private BankAccount bankAccount;

    public Card() {
        PIN_NUMBER = 112211;
    }

    public boolean isCorrectPinEntered(int pin) {
        return PIN_NUMBER == pin;
    }

    public int getBankBalance() {
        return bankAccount.balance;
    }

    public void deductBankBalance(int amount) {
        bankAccount.withdrawalBalance(amount);
    }

    public void setBankAccount(BankAccount account) {
        this.bankAccount = account;
    }
}
