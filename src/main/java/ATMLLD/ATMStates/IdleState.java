package ATMLLD.ATMStates;

import ATMLLD.ATM;
import ATMLLD.Card;

public class IdleState extends ATMState{

    public IdleState() {
        System.out.println("ATM is currently in idle state!");
    }

    @Override
    public void insertCard(ATM atm, Card card) {
        System.out.println("Card inserted");
        atm.setAtmState(new HasCardState());
    }
}
