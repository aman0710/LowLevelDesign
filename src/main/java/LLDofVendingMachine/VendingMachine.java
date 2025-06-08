package LLDofVendingMachine;

import LLDofVendingMachine.VendingStates.State;
import LLDofVendingMachine.VendingStates.impls.IdleState;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    Inventory inventory;
    State vendingMachineState;
    List<Coin> coins;

    VendingMachine() {
        this.vendingMachineState = new IdleState(this);
        this.coins = new ArrayList<>();
        this.inventory = new Inventory(10);
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public State getVendingMachineState() {
        return vendingMachineState;
    }

    public void setVendingMachineState(State vendingMachineState) {
        this.vendingMachineState = vendingMachineState;
    }

    public List<Coin> getCoins() {
        return coins;
    }

    public void setCoins(List<Coin> coins) {
        this.coins = coins;
    }
}
