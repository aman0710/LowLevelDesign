package VendingMachineLLD.states;

import VendingMachineLLD.context.Item;
import VendingMachineLLD.context.VendingMachine;

import java.util.ArrayList;

public class IdleState extends VendingMachineState{
    public IdleState() {
        System.out.println("Currently vending machine is in idle state!");
    }

    public IdleState(VendingMachine vendingMachine) {
        System.out.println("Currently vending machine is in idle state!");
        vendingMachine.setCoinList(new ArrayList<>());
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine vendingMachine) throws Exception {
        vendingMachine.setVendingMachineState(new HasMoneyState());
    }

    @Override
    public void updateInventory(VendingMachine vendingMachine, Item item, int code) throws Exception {
        vendingMachine.getInventory().addItem(item, code);
    }

}
