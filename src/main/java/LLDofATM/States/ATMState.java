package LLDofATM.States;

import LLDofATM.ATM;
import LLDofATM.Card;
import LLDofATM.TransactionType;
import NullObjectDesignPattern.Car;

public abstract class ATMState {
    public void insertCard(ATM atm) throws Exception {
        throw new Exception("OOPS! There was an exception");
    }

    public void authenticatePin(ATM atm, Card card, String pin) throws Exception {
        throw new Exception("OOPS! There was an exception");
    }

    public void selectOperation(ATM atm, Card card, TransactionType transactionType) throws Exception {
        throw new Exception("OOPS! There was an exception");
    }

    public void withdrawCash(ATM atm, Card card, int withdrawalAmount) throws Exception {
        throw new Exception("OOPS! There was an exception");
    }

    public void checkBalance(ATM atm, Card card) throws Exception {
        throw new Exception("OOPS! There was an exception");
    }

    public void returnCard(ATM atm) throws Exception {
        throw new Exception("OOPS! There was an exception");
    }

    public void exit(ATM atm) throws Exception {
        throw new Exception("OOPS! There was an Exception");
    }
}
