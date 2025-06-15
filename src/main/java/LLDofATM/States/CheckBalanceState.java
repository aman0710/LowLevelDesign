package LLDofATM.States;

import LLDofATM.ATM;
import LLDofATM.Card;

public class CheckBalanceState extends ATMState{

    public CheckBalanceState() {
        System.out.println("The ATM is in Check Balance state");
    }

    @Override
    public void checkBalance(ATM atm, Card card) throws Exception {
        int balance = card.getUserBankAccount().getBalance();
        System.out.println("Your bank account balance is : " + balance);
        exit(atm);
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
