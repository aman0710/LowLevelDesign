package VendingMachineLLD.states;

import VendingMachineLLD.context.Coin;
import VendingMachineLLD.context.VendingMachine;

import java.util.List;

public class HasMoneyState extends VendingMachineState {

    public HasMoneyState() {
        System.out.println("Currently the vending machine is in has money state!");
    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine vendingMachine) throws Exception {
        vendingMachine.setVendingMachineState(new SelectionState());
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin) throws Exception {
        System.out.println("Vending machine accepted the coin!");
        vendingMachine.getCoinList().add(coin);
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine vendingMachine) throws Exception {
        System.out.println("Returned the full amount back in the coin dispense tray");
        List<Coin> coins = vendingMachine.getCoinList();
        vendingMachine.setVendingMachineState(new IdleState(vendingMachine));
        return coins;
    }
}
