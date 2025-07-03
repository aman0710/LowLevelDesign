package LLDofSplitWise.Group;

import LLDofSplitWise.Expense.Expense;
import LLDofSplitWise.Expense.ExpenseController;
import LLDofSplitWise.Expense.Split.Split;
import LLDofSplitWise.Expense.SplitType;
import LLDofSplitWise.User.User;

import java.util.ArrayList;
import java.util.List;

public class Group {

    String id;
    String name;
    List<User> userList;
    List<Expense> expenseList;
    ExpenseController expenseController;

    public Group(String id, String name) {
        this.id = id;
        this.name = name;
        this.userList = new ArrayList<>();
        this.expenseList = new ArrayList<>();
        this.expenseController = new ExpenseController();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addMember(User user) {
        this.userList.add(user);
    }

    public Expense createExpense(String id, String description, double amount, User paidByUser, SplitType splitType, List<Split> splitList) {
        Expense expense = null;
        try{
            expense = expenseController.createExpense(id, description, amount, paidByUser, splitType, splitList);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        expenseList.add(expense);
        return expense;
    }

}
