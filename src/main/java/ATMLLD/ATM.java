package ATMLLD;


import ATMLLD.ATMStates.ATMState;
import ATMLLD.ATMStates.IdleState;

public class ATM {

    private static ATM atmObject = new ATM();
    ATMState atmState;
    private int balance;
    int twoThousandNotes;
    int fiveHundredNotes;
    int hundredNotes;

    private ATM() {
    }

    public static ATM getAtmObject() {
        atmObject.setAtmState(new IdleState());
        return atmObject;
    }

    public void setAtmState(ATMState state) {
        this.atmState = state;
    }

    public ATMState getAtmState() {
        return this.atmState;
    }

    public int getBalance() {
        return this.balance;
    }

    public void setBalance(int balance, int twoThousandNotes, int fiveHundredNotes, int hundredNotes) {
        this.balance = balance;
        this.twoThousandNotes = twoThousandNotes;
        this.fiveHundredNotes = fiveHundredNotes;
        this.hundredNotes = hundredNotes;
    }

    public int getTwoThousandNotes() {
        return this.twoThousandNotes;
    }

    public int getFiveHundredNotes() {
        return this.fiveHundredNotes;
    }

    public int getHundredNotes() {
        return this.hundredNotes;
    }

    public void deductATMBalance(int amount) {
        this.balance = this.balance - amount;
    }

    public void deductTwoThousandNotes(int number) {
        this.twoThousandNotes = this.twoThousandNotes - number;
    }

    public void deductFiveHundredNotes(int number) {
        this.fiveHundredNotes = this.fiveHundredNotes - number;
    }

    public void deductHundredNotes(int number) {
        this.hundredNotes = this.hundredNotes - number;
    }

    public void printCurrentATMStatus() {
        System.out.println("ATM Status:");
        System.out.println("ATM Balance: " + balance);
        System.out.println("2000 notes: " + twoThousandNotes);
        System.out.println("500 notes: " + fiveHundredNotes);
        System.out.println("100 notes: " + hundredNotes);
    }
}
