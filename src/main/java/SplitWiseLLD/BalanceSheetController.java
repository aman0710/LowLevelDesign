package SplitWiseLLD;

import SplitWiseLLD.Expense.Split;
import SplitWiseLLD.User.User;

import java.util.List;
import java.util.Map;

public class BalanceSheetController {
    public void updateUserExpenseBalanceSheet(User expensePaidBy, List<Split> splits, double expenseAmount) {
        UserExpenseBalanceSheet paidByUserExpenseSheet = expensePaidBy.getUserExpenseBalanceSheet();
        paidByUserExpenseSheet.setTotalPayment(paidByUserExpenseSheet.getTotalPayment() + expenseAmount);

        for(Split split: splits) {
            User userOwe = split.getUser();
            double oweAmount = split.getAmountOwe();
            UserExpenseBalanceSheet oweUserExpenseSheet = userOwe.getUserExpenseBalanceSheet();

            if(expensePaidBy.getUserId().equals(userOwe.getUserId())) {
                paidByUserExpenseSheet.setTotalExpense(paidByUserExpenseSheet.getTotalExpense() + oweAmount);
            } else {

                // update the balance of paid user
                paidByUserExpenseSheet.setTotalGetBack(paidByUserExpenseSheet.getTotalGetBack() + oweAmount);

                if(!paidByUserExpenseSheet.getUserVsBalance().containsKey(userOwe.getUserId())) {
                    paidByUserExpenseSheet.getUserVsBalance().put(userOwe.getUserId(), new Balance());
                }
                Balance oweUserBalance = paidByUserExpenseSheet.getUserVsBalance().get(userOwe.getUserId());
                oweUserBalance.setAmountGetBack(oweUserBalance.getAmountGetBack() + oweAmount);

                // update the balance sheet of owe user
                oweUserExpenseSheet.setTotalOwe(oweUserExpenseSheet.getTotalOwe() + oweAmount);
                oweUserExpenseSheet.setTotalExpense(oweUserExpenseSheet.getTotalExpense() + oweAmount);

                if(!oweUserExpenseSheet.getUserVsBalance().containsKey(expensePaidBy.getUserId())) {
                    oweUserExpenseSheet.getUserVsBalance().put(expensePaidBy.getUserId(), new Balance());
                }
                Balance userPaidBalance = oweUserExpenseSheet.getUserVsBalance().get(expensePaidBy.getUserId());
                userPaidBalance.setAmountOwe(userPaidBalance.getAmountOwe() + oweAmount);
            }
        }
    }

    public void showBalanceSheetOfUser(User user) {
        System.out.println("-------------------------------------------------------");
        System.out.println("Balance sheet of user: " + user.getUserId());
        UserExpenseBalanceSheet userExpenseBalanceSheet = user.getUserExpenseBalanceSheet();

        System.out.println("Total Payment Made: " + userExpenseBalanceSheet.getTotalPayment());
        System.out.println("Total Your Expenses: " + userExpenseBalanceSheet.getTotalExpense());
        System.out.println("Total You Owe: " + userExpenseBalanceSheet.getTotalOwe());
        System.out.println("Total You Get Back: " + userExpenseBalanceSheet.getTotalGetBack());
        System.out.println("Balance against each user:");
        for(Map.Entry<String, Balance> balanceEntry: userExpenseBalanceSheet.getUserVsBalance().entrySet()) {
            String userId = balanceEntry.getKey();
            Balance balance = balanceEntry.getValue();
            System.out.println("User ID: " + userId + " Amount owe: " + balance.getAmountOwe() + " Amount Get Back: " + balance.getAmountGetBack());
        }
        System.out.println("-------------------------------------------------------");
    }
}
