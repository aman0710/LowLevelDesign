package LLDofVendingMachine.VendingStates;

import LLDofVendingMachine.Coin;
import LLDofVendingMachine.Item;
import LLDofVendingMachine.VendingMachine;
import java.util.List;

public interface State {
    public void pressInsertCoinButton(VendingMachine vendingMachine) throws Exception;

    public void insertCoin(VendingMachine vendingMachine, Coin coin) throws Exception;

    public void selectProductButton(VendingMachine vendingMachine) throws Exception;

    public void chooseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception;

    public int getChange(VendingMachine vendingMachine, int amount) throws Exception;

    public Item dispenseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception;

    public List<Coin> getRefund(VendingMachine vendingMachine) throws Exception;
}
