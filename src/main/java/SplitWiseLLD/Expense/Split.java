package SplitWiseLLD.Expense;

import SplitWiseLLD.User.User;

public class Split {
    double amountOwe;
    User user;

    public Split(User user, double amountOwe) {
        this.amountOwe = amountOwe;
        this.user = user;
    }

    public User getUser() {
        return this.user;
    }

    public double getAmountOwe() {
        return this.amountOwe;
    }

    public void setAmountOwe(double amountOwe) {
        this.amountOwe = amountOwe;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
