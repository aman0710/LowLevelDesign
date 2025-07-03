package LLDofSplitWise.Expense;

import LLDofSplitWise.BalanceSheet.BalanceSheetController;
import LLDofSplitWise.Expense.Split.ExpenseSplit;
import LLDofSplitWise.Expense.Split.Split;
import LLDofSplitWise.User.User;

import java.util.List;

public class ExpenseController {
    BalanceSheetController balanceSheetController;

    public ExpenseController() {
        this.balanceSheetController = new BalanceSheetController();
    }

    public Expense createExpense(String id, String description, double amount, User paidByUser, SplitType splitType, List<Split> splitList) throws Exception {
        ExpenseSplit expenseSplit = SplitFactory.getExpenseSplitObject(splitType);
        expenseSplit.validateExpenseSplitRequest(splitList, amount);
        Expense expense = new Expense(id, description, amount, paidByUser, splitType, splitList);
        balanceSheetController.updateBalanceSheet(paidByUser, splitList, amount);
        return expense;
    }
}
