package LLDofATM.States;


import LLDofATM.ATM;
import LLDofATM.Card;
import LLDofATM.DenominationProcessor.CashWithdrawalProcessor;
import LLDofATM.DenominationProcessor.FiveHundredWithdrawalProcessor;
import LLDofATM.DenominationProcessor.HundredWithdrawalProcessor;
import LLDofATM.DenominationProcessor.TwoThousandWithdrawalProcessor;

public class CashWithdrawalState extends ATMState {
    public CashWithdrawalState() {
        System.out.println("The ATM is in Cash Withdrawal state");
        System.out.println("Please enter the withdrawal amount");
    }

    @Override
    public void withdrawCash(ATM atm, Card card, int withdrawalAmount) throws Exception {
        if(withdrawalAmount > atm.getAtmBalance()) {
            System.out.println("Insufficient funds in the ATM. Please try a different ATM");
            exit(atm);
        } else if (withdrawalAmount > card.getUserBankAccount().getBalance()) {
            System.out.println("Insufficient funds in your bank account");
            exit(atm);
        }
        else {
            System.out.println("Funds present, dispensing cash...");
            CashWithdrawalProcessor cashWithdrawalProcessor = new TwoThousandWithdrawalProcessor(new FiveHundredWithdrawalProcessor(new HundredWithdrawalProcessor(null)));
            cashWithdrawalProcessor.withdraw(atm, withdrawalAmount);
            atm.deductATMBalance(withdrawalAmount);
            card.getUserBankAccount().deductAmount(withdrawalAmount);
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
