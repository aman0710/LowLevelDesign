package VendingMachineLLD.context;

import LLDofCricBuzz.Inning.RunType;

public class Inventory {
    ItemShelf[] inventory;

    public Inventory(int itemCount) {
        this.inventory = new ItemShelf[itemCount];
        intialEmptyInventory();
    }

    public ItemShelf[] getInventory() {
        return inventory;
    }

    public void setInventory(ItemShelf[] inventory) {
        this.inventory = inventory;
    }

    public void intialEmptyInventory() {
        int startCode = 101;
        for(int i=0; i<inventory.length; i++) {
            ItemShelf space = new ItemShelf();
            space.setCode(startCode);
            space.setSoldOut(true);
            inventory[i] = space;
            startCode++;
        }
    }

    public void addItem(Item item, int code) throws Exception {
        for(ItemShelf itemShelf: inventory) {
            if(itemShelf.getCode() == code) {
                if(itemShelf.isSoldOut()) {
                    itemShelf.setItem(item);
                    itemShelf.setSoldOut(false);
                } else {
                    throw new RuntimeException("The shelf is not empty, you cannot add more items!");
                }
            }
        }
    }

    public Item getItem(int code) throws Exception {
        for(ItemShelf itemShelf: inventory) {
            if(itemShelf.getCode() == code) {
                if(itemShelf.isSoldOut()) {
                    throw new RuntimeException("Item is already sold out!");
                } else {
                    return itemShelf.getItem();
                }
            }
        }
        throw new RuntimeException("Invalid code!");
    }

    public void updateSoldOutItem(int code) throws Exception {
        for(ItemShelf itemShelf: inventory) {
            if(itemShelf.getCode() == code) {
                itemShelf.setSoldOut(true);
            }
        }
    }
}
