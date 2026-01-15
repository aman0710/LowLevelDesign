package ATMLLD.WithdrawalProcessors;

import ATMLLD.ATM;

public abstract class WithdrawalProcessor {

    WithdrawalProcessor nextWithdrawalProcessor;

    public WithdrawalProcessor(WithdrawalProcessor nextWithdrawalProcessor) {
        this.nextWithdrawalProcessor = nextWithdrawalProcessor;
    }

    public void withdraw(ATM atm, int remainingAmt) {
        if(nextWithdrawalProcessor != null) {
            nextWithdrawalProcessor.withdraw(atm, remainingAmt);
        }
    }
}
