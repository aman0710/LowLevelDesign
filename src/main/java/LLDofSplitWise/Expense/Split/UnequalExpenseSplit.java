package LLDofSplitWise.Expense.Split;

import java.util.List;

public class UnequalExpenseSplit implements ExpenseSplit{

    @Override
    public void validateExpenseSplitRequest(List<Split> splitList, double totalAmount) throws Exception {
        double sum = 0;
        for(Split split: splitList) {
            sum += split.getAmountOwe();
        }
        if(sum != totalAmount)
            throw new Exception("Invalid split of amount");
    }
}
