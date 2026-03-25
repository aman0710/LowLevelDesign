package LLDofPaymentGateway.Transaction;

import LLDofPaymentGateway.Instrument.InstrumentController;
import LLDofPaymentGateway.Instrument.InstrumentDO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactionService {
    public static Map<Integer, List<Transaction>> userVsTransactionsList = new HashMap<>();
    InstrumentController instrumentController;
    Processor processor;

    public TransactionService() {
        instrumentController = new InstrumentController();
        processor = new Processor();
    }

    public List<Transaction> getTransactionHistory(int userId) {
        return userVsTransactionsList.get(userId);
    }

    public TransactionDO makePayment(TransactionDO txnDO) {
        // validate details
        InstrumentDO senderInstrumentDO = instrumentController.getInstrumentById(txnDO.getSenderId(), txnDO.getDebitInstrumentId());
        InstrumentDO receiverInstrumentDO = instrumentController.getInstrumentById(txnDO.getReceiverId(), txnDO.getCreditInstrumentId());
        processor.processPayment(senderInstrumentDO, receiverInstrumentDO);
        Transaction txn = new Transaction();
        txn.setAmount(txnDO.getAmount());
        txn.setTxnId(txnDO.getTxnId());
        txn.setSenderId(txnDO.getSenderId());
        txn.setReceiverId(txnDO.getReceiverId());
        txn.setCreditInstrumentId(txnDO.getCreditInstrumentId());
        txn.setDebitInstrumentId(txnDO.getDebitInstrumentId());
        txn.setTransactionStatus(TransactionStatus.SUCCESS);

        List<Transaction> senderTxnsList = userVsTransactionsList.get(txn.getSenderId());
        if(senderTxnsList == null) {
            senderTxnsList = new ArrayList<>();
            userVsTransactionsList.put(txn.getSenderId(), senderTxnsList);
        }
        senderTxnsList.add(txn);
        List<Transaction> receiverTxnsList = userVsTransactionsList.get(txn.getReceiverId());
        if(receiverTxnsList == null) {
            receiverTxnsList = new ArrayList<>();
            userVsTransactionsList.put(txn.getReceiverId(), receiverTxnsList);
        }
        receiverTxnsList.add(txn);
        txnDO.setTransactionStatus(txn.getTransactionStatus());
        return txnDO;
    }
}
