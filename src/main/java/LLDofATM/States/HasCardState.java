package LLDofATM.States;

import LLDofATM.ATM;
import LLDofATM.Card;

public class HasCardState extends ATMState{

    public HasCardState() {
        System.out.println("The ATM is in Has Card state");
    }

    @Override
    public void authenticatePin(ATM atm, Card card, String pin) throws Exception {
        if(card.isEnteredPinCorrect(pin)) {
            System.out.println("The entered PIN is correct");
            atm.setAtmState(new SelectOperationState());
        }
        else {
            System.out.println("The entered PIN is incorrect");
            exit(atm);
        }
    }

    @Override
    public void returnCard(ATM atm) throws Exception {
        System.out.println("Please collect your card");
    }

    @Override
    public void exit(ATM atm) throws Exception {
        returnCard(atm);
        System.out.println("Exit!");
        atm.setAtmState(new IdleState());
    }
}
