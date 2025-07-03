package LLDofSplitWise.Expense.Split;

import java.util.List;

public interface ExpenseSplit {
    public void validateExpenseSplitRequest(List<Split> splitList, double totalAmount) throws Exception;
}
