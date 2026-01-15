package ATMLLD.WithdrawalProcessors;

import ATMLLD.ATM;

public class TwoThousandProcessor extends WithdrawalProcessor {

    public TwoThousandProcessor(WithdrawalProcessor nextWithdrawalProcessor) {
        super(nextWithdrawalProcessor);
    }

    public void withdraw(ATM atm, int remainingAmt) {
        int requiredNotes = remainingAmt / 2000;
        int balanceAmt = remainingAmt % 2000;

        if(requiredNotes > atm.getTwoThousandNotes()) {
            int twoThousandNotes = atm.getTwoThousandNotes();
            atm.deductTwoThousandNotes(twoThousandNotes);
            balanceAmt += (requiredNotes - twoThousandNotes) * 2000;
        }
        else {
            atm.deductTwoThousandNotes(requiredNotes);
        }

        if(balanceAmt != 0) {
            super.withdraw(atm, balanceAmt);
        }
    }
}
