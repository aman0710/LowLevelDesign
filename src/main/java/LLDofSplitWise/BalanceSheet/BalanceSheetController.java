package LLDofSplitWise.BalanceSheet;

import LLDofSplitWise.Expense.Split.Split;
import LLDofSplitWise.User.User;

import java.util.List;
import java.util.Map;

public class BalanceSheetController {
    public void updateBalanceSheet(User paidByUser, List<Split> splitList, double totalAmount) {
        BalanceSheet paidByUserBalanceSheet = paidByUser.getBalanceSheet();
        paidByUserBalanceSheet.setTotalPayment(paidByUserBalanceSheet.getTotalPayment() + totalAmount);

        for(Split split: splitList) {
            User oweUser = split.getUser();
            double oweAmount = split.getAmountOwe();
            BalanceSheet oweUserBalanceSheet = oweUser.getBalanceSheet();

            if(paidByUser.getId().equalsIgnoreCase(oweUser.getId())){
                paidByUserBalanceSheet.setTotalExpense(paidByUserBalanceSheet.getTotalExpense() + oweAmount);
                continue;
            }

            paidByUserBalanceSheet.setTotalYouGetBack(paidByUserBalanceSheet.getTotalYouGetBack() + oweAmount);

            Balance oweUserBalance;
            if(paidByUserBalanceSheet.getUserVsBalance().containsKey(oweUser.getId())) {
                oweUserBalance = paidByUserBalanceSheet.getUserVsBalance().get(oweUser.getId());
            }
            else{
                oweUserBalance = new Balance();
                paidByUserBalanceSheet.getUserVsBalance().put(oweUser.getId(), oweUserBalance);
            }
            oweUserBalance.setAmountGetBack(oweUserBalance.getAmountGetBack() + oweAmount);

            oweUserBalanceSheet.setTotalExpense(oweUserBalanceSheet.getTotalExpense() + oweAmount);
            oweUserBalanceSheet.setTotalYouOwe(oweUserBalanceSheet.getTotalYouOwe() + oweAmount);
            Balance paidByUserBalance;
            if(oweUserBalanceSheet.getUserVsBalance().containsKey(paidByUser.getId())) {
                paidByUserBalance = oweUserBalanceSheet.getUserVsBalance().get(paidByUser.getId());
            }
            else{
                paidByUserBalance = new Balance();
                oweUserBalanceSheet.getUserVsBalance().put(paidByUser.getId(), paidByUserBalance);
            }
            paidByUserBalance.setAmountOwe(paidByUserBalance.getAmountOwe() + oweAmount);
        }
    }

    public void showUserBalanceSheet(User user) {
        System.out.println("------------------------------------------------------------------");
        System.out.println("Balance Sheet of User : " + user.getId());
        BalanceSheet balanceSheet = user.getBalanceSheet();

        System.out.println("Total Payment: " + balanceSheet.getTotalPayment());
        System.out.println("Total Expense: " + balanceSheet.getTotalExpense());
        System.out.println("Total You Owe: " + balanceSheet.getTotalYouOwe());
        System.out.println("Total You Get Back: " + balanceSheet.getTotalYouGetBack());

        for(Map.Entry<String, Balance> entry: balanceSheet.getUserVsBalance().entrySet()) {
            String userId = entry.getKey();
            Balance balance = entry.getValue();

            System.out.println("User ID: " + userId);
            System.out.println("-> You Owe: " + balance.getAmountOwe());
            System.out.println("-> You get back: " + balance.getAmountGetBack());
        }
        System.out.println("------------------------------------------------------------------");
    }
}
