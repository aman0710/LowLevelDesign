package VendingMachineLLD.states;

import VendingMachineLLD.context.Coin;
import VendingMachineLLD.context.Item;
import VendingMachineLLD.context.VendingMachine;

import java.util.List;

public class SelectionState extends VendingMachineState {

    public SelectionState() {
        System.out.println("Currently vending machine is in selection state!");
    }

    @Override
    public void chooseProduct(VendingMachine vendingMachine, int code) throws Exception {
        Item item = vendingMachine.getInventory().getItem(code);
        int paidByUser = 0;
        for(Coin coin: vendingMachine.getCoinList()) {
            paidByUser += coin.value;
        }

        if(paidByUser < item.getPrice()) {
            System.out.println("Insufficient amount, product you selected is of price: " + item.getPrice() + " and you paid: " + paidByUser);
            refundFullMoney(vendingMachine);
            throw new RuntimeException("Insufficient amount!");
        } else {
            if(paidByUser > item.getPrice()) {
                getChange(paidByUser - item.getPrice());
            }
            vendingMachine.setVendingMachineState(new DispenseState(vendingMachine, code));
        }
    }

    @Override
    public int getChange(int returnExtraMoney) throws Exception {
        System.out.println("Returned the coins in the dispense tray : " + returnExtraMoney);
        return returnExtraMoney;
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine vendingMachine) throws Exception {
        System.out.println("Returned the full amount in the coin dispense tray!");
        List<Coin> coins = vendingMachine.getCoinList();
        vendingMachine.setVendingMachineState(new IdleState(vendingMachine));
        return coins;
    }
}
