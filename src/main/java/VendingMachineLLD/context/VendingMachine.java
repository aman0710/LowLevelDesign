package VendingMachineLLD.context;

import VendingMachineLLD.states.IdleState;
import VendingMachineLLD.states.VendingMachineState;
import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    VendingMachineState vendingMachineState;
    Inventory inventory;
    List<Coin> coinList;

    public VendingMachine() {
        this.vendingMachineState = new IdleState();
        this.inventory = new Inventory(10);
        this.coinList = new ArrayList<>();
    }

    public void setVendingMachineState(VendingMachineState state) {
        this.vendingMachineState = state;
    }

    public VendingMachineState getVendingMachineState() {
        return vendingMachineState;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public List<Coin> getCoinList() {
        return coinList;
    }

    public void setCoinList(List<Coin> coinList) {
        this.coinList = coinList;
    }
}
