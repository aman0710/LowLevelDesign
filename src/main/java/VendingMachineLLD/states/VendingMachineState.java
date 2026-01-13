package VendingMachineLLD.states;

import VendingMachineLLD.VendingMachineDemo;
import VendingMachineLLD.context.Coin;
import VendingMachineLLD.context.Item;
import VendingMachineLLD.context.VendingMachine;

import java.util.List;
import java.util.concurrent.ExecutionException;

public abstract class VendingMachineState {
    public void clickOnInsertCoinButton(VendingMachine vendingMachine) throws Exception {

    }

    public void clickOnStartProductSelectionButton(VendingMachine vendingMachine) throws Exception {

    }

    public void insertCoin(VendingMachine vendingMachine, Coin coin) throws Exception {

    }

    public void chooseProduct(VendingMachine vendingMachine, int code) throws Exception {

    }

    public int getChange(int returnChangeMoney) throws Exception {
        return 0;
    }

    public Item dispenseProduct(VendingMachine vendingMachine, int code) throws Exception {
        return null;
    }

    public List<Coin> refundFullMoney(VendingMachine vendingMachine) throws Exception {
        return null;
    }

    public void updateInventory(VendingMachine vendingMachine, Item item, int code) throws Exception {

    }
}
