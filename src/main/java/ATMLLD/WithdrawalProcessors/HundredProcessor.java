package ATMLLD.WithdrawalProcessors;

import ATMLLD.ATM;

public class HundredProcessor extends WithdrawalProcessor{

    public HundredProcessor(WithdrawalProcessor nextWithdrawalProcessor) {
        super(nextWithdrawalProcessor);
    }

    public void withdraw(ATM atm, int remainingAmt) {
        int requiredNotes = remainingAmt / 100;
        int balanceAmt = remainingAmt % 100;

        if(requiredNotes > atm.getHundredNotes()) {
            int hundredNotes = atm.getHundredNotes();
            atm.deductHundredNotes(hundredNotes);
            balanceAmt += (requiredNotes - hundredNotes) * 100;
        } else {
            atm.deductHundredNotes(requiredNotes);
        }

        if(balanceAmt != 0) {
            System.out.println("Something went wrong!");
        }
    }
}
