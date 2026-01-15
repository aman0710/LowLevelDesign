package ATMLLD.WithdrawalProcessors;

import ATMLLD.ATM;

public class FiveHundredProcessor extends WithdrawalProcessor{

    public FiveHundredProcessor(WithdrawalProcessor nextWithdrawalProcessor) {
        super(nextWithdrawalProcessor);
    }

    public void withdraw(ATM atm, int remainingAmt) {
        int requiredNotes = remainingAmt / 500;
        int balanceAmt = remainingAmt % 500;

        if(requiredNotes > atm.getFiveHundredNotes()) {
            int fiveHundredNotes = atm.getFiveHundredNotes();
            atm.deductFiveHundredNotes(fiveHundredNotes);
            balanceAmt += (requiredNotes - fiveHundredNotes) * 500;
        } else {
            atm.deductFiveHundredNotes(requiredNotes);
        }

        if(balanceAmt != 0) {
            super.withdraw(atm, balanceAmt);
        }
    }
}
