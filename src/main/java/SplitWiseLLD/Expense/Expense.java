package SplitWiseLLD.Expense;

import SplitWiseLLD.User.User;

import java.util.ArrayList;
import java.util.List;

public class Expense {
    String expenseId;
    String description;
    double expenseAmount;
    User paidByUser;
    ExpenseSplitType expenseSplitType;
    List<Split> splitDetails = new ArrayList<Split>();

    public Expense(String expenseId, String description, double expenseAmount, User paidByUser, ExpenseSplitType expenseSplitType, List<Split> splitDetails) {
        this.expenseId = expenseId;
        this.description = description;
        this.expenseAmount = expenseAmount;
        this.paidByUser = paidByUser;
        this.expenseSplitType = expenseSplitType;
        this.splitDetails.addAll(splitDetails);
    }
}
