package ATMLLD;

public enum TransactionType {
    CASH_WITHDRAWAL,
    CHECK_BALANCE;

    public static void showAllTransactions() {
        System.out.println("All transaction types are listed below:");
        for(TransactionType type: TransactionType.values()) {
            System.out.println("--->" + type.name());
        }
    }
}
