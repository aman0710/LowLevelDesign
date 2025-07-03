package LLDofSplitWise.Expense.Split;

import java.util.List;

public class EqualExpenseSplit implements ExpenseSplit {

    @Override
    public void validateExpenseSplitRequest(List<Split> splitList, double totalAmount) throws Exception {
        double amountPerUser = totalAmount / splitList.size();
        for(Split split : splitList){
            if(split.getAmountOwe() != amountPerUser)
                throw new Exception("Unequal or Invalid amount");
        }
    }
}
