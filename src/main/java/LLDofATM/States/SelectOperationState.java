package LLDofATM.States;

import LLDofATM.ATM;
import LLDofATM.Card;
import LLDofATM.TransactionType;
import NullObjectDesignPattern.Car;

public class SelectOperationState extends ATMState{

    public SelectOperationState() {
        System.out.println("The ATM is in Select Operation state");
        System.out.println("Please select one of the following operations: ");
        showAllOperations();
    }

    @Override
    public void selectOperation(ATM atm, Card card, TransactionType transactionType) throws Exception {
        switch (transactionType) {
            case CASH_WITHDRAWAL:
                atm.setAtmState(new CashWithdrawalState());
                break;
            case CHECK_BALANCE:
                atm.setAtmState(new CheckBalanceState());
                break;
            default:
                System.out.println("The entered operation is invalid!");
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

    public void showAllOperations() {
        TransactionType.showAllTransactionTypes();
    }
}
