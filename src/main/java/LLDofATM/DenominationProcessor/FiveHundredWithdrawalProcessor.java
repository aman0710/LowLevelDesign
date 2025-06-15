package LLDofATM.DenominationProcessor;

import LLDofATM.ATM;

public class FiveHundredWithdrawalProcessor extends CashWithdrawalProcessor{
    public FiveHundredWithdrawalProcessor(CashWithdrawalProcessor nextCashWithdrawalProcessor) {
        super(nextCashWithdrawalProcessor);
    }

    @Override
    public void withdraw(ATM atm, int remainingAmount) {
        int requiredNotes = remainingAmount / 500;
        int balanceAmount = remainingAmount % 500;

        if(requiredNotes > atm.getNoOfFiveHundredNotes()) {
            atm.setNoOfFiveHundredNotes(0);
            balanceAmount = balanceAmount + ((requiredNotes - atm.getNoOfFiveHundredNotes()) * 500);
        }
        else {
            atm.setNoOfFiveHundredNotes(atm.getNoOfFiveHundredNotes() - requiredNotes);
        }

        if(balanceAmount != 0)
            super.withdraw(atm, balanceAmount);
    }
}
