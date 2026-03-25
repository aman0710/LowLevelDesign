package LLDofPaymentGateway.Transaction;

import LLDofPaymentGateway.Instrument.InstrumentDO;

public class Processor {

    public void processPayment(InstrumentDO senderInstrumentDO, InstrumentDO receiverInstrumentDO) {
        // validate sender instrument
        // validate receiver instrument
        // process payment
        // update balance in debit instrument - debit
        // update balance in credit instrument - credit
    }
}
