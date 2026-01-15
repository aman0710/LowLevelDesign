package ATMLLD.ATMStates;

import ATMLLD.ATM;
import ATMLLD.Card;
import ATMLLD.TransactionType;

public class SelectOperationState extends ATMState{

    public SelectOperationState() {
        System.out.println("Select one operation from the list below:");
        showAllOperations();
    }

    private void showAllOperations() {
        TransactionType.showAllTransactions();
    }

    @Override
    public void selectOperation(ATM atm, Card card, TransactionType type) {
        switch (type) {
            case CASH_WITHDRAWAL:
                atm.setAtmState(new CashWithdrawalState());
                break;
            case CHECK_BALANCE:
                atm.setAtmState(new CheckBalanceState());
                break;
            default: {
                System.out.println("Invalid Choice!");
                exit(atm);
            }
        }
    }

    @Override
    public void exit(ATM atm) {
        returnCard();
        atm.setAtmState(new IdleState());
        System.out.println("Exiting the process");
    }

    @Override
    public void returnCard() {
        System.out.println("Please collect your card");
    }
}
