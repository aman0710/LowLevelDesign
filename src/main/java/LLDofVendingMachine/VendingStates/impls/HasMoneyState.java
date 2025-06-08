package LLDofVendingMachine.VendingStates.impls;

import LLDofVendingMachine.Coin;
import LLDofVendingMachine.Item;
import LLDofVendingMachine.VendingMachine;
import LLDofVendingMachine.VendingStates.State;

import java.util.List;

public class HasMoneyState implements State {

    public HasMoneyState() {
        System.out.println("Vending Machine is currently in HasMoneyState");
    }

    @Override
    public void pressInsertCoinButton(VendingMachine vendingMachine) throws Exception {
        throw new Exception("You cannot press insert coin button in HasMoneyState");
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin) throws Exception{
        vendingMachine.getCoins().add(coin);
        System.out.println("Coin added to the machine");
    }

    @Override
    public void selectProductButton(VendingMachine vendingMachine) {
        vendingMachine.setVendingMachineState(new SelectionState());
    }

    @Override
    public void chooseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception {
        throw new Exception("You cannot choose a product in HasMoneyState");
    }

    @Override
    public int getChange(VendingMachine vendingMachine, int amount) throws Exception {
        throw new Exception("You cannot ask for a change in HasMoneyState");
    }

    @Override
    public Item dispenseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception{
        throw new Exception("You cannot dispense product in HasMoneyState");
    }

    @Override
    public List<Coin> getRefund(VendingMachine vendingMachine) {
        System.out.println("Returned the full amount back to the user");
        vendingMachine.setVendingMachineState(new IdleState(vendingMachine));
        return vendingMachine.getCoins();
    }
}
