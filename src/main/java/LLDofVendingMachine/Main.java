package LLDofVendingMachine;

import LLDofVendingMachine.VendingStates.State;

public class Main {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();
        try {
            System.out.println("Filling up empty vending machine");
            fillUpInventory(vendingMachine);
            displayVendingMachine(vendingMachine);

            System.out.println("Pressing insert coin button");
            State vendingState = vendingMachine.getVendingMachineState();
            vendingState.pressInsertCoinButton(vendingMachine);
            vendingState = vendingMachine.getVendingMachineState();

            Coin coin1 = Coin.NICKEL;
            Coin coin2 = Coin.QUARTER;
            vendingState.insertCoin(vendingMachine, coin1);
            vendingState.insertCoin(vendingMachine, coin2);
            vendingState.selectProductButton(vendingMachine);

            vendingState = vendingMachine.getVendingMachineState();
            System.out.println("Fetching Item with code: 102");
            vendingState.chooseProduct(vendingMachine, 102);

            displayVendingMachine(vendingMachine);
        }
        catch (Exception e) {
            displayVendingMachine(vendingMachine);
        }
    }

    public static void fillUpInventory(VendingMachine vendingMachine) {
        for(int i=0; i<10; i++) {
            ItemShelf[] itemShelf = vendingMachine.getInventory().getInventory();
            Item item = new Item();
            if(i < 3) {
                item.setItemType(ItemType.COKE);
                item.setPrice(12);
            }
            else if(i < 5) {
                item.setItemType(ItemType.PEPSI);
                item.setPrice(9);
            } else if (i <7) {
                item.setItemType(ItemType.JUICE);
                item.setPrice(13);
            }
            else {
                item.setItemType(ItemType.SODA);
                item.setPrice(7);
            }
            itemShelf[i].setItem(item);
            itemShelf[i].setSoldOut(false);
        }
    }

    public static void displayVendingMachine(VendingMachine vendingMachine) {
        for(ItemShelf itemShelf : vendingMachine.getInventory().getInventory()) {
            System.out.println("Item type : " + itemShelf.getItem().getItemType() +
                    " Item code : " + itemShelf.getCode() +
                    " Item price : " + itemShelf.getItem().getPrice() +
                    " is Item Available : " + !itemShelf.isSoldOut());
        }
    }
}
