package LLDofSplitWise;

import LLDofSplitWise.BalanceSheet.BalanceSheet;
import LLDofSplitWise.BalanceSheet.BalanceSheetController;
import LLDofSplitWise.Expense.Split.Split;
import LLDofSplitWise.Expense.SplitType;
import LLDofSplitWise.Group.Group;
import LLDofSplitWise.Group.GroupController;
import LLDofSplitWise.User.User;
import LLDofSplitWise.User.UserController;

import java.util.ArrayList;
import java.util.List;

public class Splitwise {

    UserController userController;
    GroupController groupController;
    BalanceSheetController balanceSheetController;

    public Splitwise() {
        this.balanceSheetController = new BalanceSheetController();
        this.userController = new UserController();
        this.groupController = new GroupController();
    }

    public void setupUserAndGroup() {
        addUsersToSplitwiseApp();
        User user1 = this.userController.getUser("U1001");
        this.groupController.createNewGroup("G1001", "Outing With Friends", user1);
    }

    public void addUsersToSplitwiseApp() {
        User user1 = new User("U1001", "User1");
        User user2 = new User("U2001", "User2");
        User user3 = new User("U3001", "User3");
        this.userController.addUser(user1);
        this.userController.addUser(user2);
        this.userController.addUser(user3);
    }

    public void demo() {
        setupUserAndGroup();

        Group group = this.groupController.getGroup("G1001");
        group.addMember(this.userController.getUser("U2001"));
        group.addMember(this.userController.getUser("U3001"));

        List<Split> splitList1 = new ArrayList<>();
        Split split1 = new Split(userController.getUser("U1001"), 300);
        Split split2 = new Split(userController.getUser("U2001"), 300);
        Split split3 = new Split(userController.getUser("U3001"), 300);
        splitList1.add(split1);
        splitList1.add(split2);
        splitList1.add(split3);
        group.createExpense("EXP1001", "Breakfast", 900, userController.getUser("U1001"), SplitType.EQUAL, splitList1);

        List<Split> splitList2 = new ArrayList<>();
        Split split4 = new Split(userController.getUser("U1001"), 400);
        Split split5 = new Split(userController.getUser("U2001"), 100);
        splitList2.add(split4);
        splitList2.add(split5);
        group.createExpense("EXP2001", "Lunch", 500, userController.getUser("U2001"), SplitType.UNEQUAL, splitList2);

        for(User user: this.userController.getAllUsers()) {
            balanceSheetController.showUserBalanceSheet(user);
        }
    }
}
