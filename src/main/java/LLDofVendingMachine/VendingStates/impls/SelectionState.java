package LLDofVendingMachine.VendingStates.impls;

import LLDofVendingMachine.*;
import LLDofVendingMachine.VendingStates.State;

import java.util.List;

public class SelectionState implements State {

    public SelectionState() {
        System.out.println("Vending Machine is currently in SelectionState");
    }

    @Override
    public void pressInsertCoinButton(VendingMachine vendingMachine) throws Exception {
        throw new Exception("You cannot press insert coin button in SelectionState");
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin) throws Exception {
        throw new Exception("You cannot insert coins in SelectionState");
    }

    @Override
    public void selectProductButton(VendingMachine vendingMachine) {
        return;
    }

    @Override
    public void chooseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception {
        Item item = vendingMachine.getInventory().getItem(codeNumber);

        int paidByUser = 0;
        for(Coin coin: vendingMachine.getCoins()) {
            paidByUser += coin.value;
        }

        if(paidByUser < item.getPrice()) {
            System.out.println("Insufficient amount added to the vending machine");
            getRefund(vendingMachine);
            throw new Exception("Insufficent Balance");
        }

        if(paidByUser > item.getPrice()) {
            int extraAmount = paidByUser - item.getPrice();
            getChange(vendingMachine, extraAmount);
        }
        vendingMachine.setVendingMachineState(new DispenseState(vendingMachine, codeNumber));
    }

    @Override
    public int getChange(VendingMachine vendingMachine, int amount) throws Exception{
        System.out.println("Returned the extra money in the tray : " + amount);
        return amount;
    }

    @Override
    public Item dispenseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception {
        throw new Exception("You cannot dispense product in SelectionState");
    }

    @Override
    public List<Coin> getRefund(VendingMachine vendingMachine) {
        System.out.println("Returning the full amount to the user");
        vendingMachine.setVendingMachineState(new IdleState(vendingMachine));
        return vendingMachine.getCoins();
    }
}
