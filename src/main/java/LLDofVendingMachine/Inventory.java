package LLDofVendingMachine;

public class Inventory {
    ItemShelf[] inventory;

    Inventory(int itemCount) {
        this.inventory = new ItemShelf[itemCount];
        initialEmptyInventory();
    }
    public ItemShelf[] getInventory() {
        return inventory;
    }

    public void setInventory(ItemShelf[] inventory) {
        this.inventory = inventory;
    }

    public void initialEmptyInventory() {
        int startCode = 101;
        for(int i=0; i< inventory.length; i++) {
            inventory[i] = new ItemShelf();
            inventory[i].setCode(startCode);
            inventory[i].setSoldOut(false);
            startCode++;
        }
    }

    public void addItem(int codeNumber, Item item) throws Exception {
        for(ItemShelf itemShelf : inventory) {
            if(itemShelf.getCode() == codeNumber) {
                if(itemShelf.isSoldOut()) {
                    itemShelf.setItem(item);
                    itemShelf.setSoldOut(false);
                    return;
                }
                throw new Exception("Item is still present, you cannot add more!");
            }
            throw new Exception("Provided code number is invalid!!");
        }
    }

    public Item getItem(int codeNumber) throws Exception {
        for(ItemShelf itemShelf : inventory) {
            if(itemShelf.getCode() == codeNumber) {
                if(!itemShelf.isSoldOut()){
                    itemShelf.setSoldOut(true);
                    return itemShelf.item;
                }
                throw new Exception("Item selected has been sold out!!");
            }
        }
        throw new Exception("Invalid item selected!!");
    }
}
