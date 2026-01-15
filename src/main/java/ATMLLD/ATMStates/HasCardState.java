package ATMLLD.ATMStates;

import ATMLLD.ATM;
import ATMLLD.Card;

public class HasCardState extends ATMState{

    public HasCardState() {
        System.out.println("Enter your PIN number");
    }

    @Override
    public void authenticatePin(ATM atm, Card card, int pin) {
        boolean isCorrectPinEntered = card.isCorrectPinEntered(pin);
        if(isCorrectPinEntered) {
            atm.setAtmState(new SelectOperationState());
        } else {
            System.out.println("Wrong PIN entered!");
            exit(atm);
        }
    }

    @Override
    public void exit(ATM atm) {
        returnCard();
        atm.setAtmState(new IdleState());
        System.out.println("Exiting this process!");
    }

    @Override
    public void returnCard() {
        System.out.println("Please collect your card");
    }
}
