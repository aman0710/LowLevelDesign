package LLDofVendingMachine.VendingStates.impls;

import LLDofVendingMachine.Coin;
import LLDofVendingMachine.Item;
import LLDofVendingMachine.VendingMachine;
import LLDofVendingMachine.VendingStates.State;

import java.util.List;

public class DispenseState implements State {

    public DispenseState(VendingMachine vendingMachine, int codeNumber) throws Exception {
        System.out.println("Vending Machine is currently in DispenseState");
        dispenseProduct(vendingMachine, codeNumber);
    }

    @Override
    public void pressInsertCoinButton(VendingMachine vendingMachine) throws Exception {
        throw new Exception("You cannot press insert coin  button in DispenseState");
    }


    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin) throws Exception {
        throw new Exception("You cannot insert coin in DispenseState");
    }

    @Override
    public void selectProductButton(VendingMachine vendingMachine) throws Exception {
        throw new Exception("You cannot press Select Product button in DispenseState");
    }

    @Override
    public void chooseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception {
        throw new Exception("You cannot choose product in DispenseState");
    }

    @Override
    public int getChange(VendingMachine vendingMachine, int amount) throws Exception {
        throw new Exception("You cannot return the change in DispenseState");
    }

    @Override
    public Item dispenseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception {
        System.out.println("Dispensing the product");
        Item item = vendingMachine.getInventory().getItem(codeNumber);
        System.out.println("The dispensed product is : " + item.getItemType() + " of price : " + item.getPrice());
        return item;
    }

    @Override
    public List<Coin> getRefund(VendingMachine vendingMachine) throws Exception {
        throw new Exception("You cannot ask for refund in DispenseState");
    }
}
