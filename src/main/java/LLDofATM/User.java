package LLDofATM;

public class User {
    Card card;
    BankAccount userBankAccount;

    public User(Card card, BankAccount userBankAccount) {
        this.card = card;
        this.userBankAccount = userBankAccount;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public BankAccount getUserBankAccount() {
        return userBankAccount;
    }

    public void setUserBankAccount(BankAccount userBankAccount) {
        this.userBankAccount = userBankAccount;
    }
}
