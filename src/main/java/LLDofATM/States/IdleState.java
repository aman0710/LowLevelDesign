package LLDofATM.States;

import LLDofATM.ATM;

public class IdleState extends ATMState {

    public IdleState(){
        System.out.println("The ATM is in idle state");
    }

    @Override
    public void insertCard(ATM atm) throws Exception {
        System.out.println("Please insert your card");
        atm.setAtmState(new HasCardState());
    }
}
