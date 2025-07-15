package LLDofInventoryManagementSystem;

import java.util.List;

public abstract class WarehouseSelectionStrategy {
    public abstract Warehouse getWarehouse(List<Warehouse> warehouseList);
}
