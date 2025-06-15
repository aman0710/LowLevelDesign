package LLDofATM.DenominationProcessor;

import LLDofATM.ATM;

public class TwoThousandWithdrawalProcessor extends CashWithdrawalProcessor{
    public TwoThousandWithdrawalProcessor(CashWithdrawalProcessor nextCashWithdrawalProcessor) {
        super(nextCashWithdrawalProcessor);
    }

    @Override
    public void withdraw(ATM atm, int remainingAmount) {
        int requiredNotes = remainingAmount / 2000;
        int balanceAmount = remainingAmount % 2000;

        if(requiredNotes > atm.getNoOfTwoThousandNotes()) {
            atm.setNoOfTwoThousandNotes(0);
            balanceAmount = balanceAmount + ((requiredNotes - atm.getNoOfTwoThousandNotes()) * 2000);
        }
        else {
            atm.setNoOfTwoThousandNotes(atm.getNoOfTwoThousandNotes() - requiredNotes);
        }

        if(balanceAmount != 0)
            super.withdraw(atm, balanceAmount);
    }
}
