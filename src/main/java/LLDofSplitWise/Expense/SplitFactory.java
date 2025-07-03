package LLDofSplitWise.Expense;

import LLDofSplitWise.Expense.Split.EqualExpenseSplit;
import LLDofSplitWise.Expense.Split.ExpenseSplit;
import LLDofSplitWise.Expense.Split.PercentageExpenseSplit;
import LLDofSplitWise.Expense.Split.UnequalExpenseSplit;

public class SplitFactory {
    public static ExpenseSplit getExpenseSplitObject(SplitType splitType) {
        switch (splitType) {
            case EQUAL:
                return new EqualExpenseSplit();
            case UNEQUAL:
                return new UnequalExpenseSplit();
            case PERCENTAGE:
                return new PercentageExpenseSplit();
            default:
                return null;
        }
    }
}
