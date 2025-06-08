package LLDofVendingMachine.VendingStates.impls;

import LLDofVendingMachine.Coin;
import LLDofVendingMachine.Item;
import LLDofVendingMachine.VendingMachine;
import LLDofVendingMachine.VendingStates.State;

import java.util.ArrayList;
import java.util.List;

public class IdleState implements State {

    public IdleState(VendingMachine vendingMachine) {
        vendingMachine.setCoins(new ArrayList<>());
        System.out.println("Vending Machine is currently in IdleState");
    }

    @Override
    public void pressInsertCoinButton(VendingMachine vendingMachine) {
        vendingMachine.setVendingMachineState(new HasMoneyState());
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin) throws Exception {
        throw new Exception("You cannot insert coins in IdleState");
    }

    @Override
    public void selectProductButton(VendingMachine vendingMachine) throws Exception {
        throw new Exception("You cannot select a product in IdleState");
    }

    @Override
    public void chooseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception {
        throw new Exception("You cannot choose a product in IdleState");
    }

    @Override
    public int getChange(VendingMachine vendingMachine, int amount) throws Exception {
        throw new Exception("You cannot ask for a change in IdleState");
    }

    @Override
    public Item dispenseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception {
        throw new Exception("You cannot dispense a product in IdleState");
    }

    @Override
    public List<Coin> getRefund(VendingMachine vendingMachine) throws Exception {
        throw new Exception("You cannot ask for a refund in IdleState");
    }
}
