package LLDofSplitWise.Expense.Split;

import LLDofSplitWise.User.User;

public class Split {
    User user;
    double amountOwe;

    public Split(User user, double amountOwe) {
        this.amountOwe = amountOwe;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getAmountOwe() {
        return amountOwe;
    }

    public void setAmountOwe(double amountOwe) {
        this.amountOwe = amountOwe;
    }
}
