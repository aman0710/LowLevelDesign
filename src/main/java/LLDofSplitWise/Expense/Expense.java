package LLDofSplitWise.Expense;

import LLDofSplitWise.Expense.Split.Split;
import LLDofSplitWise.User.User;

import java.util.List;

public class Expense {
    String id;
    String description;
    double amount;
    User paidByUser;
    SplitType splitType;
    List<Split> splitList;

    public Expense(String id, String description, double amount, User paidByUser, SplitType splitType, List<Split> splitList) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.paidByUser = paidByUser;
        this.splitType = splitType;
        this.splitList = splitList;
    }
}
