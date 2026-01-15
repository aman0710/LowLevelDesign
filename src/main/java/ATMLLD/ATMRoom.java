package ATMLLD;

public class ATMRoom {
    ATM atm;
    User user;

    public void initialize() {
        this.atm = ATM.getAtmObject();
        atm.setBalance(3500, 1, 2, 5);
        this.user = createUser();
    }

    private User createUser() {
        User user = new User();
        user.setCard(createCard());
        return user;
    }

    private Card createCard() {
        Card card = new Card();
        card.setBankAccount(createBankAccount());
        return card;
    }

    private BankAccount createBankAccount() {
        BankAccount bankAccount = new BankAccount();
        bankAccount.balance = 3000;
        return bankAccount;
    }
}
