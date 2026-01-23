package SplitWiseLLD.Group;

import SplitWiseLLD.Expense.Expense;
import SplitWiseLLD.Expense.ExpenseController;
import SplitWiseLLD.Expense.ExpenseSplitType;
import SplitWiseLLD.Expense.Split;
import SplitWiseLLD.User.User;

import java.util.ArrayList;
import java.util.List;

public class Group {
    String groupName;
    String groupId;
    List<User> groupMembers;
    List<Expense> expenseList;
    ExpenseController expenseController;

    public Group() {
        groupMembers = new ArrayList<>();
        expenseList = new ArrayList<>();
        expenseController = new ExpenseController();
    }

    public void addMember(User user) {
        groupMembers.add(user);
    }

    public String getGroupId() {
        return this.groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Expense createExpense(String expenseId, String description, double expenseAmount, List<Split> splitDetails, ExpenseSplitType expenseSplitType, User paidByUser) {
        Expense expense = expenseController.createExpense(expenseId, description, expenseAmount, splitDetails, expenseSplitType, paidByUser);
        expenseList.add(expense);
        return expense;
    }
}
