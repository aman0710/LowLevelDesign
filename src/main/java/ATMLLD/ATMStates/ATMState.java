package ATMLLD.ATMStates;

import ATMLLD.ATM;
import ATMLLD.Card;
import ATMLLD.TransactionType;

public abstract class ATMState {
    public void insertCard(ATM atm, Card card) {
        System.out.println("OOPS! Something went wrong");
    }

    public void authenticatePin(ATM atm, Card card, int pin) {
        System.out.println("OOPS! Something went wrong");
    }

    public void selectOperation(ATM atm, Card card, TransactionType type) {
        System.out.println("OOPS! Something went wrong");
    }

    public void cashWithdrawal(ATM atm, Card card, int amt) {
        System.out.println("OOPS! Something went wrong");
    }

    public void checkBalance(ATM atm, Card card) {
        System.out.println("OOPS! Something went wrong");
    }

    public void returnCard() {
        System.out.println("OOPS! Something went wrong");
    }

    public void exit(ATM atm) {
        System.out.println("OOPS! Something went wrong");
    }
}
