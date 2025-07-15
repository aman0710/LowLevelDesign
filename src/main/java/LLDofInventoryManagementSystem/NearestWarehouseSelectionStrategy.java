package LLDofInventoryManagementSystem;

import java.util.List;

public class NearestWarehouseSelectionStrategy extends WarehouseSelectionStrategy{

    @Override
    public Warehouse getWarehouse(List<Warehouse> warehouseList) {
        return warehouseList.get(0);
    }
}
