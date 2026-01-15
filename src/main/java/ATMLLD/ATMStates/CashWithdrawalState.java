package ATMLLD.ATMStates;

import ATMLLD.ATM;
import ATMLLD.Card;
import ATMLLD.WithdrawalProcessors.FiveHundredProcessor;
import ATMLLD.WithdrawalProcessors.HundredProcessor;
import ATMLLD.WithdrawalProcessors.TwoThousandProcessor;
import ATMLLD.WithdrawalProcessors.WithdrawalProcessor;

public class CashWithdrawalState extends ATMState{

    public CashWithdrawalState() {
        System.out.println("ATM is in cash withdrawal state. Please enter the withdrawal amount:");
    }

    @Override
    public void cashWithdrawal(ATM atm, Card card, int amt) {
        if(amt > card.getBankBalance()) {
            System.out.println("Insufficient funds in your bank account");
            exit(atm);
        } else if(amt > atm.getBalance()) {
            System.out.println("Insufficient funds in the ATM");
            exit(atm);
        } else {
            atm.deductATMBalance(amt);
            card.deductBankBalance(amt);
            WithdrawalProcessor withdrawalProcessor = new TwoThousandProcessor(new FiveHundredProcessor(new HundredProcessor(null)));
            withdrawalProcessor.withdraw(atm, amt);
            exit(atm);
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
