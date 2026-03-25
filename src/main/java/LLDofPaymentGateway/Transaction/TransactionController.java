package LLDofPaymentGateway.Transaction;

import java.util.List;

public class TransactionController {
    TransactionService transactionService;
    public TransactionController() {
        this.transactionService = new TransactionService();
    }

    public List<Transaction> getTransactionHistory(int userId) {
        return transactionService.getTransactionHistory(userId);
    }

    public TransactionDO makePayment(TransactionDO transactionDO) {
        return transactionService.makePayment(transactionDO);
    }
}
