package LLDofATM;

import LLDofATM.States.ATMState;
import LLDofATM.States.IdleState;

public class ATM {
    ATMState atmState;
    int atmBalance;
    int noOfTwoThousandNotes;
    int noOfFiveHundredNotes;
    int noOfHundredNotes;

    public ATM(int atmBalance, int noOfTwoThousandNotes, int noOfFiveHundredNotes, int noOfHundredNotes) {
        this.atmBalance = atmBalance;
        this.noOfTwoThousandNotes = noOfTwoThousandNotes;
        this.noOfFiveHundredNotes = noOfFiveHundredNotes;
        this.noOfHundredNotes = noOfHundredNotes;
        this.atmState = new IdleState();
    }

    public ATMState getAtmState() {
        return atmState;
    }

    public void setAtmState(ATMState atmState) {
        this.atmState = atmState;
    }

    public int getAtmBalance() {
        return atmBalance;
    }

    public void setAtmBalance(int atmBalance) {
        this.atmBalance = atmBalance;
    }

    public int getNoOfTwoThousandNotes() {
        return noOfTwoThousandNotes;
    }

    public void setNoOfTwoThousandNotes(int noOfTwoThousandNotes) {
        this.noOfTwoThousandNotes = noOfTwoThousandNotes;
    }

    public int getNoOfFiveHundredNotes() {
        return noOfFiveHundredNotes;
    }

    public void setNoOfFiveHundredNotes(int noOfFiveHundredNotes) {
        this.noOfFiveHundredNotes = noOfFiveHundredNotes;
    }

    public int getNoOfHundredNotes() {
        return noOfHundredNotes;
    }

    public void setNoOfHundredNotes(int noOfHundredNotes) {
        this.noOfHundredNotes = noOfHundredNotes;
    }

    public void deductATMBalance(int amount) {
        this.atmBalance = this.atmBalance - amount;
    }

    public void displayATM() {
        System.out.println("ATM Balance : " + this.atmBalance);
        System.out.println("Rs.2000 notes : " + this.noOfTwoThousandNotes);
        System.out.println("Rs.500 notes : " + this.noOfFiveHundredNotes);
        System.out.println("Rs.100 notes : " + this.noOfHundredNotes);
    }
}
