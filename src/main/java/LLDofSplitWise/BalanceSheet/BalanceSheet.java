package LLDofSplitWise.BalanceSheet;

import java.util.HashMap;
import java.util.Map;

public class BalanceSheet {
    Map<String, Balance> userVsBalance;
    double totalExpense;
    double totalPayment;
    double totalYouOwe;
    double totalYouGetBack;

    public BalanceSheet() {
        this.userVsBalance = new HashMap<>();
        this.totalExpense = 0;
        this.totalPayment = 0;
        this.totalYouOwe = 0;
        this.totalYouGetBack = 0;

    }

    public double getTotalExpense() {
        return totalExpense;
    }

    public void setTotalExpense(double totalExpense) {
        this.totalExpense = totalExpense;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(double totalPayment) {
        this.totalPayment = totalPayment;
    }

    public double getTotalYouOwe() {
        return totalYouOwe;
    }

    public void setTotalYouOwe(double totalYouOwe) {
        this.totalYouOwe = totalYouOwe;
    }

    public double getTotalYouGetBack() {
        return totalYouGetBack;
    }

    public void setTotalYouGetBack(double totalYouGetBack) {
        this.totalYouGetBack = totalYouGetBack;
    }

    public Map<String, Balance> getUserVsBalance() {
        return userVsBalance;
    }

    public void setUserVsBalance(Map<String, Balance> userVsBalance) {
        this.userVsBalance = userVsBalance;
    }
}
