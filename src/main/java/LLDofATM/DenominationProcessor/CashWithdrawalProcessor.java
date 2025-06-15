package LLDofATM.DenominationProcessor;

import LLDofATM.ATM;

public abstract class CashWithdrawalProcessor {
    CashWithdrawalProcessor nextCashWithdrawalProcessor;

    public CashWithdrawalProcessor(CashWithdrawalProcessor nextCashWithdrawalProcessor) {
        this.nextCashWithdrawalProcessor = nextCashWithdrawalProcessor;
    }

    public void withdraw(ATM atm, int remainingAmount) {
        if(nextCashWithdrawalProcessor != null)
            nextCashWithdrawalProcessor.withdraw(atm, remainingAmount);
    }
}
