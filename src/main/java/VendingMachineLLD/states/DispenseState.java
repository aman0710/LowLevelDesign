package VendingMachineLLD.states;

import VendingMachineLLD.context.Item;
import VendingMachineLLD.context.VendingMachine;

public class DispenseState extends VendingMachineState {

    public DispenseState(VendingMachine vendingMachine, int code) throws Exception {
        System.out.println("Currently vending machine is in dispense state!");
        dispenseProduct(vendingMachine, code);
    }

    @Override
    public Item dispenseProduct(VendingMachine vendingMachine, int code) throws Exception {
        System.out.println("Product has been dispensed!");
        Item item = vendingMachine.getInventory().getItem(code);
        vendingMachine.getInventory().updateSoldOutItem(code);
        vendingMachine.setVendingMachineState(new IdleState(vendingMachine));
        return item;
    }
}
