package LLDofATM.DenominationProcessor;

import LLDofATM.ATM;

public class HundredWithdrawalProcessor extends CashWithdrawalProcessor{
    public HundredWithdrawalProcessor(CashWithdrawalProcessor nextCashWithdrawalProcessor) {
        super(nextCashWithdrawalProcessor);
    }

    @Override
    public void withdraw(ATM atm, int remainingAmount) {
        int requiredNotes = remainingAmount / 100;
        int balanceAmount = remainingAmount % 100;

        if(requiredNotes > atm.getNoOfHundredNotes()) {
            atm.setNoOfHundredNotes(0);
            balanceAmount = balanceAmount + ((requiredNotes - atm.getNoOfHundredNotes()) * 100);
        }
        else {
            atm.setNoOfHundredNotes(atm.getNoOfHundredNotes() - requiredNotes);
        }

        if(balanceAmount != 0)
            super.withdraw(atm, balanceAmount);
    }
}
