package SplitWiseLLD.Expense;

import SplitWiseLLD.BalanceSheetController;
import SplitWiseLLD.User.User;

import java.util.Collections;
import java.util.List;

public class ExpenseController {
    BalanceSheetController balanceSheetController;

    public ExpenseController() {
        this.balanceSheetController = new BalanceSheetController();
    }

    public Expense createExpense(String expenseId, String description, double expenseAmount, List<Split> splitDetails, ExpenseSplitType expenseSplitType, User paidByUser) {
        ExpenseSplit expenseSplit = SplitFactory.getSplitObject(expenseSplitType);

        if(expenseSplit != null) {
            expenseSplit.validateSplitRequest(splitDetails, expenseAmount);
        }
        Expense expense = new Expense(expenseId, description, expenseAmount, paidByUser, expenseSplitType, splitDetails);
        balanceSheetController.updateUserExpenseBalanceSheet(paidByUser, splitDetails, expenseAmount);

        return expense;
    }
}
