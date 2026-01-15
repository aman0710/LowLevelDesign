package ATMLLD.ATMStates;

import ATMLLD.ATM;
import ATMLLD.Card;

public class CheckBalanceState extends ATMState{

    public CheckBalanceState() {
        System.out.println("ATM is in check balance state. Checking your balance...");
    }

    @Override
    public void checkBalance(ATM atm, Card card) {
        System.out.println("Your bank balance is: " + card.getBankBalance());
        exit(atm);
    }

    @Override
    public void exit(ATM atm) {
        returnCard();
        atm.setAtmState(new IdleState());
        System.out.println("Exiting the process!");
    }

    @Override
    public void returnCard() {
        System.out.println("Please collect your card");
    }
}
