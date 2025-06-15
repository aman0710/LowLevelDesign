package LLDofATM;

public class ATMRoom {
    User user;
    ATM atm;

    public ATMRoom(User user, ATM atm) {
        this.user = user;
        this.atm = atm;
    }

    public static ATMRoom intialize(int userBalance, String cardPIN, int atmBalance, int noOfTwoThousandNotes, int noOfFiveHundredNotes, int noOfHundredNotes) {
        BankAccount bankAccount = new BankAccount(userBalance);
        Card card = new Card(cardPIN, bankAccount);
        User user = new User(card, bankAccount);
        ATM atm = new ATM(atmBalance, noOfTwoThousandNotes, noOfFiveHundredNotes, noOfHundredNotes);
        ATMRoom atmRoom = new ATMRoom(user, atm);
        return atmRoom;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ATM getAtm() {
        return atm;
    }

    public void setAtm(ATM atm) {
        this.atm = atm;
    }
}
