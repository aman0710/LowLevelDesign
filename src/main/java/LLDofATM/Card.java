package LLDofATM;

import java.util.Date;

public class Card {
    Date expiryDate;
    String cardHolder;
    int cvv;
    String cardPIN;
    BankAccount userBankAccount;

    public Card(String pin, BankAccount bankAccount) {
        this.cardPIN = pin;
        this.userBankAccount = bankAccount;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public String getCardPIN() {
        return cardPIN;
    }

    public void setCardPIN(String cardPIN) {
        this.cardPIN = cardPIN;
    }

    public BankAccount getUserBankAccount() {
        return userBankAccount;
    }

    public void setUserBankAccount(BankAccount userBankAccount) {
        this.userBankAccount = userBankAccount;
    }

    public boolean isEnteredPinCorrect(String pin) {
        return cardPIN.equalsIgnoreCase(pin);
    }

    public void displayBalance() {
        System.out.println("Your bank account balance is : " + this.getUserBankAccount().getBalance());
    }
}
